package com.aaa.entity;

/**
 * RoleemployeeId entity. @author MyEclipse Persistence Tools
 */

public class RoleemployeeId implements java.io.Serializable {

	// Fields

	private Personalmanagement personalmanagement;
	private Rolemanagement rolemanagement;

	// Constructors

	/** default constructor */
	public RoleemployeeId() {
	}

	/** full constructor */
	public RoleemployeeId(Personalmanagement personalmanagement,
			Rolemanagement rolemanagement) {
		this.personalmanagement = personalmanagement;
		this.rolemanagement = rolemanagement;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleemployeeId))
			return false;
		RoleemployeeId castOther = (RoleemployeeId) other;

		return ((this.getPersonalmanagement() == castOther
				.getPersonalmanagement()) || (this.getPersonalmanagement() != null
				&& castOther.getPersonalmanagement() != null && this
				.getPersonalmanagement().equals(
						castOther.getPersonalmanagement())))
				&& ((this.getRolemanagement() == castOther.getRolemanagement()) || (this
						.getRolemanagement() != null
						&& castOther.getRolemanagement() != null && this
						.getRolemanagement().equals(
								castOther.getRolemanagement())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPersonalmanagement() == null ? 0 : this
						.getPersonalmanagement().hashCode());
		result = 37
				* result
				+ (getRolemanagement() == null ? 0 : this.getRolemanagement()
						.hashCode());
		return result;
	}

}