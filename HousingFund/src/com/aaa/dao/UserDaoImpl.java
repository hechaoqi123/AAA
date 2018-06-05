package com.aaa.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.Utinaccountinfo;



@Repository
public class UserDaoImpl extends BaseDaoImpl<Indaccountinfo> implements UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	/* (non-Javadoc)
	 * @see com.aaa.dao.UserDao#getOne(java.lang.String)
	 */
	@Override
	public Indaccountinfo getOne(String LoginAccount) {
		Indaccountinfo t=new Indaccountinfo();
		t.setLoginAccount(LoginAccount);
		  List<Indaccountinfo> list=findByExample(t);
		  if(list.size()==0){
               return null;			  
		  }
		 return list.get(0);

	}
	
	public Indaccountinfo getTwo(String LoginAccount) {
		Indaccountinfo t=new Indaccountinfo();
		t.setLoginAccount(LoginAccount);
		  List<Indaccountinfo> list=findByExample(t);
		  if(list.size()==0){
               return null;			  
		  }
		 return list.get(0);

	}

	public void save2(Object obj) {
		hibernateTemplate.save(obj);
		
	}
	
	public void update(Indaccountinfo ino,int ida,int idb){
	   Indinfo i=hibernateTemplate.get(Indinfo.class, ida);
	 //Utinaccountinfo u=hibernateTemplate.get(Utinaccountinfo.class, idb);
	   i.setTrueName(ino.getIndinfo().getTrueName());
	 i.setSex(ino.getIndinfo().getSex());
	 i.setPhoneNumber(ino.getIndinfo().getPhoneNumber());
	 
	 //indaccountinfo.setUtinaccount.nfo(u);
	   i.setDuties(ino.getIndinfo().getDuties());
	   hibernateTemplate.update(i);
		//
		Indaccountinfo ui=hibernateTemplate.get(Indaccountinfo.class,idb);
		ui.setIndDepositRadices(ino.getIndDepositRadices());
		try {
			hibernateTemplate.update(ui);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		hibernateTemplate.update(ui);
		
		
		;
	};

}   
