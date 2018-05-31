package com.aaa.actions;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aaa.biz.LoanFinalBiz;
import com.aaa.entity.Loanfinal;
@Controller
@ParentPackage("struts-default")
@Scope("properties")
public class LoanFinalAction extends BaseAction<Loanfinal> {

 //添加最终评审,生成借款合同
	@Autowired
	LoanFinalBiz biz;
	@Action(value="loan_final",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
	public String loan_final(){
		  biz.save(getModel().getLoanFinalId());
		return SUCCESS;
	}
}
