package com.aaa.dao;

import com.aaa.entity.Loanapplication;



public interface LoanDao {

	public abstract Loanapplication getFive(String BorrowerIdnumber);
public abstract Loanapplication getSix(String BorrowerIdnumber);

}