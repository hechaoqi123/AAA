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
public class PageUtils{   //@Scope("singleton")默认单例：通过Spring进行获取的是同一个实例
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//获得总数据量
	
	/*	private int getCount(Class entityClass) {
		return  hibernateTemplate.find("From "+entityClass.getSimpleName()).size();
	}
	
    //获得总页数
	private int getTotalPage(Class entityClass,int MaxResult) {
		long count=getCount(entityClass);
		   if(count%MaxResult==0){
			   return (int) (count/MaxResult);
		   }else{
			   return (int) (count/MaxResult)+1;
		   }
	}
	
//PageEntity实体封装
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
    
    //PageEntity多表联合封装
    public PageEntity Join_PageEntity(List list,PageEntity pageEntity){
    	   //效率低:每次查询都会查询全表,尽量避免使用
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
		//将每页的数据封装到PageEntity
		page.setList(list);
		 //进行全表查询
		   List list2=hibernateTemplate.find(hql);
		 //总条数
		   int count=list2!=null ? list2.size() : 0;
		 //将总条数封装到PageEntity
		   page.setAllRows(count);
		   if(count%page.getPageSize()==0){
			   page.setAllPage(count/page.getPageSize());
		   }else{
			   page.setAllPage(count/page.getPageSize()+1);
		   }
		return page;
}  
}
