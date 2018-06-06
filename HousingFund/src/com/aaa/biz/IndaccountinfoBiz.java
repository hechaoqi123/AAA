package com.aaa.biz;

import java.io.File;
import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.RDUtil;

public interface IndaccountinfoBiz {
   
	
	
	// 汇缴之后  ——> 修改个人账户的余额
	public abstract int update_Indaccount(Indaccountinfo ind,RDUtil rd);
	//修改单位账户余额
	public int update_utinmoney(RDUtil rd);
	//查询个人总金钱
		public List ind_MyMoney(String idnum);
		
		//增加
		public int saveIndaccountinfo(Indinfo indinfo, Indaccountinfo indaccountinfo, Integer utinaccountinfoID);
		//查询当前公司是员工
		public List<Indaccountinfo> getEmp(Integer utinaccountinfoID);
		//修改基数
		public int updateRadices(Indaccountinfo indaccountinfo);
		//模糊查询当前公司的员工
		public List getFuzzy(Integer utinaccountinfoID, Indaccountinfo indaccountinfo);
		//获取个人账户
		public Indaccountinfo getOne(int id);
		//通过身份证号查询个人账户余额
		public int getMoney(Indaccountinfo entity);
		//提取还贷
		public void return_loan(Indaccountinfo entity,Float money2);
		//判断个人账户与身份证号是否匹配
		public List fingByExample(Indaccountinfo entity);
		//修改所有信息
		public int updateEmpInfo(Indaccountinfo indaccountinfo, Indinfo indinfo, Integer utinaccountinfoID);
		//冻结
		public int frozenEmp(Indaccountinfo indaccountinfo);
		//将文件传入dao返回处理的结果  插入成功或者失败
		public List saveFileIndaccountinfo(File file, Integer utinaccountinfoID) throws Exception;
		//条件查询一个信息
		public List getOneIndaf(Indinfo indinfo);
		//员工转移获取一个用户
		public List UtinegetOneEmp(Indaccountinfo indaccountinfo);
		//账户转移
		public void utine(int indId,int unitId);
}