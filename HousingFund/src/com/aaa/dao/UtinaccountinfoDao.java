package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Utinaccountinfo;

public interface UtinaccountinfoDao {
	//��ѯȫ��
	public List getUtinaccountinfo();
	//����
	public int saveUtinaccountinfo(Utinaccountinfo utinaccountinfo,Integer UnitinfoID);
	//��ѯһ����������˾
	public List get_one_Utinaccountinfo(Integer accountId);
	//����
	public int update_utinAccount(Integer utinAccountId, String accountStatus);
	
	//��˾��ģ����ѯ
	public List getFuzzy(Utinaccountinfo utinaccountinfo);
}
