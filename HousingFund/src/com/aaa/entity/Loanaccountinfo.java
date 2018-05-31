package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Loanaccountinfo entity. @author MyEclipse Persistence Tools
 */
  //个人住房贷款账户信息
public class Loanaccountinfo implements java.io.Serializable {

	// Fields

	private Integer loanAccountInfoId;
	private Float loanDisbur;//贷款发放额（所贷金额）
	private Date loanDate;//贷款发放日期
	private Float loanRate;//贷款利率
	private Integer loanPeriod;//贷款期数
	private String currentPlan;//当前还款计划编号
	private Float currentShouldMoney;//当前还款计划应还金额
	private Float totalInterestRecovered;//应回收利息总额
	private String guaranteeMode;//备注（驳回原因）
	private String remarks;//申请书编号
	private Set guarantorinfos = new HashSet(0);//担保人
	private Set collateralinfos = new HashSet(0);//抵押物信息
	//util
	public Guarantorinfo getGuarantorinfo(){
		  if(guarantorinfos!=null){
			  for(Object obj : guarantorinfos){
					return (Guarantorinfo) obj;
				} 
		  }
		return null;
	}
	public Collateralinfo getCollateralinfo(){
		System.out.println(collateralinfos.size());
		if(collateralinfos!=null){
			for(Object obj : collateralinfos){
				System.out.println(((Collateralinfo)obj).getPawnValueEsti());
				return (Collateralinfo) obj;
			}
		}
		return null;
	}
   
	// Constructors

	/** default constructor */
	public Loanaccountinfo() {
	}

	/** full constructor */
	public Loanaccountinfo(Float loanDisbur, Date loanDate, Float loanRate,
			Integer loanPeriod, Float currentShouldMoney, String currentPlan,
			Float totalInterestRecovered, String guaranteeMode, String remarks,
			Set guarantorinfos, Set collateralinfos) {
		this.loanDisbur = loanDisbur;
		this.loanDate = loanDate;
		this.loanRate = loanRate;
		this.loanPeriod = loanPeriod;
		this.currentShouldMoney = currentShouldMoney;
		this.currentPlan = currentPlan;
		this.totalInterestRecovered = totalInterestRecovered;
		this.guaranteeMode = guaranteeMode;
		this.remarks = remarks;
		this.guarantorinfos = guarantorinfos;
		this.collateralinfos = collateralinfos;
	}
	// Property accessors

	public Integer getLoanAccountInfoId() {
		return this.loanAccountInfoId;
	}

	public void setLoanAccountInfoId(Integer loanAccountInfoId) {
		this.loanAccountInfoId = loanAccountInfoId;
	}

	public Float getLoanDisbur() {
		return this.loanDisbur;
	}

	public void setLoanDisbur(Float loanDisbur) {
		this.loanDisbur = loanDisbur;
	}

	public Date getLoanDate() {
		return this.loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Float getLoanRate() {
		return this.loanRate;
	}

	public void setLoanRate(Float loanRate) {
		this.loanRate = loanRate;
	}

	public Integer getLoanPeriod() {
		return this.loanPeriod;
	}

	public void setLoanPeriod(Integer loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public Float getCurrentShouldMoney() {
		return this.currentShouldMoney;
	}

	public void setCurrentShouldMoney(Float currentShouldMoney) {
		this.currentShouldMoney = currentShouldMoney;
	}

	public String getCurrentPlan() {
		return this.currentPlan;
	}

	public void setCurrentPlan(String currentPlan) {
		this.currentPlan = currentPlan;
	}

	public Float getTotalInterestRecovered() {
		return this.totalInterestRecovered;
	}

	public void setTotalInterestRecovered(Float totalInterestRecovered) {
		this.totalInterestRecovered = totalInterestRecovered;
	}

	public String getGuaranteeMode() {
		return this.guaranteeMode;
	}

	public void setGuaranteeMode(String guaranteeMode) {
		this.guaranteeMode = guaranteeMode;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getGuarantorinfos() {
		return this.guarantorinfos;
	}

	public void setGuarantorinfos(Set guarantorinfos) {
		this.guarantorinfos = guarantorinfos;
	}

	public Set getCollateralinfos() {
		return this.collateralinfos;
	}

	public void setCollateralinfos(Set collateralinfos) {
		this.collateralinfos = collateralinfos;
	}

}