package com.aaa.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;

import com.aaa.biz.SupBiz;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.Supdetailed;
import com.aaa.entity.UtilSup;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinsupapply;
import com.aaa.entity.idnumutil;
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
	
    private String idnum;

    private File files;
    
    
    @Action("add_sup")
    public String add_sup() throws Exception{
    	System.out.println(files);
    	List<Supdetailed> list=biz.add_suo(files);
    	String json=JSON.toJSONString(list);
    	System.out.println(json);
    	getOut().print(json);
    	return null;
    }
    
	//添加补缴
	@Action("inse_sup")
	public String inse_sup() throws IOException{
	/*	System.out.println(11);
		System.out.println(u.getUtinNmae());
		System.out.println(utinAccountID);
		
		System.out.println(jsons);*/
		
		System.out.println(u.getUtinNmae());
		System.out.println(u.getUtinsupmoney());
		System.out.println(u.getSupSumple());
		System.out.println(u.getChequeId());
		System.out.println(u.getSupCause());
		List sz=new ArrayList();
		
		Utinaccountinfo ut=biz.sele_u(utinAccountID);
		if(ut==null){
			
			getOut().print("www");
		}else{
			
			List<UtilSup> list=JSON.parseArray(jsons,UtilSup.class);
			
			//查询是否有此账号
			/*for (UtilSup sup : list) {
				
				Indaccountinfo i= biz.sele_i(sup.getIndAccountID());
				
				if(i!=null){
					sz.add(1);				
				}				  
		          }*/
			
			
			//有就执行
		// if(sz.size()==list.size()){
			 
			 int ids=biz.inse_usa(u,utinAccountID);
				
				System.out.println("list:"+list);
				for (UtilSup sup : list) {
					
					System.out.println(sup.getIndAccountID());
					System.out.println(sup.getIndDepositRatio());
					System.out.println(ids);
					biz.inser_sd(sup, ids);
				}
				getOut().print(true);
		/*}else{
			 
			 getOut().print("error");
		 }*/
		
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
	
	//根据身份证号查询
	@Action("sele_supidnum")
	public String sele_idnum(){
		System.out.println(indid);
	 	List<idnumutil> list=JSON.parseArray(jsons,idnumutil.class);
	 	
	 	List sumlist=new ArrayList();
	 	int a=0;
	 	for (idnumutil i : list) {
	 		System.out.println(i.getIdnum());
	 		Map map=(Map) biz.sele_supidnum(indid, i.getIdnum()).get(0);
	 		if(map==null){
	 			Map m=new HashMap();
	 			m.put("indAccountId", "null");
	 			sumlist.add(a,m);
	 		}else{
	 		sumlist.add(a,map);
	 		}
	 		a++;
		}
		
		
			String json=JSON.toJSONString(sumlist);
			System.out.println(json);
			getOut().print(json);
		
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

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
	}
	
	
	
	
	
	
	
	
	
	
	
}
