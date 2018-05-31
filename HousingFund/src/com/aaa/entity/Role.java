package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rname;
	private String rtype;
	private Set rolepowerses = new HashSet(0);
	private Set userses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String rname, String rtype, Set rolepowerses, Set userses) {
		this.rname = rname;
		this.rtype = rtype;
		this.rolepowerses = rolepowerses;
		this.userses = userses;
	}
	public Role(Integer rid, String rname, String rtype) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.rtype = rtype;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRtype() {
		return this.rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public Set getRolepowerses() {
		return this.rolepowerses;
	}

	public void setRolepowerses(Set rolepowerses) {
		this.rolepowerses = rolepowerses;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}