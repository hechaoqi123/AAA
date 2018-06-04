package com.aaa.biz;

import java.util.List;

import com.aaa.entity.*;


public interface UtinaccountinfoUtilBiz {

	
	//sele
	public List selefu();
	//add save
	public int upinse(Flupay fu);
	//总缴纳金
	public Double UtinSumMoneySele(Integer UtinId);
	//其他信息查询
	public List UtinInfoSele(Integer UtinId);
	//查询单位员工信息
		public List IndAccountInfoSele(Integer UtinId);
		//查询上次汇缴
				public List sele_date(Integer UtinId);
				//查询单位
				public TeachaerPageEntity sele_utin(TeachaerPageEntity page);
				//单位id模糊查询
				public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids);
				//单位名称模糊查询
				public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname);
				
}
