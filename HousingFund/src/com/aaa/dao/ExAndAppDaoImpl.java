package com.aaa.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Causeofextraction;
import com.aaa.entity.Extractionandapproval;
import com.aaa.entity.Extractionrecord;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Materialproof;
import com.aaa.entity.Materialtype;
import com.aaa.entity.Mpfacentrestat;
import com.aaa.entity.TeachaerPageEntity;
import com.aaa.util.TeacherPageUtil;
import com.alibaba.fastjson.JSON;

@Repository
public class ExAndAppDaoImpl implements ExAndAppDao {

	@Resource
	private HibernateTemplate ht;
	@Resource
	private TeacherPageUtil  util;
	@Override
	public int Save_ExAndApp(Materialproof m,int reasonNo){
		/*Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time=s.format(d);*/
		Date d=new Date(new java.util.Date().getTime());
		m.getExtractdetails().getExtractionandapproval().setApprovalStatus("未审批");
		m.getExtractdetails().getExtractionandapproval().setApplicationtime(d);
		
		Causeofextraction c=ht.get(Causeofextraction.class, reasonNo);
		//m.getExtractdetails().setCauseofextractions(causeofextractions);
		m.getExtractdetails().getCauseofextractions().add(c);
		
		
		try {
			ht.save(m);
		
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;
	}
	//查询未审批
	public TeachaerPageEntity sele_ex(TeachaerPageEntity page){
		
		String sql="select new map(e.approvalNumberId as approvalNumberId,e.indaccountinfo.indAccountId as IndAccountID,e.applicationtime as applicationtime,e.workersName as workersName,e.bankOfDeposit as bankOfDeposit,e.payee as payee,e.collectionAccount as collectionAccount,e.approvalStatus as approvalStatus,e.withdrawalAmount as withdrawalAmount) from Extractionandapproval e where e.approvalStatus='未审批'";
		
			
		TeachaerPageEntity t=util.getPage(sql, page);
		
	
		return t;
	}
	//查询审批表信息
		public List sele_EAA(int appid){
			String sql="select new map(e.approvalNumberId as approvalNumberId,e.indaccountinfo.indAccountId as IndAccountID,DATE_FORMAT(e.applicationtime,'%Y-%m-%d') as applicationtime,e.workersName as workersName,e.bankOfDeposit as bankOfDeposit,e.payee as payee,e.collectionAccount as collectionAccount,e.approvalStatus as approvalStatus,e.withdrawalAmount as withdrawalAmount,"
					+ "e.exunitnum as exunitnum,e.exunitname as exunitname,e.exdoctype as exdoctype,"
					+ "e.exidnum as exidnum,e.indaccstatus as indaccstatus,e.exsex as exsex,"
					+ "e.exage as exage,e.exmodel as exmodel,e.exphone as exphone) from Extractionandapproval e where e.approvalNumberId='"+appid+"' ";
			List list=ht.find(sql);
			return list;
			
		}
	//查询合同信息
	public List sele_contract(int appid){
		
		System.out.println(111);
		try {
			//List list=ht.find("select e.extractDetailsId from Extractdetails e where e.extractionandapproval.approvalNumberId="+appid+"");
		  
			List list=ht.find("select m.materialtype.materialTypeId from Materialproof m  where m.extractdetails.extractionandapproval.approvalNumberId="+appid+"");
			int a=(Integer) list.get(0);
			System.out.println("a:"+a);
			List<Map> list2=ht.find("select new map(m.retireti.retireId as retireId,m.purinfo.piId as piId,m.proofofdeath.deathCertificateId as deathCertificateId) from Materialtype m where m.materialTypeId="+a+"");
		   
		   /*  for (Map o : list2) {
				Iterator<Map.Entry<Object,Object>> sp=o.entrySet().iterator();
				while(sp.hasNext()){
					Map.Entry<Object, Object> entry =sp.next();
					System.out.println(entry.getKey() + " " + entry.getValue()); 
				}
			}*/
		 
			System.out.println(222);
		    Map<String,Object> map=list2.get(0);
		    Integer piId=(Integer) map.get("piId");//购房信息
		    Integer deid=(Integer) map.get("deathCertificateId");//死亡证明
		    Integer retireId=(Integer) map.get("retireId");//离职退休
		   /* System.out.println(piId);
		    System.out.println(deid);
		    System.out.println(retireId);*/
		 if(piId!=null){
			List plist= ht.find("select new map(piId as piId,p.puType as puType," +
					"p.puAddress as puAddress,p.pumoney as pumoney,p.puText as puText," +
					"p.shphone as shphone,p.shaddress as shaddress,p.shutin as shutin," +
					"p.shidnum as shidnum,p.hbname as hbname,p.houcs as houcs,p.recnum as recnum) from Purinfo p where p.piId="+piId+"");
               return plist;
               
		 }else if(deid!=null){
			 
			 List plist= ht.find("select new map(deathCertificateId as deathCertificateId,p.myName as myName,p.idno as idno,p.placeOfDomicile as placeOfDomicile,p.causeOfDeath as causeOfDeath) from Proofofdeath p where p.deathCertificateId="+deid+"");
             return plist; 
			 
		 }else if(retireId!=null){
			 
			 List plist= ht.find("select new map(retireId as retireId,myName as myName,utinName as utinName,reasForRe as reasForRe) from Retireti where retireId="+retireId+"");
             return plist;  
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int not_con(int id){
		
		/*Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time=s.format(d);*/
		Date d=new Date(new java.util.Date().getTime());
		Extractionandapproval e=ht.get(Extractionandapproval.class,id);
		
		e.setApprovalStatus("审核失败");
		e.setApprovalTime(d);
		ht.update(e);
		return 0;
	}
	
	public int yes_con(int appid,int indid,double money,String apptime){
		System.out.println(appid);
		/*Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String time=s.format(d);*/
		System.out.println(333);
		Date d=new Date(new java.util.Date().getTime());
		Extractionandapproval e=ht.get(Extractionandapproval.class,appid);
		
		
		e.setApprovalStatus("审核成功");
		e.setApprovalTime(d);
		
	    ht.update(e);
		
		
		ht.clear();
		
		
		Indaccountinfo ind=ht.get(Indaccountinfo.class,indid);
		ind.setPresentSumRem(ind.getPresentSumRem()-(float)money);//此处被强转
		ind.setUsableRem(ind.getUsableRem()-(float)money);//此处被强转
		
		ht.update(ind);
		ht.clear();
		
		Extractionrecord ex=new Extractionrecord();
		ex.setExtractionAccount(String.valueOf(indid));
		ex.setWithdrawalAmount((float)money);
		//ex.setExtractionDate(apptime);//此处修改过
		//ex.setLoanDate(time);
		ex.setLoanDate(new Date());
		ex.setReceptionist("管理员");
		ht.save(ex);
		ht.clear();
		
		//添加到积金中心统计
		Mpfacentrestat m=new Mpfacentrestat();
		
		//new java.sql.Date(new java.util.Date().getTime());
		
	    m.setWithdrawalSumStat((float)money);
	    m.setStatisticalTime(new java.sql.Date(new java.util.Date().getTime()));
		ht.save(m);
		ht.clear();
		return 0;
	}
	
	
}
