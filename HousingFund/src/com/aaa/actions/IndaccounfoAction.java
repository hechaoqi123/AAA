package com.aaa.actions;

import java.io.File;
import java.util.List;
import java.util.Map;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.IndaccountinfoBiz;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.alibaba.fastjson.JSON;

@ParentPackage("struts-default")
@Controller
public class IndaccounfoAction extends BaseAction<Indaccountinfo> {
	@Autowired
	private IndaccountinfoBiz indaccountinfoBiz; 
	
	private Indinfo indinfo;
	private List<Indinfo> list_indinfo;
	private List<Indaccountinfo> list_indaccountinfo;
	private Indaccountinfo indaccountinfo;
	private Integer utinaccountinfoID;
	private File myFile;
	
//添加excule
	@Action(value="saveFileIndaccountinfo", results = {@Result(name = "saveFileIndaccountinfo", location = "/BackJsp/LDL/saveFileError.jsp")})
	public String saveFileIndaccountinfo() throws Exception{
		List<List<Indaccountinfo>> list_Indaccountinfo = indaccountinfoBiz.saveFileIndaccountinfo(myFile);
		Object str = list_Indaccountinfo.get(0);
		if(str.equals("errorFile")){
			Map requestMap = getRequestMap();
			requestMap.put("list_Indaccountinfo", null);
		}else{
			Map requestMap = getRequestMap();
			requestMap.put("list_Indaccountinfo", list_Indaccountinfo);
		}
		return "saveFileIndaccountinfo";
		
	}
	
	
	//添加员工
	@Action(value="saveIndaccountinfo", results = {@Result(name = "saveIndaccountinfo", location = "/BackJsp/LDL/success.jsp")})
	public String saveIndaccountinfo(){
		if(list_indinfo != null){
			for(int i=0;i<list_indinfo.size();i++){
				indaccountinfoBiz.saveIndaccountinfo(list_indinfo.get(i), list_indaccountinfo.get(i), utinaccountinfoID);
			}
		}else{
			indaccountinfoBiz.saveIndaccountinfo(indinfo, indaccountinfo, utinaccountinfoID);
		}
		return "saveIndaccountinfo";
	}
	//获取指定公司员工
	@Action(value="getEmp", results = {@Result(name = "getEmp",  location = "/BackJsp/LDL/Emp.jsp")})
	public String getEmp(){
		List<Indaccountinfo> list_Indaccountinfo = indaccountinfoBiz.getEmp(utinaccountinfoID);
		getRequestMap().put("list_Indaccountinfo", list_Indaccountinfo);
		return "getEmp";
	}
	//修改基数
	@Action("updateRadices")
	public String updateRadices(){
		try {
			indaccountinfoBiz.updateRadices(indaccountinfo);
		} catch (Exception e) {
			System.out.println("基数修改异常！");
			e.printStackTrace();
		}
		return null;
	};
	//冻结账户
	@Action("frozenEmp")
	public String frozenEmp(){
		int frozenEmpReturn = indaccountinfoBiz.frozenEmp(indaccountinfo);
		getOut().print(frozenEmpReturn);
		return null;
	}
	@Action("thowEmp")
	public String thowEmp(){
		int frozenEmpReturn = indaccountinfoBiz.frozenEmp(indaccountinfo);
		getOut().print(frozenEmpReturn);
		return null;
	}
	//模糊查询
	@Action(value="getFuzzyEmp")
	public String getFuzzy(){
		   try {
				List list_Indaccountinfo = indaccountinfoBiz.getFuzzy(utinaccountinfoID, indaccountinfo);
				String json_Indaccountinfo = JSON.toJSONString(list_Indaccountinfo);
				getOut().print(json_Indaccountinfo);
		} catch (Exception e) {
		    System.out.println("indaccountAction模糊查询异常！");
		}
		return null;
		}
		//获取一个员工
		@Action(value="getEmpinfo", results = {@Result(name = "getEmpinfo",  location = "/BackJsp/LDL/employeeOpenImpl.jsp")})
		public String getEmpinfo(){
			Indaccountinfo indaccountinfoObject = indaccountinfoBiz.getOne(indaccountinfo.getIndAccountId());
			getRequestMap().put("indaccountinfoObject", indaccountinfoObject);
			return "getEmpinfo";
		}
		//通过条件获取一个对象注册查询
		@Action("getOneIndaf")
		public String getOneIndaf(){
			List oneIndaf = indaccountinfoBiz.getOneIndaf(list_indinfo.get(0));
			if(oneIndaf.size()>0){
				getOut().print("false");
			}else{
				getOut().print("true");
			}
			return null;
		}
		//员工转移获取一个用户
		@Action("UtinegetOneEmp")
		public String UtinegetOneEmp(){
			List utinegetOneEmp = indaccountinfoBiz.UtinegetOneEmp(indaccountinfo);
			String jsonUtin = JSON.toJSONString(utinegetOneEmp);
			getOut().print(jsonUtin);
			return null;
		}
		//修改
		@Action(value="updateIndaccountinfo", results = {@Result(name = "updateIndaccountinfo",  location = "/BackJsp/LDL/success.jsp")})
		public String updateIndaccountinfo(){
			for(int i=0;i<list_indinfo.size();i++){
				indinfo = list_indinfo.get(i);
			}
			indaccountinfoBiz.updateEmpInfo(indaccountinfo, indinfo, utinaccountinfoID);
			return "updateIndaccountinfo";
		}
		//员工转移
		@Action(value="empUtine", results = {@Result(name = "empUtine",  location = "/BackJsp/LDL/success.jsp")})
		public String empUtine(){
			indaccountinfoBiz.utine(list_indinfo.get(0).getIndInfoId(),indaccountinfo.getIndAccountId());
			return "empUtine";
		}
		
	public Indinfo getIndinfo() {
		return indinfo;
	}

	public void setIndinfo(Indinfo indinfo) {
		this.indinfo = indinfo;
	}

	public Indaccountinfo getIndaccountinfo() {
		return indaccountinfo;
	}

	public void setIndaccountinfo(Indaccountinfo indaccountinfo) {
		this.indaccountinfo = indaccountinfo;
	}

	public Integer getUtinaccountinfoID() {
		return utinaccountinfoID;
	}

	public void setUtinaccountinfoID(Integer utinaccountinfoID) {
		this.utinaccountinfoID = utinaccountinfoID;
	}

	public List<Indinfo> getList_indinfo() {
		return list_indinfo;
	}

	public void setList_indinfo(List<Indinfo> list_indinfo) {
		this.list_indinfo = list_indinfo;
	}

	public List<Indaccountinfo> getList_indaccountinfo() {
		return list_indaccountinfo;
	}

	public void setList_indaccountinfo(List<Indaccountinfo> list_indaccountinfo) {
		this.list_indaccountinfo = list_indaccountinfo;
	}


	public File getMyFile() {
		return myFile;
	}


	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	
	
}
