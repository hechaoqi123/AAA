package com.aaa.dao;

import java.io.File;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.aaa.entity.PageEntity;

public interface BaseDao<T> {

	//���
	public abstract void save(T entity);

	//ɾ��
	public abstract void delect(T entity);

	//�޸�
	public abstract void update(T entity);

	//��ѯ����
	public abstract List<T> getAll();

	//�����ѯ
	public abstract T getOne(int id);
	//������QBC��ѯ
	public abstract List<T> findByCriteria(Criterion[] criterions,Order order);
	//���Ӳ�ѯ
	public abstract PageEntity getJoin(String HQL,PageEntity pageEntity);
    //������ѯ
	public abstract List<T> findByExample(T t);
	//��ҳ��ѯ����ҳʵ��,��������������ƣ�
	@SuppressWarnings("unchecked")
	public PageEntity findByPage(PageEntity pageEntity,Order order,Criterion criterion);

}