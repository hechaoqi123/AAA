package com.aaa.biz;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.CollateralinfoDao;
import com.aaa.dao.GuarantorinfoDao;
import com.aaa.dao.LoanApplicationDao;
import com.aaa.dao.LoanaccountinfoDao;
import com.aaa.entity.Collateralinfo;
import com.aaa.entity.Collateralvalueestimate;
import com.aaa.entity.Guarantorinfo;
import com.aaa.entity.Guarantorinfoestimate;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.PageEntity;
@Service
@Transactional
public class LoanaccountinfoBizImpl implements LoanaccountinfoBiz {
   @Autowired
   LoanaccountinfoDao dao;
   @Autowired
   LoanApplicationDao loanDao;
   @Autowired
   CollateralinfoDao collDao;
   @Autowired
   GuarantorinfoDao guarDao;
   
   
 //获取贷款信息
   @Transactional(readOnly=true)
   public Loanaccountinfo findByExample(Loanaccountinfo entity) {
	return dao.findByExample(entity).get(0);
  }
//担保（抵押）价值评定   
  public void save(Loanaccountinfo accountEntity, Loanapplication loanentity) {
	//修改申请书状态，查询贷款信息（ID,申请书编号）//抵押物(需要传入一个抵押物的ID即可,位置,评估价值，所属人)
	  loanentity=loanDao.getOne(loanentity.getLoanApplicationId());
	      loanentity.setStatus("已评估");
	      loanDao.save(loanentity);
	      //获得贷款信息
	  	  Criterion[] criterions={Restrictions.eq("remarks",String.valueOf(loanentity.getLoanApplicationId()))};
	  	Loanaccountinfo account=dao.findByCriteria(criterions, null).get(0);//贷款信息
	  	   account.setLoanDisbur(accountEntity.getLoanDisbur());
	  	   account.setLoanRate(accountEntity.getLoanRate());
	  	   account.setLoanPeriod(accountEntity.getLoanPeriod());
	      if(accountEntity.getCollateralinfos().size()>0){//抵押物抵押
	    	    Collateralvalueestimate collti=accountEntity.getCollateralinfo().getCollateralvalueestimate();//抵押物价值评估
	    	    Collateralinfo coll= collDao.getOne(accountEntity.getCollateralinfo().getCollateralInfoId());//抵押物
	    	      coll.setCollateralvalueestimate(collti);
	    	      System.out.println("jiazhi="+ accountEntity.getCollateralinfo().getPawnValueEsti());
	    	      coll.setPawnValueEsti(accountEntity.getCollateralinfo().getPawnValueEsti());
	    	      account.getCollateralinfos().add(coll);
	      }
	      if(accountEntity.getGuarantorinfos().size()>0){//担保人担保
	    	  Guarantorinfoestimate guarti=accountEntity.getGuarantorinfo().getGuarantorinfoestimate();//担保人价值品评估
	    	  Guarantorinfo guar=guarDao.getOne(accountEntity.getGuarantorinfo().getGuarantorInfoId());//担保人信息
	    	         guar.setGuarantorinfoestimate(guarti);
	    	         account.getGuarantorinfos().add(guar);
	      }
	      dao.save(account);
 } 
    //获取抵押物信息	
  @Transactional(readOnly=true)
public Collateralinfo getColl(int loanId) {
	     Criterion[] criterions={Restrictions.eq("remarks",String.valueOf(loanId))};
	     Collateralinfo c=dao.findByCriteria(criterions, null).get(0).getCollateralinfo();
	     System.out.println(c);
	     System.out.println("ww"+c.getPawnValueEsti());
	return dao.findByCriteria(criterions, null).get(0).getCollateralinfo();
}
  //获取担保人信息
  @Transactional(readOnly=true)
public Guarantorinfo getGuar(int loanId) {
	 Criterion[] criterions={Restrictions.eq("remarks", String.valueOf(loanId))};
	return dao.findByCriteria(criterions, null).get(0).getGuarantorinfo();
}

	
}
