package com.aaa.dao;

import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;

public interface LoanaccountinfoDao extends BaseDao<Loanaccountinfo> {
   //通过申请书查看贷款信息
	public Loanaccountinfo getLoanaccountinf(Loanapplication loan);
}
