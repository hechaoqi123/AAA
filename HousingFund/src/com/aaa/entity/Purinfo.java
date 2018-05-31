package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Purinfo entity. @author MyEclipse Persistence Tools
 */

public class Purinfo implements java.io.Serializable {

	// Fields

	private Integer piId;
	private String puType;
	private String puAddress;
	private String pumoney;
	private String puText;
	private String shphone;
	private String shaddress;
	private String shutin;
	private String shidnum;
	private String hbname;
	private String recnum;
	private String houcs;
	private Set materialtypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Purinfo() {
	}

	/** full constructor */
	public Purinfo(String puType, String puAddress, String pumoney,
			String puText, String shphone, String shaddress, String shutin,
			String shidnum, String hbname, String recnum, String houcs,
			Set materialtypes) {
		this.puType = puType;
		this.puAddress = puAddress;
		this.pumoney = pumoney;
		this.puText = puText;
		this.shphone = shphone;
		this.shaddress = shaddress;
		this.shutin = shutin;
		this.shidnum = shidnum;
		this.hbname = hbname;
		this.recnum = recnum;
		this.houcs = houcs;
		this.materialtypes = materialtypes;
	}

	// Property accessors

	public Integer getPiId() {
		return this.piId;
	}

	public void setPiId(Integer piId) {
		this.piId = piId;
	}

	public String getPuType() {
		return this.puType;
	}

	public void setPuType(String puType) {
		this.puType = puType;
	}

	public String getPuAddress() {
		return this.puAddress;
	}

	public void setPuAddress(String puAddress) {
		this.puAddress = puAddress;
	}

	public String getPumoney() {
		return this.pumoney;
	}

	public void setPumoney(String pumoney) {
		this.pumoney = pumoney;
	}

	public String getPuText() {
		return this.puText;
	}

	public void setPuText(String puText) {
		this.puText = puText;
	}

	public String getShphone() {
		return this.shphone;
	}

	public void setShphone(String shphone) {
		this.shphone = shphone;
	}

	public String getShaddress() {
		return this.shaddress;
	}

	public void setShaddress(String shaddress) {
		this.shaddress = shaddress;
	}

	public String getShutin() {
		return this.shutin;
	}

	public void setShutin(String shutin) {
		this.shutin = shutin;
	}

	public String getShidnum() {
		return this.shidnum;
	}

	public void setShidnum(String shidnum) {
		this.shidnum = shidnum;
	}

	public String getHbname() {
		return this.hbname;
	}

	public void setHbname(String hbname) {
		this.hbname = hbname;
	}

	public String getRecnum() {
		return this.recnum;
	}

	public void setRecnum(String recnum) {
		this.recnum = recnum;
	}

	public String getHoucs() {
		return this.houcs;
	}

	public void setHoucs(String houcs) {
		this.houcs = houcs;
	}

	public Set getMaterialtypes() {
		return this.materialtypes;
	}

	public void setMaterialtypes(Set materialtypes) {
		this.materialtypes = materialtypes;
	}

}