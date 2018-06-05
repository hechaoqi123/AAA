package com.aaa.actions;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.aaa.biz.RepayBiz;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Loanapplication;
import com.alibaba.fastjson.JSON;

@Controller//spring×¢½â
@ParentPackage("struts-default")
public class RepayAction  extends BaseAction<Borrowmoneyagreement>{
@Resource
private RepayBiz repayBiz;


@Action(value="query6")
public void query6(){
	
	List list=repayBiz.getSevens(getModel().getBorrowerIdno());
	try {
		JSON.toJSONString(list);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 String jsonStr=JSON.toJSONString(list);
	 this.getOut().print(jsonStr);
}

public RepayBiz getRepayBiz() {
	return repayBiz;
}
public void setRepayBiz(RepayBiz repayBiz) {
	this.repayBiz = repayBiz;
}


}
