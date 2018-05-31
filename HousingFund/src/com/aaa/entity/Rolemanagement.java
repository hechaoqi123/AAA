package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Rolemanagement entity. @author MyEclipse Persistence Tools
 */

public class Rolemanagement implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleDescribe;
	private Integer roleGrade;
	private Set roleemployees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rolemanagement() {
	}

	/** full constructor */
	public Rolemanagement(String roleDescribe, Integer roleGrade,
			Set roleemployees) {
		this.roleDescribe = roleDescribe;
		this.roleGrade = roleGrade;
		this.roleemployees = roleemployees;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleDescribe() {
		return this.roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

	public Integer getRoleGrade() {
		return this.roleGrade;
	}

	public void setRoleGrade(Integer roleGrade) {
		this.roleGrade = roleGrade;
	}

	public Set getRoleemployees() {
		return this.roleemployees;
	}

	public void setRoleemployees(Set roleemployees) {
		this.roleemployees = roleemployees;
	}

}