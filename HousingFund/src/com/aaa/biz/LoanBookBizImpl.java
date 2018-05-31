package com.aaa.biz;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.LoanApplicationDao;
import com.aaa.dao.LoanBookDao;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Loanbook;
import com.aaa.entity.PageEntity;
@Service
@Transactional
public class LoanBookBizImpl implements LoanBookBiz {
   @Autowired
   LoanBookDao loanDao;
   @Autowired
   LoanApplicationDao dao;
   //查询账户贷款信息
   @Transactional(readOnly=true)
	public List<Loanbook> findAll(String accountId) {
	  Loanapplication app = dao.getOne(Integer.valueOf(accountId));
	   accountId=app.getIndAccount();
	   String accountId2=null;
	   if(app.getCoborrower()!=null){
		   accountId2=app.getCoborrower().getCoborrowerAccount();
	   }
	   System.out.println("个人账户IdaccountId"+accountId);
	   System.out.println("个人账户IdaccountId"+accountId2);
		Criterion[] criterions={Restrictions.or(Restrictions.eq("loanAccount", accountId), Restrictions.eq("loanAccount", accountId2))};
		return loanDao.findByCriteria(criterions, Order.desc("loanBookId"));
	}


}
