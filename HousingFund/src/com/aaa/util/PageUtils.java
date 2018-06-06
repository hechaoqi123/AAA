package com.aaa.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.entity.PageEntity;
import com.aaa.entity.PageEntitys;
@Component
public class PageUtils{   //@Scope("singleton")Ĭ�ϵ�����ͨ��Spring���л�ȡ����ͬһ��ʵ��
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//�����������
	
	/*	private int getCount(Class entityClass) {
		return  hibernateTemplate.find("From "+entityClass.getSimpleName()).size();
	}
	
    //�����ҳ��
	private int getTotalPage(Class entityClass,int MaxResult) {
		long count=getCount(entityClass);
		   if(count%MaxResult==0){
			   return (int) (count/MaxResult);
		   }else{
			   return (int) (count/MaxResult)+1;
		   }
	}
	
//PageEntityʵ���װ
    public PageEntity getPageEntity(Class entityClass,DetachedCriteria criteria,PageEntity entity){
    	int CurrentPage=entity.getCurrentPage();
    	int maxResults=entity.getMaxResult();
    	int totalPage=getTotalPage(entityClass, maxResults);
    	int count=getCount(entityClass);
    	int first=(CurrentPage-1)*maxResults;
    	List list=hibernateTemplate.findByCriteria(criteria, first, maxResults);
    	  entity.setCount(count);
    	  entity.setList(list);
    	  entity.setTotalPage(totalPage);
		return entity;
    }
    
    //PageEntity������Ϸ�װ
    public PageEntity Join_PageEntity(List list,PageEntity pageEntity){
    	   //Ч�ʵ�:ÿ�β�ѯ�����ѯȫ��,��������ʹ��
     	int CurrentPage=pageEntity.getCurrentPage();
    	int maxResults=pageEntity.getMaxResult();
    	int count=list.size();
    	int totalPage;
    	   if(count%maxResults==0){
    		   totalPage=count/maxResults;
    	   }else{
    		   totalPage=(count/maxResults)+1; 
    	   }
    	  pageEntity.setCount(count);
    	  pageEntity.setTotalPage(totalPage);
    	  pageEntity.setList(list.subList((CurrentPage-1)*maxResults,CurrentPage*maxResults));
		return pageEntity;
    }*/
     
    public PageEntitys getPage(final String hql,final PageEntitys page){
		List list=hibernateTemplate.executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query =session.createQuery(hql);
				query.setFirstResult((page.getCurrPage()-1)*page.getPageSize());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}
			
	});
		//��ÿҳ�����ݷ�װ��PageEntity
		page.setList(list);
		 //����ȫ���ѯ
		   List list2=hibernateTemplate.find(hql);
		 //������
		   int count=list2!=null ? list2.size() : 0;
		 //����������װ��PageEntity
		   page.setAllRows(count);
		   if(count%page.getPageSize()==0){
			   page.setAllPage(count/page.getPageSize());
		   }else{
			   page.setAllPage(count/page.getPageSize()+1);
		   }
		return page;
}  
}
