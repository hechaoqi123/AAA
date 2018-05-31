package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Powers;
import com.aaa.entity.Role;
import com.aaa.entity.Users;

public interface PowersBiz {
	//获取用户权限
	public List<Powers> get_Powers(Users users);
	//增加功能
	public int addFunction(Powers powers);
	//删除功能
	public int del_Prowers(Powers powers);

	//查询所有功能
	public List<Powers> getAllPowers(String getRole, Role role);
	//查询一个
	public Powers get_This_Powers(Powers powers);
	//修改
	public int update_powers(Powers powers);
}
