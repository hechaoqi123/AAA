package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Powers entity. @author MyEclipse Persistence Tools
 */

public class Powers implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String pname;
	private String purl;
	private String ptype;
	private Set rolepowerses = new HashSet(0);

	// Constructors

	/** default constructor */
	/** default constructor */
	public Powers() {
	}

	/** full constructor */
	public Powers(String pname, String purl, String ptype, Set rolepowerses) {
		this.pname = pname;
		this.purl = purl;
		this.ptype = ptype;
		this.rolepowerses = rolepowerses;
	}
	public Powers(Integer pid, String pname, String purl, String ptype) {
		this.pid = pid;
		this.pname = pname;
		this.purl = purl;
		this.ptype = ptype;
	}
	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPurl() {
		return this.purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getPtype() {
		return this.ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public Set getRolepowerses() {
		return this.rolepowerses;
	}

	public void setRolepowerses(Set rolepowerses) {
		this.rolepowerses = rolepowerses;
	}

}