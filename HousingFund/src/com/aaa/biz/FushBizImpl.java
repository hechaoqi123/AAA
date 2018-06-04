package com.aaa.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.BorrDao;
import com.aaa.dao.FushDao;
import com.aaa.dao.IndAccountinfoDao;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Fush;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Log;
import com.aaa.entity.PageEntity;
import com.aaa.entity.Repaymentplandetails;
@Service
@Transactional
//冲还贷业务办理
public class FushBizImpl implements FushBiz {
	@Autowired
	private FushDao dao;
	@Autowired
	private BorrDao borrDao;
	@Autowired
	private  RepaymentPlanDetailsBiz repayBiz;
	@Autowired
	private  BorrBiz borrBiz;
	@Autowired
	private  LogBiz logBiz;
	@Autowired
	private  IndaccountinfoBiz indBiz;
 //业务办理
	@Override
	public void work(Fush entity) {
		Borrowmoneyagreement borr = borrDao.getOne(entity.getBorrowmoneyagreement().getBorrowMoneyAgreementId());
		entity.setBorrowmoneyagreement(borr);
		dao.save(entity);
	}
  //查询所有
	@Override
	public List getAll() {
		return dao.getAll();
	}
	
  //冲还贷	
	@Override
	public void work2() {
		 SimpleDateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
		try {
		    List<Fush> list=getAll();
		     System.out.println("冲贷数量:"+list.size());
		     for (Fush fush : list) {
		    	 
		    	 if(fush.getStatus().equals("正常")){
		    //取出还款记录
		    	  Repaymentplandetails repay = borrBiz.getRepay(fush.getBorrowmoneyagreement());
		        if(repay==null){//未查询到未还款记录
		        	  System.out.println("异常还款");
		        	  Log log=new Log();
		        	  log.setFush(fush);
		        	  log.setRiqi(fmt.format(new Date()));
		        	  log.setStatus("失败");
		        	  log.setRepaymentplandetails(repay);
		        	  log.setRemark("无未还贷款。");
		        	  fush.setStatus("冻结");
		        	    //记录日志
		        	  logBiz.add(log);
		        	  continue;
		        }
		            	  
		    	  
		    //进行还款
		         //账户余额
		             Indaccountinfo ind=new Indaccountinfo();
		             ind.setIdnumber(repay.getBorrowmoneyagreement().getBorrowerIdno());
		             int money=indBiz.getMoney(ind);
	             //应还金额
	 	        float money2 = repay.getAmountOfRepayRecei()+repay.getOverduePrincipalAndInte();
		          if(money>=money2){//正常还款
		        	  System.out.println("正常还款");
		        	     //个人账户金额减少  还款状态改变   记录日志
		        	  indBiz.return_loan(ind,money2);
		        	  borrBiz.return_loan(repay.getRepaymentPlanDetailsiId());
		        	   Log log=new Log();
		        	      log.setFush(fush);
		        		  log.setMoney(String.valueOf(money2));
		        		  System.out.println("repay"+repay);
			        	  log.setRepaymentplandetails(repay);
			        	  log.setRiqi(fmt.format(new Date()));
			        	  log.setStatus("成功");
			        	  log.setRemark("还款成功。");
		        	  logBiz.add(log);
		          }else{//异常还款（还款失败：金额不足）
		        	  System.out.println("异常还款");
		        	  Log log=new Log();
		        	  log.setFush(fush);
		        	  log.setRepaymentplandetails(repay);
		        	  log.setMoney(String.valueOf(money2));
		        	  log.setRiqi(fmt.format(new Date()));
		        	  log.setStatus("失败");
		        	  log.setRemark("余额不足。");
		        	    //记录日志
		        	  logBiz.add(log);
		          }
		    	 
			}
		     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//分页查询
	@Override
	public PageEntity getPart(PageEntity entity, Criterion criterion) {
		return dao.findByPage(entity, Order.asc("id"), criterion);
	}
	//获取个人冲贷信息
	@Override
	public Fush getOne(Integer id) {
		return dao.getOne(id);
	}
	//修改状态
	@Override
	public void update(int id, String status) {
		dao.getOne(id).setStatus(status);
	}
	//删除记录
	@Override
	public void remove(int id) {
		dao.delect(dao.getOne(id));
	}
	

}
