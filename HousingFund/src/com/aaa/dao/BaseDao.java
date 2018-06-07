package com.aaa.dao;

import java.io.File;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.aaa.entity.PageEntity;

public interface BaseDao<T> {

	//添加
	public abstract void save(T entity);

	//删除
	public abstract void delect(T entity);

	//修改
	public abstract void update(T entity);

	//查询所有
	public abstract List<T> getAll();

	//单体查询
	public abstract T getOne(int id);
	//多条件QBC查询
	public abstract List<T> findByCriteria(Criterion[] criterions,Order order);
	//链接查询
	public abstract PageEntity getJoin(String HQL,PageEntity pageEntity);
    //样例查询
	public abstract List<T> findByExample(T t);
	//分页查询（分页实体,排序规则，条件限制）
	@SuppressWarnings("unchecked")
	public PageEntity findByPage(PageEntity pageEntity,Order order,Criterion criterion);

}