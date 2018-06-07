package com.aaa.biz;

import java.util.List;

import org.springframework.stereotype.Service;


import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.PageEntity;
import com.aaa.entity.PageEntitys;
import com.aaa.entity.Utinaccountinfo;
@Service
public interface UtinBiz {

	public abstract Utinaccountinfo getThree(String UtinNumber);
	public abstract Utinaccountinfo getFour(String UtinNumber);
	public abstract PageEntitys getEight(Integer UtinAccountId,PageEntitys pageEntity);
	public abstract List getFuzzy(Integer utinAccountId, Indaccountinfo indaccountinfo);
}