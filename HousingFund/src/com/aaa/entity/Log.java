package com.aaa.entity;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
  //冲贷日志
public class Log implements java.io.Serializable {

	// Fields

	private Integer id;
	private Repaymentplandetails repaymentplandetails;//冲还贷记录
	private Fush fush;//
	private String money;//还款金额
	private String riqi;//日期
	private String status;//状态
	private String remark;//备注

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(Repaymentplandetails repaymentplandetails, Fush fush,
			String money, String riqi, String status, String remark) {
		this.repaymentplandetails = repaymentplandetails;
		this.fush = fush;
		this.money = money;
		this.riqi = riqi;
		this.status = status;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Repaymentplandetails getRepaymentplandetails() {
		return this.repaymentplandetails;
	}

	public void setRepaymentplandetails(
			Repaymentplandetails repaymentplandetails) {
		this.repaymentplandetails = repaymentplandetails;
	}

	public Fush getFush() {
		return this.fush;
	}

	public void setFush(Fush fush) {
		this.fush = fush;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getRiqi() {
		return this.riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}