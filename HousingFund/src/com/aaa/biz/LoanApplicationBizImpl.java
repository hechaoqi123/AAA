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
	LoanApplicationDao LoanDao;//申请书
	@Autowired
	LoanaccountinfoDao Loanaccountinfodao;//贷款信息
	@Autowired
	IndAccountinfoDao indDao;//个人账户
	@Autowired
	BorrDao borrDao;
	@Autowired
	MpfacentrestatDao mpfDao;//统计中心
	@Autowired
	RepaymentPlanDetailsDao repayDao;
//发起贷款申请
	public void save(Loanapplication loanEntity,Loanaccountinfo loanaccountinfoEntity){
		   this.ready(loanEntity);//添加关联关系
		  if(loanEntity!=null){//保存借款申请
				   LoanDao.save(loanEntity);
		  }
		  if(loanaccountinfoEntity!=null){//添加贷款信息
		   loanaccountinfoEntity.setRemarks(String.valueOf(loanEntity.getLoanApplicationId()));
				   Loanaccountinfodao.save(loanaccountinfoEntity);
		   }
	}
//申请书查询
	@Transactional(readOnly=true)
	public List<Loanapplication> criteriaAssess(String state) {
		Criterion[] criterions={Restrictions.eq("status", state)};
		  Order order=Order.asc("loanApplicationId");
		return LoanDao.findByCriteria(criterions, order);
	}
//贷款申请书单体查询
	@Transactional(readOnly=true)
	public Loanapplication getOne(int id) {
		return LoanDao.getOne(id);
	}
//计算最大额度
	@Transactional(readOnly=true)
	public Integer getLimit(Integer LoanapplicationId) {
		System.out.println("-----开始计算最大额度-----");
		Loanapplication loanEntity = LoanDao.getOne(LoanapplicationId);//获取申请书
		Coborrower cobor=loanEntity.getCoborrower();//共同借款人
	    Indaccountinfo ind=indDao.getOne(Integer.valueOf(loanEntity.getIndAccount()));//个人账户
		   Integer result=null;
		   int money=0;//购房额度
		      if(loanEntity.getRemarks().equals("首套房")){
		    	   System.out.println("类型:首套房");
		          money=(int) (loanEntity.getPurchasecontract().getPurchasedhinfo().getSellingPrice()*0.7*10000);
		      }else{
		    	  System.out.println("类型:二套房");
		          money=(int) (loanEntity.getPurchasecontract().getPurchasedhinfo().getSellingPrice()*0.5*10000);
		      }
        if(cobor==null){
        	 System.out.println("贷款类型:个人贷款");
        	if(ind.getPresentSumRem()==null){//当额度为空时
        		ind.setPresentSumRem(0F);
        	}
		    result=(int) (ind.getPresentSumRem()*20/10000);//可贷金额
		      if(result>50){
		    	  result=50;
		      }
		      if(result>(money/10000)){
		    	  result=(money/10000);
		      }
		   }else{//共同申请
			   System.out.println("贷款类型:共同贷款");
			 float result_1=ind.getPresentSumRem();
			 ind=indDao.getOne(Integer.valueOf(cobor.getCoborrowerAccount()));//共同借款人账户
			 float result_2=ind.getPresentSumRem();
			 result=(int) ((result_1+result_2)*20/10000);//可贷金额
		      if(result>70){
		    	  result=70;
		      }
			 if(result>(money/10000)){
		    	  result=(money/10000);
		      }
		   }
        System.out.println("最大额度为:"+result);
        return result;
	}
 //申请通过OR驳回
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
//未签订合同检索
	public Object[] find(Loanapplication loan) {
		try {
			Criterion[] criterions={Restrictions.and(Restrictions.eq("status","未签订借款合同"), Restrictions.eq("borrowerIdnumber",loan.getBorrowerIdnumber()))};
			List<Loanapplication> list=LoanDao.findByCriteria(criterions, Order.desc("loanApplicationId"));
			if(list.size()>0){
				loan=(Loanapplication) list.get(0);//借款申请
				return new Object[]{loan,borrDao.findByCriteria(new Criterion[]{Restrictions.eq("repaymentAccount", String.valueOf(loan.getIndAccount()))}, null).get(0).getBorrowMoneyAgreementId()};
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//合同签订   
	public void update(int id) {
	 //修改申请书状态
	Loanapplication loan= LoanDao.getOne(id);
	 loan.setStatus("借款合同已签订");
	//申请书基本信息
     String name=loan.getNameOfBorrower();
	   Float money=loan.getBorrowingBalance();
	   Integer number=loan.getLentYearsNumber();
	   Float rate=loan.getAnnualRate();
     //通过申请书获取合同
	 Criterion[] criterions={Restrictions.eq("borrowerIdno",loan.getBorrowerIdnumber()),Restrictions.eq("borrowMoneyNumber", String.valueOf(money)),Restrictions.eq("borrowerName", name)};
     Borrowmoneyagreement bor=(Borrowmoneyagreement) borrDao.findByCriteria(criterions, Order.desc("borrowMoneyAgreementId")).get(0);
     //借款清册(贷款账户，贷款人，贷款金额，贷款时间，贷款状态)
     Loanbook book=new Loanbook();
     book.setLoanAccount(loan.getIndAccount());
     book.setLender(name);
     book.setValueOfLoan(money);
     book.setLoanDate(new Date());
     book.setLoanStatus("未还清");
     bor.setLoanbook(book);
     //还款计划   
     for(int i=1;i<=number;i++){
         Repaymentplandetails Repay=new Repaymentplandetails();
         Float capital=money*10000/number;  //本金=本金/期数
         Float accrual=money*10000*(rate/100*number/12);//总利息=本金*利率/期数
         Repay.setModeOfRepaymentSelect(loan.getUnitAddress());//还款方式
         Repay.setCurrentReturnedCorpus(capital);//本金
         Repay.setCurrentReturnedInterest(accrual/number);//利息
	   	  Repay.setCurrentPeriod(i);
	   	  Repay.setRepaymentStatus("未还");
	   	  Repay.setAmountOfRepayRecei(capital+(accrual/number));//应还金额
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(new Date());//设置起始时间
		   cal.add(Calendar.MONTH, i);
	   	  Repay.setRepaymentDeadline(cal.getTime());
	   	  bor.getRepaymentplandetailses().add(Repay);
   	  
     }
     //添加统计
 	 Mpfacentrestat entity=new Mpfacentrestat();
 	 entity.setLoanAmountStat(loan.getBorrowingBalance());
 	 entity.setStatisticalTime(new Date());
 	 mpfDao.save(entity);
  }	
//获取申请书及个人还款计划   
	public Object[] refund(Loanapplication loan) {
		try{
		Criterion[] criterions={Restrictions.and(Restrictions.or(Restrictions.eq("status","未签订借款合同"), Restrictions.eq("status","借款合同已签订")), Restrictions.eq("borrowerIdnumber",loan.getBorrowerIdnumber()))};
		List<Loanapplication> list=LoanDao.findByCriteria(criterions, Order.desc("loanApplicationId"));
		  if(list.size()>0){
			  loan=(Loanapplication) list.get(0);//借款申请
			  //还款计划
			 List list2=repayDao.findByCriteria(new Criterion[]{Restrictions.eq("borrowmoneyagreement.borrowMoneyAgreementId", borrDao.findByCriteria(new Criterion[]{Restrictions.eq("repaymentAccount", String.valueOf(loan.getIndAccount()))}, null).get(0).getBorrowMoneyAgreementId())}, Order.asc("currentPeriod"));
		          return new Object[]{loan,list2};
		  }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//添加关联关系
    private void ready(Loanapplication loanEntity){
	   switch (loanEntity.getGuaranteemode().getGuaranteeModeId()) {
		case 1:
			loanEntity.getGuaranteemode().setSecurityModeDes("拟购房抵押");
			break;
       case 2:
       	loanEntity.getGuaranteemode().setSecurityModeDes("其他房产抵押");
			break;
       case 3:
       	loanEntity.getGuaranteemode().setSecurityModeDes("担保人担保");
	        break;
		}
	   switch (loanEntity.getUseoffunds().getUseOfFundsId()) {
		case 1:
			loanEntity.getUseoffunds().setUseDescription("商品房");
			break;
      case 2:
      	    loanEntity.getUseoffunds().setUseDescription("经济房");
			break;
      case 3:
      	    loanEntity.getUseoffunds().setUseDescription("二手房");
	        break;
		}
   }
    //条件查询
	@Override
	public Loanapplication getOne(Loanapplication model) {
		      model.setStatus(null);
		     List<Loanapplication> list=LoanDao.findByExample(model);
		     //通过ID倒序排列
		     System.out.println("申请书"+list.size());
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
