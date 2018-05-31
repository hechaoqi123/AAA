package com.aaa.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Role role;
	private String unum;
	private String upass;
	private String uname;
	private String udescription;
	private Integer ustatic;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(Role role, String unum, String upass, String uname,
			String udescription, Integer ustatic) {
		this.role = role;
		this.unum = unum;
		this.upass = upass;
		this.uname = uname;
		this.udescription = udescription;
		this.ustatic = ustatic;
	}
	public Users(Integer uid, String unum, String upass, String uname,
			String udescription, Integer ustatic) {
		super();
		this.uid = uid;
		this.unum = unum;
		this.upass = upass;
		this.uname = uname;
		this.udescription = udescription;
		this.ustatic = ustatic;
	}
	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUnum() {
		return this.unum;
	}

	public void setUnum(String unum) {
		this.unum = unum;
	}

	public String getUpass() {
		return this.upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUdescription() {
		return this.udescription;
	}

	public void setUdescription(String udescription) {
		this.udescription = udescription;
	}

	public Integer getUstatic() {
		return this.ustatic;
	}

	public void setUstatic(Integer ustatic) {
		this.ustatic = ustatic;
	}

}