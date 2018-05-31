package com.aaa.entity;

/**
 * Roleemployee entity. @author MyEclipse Persistence Tools
 */

public class Roleemployee implements java.io.Serializable {

	// Fields

	private RoleemployeeId id;
	private Personalmanagement personalmanagement;
	private Rolemanagement rolemanagement;

	// Constructors

	/** default constructor */
	public Roleemployee() {
	}

	/** full constructor */
	public Roleemployee(RoleemployeeId id,
			Personalmanagement personalmanagement, Rolemanagement rolemanagement) {
		this.id = id;
		this.personalmanagement = personalmanagement;
		this.rolemanagement = rolemanagement;
	}

	// Property accessors

	public RoleemployeeId getId() {
		return this.id;
	}

	public void setId(RoleemployeeId id) {
		this.id = id;
	}

	public Personalmanagement getPersonalmanagement() {
		return this.personalmanagement;
	}

	public void setPersonalmanagement(Personalmanagement personalmanagement) {
		this.personalmanagement = personalmanagement;
	}

	public Rolemanagement getRolemanagement() {
		return this.rolemanagement;
	}

	public void setRolemanagement(Rolemanagement rolemanagement) {
		this.rolemanagement = rolemanagement;
	}

}