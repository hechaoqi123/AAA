package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Coborrower entity. @author MyEclipse Persistence Tools
 */
//共同借款人
public class Coborrower implements java.io.Serializable {

	// Fields

	private Integer coborrowerId;
	private String coborrowerAccount;//共同借款人账户
	private String coborrowerName;//姓名
	private String coborrowerPhone;//手机号
	private String coborrowerAddress;//地址
	private String coborrowerUtinName;//单位名称
	private String coborrowerIdno;//身份证号
	private Float coborrowerMonthMoney;//月收入
	private String relation;//与借款人关系
	private Set loanapplications = new HashSet(0);//借款申请书

	// Constructors

	/** default constructor */
	public Coborrower() {
	}

	/** full constructor */
	public Coborrower(String coborrowerAccount, String coborrowerName,
			String coborrowerPhone, String coborrowerAddress,
			String coborrowerUtinName, String coborrowerIdno,
			Float coborrowerMonthMoney, String relation, Set loanapplications) {
		this.coborrowerAccount = coborrowerAccount;
		this.coborrowerName = coborrowerName;
		this.coborrowerPhone = coborrowerPhone;
		this.coborrowerAddress = coborrowerAddress;
		this.coborrowerUtinName = coborrowerUtinName;
		this.coborrowerIdno = coborrowerIdno;
		this.coborrowerMonthMoney = coborrowerMonthMoney;
		this.relation = relation;
		this.loanapplications = loanapplications;
	}

	// Property accessors

	public Integer getCoborrowerId() {
		return this.coborrowerId;
	}

	public void setCoborrowerId(Integer coborrowerId) {
		this.coborrowerId = coborrowerId;
	}

	public String getCoborrowerAccount() {
		return this.coborrowerAccount;
	}

	public void setCoborrowerAccount(String coborrowerAccount) {
		this.coborrowerAccount = coborrowerAccount;
	}

	public String getCoborrowerName() {
		return this.coborrowerName;
	}

	public void setCoborrowerName(String coborrowerName) {
		this.coborrowerName = coborrowerName;
	}

	public String getCoborrowerPhone() {
		return this.coborrowerPhone;
	}

	public void setCoborrowerPhone(String coborrowerPhone) {
		this.coborrowerPhone = coborrowerPhone;
	}

	public String getCoborrowerAddress() {
		return this.coborrowerAddress;
	}

	public void setCoborrowerAddress(String coborrowerAddress) {
		this.coborrowerAddress = coborrowerAddress;
	}

	public String getCoborrowerUtinName() {
		return this.coborrowerUtinName;
	}

	public void setCoborrowerUtinName(String coborrowerUtinName) {
		this.coborrowerUtinName = coborrowerUtinName;
	}

	public String getCoborrowerIdno() {
		return this.coborrowerIdno;
	}

	public void setCoborrowerIdno(String coborrowerIdno) {
		this.coborrowerIdno = coborrowerIdno;
	}

	public Float getCoborrowerMonthMoney() {
		return this.coborrowerMonthMoney;
	}

	public void setCoborrowerMonthMoney(Float coborrowerMonthMoney) {
		this.coborrowerMonthMoney = coborrowerMonthMoney;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Set getLoanapplications() {
		return this.loanapplications;
	}

	public void setLoanapplications(Set loanapplications) {
		this.loanapplications = loanapplications;
	}

}