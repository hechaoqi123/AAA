package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Extractionandapproval;
import com.aaa.entity.Materialproof;
import com.aaa.entity.TeachaerPageEntity;

public interface ExAndAppDao {

	//��Ӳ���֤������Ϣ
	public abstract int Save_ExAndApp(Materialproof m,int reasonNo);
	
	//��ѯδ����
	public TeachaerPageEntity sele_ex(TeachaerPageEntity page);
	//��ѯ��������Ϣ
	public List sele_EAA(int appid);
	//��ѯ��ͬ��Ϣ
	public List sele_contract(int appid);

	//������ͨ��
	public int not_con(int id);
	//����ͨ��
	public int yes_con(int appid,int indid,double money,String apptime);
}