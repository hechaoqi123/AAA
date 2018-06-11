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
	

	//0 0 12 L * ? ÿ���µ�12��ִ��
	//0/10 * * * * ? 10�� ִ��һ��

	//0/10 * * * * ? 10��ִ��һ��
     @Scheduled(cron = "0 0 12 * * ?") //0 0 12 * * ?  ÿ������12�㴥�� 

	public  void ss(){
		

				
				Calendar calendar=Calendar.getInstance(); //����
	              int year=calendar.get(Calendar.YEAR);//��
	              int month=calendar.get(Calendar.MONTH);//��
	              int  day=calendar.get(Calendar.DATE);//��
	            
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
