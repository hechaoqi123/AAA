package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Useoffunds entity. @author MyEclipse Persistence Tools
 */
   //所购房屋类型
public class Useoffunds implements java.io.Serializable {

	// Fields

	private Integer useOfFundsId;
	private String useDescription;//房屋类型
	private String remarkInfo;//备注信息
	private Set loanapplications = new HashSet(0);//借款申请书

	// Constructors

	/** default constructor */
	public Useoffunds() {
	}

	/** full constructor */
	public Useoffunds(String useDescription, String remarkInfo,
			Set loanapplications) {
		this.useDescription = useDescription;
		this.remarkInfo = remarkInfo;
		this.loanapplications = loanapplications;
	}

	// Property accessors

	public Integer getUseOfFundsId() {
		return this.useOfFundsId;
	}

	public void setUseOfFundsId(Integer useOfFundsId) {
		this.useOfFundsId = useOfFundsId;
	}

	public String getUseDescription() {
		return this.useDescription;
	}

	public void setUseDescription(String useDescription) {
		this.useDescription = useDescription;
	}

	public String getRemarkInfo() {
		return this.remarkInfo;
	}

	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}

	public Set getLoanapplications() {
		return this.loanapplications;
	}

	public void setLoanapplications(Set loanapplications) {
		this.loanapplications = loanapplications;
	}

}