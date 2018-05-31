package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Materialproof entity. @author MyEclipse Persistence Tools
 */
  //材料证明
public class Materialproof implements java.io.Serializable {

	// Fields

	private Integer materialProofId;
	
	private Materialtype materialtype;//材料类型表
	private Extractdetails extractdetails;//提取详情
	private Set materialtypes = new HashSet(0);//似无效字段

	// Constructors

	/** default constructor */
	public Materialproof() {
	}

	public Integer getMaterialProofId() {
		return materialProofId;
	}

	public void setMaterialProofId(Integer materialProofId) {
		this.materialProofId = materialProofId;
	}

	public Materialtype getMaterialtype() {
		return materialtype;
	}

	public void setMaterialtype(Materialtype materialtype) {
		this.materialtype = materialtype;
	}

	public Extractdetails getExtractdetails() {
		return extractdetails;
	}

	public void setExtractdetails(Extractdetails extractdetails) {
		this.extractdetails = extractdetails;
	}

	public Set getMaterialtypes() {
		return materialtypes;
	}

	public void setMaterialtypes(Set materialtypes) {
		this.materialtypes = materialtypes;
	}

	public Materialproof(Integer materialProofId, Materialtype materialtype,
			Extractdetails extractdetails, Set materialtypes) {
		super();
		this.materialProofId = materialProofId;
		this.materialtype = materialtype;
		this.extractdetails = extractdetails;
		this.materialtypes = materialtypes;
	}

	

}