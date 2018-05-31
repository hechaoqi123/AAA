package com.aaa.biz;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.RemittanceDetailDaoImpl;
import com.aaa.entity.*;
@Transactional
@Service
public class RemittanceDetailBizImpl implements RemittanceDetailBiz {

	@Resource
	private RemittanceDetailDaoImpl dao;
	
	//汇缴之后  ——> 添加个人汇缴明细
	@Override
	public int sava_RemittanceDetail(RDUtil rdu,Remittancedetail rd){
		dao.sava_RemittanceDetail(rdu, rd);
		return 0;
	}
	//汇缴之后  ——> 添加单位汇缴明细
	@Override
	public int sava_UtInRemittanceDetail(RDUtil rdu,Utinremittancedetail rd){
		dao.sava_UtInRemittanceDetail(rdu, rd);
		return 0;
	}
	
	//汇缴记录查询
	 @Transactional(readOnly=true)
	   public List<Remittancedetail> findRecord(String indAccountId) {
		 Criterion[] criterion={Restrictions.eq("indAccountId", indAccountId)};
		   return dao.findByCriteria(criterion,Order.desc("depositInfoId"));
	  }
}
