package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;



/**
 * Loanapplication entity. @author MyEclipse Persistence Tools
 */
//住房公积金借款申请书
public class Loanapplication implements java.io.Serializable {
	// Fields
	private Integer loanApplicationId;
	private String nameOfBorrower;//借款人姓名
	private String borrowerIdnumber;//身份证号
	private String borrowersUnit;//所在单位名称
	private String borrowerPhone;//联系电话
	private String indAccount;//公积金账户编号
	private Float borrowingBalance;//借款金额
	private Integer lentYearsNumber;//借款年限（推荐以月为单位）
	private Float borrowerMonthMoney;//借款人月收入
	private Useoffunds useoffunds;//所购房屋类型
	private Purchasecontract purchasecontract;//购房合同
	private Guaranteemode guaranteemode;//担保方式
	private Coborrower coborrower;//共同借款人（夫妻）
	private Float annualRate;//利率
	private String remarks;//是否首套房
	private String status="未审批";//审批状态
	private String unitAddress;//还款方式
	private Set loanfinals = new HashSet(0);

	// Constructors

	/** default constructor */
	public Loanapplication() {
	}

	/** full constructor */
	public Loanapplication(Purchasecontract purchasecontract,
			Coborrower coborrower, Useoffunds useoffunds,
			Guaranteemode guaranteemode, String nameOfBorrower,
			String borrowerIdnumber, String borrowersUnit,
			String borrowerPhone, String indAccount, String unitAddress,
			Float borrowerMonthMoney, Float borrowingBalance,
			Integer lentYearsNumber, Float annualRate, String remarks,
			String status, Set loanfinals) {
		this.purchasecontract = purchasecontract;
		this.coborrower = coborrower;
		this.useoffunds = useoffunds;
		this.guaranteemode = guaranteemode;
		this.nameOfBorrower = nameOfBorrower;
		this.borrowerIdnumber = borrowerIdnumber;
		this.borrowersUnit = borrowersUnit;
		this.borrowerPhone = borrowerPhone;
		this.indAccount = indAccount;
		this.unitAddress = unitAddress;
		this.borrowerMonthMoney = borrowerMonthMoney;
		this.borrowingBalance = borrowingBalance;
		this.lentYearsNumber = lentYearsNumber;
		this.annualRate = annualRate;
		this.remarks = remarks;
		this.status = status;
		this.loanfinals = loanfinals;
	}

	// Property accessors

	public Integer getLoanApplicationId() {
		return this.loanApplicationId;
	}

	public void setLoanApplicationId(Integer loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public Purchasecontract getPurchasecontract() {
		return this.purchasecontract;
	}

	public void setPurchasecontract(Purchasecontract purchasecontract) {
		this.purchasecontract = purchasecontract;
	}

	public Coborrower getCoborrower() {
		return this.coborrower;
	}

	public void setCoborrower(Coborrower coborrower) {
		this.coborrower = coborrower;
	}

	public Useoffunds getUseoffunds() {
		return this.useoffunds;
	}

	public void setUseoffunds(Useoffunds useoffunds) {
		this.useoffunds = useoffunds;
	}

	public Guaranteemode getGuaranteemode() {
		return this.guaranteemode;
	}

	public void setGuaranteemode(Guaranteemode guaranteemode) {
		this.guaranteemode = guaranteemode;
	}

	public String getNameOfBorrower() {
		return this.nameOfBorrower;
	}

	public void setNameOfBorrower(String nameOfBorrower) {
		this.nameOfBorrower = nameOfBorrower;
	}

	public String getBorrowerIdnumber() {
		return this.borrowerIdnumber;
	}

	public void setBorrowerIdnumber(String borrowerIdnumber) {
		this.borrowerIdnumber = borrowerIdnumber;
	}

	public String getBorrowersUnit() {
		return this.borrowersUnit;
	}

	public void setBorrowersUnit(String borrowersUnit) {
		this.borrowersUnit = borrowersUnit;
	}

	public String getBorrowerPhone() {
		return this.borrowerPhone;
	}

	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}

	public String getIndAccount() {
		return this.indAccount;
	}

	public void setIndAccount(String indAccount) {
		this.indAccount = indAccount;
	}

	public String getUnitAddress() {
		return this.unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public Float getBorrowerMonthMoney() {
		return this.borrowerMonthMoney;
	}

	public void setBorrowerMonthMoney(Float borrowerMonthMoney) {
		this.borrowerMonthMoney = borrowerMonthMoney;
	}

	public Float getBorrowingBalance() {
		return this.borrowingBalance;
	}

	public void setBorrowingBalance(Float borrowingBalance) {
		this.borrowingBalance = borrowingBalance;
	}

	public Integer getLentYearsNumber() {
		return this.lentYearsNumber;
	}

	public void setLentYearsNumber(Integer lentYearsNumber) {
		this.lentYearsNumber = lentYearsNumber;
	}

	public Float getAnnualRate() {
		return this.annualRate;
	}

	public void setAnnualRate(Float annualRate) {
		this.annualRate = annualRate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getLoanfinals() {
		return this.loanfinals;
	}

	public void setLoanfinals(Set loanfinals) {
		this.loanfinals = loanfinals;
	}

}