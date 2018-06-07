package com.aaa.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.PageEntity;
import com.aaa.entity.PageEntitys;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.util.PageUtil;
import com.aaa.util.PageUtils;


@Repository
public class UtinDaoImpl extends BaseDaoImpl<Utinaccountinfo> implements UtinDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private PageUtils util;
	/* (non-Javadoc)
	 * @see com.aaa.dao.UserDao#getOne(java.lang.String)
	 */
	
	public Utinaccountinfo getThree(String UtinNumber) {
		Utinaccountinfo u=new Utinaccountinfo();
		u.setUtinName(UtinNumber);
		  List<Utinaccountinfo> list=findByExample(u);
		  if(list.size()==0){
               return null;			  
		  }
		 return list.get(0);

	}
	
	public Utinaccountinfo getFour(String UtinNumber) {
		Utinaccountinfo u=new Utinaccountinfo();
		u.setUtinName(UtinNumber);
		  List<Utinaccountinfo> list=findByExample(u);
		  if(list.size()==0){
               return null;			  
		  }
		 return list.get(0);

	}
	
public PageEntitys getEight(Integer UtinAccountId,PageEntitys pageEntity){
		
		String hql="select new Map(i.indinfo.indInfoId as indInfoId,i.indinfo.trueName as trueName,i.indinfo.sex as sex,i.loginAccount as indAccount,i.indinfo.phoneNumber as phoneNumber,i.indinfo.idnumber as idnumber,i.indinfo.duties as duties,i.indAccountId as indAccountId,i.indDepositRadices as indDepositRadices) from Indaccountinfo i where i.utinaccountinfo.utinAccountId='"+UtinAccountId+"'";
		
		return util.getPage(hql,pageEntity);
		
	}
public List getFuzzy(Integer utinAccountId, Indaccountinfo indaccountinfo){

	String hql = "select new map(i.indinfo.indInfoId as indInfoId,i.indinfo.trueName as trueName,i.indinfo.sex as sex,i.indinfo.indAccount as indAccount,i.indinfo.phoneNumber as phoneNumber,i.indinfo.idnumber as idnumber,i.indinfo.duties as duties,i.indDepositRadices as indDepositRadices) from Indaccountinfo i where i.indinfo.trueName like '%"+indaccountinfo.getIndinfo().getTrueName()+"%' and  i.utinaccountinfo.utinAccountId = "+utinAccountId;
	try {
		hibernateTemplate.find(hql);
	} catch (Exception e) {
		e.printStackTrace();
	}
	List list_Indaccountinfo = hibernateTemplate.find(hql);
	return list_Indaccountinfo;
	}


}
