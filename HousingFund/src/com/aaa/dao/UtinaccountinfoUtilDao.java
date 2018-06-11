package com.aaa.dao;

import java.util.List;

import com.aaa.entity.*;


public interface UtinaccountinfoUtilDao {

	//查询此单位是否存在
	public List sele_utinid(int id);
	//添加或者修改
	public int upinse(Flupay fu);
		
	public List<Utinaccountinfo> ss(int id);

	public List selefu();
	
	//总缴纳金
	public Double UtinSumMoneySele(Integer UtinId);
	
	//其他信息查询
	public List UtinInfoSele(Integer UtinId);
	//查询单位员工信息
	public List IndAccountInfoSele(Integer UtinId);
	//查询上次汇缴
		public List sele_date(Integer UtinId);
		//查询全部单位
		public TeachaerPageEntity sele_utin(TeachaerPageEntity page);
		//单位id模糊查询
		public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids);
		//单位名称模糊查询
		public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname);
			
	
		 //先获取所有正常单位账户
		public List<Utinaccountinfo> utinse();
		//查询本月是否缴纳过
		public List sele_uddate(int id);
		//得到单位账户余额
		public Double sele_yue(int id);
		//得到所有个人账户信息 
		public List<Indaccountinfo> sele_Allindinfo(int id);
		//得到个人信息
		public Indaccountinfo sele_oneindinfo(int uid,int iid,String uname);
		//修改账户余额
		public int update_utinmoney(int id,Double money);
		//添加单位汇缴纪录
		public int add_rd(int id,Double money);
		
		//查询此单位是否开启业务了并 查询单位法人代表
		public List sele_fy(int id);
		//查询此单位的 冲缴状态 是否
		public List sele_uufy(int id);
	
}
