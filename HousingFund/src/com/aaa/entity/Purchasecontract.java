package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Purchasecontract entity. @author MyEclipse Persistence Tools
 */
//购房合同
public class Purchasecontract implements java.io.Serializable {

	// Fields

	private Integer purchaseContractId;
	private Purchasedhinfo purchasedhinfo;//房屋信息
	private Materialtype materialtype;//材料类型
	private String salesPersonName;//售房人姓名
	private String homeBuyersName;//购房人姓名
	private String salesPersonPhone;//售房人银行账户
	private String homeBuyersPhone;//购房人身份证号
	private String treatycCntents;//已付金额
	private Set loanapplications = new HashSet(0);//  //住房公积金借款申请书

	// Constructors

	/** default constructor */
	public Purchasecontract() {
	}

	/** full constructor */
	public Purchasecontract(Purchasedhinfo purchasedhinfo,
			Materialtype materialtype, String salesPersonName,
			String homeBuyersName, String salesPersonPhone,
			String homeBuyersPhone, String treatycCntents, Set loanapplications) {
		this.purchasedhinfo = purchasedhinfo;
		this.materialtype = materialtype;
		this.salesPersonName = salesPersonName;
		this.homeBuyersName = homeBuyersName;
		this.salesPersonPhone = salesPersonPhone;
		this.homeBuyersPhone = homeBuyersPhone;
		this.treatycCntents = treatycCntents;
		this.loanapplications = loanapplications;
	}

	// Property accessors

	public Integer getPurchaseContractId() {
		return this.purchaseContractId;
	}

	public void setPurchaseContractId(Integer purchaseContractId) {
		this.purchaseContractId = purchaseContractId;
	}

	public Purchasedhinfo getPurchasedhinfo() {
		return this.purchasedhinfo;
	}

	public void setPurchasedhinfo(Purchasedhinfo purchasedhinfo) {
		this.purchasedhinfo = purchasedhinfo;
	}

	public Materialtype getMaterialtype() {
		return this.materialtype;
	}

	public void setMaterialtype(Materialtype materialtype) {
		this.materialtype = materialtype;
	}

	public String getSalesPersonName() {
		return this.salesPersonName;
	}

	public void setSalesPersonName(String salesPersonName) {
		this.salesPersonName = salesPersonName;
	}

	public String getHomeBuyersName() {
		return this.homeBuyersName;
	}

	public void setHomeBuyersName(String homeBuyersName) {
		this.homeBuyersName = homeBuyersName;
	}

	public String getSalesPersonPhone() {
		return this.salesPersonPhone;
	}

	public void setSalesPersonPhone(String salesPersonPhone) {
		this.salesPersonPhone = salesPersonPhone;
	}

	public String getHomeBuyersPhone() {
		return this.homeBuyersPhone;
	}

	public void setHomeBuyersPhone(String homeBuyersPhone) {
		this.homeBuyersPhone = homeBuyersPhone;
	}

	public String getTreatycCntents() {
		return this.treatycCntents;
	}

	public void setTreatycCntents(String treatycCntents) {
		this.treatycCntents = treatycCntents;
	}

	public Set getLoanapplications() {
		return this.loanapplications;
	}

	public void setLoanapplications(Set loanapplications) {
		this.loanapplications = loanapplications;
	}

}