package com.aaa.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aaa.biz.LoanApplicationBiz;
import com.aaa.biz.LoanaccountinfoBiz;
import com.aaa.entity.Collateralinfo;
import com.aaa.entity.Guarantorinfo;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
/**借款担保信息Action**/
@Controller
@ParentPackage("struts-default")
@Scope("properties")
public class LoanaccountinfoAction extends BaseAction<Loanaccountinfo> {
	Loanapplication loan;//申请书（前台传入一个ID）
	@Autowired
	LoanaccountinfoBiz biz;
	@Autowired
	LoanApplicationBiz loanbiz;
 //相关材料证明（担保人信息，拟购房信息，其他房产信息及权属证明）
	@Action(value="assureAssess_work",results={@Result(name="success",location="/BackJsp/hcq/assureAssess_end.jsp")})
	public String assureAssess_work(){
		loan=loanbiz.getOne(loan.getLoanApplicationId());
		  entity.setRemarks(String.valueOf(loan.getLoanApplicationId()));
		  entity=biz.findByExample(entity);//贷款信息
		 Collateralinfo coll = entity.getCollateralinfo(); //抵押物
		 Guarantorinfo guar = entity.getGuarantorinfo();//担保人
		     if(coll!=null){
		    	 getRequestMap().put("coll",coll);
		     }
		     if(guar!=null){
		    	 getRequestMap().put("guar",guar);
		     }
		return SUCCESS;
	}
//担保人抵押物价值评定（修改申请书状态，补全贷款信息，价值评估）
	 Collateralinfo coll;//抵押物(需要传入一个抵押物的ID即可,位置,评估价值，所属人)
	 Guarantorinfo  guar;//担保人
	@Action(value="cost_fixation",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
   	public String cost_fixation(){
		if(coll!=null){
			getModel().getCollateralinfos().add(coll);
		}
		if(guar!=null){
			getModel().getGuarantorinfos().add(guar);
		}
		biz.save(getModel(), loan);
		return SUCCESS;
   		
   	}
//借款申请最终审核
	@Action(value="final_check",results={@Result(name="success",location="/BackJsp/hcq/review_end.jsp")})
   public String final_check(){
		if(coll!=null){
			coll=biz.getColl(loan.getLoanApplicationId());
		}
		if(guar!=null){
			guar=biz.getGuar(loan.getLoanApplicationId());
		}
		loan=loanbiz.getOne(loan.getLoanApplicationId());
		return SUCCESS;
	}
	//get set
	public Loanapplication getLoan() {
		return loan;
	}
	public void setLoan(Loanapplication loan) {
		this.loan = loan;
	}
	public Collateralinfo getColl() {
		return coll;
	}
	public void setColl(Collateralinfo coll) {
		this.coll = coll;
	}
	public Guarantorinfo getGuar() {
		return guar;
	}
	public void setGuar(Guarantorinfo guar) {
		this.guar = guar;
	}
	
	
}
