package com.aaa.entity;

/**
 * Utinremittancedetail entity. @author MyEclipse Persistence Tools
 */

public class Utinremittancedetail implements java.io.Serializable {

	// Fields

	private Integer utinRdid;
	private Utinaccountinfo utinaccountinfo;//单位id
	private String utinName;//单位名称
	private Double payinSumMoney;//汇缴总金额
	private Integer depositPeople;//汇缴人数
	private String depositDate;//汇缴时间

	private String adminname;//制单人
	private String remonth;//汇缴月数
	private String finaldate;//最终日期
	private String oridate;//起始日期
	// Constructors

	/** default constructor */
	public Utinremittancedetail() {
	}

	/** full constructor */
	public Utinremittancedetail(Utinaccountinfo utinaccountinfo,
			String utinName, Double payinSumMoney, Integer depositPeople,
			String depositDate) {
		this.utinaccountinfo = utinaccountinfo;
		this.utinName = utinName;
		this.payinSumMoney = payinSumMoney;
		this.depositPeople = depositPeople;
		this.depositDate = depositDate;
	}

	// Property accessors

	public Integer getUtinRdid() {
		return this.utinRdid;
	}

	public Utinremittancedetail(Integer utinRdid,
			Utinaccountinfo utinaccountinfo, String utinName,
			Double payinSumMoney, Integer depositPeople, String depositDate,
			String adminname, String remonth, String finaldate, String oridate) {
		super();
		this.utinRdid = utinRdid;
		this.utinaccountinfo = utinaccountinfo;
		this.utinName = utinName;
		this.payinSumMoney = payinSumMoney;
		this.depositPeople = depositPeople;
		this.depositDate = depositDate;
		this.adminname = adminname;
		this.remonth = remonth;
		this.finaldate = finaldate;
		this.oridate = oridate;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getRemonth() {
		return remonth;
	}

	public void setRemonth(String remonth) {
		this.remonth = remonth;
	}

	public String getFinaldate() {
		return finaldate;
	}

	public void setFinaldate(String finaldate) {
		this.finaldate = finaldate;
	}

	public String getOridate() {
		return oridate;
	}

	public void setOridate(String oridate) {
		this.oridate = oridate;
	}

	public void setUtinRdid(Integer utinRdid) {
		this.utinRdid = utinRdid;
	}

	public Utinaccountinfo getUtinaccountinfo() {
		return this.utinaccountinfo;
	}

	public void setUtinaccountinfo(Utinaccountinfo utinaccountinfo) {
		this.utinaccountinfo = utinaccountinfo;
	}

	public String getUtinName() {
		return this.utinName;
	}

	public void setUtinName(String utinName) {
		this.utinName = utinName;
	}

	public Double getPayinSumMoney() {
		return this.payinSumMoney;
	}

	public void setPayinSumMoney(Double payinSumMoney) {
		this.payinSumMoney = payinSumMoney;
	}

	public Integer getDepositPeople() {
		return this.depositPeople;
	}

	public void setDepositPeople(Integer depositPeople) {
		this.depositPeople = depositPeople;
	}

	public String getDepositDate() {
		return this.depositDate;
	}

	public void setDepositDate(String depositDate) {
		this.depositDate = depositDate;
	}

}