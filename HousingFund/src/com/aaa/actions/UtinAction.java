package com.aaa.actions;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;



import com.aaa.biz.UtinaccountinfoUtilBiz;
import com.aaa.entity.Flupay;

import com.aaa.entity.Indinfo;

import com.aaa.entity.TeachaerPageEntity;
import com.aaa.entity.Utinaccountinfo;
import com.alibaba.fastjson.JSON;




@ParentPackage("struts-default")
@Controller
public class UtinAction extends BaseAction<Indinfo> {

	@Resource
	private UtinaccountinfoUtilBiz biz;
	
	private Utinaccountinfo utin;
	private Integer UtinId;
	private String utinname;
	private TeachaerPageEntity what;
	private Flupay fu;
	
	private int uuid;
	//��ɰ����ѯ
	@Action("UtinMoney")
	public String SeleUtinMoney() throws IOException{
	
		try {
			  Date date = new Date();
			   SimpleDateFormat ft =new SimpleDateFormat("yyyy-MM-dd");
			//�ܽ��
			Double m=biz.UtinSumMoneySele(UtinId);
			//��ѯ��λԱ����Ϣ
			List i=biz.IndAccountInfoSele(UtinId);
			//��ѯ�ϴλ��
			List dlist=biz.sele_date(UtinId);
			
			List u=biz.UtinInfoSele(UtinId);
			System.out.println(999);
			if(u.size()<1){
				getOut().print(false);
			}else{ 
			  Map map=new HashMap();
	          map.put("SumMoney", m);
	          map.put("times",ft.format(date));
	          map.put("indAccount", i);
	          if(dlist!=null){
	        	  map.put("dlist", dlist);  
	        	  
	          }else{
	        	  
	        	  map.put("dlist", null);  
	          }
	          
		      u.add(map);	
		      String json=JSON.toJSONString(u);
		      System.out.println(json);
			  getOut().print(json);
				
			}
		} catch (Exception e) {
			System.out.println("Action--UtinMoney�����쳣���쳣��Ϣ���£�");
			e.printStackTrace();
		}
		return null;
	}
	
	//��ѯȫ����λ
	@Action("sele_utin")
	public String sele_utin(){
		
		if(what==null){
			what=new TeachaerPageEntity();
		}
		
		TeachaerPageEntity  list=biz.sele_utin(what);
		String json=JSON.toJSONString(list);
		System.out.println(json);
		getOut().print(json);
		return null;
	}
	//idģ����ѯ
	@Action("sele_mohuid")
	public String sele_mohuid(){
		if(what==null){
			what=new TeachaerPageEntity();
		}
		TeachaerPageEntity  list=biz.sele_mohuid(what, UtinId);
		String json=JSON.toJSONString(list);
		System.out.println(json);
		getOut().print(json);
		return null;
	}
	//nameģ��
	@Action("sele_mohuname")
	public String sele_mohuname(){
		if(what==null){
			what=new TeachaerPageEntity();
		}
		TeachaerPageEntity  list=biz.sele_mohuname(what, utinname);
		String json=JSON.toJSONString(list);
		System.out.println(json);
		getOut().print(json);
		return null;
	}
	@Action("idsele")
	public String seleid(){
		List list=biz.UtinInfoSele(UtinId);
		 if(list.size()>0){
			 String json=JSON.toJSONString(list);
			  System.out.println(json);
			 getOut().print(json);		 
		 }else{
			 
			 getOut().print(false);		 
		 }
		return null;
	}
	@Action("upinse")
	public String upinse(){
		
		System.out.println(fu.getUtinaccountinfo().getUtinAccountId());
		int a=biz.upinse(fu);
		 getOut().print(a);	
		return null;
	}

	@Action("sele_utinid")
	public String sele_utinid(){
		
		List list=biz.sele_utinid(uuid);
		String  json=JSON.toJSONString(list);
		System.out.println(json);
		getOut().print(json);
		return null;
	}
	
	
	
	
	
	public Integer getUtinId() {
		return UtinId;
	}

	public void setUtinId(Integer utinId) {
		UtinId = utinId;
	}

	public TeachaerPageEntity getWhat() {
		return what;
	}

	public void setWhat(TeachaerPageEntity what) {
		this.what = what;
	}

	public String getUtinname() {
		return utinname;
	}

	public void setUtinname(String utinname) {
		this.utinname = utinname;
	}

	public Flupay getFu() {
		return fu;
	}

	public void setFu(Flupay fu) {
		this.fu = fu;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}




	
}
