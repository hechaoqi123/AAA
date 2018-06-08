package com.aaa.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.PowersBiz;
import com.aaa.biz.UsersBiz;
import com.aaa.entity.Powers;
import com.aaa.entity.Role;
import com.aaa.entity.Users;
import com.alibaba.fastjson.JSON;

@ParentPackage("struts-default")
@Controller
public class UsersAction extends BaseAction<Users> {
	@Autowired
	private UsersBiz usersBiz;
	@Autowired
	private PowersBiz powersBiz;
	
	private Users users;
	private Integer urid;
	
	//用户登录
	@Action(value = "users_login", results = {@Result(name = "users_login.action", location = "/BackJsp/HomePage.jsp"),@Result(name = "users_login.action null", location = "/BackJsp/login.jsp")})
	public String users_login(){
		String hql = "FROM Users u where u.unum = '"+users.getUname()+"' and u.upass = '"+users.getUpass()+"'";
		List<Users> list_users = usersBiz.users_login(hql);
		if(list_users.size() != 0){
			List<Powers> list_Powers = powersBiz.get_Powers(list_users.get(0));
			Map map= getRequestMap();
			map.put("list_users", list_users);
			map.put("list_Powers", list_Powers);
			HttpSession session=getSession();
			session.setAttribute("user",list_users.get(0));
			return "users_login.action";
		}else{
			Map map= getRequestMap();
			map.put("error", "用户名或密码错误！");
			return "users_login.action null";
		}
	};
	//注销
	@Action(value="cancel",results={@Result(name="success",type="redirect",location="/BackJsp/login.jsp")})
	public String cancel(){
		HttpSession session=getSession();
		session.removeAttribute("user");
		return SUCCESS;
	}
	//查询全部员工
	@Action("get_UsersAll")
	public String get_UsersAll(){
		List list_users = usersBiz.get_UsersAll();
		String json_users = JSON.toJSONString(list_users);
		getOut().print(json_users);
		return null;
	}
	//添加
	@Action("addUsers")
	public String addUsers(){
		usersBiz.addUsers(users);
		return null;
	}
	//删除
	@Action("del_Users")
	public String del_Users(){
		usersBiz.del_Users(users);
		return null;
	}
	//查询一个
	@Action("get_This_Users")
	public String get_This_Users(){
		List get_This_Users = usersBiz.get_This_Users(users);
		String json_Users = JSON.toJSONString(get_This_Users);
		getOut().print(json_Users);
		return null;
		
	}
	//修改
	@Action("update_users")
	public String update_users(){
		try {
			Role role = new Role();
			role.setRid(urid);
			usersBiz.update_Users(users, role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	public Integer getUrid() {
		return urid;
	}
	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	

}
