package com.aaa.dao;

import java.util.List;

import com.aaa.entity.*;


public interface UtinaccountinfoUtilDao {

	//��ѯ�˵�λ�Ƿ����
	public List sele_utinid(int id);
	//��ӻ����޸�
	public int upinse(Flupay fu);
		
	public List<Utinaccountinfo> ss(int id);

	public List selefu();
	
	//�ܽ��ɽ�
	public Double UtinSumMoneySele(Integer UtinId);
	
	//������Ϣ��ѯ
	public List UtinInfoSele(Integer UtinId);
	//��ѯ��λԱ����Ϣ
	public List IndAccountInfoSele(Integer UtinId);
	//��ѯ�ϴλ��
		public List sele_date(Integer UtinId);
		//��ѯȫ����λ
		public TeachaerPageEntity sele_utin(TeachaerPageEntity page);
		//��λidģ����ѯ
		public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids);
		//��λ����ģ����ѯ
		public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname);
			
	
		 //�Ȼ�ȡ����������λ�˻�
		public List<Utinaccountinfo> utinse();
		//��ѯ�����Ƿ���ɹ�
		public List sele_uddate(int id);
		//�õ���λ�˻����
		public Double sele_yue(int id);
		//�õ����и����˻���Ϣ 
		public List<Indaccountinfo> sele_Allindinfo(int id);
		//�õ�������Ϣ
		public Indaccountinfo sele_oneindinfo(int uid,int iid,String uname);
		//�޸��˻����
		public int update_utinmoney(int id,Double money);
		//��ӵ�λ��ɼ�¼
		public int add_rd(int id,Double money);
		
		//��ѯ�˵�λ�Ƿ���ҵ���˲� ��ѯ��λ���˴���
		public List sele_fy(int id);
		//��ѯ�˵�λ�� ���״̬ �Ƿ�
		public List sele_uufy(int id);
	
}
