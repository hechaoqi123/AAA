package com.aaa.entity;

import java.util.Date;


/**
 * Supdetailed entity. @author MyEclipse Persistence Tools
 */

//单位补缴信息清册
public class Supdetailed implements java.io.Serializable {
	// Fields
	private Integer supDetailedId;
	private Utinsupapply utinsupapply;//补缴申请表
	private String employeeName;//员工姓名
	private Float supMoney;//补缴金额
	private Integer supMonth;//补缴月份
	private Float supRadices;//基数
	private String supDate;//补缴日期
	private Indaccountinfo indaccountinfo;
	private Float indDepositRatio;

	// Constructors

	/** default constructor */
	public Supdetailed() {
	}

	/** full constructor */
	public Supdetailed(Utinsupapply utinsupapply,
			Indaccountinfo indaccountinfo, String employeeName, Float supMoney,
			Integer supMonth, Float supRadices, String supDate,
			Float indDepositRatio) {
		this.utinsupapply = utinsupapply;
		this.indaccountinfo = indaccountinfo;
		this.employeeName = employeeName;
		this.supMoney = supMoney;
		this.supMonth = supMonth;
		this.supRadices = supRadices;
		this.supDate = supDate;
		this.indDepositRatio = indDepositRatio;
	}

	// Property accessors

	public Integer getSupDetailedId() {
		return this.supDetailedId;
	}

	public void setSupDetailedId(Integer supDetailedId) {
		this.supDetailedId = supDetailedId;
	}

	public Utinsupapply getUtinsupapply() {
		return this.utinsupapply;
	}

	public void setUtinsupapply(Utinsupapply utinsupapply) {
		this.utinsupapply = utinsupapply;
	}

	public Indaccountinfo getIndaccountinfo() {
		return this.indaccountinfo;
	}

	public void setIndaccountinfo(Indaccountinfo indaccountinfo) {
		this.indaccountinfo = indaccountinfo;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Float getSupMoney() {
		return this.supMoney;
	}

	public void setSupMoney(Float supMoney) {
		this.supMoney = supMoney;
	}

	public Integer getSupMonth() {
		return this.supMonth;
	}

	public void setSupMonth(Integer supMonth) {
		this.supMonth = supMonth;
	}

	public Float getSupRadices() {
		return this.supRadices;
	}

	public void setSupRadices(Float supRadices) {
		this.supRadices = supRadices;
	}

	public String getSupDate() {
		return this.supDate;
	}

	public void setSupDate(String supDate) {
		this.supDate = supDate;
	}

	public Float getIndDepositRatio() {
		return this.indDepositRatio;
	}

	public void setIndDepositRatio(Float indDepositRatio) {
		this.indDepositRatio = indDepositRatio;
	}

}