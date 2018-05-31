package com.aaa.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.*;
import com.aaa.entity.Mpfacentrestat;

@Repository
public class RemittanceDetailDaoImpl  extends BaseDaoImpl<Remittancedetail> implements RemittanceDetailDao {

	@Resource
	private HibernateTemplate ht;
	
	//汇缴之后  ——> 添加个人汇缴明细
	/* (non-Javadoc)
	 * @see com.aaa.dao.RemittanceDetailDao#sava_RemittanceDetail(com.aaa.entity.RDUtil, com.aaa.entity.Remittancedetail)
	 */
	@Override
	public int sava_RemittanceDetail(RDUtil rdu,Remittancedetail rd){
		SimpleDateFormat f=new SimpleDateFormat("yyyy-mm-dd HH:mm");
		
		Date d=new Date(new java.util.Date().getTime());
		
		 //现在时间
		Utinaccountinfo ut=new Utinaccountinfo();
		ut.setUtinAccountId(rdu.getUtinAccountId());
		rd.setUtinaccountinfo(ut);
		
		rd.setIndAccountId(rdu.getIndAccountId().toString());
		rd.setUtinAccount(rdu.getUtinName());
		rd.setPayinSumMoney(rdu.getPayinSumMoney());
		rd.setIndAccount(rdu.getIndAccountId().toString());
		rd.setPayinDate(d);
		ht.save(rd);
		ht.clear();
	
		return 0;
	}
	//汇缴之后  ——> 添加单位汇缴明细
	/* (non-Javadoc)
	 * @see com.aaa.dao.RemittanceDetailDao#sava_UtInRemittanceDetail(com.aaa.entity.RDUtil, com.aaa.entity.Remittancedetail)
	 */
	@Override
	public int sava_UtInRemittanceDetail(RDUtil rdu,Utinremittancedetail rd){
  SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String time=f.format(new Date());
		
		
		Utinaccountinfo ut=new Utinaccountinfo();
		ut.setUtinAccountId(rdu.getUtinAccountId());
		rd.setUtinaccountinfo(ut);
		
		rd.setUtinName(rdu.getUtinName());
		rd.setPayinSumMoney((double)rdu.getSummoney());
		rd.setDepositPeople(rdu.getDepositPeople());
		rd.setDepositDate(time);
		rd.setAdminname(rdu.getAdminname());
		rd.setOridate(rdu.getOridate());
		rd.setFinaldate(rdu.getFinaldate());
		rd.setRemonth(rdu.getRemonth());
		ht.save(rd);
		ht.clear();
		
		//添加到积金中心统计
		Mpfacentrestat m=new Mpfacentrestat();
		double mo=rdu.getSummoney();
		m.setAggregateSumStat((float)mo);
		m.setStatisticalTime(new java.sql.Date(new java.util.Date().getTime()));
		ht.save(m);
		ht.clear();
		return 0;
	}
}
