package com.aaa.biz;

import com.aaa.entity.Loanfinal;

public interface LoanFinalBiz{
   //添加最终评审,生成借款合同
	public void save(Integer loanApplicationId);
}