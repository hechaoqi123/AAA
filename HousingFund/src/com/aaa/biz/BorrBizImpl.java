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

/**借款合同**/
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
	MpfacentrestatDao mpfDao;//统计中心
  //按揭偿还贷款(取出一条还款记录)
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
			   if(repaymentplandetails.getCurrentPeriod()<current&&(repaymentplandetails.getRepaymentStatus().equals("逾期未还")||repaymentplandetails.getRepaymentStatus().equals("未还"))){
					current=repaymentplandetails.getCurrentPeriod();
					repay=repaymentplandetails;
				}
			}
		return repay;
	}
	//通过身份证号取出借款合同
	public Borrowmoneyagreement getBorr(Borrowmoneyagreement borr){
		 if(borr==null){
			 return null;
		  }
		return borrDao.findByExample(borr).get(0);
	}
	//按揭还款
	public boolean return_loan(Integer id) {
		try {
			Repaymentplandetails repay = repayDao.getOne(id);
			if(repay.getRepaymentStatus().equals("未还")||repay.getRepaymentStatus().equals("逾期未还")){
				if(repay.getOverduerepayment()!=null){//当此还款逾期时:添加逾期罚息
					repay.setOverduePrincipalAndInte(repay.getOverduerepayment().getReturnedPriInt());
				}
				repay.setRepaymentsReceived(Float.valueOf(Math.round(repay.getAmountOfRepayRecei()+repay.getOverduePrincipalAndInte())));
				repay.setRepaymentStatus("已还");
				repay.setRepaymentDate(new Date());
				 //添加统计
				 Mpfacentrestat entity=new Mpfacentrestat();
				 entity.setRecoveryLoanStat(repay.getRepaymentsReceived());
			 	 entity.setStatisticalTime(new Date());
			 	 mpfDao.save(entity);
				return true;
			}else{
				throw new RuntimeException("为找到未还的借款！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BorrBizImpl中提交还款出现异常");
			return false;
		}
	}
	//贷款结清
		public void sure_end(String repaymentAccount) {
			Criterion[] criterions={Restrictions.eq("loanAccount",repaymentAccount),Restrictions.eq("loanStatus", "未还清")};
			List list=bookDao.findByCriteria(criterions, null);
			if(list!=null){
			   com.aaa.entity.Loanbook book=(com.aaa.entity.Loanbook) list.get(0);
			      book.setLoanStatus("已还清");
			}else{
	            throw new RuntimeException("没有找到此借款。");			
			}
		}
  //查询历史还款记录	
	@Override
	public List getPaid(Integer id) {
		Borrowmoneyagreement borr=borrDao.getOne(id);//借贷合同
		Set<Repaymentplandetails> set=borr.getRepaymentplandetailses();
		List<Repaymentplandetails> list=new ArrayList();
		for (Repaymentplandetails repay : set) {
			if(repay.getRepaymentStatus().equals("已还")||repay.getRepaymentStatus().equals("已提前还款")||repay.getRepaymentStatus().equals("逾期未还")){
				list.add(repay);
			}
		}
	    //冒泡排序
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
		  Collections.reverse(list);//反转
		return list;
	}
	//查询未还清的借贷合同
	@Override
	public boolean find(Loanapplication loan) {
		  Borrowmoneyagreement borr=new Borrowmoneyagreement();
		  borr.setBorrowerIdno(loan.getBorrowerIdnumber());
		 List<Borrowmoneyagreement> list = borrDao.findByExample(borr);
		    for (Borrowmoneyagreement borrowmoneyagreement : list) {
				if(borrowmoneyagreement.getLoanbook().getLoanStatus().equals("未还清")){
					return true;
				}
			 }
		return false;
	}
}
