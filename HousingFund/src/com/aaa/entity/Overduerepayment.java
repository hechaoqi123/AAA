package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Overduerepayment entity. @author MyEclipse Persistence Tools
 */
  //逾期还款表
public class Overduerepayment implements java.io.Serializable {

	// Fields

	private Integer overdueRepaymentId;
	private Float returnedPriInt;//应还本息
	private Float defaultInterest;//罚息
	private Date repaymentDate;//还款日期
	private Set repaymentplandetailses = new HashSet(0);//还款详情

	// Constructors

	/** default constructor */
	public Overduerepayment() {
	}

	/** full constructor */
	public Overduerepayment(Float returnedPriInt, Float defaultInterest,
			Date repaymentDate, Set repaymentplandetailses) {
		this.returnedPriInt = returnedPriInt;
		this.defaultInterest = defaultInterest;
		this.repaymentDate = repaymentDate;
		this.repaymentplandetailses = repaymentplandetailses;
	}

	// Property accessors

	public Integer getOverdueRepaymentId() {
		return this.overdueRepaymentId;
	}

	public void setOverdueRepaymentId(Integer overdueRepaymentId) {
		this.overdueRepaymentId = overdueRepaymentId;
	}

	public Float getReturnedPriInt() {
		return this.returnedPriInt;
	}

	public void setReturnedPriInt(Float returnedPriInt) {
		this.returnedPriInt = returnedPriInt;
	}

	public Float getDefaultInterest() {
		return this.defaultInterest;
	}

	public void setDefaultInterest(Float defaultInterest) {
		this.defaultInterest = defaultInterest;
	}

	public Date getRepaymentDate() {
		return this.repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public Set getRepaymentplandetailses() {
		return this.repaymentplandetailses;
	}

	public void setRepaymentplandetailses(Set repaymentplandetailses) {
		this.repaymentplandetailses = repaymentplandetailses;
	}

}