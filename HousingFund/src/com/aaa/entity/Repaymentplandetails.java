package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Repaymentplandetails entity. @author MyEclipse Persistence Tools
 */
//还款计划
public class Repaymentplandetails implements java.io.Serializable {
	// Fields
	private Integer repaymentPlanDetailsiId;
	private Overduerepayment overduerepayment;//逾期还款
	private Borrowmoneyagreement borrowmoneyagreement;//借款合同
	private String modeOfRepaymentSelect;//还款方式
	private Float currentReturnedCorpus;//当期本金
	private Float currentReturnedInterest;//当期利息
	private Float overduePrincipalAndInte=0F;//逾期罚息
	private Integer currentPeriod;//当前期数
	private Float amountOfRepayRecei;//应还金额
	private Float repaymentsReceived;//实收金额
	private String repaymentStatus;//还款状态
	private Date repaymentDate;//还款日期
	private Date repaymentDeadline;//还款截止日期
	private Set borrowmoneyagreements = new HashSet(0);

	// Constructors

	/** default constructor */
	public Repaymentplandetails() {
	}

	/** full constructor */
	public Repaymentplandetails(Overduerepayment overduerepayment,
			Borrowmoneyagreement borrowmoneyagreement,
			String modeOfRepaymentSelect, Float currentReturnedCorpus,
			Float currentReturnedInterest, Float overduePrincipalAndInte,
			Integer currentPeriod, Float amountOfRepayRecei,
			Float repaymentsReceived, String repaymentStatus,
			Date repaymentDate, Date repaymentDeadline,
			Set borrowmoneyagreements) {
		this.overduerepayment = overduerepayment;
		this.borrowmoneyagreement = borrowmoneyagreement;
		this.modeOfRepaymentSelect = modeOfRepaymentSelect;
		this.currentReturnedCorpus = currentReturnedCorpus;
		this.currentReturnedInterest = currentReturnedInterest;
		this.overduePrincipalAndInte = overduePrincipalAndInte;
		this.currentPeriod = currentPeriod;
		this.amountOfRepayRecei = amountOfRepayRecei;
		this.repaymentsReceived = repaymentsReceived;
		this.repaymentStatus = repaymentStatus;
		this.repaymentDate = repaymentDate;
		this.repaymentDeadline = repaymentDeadline;
		this.borrowmoneyagreements = borrowmoneyagreements;
	}

	// Property accessors

	public Integer getRepaymentPlanDetailsiId() {
		return this.repaymentPlanDetailsiId;
	}

	public void setRepaymentPlanDetailsiId(Integer repaymentPlanDetailsiId) {
		this.repaymentPlanDetailsiId = repaymentPlanDetailsiId;
	}

	public Overduerepayment getOverduerepayment() {
		return this.overduerepayment;
	}

	public void setOverduerepayment(Overduerepayment overduerepayment) {
		this.overduerepayment = overduerepayment;
	}

	public Borrowmoneyagreement getBorrowmoneyagreement() {
		return this.borrowmoneyagreement;
	}

	public void setBorrowmoneyagreement(
			Borrowmoneyagreement borrowmoneyagreement) {
		this.borrowmoneyagreement = borrowmoneyagreement;
	}

	public String getModeOfRepaymentSelect() {
		return this.modeOfRepaymentSelect;
	}

	public void setModeOfRepaymentSelect(String modeOfRepaymentSelect) {
		this.modeOfRepaymentSelect = modeOfRepaymentSelect;
	}

	public Float getCurrentReturnedCorpus() {
		return this.currentReturnedCorpus;
	}

	public void setCurrentReturnedCorpus(Float currentReturnedCorpus) {
		this.currentReturnedCorpus = currentReturnedCorpus;
	}

	public Float getCurrentReturnedInterest() {
		return this.currentReturnedInterest;
	}

	public void setCurrentReturnedInterest(Float currentReturnedInterest) {
		this.currentReturnedInterest = currentReturnedInterest;
	}

	public Float getOverduePrincipalAndInte() {
		return this.overduePrincipalAndInte;
	}

	public void setOverduePrincipalAndInte(Float overduePrincipalAndInte) {
		this.overduePrincipalAndInte = overduePrincipalAndInte;
	}

	public Integer getCurrentPeriod() {
		return this.currentPeriod;
	}

	public void setCurrentPeriod(Integer currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	public Float getAmountOfRepayRecei() {
		return this.amountOfRepayRecei;
	}

	public void setAmountOfRepayRecei(Float amountOfRepayRecei) {
		this.amountOfRepayRecei = amountOfRepayRecei;
	}

	public Float getRepaymentsReceived() {
		return this.repaymentsReceived;
	}

	public void setRepaymentsReceived(Float repaymentsReceived) {
		this.repaymentsReceived = repaymentsReceived;
	}

	public String getRepaymentStatus() {
		return this.repaymentStatus;
	}

	public void setRepaymentStatus(String repaymentStatus) {
		this.repaymentStatus = repaymentStatus;
	}

	public Date getRepaymentDate() {
		return this.repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public Date getRepaymentDeadline() {
		return this.repaymentDeadline;
	}

	public void setRepaymentDeadline(Date repaymentDeadline) {
		this.repaymentDeadline = repaymentDeadline;
	}

	public Set getBorrowmoneyagreements() {
		return this.borrowmoneyagreements;
	}

	public void setBorrowmoneyagreements(Set borrowmoneyagreements) {
		this.borrowmoneyagreements = borrowmoneyagreements;
	}

}