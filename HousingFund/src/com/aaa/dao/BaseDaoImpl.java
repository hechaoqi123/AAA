package com.aaa.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.entity.PageEntity;
import com.aaa.util.PageUtil;
/**
 * 使用说明: 实现类继承此类并传入一个泛型实参（需要操作的表对应的实体类）
 *       注: 使用分页查询时需要配合PageEntity、PageUtil一块使用
 * 功能列表：
 *    1.增删改
 *    2.单体查询
 *    3.全表查询
 *    4.QBC条件查询
 *    5.样例查询
 *    
 *    6.分页查询
 *    7.链接分页查询（不推荐使用）
 * **/
@Component
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	@Autowired
   HibernateTemplate hibernateTemplate;
	@Autowired
    PageUtil util;
    Class cla;
	  //获取泛型实参
	{
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Type types[]=type.getActualTypeArguments();//父类的真实参数
		cla=(Class) types[0];//将参数转换为Class
	}
	//添加

	public void save(T entity) {
		  if(entity!=null){
			  hibernateTemplate.save(entity);
			  
			  
		  }
	}
    //删除

	public void delect(T entity) {
		if(entity!=null){
			hibernateTemplate.delete(entity);
		}
		
	}
    //修改

	public void update(T entity) {
		if(entity!=null){
			hibernateTemplate.update(entity);
		}
		
	}
   //查询所有

	public List<T> getAll() {
		return hibernateTemplate.find("From "+cla.getSimpleName());
	}
   //单体查询

	public T getOne(int id) {
		return (T) hibernateTemplate.get(cla, id);
	}
   //条件查询 
	public List<T> findByCriteria(Criterion[] criterions,Order order){
		   //创建一个离线查询
		DetachedCriteria criteria=DetachedCriteria.forClass(cla);
		if(criterions!=null){
			 for (Criterion criterion : criterions){//添加条件
		    	 if(criterion!=null){
		    		 criteria.add(criterion);
		    	 }
			}
		}
		    if(order!=null){//添加排序
		    	criteria.addOrder(order);
		     }
		return hibernateTemplate.findByCriteria(criteria);
	}
	//样例查询
	public java.util.List<T> findByExample(T t) {
		return hibernateTemplate.findByExample(t);
	};
	
	/**分页查询**/
   //分页链接查询
	public PageEntity getJoin(String HQL,PageEntity pageEntity) {
		 List<Map> list=hibernateTemplate.find(HQL);
		return util.Join_PageEntity(list, pageEntity);
	}
	
   //分页查询
	@SuppressWarnings("unchecked")
	public PageEntity findByPage(PageEntity pageEntity,Order order,Criterion criterion) {
		DetachedCriteria criteria=DetachedCriteria.forClass(cla);
		  if(criterion!=null){//添加限制
			  criteria.add(criterion);
		  }
		  if(order!=null){//添加排序
			  criteria.addOrder(order);
		  }
		    //hibernateTemplate.findByCriteria(criteria, firstResult, maxResults)
		  return util.getPageEntity(cla, criteria,pageEntity);
	}
	
}
