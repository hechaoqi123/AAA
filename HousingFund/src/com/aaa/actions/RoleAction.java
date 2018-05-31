package com.aaa.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.RoleBiz;
import com.aaa.entity.Role;
import com.aaa.entity.Role;
import com.alibaba.fastjson.JSON;
@ParentPackage("struts-default")
@Controller
public class RoleAction extends BaseAction<Role> {
	private Role role;
	@Autowired
	RoleBiz RoleBiz;
	//增加一个
	@Action("addRole")
	public String addRole(){
		RoleBiz.addRole(role);
		getOut().print("true");
		return null;
	}
	//查询所有
	@Action("ger_All_Role")
	public String get_All_Role(){
		List<Role> list_Role = RoleBiz.getAllRole();
		String json_Role = JSON.toJSONString(list_Role);
		getOut().print(json_Role);
		return null;
	}
	//删除一个
	@Action("del_Role")
	public String del_Role(){
		RoleBiz.del_Role(role);
		getOut().print("true");
		return null;
	}
	//查询一个
	@Action("get_This_Role")
	public String get_This_Role(){
		String json_This_Role = JSON.toJSONString(RoleBiz.get_This_Role(role));
		getOut().print(json_This_Role);
		return null;
		}
	//修改
	@Action("update_Role")
	public String update_Role(){
		RoleBiz.update_Role(role);
		getOut().print("true");
		return null;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
