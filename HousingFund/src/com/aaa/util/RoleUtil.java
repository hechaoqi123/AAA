package com.aaa.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.chain.web.MapEntry;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 角色工具类
 * **/
public class RoleUtil {
	@Autowired
	static HibernateTemplate hibernateTemplate;
	private static Map Roles;//<角色名,角色实体>
	static{//初始化所有角色
		DetachedCriteria criteria=DetachedCriteria.forClass("".getClass());//此处传入Role.class
    	List list=hibernateTemplate.findByCriteria(criteria);
    	Roles=new HashMap();
    	for (Object object : list) {
			//Roles.put(角色名, 角色实体)
		}
	}
//获取所有角色
    public static Map getRoles(){
  	  return Roles;
    }
//获取角色实体
    public static Object UserLogin(String key){
	  return Roles.get(key);
	}
//添加角色
    public static void saveUser(Object entity){
  		hibernateTemplate.save(entity); 
  		//Roles.add(角色名,entity);
    }
//删除角色
    public static void deleteUser(Object entity){
  	      //Roles.remove(角色名);
		hibernateTemplate.delete(entity); 
   }
/*//修改角色    
    public static void UpdateUser(Object entity){
  	  hibernateTemplate.update(entity); 
  	 //Roles.put(角色名, entity);自动替换
   }*/
}
