package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Utinaccountinfo;

public interface UtinaccountinfoDao {
	//查询全部
	public List getUtinaccountinfo();
	//增加
	public int saveUtinaccountinfo(Utinaccountinfo utinaccountinfo,Integer UnitinfoID);
	//查询一个待审批公司
	public List get_one_Utinaccountinfo(Integer accountId);
	//审批
	public int update_utinAccount(Integer utinAccountId, String accountStatus);
	
	//公司的模糊查询
	public List getFuzzy(Utinaccountinfo utinaccountinfo);
}
