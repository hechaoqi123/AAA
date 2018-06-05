package com.aaa.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.ExAndAppDao;
import com.aaa.entity.Extractionandapproval;
import com.aaa.entity.Materialproof;
import com.aaa.entity.TeachaerPageEntity;

@Service

public class ExAndAppBizImpl implements ExAndAppBiz {

	@Resource
	private ExAndAppDao dao;
	@Override
	public int Save_ExAndApp(Materialproof m,int reasonNo){
		
		dao.Save_ExAndApp(m,reasonNo);
		return 0;
	}
	
	public TeachaerPageEntity sele_ex(TeachaerPageEntity page){
		return dao.sele_ex(page);
	}
	
	public List sele_contract(int appid){
		
		return dao.sele_contract(appid);
	}
	
	public int not_con(int id){
		
		return dao.not_con(id);
	}
	
	public int yes_con(int appid,int indid,double money,String apptime){
		
		return dao.yes_con(appid, indid, money, apptime);
	}
	
	public List sele_EAA(int appid){
		
		return dao.sele_EAA(appid);
	}
}
