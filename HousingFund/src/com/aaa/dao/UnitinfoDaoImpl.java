package com.aaa.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Unitinfo;
@Repository
public class UnitinfoDaoImpl implements UnitinfoDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public int saveUnitinfo(Unitinfo utitinfo) {
		utitinfo.setUtinNumber(utitinfo.getOperatorIdnumber());
		hibernateTemplate.save(utitinfo);
		return utitinfo.getUtinId();
	}
	//查看公司是否存在
		@Override
		public boolean selutinName(Unitinfo utitinfo){
			String hql = "From Unitinfo where utinName = '"+utitinfo.getUtinName()+"'";
			List<Unitinfo> find = hibernateTemplate.find(hql);
			if(find.size()>0){
				return true;
			}else{
				return false;
			}
		}

}
