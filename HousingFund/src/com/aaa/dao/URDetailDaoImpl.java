package com.aaa.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.TeachaerPageEntity;
import com.aaa.util.TeacherPageUtil;

@Repository
public class URDetailDaoImpl implements URDetailDao {

	@Resource
	private HibernateTemplate ht;
	
	@Resource
	private TeacherPageUtil util;
	
	public TeachaerPageEntity sele_Detail(int id,TeachaerPageEntity page){
	
		String sql="select new map(u.utinaccountinfo.utinAccountId as utinAccountId,utinName as utinName,payinSumMoney as payinSumMoney," +
				"depositPeople as depositPeople,depositDate as depositDate," +
				"adminname as adminname,remonth as remonth,finaldate as finaldate,oridate as oridate" +
				")  from  Utinremittancedetail u where u.utinaccountinfo.utinAccountId="+id+" ORDER BY STR_TO_DATE(DepositDate,'%Y-%m-%d') desc";
		
		try {
			util.getPage(sql, page);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		TeachaerPageEntity list=util.getPage(sql, page);
		return list;
	}
	public List sele_rd(int id){
		
		List list=ht.find("select new map(payinSumMoney as payinSumMoney,payinDate as payinDate) from Remittancedetail r where r.indAccountId="+id+"");
		return list;
	}
	
	public List se_exre(int id){
		
		List list=ht.find("select new map(withdrawalAmount as withdrawalAmount,extractionDate as extractionDate,loanDate as loanDate) from Extractionrecord e where e.extractionAccount="+id+"");
		return list;
	}
	public TeachaerPageEntity sele_allex(TeachaerPageEntity page){
		String sql="select new map(e.indaccountinfo.indAccountId as indAccountId,DATE_FORMAT(e.applicationtime,'%Y-%m-%d') as applicationtime,"
				+ "e.workersName as workersName,e.approvalStatus as approvalStatus,"
				+ "e.withdrawalAmount as withdrawalAmount,e.indaccstatus as indaccstatus,"
				+ "e.exsex as exsex,e.exphone as exphone,e.exunitname as exunitname,e.exidnum as exidnum) from Extractionandapproval e ORDER BY e.applicationtime DESC";
		
		TeachaerPageEntity t=util.getPage(sql, page);
		return t;
	}
	
	//查询idnum全部提取
			public List sele_idnum(String idnum){
				String sql="select new map(e.indaccountinfo.indAccountId as indAccountId,DATE_FORMAT(e.applicationtime,'%Y-%m-%d') as applicationtime,"
						+ "e.workersName as workersName,e.approvalStatus as approvalStatus,"
						+ "e.withdrawalAmount as withdrawalAmount,e.indaccstatus as indaccstatus,"
						+ "e.exsex as exsex,e.exphone as exphone,e.exunitname as exunitname,e.exidnum as exidnum) from Extractionandapproval e where e.exidnum like '%"+idnum+"%' ORDER BY e.applicationtime DESC ";
				
				try {
					ht.find(sql);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				List list=ht.find(sql);
				return list;
			}
	
}
