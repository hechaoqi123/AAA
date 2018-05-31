package com.aaa.dao;

import java.util.List;

public interface URDetailDao {

	//单位汇缴清册
	public List sele_Detail(int id);
	//个人汇缴清册
	public List sele_rd(int id);
	//个人提取纪录
	public List se_exre(int id);
}