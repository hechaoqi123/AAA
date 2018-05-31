package com.aaa.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.aaa.biz.SupBiz;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.Supdetailed;
import com.aaa.entity.UtilSup;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinsupapply;
import com.alibaba.fastjson.JSON;

@ParentPackage("struts-default")
@Controller
public class SupAction extends BaseAction<Indinfo>{

	@Resource
	private SupBiz biz;
	
	private Utinsupapply u;
	
	private String jsons;
	
	private int utinAccountID;
	
	private int indid;
	
	@Action("inse_sup")
	public String inse_sup() throws IOException{
	/*	System.out.println(11);
		System.out.println(u.getUtinNmae());
		System.out.println(utinAccountID);
		
		System.out.println(jsons);*/
		System.out.println(11);
		List sz=new ArrayList();
		
		Utinaccountinfo ut=biz.sele_u(utinAccountID);
		if(ut==null){
			
			getOut().print("www");
		}else{
			
			List<UtilSup> list=JSON.parseArray(jsons,UtilSup.class);
			
			//查询是否有此账号
			for (UtilSup sup : list) {
				Indaccountinfo i= biz.sele_i(sup.getIndAccountID());
				System.out.println(i);
				if(i!=null){
					sz.add(1);				
				}				  
		          }
			
			
			//有就执行
		 if(sz.size()==list.size()){
			 System.out.println(3333);
			 int ids=biz.inse_usa(u,utinAccountID);
				
				System.out.println("list:"+list);
				for (UtilSup sup : list) {
					biz.inser_sd(sup, ids);
				}
				getOut().print(true);
		 }else{
			 
			 getOut().print("error");
		 }
		
		}
		
		return null;
	}

	@Action("bjse")
	public String bjse() throws IOException{
		
		List list=biz.bjse(indid);
		if(list.size()<1){
			getOut().print(false);
			
		}else{
		String json=JSON.toJSONString(list);
		getOut().print(json);
		}
		return null;
	}
	
	
	public String getJsons() {
		return jsons;
	}

	public void setJsons(String jsons) {
		this.jsons = jsons;
	}

	public int getUtinAccountID() {
		return utinAccountID;
	}

	public void setUtinAccountID(int utinAccountID) {
		this.utinAccountID = utinAccountID;
	}

	public Utinsupapply getU() {
		return u;
	}

	public void setU(Utinsupapply u) {
		this.u = u;
	}

	public int getIndid() {
		return indid;
	}

	public void setIndid(int indid) {
		this.indid = indid;
	}
	
	
	
	
	
	
	
	
	
	
	
}
