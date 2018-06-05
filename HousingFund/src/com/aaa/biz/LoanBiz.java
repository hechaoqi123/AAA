package com.aaa.biz;

import com.aaa.entity.Loanapplication;



public interface LoanBiz {

	public abstract Loanapplication getFive(String BorrowerIdnumber);
	public abstract Loanapplication getSix(String BorrowerIdnumber);

}