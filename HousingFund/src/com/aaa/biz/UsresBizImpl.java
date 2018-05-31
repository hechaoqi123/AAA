package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.UsersDao;
import com.aaa.entity.Powers;
import com.aaa.entity.Role;
import com.aaa.entity.Users;
@Service
@Transactional
public class UsresBizImpl implements UsersBiz {
	@Autowired
	UsersDao usersDao;
	
	@Override
	public List<Users> get_UsersAll() {
		return usersDao.get_UsersAll();
	}
	@Override
	public List<Users> users_login(String hql) {
		return usersDao.users_login(hql);
	}
	@Override
	public int addUsers(Users users) {
		usersDao.addUsers(users);
		return 0;
	}
	@Override
	public int del_Users(Users users) {
		usersDao.del_Users(users);
		return 0;
	}
	@Override
	public List get_This_Users(Users users) {
		return usersDao.get_This_Users(users);
	}
	@Override
	public int update_Users(Users users, Role role) {
		usersDao.update_Users(users, role);
		return 0;
	}
	

}
