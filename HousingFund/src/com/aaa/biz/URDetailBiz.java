package com.aaa.biz;

import java.util.List;

import com.aaa.entity.TeachaerPageEntity;

public interface URDetailBiz {

	public TeachaerPageEntity sele_Detail(int id,TeachaerPageEntity page);
	
	public List sele_rd(int id);
	
	public List se_exre(int id);
	//查询全部
	public TeachaerPageEntity sele_allex(TeachaerPageEntity page);
	//查询idnum全部提取
	public List sele_idnum(String idnum);
}