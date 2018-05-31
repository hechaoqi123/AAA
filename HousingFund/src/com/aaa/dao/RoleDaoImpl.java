package com.aaa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Role;
@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Override
	public int addRole(Role role) {
		hibernateTemplate.save(role);
		return 0;
	}
	@Override
	public List<Role> getAllRole() {
		List<Role> list_Role = hibernateTemplate.find("select new Role(r.rid, r.rname, r.rtype) from Role r");
		return list_Role;
	}
	@Override
	public int del_Role(Role role) {
		hibernateTemplate.delete(role);
		return 0;
	}
	@Override
	public Role get_This_Role(Role Role) {
		Role RoleEntity = hibernateTemplate.get(Role.class, Role.getRid());
		//设置关联关系空
		RoleEntity.setUserses(null);
		RoleEntity.setRolepowerses(null);
		return RoleEntity;
	}
	@Override
	public int update_Role(Role role) {
		hibernateTemplate.update(role);
		return 0;
	}

}
