package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.PageEntity;
import com.aaa.entity.PageEntitys;
import com.aaa.entity.Utinaccountinfo;



public interface UtinDao {

	public abstract Utinaccountinfo getThree(String UtinNumber);
	public abstract Utinaccountinfo getFour(String UtinNumber);
	public abstract PageEntitys getEight(Integer UtinAccountId,PageEntitys pageEntity);
	public abstract List getFuzzy(Integer utinAccountId, Indaccountinfo indaccountinfo);
}
