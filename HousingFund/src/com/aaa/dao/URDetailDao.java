package com.aaa.dao;

import java.util.List;

import com.aaa.entity.TeachaerPageEntity;

public interface URDetailDao {

	//单位汇缴清册
	public TeachaerPageEntity sele_Detail(int id,TeachaerPageEntity page);
	//个人汇缴清册
	public List sele_rd(int id);
	//个人提取纪录
	public List se_exre(int id);
	
	//查询全部提取
	public TeachaerPageEntity sele_allex(TeachaerPageEntity page);
	//查询idnum全部提取
		public List sele_idnum(String idnum);
}