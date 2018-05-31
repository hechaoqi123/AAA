package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Role;

public interface RoleDao {
	//增加功能
	public int addRole(Role role);
	//删除功能
	public int del_Role(Role role);
	
	//查询所有功能
	public List<Role> getAllRole();
	
	//查询一个
	public Role get_This_Role(Role role);
	//修改
	public int update_Role(Role role);
}
