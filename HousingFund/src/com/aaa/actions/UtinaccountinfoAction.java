package com.aaa.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.UtinaccountinfoBiz;
import com.aaa.entity.Utinaccountinfo;
import com.alibaba.fastjson.JSON;
@ParentPackage("struts-default")
@Controller
public class UtinaccountinfoAction extends BaseAction<Utinaccountinfo> {
	@Autowired
	private UtinaccountinfoBiz utinaccountinfoBiz; 

	private Integer accountId;
	private Utinaccountinfo utinaccountinfo;
	//查询全部
	@Action("getUtinaccountinfo")
	public String getAllUtinaccountinfo(){
		List list_utinaccountinfo = utinaccountinfoBiz.getUtinaccountinfo();
		String json_utinaccountinfo = JSON.toJSONString(list_utinaccountinfo);
		getOut().print(json_utinaccountinfo);
		return null;
	}
	//查询一个
	@Action("get_one_Utinaccountinfo")
	public String get_one_Utinaccountinfo(){
		List list_one_Utinaccountinfo = utinaccountinfoBiz.get_one_Utinaccountinfo(accountId);
		String json_one_utinaccountinfo = JSON.toJSONString(list_one_Utinaccountinfo);
		getOut().print(json_one_utinaccountinfo);
		return null;
	}
	//修改跳转
	@Action(value = "getUtinSup", results = {@Result(name = "getUtinSup",location = "/BackJsp/LDL/updateUnit.jsp")})
	public String getUtinSup(){
		Utinaccountinfo oneUtin = utinaccountinfoBiz.getOneUtin(utinaccountinfo);
		String idnum = oneUtin.getUnitinfo().getOperatorIdnumber();
		String emils =idnum.substring(5, 10)+"dds@qq.com";
		String youB =idnum.substring(0, 6);
		String zuzhiJG ="AA"+idnum.substring(5, 9);
		getRequestMap().put("oneUtin", oneUtin);
		getRequestMap().put("emils", emils);
		getRequestMap().put("youB", youB);
		getRequestMap().put("zuzhiJG", zuzhiJG);
		return "getUtinSup";
	}
	//修改实现
	@Action(value = "updateUtin", results = {@Result(name = "updateUtin",location = "/BackJsp/LDL/success.jsp")})
	public String updateUtin(){
		System.out.println(utinaccountinfo.getUtinAccountId());
		System.out.println(utinaccountinfo.getUnitinfo().getUtinName());
		utinaccountinfoBiz.updateUtin(utinaccountinfo);
		return "updateUtin";
	}
	//审批
	@Action("update_utinAccount")
	public String update_utinAccount(){
		utinaccountinfoBiz.update_utinAccount(utinaccountinfo.getUtinAccountId(), utinaccountinfo.getAccountStatus());
		getOut().print("true");
		return null;
	}
	//公司模糊查询
	@Action("getFuzzy")
	public String getFuzzy(){
		List list_utinaccountifo = utinaccountinfoBiz.getFuzzy(utinaccountinfo);
		String json_one_utinaccountinfo = JSON.toJSONString(list_utinaccountifo);
		getOut().print(json_one_utinaccountinfo);
		return null;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Utinaccountinfo getUtinaccountinfo() {
		return utinaccountinfo;
	}
	public void setUtinaccountinfo(Utinaccountinfo utinaccountinfo) {
		this.utinaccountinfo = utinaccountinfo;
	}
	

	
	
}
