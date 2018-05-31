package com.aaa.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.PageEntity;
@Repository
public class LoanaccountinfoDaoImpl extends BaseDaoImpl<Loanaccountinfo> implements
		LoanaccountinfoDao {
	public Loanaccountinfo getLoanaccountinf(Loanapplication loan) {
		    Loanaccountinfo t=new Loanaccountinfo();
		      t.setRemarks(String.valueOf(loan.getLoanApplicationId()));
		return findByExample(t).get(0);
	}

	
}
