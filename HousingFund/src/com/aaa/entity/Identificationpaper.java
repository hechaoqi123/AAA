package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Identificationpaper entity. @author MyEclipse Persistence Tools
 */
   //身份证明表
public class Identificationpaper implements java.io.Serializable {

	// Fields

	private Integer idno;
	private String idcard;//身份证号
	private String originalIdcard;//配偶身份证号
	private String marriageCertificate;//夫妻婚姻关系证明
	private String domicileCertificate;//户籍证明
	private String operatorIdcard;//委托办理时：经办人身份证号
	private Set extractdetailses = new HashSet(0);//提取详情

	// Constructors

	/** default constructor */
	public Identificationpaper() {
	}

	/** full constructor */
	public Identificationpaper(String idcard, String originalIdcard,
			String marriageCertificate, String domicileCertificate,
			String operatorIdcard, Set extractdetailses) {
		this.idcard = idcard;
		this.originalIdcard = originalIdcard;
		this.marriageCertificate = marriageCertificate;
		this.domicileCertificate = domicileCertificate;
		this.operatorIdcard = operatorIdcard;
		this.extractdetailses = extractdetailses;
	}

	// Property accessors

	public Integer getIdno() {
		return this.idno;
	}

	public void setIdno(Integer idno) {
		this.idno = idno;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getOriginalIdcard() {
		return this.originalIdcard;
	}

	public void setOriginalIdcard(String originalIdcard) {
		this.originalIdcard = originalIdcard;
	}

	public String getMarriageCertificate() {
		return this.marriageCertificate;
	}

	public void setMarriageCertificate(String marriageCertificate) {
		this.marriageCertificate = marriageCertificate;
	}

	public String getDomicileCertificate() {
		return this.domicileCertificate;
	}

	public void setDomicileCertificate(String domicileCertificate) {
		this.domicileCertificate = domicileCertificate;
	}

	public String getOperatorIdcard() {
		return this.operatorIdcard;
	}

	public void setOperatorIdcard(String operatorIdcard) {
		this.operatorIdcard = operatorIdcard;
	}

	public Set getExtractdetailses() {
		return this.extractdetailses;
	}

	public void setExtractdetailses(Set extractdetailses) {
		this.extractdetailses = extractdetailses;
	}

}