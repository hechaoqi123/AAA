package com.aaa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Powers;
import com.aaa.entity.Role;
import com.aaa.entity.Rolepowers;
import com.aaa.entity.Users;
@Repository
public class PowersDaoImpl implements PowersDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Override
	public List<Powers> get_Powers(Users users) {
		String hql_powers = "FROM Powers p WHERE p.pid in (SELECT rp.powers.pid FROM Rolepowers rp WHERE rp.role.rid = "+users.getRole().getRid()+")";
		
		List<Powers> list_powers = hibernateTemplate.find(hql_powers);
		return list_powers;
	}
	@Override
	public int addFunction(Powers powers) {
		hibernateTemplate.save(powers);
		return 0;
	}
	//@SuppressWarnings("unchecked")
	@Override
	public List<Powers> getAllPowers(String getRole, Role role) {
		String hql = null;
		List<Powers> list_Powers = null;
		//boolean b = getRole.equals("getRole");
		if(getRole.equals("getRole")){
			hql = "select new Powers(p.pid, p.pname, p.purl, p.ptype) FROM Powers p where p.pid in (SELECT rp.powers.pid FROM Rolepowers rp WHERE rp.role.rid = "+role.getRid()+")";
			list_Powers = hibernateTemplate.find(hql);
		}else if(getRole.equals("getNoRole")){
			hql = "select new Powers(p.pid, p.pname, p.purl, p.ptype) FROM Powers p where p.pid not in (SELECT rp.powers.pid FROM Rolepowers rp WHERE rp.role.rid = "+role.getRid()+")";
			list_Powers = hibernateTemplate.find(hql);
		}else{
			hql = "select new Powers(p.pid, p.pname, p.purl, p.ptype) from Powers p";
			list_Powers = hibernateTemplate.find(hql);
		}
		return list_Powers;
	}
	@Override
	public int del_Prowers(Powers powers) {
		hibernateTemplate.delete(powers);
		return 0;
	}
	@Override
	public Powers get_This_Powers(Powers powers) {
		Powers powersEntity = hibernateTemplate.get(Powers.class, powers.getPid());
		//设置关联关系空
		powersEntity.setRolepowerses(null);
		return powersEntity;
	}
	@Override
	public int update_powers(Powers powers) {
		hibernateTemplate.update(powers);
		return 0;
	}
	@Override
	public List<Powers> get_role_Powers(Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Powers> get_role_NoPowers(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

}
