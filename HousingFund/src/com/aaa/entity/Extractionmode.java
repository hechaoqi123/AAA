package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Extractionmode entity. @author MyEclipse Persistence Tools
 */
   //提取方式
/*  提取方式：
             个人全部提取     个人部分提取     夫妻全部提取    夫妻部分提取*/
public class Extractionmode implements java.io.Serializable {

	// Fields

	private Integer extractionModeNumber;
	private String extractionModeDescription;//提取方式描述
	private Set extractdetailses = new HashSet(0);//提取详情

	// Constructors

	/** default constructor */
	public Extractionmode() {
	}

	/** full constructor */
	public Extractionmode(String extractionModeDescription, Set extractdetailses) {
		this.extractionModeDescription = extractionModeDescription;
		this.extractdetailses = extractdetailses;
	}

	// Property accessors

	public Integer getExtractionModeNumber() {
		return this.extractionModeNumber;
	}

	public void setExtractionModeNumber(Integer extractionModeNumber) {
		this.extractionModeNumber = extractionModeNumber;
	}

	public String getExtractionModeDescription() {
		return this.extractionModeDescription;
	}

	public void setExtractionModeDescription(String extractionModeDescription) {
		this.extractionModeDescription = extractionModeDescription;
	}

	public Set getExtractdetailses() {
		return this.extractdetailses;
	}

	public void setExtractdetailses(Set extractdetailses) {
		this.extractdetailses = extractdetailses;
	}

}