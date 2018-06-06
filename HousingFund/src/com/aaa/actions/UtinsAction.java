package com.aaa.actions;



import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.UtinBiz;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.PageEntitys;
import com.aaa.entity.Utinaccountinfo;
import com.alibaba.fastjson.JSON;




@Controller//spring×¢½â
@ParentPackage("struts-default")
public class UtinsAction extends BaseAction<Utinaccountinfo>{
	@Autowired
    private UtinBiz utinBiz;
	//JOSN×Ö·û´®
	private String jsonArr;
	private PageEntitys pageEntitys;
	private int currPage;
	private Indaccountinfo indaccountinfo;
	PageEntitys pagenew=new PageEntitys();
	
	
	@Action(value="query2")
	public String query2(){
		Utinaccountinfo ut=utinBiz.getThree(getModel().getUtinName());
		  ut.setUnitinfo(null);
		     ut.setUtinsupapplies(null);
		     ut.setRemittancedetails(null);
		     ut.setIndaccountinfos(null);
		     ut.setFlupaies(null);
		     ut.setUtinremittancedetails(null);
		     String ss=JSON.toJSONString(ut);
		     getOut().print(ss);
		     return null;
		
	}
	
	@Action(value="query3")
	public String query3() throws UnsupportedEncodingException{
		Utinaccountinfo ut=utinBiz.getFour(getModel().getUtinName());
		System.out.println(ut);
		     ut.setUnitinfo(null);
		     ut.setUtinsupapplies(null);
		     ut.setRemittancedetails(null);
		     ut.setIndaccountinfos(null);
		     ut.setFlupaies(null);
		     ut.setUtinremittancedetails(null);
		     String jsonStr=JSON.toJSONString(ut);
		     getOut().print(jsonStr);
		return null;
		
	}
	
	@Action(value="query7")
	public String query7() throws IOException{
		pagenew.setCurrPage(currPage);
		if(pageEntitys==null){pageEntitys=new PageEntitys();}
	 	PageEntitys page=utinBiz.getEight(getModel().getUtinAccountId(),pagenew);
	 	String jsonStr=JSON.toJSONString(page);
	 	getOut().print(jsonStr);
		return null;
		
	}

	@Action(value="query8")
	public String query8(){
	List list=utinBiz.getFuzzy(getModel().getUtinAccountId(), indaccountinfo);
		     String jsonStr=JSON.toJSONString(list);
		    getOut().print(jsonStr);
		return null;
		
	}

	public PageEntitys getPageEntitys() {
		return pageEntitys;
	}

	public void setPageEntitys(PageEntitys pageEntitys) {
		this.pageEntitys = pageEntitys;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public Indaccountinfo getIndaccountinfo() {
		return indaccountinfo;
	}

	public void setIndaccountinfo(Indaccountinfo indaccountinfo) {
		this.indaccountinfo = indaccountinfo;
	}


	
}