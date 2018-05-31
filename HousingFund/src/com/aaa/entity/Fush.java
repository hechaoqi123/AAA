package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Fush entity. @author MyEclipse Persistence Tools
 */
  //冲贷业务
public class Fush implements java.io.Serializable {

	// Fields

	private Integer id;
	private Borrowmoneyagreement borrowmoneyagreement;//借贷合同
	private String iphone;//手机号
	private String number;//银行卡号
	private String status;//状态
	private Set logs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Fush() {
	}

	/** minimal constructor */
	public Fush(Borrowmoneyagreement borrowmoneyagreement) {
		this.borrowmoneyagreement = borrowmoneyagreement;
	}

	/** full constructor */
	public Fush(Borrowmoneyagreement borrowmoneyagreement, String iphone,
			String number, String status, Set logs) {
		this.borrowmoneyagreement = borrowmoneyagreement;
		this.iphone = iphone;
		this.number = number;
		this.status = status;
		this.logs = logs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Borrowmoneyagreement getBorrowmoneyagreement() {
		return this.borrowmoneyagreement;
	}

	public void setBorrowmoneyagreement(
			Borrowmoneyagreement borrowmoneyagreement) {
		this.borrowmoneyagreement = borrowmoneyagreement;
	}

	public String getIphone() {
		return this.iphone;
	}

	public void setIphone(String iphone) {
		this.iphone = iphone;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getLogs() {
		return this.logs;
	}

	public void setLogs(Set logs) {
		this.logs = logs;
	}

}