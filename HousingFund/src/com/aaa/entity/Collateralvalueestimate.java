package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Collateralvalueestimate entity. @author MyEclipse Persistence Tools
 */
//抵押物价值评估
public class Collateralvalueestimate implements java.io.Serializable {
	// Fields
	private Integer collateralValueEstimateId;
	private String pawnType;//类型
	private String pawnAddress;//所在地
	private String pawnOwner;//所属人
	private String ownerIdno;//无效字段：所属人身份证号
	private Float pawnValueEsti;//评估价值
	private String remarks;//备注
	private Set collateralinfos = new HashSet(0);//抵押物

	// Constructors

	/** default constructor */
	public Collateralvalueestimate() {
	}

	/** full constructor */
	public Collateralvalueestimate(String pawnType, String pawnAddress,
			String pawnOwner, String ownerIdno, Float pawnValueEsti,
			String remarks, Set collateralinfos) {
		this.pawnType = pawnType;
		this.pawnAddress = pawnAddress;
		this.pawnOwner = pawnOwner;
		this.ownerIdno = ownerIdno;
		this.pawnValueEsti = pawnValueEsti;
		this.remarks = remarks;
		this.collateralinfos = collateralinfos;
	}

	// Property accessors

	public Integer getCollateralValueEstimateId() {
		return this.collateralValueEstimateId;
	}

	public void setCollateralValueEstimateId(Integer collateralValueEstimateId) {
		this.collateralValueEstimateId = collateralValueEstimateId;
	}

	public String getPawnType() {
		return this.pawnType;
	}

	public void setPawnType(String pawnType) {
		this.pawnType = pawnType;
	}

	public String getPawnAddress() {
		return this.pawnAddress;
	}

	public void setPawnAddress(String pawnAddress) {
		this.pawnAddress = pawnAddress;
	}

	public String getPawnOwner() {
		return this.pawnOwner;
	}

	public void setPawnOwner(String pawnOwner) {
		this.pawnOwner = pawnOwner;
	}

	public String getOwnerIdno() {
		return this.ownerIdno;
	}

	public void setOwnerIdno(String ownerIdno) {
		this.ownerIdno = ownerIdno;
	}

	public Float getPawnValueEsti() {
		return this.pawnValueEsti;
	}

	public void setPawnValueEsti(Float pawnValueEsti) {
		this.pawnValueEsti = pawnValueEsti;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getCollateralinfos() {
		return this.collateralinfos;
	}

	public void setCollateralinfos(Set collateralinfos) {
		this.collateralinfos = collateralinfos;
	}

}