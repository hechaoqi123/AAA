package com.aaa.biz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.RepaymentPlanDetailsDao;
import com.aaa.entity.Overduerepayment;
import com.aaa.entity.Repaymentplandetails;

@Transactional
@Service
public class RepaymentPlanDetailsBizImpl implements RepaymentPlanDetailsBiz {
  @Autowired
  RepaymentPlanDetailsDao dao;
  //计算逾期(逾期罚息=年利率)
	@Override
	public void task() {
		try {
			dao.del();//清除无效还款
			List<Repaymentplandetails> list = dao.getAll();
			 for (Repaymentplandetails repay: list) {
				if(repay.getRepaymentStatus().equals("未还")||repay.getRepaymentStatus().equals("逾期未还")){
				   if(new Date().compareTo(repay.getRepaymentDeadline())>0){//逾期
					    Date date1=new Date();//当前日期
						Date date2=repay.getRepaymentDeadline();//逾期日期
						int number=(int) ((date1.getTime()-date2.getTime())/1000/60/60/24);
						//本息
						Float bx=repay.getCurrentReturnedCorpus()+repay.getCurrentReturnedInterest();
						//罚息利率
						Float lv=repay.getBorrowmoneyagreement().getBorrowerAnnualRate()*1.5F/100/360;
						//罚息金额
						 Float money=bx*lv*number;
						 repay.setOverduePrincipalAndInte(money);
						 repay.setRepaymentStatus("逾期未还");
						 if(repay.getOverduerepayment()==null){
							 Overduerepayment entity = new Overduerepayment();
							 entity.setDefaultInterest(money);
							 repay.setOverduerepayment(entity);
						 }else{
							 repay.getOverduerepayment().setDefaultInterest(money);
						 }
				   };
				}
				}
		} catch (Exception e) {
			System.out.println("计算逾期出现异常！信息如下");
			e.printStackTrace();
		}
	}
	
}
