package com.aaa.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aaa.biz.BorrBiz;
import com.aaa.biz.LoanApplicationBiz;
import com.aaa.biz.LoanBookBiz;
import com.aaa.biz.LoanaccountinfoBiz;
import com.aaa.biz.RemittanceDetailBiz;
import com.aaa.dao.LoanBookDao;
import com.aaa.entity.Coborrower;
import com.aaa.entity.Collateralinfo;
import com.aaa.entity.Guaranteemode;
import com.aaa.entity.Guarantorinfo;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Loanbook;
import com.aaa.entity.Proof;
import com.aaa.entity.Purchasecontract;
import com.aaa.entity.Purchasedhinfo;
import com.aaa.entity.Remittancedetail;
import com.aaa.entity.Repaymentplandetails;
import com.aaa.entity.Useoffunds;
import com.aaa.util.JSON;
/****���������Action****/
@Controller
@ParentPackage("struts-default")
@Scope("properties")
public class LoanApplicationAction extends BaseAction<Loanapplication> {
	@Autowired
	 LoanApplicationBiz biz;
	@Autowired
	 LoanaccountinfoBiz loanBiz;
	@Autowired
	 BorrBiz borBiz;
	 Loanaccountinfo loanaccountinfoEntity=new Loanaccountinfo();//������Ϣ
	 Guarantorinfo guarantorinfo;//������
	 Collateralinfo collateralinfo;//��Ѻ��
//�ύ���������
	@Action(value="save_LoanApplication",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
    public String save(){
		String account=getModel().getCoborrower().getCoborrowerAccount();
		   if(account.equals("")||account==null){
			   getModel().setCoborrower(null);
		   }
			if(collateralinfo!=null){//����������ϵ
				loanaccountinfoEntity.getCollateralinfos().add(collateralinfo);
			}
			if(guarantorinfo!=null){
				loanaccountinfoEntity.getGuarantorinfos().add(guarantorinfo);
			}
			getModel().setStatus("δ����");
			biz.save(getModel(), loanaccountinfoEntity);
		return SUCCESS;
    }
//����������ѯ
	@Action(value="showlendApproval",results={@Result(name="success",location="/BackJsp/hcq/lendApproval.jsp")})
	public String showlendApproval(){
		this.getRequestMap().put("list", biz.criteriaAssess("δ����"));
		return SUCCESS;
	}
//������������
	@Autowired
	RemittanceDetailBiz remBiz;
	@Autowired
	LoanBookBiz loanBookBiz;
	@Action(value="firs_tiral",results={@Result(name="success",location="/BackJsp/hcq/lendApproval_end.jsp")})
	public String firs_tiral(){
		//����������
		Loanapplication loanBook=biz.getOne(getModel().getLoanApplicationId());
		String accountId=loanBook.getIndAccount();//�����˻�
		List<Remittancedetail> rems=remBiz.findRecord(accountId);//�����˻���ɼ�¼
		List<Loanbook> loanMarks=loanBookBiz.findAll(String.valueOf(getModel().getLoanApplicationId()));//��ʷ�����¼
		Integer maxMonry=biz.getLimit(getModel().getLoanApplicationId());//����ȼ���
	      Map map=getRequestMap();	
	      map.put("book", loanBook);
	      map.put("rems", rems);
	      map.put("loanMarks",loanMarks);
	      map.put("maxMonry",maxMonry);
		return SUCCESS;
	}
//�������(����Or����)
	@Action(value="first_audit_end",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
	public String audit_end(){
		   String cause=getModel().getRemarks();
		biz.successORreject(getModel(), cause);
		return SUCCESS;
	}
//�����������ѯ
	@Action(value="assureAssess",results={@Result(name="success",location="/BackJsp/hcq/assureAssess.jsp")})
	public String assureAssess(){
		this.getRequestMap().put("list", biz.criteriaAssess("������"));
		return SUCCESS;
	}
//�����������ѯ
	@Action(value="review",results={@Result(name="success",location="/BackJsp/hcq/review.jsp")})
	public String review(){
			this.getRequestMap().put("list", biz.criteriaAssess("������"));
			return SUCCESS;
		}
 //����ͬ����
	@Action("get_loan")
	public String find() throws Exception{
		Object[]  objs=biz.find(getModel());
		  if(objs!=null){
			  Loanapplication	loan=(Loanapplication) objs[0];
				Integer id=(Integer) objs[1]; //��ͬ���
				String address=loan.getPurchasecontract().getPurchasedhinfo().getHousingPosition();
				loan.setBorrowersUnit(address); 
				loan.setBorrowerPhone(String.valueOf(id));
				try {
					//System.out.println(com.aaa.util.JSON.toJsonRelation(loan));
					String json=com.aaa.util.JSON.toJsonRelation(loan);
				     getOut().print(json);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		  }
		      return null;
	}
 //����ƻ�����	
	@Action("refund")
	public String refund(){
		try {
		Object[] objs=biz.refund(getModel());
		 Loanapplication loan=(Loanapplication) objs[0];//������
		    //�ж��Ƿ����δ��������  true ���� false ������
		   boolean succ=borBiz.find(loan);
		     if(!succ){
		    	 getOut().print("{'result':'false'}");
		    	 return null;
		     }
		 loan=(Loanapplication) JSON.RemoveRelation(loan);//ȡ����������
		 List list=(List) objs[1];
		 
			 for (Object object : list) {
				   Repaymentplandetails r=(Repaymentplandetails) object;
				   JSON.RemoveRelation(r);
			}
			 list.add(loan);
			String json=JSON.toCollectionJson(list);
			getOut().print(json);
		} catch (Exception e) {
			getOut().print("");
		}
		return null;
	}
//����ͬǩ��	end_loan
	@Action(value="end_loan",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
		public String end(){
		  biz.update(getModel().getLoanApplicationId());
			return SUCCESS;
		}
//������������
	@Action("find_Loan")
	public String fing_Loan(){
		try {
			Loanapplication Loan = biz.getOne(getModel());
			loanaccountinfoEntity.setRemarks(String.valueOf(Loan.getLoanApplicationId()));
			loanaccountinfoEntity=loanBiz.findByExample(loanaccountinfoEntity);
			String remark=loanaccountinfoEntity.getGuaranteeMode();
			   if(Loan.getCoborrower()==null){//�жϹ�ͬ�����
				   Coborrower coborrower=new Coborrower();
				   coborrower.setCoborrowerName("��");
				   coborrower.setCoborrowerAddress(remark);
				   Loan.setCoborrower(coborrower);
			   }else{
				   Loan.getCoborrower().setCoborrowerAddress(remark);
			   }
			String json=JSON.toJsonRelation(Loan);
			   System.out.println(json);
			getOut().print(json);
		} catch (Exception e) {
			getOut().print("error");
			e.printStackTrace();
		}
		return null;
	}
	//get set
	public Loanaccountinfo getLoanaccountinfoEntity() {
		return loanaccountinfoEntity;
	}
	public void setLoanaccountinfoEntity(Loanaccountinfo loanaccountinfoEntity) {
		this.loanaccountinfoEntity = loanaccountinfoEntity;
	}
	public Guarantorinfo getGuarantorinfo() {
		return guarantorinfo;
	}
	public void setGuarantorinfo(Guarantorinfo guarantorinfo) {
		this.guarantorinfo = guarantorinfo;
	}
	public Collateralinfo getCollateralinfo() {
		return collateralinfo;
	}
	public void setCollateralinfo(Collateralinfo collateralinfo) {
		this.collateralinfo = collateralinfo;
	}
	
}
