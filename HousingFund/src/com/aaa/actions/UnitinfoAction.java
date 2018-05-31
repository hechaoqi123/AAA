package com.aaa.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.UnitinfoBiz;
import com.aaa.biz.UtinaccountinfoBiz;
import com.aaa.entity.Unitinfo;
import com.aaa.entity.Utinaccountinfo;
import com.alibaba.fastjson.JSON;
@ParentPackage("struts-default")
@Controller
public class UnitinfoAction extends BaseAction<Unitinfo> {
	@Autowired
	private UnitinfoBiz unitinfoBiz;
	@Autowired
	private UtinaccountinfoBiz utinaccountinfoBiz;
	
	
	private Utinaccountinfo utinaccountinfo;
	private Unitinfo utitinfo;
	//增加一个公司
	@Action(value="saveUnitinfo",results={@Result(name="saveUnitinfo",location="/BackJsp/LDL/success.jsp")})
	public String saveUnitinfo(){
		int UnitinfoID = unitinfoBiz.saveUnitinfo(utitinfo);
		utinaccountinfo.setUtinName(utitinfo.getUtinName());
		utinaccountinfoBiz.saveUtinaccountinfo(utinaccountinfo, UnitinfoID);
		return "saveUnitinfo";
		}
	//查看公司是否存在
	@Action("selutinName")
	public String selutinName(){
		getOut().print(unitinfoBiz.selutinName(utitinfo));
		return null;
		}
	
	
	
	
	
	public Unitinfo getUtitinfo() {
		return utitinfo;
	}
	public void setUtitinfo(Unitinfo utitinfo) {
		this.utitinfo = utitinfo;
	}
	public Utinaccountinfo getUtinaccountinfo() {
		return utinaccountinfo;
	}
	public void setUtinaccountinfo(Utinaccountinfo utinaccountinfo) {
		this.utinaccountinfo = utinaccountinfo;
	}
	
	
	
}
