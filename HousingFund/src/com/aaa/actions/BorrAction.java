package com.aaa.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aaa.biz.BorrBiz;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Repaymentplandetails;
import com.aaa.util.JSON;

/**借款合同**/
@Controller
@ParentPackage("struts-default")
@Scope("properties")
public class BorrAction extends BaseAction<Borrowmoneyagreement> {
	@Autowired
    BorrBiz biz;
 //按揭偿还贷款（索引）	
   @Action("get_borr")
   public String get_borr(){
	       List list=new ArrayList();
	       list.add(biz.getRepay(getModel()));//按揭还款
	       list.add(biz.getBorr(getModel()));//借款合同
	    getOut().print(JSON.toCollectionJson(list));
	       return null;
   }
//确认还款（打印凭证）
   @Action(value="sure_borr",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
   public String sure_borr(){//更新还款计划状态（判断是否已还清）
	   boolean success=biz.return_loan(getModel().getBorrowMoneyAgreementId());
	       if(success){//还款成功
	    	   return SUCCESS;
	       }else{//还款失败
	    	  System.out.println("还款失败:打印日志"); 
	    	  return ERROR;
	       }
   }
//结清还款（打印凭证）
   @Action(value="sure_end",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
   public String sure_end(){//更新还款计划状态（判断是否已还清）
	   biz.sure_end(getModel().getRepaymentAccount());
	    	   return SUCCESS;
   }
//索引借贷合同
   @Action("indexBorr")
   public String indexBorr(){
	   try {
		   //判断贷款清册是否结清
		   Borrowmoneyagreement borr=biz.getBorr(getModel());
		   Set<Repaymentplandetails> set=borr.getRepaymentplandetailses();
		      Float money=0F;//存储已还金额
		      int number=0;//存储已还期数
		   for (Repaymentplandetails repaymentplandetails : set) {
			   String status=repaymentplandetails.getRepaymentStatus();//状态
			   Float money2=repaymentplandetails.getCurrentReturnedCorpus();//本金
			   if(!status.equals("未还")&&!status.equals("逾期未还")){
				   money+=money2;
			   }
			   if(status.equals("已还")){
				   number++;
			   }
			   
			}
		     //占用一个属性传已还金额的值
		   borr.setRepaymentPlanDetailsiId(number);
		     borr.setCoborrower(money.toString());
		     getOut().print(JSON.toJson(borr));
	} catch (Exception e) {
		e.printStackTrace();
	}
	      return null;
   }
}
