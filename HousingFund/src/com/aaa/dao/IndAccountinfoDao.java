package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.RDUtil;

public interface IndAccountinfoDao extends BaseDao<Indaccountinfo>{

	// 汇缴之后  ——> 修改个人账户的余额
	public abstract int update_Indaccount(Indaccountinfo ind,RDUtil rd);

	//修改单位账户余额
	public int update_utinmoney(RDUtil rd);
	//查询个人总金钱
	public List ind_MyMoney(String idnum);
	
	//增加
		public int saveIndaccountinfo(Indinfo indinfo, Indaccountinfo indaccountinfo, Integer utinaccountinfoID);
		//查询当前公司是员工
		public List getEmp(Integer utinaccountinfoID);
		//修改基数
		public int updateRadices(Indaccountinfo indaccountinfo);
		//模糊查询当前公司的员工
		public List getFuzzy(Integer utinaccountinfoID, Indaccountinfo indaccountinfo);
		//修改所有信息
		public int updateEmpInfo(Indaccountinfo indaccountinfo, Indinfo indinfo, Integer utinaccountinfoID);
		//删除
		public int delEmp(Indaccountinfo indaccountinfo);
}