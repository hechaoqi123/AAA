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
   
   
 //��ȡ������Ϣ
   @Transactional(readOnly=true)
   public Loanaccountinfo findByExample(Loanaccountinfo entity) {
	return dao.findByExample(entity).get(0);
  }
//��������Ѻ����ֵ����   
  public void save(Loanaccountinfo accountEntity, Loanapplication loanentity) {
	//�޸�������״̬����ѯ������Ϣ��ID,�������ţ�//��Ѻ��(��Ҫ����һ����Ѻ���ID����,λ��,������ֵ��������)
	  loanentity=loanDao.getOne(loanentity.getLoanApplicationId());
	      loanentity.setStatus("������");
	      loanDao.save(loanentity);
	      //��ô�����Ϣ
	  	  Criterion[] criterions={Restrictions.eq("remarks",String.valueOf(loanentity.getLoanApplicationId()))};
	  	Loanaccountinfo account=dao.findByCriteria(criterions, null).get(0);//������Ϣ
	  	   account.setLoanDisbur(accountEntity.getLoanDisbur());
	  	   account.setLoanRate(accountEntity.getLoanRate());
	  	   account.setLoanPeriod(accountEntity.getLoanPeriod());
	      if(accountEntity.getCollateralinfos().size()>0){//��Ѻ���Ѻ
	    	    Collateralvalueestimate collti=accountEntity.getCollateralinfo().getCollateralvalueestimate();//��Ѻ���ֵ����
	    	    Collateralinfo coll= collDao.getOne(accountEntity.getCollateralinfo().getCollateralInfoId());//��Ѻ��
	    	      coll.setCollateralvalueestimate(collti);
	    	      System.out.println("jiazhi="+ accountEntity.getCollateralinfo().getPawnValueEsti());
	    	      coll.setPawnValueEsti(accountEntity.getCollateralinfo().getPawnValueEsti());
	    	      account.getCollateralinfos().add(coll);
	      }
	      if(accountEntity.getGuarantorinfos().size()>0){//�����˵���
	    	  Guarantorinfoestimate guarti=accountEntity.getGuarantorinfo().getGuarantorinfoestimate();//�����˼�ֵƷ����
	    	  Guarantorinfo guar=guarDao.getOne(accountEntity.getGuarantorinfo().getGuarantorInfoId());//��������Ϣ
	    	         guar.setGuarantorinfoestimate(guarti);
	    	         account.getGuarantorinfos().add(guar);
	      }
	      dao.save(account);
 } 
    //��ȡ��Ѻ����Ϣ	
  @Transactional(readOnly=true)
public Collateralinfo getColl(int loanId) {
	     Criterion[] criterions={Restrictions.eq("remarks",String.valueOf(loanId))};
	     Collateralinfo c=dao.findByCriteria(criterions, null).get(0).getCollateralinfo();
	return dao.findByCriteria(criterions, null).get(0).getCollateralinfo();
}
  //��ȡ��������Ϣ
  @Transactional(readOnly=true)
public Guarantorinfo getGuar(int loanId) {
	 Criterion[] criterions={Restrictions.eq("remarks", String.valueOf(loanId))};
	return dao.findByCriteria(criterions, null).get(0).getGuarantorinfo();
}

	
}
