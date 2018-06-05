package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Extractionandapproval entity. @author MyEclipse Persistence Tools
 */

public class Extractionandapproval implements java.io.Serializable {

	// Fields

	private Integer approvalNumberId;
	private Indaccountinfo indaccountinfo;
	private String indAccount;
	private Date applicationtime;
	private String workersName;
	private String bankOfDeposit;
	private String payee;
	private String collectionAccount;
	private String approvalStatus;//
	private Date approvalTime;
	private Double withdrawalAmount;
	private String exunitnum;
	private String exunitname;
	private String exdoctype;
	private String exidnum;
	private String indaccstatus;
	private String exsex;
	private String exage;
	private String exmodel;
	private String exphone;
	private Set extractdetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Extractionandapproval() {
	}

	/** full constructor */
	public Extractionandapproval(Indaccountinfo indaccountinfo,
			String indAccount, Date applicationtime, String workersName,
			String bankOfDeposit, String payee, String collectionAccount,
			String approvalStatus, Date approvalTime, Double withdrawalAmount,
			String exunitnum, String exunitname, String exdoctype,
			String exidnum, String indaccstatus, String exsex, String exage,
			String exmodel, String exphone, Set extractdetailses) {
		this.indaccountinfo = indaccountinfo;
		this.indAccount = indAccount;
		this.applicationtime = applicationtime;
		this.workersName = workersName;
		this.bankOfDeposit = bankOfDeposit;
		this.payee = payee;
		this.collectionAccount = collectionAccount;
		this.approvalStatus = approvalStatus;
		this.approvalTime = approvalTime;
		this.withdrawalAmount = withdrawalAmount;
		this.exunitnum = exunitnum;
		this.exunitname = exunitname;
		this.exdoctype = exdoctype;
		this.exidnum = exidnum;
		this.indaccstatus = indaccstatus;
		this.exsex = exsex;
		this.exage = exage;
		this.exmodel = exmodel;
		this.exphone = exphone;
		this.extractdetailses = extractdetailses;
	}

	// Property accessors

	public Integer getApprovalNumberId() {
		return this.approvalNumberId;
	}

	public void setApprovalNumberId(Integer approvalNumberId) {
		this.approvalNumberId = approvalNumberId;
	}

	public Indaccountinfo getIndaccountinfo() {
		return this.indaccountinfo;
	}

	public void setIndaccountinfo(Indaccountinfo indaccountinfo) {
		this.indaccountinfo = indaccountinfo;
	}

	public String getIndAccount() {
		return this.indAccount;
	}

	public void setIndAccount(String indAccount) {
		this.indAccount = indAccount;
	}

	public Date getApplicationtime() {
		return this.applicationtime;
	}

	public void setApplicationtime(Date applicationtime) {
		this.applicationtime = applicationtime;
	}

	public String getWorkersName() {
		return this.workersName;
	}

	public void setWorkersName(String workersName) {
		this.workersName = workersName;
	}

	public String getBankOfDeposit() {
		return this.bankOfDeposit;
	}

	public void setBankOfDeposit(String bankOfDeposit) {
		this.bankOfDeposit = bankOfDeposit;
	}

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getCollectionAccount() {
		return this.collectionAccount;
	}

	public void setCollectionAccount(String collectionAccount) {
		this.collectionAccount = collectionAccount;
	}

	public String getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Date getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public Double getWithdrawalAmount() {
		return this.withdrawalAmount;
	}

	public void setWithdrawalAmount(Double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public String getExunitnum() {
		return this.exunitnum;
	}

	public void setExunitnum(String exunitnum) {
		this.exunitnum = exunitnum;
	}

	public String getExunitname() {
		return this.exunitname;
	}

	public void setExunitname(String exunitname) {
		this.exunitname = exunitname;
	}

	public String getExdoctype() {
		return this.exdoctype;
	}

	public void setExdoctype(String exdoctype) {
		this.exdoctype = exdoctype;
	}

	public String getExidnum() {
		return this.exidnum;
	}

	public void setExidnum(String exidnum) {
		this.exidnum = exidnum;
	}

	public String getIndaccstatus() {
		return this.indaccstatus;
	}

	public void setIndaccstatus(String indaccstatus) {
		this.indaccstatus = indaccstatus;
	}

	public String getExsex() {
		return this.exsex;
	}

	public void setExsex(String exsex) {
		this.exsex = exsex;
	}

	public String getExage() {
		return this.exage;
	}

	public void setExage(String exage) {
		this.exage = exage;
	}

	public String getExmodel() {
		return this.exmodel;
	}

	public void setExmodel(String exmodel) {
		this.exmodel = exmodel;
	}

	public String getExphone() {
		return this.exphone;
	}

	public void setExphone(String exphone) {
		this.exphone = exphone;
	}

	public Set getExtractdetailses() {
		return this.extractdetailses;
	}

	public void setExtractdetailses(Set extractdetailses) {
		this.extractdetailses = extractdetailses;
	}

}