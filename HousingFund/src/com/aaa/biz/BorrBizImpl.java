package com.aaa.biz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.BorrDao;
import com.aaa.dao.LoanBookDao;
import com.aaa.dao.MpfacentrestatDao;
import com.aaa.dao.RepaymentPlanDetailsDao;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Loanbook;
import com.aaa.entity.Mpfacentrestat;
import com.aaa.entity.Repaymentplandetails;

/**����ͬ**/
@Service
@Transactional
public class BorrBizImpl implements BorrBiz {
	@Autowired
	BorrDao borrDao;
	@Autowired
	RepaymentPlanDetailsDao repayDao;
	@Autowired
	LoanBookDao bookDao;
	@Autowired
	MpfacentrestatDao mpfDao;//ͳ������
  //���ҳ�������(ȡ��һ�������¼)
	@Transactional(readOnly=true)
	public Repaymentplandetails getRepay(Borrowmoneyagreement borr){
		  if(borr==null){
			 return null;
		  }
		  Borrowmoneyagreement bor=borrDao.findByExample(borr).get(0);
		 Set<Repaymentplandetails> set=bor.getRepaymentplandetailses();
		   int current=Integer.MAX_VALUE;
		   Repaymentplandetails repay=null;
		   for (Repaymentplandetails repaymentplandetails : set) {
			   if(repaymentplandetails.getCurrentPeriod()<current&&(repaymentplandetails.getRepaymentStatus().equals("����δ��")||repaymentplandetails.getRepaymentStatus().equals("δ��"))){
					current=repaymentplandetails.getCurrentPeriod();
					repay=repaymentplandetails;
				}
			}
		return repay;
	}
	//ͨ�����֤��ȡ������ͬ
	public Borrowmoneyagreement getBorr(Borrowmoneyagreement borr){
		 if(borr==null){
			 return null;
		  }
		return borrDao.findByExample(borr).get(0);
	}
	//���һ���
	public boolean return_loan(Integer id) {
		try {
			Repaymentplandetails repay = repayDao.getOne(id);
			if(repay.getRepaymentStatus().equals("δ��")||repay.getRepaymentStatus().equals("����δ��")){
				if(repay.getOverduerepayment()!=null){//���˻�������ʱ:������ڷ�Ϣ
					repay.setOverduePrincipalAndInte(repay.getOverduerepayment().getDefaultInterest());
				}
				repay.setRepaymentsReceived(Float.valueOf(Math.round(repay.getAmountOfRepayRecei()+repay.getOverduePrincipalAndInte())));
				repay.setRepaymentStatus("�ѻ�");
				repay.setRepaymentDate(new Date());
				 //���ͳ��
				 Mpfacentrestat entity=new Mpfacentrestat();
				 entity.setRecoveryLoanStat(repay.getRepaymentsReceived());
			 	 entity.setStatisticalTime(new Date());
			 	 mpfDao.save(entity);
				return true;
			}else{
				throw new RuntimeException("Ϊ�ҵ�δ���Ľ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BorrBizImpl���ύ��������쳣");
			return false;
		}
	}
	//�������
		public void sure_end(String repaymentAccount) {
			Criterion[] criterions={Restrictions.eq("loanAccount",repaymentAccount),Restrictions.eq("loanStatus", "δ����")};
			List list=bookDao.findByCriteria(criterions, null);
			if(list!=null){
			   com.aaa.entity.Loanbook book=(com.aaa.entity.Loanbook) list.get(0);
			      book.setLoanStatus("�ѻ���");
			}else{
	            throw new RuntimeException("û���ҵ��˽�");			
			}
		}
  //��ѯ��ʷ�����¼	
	@Override
	public List getPaid(Integer id) {
		Borrowmoneyagreement borr=borrDao.getOne(id);//�����ͬ
		Set<Repaymentplandetails> set=borr.getRepaymentplandetailses();
		List<Repaymentplandetails> list=new ArrayList();
		for (Repaymentplandetails repay : set) {
			if(repay.getRepaymentStatus().equals("�ѻ�")||repay.getRepaymentStatus().equals("����ǰ����")||repay.getRepaymentStatus().equals("����δ��")){
				list.add(repay);
			}
		}
	    //ð������
		  for(int j=0;j<list.size();j++){
			  for(int i=0;i<list.size()-1-j;i++){
				  int id1=list.get(i).getCurrentPeriod();
				  int id2=list.get(i+1).getCurrentPeriod();
				 if(id1>id2){
					 Repaymentplandetails entity1=list.get(i);
					 Repaymentplandetails entity2=list.get(i+1);
					 list.set(i, entity2);
					 list.set(i+1,entity1);
			     }
			}
		  }
		  Collections.reverse(list);//��ת
		return list;
	}
	//��ѯδ����Ľ����ͬ
	@Override
	public boolean find(Loanapplication loan) {
		  Borrowmoneyagreement borr=new Borrowmoneyagreement();
		  borr.setBorrowerIdno(loan.getBorrowerIdnumber());
		 List<Borrowmoneyagreement> list = borrDao.findByExample(borr);
		    for (Borrowmoneyagreement borrowmoneyagreement : list) {
				if(borrowmoneyagreement.getLoanbook().getLoanStatus().equals("δ����")){
					return true;
				}
			 }
		return false;
	}
}
