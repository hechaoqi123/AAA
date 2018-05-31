package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Extractionandapproval;
import com.aaa.entity.Materialproof;

public interface ExAndAppBiz {

	public abstract int Save_ExAndApp(Materialproof m,int reasonNo);
	public List sele_ex();
	public List sele_contract(int appid);
	public int not_con(int id);
	public int yes_con(int appid,int indid,double money,String apptime);
}