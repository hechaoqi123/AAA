package com.aaa.biz;

import java.util.List;

import com.aaa.entity.*;


public interface UtinaccountinfoUtilBiz {
	//��ѯ�˵�λ�Ƿ����
	public List sele_utinid(int id);
	//sele
	public List selefu();
	//add save
	public int upinse(Flupay fu);
	//�ܽ��ɽ�
	public Double UtinSumMoneySele(Integer UtinId);
	//������Ϣ��ѯ
	public List UtinInfoSele(Integer UtinId);
	//��ѯ��λԱ����Ϣ
		public List IndAccountInfoSele(Integer UtinId);
		//��ѯ�ϴλ��
				public List sele_date(Integer UtinId);
				//��ѯ��λ
				public TeachaerPageEntity sele_utin(TeachaerPageEntity page);
				//��λidģ����ѯ
				public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids);
				//��λ����ģ����ѯ
				public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname);
				
				//��ѯ�˵�λ�Ƿ���ҵ���˲� ��ѯ��λ���˴���
				public List sele_fy(int id);
				//��ѯ�˵�λ�� ���״̬ �Ƿ�
				public List sele_uufy(int id);
}
