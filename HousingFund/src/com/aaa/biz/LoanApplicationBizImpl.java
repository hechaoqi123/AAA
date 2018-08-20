package com.aaa.biz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.BorrDao;
import com.aaa.dao.IndAccountinfoDao;
import com.aaa.dao.LoanApplicationDao;
import com.aaa.dao.LoanaccountinfoDao;
import com.aaa.dao.MpfacentrestatDao;
import com.aaa.dao.RepaymentPlanDetailsDao;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Coborrower;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Loanbook;
import com.aaa.entity.Mpfacentrestat;
import com.aaa.entity.Repaymentplandetails;
import com.alibaba.fastjson.JSON;

@Service
@Transactional
public class LoanApplicationBizImpl  implements LoanApplicationBiz {
	@Autowired
	LoanApplicationDao LoanDao;//������
	@Autowired
	LoanaccountinfoDao Loanaccountinfodao;//������Ϣ
	@Autowired
	IndAccountinfoDao indDao;//�����˻�
	@Autowired
	BorrDao borrDao;
	@Autowired
	MpfacentrestatDao mpfDao;//ͳ������
	@Autowired
	RepaymentPlanDetailsDao repayDao;
//�����������
	public void save(Loanapplication loanEntity,Loanaccountinfo loanaccountinfoEntity){
		   this.ready(loanEntity);//��ӹ�����ϵ
		  if(loanEntity!=null){//����������
				   LoanDao.save(loanEntity);
		  }
		  if(loanaccountinfoEntity!=null){//��Ӵ�����Ϣ
		   loanaccountinfoEntity.setRemarks(String.valueOf(loanEntity.getLoanApplicationId()));
				   Loanaccountinfodao.save(loanaccountinfoEntity);
		   }
	}
//�������ѯ
	@Transactional(readOnly=true)
	public List<Loanapplication> criteriaAssess(String state) {
		Criterion[] criterions={Restrictions.eq("status", state)};
		  Order order=Order.asc("loanApplicationId");
		return LoanDao.findByCriteria(criterions, order);
	}
//���������鵥���ѯ
	@Transactional(readOnly=true)
	public Loanapplication getOne(int id) {
		return LoanDao.getOne(id);
	}
//���������
	@Transactional(readOnly=true)
	public Integer getLimit(Integer LoanapplicationId) {
		System.out.println("-----��ʼ���������-----");
		Loanapplication loanEntity = LoanDao.getOne(LoanapplicationId);//��ȡ������
		Coborrower cobor=loanEntity.getCoborrower();//��ͬ�����
	    Indaccountinfo ind=indDao.getOne(Integer.valueOf(loanEntity.getIndAccount()));//�����˻�
		   Integer result=null;
		   int money=0;//�������
		      if(loanEntity.getRemarks().equals("���׷�")){
		    	   System.out.println("����:���׷�");
		          money=(int) (loanEntity.getPurchasecontract().getPurchasedhinfo().getSellingPrice()*0.7*10000);
		      }else{
		    	  System.out.println("����:���׷�");
		          money=(int) (loanEntity.getPurchasecontract().getPurchasedhinfo().getSellingPrice()*0.5*10000);
		      }
        if(cobor==null){
        	 System.out.println("��������:���˴���");
        	if(ind.getPresentSumRem()==null){//�����Ϊ��ʱ
        		ind.setPresentSumRem(0F);
        	}
		    result=(int) (ind.getPresentSumRem()*20/10000);//�ɴ����
		      if(result>50){
		    	  result=50;
		      }
		      if(result>(money/10000)){
		    	  result=(money/10000);
		      }
		   }else{//��ͬ����
			   System.out.println("��������:��ͬ����");
			 float result_1=ind.getPresentSumRem();
			 ind=indDao.getOne(Integer.valueOf(cobor.getCoborrowerAccount()));//��ͬ������˻�
			 float result_2=ind.getPresentSumRem();
			 result=(int) ((result_1+result_2)*20/10000);//�ɴ����
		      if(result>70){
		    	  result=70;
		      }
			 if(result>(money/10000)){
		    	  result=(money/10000);
		      }
		   }
        System.out.println("�����Ϊ:"+result);
        return result;
	}
 //����ͨ��OR����
	public void successORreject(Loanapplication loanEntity,String cause) {
		String status=loanEntity.getStatus();
		loanEntity=LoanDao.getOne(loanEntity.getLoanApplicationId());
		loanEntity.setStatus(status);
		LoanDao.update(loanEntity);
		if(cause!=null){
			Loanaccountinfo loan=Loanaccountinfodao.getLoanaccountinf(loanEntity);
			loan.setGuaranteeMode(cause);
			Loanaccountinfodao.update(loan);
		}
		
	}
//δǩ����ͬ����
	public Object[] find(Loanapplication loan) {
		try {
			Criterion[] criterions={Restrictions.and(Restrictions.eq("status","δǩ������ͬ"), Restrictions.eq("borrowerIdnumber",loan.getBorrowerIdnumber()))};
			List<Loanapplication> list=LoanDao.findByCriteria(criterions, Order.desc("loanApplicationId"));
			if(list.size()>0){
				loan=(Loanapplication) list.get(0);//�������
				return new Object[]{loan,borrDao.findByCriteria(new Criterion[]{Restrictions.eq("repaymentAccount", String.valueOf(loan.getIndAccount()))}, null).get(0).getBorrowMoneyAgreementId()};
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//��ͬǩ��   
	public void update(int id) {
	 //�޸�������״̬
	Loanapplication loan= LoanDao.getOne(id);
	 loan.setStatus("����ͬ��ǩ��");
	//�����������Ϣ
     String name=loan.getNameOfBorrower();
	   Float money=loan.getBorrowingBalance();
	   Integer number=loan.getLentYearsNumber();
	   Float rate=loan.getAnnualRate();
     //ͨ���������ȡ��ͬ
	 Criterion[] criterions={Restrictions.eq("borrowerIdno",loan.getBorrowerIdnumber()),Restrictions.eq("borrowMoneyNumber", String.valueOf(money)),Restrictions.eq("borrowerName", name)};
     Borrowmoneyagreement bor=(Borrowmoneyagreement) borrDao.findByCriteria(criterions, Order.desc("borrowMoneyAgreementId")).get(0);
     //������(�����˻��������ˣ����������ʱ�䣬����״̬)
     Loanbook book=new Loanbook();
     book.setLoanAccount(loan.getIndAccount());
     book.setLender(name);
     book.setValueOfLoan(money);
     book.setLoanDate(new Date());
     book.setLoanStatus("δ����");
     bor.setLoanbook(book);
     //����ƻ�   
     for(int i=1;i<=number;i++){
         Repaymentplandetails Repay=new Repaymentplandetails();
         Float capital=money*10000/number;  //����=����/����
         Float accrual=money*10000*(rate/100*number/12);//����Ϣ=����*����/����
         Repay.setModeOfRepaymentSelect(loan.getUnitAddress());//���ʽ
         Repay.setCurrentReturnedCorpus(capital);//����
         Repay.setCurrentReturnedInterest(accrual/number);//��Ϣ
	   	  Repay.setCurrentPeriod(i);
	   	  Repay.setRepaymentStatus("δ��");
	   	  Repay.setAmountOfRepayRecei(capital+(accrual/number));//Ӧ�����
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new Date());//������ʼʱ��
		   cal.add(Calendar.MONTH, i);
	   	  Repay.setRepaymentDeadline(cal.getTime());
	   	  bor.getRepaymentplandetailses().add(Repay);
   	  
     }
     //���ͳ��
 	 Mpfacentrestat entity=new Mpfacentrestat();
 	 entity.setLoanAmountStat(loan.getBorrowingBalance());
 	 entity.setStatisticalTime(new Date());
 	 mpfDao.save(entity);
  }	
//��ȡ�����鼰���˻���ƻ�   
	public Object[] refund(Loanapplication loan) {
		try{
		Criterion[] criterions={Restrictions.and(Restrictions.or(Restrictions.eq("status","δǩ������ͬ"), Restrictions.eq("status","����ͬ��ǩ��")), Restrictions.eq("borrowerIdnumber",loan.getBorrowerIdnumber()))};
		List<Loanapplication> list=LoanDao.findByCriteria(criterions, Order.desc("loanApplicationId"));
		  if(list.size()>0){
			  loan=(Loanapplication) list.get(0);//�������
			  //����ƻ�
			 List list2=repayDao.findByCriteria(new Criterion[]{Restrictions.eq("borrowmoneyagreement.borrowMoneyAgreementId", borrDao.findByCriteria(new Criterion[]{Restrictions.eq("repaymentAccount", String.valueOf(loan.getIndAccount()))}, null).get(0).getBorrowMoneyAgreementId())}, Order.asc("currentPeriod"));
		          return new Object[]{loan,list2};
		  }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//��ӹ�����ϵ
    private void ready(Loanapplication loanEntity){
	   switch (loanEntity.getGuaranteemode().getGuaranteeModeId()) {
		case 1:
			loanEntity.getGuaranteemode().setSecurityModeDes("�⹺����Ѻ");
			break;
       case 2:
       	loanEntity.getGuaranteemode().setSecurityModeDes("����������Ѻ");
			break;
       case 3:
       	loanEntity.getGuaranteemode().setSecurityModeDes("�����˵���");
	        break;
		}
	   switch (loanEntity.getUseoffunds().getUseOfFundsId()) {
		case 1:
			loanEntity.getUseoffunds().setUseDescription("��Ʒ��");
			break;
      case 2:
      	    loanEntity.getUseoffunds().setUseDescription("���÷�");
			break;
      case 3:
      	    loanEntity.getUseoffunds().setUseDescription("���ַ�");
	        break;
		}
   }
    //������ѯ
	@Override
	public Loanapplication getOne(Loanapplication model) {
		      model.setStatus(null);
		     List<Loanapplication> list=LoanDao.findByExample(model);
		     //ͨ��ID��������
		     System.out.println("������"+list.size());
		       if(list.size()>1){
		    	   for(int j=0;j<list.size();j++){
				        for(int i=0;i<list.size()-1-j;i++){
				        	if(list.get(i).getLoanApplicationId()<list.get(i+1).getLoanApplicationId()){
				        		 Loanapplication min=list.get(i);
				        		 Loanapplication max=list.get(i+1);
				        		list.set(i, max);
				        		list.set(i+1, min);
				        	}
				         }
				        }
		       }
		return list.get(0);
	}
    
}
