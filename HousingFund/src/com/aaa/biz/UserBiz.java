package com.aaa.biz;

import org.springframework.stereotype.Service;

import com.aaa.entity.Indaccountinfo;
@Service
public interface UserBiz {

	public abstract Indaccountinfo getOne(String LoginAccount);

	public abstract Indaccountinfo getTwo(String LoginAccount);
	
	 public abstract void save(Object obj);
	 public abstract void update(Indaccountinfo indaccountinfo,int ida,int idb);
}