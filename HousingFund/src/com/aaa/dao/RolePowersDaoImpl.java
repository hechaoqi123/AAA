package com.aaa.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Powers;
import com.aaa.entity.Role;
import com.aaa.entity.Rolepowers;

@Repository
public class RolePowersDaoImpl implements RolePowersDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Override
	public String getTr_role_add(int rid, int pid) {
		Role r=hibernateTemplate.get(Role.class, rid);
		Powers p=hibernateTemplate.get(Powers.class, pid);
		Rolepowers rp=new Rolepowers();
		rp.setPowers(p);
		rp.setRole(r);
		hibernateTemplate.save(rp);
		return null;
	}

	@Override
	public String getTr_role_del(int rid, int pid) {
		Rolepowers rp=new Rolepowers();
		String hql = "FROM Rolepowers rp WHERE rp.role.rid = "+rid+" and rp.powers.pid = "+pid;
		List<Rolepowers> find = hibernateTemplate.find(hql);
		rp = find.get(0);
		hibernateTemplate.delete(rp);
		return null;
	}

}
