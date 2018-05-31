package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.RoleDao;
import com.aaa.entity.Role;
@Service
@Transactional
public class RoleBizImpl implements RoleBiz{
	@Autowired
	RoleDao roleDao;
	@Override
	public int addRole(Role role) {
		roleDao.addRole(role);
		return 0;
	}

	@Override
	public int del_Role(Role role) {
		roleDao.del_Role(role);
		return 0;
	}

	@Override
	public List<Role> getAllRole() {
		return roleDao.getAllRole();
	}

	@Override
	public Role get_This_Role(Role role) {
		return roleDao.get_This_Role(role);
	}

	@Override
	public int update_Role(Role role) {
		return roleDao.update_Role(role);
	}

}
