package com.aaa.entity;

/**
 * Flupay entity. @author MyEclipse Persistence Tools
 */

public class Flupay implements java.io.Serializable {

	// Fields

	private Integer fluPayid;
	private Utinaccountinfo utinaccountinfo;//单位编号
	private String utinName;//单位名称 
	private String fluPayprove;//冲缴证明
	private String ifelseFp;//是否开启 是 否

	// Constructors

	/** default constructor */
	public Flupay() {
	}

	/** full constructor */
	public Flupay(Utinaccountinfo utinaccountinfo, String utinName,
			String fluPayprove, String ifelseFp) {
		this.utinaccountinfo = utinaccountinfo;
		this.utinName = utinName;
		this.fluPayprove = fluPayprove;
		this.ifelseFp = ifelseFp;
	}

	// Property accessors

	public Integer getFluPayid() {
		return this.fluPayid;
	}

	public void setFluPayid(Integer fluPayid) {
		this.fluPayid = fluPayid;
	}

	public Utinaccountinfo getUtinaccountinfo() {
		return this.utinaccountinfo;
	}

	public void setUtinaccountinfo(Utinaccountinfo utinaccountinfo) {
		this.utinaccountinfo = utinaccountinfo;
	}

	public String getUtinName() {
		return this.utinName;
	}

	public void setUtinName(String utinName) {
		this.utinName = utinName;
	}

	public String getFluPayprove() {
		return this.fluPayprove;
	}

	public void setFluPayprove(String fluPayprove) {
		this.fluPayprove = fluPayprove;
	}

	public String getIfelseFp() {
		return this.ifelseFp;
	}

	public void setIfelseFp(String ifelseFp) {
		this.ifelseFp = ifelseFp;
	}

}