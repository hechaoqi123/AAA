package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Utinaccountinfo;

public interface UtinaccountinfoBiz {
	//��ѯ���й�˾�˻���Ϣ
	public List getUtinaccountinfo();
	//����ӹ�˾��Ϣʱ����һ����˾�˻���Ϣ
	public int saveUtinaccountinfo(Utinaccountinfo utinaccountinfo, int UnitinfoID);
	//��ѯһ��
	public List get_one_Utinaccountinfo(Integer accountId);
	//�޸�����
	public int update_utinAccount(Integer utinAccountId, String accountStatus);
	//��˾��ģ����ѯ
	public List getFuzzy(Utinaccountinfo utinaccountinfo);
	//��ѯһ����λ�޸���Ϣ
	public Utinaccountinfo getOneUtin(Utinaccountinfo utinaccountinfo);
	//�޸�ʵ��
//	public void
}
