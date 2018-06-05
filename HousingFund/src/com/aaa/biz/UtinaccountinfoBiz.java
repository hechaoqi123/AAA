package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Utinaccountinfo;

public interface UtinaccountinfoBiz {
	//查询所有公司账户信息
	public List getUtinaccountinfo();
	//在添加公司信息时增加一个公司账户信息
	public int saveUtinaccountinfo(Utinaccountinfo utinaccountinfo, int UnitinfoID);
	//查询一个
	public List get_one_Utinaccountinfo(Integer accountId);
	//修改审批
	public int update_utinAccount(Integer utinAccountId, String accountStatus);
	//公司的模糊查询
	public List getFuzzy(Utinaccountinfo utinaccountinfo);
	//查询一个单位修改信息
	public Utinaccountinfo getOneUtin(Utinaccountinfo utinaccountinfo);
	//修改实现
//	public void
}
