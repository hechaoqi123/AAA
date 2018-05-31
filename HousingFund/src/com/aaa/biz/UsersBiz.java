package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Role;
import com.aaa.entity.Users;

public interface UsersBiz {
	public List<Users> users_login(String hql);
	
	//查询全部
	public List<Users> get_UsersAll();
	//增加功能
	public int addUsers(Users users);
	//删除功能
	public int del_Users(Users users);
	
	
	//查询一个
	public List get_This_Users(Users users);
	//修改
	public int update_Users(Users users, Role role);
}
