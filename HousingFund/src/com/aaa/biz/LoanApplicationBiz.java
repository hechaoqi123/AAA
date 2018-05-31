package com.aaa.biz;

import java.util.List;

import com.aaa.actions.LoanApplicationAction;
import com.aaa.entity.Coborrower;
import com.aaa.entity.Collateralinfo;
import com.aaa.entity.Guaranteemode;
import com.aaa.entity.Guarantorinfo;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Proof;
import com.aaa.entity.Purchasecontract;
import com.aaa.entity.Purchasedhinfo;
import com.aaa.entity.Useoffunds;


public interface LoanApplicationBiz{
	//发起贷款申请
	public void save(Loanapplication loanEntity,Loanaccountinfo loanaccountinfoEntity);
	//待审核申请
	public List<Loanapplication> criteriaAssess(String state);
	//申请书查询
	public Loanapplication getOne(int id);
	//当前申请书最大可贷额度
	public Integer getLimit(Integer LoanapplicationId);
	//更新申请书状态
	public void successORreject(Loanapplication loanEntity,String cause);
	//未签订贷款合同申请书查询
	public Object[] find(Loanapplication loan);
	//合同签订
	public void update(int i);
	//申请书及个人还款计划
	public Object[]  refund(Loanapplication loan);
}
