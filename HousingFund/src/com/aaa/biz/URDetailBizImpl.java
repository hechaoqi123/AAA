package com.aaa.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.URDetailDao;

@Service
@Transactional
public class URDetailBizImpl implements URDetailBiz {

	@Resource
	private URDetailDao dao;
	
	public List sele_Detail(int id){
	return dao.sele_Detail(id);
	}
	
	public List sele_rd(int id){
		
		return dao.sele_rd(id);
	}
	
	public List se_exre(int id){
		
		return dao.se_exre(id);
	}
	
}
