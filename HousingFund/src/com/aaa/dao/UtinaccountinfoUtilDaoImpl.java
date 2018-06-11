package com.aaa.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.*;
import com.aaa.util.TeacherPageUtil;


@Repository
public class UtinaccountinfoUtilDaoImpl implements UtinaccountinfoUtilDao {

	@Resource
	private HibernateTemplate ht;
	@Resource
	private TeacherPageUtil util;
	
	@Override
	public Double UtinSumMoneySele(Integer UtinId) {
		
		List list= ht.find("select SUM((IndDepositRadices*IndDepositRatio)*2) from Indaccountinfo where UtinAccountID="+UtinId+"  and indStatus='正常'");
		Double m=(Double)list.get(0);
		return m;
	}
	public List<Utinaccountinfo> ss(int id){
		
		
		List<Utinaccountinfo> list=ht.find(
				"from Utinaccountinfo  where UtinAccountID="+id+" and accountStatus='正常'");
	return list;
	}
	public List<Flupay> selefu(){
		
		List<Flupay> list=ht.find(" from Flupay where ifelseFp='是'");
		return list;
	}
	
	//添加或者修改
		public int upinse(Flupay fu){
			List<Flupay> list=ht.find("from Flupay f where f.utinaccountinfo.utinAccountId="+fu.getUtinaccountinfo().getUtinAccountId()+"");
			
			
			if(list.size()>0){
				
				Flupay f=ht.get(Flupay.class,list.get(0).getFluPayid());
				f.setIfelseFp(fu.getIfelseFp());
				ht.update(f);	
				
				return 1;
			}else{
				
				ht.save(fu);
				return 1;
			}
			
		}
	
	@Override
	public List UtinInfoSele(Integer UtinId) {
		try {
			List list=ht.find("select new map(" +
					            "utinAccountId as utinAccountId," +
								"accountStatus as accountStatus," +
								"utinDepositRatio as utinDepositRatio," +
								"utinSumPeople as utinSumPeople," +
								"utinDepositPeople as utinDepositPeople," +
								"utinSealPeople as utinSealPeople," +
								"utinName as utinName," +
								"utinProvRema as utinProvRema"+
								") from Utinaccountinfo  where utinAccountId="+UtinId+"");
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
	//单位员工信息
	@Override
	public List IndAccountInfoSele(Integer UtinId) {
		try {
			List list=ht.find("select  new map(i.indAccountId as indAccountId,i.idnumber as iDNumber,i.trueName as trueName,i.indDepositRadices as indDepositRadices,i.indDepositRatio as indDepositRatio,i.presentSumRem as presentSumRem,i.usableRem as usableRem) from Indaccountinfo i where i.indStatus='正常'  and  i.utinaccountinfo.utinAccountId="+UtinId+"");
			
			return list;
		} catch (Exception e) {
			System.out.println("UtinaccountinfoUtilDaoImpl中的IndAccountInfoSele方法出现异常：异常信息如下");
			e.printStackTrace();
		}
		return null;
	}
	//查询上次汇缴
   public List sele_date(Integer UtinId){
		
		List list= ht.find("select new map(u.payinSumMoney as PayinSumMoney,u.depositPeople as DepositPeople,u.depositDate as DepositDate ) from Utinremittancedetail u where u.utinaccountinfo.utinAccountId="+UtinId+" ORDER BY   STR_TO_DATE(u.depositDate,'%Y-%m-%d %H:%i') DESC ");
	     
		return list;
	}
 //查询单位
 		public TeachaerPageEntity sele_utin(TeachaerPageEntity page){
 			String sql="select new map(u.utinAccountId as utinAccountId," +
 					"u.accountStatus as accountStatus,u.utinName as utinName," +
 					"u.unitinfo.utinAddress as utinAddress," +
 					"u.unitinfo.corpRepr as corpRepr," +
 					"u.unitinfo.operatorName as operatorName) " +
 					"from Utinaccountinfo u where u.accountStatus='正常' order by u.utinAccountId";
 			//String sql="from Proof";
 			TeachaerPageEntity pa=util.getPage(sql, page);
 			
 			return pa;
 		}
 		//单位id模糊查询
 				public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids){
 					String sql="select new map(u.utinAccountId as utinAccountId," +
 		 					"u.accountStatus as accountStatus,u.utinName as utinName," +
 		 					"u.unitinfo.utinAddress as utinAddress," +
 		 					"u.unitinfo.corpRepr as corpRepr," +
 		 					"u.unitinfo.operatorName as operatorName) " +
 		 					"from Utinaccountinfo u where u.accountStatus='正常' and u.utinAccountId  like '%"+ids+"%'";
 		 			//String sql="from Proof";
 		 			TeachaerPageEntity pa=util.getPage(sql, page);	
 					return pa;
 				}
 				//单位名称模糊查询
 				public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname){
 					
 					String sql="select new map(u.utinAccountId as utinAccountId," +
 		 					"u.accountStatus as accountStatus,u.utinName as utinName," +
 		 					"u.unitinfo.utinAddress as utinAddress," +
 		 					"u.unitinfo.corpRepr as corpRepr," +
 		 					"u.unitinfo.operatorName as operatorName) " +
 		 					"from Utinaccountinfo u where u.accountStatus='正常' and u.utinName  like '%"+utinname+"%'";
 		 			//String sql="from Proof";
 		 			TeachaerPageEntity pa=util.getPage(sql, page);	
 					return pa;	
 				}

 				//正常单位
				@Override
				public List<Utinaccountinfo> utinse() {
					// TODO Auto-generated method stub
					List<Utinaccountinfo> list=ht.find("from Utinaccountinfo where accountStatus='正常'");
					return list;
				}
				//本月是否缴纳过
				public List sele_uddate(int id){
					
					List utlist=ht.find("select depositDate from Utinremittancedetail ut " +
							"where ut.utinaccountinfo.utinAccountId="+id+" " +
									"order by STR_TO_DATE(DepositDate,'%Y-%m-%d') desc ");
					return utlist;
				}
				//得到账户余额
				public Double sele_yue(int id){
					
					List list=ht.find("select utinProvRema from Utinaccountinfo where utinAccountId="+id+"");
				  Double money=(Double) list.get(0);
				  return money;
				}
				//得到所有个人账户信息 
				public List<Indaccountinfo> sele_Allindinfo(int id){
					
			List<Indaccountinfo> list=ht.find(
							"from Indaccountinfo ind where" +
							" ind.utinaccountinfo.utinAccountId="+id+" and " +
							" ind.indStatus='正常'");
					return list;
				}
				//得到个人信息并修改
				public Indaccountinfo sele_oneindinfo(int uid,int iid,String uname){
					//先查询
					Indaccountinfo ind=ht.get(Indaccountinfo.class, iid);
					//账户余额=本余额+本月基数*比例*2
					ind.setPresentSumRem(ind.getPresentSumRem()+
							ind.getIndDepositRadices()*ind.getIndDepositRatio()*2);
					//可用余额同上
					ind.setUsableRem(ind.getUsableRem()+
							ind.getIndDepositRadices()*ind.getIndDepositRatio()*2);
					//修改
					ht.update(ind);
					
					//添加个人汇缴纪录
					Remittancedetail rd=new Remittancedetail();
					Utinaccountinfo uti=ht.get(Utinaccountinfo.class, uid);
					//单位账户外键
					rd.setUtinaccountinfo(uti);
					//个人账户id
					rd.setIndAccountId(Integer.toString(iid));
					rd.setUtinAccount(uname);
					rd.setIndAccount(Integer.toString(iid));
					rd.setPayinSumMoney(ind.getIndDepositRadices()*ind.getIndDepositRatio()*2);
					rd.setPayinDate(new Date(new java.util.Date().getTime()));
					ht.save(rd);
					
					return null;
				}
				//修改账户余额
				public int update_utinmoney(int id,Double money){
					Utinaccountinfo utin=ht.get(Utinaccountinfo.class, id);
					//修改单位余额
					utin.setUtinProvRema(utin.getUtinProvRema()-money);
					ht.update(utin);
					return 0;
				}
				//添加单位汇缴纪录
				public int add_rd(int id,Double money){
					Date d=new Date();
					SimpleDateFormat ftm=new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat ftm2=new SimpleDateFormat("yyyy-MM");
					String date=ftm.format(d);
					String month=ftm2.format(d);//月
					//单位汇缴纪录
					Utinremittancedetail ud=new Utinremittancedetail();
					Utinaccountinfo utin=ht.get(Utinaccountinfo.class, id);
					ud.setUtinaccountinfo(utin);
					ud.setUtinName(utin.getUtinName());
					ud.setPayinSumMoney(money);//总金额
					ud.setDepositPeople(utin.getUtinDepositPeople());//汇缴人数
					ud.setDepositDate(date);
					ud.setFinaldate(month);
					ud.setOridate(month);
					ud.setRemonth(Integer.toString(1));
					ud.setAdminname("自动汇缴");
					ht.save(ud);
					return 0;
				}
				
				//查询此单位是否存在
				
				public List sele_utinid(int id){
					
					String sql="select new map(utinAccountId as utinAccountId,utinName as utinName,utinDepositRatio as utinDepositRatio) from Utinaccountinfo where utinAccountId="+id+"";
					
               
					List list=ht.find(sql);
					return list;
				}
				//查询此单位是否开启业务了并 查询单位法人代表
				public List sele_fy(int id){
					String sql="select new map(u.utinAccountId as utinAccountId,"
							+ "u.unitinfo.utinName as utinName,"
							+ "u.unitinfo.corpRepr as corpRepr)"
							+ "from Utinaccountinfo u  where u.utinAccountId="+id+"";
					List list=ht.find(sql);
				
						return list;
					
				}
				//查询此单位的 冲缴状态 是否
				public List sele_uufy(int id){
					String sql="select new map(f.ifelseFp as ifelseFp)"
							+ "from Flupay f where f.utinaccountinfo.utinAccountId="+id+"";
					List list=ht.find(sql);
					return list;
				}
				
				
				
				}
   

