package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Extractdetails entity. @author MyEclipse Persistence Tools
 */
//住房公积金提取详情
public class Extractdetails implements java.io.Serializable {

	// Fields

	private Integer extractDetailsId;
	private Identificationpaper identificationpaper;//身份证明
	private Extractionandapproval extractionandapproval;//提取审批表
	private Extractionmode extractionmode;//提取方式
	private Float withdrawalAmount;//提取金额
	private Causeofextraction causeofextraction;//
	private Set materialproofs = new HashSet(0);//材料证明
	private Set causeofextractions = new HashSet(0);//提取原因

	// Constructors

	/** default constructor */
	public Extractdetails() {
	}

	/** full constructor */
	public Extractdetails(Identificationpaper identificationpaper,
			Causeofextraction causeofextraction,
			Extractionandapproval extractionandapproval,
			Extractionmode extractionmode, Float withdrawalAmount,
			Set materialproofs, Set causeofextractions) {
		this.identificationpaper = identificationpaper;
		this.causeofextraction = causeofextraction;
		this.extractionandapproval = extractionandapproval;
		this.extractionmode = extractionmode;
		this.withdrawalAmount = withdrawalAmount;
		this.materialproofs = materialproofs;
		this.causeofextractions = causeofextractions;
	}

	// Property accessors

	public Integer getExtractDetailsId() {
		return this.extractDetailsId;
	}

	public void setExtractDetailsId(Integer extractDetailsId) {
		this.extractDetailsId = extractDetailsId;
	}

	public Identificationpaper getIdentificationpaper() {
		return this.identificationpaper;
	}

	public void setIdentificationpaper(Identificationpaper identificationpaper) {
		this.identificationpaper = identificationpaper;
	}

	public Causeofextraction getCauseofextraction() {
		return this.causeofextraction;
	}

	public void setCauseofextraction(Causeofextraction causeofextraction) {
		this.causeofextraction = causeofextraction;
	}

	public Extractionandapproval getExtractionandapproval() {
		return this.extractionandapproval;
	}

	public void setExtractionandapproval(
			Extractionandapproval extractionandapproval) {
		this.extractionandapproval = extractionandapproval;
	}

	public Extractionmode getExtractionmode() {
		return this.extractionmode;
	}

	public void setExtractionmode(Extractionmode extractionmode) {
		this.extractionmode = extractionmode;
	}

	public Float getWithdrawalAmount() {
		return this.withdrawalAmount;
	}

	public void setWithdrawalAmount(Float withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public Set getMaterialproofs() {
		return this.materialproofs;
	}

	public void setMaterialproofs(Set materialproofs) {
		this.materialproofs = materialproofs;
	}

	public Set getCauseofextractions() {
		return this.causeofextractions;
	}

	public void setCauseofextractions(Set causeofextractions) {
		this.causeofextractions = causeofextractions;
	}

}