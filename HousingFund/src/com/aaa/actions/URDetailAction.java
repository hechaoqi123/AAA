package com.aaa.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.aaa.biz.URDetailBiz;
import com.aaa.entity.Indinfo;
import com.aaa.entity.TeachaerPageEntity;
import com.alibaba.fastjson.JSON;

@ParentPackage("struts-default")
@Controller
public class URDetailAction extends BaseAction<Indinfo>{

     @Resource	
	private URDetailBiz biz;
     
     private int utlnid;
     
     private TeachaerPageEntity page;
     private String idnum;
     private int mxseid;
     @Action("sele_urd")
     public String sele_URD() throws IOException{
    	 
    	 if(page==null){
    		 page=new TeachaerPageEntity();
    		 
    	 }
    	 System.out.println(utlnid);
    	 System.out.println(111);
    	 
    	 TeachaerPageEntity list= biz.sele_Detail(utlnid, page);
    	if(list.getList().size()<1){
    		System.out.println(333);
    	String json=JSON.toJSONString(list);
    	System.out.println(json);
    	getOut().print(false);
    	}else{
    		System.out.println(22);
    	String json=JSON.toJSONString(list);
    	System.out.println(json);
    	  getOut().print(json);
    	}
    	 return null;
     }
     
     @Action("seleUR")
     public String seleUR() throws IOException{
    	 
    	 if(page==null){
    		 page=new TeachaerPageEntity();
    		 
    	 }
    	 TeachaerPageEntity list= biz.sele_Detail(utlnid, page);
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
     
     //查询全部
     @Action("sele_allex")
     public String sele_allex(){
    	 if(page==null){
    		 page=new TeachaerPageEntity();
    		 
    	 }
    	 System.out.println("page:"+page.getCurrPage());
    	 TeachaerPageEntity t=biz.sele_allex(page);
    	 String json=JSON.toJSONString(t);
    	 getOut().print(json); 
    	 
    	 return null;
     }
     
     //模糊查询
     @Action("idsele_allex")
     public String sele_indnum(){
    	 System.out.println("idnum"+idnum);
    	List list= biz.sele_idnum(idnum);
    	if(list.size()>0){
    		
    		 String json=JSON.toJSONString(list);
    		getOut().print(json);
    		
    	}else{
    		getOut().print(false);
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

	public TeachaerPageEntity getPage() {
		return page;
	}

	public void setPage(TeachaerPageEntity page) {
		this.page = page;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
     
}
