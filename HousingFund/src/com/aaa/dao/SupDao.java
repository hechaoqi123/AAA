package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.UtilSup;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinsupapply;

public interface SupDao {

	//�Ȳ�ѯ��λ�˺��Ƿ����
	public Utinaccountinfo sele_u(int id);
	//��ѯ�����˻��Ƿ����
	public Indaccountinfo sele_i(int id);
	
	//��ӵ�λ���ɼ�¼ �õ���λID
	public abstract int inse_usa(Utinsupapply u, int a);
  
	//��Ӳ������  �޸ĸ����˻�
	public int inser_sd(UtilSup u,int id);
	
	//��ѯ���ɼ�¼
	public List bjse(int a);
	//����idnum��ѯ�˵�λ�Ƿ���ڴ�idnum
	public List sele_supidnum(int a,String idnum);
}