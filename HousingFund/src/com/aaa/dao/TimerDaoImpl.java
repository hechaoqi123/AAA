package com.aaa.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Utinaccountinfo;

@Repository
public class TimerDaoImpl {

	@Resource
	private  HibernateTemplate ht;

	public List timer_sele_utinid(){
		 Date date=new Date();
		 //获取当前约束月数
		 SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM");
		 String currtime=fmt.format(date);
		 System.out.println(currtime);
		 //先获取所有正常单位账户
		List<Utinaccountinfo> list=ht.find("from Utinaccountinfo where accountStatus='正常'");
		
	for (Utinaccountinfo ut : list) {
		//查看本月是否交过
		System.out.println(ut.getUtinAccountId());
		List utlist=ht.find("select depositDate from Utinremittancedetail ut " +
				"where ut.utinaccountinfo.utinAccountId="+ut.getUtinAccountId()+" " +
						"order by STR_TO_DATE(DepositDate,'%Y-%m-%d') desc ");
		
		//有缴存纪录
		if(utlist.size()>0){
			System.out.println(utlist.get(0));
			String utdate=(String) utlist.get(0);
			String substr=utdate.substring(0, 7);
			
			System.out.println(substr);
			//判断当前月数是否等于最后一次缴存月数
			if(currtime.equals(substr)){
				//如果等于不往下执行
				
			}else{
				//不等于往下执行
				//得到需要交的总钱数
				//Double utsummoney=utdao.UtinSumMoneySele(ut.getUtinAccountId());
				//得到
				ht.find("select ");
			}
			
		}//
		
		
	}
		return null;
	}

}
