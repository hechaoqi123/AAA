package com.aaa.actions;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.stereotype.Controller;

import com.aaa.biz.ExAndAppBiz;
import com.aaa.entity.*;
import com.alibaba.fastjson.JSON;

@ParentPackage("struts-default")
@Controller
public class ExAndAppAction extends BaseAction<Indinfo>{

	@Resource
	private ExAndAppBiz biz;

	//材料类型
	private Materialproof m;
	private int reasonNo;
	private int appid;
	private int indid;
	private Float money;
	private String apptime;
	
	/*//购房信息
	private Purinfo pur;
	//离休信息
	private Retireti ret;
	//死亡证明
	private Proofofdeath pro;*/
	
	@Action(value="save_exapp",results={@Result(name="su",location="/ssw/success.jsp")})
	public String save_ExAndApp(){
		
		biz.Save_ExAndApp(m,reasonNo);
		return "su";
	}

	@Action("sele_ex")
	public String sele_ex() throws IOException{
		
		List list=biz.sele_ex();
		System.out.println(list);
		String json=JSON.toJSONString(list);
		
		System.out.println(json);
		
			getOut().print(json);
		
		return null;
	}
	
	@Action("sele_contract")
	public String sele_contract() throws IOException{
		List list=biz.sele_contract(appid);
		System.out.println(list);
		String json=JSON.toJSONString(list);
		System.out.println(json);
		getOut().print(json);
		return null;
	}
	
	@Action("not_con")
	public String updata_con_not(){
		
		biz.not_con(appid);
		return null;
	}
	@Action(value="yes_con")
	public String update_con_yes(){
		System.out.println("1："+appid);
		System.out.println("2："+indid);
		System.out.println("3："+money);
		System.out.println("4："+apptime);
		biz.yes_con(appid, indid, money, apptime);
		
		return null;
	}
	
	
	

	public Materialproof getM() {
		return m;
	}

	public void setM(Materialproof m) {
		this.m = m;
	}



	public int getReasonNo() {
		return reasonNo;
	}



	public void setReasonNo(int reasonNo) {
		this.reasonNo = reasonNo;
	}

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public int getIndid() {
		return indid;
	}

	public void setIndid(int indid) {
		this.indid = indid;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getApptime() {
		return apptime;
	}

	public void setApptime(String apptime) {
		this.apptime = apptime;
	}

	
	
}
