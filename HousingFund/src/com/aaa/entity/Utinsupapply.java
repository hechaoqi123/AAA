package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Utinsupapply entity. @author MyEclipse Persistence Tools
 */

//单位补缴申请书
public class Utinsupapply implements java.io.Serializable {

	// Fields
	private Integer applyId;
	private Utinaccountinfo utinaccountinfo;//单位账户信息
	private String applyUtin;//单位名称
	private String utinOperator;//经办人
	private String supCause;//补缴原因
	private String applyDate;//申请时间
	private Double utinsupmoney;
	private String utinNmae;
	private String chequeId;
	private Integer supSumple;
	private Set supdetaileds = new HashSet(0);

	// Constructors

	/** default constructor */
	public Utinsupapply() {
	}

	/** full constructor */
	public Utinsupapply(Utinaccountinfo utinaccountinfo, String applyUtin,
			String utinOperator, String supCause, String applyDate,
			Double utinsupmoney, String utinNmae, String chequeId,
			Integer supSumple, Set supdetaileds) {
		this.utinaccountinfo = utinaccountinfo;
		this.applyUtin = applyUtin;
		this.utinOperator = utinOperator;
		this.supCause = supCause;
		this.applyDate = applyDate;
		this.utinsupmoney = utinsupmoney;
		this.utinNmae = utinNmae;
		this.chequeId = chequeId;
		this.supSumple = supSumple;
		this.supdetaileds = supdetaileds;
	}

	// Property accessors

	public Integer getApplyId() {
		return this.applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Utinaccountinfo getUtinaccountinfo() {
		return this.utinaccountinfo;
	}

	public void setUtinaccountinfo(Utinaccountinfo utinaccountinfo) {
		this.utinaccountinfo = utinaccountinfo;
	}

	public String getApplyUtin() {
		return this.applyUtin;
	}

	public void setApplyUtin(String applyUtin) {
		this.applyUtin = applyUtin;
	}

	public String getUtinOperator() {
		return this.utinOperator;
	}

	public void setUtinOperator(String utinOperator) {
		this.utinOperator = utinOperator;
	}

	public String getSupCause() {
		return this.supCause;
	}

	public void setSupCause(String supCause) {
		this.supCause = supCause;
	}

	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public Double getUtinsupmoney() {
		return this.utinsupmoney;
	}

	public void setUtinsupmoney(Double utinsupmoney) {
		this.utinsupmoney = utinsupmoney;
	}

	public String getUtinNmae() {
		return this.utinNmae;
	}

	public void setUtinNmae(String utinNmae) {
		this.utinNmae = utinNmae;
	}

	public String getChequeId() {
		return this.chequeId;
	}

	public void setChequeId(String chequeId) {
		this.chequeId = chequeId;
	}

	public Integer getSupSumple() {
		return this.supSumple;
	}

	public void setSupSumple(Integer supSumple) {
		this.supSumple = supSumple;
	}

	public Set getSupdetaileds() {
		return this.supdetaileds;
	}

	public void setSupdetaileds(Set supdetaileds) {
		this.supdetaileds = supdetaileds;
	}

}