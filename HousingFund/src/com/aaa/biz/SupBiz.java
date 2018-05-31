package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.UtilSup;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinsupapply;

public interface SupBiz {

	public Utinaccountinfo sele_u(int id);
	
	public Indaccountinfo sele_i(int id);
	
	public abstract int inse_usa(Utinsupapply u, int a);

	public int inser_sd(UtilSup u,int id);
	
	public List bjse(int a);
}