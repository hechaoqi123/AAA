package com.aaa.biz;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.aaa.entity.Fush;
import com.aaa.entity.PageEntity;

//������廹����
public interface FushBiz {
  //������ҵ��
	public void work(Fush entity);
  //��ѯ���а��������û�
	public List getAll();
  //�廹��
	public void work2();
  //��ҳ��ѯ����廹�����û�	
	public PageEntity getPart(PageEntity entity, Criterion criterion);
  //���˳����־	
	public Fush getOne(Integer id);
  //�޸ĸ���ҵ��״̬
	public void update(int id,String status);
  //ɾ��
	public void remove(int id);
}
