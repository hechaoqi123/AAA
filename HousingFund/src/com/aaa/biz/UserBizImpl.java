package com.aaa.biz;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import com.aaa.dao.UserDao;
import com.aaa.entity.Indaccountinfo;


@Repository
public class UserBizImpl implements UserBiz {
	@Autowired
	private UserDao userDao;
	
	@Override
	public Indaccountinfo getOne(String LoginAccount) {
	return userDao.getOne(LoginAccount);
	}
	
	public Indaccountinfo getTwo(String LoginAccount) {
	return userDao.getTwo(LoginAccount);
	}

	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
	   userDao.save2(obj);
	}
	public void update(Indaccountinfo indaccountinfo,int ida,int idb){
		userDao.update(indaccountinfo, ida, idb);
		
	}
}
