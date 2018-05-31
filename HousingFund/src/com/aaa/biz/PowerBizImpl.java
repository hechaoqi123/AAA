package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.PowersDao;
import com.aaa.entity.Powers;
import com.aaa.entity.Role;
import com.aaa.entity.Users;
@Service
@Transactional
public class PowerBizImpl implements PowersBiz{
	@Autowired
	PowersDao powersDao;
	//获取用户权限
	public List<Powers> get_Powers(Users users){
		return powersDao.get_Powers(users);
	}
	@Override
	public int addFunction(Powers powers) {
		powersDao.addFunction(powers);
		return 0;
	}
	@Override
	public List<Powers> getAllPowers(String getRole, Role role) {
		return powersDao.getAllPowers(getRole,role);
	}
	@Override
	public int del_Prowers(Powers powers) {
		powersDao.del_Prowers(powers);
		return 0;
	}
	@Override
	public Powers get_This_Powers(Powers powers) {
		return powersDao.get_This_Powers(powers);
	}
	@Override
	public int update_powers(Powers powers) {
		powersDao.update_powers(powers);
		return 0;
	}
}
