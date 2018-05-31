package com.aaa.entity;

/**
 * Fundtranreco entity. @author MyEclipse Persistence Tools
 */

public class Fundtranreco implements java.io.Serializable {

	// Fields

	private Integer tranRecoId;
	private String hostAccount;
	private String seconAccount;

	// Constructors

	/** default constructor */
	public Fundtranreco() {
	}

	/** full constructor */
	public Fundtranreco(String hostAccount, String seconAccount) {
		this.hostAccount = hostAccount;
		this.seconAccount = seconAccount;
	}

	// Property accessors

	public Integer getTranRecoId() {
		return this.tranRecoId;
	}

	public void setTranRecoId(Integer tranRecoId) {
		this.tranRecoId = tranRecoId;
	}

	public String getHostAccount() {
		return this.hostAccount;
	}

	public void setHostAccount(String hostAccount) {
		this.hostAccount = hostAccount;
	}

	public String getSeconAccount() {
		return this.seconAccount;
	}

	public void setSeconAccount(String seconAccount) {
		this.seconAccount = seconAccount;
	}

}