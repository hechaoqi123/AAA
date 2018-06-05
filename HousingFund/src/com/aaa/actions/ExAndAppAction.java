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

	//��������
	private Materialproof m;
	private int reasonNo;
	private int appid;
	private int indid;
	private Float money;
	private String apptime;
	
	private TeachaerPageEntity page;
	/*//������Ϣ
	private Purinfo pur;
	//������Ϣ
	private Retireti ret;
	//����֤��
	private Proofofdeath pro;*/
	
	@Action(value="save_exapp",results={@Result(name="su",location="/ssw/success.jsp")})
	public String save_ExAndApp(){
		
		System.out.println(m.getExtractdetails().getExtractionandapproval().getWorkersName());
		biz.Save_ExAndApp(m,reasonNo);
		return "su";
	}

	//(��ȡ)δ������ѯ
	@Action("sele_ex")
	public String sele_ex() throws IOException{
		if(page==null){
			page=new TeachaerPageEntity();
			
		}
		TeachaerPageEntity t=biz.sele_ex(page);
		System.out.println(t);
		String json=JSON.toJSONString(t);
		
		System.out.println(json);
		
			getOut().print(json);
		
		return null;
	}
	
	@Action(value="sele_contract",results={@Result(name="tiao",location="/ssw/newtable.jsp")})
	public String sele_contract() throws IOException{
		System.out.println(appid);
	    List list1=biz.sele_EAA(appid);
		List list2=biz.sele_contract(appid);
		
		//list1.get(6).toString();
		list1.addAll(list2);
		System.out.println(list2);
		System.out.println(list1);
		System.out.println(list1.size());
		getRequestMap().put("list", list1);
		/*System.out.println(list);
		String json=JSON.toJSONString(list);
		System.out.println(json);*/
		//getOut().print(json);
		return "tiao";
	}
	
	@Action("not_con")
	public String updata_con_not(){
		
		biz.not_con(appid);
		getOut().print(true);
		return null;
	}
	@Action(value="yes_con")
	public String update_con_yes(){
		System.out.println("1��"+appid);
		System.out.println("2��"+indid);
		System.out.println("3��"+money);
		System.out.println("4��"+apptime);
		biz.yes_con(appid, indid, money, apptime);
		getOut().print(true);
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

	public TeachaerPageEntity getPage() {
		return page;
	}

	public void setPage(TeachaerPageEntity page) {
		this.page = page;
	}

	
	
}
