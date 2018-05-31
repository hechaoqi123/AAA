package com.aaa.task;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.aaa.biz.TimerBiz;
import com.aaa.dao.UtinaccountinfoUtilDao;

@Controller
public class TimerTest {

	@Resource
	private  TimerBiz ti;
	
	//0/10 * * * * ? 10秒执行一次
	// @Scheduled(cron = "0 0 12 * * ?") //0 0 12 * * ?  每天中午12点触发 
	public  void ss(){
		

				
				Calendar calendar=Calendar.getInstance(); //日历
	              int year=calendar.get(Calendar.YEAR);//年
	              int month=calendar.get(Calendar.MONTH);//月
	              int  day=calendar.get(Calendar.DATE);//天
	            
	              calendar.set(Calendar.YEAR, year);
	              calendar.set(Calendar.MONTH,month);
	              int end=calendar.getActualMaximum(calendar.DAY_OF_MONTH);
	              int begin=calendar.getActualMinimum(calendar.DAY_OF_MONTH);
			
				if(end==day){
					
					ti.timersucc();
					
				}else{
					System.out.println(false);
				}
				
			
	}
	
	
}
