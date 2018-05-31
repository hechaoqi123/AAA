package com.aaa.dao;

import com.aaa.entity.RDUtil;
import com.aaa.entity.Remittancedetail;
import com.aaa.entity.Utinremittancedetail;

public interface RemittanceDetailDao extends BaseDao<Remittancedetail>{

	//汇缴之后  ——> 添加个人汇缴明细
	public abstract int sava_RemittanceDetail(RDUtil rdu, Remittancedetail rd);

	//汇缴之后  ——> 添加单位汇缴明细
	public abstract int sava_UtInRemittanceDetail(RDUtil rdu,Utinremittancedetail rd);

}