package com.aaa.dao;

import java.util.List;

import com.aaa.entity.TeachaerPageEntity;

public interface URDetailDao {

	//��λ������
	public TeachaerPageEntity sele_Detail(int id,TeachaerPageEntity page);
	//���˻�����
	public List sele_rd(int id);
	//������ȡ��¼
	public List se_exre(int id);
	
	//��ѯȫ����ȡ
	public TeachaerPageEntity sele_allex(TeachaerPageEntity page);
	//��ѯidnumȫ����ȡ
		public List sele_idnum(String idnum);
}