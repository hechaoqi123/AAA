package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



import com.aaa.dao.UtinDao;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.PageEntity;
import com.aaa.entity.PageEntitys;
import com.aaa.entity.Utinaccountinfo;


@Repository
public class UtinBizImpl implements UtinBiz {
	@Autowired
	private UtinDao utinDao;

	@Override
	public Utinaccountinfo getThree(String UtinNumber) {
		// TODO Auto-generated method stub
		return utinDao.getThree(UtinNumber);
	}

	@Override
	public Utinaccountinfo getFour(String UtinNumber) {
		// TODO Auto-generated method stub
		return utinDao.getFour(UtinNumber);
	}
	
	@Override
	public PageEntitys getEight(Integer UtinAccountId,PageEntitys pageEntity) {
		// TODO Auto-generated method stub
		return utinDao.getEight(UtinAccountId, pageEntity);
	}
	public List getFuzzy(Integer utinAccountId, Indaccountinfo indaccountinfo){
		return utinDao.getFuzzy(utinAccountId, indaccountinfo);
	}
}