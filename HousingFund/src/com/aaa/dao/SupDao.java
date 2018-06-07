package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.UtilSup;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinsupapply;

public interface SupDao {

	//先查询单位账号是否存在
	public Utinaccountinfo sele_u(int id);
	//查询个人账户是否存在
	public Indaccountinfo sele_i(int id);
	
	//添加单位补缴纪录 得到到位ID
	public abstract int inse_usa(Utinsupapply u, int a);
  
	//添加补缴清册  修改个人账户
	public int inser_sd(UtilSup u,int id);
	
	//查询补缴纪录
	public List bjse(int a);
	//根据idnum查询此单位是否存在此idnum
	public List sele_supidnum(int a,String idnum);
}