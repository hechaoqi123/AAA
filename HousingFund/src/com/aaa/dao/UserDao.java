package com.aaa.dao;

import com.aaa.entity.Indaccountinfo;

public interface UserDao {

	public abstract Indaccountinfo getOne(String LoginAccount);
	public abstract Indaccountinfo getTwo(String LoginAccount);
    public abstract void save2(Object obj);
    public abstract void update(Indaccountinfo indaccountinfo,int ida,int idb);
}