package com.aaa.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Loanapplication;





@Repository
public class LoanDaoImpl extends BaseDaoImpl<Loanapplication> implements LoanDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Loanapplication getFive(String BorrowerIdnumber) {
		/*Loanapplication t=new Loanapplication();
		t.setBorrowerIdnumber(BorrowerIdnumber);
		List<Loanapplication> list=findByExample(t);*/
		String hql = "from Loanapplication l where l.borrowerIdnumber = '"+BorrowerIdnumber+"'";
		List<Loanapplication> find = hibernateTemplate.find(hql);
		  if(find.size()==0){
               return null;			  
		  }
		 return find.get(0);

	}
	
	public Loanapplication getSix(String BorrowerIdnumber) {
		String hql = "from Loanapplication l where l.borrowerIdnumber = '"+BorrowerIdnumber+"'";
		List<Loanapplication> find = hibernateTemplate.find(hql);
		  if(find.size()==0){
               return null;			  
		  }
		 return find.get(0);

	}
}
