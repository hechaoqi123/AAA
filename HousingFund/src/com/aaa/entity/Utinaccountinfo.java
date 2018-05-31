package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Utinaccountinfo entity. @author MyEclipse Persistence Tools
 */

public class Utinaccountinfo implements java.io.Serializable {

	// Fields

	private Integer utinAccountId;
	private Unitinfo unitinfo;
	private String accountStatus;
	private Double utinDepositRatio;
	private Integer utinSumPeople;
	private Integer utinDepositPeople;
	private Integer utinSealPeople;
	private Double utinProvRema;
	private String utinPayinWay;
	private String utinAccountPass;
	private String utinName;
	private Set utinsupapplies = new HashSet(0);
	private Set remittancedetails = new HashSet(0);
	private Set indaccountinfos = new HashSet(0);
	private Set utinremittancedetails = new HashSet(0);
	private Set flupaies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Utinaccountinfo() {
	}

	/** full constructor */
	public Utinaccountinfo(Unitinfo unitinfo, String accountStatus,
			Double utinDepositRatio, Integer utinSumPeople,
			Integer utinDepositPeople, Integer utinSealPeople,
			Double utinProvRema, String utinPayinWay, String utinAccountPass,
			String utinName, Set utinsupapplies, Set remittancedetails,
			Set indaccountinfos, Set utinremittancedetails, Set flupaies) {
		this.unitinfo = unitinfo;
		this.accountStatus = accountStatus;
		this.utinDepositRatio = utinDepositRatio;
		this.utinSumPeople = utinSumPeople;
		this.utinDepositPeople = utinDepositPeople;
		this.utinSealPeople = utinSealPeople;
		this.utinProvRema = utinProvRema;
		this.utinPayinWay = utinPayinWay;
		this.utinAccountPass = utinAccountPass;
		this.utinName = utinName;
		this.utinsupapplies = utinsupapplies;
		this.remittancedetails = remittancedetails;
		this.indaccountinfos = indaccountinfos;
		this.utinremittancedetails = utinremittancedetails;
		this.flupaies = flupaies;
	}

	// Property accessors

	public Integer getUtinAccountId() {
		return this.utinAccountId;
	}

	public void setUtinAccountId(Integer utinAccountId) {
		this.utinAccountId = utinAccountId;
	}

	public Unitinfo getUnitinfo() {
		return this.unitinfo;
	}

	public void setUnitinfo(Unitinfo unitinfo) {
		this.unitinfo = unitinfo;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Double getUtinDepositRatio() {
		return this.utinDepositRatio;
	}

	public void setUtinDepositRatio(Double utinDepositRatio) {
		this.utinDepositRatio = utinDepositRatio;
	}

	public Integer getUtinSumPeople() {
		return this.utinSumPeople;
	}

	public void setUtinSumPeople(Integer utinSumPeople) {
		this.utinSumPeople = utinSumPeople;
	}

	public Integer getUtinDepositPeople() {
		return this.utinDepositPeople;
	}

	public void setUtinDepositPeople(Integer utinDepositPeople) {
		this.utinDepositPeople = utinDepositPeople;
	}

	public Integer getUtinSealPeople() {
		return this.utinSealPeople;
	}

	public void setUtinSealPeople(Integer utinSealPeople) {
		this.utinSealPeople = utinSealPeople;
	}

	public Double getUtinProvRema() {
		return this.utinProvRema;
	}

	public void setUtinProvRema(Double utinProvRema) {
		this.utinProvRema = utinProvRema;
	}

	public String getUtinPayinWay() {
		return this.utinPayinWay;
	}

	public void setUtinPayinWay(String utinPayinWay) {
		this.utinPayinWay = utinPayinWay;
	}

	public String getUtinAccountPass() {
		return this.utinAccountPass;
	}

	public void setUtinAccountPass(String utinAccountPass) {
		this.utinAccountPass = utinAccountPass;
	}

	public String getUtinName() {
		return this.utinName;
	}

	public void setUtinName(String utinName) {
		this.utinName = utinName;
	}

	public Set getUtinsupapplies() {
		return this.utinsupapplies;
	}

	public void setUtinsupapplies(Set utinsupapplies) {
		this.utinsupapplies = utinsupapplies;
	}

	public Set getRemittancedetails() {
		return this.remittancedetails;
	}

	public void setRemittancedetails(Set remittancedetails) {
		this.remittancedetails = remittancedetails;
	}

	public Set getIndaccountinfos() {
		return this.indaccountinfos;
	}

	public void setIndaccountinfos(Set indaccountinfos) {
		this.indaccountinfos = indaccountinfos;
	}

	public Set getUtinremittancedetails() {
		return this.utinremittancedetails;
	}

	public void setUtinremittancedetails(Set utinremittancedetails) {
		this.utinremittancedetails = utinremittancedetails;
	}

	public Set getFlupaies() {
		return this.flupaies;
	}

	public void setFlupaies(Set flupaies) {
		this.flupaies = flupaies;
	}

}