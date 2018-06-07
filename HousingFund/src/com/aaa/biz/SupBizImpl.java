package com.aaa.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.SupDao;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.UtilSup;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinsupapply;

@Service
@Transactional
public class SupBizImpl implements SupBiz {

	@Resource
	private SupDao dao;
	public Utinaccountinfo sele_u(int id){
		
		return dao.sele_u(id);
	}
	public Indaccountinfo sele_i(int id){
		
		return dao.sele_i(id);
	}
	
	@Override
	public int inse_usa(Utinsupapply u,int a){

		
		
		return dao.inse_usa(u, a);
	}
	public int inser_sd(UtilSup u,int id){
		
		return dao.inser_sd(u, id);
	}
	public List bjse(int a){
		return dao.bjse(a);
	}
	//根据idnum查询此单位是否存在此idnum
		public List sele_supidnum(int a,String idnum){
			
			return dao.sele_supidnum(a, idnum);
		}
}
