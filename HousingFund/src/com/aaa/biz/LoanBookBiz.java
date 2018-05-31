package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Loanapplication;
import com.aaa.entity.Loanbook;

public interface LoanBookBiz{
   //个人账户OR共同借款人贷款记录查询
	public List<Loanbook> findAll(String loanaccountId);
}
