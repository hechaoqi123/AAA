package com.aaa.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.RolePowersDao;
@Service
@Transactional
public class RolePowersBIzImpl implements RolePowersBIz {
	@Autowired
	RolePowersDao rolePowersDao;
	@Override
	public String getTr_role_add(int rid, int pid) {
		rolePowersDao.getTr_role_add(rid, pid);
		return null;
	}

	@Override
	public String getTr_role_del(int rid, int pid) {
		rolePowersDao.getTr_role_del(rid, pid);
		return null;
	}

}
