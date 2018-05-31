package com.aaa.entity;

import java.util.Date;

/**
 * Mpfacentrestat entity. @author MyEclipse Persistence Tools
 */
   //积金中心统计
public class Mpfacentrestat implements java.io.Serializable {

	// Fields

	private Integer mpfacentreStatId;
	private Float aggregateSumStat;//归集金额统计
	private Float withdrawalSumStat;//提取金额统计
	private Float loanAmountStat;//贷款金额统计
	private Float recoveryLoanStat;//还款金额统计
	private Integer unitAccountOpenStat;//单位开户统计
	private Integer individualAccountStat;//个人开户统计
	private Date statisticalTime;//统计时间
	private Integer status;//状态 ：失效  正常

	// Constructors

	/** default constructor */
	public Mpfacentrestat() {
	}

	/** full constructor */
	public Mpfacentrestat(Float aggregateSumStat, Float withdrawalSumStat,
			Float loanAmountStat, Float recoveryLoanStat,
			Integer unitAccountOpenStat, Integer individualAccountStat,
			Date statisticalTime, Integer status) {
		this.aggregateSumStat = aggregateSumStat;
		this.withdrawalSumStat = withdrawalSumStat;
		this.loanAmountStat = loanAmountStat;
		this.recoveryLoanStat = recoveryLoanStat;
		this.unitAccountOpenStat = unitAccountOpenStat;
		this.individualAccountStat = individualAccountStat;
		this.statisticalTime = statisticalTime;
		this.status = status;
	}

	// Property accessors

	public Integer getMpfacentreStatId() {
		return this.mpfacentreStatId;
	}

	public void setMpfacentreStatId(Integer mpfacentreStatId) {
		this.mpfacentreStatId = mpfacentreStatId;
	}

	public Float getAggregateSumStat() {
		return this.aggregateSumStat;
	}

	public void setAggregateSumStat(Float aggregateSumStat) {
		this.aggregateSumStat = aggregateSumStat;
	}

	public Float getWithdrawalSumStat() {
		return this.withdrawalSumStat;
	}

	public void setWithdrawalSumStat(Float withdrawalSumStat) {
		this.withdrawalSumStat = withdrawalSumStat;
	}

	public Float getLoanAmountStat() {
		return this.loanAmountStat;
	}

	public void setLoanAmountStat(Float loanAmountStat) {
		this.loanAmountStat = loanAmountStat;
	}

	public Float getRecoveryLoanStat() {
		return this.recoveryLoanStat;
	}

	public void setRecoveryLoanStat(Float recoveryLoanStat) {
		this.recoveryLoanStat = recoveryLoanStat;
	}

	public Integer getUnitAccountOpenStat() {
		return this.unitAccountOpenStat;
	}

	public void setUnitAccountOpenStat(Integer unitAccountOpenStat) {
		this.unitAccountOpenStat = unitAccountOpenStat;
	}

	public Integer getIndividualAccountStat() {
		return this.individualAccountStat;
	}

	public void setIndividualAccountStat(Integer individualAccountStat) {
		this.individualAccountStat = individualAccountStat;
	}

	public Date getStatisticalTime() {
		return this.statisticalTime;
	}

	public void setStatisticalTime(Date statisticalTime) {
		this.statisticalTime = statisticalTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}