package com.aaa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aaa.entity.Repaymentplandetails;
@Repository
public class RepaymentPlanDetailsDaoImpl extends BaseDaoImpl<Repaymentplandetails> implements RepaymentPlanDetailsDao {
   //删除无效的还款计划（没有与借贷合同关联的借款计划）
	@Override
	public void del() {
		List<Repaymentplandetails> list = getAll();
		for (Repaymentplandetails repay: list) {
		    if(repay.getBorrowmoneyagreement()==null){
		    	delect(repay);
		    }	
		}
		
	}

}
