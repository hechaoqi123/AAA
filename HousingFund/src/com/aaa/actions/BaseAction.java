package com.aaa.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 *  使用说明：
 *   1.Action继承此BaaseAction并传一个实体参数（需要作为ModelDriven的实参使用）
 *   2.默认继承ActionSupport类
 *   3.默认实现ModelDriven接口,前台可以直接通过属性名进行相应的传值(通过getModel获取实体)
 * */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	//解耦
	   //request域
	public Map getRequestMap(){
		return  (Map)ActionContext.getContext().get("request");
	}
	  //session域
	public Map getSessionMap(){
		return  ActionContext.getContext().getSession();
	}
	//耦合
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	public HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	//获取PrintWriter流
	public PrintWriter getOut(){
		PrintWriter out = null;
		try {
			HttpServletResponse response=this.getResponse();
			response.setCharacterEncoding("utf-8");
			out= response.getWriter();
		} catch (IOException e) {
			System.out.println("获取Out对象异常");
			e.printStackTrace();
		}
		return out;
	}
	//ModelDriven接口的实现
	  T entity;
	{
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Type types[]=type.getActualTypeArguments();//父类的真实参数
		Class cla=(Class) types[0];//参数变成类
		try {
			entity=(T) cla.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("实体对象实例化异常");
		} 
	}
	public T getModel() {
	    return (T) entity;
	}
}
