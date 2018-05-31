package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Retireti entity. @author MyEclipse Persistence Tools
 */
//离职退休证明
public class Retireti implements java.io.Serializable {

// Fields

	private Integer retireId;
	private Materialtype materialtype;//材料类型
	private String myName;//姓名	
	private String utinName;//单位名称
	private String reasForRe;//离职原因
	private Set materialtypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Retireti() {
	}

	/** full constructor */
	public Retireti(Materialtype materialtype, String myName, String utinName,
			String reasForRe, Set materialtypes) {
		this.materialtype = materialtype;
		this.myName = myName;
		this.utinName = utinName;
		this.reasForRe = reasForRe;
		this.materialtypes = materialtypes;
	}

	// Property accessors

	public Integer getRetireId() {
		return this.retireId;
	}

	public void setRetireId(Integer retireId) {
		this.retireId = retireId;
	}

	public Materialtype getMaterialtype() {
		return this.materialtype;
	}

	public void setMaterialtype(Materialtype materialtype) {
		this.materialtype = materialtype;
	}

	public String getMyName() {
		return this.myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String getUtinName() {
		return this.utinName;
	}

	public void setUtinName(String utinName) {
		this.utinName = utinName;
	}

	public String getReasForRe() {
		return this.reasForRe;
	}

	public void setReasForRe(String reasForRe) {
		this.reasForRe = reasForRe;
	}

	public Set getMaterialtypes() {
		return this.materialtypes;
	}

	public void setMaterialtypes(Set materialtypes) {
		this.materialtypes = materialtypes;
	}

}