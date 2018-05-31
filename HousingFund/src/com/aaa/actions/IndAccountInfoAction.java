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
/**个人账户信息**/
@Controller
@ParentPackage("struts-default")
@Scope("properties")
public class IndAccountInfoAction extends BaseAction<Indaccountinfo> {
	 @Autowired
	IndaccountinfoBiz biz;
	 //获取个人账户信息
   @Action("get_IndAccountInfo")
   public String get_IndAccountInfo(){
	   List entity=biz.fingByExample(getModel());
	   System.out.println(entity.toString());
	   if(entity.size()<1){
		   getOut().print(false);
	   }else{
		   getOut().print(true);  
	   }
	   return null;
   }
   //获取个人账户信息
   @Action("get_Ind")
   public String get_Ind(){
	   List list=biz.fingByExample(getModel());
	   if(list.size()>0){
		   getOut().print(JSON.toJson(list.get(0)));
	   }
	   return null;
   }
   
}
