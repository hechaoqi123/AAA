package com.aaa.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
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
	//��ѯȫ��
	@Action("getUtinaccountinfo")
	public String getAllUtinaccountinfo(){
		List list_utinaccountinfo = utinaccountinfoBiz.getUtinaccountinfo();
		String json_utinaccountinfo = JSON.toJSONString(list_utinaccountinfo);
		getOut().print(json_utinaccountinfo);
		return null;
	}
	//��ѯһ��
	@Action("get_one_Utinaccountinfo")
	public String get_one_Utinaccountinfo(){
		List list_one_Utinaccountinfo = utinaccountinfoBiz.get_one_Utinaccountinfo(accountId);
		String json_one_utinaccountinfo = JSON.toJSONString(list_one_Utinaccountinfo);
		getOut().print(json_one_utinaccountinfo);
		return null;
	}
	//����
	@Action("update_utinAccount")
	public String update_utinAccount(){
		utinaccountinfoBiz.update_utinAccount(utinaccountinfo.getUtinAccountId(), utinaccountinfo.getAccountStatus());
		getOut().print("true");
		return null;
	}
	//��˾ģ����ѯ
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
