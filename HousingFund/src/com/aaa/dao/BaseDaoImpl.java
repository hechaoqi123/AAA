package com.aaa.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.entity.PageEntity;
import com.aaa.util.PageUtil;
/**
 * ʹ��˵��: ʵ����̳д��ಢ����һ������ʵ�Σ���Ҫ�����ı��Ӧ��ʵ���ࣩ
 *       ע: ʹ�÷�ҳ��ѯʱ��Ҫ���PageEntity��PageUtilһ��ʹ��
 * �����б�
 *    1.��ɾ��
 *    2.�����ѯ
 *    3.ȫ���ѯ
 *    4.QBC������ѯ
 *    5.������ѯ
 *    
 *    6.��ҳ��ѯ
 *    7.���ӷ�ҳ��ѯ�����Ƽ�ʹ�ã�
 * **/
@Component
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	@Autowired
   HibernateTemplate hibernateTemplate;
	@Autowired
    PageUtil util;
    Class cla;
	  //��ȡ����ʵ��
	{
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Type types[]=type.getActualTypeArguments();//�������ʵ����
		cla=(Class) types[0];//������ת��ΪClass
	}
	//���

	public void save(T entity) {
		  if(entity!=null){
			  hibernateTemplate.save(entity);
			  
			  
		  }
	}
    //ɾ��

	public void delect(T entity) {
		if(entity!=null){
			hibernateTemplate.delete(entity);
		}
		
	}
    //�޸�

	public void update(T entity) {
		if(entity!=null){
			hibernateTemplate.update(entity);
		}
		
	}
   //��ѯ����

	public List<T> getAll() {
		return hibernateTemplate.find("From "+cla.getSimpleName());
	}
   //�����ѯ

	public T getOne(int id) {
		return (T) hibernateTemplate.get(cla, id);
	}
   //������ѯ 
	public List<T> findByCriteria(Criterion[] criterions,Order order){
		   //����һ�����߲�ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(cla);
		if(criterions!=null){
			 for (Criterion criterion : criterions){//�������
		    	 if(criterion!=null){
		    		 criteria.add(criterion);
		    	 }
			}
		}
		    if(order!=null){//�������
		    	criteria.addOrder(order);
		     }
		return hibernateTemplate.findByCriteria(criteria);
	}
	//������ѯ
	public java.util.List<T> findByExample(T t) {
		return hibernateTemplate.findByExample(t);
	};
	
	/**��ҳ��ѯ**/
   //��ҳ���Ӳ�ѯ
	public PageEntity getJoin(String HQL,PageEntity pageEntity) {
		 List<Map> list=hibernateTemplate.find(HQL);
		return util.Join_PageEntity(list, pageEntity);
	}
	
   //��ҳ��ѯ
	@SuppressWarnings("unchecked")
	public PageEntity findByPage(PageEntity pageEntity,Order order,Criterion criterion) {
		DetachedCriteria criteria=DetachedCriteria.forClass(cla);
		  if(criterion!=null){//�������
			  criteria.add(criterion);
		  }
		  if(order!=null){//�������
			  criteria.addOrder(order);
		  }
		    //hibernateTemplate.findByCriteria(criteria, firstResult, maxResults)
		  return util.getPageEntity(cla, criteria,pageEntity);
	}
	
}
