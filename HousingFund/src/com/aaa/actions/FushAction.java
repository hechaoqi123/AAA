package com.aaa.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.FushBiz;
import com.aaa.biz.LogBiz;
import com.aaa.entity.Fush;
import com.aaa.entity.Log;
import com.aaa.entity.PageEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 冲还贷用户
 * */
@ParentPackage("struts-default")
@Controller
public class FushAction extends BaseAction<Fush>{
   @Autowired
   private FushBiz biz;
   @Autowired
   private LogBiz logBiz;
   private PageEntity entity;
 //日志查询
   @Action(value="getAllLog",results={@Result(name="success",location="/BackJsp/hcq/showLog.jsp")})
   public String getAllLog(){
	     Map map=(Map) ActionContext.getContext().get("request");
	        map.put("list",logBiz.getAll());
	   return SUCCESS;
   }
//分页查询
   @Action(value="getPart",results={@Result(name="success",location="/BackJsp/hcq/destroy_beforeLoan.jsp")})
   public String getPart(){
	 //添加限制条件
	   Criterion criterion=null;
	    String iphone=getModel().getIphone();
	     if(iphone!=null){
	       criterion=Restrictions.like("iphone", iphone,MatchMode.ANYWHERE);
	     }
      //条件判断
	        if(entity==null){
	    	   entity=new PageEntity();   
	         }
		       entity.setMaxResult(11);
   	//查询
	    entity=biz.getPart(entity, criterion);
	    return SUCCESS;
   }
//查看个人冲贷详情
   @Action(value="check_push",results={@Result(name="success",location="/BackJsp/hcq/check_push.jsp")})
     public String check_push(){//查询个人日志  及个人信息
	       Fush push=biz.getOne(getModel().getId());//个人冲贷信息
	       List<Log> list=new ArrayList(push.getLogs());
	          //冒泡排序
	       for(int j=0;j<list.size();j++){
	    	   for(int i=0;i<list.size()-1-j;i++){
		        	  if(list.get(i).getId()> list.get(i+1).getId()){
		        		  Log min=list.get(i+1);
		        		  Log max=list.get(i);
		        		  list.set(i, min);
		        		  list.set(i+1, max);
		        	  }
		          }
	       }
	      Map map=(Map) ActionContext.getContext().get("request");
	        map.put("push",push);
	        map.put("list", list);
	   return SUCCESS;
   }
  //冻结
	@Action(value="logout",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
	public String logout(){
		  biz.update(getModel().getId(), "冻结");
		return SUCCESS;
	}
  //激活
	@Action(value="renew",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
    public String renew(){
		biz.update(getModel().getId(), "正常");
		return SUCCESS;
	}
  //删除
	@Action(value="removePush",results={@Result(name="success",location="/BackJsp/hcq/SUCCESS.jsp")})
    public String removePush(){
		biz.remove(getModel().getId());
		return SUCCESS;
	}   
   //get  set
    public PageEntity getEntity() {
		return entity;
	}
	public void setEntity(PageEntity entity) {
		this.entity = entity;
	}
	
}
