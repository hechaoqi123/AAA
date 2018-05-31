package com.aaa.entity;

/**
 * Repayprincprove entity. @author MyEclipse Persistence Tools
 */
  //偿还本息证明
public class Repayprincprove implements java.io.Serializable {

	// Fields

	private Integer repayPrincProveId;
	private Materialtype materialtype;   //材料类型表
	private String loanAgreement;//贷款合同编号
	private Float amountMoney;//当期应还金额
	private String marriageCertificate;//夫妻关系证明

	// Constructors

	/** default constructor */
	public Repayprincprove() {
	}

	/** full constructor */
	public Repayprincprove(Materialtype materialtype, String loanAgreement,
			Float amountMoney, String marriageCertificate) {
		this.materialtype = materialtype;
		this.loanAgreement = loanAgreement;
		this.amountMoney = amountMoney;
		this.marriageCertificate = marriageCertificate;
	}

	// Property accessors

	public Integer getRepayPrincProveId() {
		return this.repayPrincProveId;
	}

	public void setRepayPrincProveId(Integer repayPrincProveId) {
		this.repayPrincProveId = repayPrincProveId;
	}

	public Materialtype getMaterialtype() {
		return this.materialtype;
	}

	public void setMaterialtype(Materialtype materialtype) {
		this.materialtype = materialtype;
	}

	public String getLoanAgreement() {
		return this.loanAgreement;
	}

	public void setLoanAgreement(String loanAgreement) {
		this.loanAgreement = loanAgreement;
	}

	public Float getAmountMoney() {
		return this.amountMoney;
	}

	public void setAmountMoney(Float amountMoney) {
		this.amountMoney = amountMoney;
	}

	public String getMarriageCertificate() {
		return this.marriageCertificate;
	}

	public void setMarriageCertificate(String marriageCertificate) {
		this.marriageCertificate = marriageCertificate;
	}

}