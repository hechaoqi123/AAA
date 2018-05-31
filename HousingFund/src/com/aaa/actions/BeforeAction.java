package com.aaa.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aaa.biz.BeforereturnBiz;
import com.aaa.biz.BorrBiz;
import com.aaa.biz.IndaccountinfoBiz;
import com.aaa.entity.Beforereturn;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Indaccountinfo;
import com.aaa.util.JSON;
@Controller
@ParentPackage("struts-default")
@Scope("properties")
//提前还款
public class BeforeAction extends BaseAction<Beforereturn> {
	@Autowired
	BeforereturnBiz biz;
	@Autowired
	BorrBiz borrBiz;
	@Autowired
	IndaccountinfoBiz indBiz;
	//提交提前还款申请
	@Action(value="before_return",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
	public String before_return(){
		 biz.save(getModel());
		return SUCCESS;
	}
	//查询未审核的提前还款申请
	@Action(value="check_return",results={@Result(name="success",location="/BackJsp/hcq/check_return.jsp")})
	public String check_return(){
		List list=biz.find();
		getRequestMap().put("list",list);
		return SUCCESS;
	}
	//提前还款申请详情
	@Action(value="check_return_end",results={@Result(name="success",location="/BackJsp/hcq/check_return_end.jsp")})
	public String check_return_end(){
		//申请表详情
		Beforereturn before= biz.getBefore(getModel().getId());
		// 历史还贷记录
		List list=borrBiz.getPaid(before.getBorrowmoneyagreement().getBorrowMoneyAgreementId());
		getRequestMap().put("before", before);
		getRequestMap().put("list", list);
		return SUCCESS;
	}
	//提交申请
	@Action(value="submit_check_return",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
	public String submit_check_return(){
		    if(getModel().getStatus().equals("已通过")){//通过
		    	biz.success(getModel());
		    }else{//驳回
		    	biz.error(getModel());
		    }
		return SUCCESS;
	}
	//公积金冲还贷款业务办理信息索引
	private Borrowmoneyagreement borr;
	 @Action("index_push")
	public String index_push(){
		 //委托方信息  //个人账户信息
		 Indaccountinfo entity=new Indaccountinfo();
		 entity.setIdnumber(borr.getBorrowerIdno());
		    borr=borrBiz.getBorr(borr);//账户余额
		 Integer money=indBiz.getMoney(entity);
		    borr.setCoborrower(money.toString());
		 getOut().print(JSON.toJsonRelation( borr));
		 return null;
	 }
	 
    //get set
		public Borrowmoneyagreement getBorr() {
			return borr;
		}
		public void setBorr(Borrowmoneyagreement borr) {
			this.borr = borr;
		}
}
