package com.aaa.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CauseOfExtractionDaoImpl implements CauseOfExtractionDao {

	@Resource
	private HibernateTemplate ht;
	
	/* (non-Javadoc)
	 * @see com.aaa.dao.CauseOfExtractionDao#sele_cause()
	 */
	@Override
	public List sele_cause(){
		
		List list=ht.find("select new map(c.reasonNo as reasonNo,c.causeDescription as causeDescription) from Causeofextraction c");
		
		
		return list;
	}
}
