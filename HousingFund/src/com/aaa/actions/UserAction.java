package com.aaa.actions;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.UserBiz;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.alibaba.fastjson.JSON;




@Controller//spring×¢½â
@ParentPackage("struts-default")
public class UserAction extends BaseAction<Indaccountinfo>{
	@Autowired
    private UserBiz userBiz;
	//JOSN×Ö·û´®
	private String jsonArr;
	private Double indDepositRadices;
	private int indInfoId;
	private int utinAccountId;
	private Indinfo indinfo;	


	@Action(value="query")
	public String query(){
		Indaccountinfo ind=userBiz.getOne(getModel().getLoginAccount());
		     ind.setUtinaccountinfo(null);
		     ind.setIndinfo(null);
		     ind.setExtractionandapprovals(null);
		     String jsonStr=JSON.toJSONString(ind);
		    getOut().print(jsonStr);
		return null;
		
	}
	
	@Action(value="query1")
	public String query1(){
		
		Indaccountinfo ind=userBiz.getTwo(getModel().getLoginAccount());
		     ind.setUtinaccountinfo(null);
		     ind.setIndinfo(null);
		     ind.setExtractionandapprovals(null);
		     String jsonStr=JSON.toJSONString(ind);
		    getOut().print(jsonStr);
		return null;
		
	}
	
@Action("update")
public String update(){

	userBiz.update(getModel(), getModel().getIndinfo().getIndInfoId(),getModel().getIndAccountId());
	
	return null;
	
}



public Double getIndDepositRadices() {
	return indDepositRadices;
}

public void setIndDepositRadices(Double indDepositRadices) {
	this.indDepositRadices = indDepositRadices;
}

public int getIndInfoId() {
	return indInfoId;
}

public void setIndInfoId(int indInfoId) {
	this.indInfoId = indInfoId;
}

public int getUtinAccountId() {
	return utinAccountId;
}

public void setUtinAccountId(int utinAccountId) {
	this.utinAccountId = utinAccountId;
}

public String getJsonArr() {
	return jsonArr;
}

public void setJsonArr(String jsonArr) {
	this.jsonArr = jsonArr;
}

public Indinfo getIndinfo() {
	return indinfo;
}

public void setIndinfo(Indinfo indinfo) {
	this.indinfo = indinfo;
}
//	@Action(value="add")
//	public String add(){
//		System.out.println("EEE"+jsonArr);
//		try{
//			JSON.parseArray(jsonArr,Indaccountinfo.class);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		List<Indaccountinfo> list=JSON.parseArray(jsonArr,Indaccountinfo.class);
//		for(Indaccountinfo indaccountinfo:list){
//			System.out.println(indaccountinfo.getUtinaccountinfo());
//			System.out.println(indaccountinfo.getIndinfo());
//			userBiz.save(indaccountinfo);
//		}
//		try {
//			getOut().print(true);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//			return null;
//		}
	
	

}