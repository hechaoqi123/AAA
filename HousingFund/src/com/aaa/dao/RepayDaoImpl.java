package com.aaa.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Borrowmoneyagreement;



@Repository
public class RepayDaoImpl extends BaseDaoImpl<Borrowmoneyagreement> implements RepayDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List getSevens(String BorrowerIdno){
		
		List list=hibernateTemplate.find("select new Map(r.borrowmoneyagreement.repaymentPlanDetailsiId as repaymentPlanDetailsiId,r.borrowmoneyagreement.repaymentMode as repaymentMode,r.borrowmoneyagreement.guarantorInfo as guarantorInfo,r.currentReturnedCorpus as currentReturnedCorpus,r.currentReturnedInterest as currentReturnedInterest,r.overduePrincipalAndInte as overduePrincipalAndInte,r.currentPeriod as currentPeriod,r.repaymentDate as repaymentDate) from Repaymentplandetails r where r.borrowmoneyagreement.borrowerIdno='"+BorrowerIdno+"'");
		return list;
		
	}
}

