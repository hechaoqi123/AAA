package com.aaa.entity;

/**
 * Rolepowers entity. @author MyEclipse Persistence Tools
 */

public class Rolepowers implements java.io.Serializable {

	// Fields

	private Integer rpid;
	private Powers powers;
	private Role role;

	// Constructors

	/** default constructor */
	public Rolepowers() {
	}

	/** full constructor */
	public Rolepowers(Powers powers, Role role) {
		this.powers = powers;
		this.role = role;
	}

	// Property accessors

	public Integer getRpid() {
		return this.rpid;
	}

	public void setRpid(Integer rpid) {
		this.rpid = rpid;
	}

	public Powers getPowers() {
		return this.powers;
	}

	public void setPowers(Powers powers) {
		this.powers = powers;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}