package com.aaa.biz;

import java.io.File;
import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.RDUtil;

public interface IndaccountinfoBiz {
   
	
	
	// ���֮��  ����> �޸ĸ����˻������
	public abstract int update_Indaccount(Indaccountinfo ind,RDUtil rd);
	//�޸ĵ�λ�˻����
	public int update_utinmoney(RDUtil rd);
	//��ѯ�����ܽ�Ǯ
		public List ind_MyMoney(String idnum);
		
		//����
		public int saveIndaccountinfo(Indinfo indinfo, Indaccountinfo indaccountinfo, Integer utinaccountinfoID);
		//��ѯ��ǰ��˾��Ա��
		public List<Indaccountinfo> getEmp(Integer utinaccountinfoID);
		//�޸Ļ���
		public int updateRadices(Indaccountinfo indaccountinfo);
		//ģ����ѯ��ǰ��˾��Ա��
		public List getFuzzy(Integer utinaccountinfoID, Indaccountinfo indaccountinfo);
		//��ȡ�����˻�
		public Indaccountinfo getOne(int id);
		//ͨ�����֤�Ų�ѯ�����˻����
		public int getMoney(Indaccountinfo entity);
		//��ȡ����
		public void return_loan(Indaccountinfo entity,Float money2);
		//�жϸ����˻������֤���Ƿ�ƥ��
		public List fingByExample(Indaccountinfo entity);
		//�޸�������Ϣ
		public int updateEmpInfo(Indaccountinfo indaccountinfo, Indinfo indinfo, Integer utinaccountinfoID);
		//����
		public int frozenEmp(Indaccountinfo indaccountinfo);
		//���ļ�����dao���ش���Ľ��  ����ɹ�����ʧ��
		public List saveFileIndaccountinfo(File file, Integer utinaccountinfoID) throws Exception;
		//������ѯһ����Ϣ
		public List getOneIndaf(Indinfo indinfo);
		//Ա��ת�ƻ�ȡһ���û�
		public List UtinegetOneEmp(Indaccountinfo indaccountinfo);
		//�˻�ת��
		public void utine(int indId,int unitId);
}