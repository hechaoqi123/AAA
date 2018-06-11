package com.aaa.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.BeforereturnDao;
import com.aaa.dao.BorrDao;
import com.aaa.dao.RepaymentPlanDetailsDao;
import com.aaa.entity.Beforereturn;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Repaymentplandetails;
//提前还款
@Service
@Transactional
public class BeforereturnBizImpl implements BeforereturnBiz {
	@Autowired
	private BeforereturnDao dao;
	@Autowired
	BorrDao borrDao;
	@Autowired
	RepaymentPlanDetailsDao repayDao;
   //提交提前还款申请
	@Override
	public void save(Beforereturn entity) {
		Integer id=entity.getBorrowmoneyagreement().getBorrowMoneyAgreementId();
		entity.setStatus("待审");
		entity.setBorrowmoneyagreement(borrDao.getOne(id));
		 dao.save(entity);
	}
	//查询未审核的提前还款申请
	public List find() {
		return dao.findByCriteria(new Criterion[]{Restrictions.eq("status", "待审")}, Order.asc("id"));
	}
	//获取提前还款申请信息
	@Override
	public Beforereturn getBefore(Integer id) {
		Beforereturn before=dao.getOne(id);
		before.setBorrowmoneyagreement(borrDao.getOne(before.getBorrowmoneyagreement().getBorrowMoneyAgreementId()));
		return before;
	}
	//通过申请
	@Override
	public void success(Beforereturn entity) {
		//改变申请状态，
		  Beforereturn before=dao.getOne(entity.getId());
		   before.setStatus("已通过");
		   if(before.getReturnType().equals("全部结清")){
			    //全部结清:遍历所有还款计划(删除未还款记录,添加提前还款记录)
			   Borrowmoneyagreement borr = before.getBorrowmoneyagreement();
			   Set<Repaymentplandetails> set = borr.getRepaymentplandetailses();
			   List list=new ArrayList();
			   for (Repaymentplandetails repay : set) {
					if(repay.getRepaymentStatus().equals("未还")||repay.getRepaymentStatus().equals("逾期未还")){
						list.add(repay);
					}
				}
			   Repaymentplandetails re=(Repaymentplandetails) list.get(list.size()-1);
			   for (Object object : list) {
				  set.remove(object);
			  }
			   re.setCurrentReturnedInterest(Float.valueOf(before.getAfterlixi()));//利息
			   re.setCurrentReturnedCorpus(Float.valueOf(before.getAfterMoney()));//本金
			   re.setRepaymentsReceived(re.getCurrentReturnedCorpus()+re.getCurrentReturnedInterest());//实收金额
			   re.setAmountOfRepayRecei(re.getRepaymentsReceived());//应还金额
			   re.setRepaymentDate(new Date());//还款日期
			   re.setRepaymentStatus("提前还款");
			   set.add(re);
			   repayDao.del();
			   }else if(before.getReturnType().equals("部分还款")){
			   //部分还款：遍历所有还款计划,修改本金及利息 添加提前还款记录
			   System.out.println("----部分还款----");
			   Borrowmoneyagreement borr = before.getBorrowmoneyagreement();
			   Set<Repaymentplandetails> set = borr.getRepaymentplandetailses();
			   List list=new ArrayList();
			     for (Repaymentplandetails repay : set) {
					if(repay.getRepaymentStatus().equals("未还")){
					    list.add(repay);
					}
				}
			     int count=list.size();//剩余期数
			        //每期应还本金=(未还本金-提前还款本金)/剩余期数
			    double money=(Integer.valueOf(before.getAfterMoney())-before.getMoney()*10000)/count;//每期应还金额
			       //每期应还利息=(总利息)/剩余期数
			    Double lixi=(double) ((Float.valueOf(before.getAfterMoney())-before.getMoney()*10000)*((borr.getBorrowerAnnualRate()/100)*count/12)/count);//每期应还利息
			    for (Repaymentplandetails repay : set) {
					if(list.contains(repay)){
			   repay.setCurrentReturnedInterest(Float.valueOf(lixi.toString()));//利息
			   repay.setCurrentReturnedCorpus((float)money);//本金
			     //应还金额
			   repay.setAmountOfRepayRecei((float) (money+lixi));
					}
				}
			    //生成提前还款记录
			    Repaymentplandetails instance=new Repaymentplandetails(); 
			    instance.setCurrentPeriod(0);
			    instance.setCurrentReturnedCorpus(Float.valueOf(before.getMoney()*10000));
			    //部分提前还款不计算利息
			    //instance.setCurrentReturnedInterest(before.getMoney()*10000*(borr.getBorrowerFixedYear()-count)/12*borr.getBorrowerAnnualRate()/100);
			    instance.setRepaymentsReceived(instance.getCurrentReturnedCorpus());//实收金额
			    instance.setAmountOfRepayRecei(instance.getRepaymentsReceived());//应还金额
			    instance.setRepaymentStatus("提前还款");
			    instance.setRepaymentDate(new Date());//还款日期
				set.add(instance);
		   }else{
			   System.out.println("异常的提前还款申请！");
		   }
	}
	//申请驳回
	@Override
	public void error(Beforereturn entity) {
		String remark=entity.getRemark();//驳回信息
		Beforereturn before=dao.getOne(entity.getId());
		before.setStatus("已驳回");
		before.setRemark(remark);
	}
	
}
