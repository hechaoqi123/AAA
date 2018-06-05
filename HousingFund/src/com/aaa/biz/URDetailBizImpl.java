package com.aaa.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.URDetailDao;
import com.aaa.entity.TeachaerPageEntity;

@Service
@Transactional
public class URDetailBizImpl implements URDetailBiz {

	@Resource
	private URDetailDao dao;
	
	public TeachaerPageEntity sele_Detail(int id,TeachaerPageEntity page){
	return dao.sele_Detail(id, page);
	}
	
	public List sele_rd(int id){
		
		return dao.sele_rd(id);
	}
	
	public List se_exre(int id){
		
		return dao.se_exre(id);
	}
	public TeachaerPageEntity sele_allex(TeachaerPageEntity page){
		
		return dao.sele_allex(page);
	}
	//查询idnum全部提取
	public List sele_idnum(String idnum){
		
		return dao.sele_idnum(idnum);
	}
}
