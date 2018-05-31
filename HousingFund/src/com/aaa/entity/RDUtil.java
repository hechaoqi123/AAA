package com.aaa.entity;

public class RDUtil {

	//个人账户ID
	private Integer indAccountId;
	//个人月缴存额    
	private Float peMonthDep;
	//可取现余额  usableRem=usableRem+PayinSumMoney*2
	private Float usableRem;
	//当前总余额   presentSumRem=presentSumRem+PayinSumMoney*2
	private Float presentSumRem;
	//个人明细表 汇缴总金额  本月缴存总金额 *2
	private Float payinSumMoney;
	//个人身份证号
	private String iDNumber;
	//单位ID
	private Integer utinAccountId;
	//单位汇缴人数
	private Integer depositPeople;
	//单位名称
	private String utinName;
	//单位汇缴总金额
	private Float summoney;
	//汇缴起始日期
	private String oridate;
	//最终日期 
	private String finaldate;
	//汇缴总月数
	private String remonth;
	//制单人
	private String adminname;
	//账户余额
	private Double utinprovrema;
	
	public Integer getIndAccountId() {
		return indAccountId;
	}
	public void setIndAccountId(Integer indAccountId) {
		this.indAccountId = indAccountId;
	}
	public Float getPeMonthDep() {
		return peMonthDep;
	}
	public void setPeMonthDep(Float peMonthDep) {
		this.peMonthDep = peMonthDep;
	}
	public Float getUsableRem() {
		return usableRem;
	}
	public void setUsableRem(Float usableRem) {
		this.usableRem = usableRem;
	}
	public Float getPresentSumRem() {
		return presentSumRem;
	}
	public void setPresentSumRem(Float presentSumRem) {
		this.presentSumRem = presentSumRem;
	}
	public Float getPayinSumMoney() {
		return payinSumMoney;
	}
	public void setPayinSumMoney(Float payinSumMoney) {
		this.payinSumMoney = payinSumMoney;
	}
	public String getiDNumber() {
		return iDNumber;
	}
	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}
	public Integer getUtinAccountId() {
		return utinAccountId;
	}
	public void setUtinAccountId(Integer utinAccountId) {
		this.utinAccountId = utinAccountId;
	}
	public Integer getDepositPeople() {
		return depositPeople;
	}
	public void setDepositPeople(Integer depositPeople) {
		this.depositPeople = depositPeople;
	}
	public String getUtinName() {
		return utinName;
	}
	public void setUtinName(String utinName) {
		this.utinName = utinName;
	}
	public Float getSummoney() {
		return summoney;
	}
	public void setSummoney(Float summoney) {
		this.summoney = summoney;
	}
	public String getOridate() {
		return oridate;
	}
	public void setOridate(String oridate) {
		this.oridate = oridate;
	}
	public String getFinaldate() {
		return finaldate;
	}
	public void setFinaldate(String finaldate) {
		this.finaldate = finaldate;
	}
	public String getRemonth() {
		return remonth;
	}
	public void setRemonth(String remonth) {
		this.remonth = remonth;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public Double getUtinprovrema() {
		return utinprovrema;
	}
	public void setUtinprovrema(Double utinprovrema) {
		this.utinprovrema = utinprovrema;
	}
	
	
	

	
}
