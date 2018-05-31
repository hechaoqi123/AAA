package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Indaccountinfo entity. @author MyEclipse Persistence Tools
 */
//个人账户信息表
public class Indaccountinfo implements java.io.Serializable {

	// Fields
	private Integer indAccountId;
	private Utinaccountinfo utinaccountinfo; //单位账户信息
	private Indinfo indinfo;   //个人信息
	private Float indDepositRadices;//个人缴存基数:工资
	private Float indDepositRatio;//个人缴存比例
	private Date indOpenDate;//个人开户日期
	private Float lastChangeRem;//上年转结余额
	private Float thisPayRem;//当年缴纳余额
	private Float presentSumRem;//当前总余额
	private Float usableRem;//可取现余额
	private Float peMonthDep;//个人月缴存金额
	private Float utinMonthDep;//单位月缴存金额
	private String bankSaAccount;//银行储蓄账户
	private String bankOpenAccount;//开户银行名称
	private String indStatus;//个人账户状态
	private String loginAccount;//网厅登陆账户：默认身份证号
	private String loginPass;//网厅账户密码
	private String trueName;//
	private String idnumber;//
	private Set supdetaileds = new HashSet(0);
	private Set extractionandapprovals = new HashSet(0);

	// Constructors

	/** default constructor */
	public Indaccountinfo() {
	}

	/** full constructor */
	public Indaccountinfo(Utinaccountinfo utinaccountinfo, Indinfo indinfo,
			Float indDepositRadices, Float indDepositRatio, Date indOpenDate,
			Float lastChangeRem, Float thisPayRem, Float presentSumRem,
			Float usableRem, Float peMonthDep, Float utinMonthDep,
			String bankSaAccount, String bankOpenAccount, String indStatus,
			String loginAccount, String loginPass, String trueName,
			String idnumber, Set supdetaileds, Set extractionandapprovals) {
		this.utinaccountinfo = utinaccountinfo;
		this.indinfo = indinfo;
		this.indDepositRadices = indDepositRadices;
		this.indDepositRatio = indDepositRatio;
		this.indOpenDate = indOpenDate;
		this.lastChangeRem = lastChangeRem;
		this.thisPayRem = thisPayRem;
		this.presentSumRem = presentSumRem;
		this.usableRem = usableRem;
		this.peMonthDep = peMonthDep;
		this.utinMonthDep = utinMonthDep;
		this.bankSaAccount = bankSaAccount;
		this.bankOpenAccount = bankOpenAccount;
		this.indStatus = indStatus;
		this.loginAccount = loginAccount;
		this.loginPass = loginPass;
		this.trueName = trueName;
		this.idnumber = idnumber;
		this.supdetaileds = supdetaileds;
		this.extractionandapprovals = extractionandapprovals;
	}

	// Property accessors

	public Integer getIndAccountId() {
		return this.indAccountId;
	}

	public void setIndAccountId(Integer indAccountId) {
		this.indAccountId = indAccountId;
	}

	public Utinaccountinfo getUtinaccountinfo() {
		return this.utinaccountinfo;
	}

	public void setUtinaccountinfo(Utinaccountinfo utinaccountinfo) {
		this.utinaccountinfo = utinaccountinfo;
	}

	public Indinfo getIndinfo() {
		return this.indinfo;
	}

	public void setIndinfo(Indinfo indinfo) {
		this.indinfo = indinfo;
	}

	public Float getIndDepositRadices() {
		return this.indDepositRadices;
	}

	public void setIndDepositRadices(Float indDepositRadices) {
		this.indDepositRadices = indDepositRadices;
	}

	public Float getIndDepositRatio() {
		return this.indDepositRatio;
	}

	public void setIndDepositRatio(Float indDepositRatio) {
		this.indDepositRatio = indDepositRatio;
	}

	public Date getIndOpenDate() {
		return this.indOpenDate;
	}

	public void setIndOpenDate(Date indOpenDate) {
		this.indOpenDate = indOpenDate;
	}

	public Float getLastChangeRem() {
		return this.lastChangeRem;
	}

	public void setLastChangeRem(Float lastChangeRem) {
		this.lastChangeRem = lastChangeRem;
	}

	public Float getThisPayRem() {
		return this.thisPayRem;
	}

	public void setThisPayRem(Float thisPayRem) {
		this.thisPayRem = thisPayRem;
	}

	public Float getPresentSumRem() {
		return this.presentSumRem;
	}

	public void setPresentSumRem(Float presentSumRem) {
		this.presentSumRem = presentSumRem;
	}

	public Float getUsableRem() {
		return this.usableRem;
	}

	public void setUsableRem(Float usableRem) {
		this.usableRem = usableRem;
	}

	public Float getPeMonthDep() {
		return this.peMonthDep;
	}

	public void setPeMonthDep(Float peMonthDep) {
		this.peMonthDep = peMonthDep;
	}

	public Float getUtinMonthDep() {
		return this.utinMonthDep;
	}

	public void setUtinMonthDep(Float utinMonthDep) {
		this.utinMonthDep = utinMonthDep;
	}

	public String getBankSaAccount() {
		return this.bankSaAccount;
	}

	public void setBankSaAccount(String bankSaAccount) {
		this.bankSaAccount = bankSaAccount;
	}

	public String getBankOpenAccount() {
		return this.bankOpenAccount;
	}

	public void setBankOpenAccount(String bankOpenAccount) {
		this.bankOpenAccount = bankOpenAccount;
	}

	public String getIndStatus() {
		return this.indStatus;
	}

	public void setIndStatus(String indStatus) {
		this.indStatus = indStatus;
	}

	public String getLoginAccount() {
		return this.loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPass() {
		return this.loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public Set getSupdetaileds() {
		return this.supdetaileds;
	}

	public void setSupdetaileds(Set supdetaileds) {
		this.supdetaileds = supdetaileds;
	}

	public Set getExtractionandapprovals() {
		return this.extractionandapprovals;
	}

	public void setExtractionandapprovals(Set extractionandapprovals) {
		this.extractionandapprovals = extractionandapprovals;
	}

}