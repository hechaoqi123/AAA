package com.aaa.biz;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.LoanApplicationDao;
import com.aaa.dao.LoanFinalDao;
import com.aaa.dao.LoanaccountinfoDao;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Loanbook;
import com.aaa.entity.Loanfinal;
import com.aaa.entity.Repaymentplandetails;
/**最终评审**/
@Service
@Transactional
public class LoanFinalBizImpl implements LoanFinalBiz {
  @Autowired
  LoanFinalDao dao;
  @Autowired
  LoanApplicationDao loanDao;
  @Autowired
  LoanaccountinfoDao accountDao;
  //添加最终评审,生成借款合同
	public void save(Integer loanApplicationId) {
		 //借款申请表
		Loanapplication loan=loanDao.getOne(loanApplicationId);//借款申请书
		    loan.setStatus("未签订借款合同");
		 //信息评估表
		Criterion[] criterions={Restrictions.eq("remarks", String.valueOf(loan.getLoanApplicationId()))};
	   Loanaccountinfo account=accountDao.findByCriteria(criterions, null).get(0);//贷款信息
		//借款合同
	   Borrowmoneyagreement bor=new Borrowmoneyagreement();
	   String name=loan.getNameOfBorrower();
	   Float money=loan.getBorrowingBalance();
	   Integer number=loan.getLentYearsNumber();
	   Float rate=loan.getAnnualRate();
	      bor.setBorrowerName(name);
	      bor.setBorrowMoneyNumber(String.valueOf(money));
	      bor.setBorrowerFixedYear(number);
	      bor.setBorrowerAnnualRate(rate);
	      bor.setRepaymentMode(loan.getUnitAddress());
	      if(account.getGuarantorinfo()!=null){
	    	  bor.setGuarantorInfo(String.valueOf(account.getGuarantorinfo().getGuarantorInfoId()));
	      }
	      if(account.getCollateralinfo()!=null){
	    	  bor.setCollateralInfo(String.valueOf(account.getCollateralinfo().getCollateralInfoId()));
	      }
	      if(loan.getCoborrower()!=null){
	    	  bor.setCoborrower(String.valueOf(loan.getCoborrower().getCoborrowerId()));
	      }
	      bor.setRepaymentAccount(loan.getIndAccount());
	      bor.setBorrowerIdno(loan.getBorrowerIdnumber());
	      bor.setBorrowerPhone(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
	
	 //最终审核
	          Loanfinal loanFinal=new Loanfinal();
	          loanFinal.setLoanapplication(loan);
	          loanFinal.setBorrowmoneyagreement(bor);
	          loanFinal.setInfEvaluationTable(account.getLoanAccountInfoId());
	          dao.save(loanFinal);
	}
}
