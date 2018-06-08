package com.aaa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Powers;
import com.aaa.entity.Role;
import com.aaa.entity.Users;
import com.alibaba.fastjson.JSON;
@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Users> users_login(String hql) {
		List<Users> list_user = hibernateTemplate.find(hql);
		return list_user;
	}
	@Override
	public List<Users> get_UsersAll() {
		String hql = "select new map(u.uid as uid, u.uname as uname, u.unum as unum, u.upass as upass, u.udescription as udescription, u.ustatic as ustatic, u.role.rname as urname, u.role.rid as urid) from Users u";
		List list_users = hibernateTemplate.find(hql);/*"select new Users(u.uid, u.uname, u.unum, u.upass, u.udescription, u.ustatic)from Users u"*/
		return list_users;
	}
	
	@Override
	public int addUsers(Users users) {
		Role role = hibernateTemplate.get(Role.class, 12);
		users.setRole(role);
		users.setUstatic(1);
		hibernateTemplate.save(users);
		return 0;
	}

	@Override
	public int del_Users(Users users) {
		hibernateTemplate.delete(users);
		return 0;
	}


	@Override
	public List get_This_Users(Users users) {
		String hql = "select new map(u.uid as uid, u.uname as uname, u.unum as unum, u.upass as upass, u.udescription as udescription, u.ustatic as ustatic, u.role.rname as urname, u.role.rid as urid) from Users u where u.uid = "+users.getUid();
		
		List list_users = hibernateTemplate.find(hql);
		/*System.out.println(list_users);
		Users usersEntity = hibernateTemplate.get(Users.class, users.getUid());
		//设置关联关系空
		usersEntity.setRole(null);*/
		return list_users;
	}

	@Override
	public int update_Users(Users users, Role role) {
		Role roleImpl = hibernateTemplate.get(Role.class, role.getRid());
		users.setRole(roleImpl);
		hibernateTemplate.update(users);
		return 0;
	}

	
}
