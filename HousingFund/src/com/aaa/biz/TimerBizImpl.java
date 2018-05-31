package com.aaa.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.UtinaccountinfoUtilDao;
import com.aaa.entity.Flupay;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinremittancedetail;

@Service
@Transactional
public class TimerBizImpl implements TimerBiz {

	@Resource
	private UtinaccountinfoUtilDao utdao;
	
	public void timersucc(){
		 Date date=new Date();
		 //获取当前约束月数
		 SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM");
		 String currtime=fmt.format(date);
		 System.out.println(currtime);
		
		 //得到所有开启定时任务的单位
		 List<Flupay> flist= utdao.selefu();
		 for (Flupay flupay : flist) {
			 //判断单位是否正常
			 System.out.println(flupay.getUtinaccountinfo().getUtinAccountId());
			 List<Utinaccountinfo> ut=utdao.ss(flupay.getUtinaccountinfo().getUtinAccountId());
		     
			 if(ut.size()>0){
		    	//查看本月是否交过
				 System.out.println(999);
					List utlist=utdao.sele_uddate(ut.get(0).getUtinAccountId());
					//是否有缴存纪录
					if(utlist.size()>0){
						//截取年月
						System.out.println(utlist.get(0));
					
						String utdate=utlist.get(0).toString();
						String substr=utdate.substring(0, 7);
						
						System.out.println(substr);
						//判断当前月数是否等于最后一次缴存月数
						if(currtime.equals(substr)){
							
							//如果等于不往下执行
							
						}else{
							//不等于往下执行
							//得到需要交的总钱数
							Double utsummoney=utdao.UtinSumMoneySele(ut.get(0).getUtinAccountId());
							System.out.println(utsummoney);
							//得到账户余额
							Double money=utdao.sele_yue(ut.get(0).getUtinAccountId());
							System.out.println(money);
							//如果余额大于等于总缴纳金执行
							if(money>=utsummoney){
								System.out.println(111);
								//查询所有个人账户 id 
							
							List<Indaccountinfo> indlist=utdao.sele_Allindinfo(ut.get(0).getUtinAccountId());
							
							//修改个人账户
							for (Indaccountinfo ind : indlist) {
								//查询个人账户在修改 添加个人缴存纪录
						utdao.sele_oneindinfo(ut.get(0).getUtinAccountId(), 
								ind.getIndAccountId(),ut.get(0).getUtinName());
						
							}
							//修改单位账户余额
							utdao.update_utinmoney(ut.get(0).getUtinAccountId(), utsummoney);
							//添加单位汇缴纪录
							utdao.add_rd(ut.get(0).getUtinAccountId(), utsummoney);
							
							}else{
								
								//不执行
							}
							
						}
		    	 
		     }
		 }
		//得到所有正常单位
		//List<Utinaccountinfo> list=utdao.utinse();
		
		}

	}
	
}
