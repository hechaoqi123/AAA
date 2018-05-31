package com.aaa.biz;

import com.aaa.entity.Collateralinfo;
import com.aaa.entity.Guarantorinfo;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;

public interface LoanaccountinfoBiz {
  //获取贷款信息
	public Loanaccountinfo findByExample(Loanaccountinfo entity);
  //（抵押）价值评定
	public void save(Loanaccountinfo accountEntity,Loanapplication loanentity);
  //获取抵押物信息 	
	public Collateralinfo getColl(int loanId);
  //获取担保人信息	
	public Guarantorinfo getGuar(int loanId);
}
