package com.aaa.util;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.entity.PageEntity;
@Component
public class PageUtil{   //@Scope("singleton")默认单例：通过Spring进行获取的是同一个实例
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//获得总数据量
	
	private int getCount(Class entityClass) {
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
    }
     
    
}
