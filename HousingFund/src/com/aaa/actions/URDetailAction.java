package com.aaa.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.aaa.biz.URDetailBiz;
import com.aaa.entity.Indinfo;
import com.alibaba.fastjson.JSON;

@ParentPackage("struts-default")
@Controller
public class URDetailAction extends BaseAction<Indinfo>{

     @Resource	
	private URDetailBiz biz;
     
     private int utlnid;
     
     private int mxseid;
     @Action("sele_urd")
     public String sele_URD() throws IOException{
    	 
    	List list= biz.sele_Detail(utlnid);
    	if(list.size()<1){
    	String json=JSON.toJSONString(list);
    	System.out.println(json);
    	getOut().print(false);
    	}else{
    	String json=JSON.toJSONString(list);
    	System.out.println(json);
    	  getOut().print(json);
    	}
    	 return null;
     }
     
     @Action("seleUR")
     public String seleUR() throws IOException{
    	 List list=biz.sele_Detail(utlnid);
    	 String json=JSON.toJSONString(list);
     	 System.out.println(json);
     	  getOut().print(json);
    	 return null;
     }
     
     
     @Action("sele_rd")
     public String sele_rd() throws IOException{
    	 
    	 List list=biz.sele_rd(mxseid);
    	 if(list.size()<1){
    		 String json= JSON.toJSONString(list);
    		 System.out.println(json);
    		 getOut().print(false);
    	 }else{
    		 String json= JSON.toJSONString(list);
    		 System.out.println(json);
    		 getOut().print(json);	 
    		 
    	 }
    	
    	
    	 return null;
     }
     
     
     @Action("sele_exre")
     public String sele_exre() throws IOException{
    	 
    	 List list=biz.se_exre(utlnid);
    	 
    	 if(list.size()<1){
    		 
    		 getOut().print(false); 
    	 }else{
    		 
    		 String json=JSON.toJSONString(list);
    		 getOut().print(json); 
    	 }
    	 return null;
     }
	public int getUtlnid() {
		return utlnid;
	}
	public void setUtlnid(int utlnid) {
		this.utlnid = utlnid;
	}

	public int getMxseid() {
		return mxseid;
	}

	public void setMxseid(int mxseid) {
		this.mxseid = mxseid;
	}
     
}
