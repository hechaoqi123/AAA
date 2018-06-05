package com.aaa.actions;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.LoanBiz;


import com.aaa.entity.Loanapplication;
import com.alibaba.fastjson.JSON;




@Controller//spring×¢½â
@ParentPackage("struts-default")
public class LoanAction extends BaseAction<Loanapplication>{
	@Autowired
    private LoanBiz loanBiz;
	//JOSN×Ö·û´®
	private String jsonArr;
	@Action(value="query4")
	public String query4(){
		Loanapplication lon=loanBiz.getFive(getModel().getBorrowerIdnumber());
		lon.setPurchasecontract(null);
		lon.setCoborrower(null);
		lon.setUseoffunds(null);
		lon.setGuaranteemode(null);
		lon.setLoanfinals(null);
		     String jsonStr=JSON.toJSONString(lon);
		    getOut().print(jsonStr);
		return null;
		
	}
	
	@Action(value="query5")
	public String query5(){
		Loanapplication lon=loanBiz.getSix(getModel().getBorrowerIdnumber());
		lon.setPurchasecontract(null);
		lon.setCoborrower(null);
		lon.setUseoffunds(null);
		lon.setGuaranteemode(null);
		lon.setLoanfinals(null);
		     String jsonStr=JSON.toJSONString(lon);
		    getOut().print(jsonStr);
		return null;
		
	}
}
