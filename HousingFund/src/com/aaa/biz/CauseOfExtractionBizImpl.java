package com.aaa.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.CauseOfExtractionDaoImpl;

@Transactional
@Service
public class CauseOfExtractionBizImpl implements CauseOfExtractionBiz {

	@Resource
	private CauseOfExtractionDaoImpl dao;
	@Override
	public List sele_cause(){
		
				return dao.sele_cause();
	}
}
