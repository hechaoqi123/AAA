package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Extractionandapproval;
import com.aaa.entity.Materialproof;

public interface ExAndAppDao {

	//添加材料证明等信息
	public abstract int Save_ExAndApp(Materialproof m,int reasonNo);
	
	//查询未审批
	public List sele_ex();
	public List sele_contract(int appid);

	//审批不通过
	public int not_con(int id);
	//审批通过
	public int yes_con(int appid,int indid,double money,String apptime);
}