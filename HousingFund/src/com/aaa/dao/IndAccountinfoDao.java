package com.aaa.dao;

import java.io.File;
import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.RDUtil;

public interface IndAccountinfoDao extends BaseDao<Indaccountinfo>{

	// ���֮��  ����> �޸ĸ����˻������
	public abstract int update_Indaccount(Indaccountinfo ind,RDUtil rd);

	//�޸ĵ�λ�˻����
	public int update_utinmoney(RDUtil rd);
	//��ѯ�����ܽ�Ǯ
	public List ind_MyMoney(String idnum);
	
	//����
		public int saveIndaccountinfo(Indinfo indinfo, Indaccountinfo indaccountinfo, Integer utinaccountinfoID);
		//��ѯ��ǰ��˾��Ա��
		public List getEmp(Integer utinaccountinfoID);
		//�޸Ļ���
		public int updateRadices(Indaccountinfo indaccountinfo);
		//ģ����ѯ��ǰ��˾��Ա��
		public List getFuzzy(Integer utinaccountinfoID, Indaccountinfo indaccountinfo);
		//�޸�������Ϣ
		public int updateEmpInfo(Indaccountinfo indaccountinfo, Indinfo indinfo, Integer utinaccountinfoID);
		//����
		public int frozenEmp(Indaccountinfo indaccountinfo);
		//�ļ�����Ա��
		public List saveFileIndaccountinfo(File file) throws Exception;
		//������ѯһ����Ϣ
		public List getOneIndaf(Indinfo indinfo);
		//Ա��ת�ƻ�ȡһ���û�
		public List UtinegetOneEmp(Indaccountinfo indaccountinfo);
}