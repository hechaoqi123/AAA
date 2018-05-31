package com.aaa.biz;

import java.util.List;

import com.aaa.entity.RDUtil;
import com.aaa.entity.Remittancedetail;
import com.aaa.entity.Utinremittancedetail;

public interface RemittanceDetailBiz {

	//汇缴之后  ——> 添加个人汇缴明细
	public abstract int sava_RemittanceDetail(RDUtil rdu, Remittancedetail rd);

	//汇缴之后  ——> 添加单位汇缴明细
	public abstract int sava_UtInRemittanceDetail(RDUtil rdu,
			Utinremittancedetail rd);
	
	//查询汇缴记录
		public List<Remittancedetail> findRecord(String indAccountId);

}