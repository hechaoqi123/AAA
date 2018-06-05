package com.aaa.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aaa.biz.IndaccountinfoBiz;
import com.aaa.entity.Indaccountinfo;
import com.aaa.util.JSON;
/**�����˻���Ϣ**/
@Controller
@ParentPackage("struts-default")
@Scope("properties")
public class IndAccountInfoAction extends BaseAction<Indaccountinfo> {
	 @Autowired
	IndaccountinfoBiz biz;
	 //��ȡ�����˻���Ϣ
   @Action("get_IndAccountInfo")
   public String get_IndAccountInfo(){
	   try {
		   Object entity=biz.getOne(getModel().getIndAccountId());
		   if(entity==null){
			   System.out.println("������");
			   getOut().print(false);
		   }else{
			   System.out.println("����");
			   getOut().print(true);  
		   }
	} catch (Exception e) {
		e.printStackTrace();
	}
	   return null;
   }
   //��ȡ�����˻���Ϣ
   @Action("get_Ind")
   public String get_Ind(){
	   List list=biz.fingByExample(getModel());
	   if(list.size()>0){
		   getOut().print(JSON.toJson(list.get(0)));
	   }
	   return null;
   }
   
}
