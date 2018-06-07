package com.aaa.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.biz.BorrBiz;
import com.aaa.biz.FushBiz;
import com.aaa.biz.IndaccountinfoBiz;
import com.aaa.biz.LogBiz;
import com.aaa.biz.RepaymentPlanDetailsBiz;
import com.aaa.entity.Fush;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Log;
import com.aaa.entity.Repaymentplandetails;

@Component
public class TimingTask {
	@Autowired
	 RepaymentPlanDetailsBiz repayBiz;
	@Autowired
	 FushBiz fushBiz;
    //计算逾期
	//@Scheduled(cron="0/50 * * * * ?")   //20秒扫描一次
	//@Scheduled(cron="0 0 6 * * ? ")     //每天6点执行
	public void work(){
		System.out.println("---开始计算逾期利息---");
		repayBiz.task();
	}
	//@Scheduled(cron="0/50 * * * * ?")  //50秒扫描一次
	//@Scheduled(cron="0 0 8 20 * ?")    //每月20号8点扫描
	//冲贷还款
	public void work2(){
		System.out.println("---开始进行冲贷还款---");
		fushBiz.work2();
	}
}
