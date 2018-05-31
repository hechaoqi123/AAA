package com.aaa.dao;

import com.aaa.entity.Repaymentplandetails;

public interface RepaymentPlanDetailsDao extends BaseDao<Repaymentplandetails>{

	//删除无效还款计划
		public void del();
}