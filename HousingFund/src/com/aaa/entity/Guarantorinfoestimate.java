package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Guarantorinfoestimate entity. @author MyEclipse Persistence Tools
 */
   //担保人信息评估
public class Guarantorinfoestimate implements java.io.Serializable {
	// Fields
	private Integer guaraInfoEstId;
	private String guarantorUtin;//担保人所在单位
	private String guarantorPost;//工作岗位
	private Float guarantorYearIncome;//月收入
	private Integer repaymentAbility;//还款能力系数
	private Float guarantorFundAssess;//资产评估
	private String remarks;//备注信息
	private Set guarantorinfos = new HashSet(0);//担保人

	// Constructors

	/** default constructor */
	public Guarantorinfoestimate() {
	}

	/** full constructor */
	public Guarantorinfoestimate(String guarantorUtin, String guarantorPost,
			Float guarantorYearIncome, Integer repaymentAbility,
			Float guarantorFundAssess, String remarks, Set guarantorinfos) {
		this.guarantorUtin = guarantorUtin;
		this.guarantorPost = guarantorPost;
		this.guarantorYearIncome = guarantorYearIncome;
		this.repaymentAbility = repaymentAbility;
		this.guarantorFundAssess = guarantorFundAssess;
		this.remarks = remarks;
		this.guarantorinfos = guarantorinfos;
	}

	// Property accessors

	public Integer getGuaraInfoEstId() {
		return this.guaraInfoEstId;
	}

	public void setGuaraInfoEstId(Integer guaraInfoEstId) {
		this.guaraInfoEstId = guaraInfoEstId;
	}

	public String getGuarantorUtin() {
		return this.guarantorUtin;
	}

	public void setGuarantorUtin(String guarantorUtin) {
		this.guarantorUtin = guarantorUtin;
	}

	public String getGuarantorPost() {
		return this.guarantorPost;
	}

	public void setGuarantorPost(String guarantorPost) {
		this.guarantorPost = guarantorPost;
	}

	public Float getGuarantorYearIncome() {
		return this.guarantorYearIncome;
	}

	public void setGuarantorYearIncome(Float guarantorYearIncome) {
		this.guarantorYearIncome = guarantorYearIncome;
	}

	public Integer getRepaymentAbility() {
		return this.repaymentAbility;
	}

	public void setRepaymentAbility(Integer repaymentAbility) {
		this.repaymentAbility = repaymentAbility;
	}

	public Float getGuarantorFundAssess() {
		return this.guarantorFundAssess;
	}

	public void setGuarantorFundAssess(Float guarantorFundAssess) {
		this.guarantorFundAssess = guarantorFundAssess;
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

}