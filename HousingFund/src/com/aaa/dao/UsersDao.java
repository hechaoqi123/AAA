package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Users;
import com.aaa.entity.Role;

public interface UsersDao {

	public List<Users> users_login(String hql);
	/*
	 * 	1、自动注入：@Resources，@Autowired
		
		2、Bean定义：@Component、@Repository、@Service 和 @Constroller 
		
		@Component是个泛化概念，可以用在任何层次。如果是web开发，尽量用@Repository、@Service 和 @Constroller
	 * */
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