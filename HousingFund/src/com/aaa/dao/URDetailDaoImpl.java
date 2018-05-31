package com.aaa.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class URDetailDaoImpl implements URDetailDao {

	@Resource
	private HibernateTemplate ht;
	
	public List sele_Detail(int id){
	
		List list=ht.find("select new map(utinName as utinName,payinSumMoney as payinSumMoney," +
				"depositPeople as depositPeople,depositDate as depositDate," +
				"adminname as adminname,remonth as remonth,finaldate as finaldate,oridate as oridate" +
				")  from  Utinremittancedetail u where u.utinaccountinfo.utinAccountId="+id+" ");
		return list;
	}
	public List sele_rd(int id){
		
		List list=ht.find("select new map(payinSumMoney as payinSumMoney,payinDate as payinDate) from Remittancedetail r where r.indAccountId="+id+"");
		return list;
	}
	
	public List se_exre(int id){
		
		List list=ht.find("select new map(withdrawalAmount as withdrawalAmount,extractionDate as extractionDate,loanDate as loanDate) from Extractionrecord e where e.extractionAccount="+id+"");
		return list;
	}
	
}
