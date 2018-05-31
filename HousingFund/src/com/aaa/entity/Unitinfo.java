package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Unitinfo entity. @author MyEclipse Persistence Tools
 */

public class Unitinfo implements java.io.Serializable {

	// Fields

	private Integer utinId;
	private String utinName;
	private String utinNumber;
	private String utinAddress;
	private String corpRepr;
	private String operatorName;
	private String operatorPhone;
	private String operatorIdnumber;
	private String bankName;
	private Date utinFoundDate;
	private Date utinOpenDate;
	private String admissibleNetwork;
	private Set utinaccountinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Unitinfo() {
	}

	/** full constructor */
	public Unitinfo(String utinName, String utinNumber, String utinAddress,
			String corpRepr, String operatorName, String operatorPhone,
			String operatorIdnumber, String bankName, Date utinFoundDate,
			Date utinOpenDate, String admissibleNetwork, Set utinaccountinfos) {
		this.utinName = utinName;
		this.utinNumber = utinNumber;
		this.utinAddress = utinAddress;
		this.corpRepr = corpRepr;
		this.operatorName = operatorName;
		this.operatorPhone = operatorPhone;
		this.operatorIdnumber = operatorIdnumber;
		this.bankName = bankName;
		this.utinFoundDate = utinFoundDate;
		this.utinOpenDate = utinOpenDate;
		this.admissibleNetwork = admissibleNetwork;
		this.utinaccountinfos = utinaccountinfos;
	}

	// Property accessors

	public Integer getUtinId() {
		return this.utinId;
	}

	public void setUtinId(Integer utinId) {
		this.utinId = utinId;
	}

	public String getUtinName() {
		return this.utinName;
	}

	public void setUtinName(String utinName) {
		this.utinName = utinName;
	}

	public String getUtinNumber() {
		return this.utinNumber;
	}

	public void setUtinNumber(String utinNumber) {
		this.utinNumber = utinNumber;
	}

	public String getUtinAddress() {
		return this.utinAddress;
	}

	public void setUtinAddress(String utinAddress) {
		this.utinAddress = utinAddress;
	}

	public String getCorpRepr() {
		return this.corpRepr;
	}

	public void setCorpRepr(String corpRepr) {
		this.corpRepr = corpRepr;
	}

	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorPhone() {
		return this.operatorPhone;
	}

	public void setOperatorPhone(String operatorPhone) {
		this.operatorPhone = operatorPhone;
	}

	public String getOperatorIdnumber() {
		return this.operatorIdnumber;
	}

	public void setOperatorIdnumber(String operatorIdnumber) {
		this.operatorIdnumber = operatorIdnumber;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getUtinFoundDate() {
		return this.utinFoundDate;
	}

	public void setUtinFoundDate(Date utinFoundDate) {
		this.utinFoundDate = utinFoundDate;
	}

	public Date getUtinOpenDate() {
		return this.utinOpenDate;
	}

	public void setUtinOpenDate(Date utinOpenDate) {
		this.utinOpenDate = utinOpenDate;
	}

	public String getAdmissibleNetwork() {
		return this.admissibleNetwork;
	}

	public void setAdmissibleNetwork(String admissibleNetwork) {
		this.admissibleNetwork = admissibleNetwork;
	}

	public Set getUtinaccountinfos() {
		return this.utinaccountinfos;
	}

	public void setUtinaccountinfos(Set utinaccountinfos) {
		this.utinaccountinfos = utinaccountinfos;
	}

}