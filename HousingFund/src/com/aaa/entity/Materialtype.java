package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Materialtype entity. @author MyEclipse Persistence Tools
 */

public class Materialtype implements java.io.Serializable {

	// Fields

	private Integer materialTypeId;
	private Retireti retireti;
	private Purinfo purinfo;
	private Proofofdeath proofofdeath;
	private Materialproof materialproof;
	private Integer purchaseContractId;
	private String typeSpecification;
	private Set retiretis = new HashSet(0);
	private Set purchasecontracts = new HashSet(0);
	private Set materialproofsForMaterialTypeId = new HashSet(0);
	private Set repayprincproves = new HashSet(0);
	private Set proofofdeaths = new HashSet(0);
	private Set materialproofsForMatMaterialTypeId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Materialtype() {
	}

	/** full constructor */
	public Materialtype(Retireti retireti, Purinfo purinfo,
			Proofofdeath proofofdeath, Materialproof materialproof,
			Integer purchaseContractId, String typeSpecification,
			Set retiretis, Set purchasecontracts,
			Set materialproofsForMaterialTypeId, Set repayprincproves,
			Set proofofdeaths, Set materialproofsForMatMaterialTypeId) {
		this.retireti = retireti;
		this.purinfo = purinfo;
		this.proofofdeath = proofofdeath;
		this.materialproof = materialproof;
		this.purchaseContractId = purchaseContractId;
		this.typeSpecification = typeSpecification;
		this.retiretis = retiretis;
		this.purchasecontracts = purchasecontracts;
		this.materialproofsForMaterialTypeId = materialproofsForMaterialTypeId;
		this.repayprincproves = repayprincproves;
		this.proofofdeaths = proofofdeaths;
		this.materialproofsForMatMaterialTypeId = materialproofsForMatMaterialTypeId;
	}

	// Property accessors

	public Integer getMaterialTypeId() {
		return this.materialTypeId;
	}

	public void setMaterialTypeId(Integer materialTypeId) {
		this.materialTypeId = materialTypeId;
	}

	public Retireti getRetireti() {
		return this.retireti;
	}

	public void setRetireti(Retireti retireti) {
		this.retireti = retireti;
	}

	public Purinfo getPurinfo() {
		return this.purinfo;
	}

	public void setPurinfo(Purinfo purinfo) {
		this.purinfo = purinfo;
	}

	public Proofofdeath getProofofdeath() {
		return this.proofofdeath;
	}

	public void setProofofdeath(Proofofdeath proofofdeath) {
		this.proofofdeath = proofofdeath;
	}

	public Materialproof getMaterialproof() {
		return this.materialproof;
	}

	public void setMaterialproof(Materialproof materialproof) {
		this.materialproof = materialproof;
	}

	public Integer getPurchaseContractId() {
		return this.purchaseContractId;
	}

	public void setPurchaseContractId(Integer purchaseContractId) {
		this.purchaseContractId = purchaseContractId;
	}

	public String getTypeSpecification() {
		return this.typeSpecification;
	}

	public void setTypeSpecification(String typeSpecification) {
		this.typeSpecification = typeSpecification;
	}

	public Set getRetiretis() {
		return this.retiretis;
	}

	public void setRetiretis(Set retiretis) {
		this.retiretis = retiretis;
	}

	public Set getPurchasecontracts() {
		return this.purchasecontracts;
	}

	public void setPurchasecontracts(Set purchasecontracts) {
		this.purchasecontracts = purchasecontracts;
	}

	public Set getMaterialproofsForMaterialTypeId() {
		return this.materialproofsForMaterialTypeId;
	}

	public void setMaterialproofsForMaterialTypeId(
			Set materialproofsForMaterialTypeId) {
		this.materialproofsForMaterialTypeId = materialproofsForMaterialTypeId;
	}

	public Set getRepayprincproves() {
		return this.repayprincproves;
	}

	public void setRepayprincproves(Set repayprincproves) {
		this.repayprincproves = repayprincproves;
	}

	public Set getProofofdeaths() {
		return this.proofofdeaths;
	}

	public void setProofofdeaths(Set proofofdeaths) {
		this.proofofdeaths = proofofdeaths;
	}

	public Set getMaterialproofsForMatMaterialTypeId() {
		return this.materialproofsForMatMaterialTypeId;
	}

	public void setMaterialproofsForMatMaterialTypeId(
			Set materialproofsForMatMaterialTypeId) {
		this.materialproofsForMatMaterialTypeId = materialproofsForMatMaterialTypeId;
	}

}