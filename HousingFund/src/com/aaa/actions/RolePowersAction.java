package com.aaa.actions;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.aaa.biz.RolePowersBIz;
import com.aaa.entity.Rolepowers;


@ParentPackage("struts-default")
@Controller
public class RolePowersAction extends BaseAction<Rolepowers> {
	private Integer rid;
	private Integer pid;
	@Autowired
	private RolePowersBIz rolePowersBiz;
	@Action("getTr_role_add")
	public void getTr_role_add(){
		rolePowersBiz.getTr_role_add(rid, pid);
		getOut().print("true");
	}
	@Action("getTr_role_del")
	public String getTr_role_del(){
		rolePowersBiz.getTr_role_del(rid, pid);
		getOut().print("true");
		return null;
	}
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	
	
}
