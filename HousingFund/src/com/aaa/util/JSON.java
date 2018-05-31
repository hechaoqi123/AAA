package com.aaa.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aaa.entity.Loanapplication;
import com.aaa.entity.Repaymentplandetails;
public class JSON {
	
	/**
	 * 方法如下：
	 *   RemoveRelation(Object obj):删除对象关联关系
	 *   toJson(Object obj):将对象转换为JSON字符串(不携带关联关系)
	 *   toJsonRelation(Object obj):将对象转换为JSON字符串(携带未实现任何接口的关联对象)
	 *   toCollectionJson(Collection coll):将集合转换为JSON字符串(携带为实现任何接口的关联对象)
	 * ***/
	//目前支持的字段类型
	private static Class[] clas={Integer.class,Float.class,String.class,Double.class,Date.class};
//取消所有关联对象
	public static Object RemoveRelation(Object obj) {
		
		if(obj!=null){
		  Class cla=obj.getClass();
	      Field[] fields=cla.getDeclaredFields();
	      for (Field field : fields) {
	    	  field.setAccessible(true);
	    	 List types=Arrays.asList(clas);
	    	 if(!types.contains(field.getType())){
	    		try {
					field.set(obj, null);
				} catch (Exception e) {
					e.printStackTrace();
				} 
	    	 }
		 }
	      }
		return obj;
	}
//将对象转换为JSON格式（不转换关联对象） 
	public static String toJson(Object obj) {
        Class cla=obj.getClass();
    	Field[] fields=cla.getDeclaredFields(); //所有字段
    	StringBuffer str=new StringBuffer();
    	  str.append("{");
    	for (Field field : fields) {
    		field.setAccessible(true);//取消访问权限检查
    		List list=Arrays.asList(clas);
    		Class type=field.getType();//字段类型
    		String name=field.getName();
    		if(list.contains(type)){
    			try {
					if(field.get(obj)!=null){//属性不为空时转换为json
						 if(type==Date.class){
								str.append("\""+name+"\"");
								str.append(":");
					    	 Date da=(Date) field.get(obj);
					    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					    	str.append("\""+sdf.format(da)+"\"");
					    	str.append(",");
						}else{
							str.append("\""+name+"\"");
							str.append(":");
							str.append("\""+field.get(obj)+"\"");
							str.append(",");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
    		}
		}
    	str.deleteCharAt(str.length()-1);//删除最后一个逗号
    	str.append("}");
		return str.toString();
    }
//将对象转换为JSON格式（转换只实现一个序列化接口的类型的关联对象） 
	public static String toJsonRelation(Object obj) {
		try {
		  if(obj==null){
			  return null;
		  }
        Class cla=obj.getClass();
    	Field[] fields=cla.getDeclaredFields(); //所有字段
    	StringBuffer str=new StringBuffer();
    	  str.append("{");
    	for (Field field : fields) {
    		field.setAccessible(true);//取消访问权限检查
    		List list=Arrays.asList(clas);
    		Class type=field.getType();//字段类型
    		String name=field.getName();
    		if(list.contains(type)){
    			if(field.get(obj)!=null){//属性不为空时转换为json
    				 if(type==Date.class){//数据类型为Date类型时格式化
    						str.append("\""+name+"\"");
    		    			str.append(":");
                    	 Date da=(Date) field.get(obj);
                    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    	str.append("\""+sdf.format(da)+"\"");
                    	str.append(",");
        			}else{
        				str.append("\""+name+"\"");
		    			str.append(":");
        				str.append("\""+field.get(obj)+"\"");
        				str.append(",");
        			}
    			}
    		}else {
    			 Class[] interfaces = type.getInterfaces();
    			if(interfaces.length==1&&interfaces[0].getName().equals("java.io.Serializable")){//实体类实现了一个接口
        			str.append("\""+name+"\"");
        			str.append(":");
        		    str.append(toJsonRelation(field.get(obj)));//递归分解
        		    str.append(",");
        			str.append("}");
        			str.deleteCharAt(str.length()-1);//删除最后一个逗号
        		}
    		}
		}
    	 str.deleteCharAt(str.length()-1);//删除最后一个逗号
    	 str.append("}");
    	return str.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
//将集合转换为Json类型
	public static String toCollectionJson(Collection coll){
		StringBuffer str=new StringBuffer();
		  str.append("[");
		    for (Object object : coll) {
		    	str.append(toJsonRelation(object));
		    	str.append(",");
			}
		    str.deleteCharAt(str.length()-1);//删除最后一个逗号
		  str.append("]");
		return str.toString();
	}
/**JSON测试***/	
	static class cla{
		String cname="java2";
		stu s;
		
	}
	static class stu{
		String sname="张三";
		stu2 s2;
		String aname="张三3";
		
	}
	static class stu2{
		String sname="张三2";
		
	}
	public static void main(String[] args) throws Exception {
		List list=new ArrayList();
		cla c=new cla();
		stu s=new stu();
		stu2 s2=new stu2();
		s.s2=s2;
		c.s=s;
		list.add(c);
		list.add(s);
		list.add(s2);
		System.out.println(toCollectionJson(list));
	}
	
} 
