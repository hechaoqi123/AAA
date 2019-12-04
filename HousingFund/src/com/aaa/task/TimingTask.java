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
    //��������
	//@Scheduled(cron="0/50 * * * * ?")//20��ɨ��һ��
	public void work(){
		System.out.println("---��ʼ����������Ϣ---");
		repayBiz.task();
	}
	//@Scheduled(cron="0/50 * * * * ?")
	//�������
	public void work2(){
		System.out.println("---��ʼ���г������---");
		fushBiz.work2();
	}
}
