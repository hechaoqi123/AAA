package com.aaa.util;

import java.io.Serializable;
import java.util.List;

import javax.xml.registry.infomodel.User;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
   /**
    * 用户工具类
    * 把Object换成对应的UserEntity
    * **/
public abstract class UserUtil {
	 @Autowired
	private  static HibernateTemplate hibernateTemplate;
    private  static List users;//所有用户集合
    
    static{//静态方法块,初始化用户集合
    	DetachedCriteria criteria=DetachedCriteria.forClass("".getClass());//此处传入User.class
    	users=hibernateTemplate.findByCriteria(criteria);
    }
//获取所有用户
      public static List getUsers(){
    	  return users;
      }
//用户登陆
      public static Object UserLogin(Object entity){
    	  for(Object obj : users){
    		  //if(用户名==用户名&&密码==密码)
    		  //return obj;
    	  }
		      return null;
		}
//添加用户
      public static void saveUser(Object entity){
    		hibernateTemplate.save(entity); 
    		users.add(entity);
      }
//删除用户
      public static void deleteUser(Object entity){
    	  for(Object obj : users){//先从集合中删除,再从数据库中删除
    		  //if(主键==主键)
    	 	  // users.remove(obj);
    	  }
  		hibernateTemplate.delete(entity); 
     }
//修改用户      
      public static void UpdateUser(Object entity){
    	  hibernateTemplate.update(entity); 
    	  for(Object obj : users){//先修改数据库,然后替换集合中的元素
    		  //if(主键==主键)
    	 	  // users.remove(obj);
    		 // users.add(entity);
    	  }
     }
}
