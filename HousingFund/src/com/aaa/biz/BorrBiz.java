package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Repaymentplandetails;

/**借款合同**/
public interface BorrBiz {
  //按揭偿还贷款(取出一条还款记录)
  public Repaymentplandetails getRepay(Borrowmoneyagreement borr);
  //通过身份证号取出借款合同
  public Borrowmoneyagreement getBorr(Borrowmoneyagreement borr);
  //按揭提交还款
  public boolean return_loan(Integer id);
  //结清还款
  public void sure_end(String repaymentAccount);
  //查询已还款记录
  public List getPaid(Integer id);
  //查询未还清的
public boolean find(Loanapplication loan);
}
