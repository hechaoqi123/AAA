package com.aaa.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Supdetailed;
import com.aaa.entity.UtilSup;
import com.aaa.entity.Utinaccountinfo;
import com.aaa.entity.Utinsupapply;

import jxl.Sheet;
import jxl.Workbook;

@Repository
public class SupDaoImpl implements SupDao {

	@Resource
	private HibernateTemplate ht;
	
	/* (non-Javadoc)
	 * @see com.aaa.dao.SupDao#inse_usa(com.aaa.entity.Utinsupapply, int)
	 */
	
	public Utinaccountinfo sele_u(int id){
		
		Utinaccountinfo u=ht.get(Utinaccountinfo.class, id);
		return u;
	}
	public Indaccountinfo sele_i(int id){
		
		Indaccountinfo u=ht.get(Indaccountinfo.class, id);
		
		return u;
	}
	
	
	@Override
	public int inse_usa(Utinsupapply u,int a){
		
    SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String time=f.format(new Date());
		
		Utinaccountinfo uc=ht.get(Utinaccountinfo.class, a);
		
		
		u.setUtinaccountinfo(uc);
		u.setApplyDate(time);
	   /* u.setChequeId(u.getChequeId());
	    u.setUtinNmae(u.getUtinNmae());
	    u.setUtinsupmoney(u.getUtinsupmoney());
	    u.setSupSumple(u.getSupSumple());
	    u.setSupCause(u.getSupCause());*/
	    
		ht.save(u);
		
		int hi=u.getApplyId();
		
		return hi;
	}
	
	//add
	public int inser_sd(UtilSup u,int id){
     SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		
		String time=f.format(new Date());
		//添加
		
		Indaccountinfo ic=ht.get(Indaccountinfo.class,u.getIndAccountID());
		Utinsupapply us=ht.get(Utinsupapply.class, id);
		
		Supdetailed s=new Supdetailed();
		
		s.setIndaccountinfo(ic);
		s.setUtinsupapply(us);
		s.setEmployeeName(u.getEmployeeName());
		s.setSupRadices(u.getSupRadices());
		s.setIndDepositRatio(u.getIndDepositRatio());
		s.setSupMonth(u.getSupMonth());
		s.setSupMoney(u.getSupMoney());
		s.setSupDate(time);
		ht.save(s);
		//修改个人账户信息
		Indaccountinfo i=ht.get(Indaccountinfo.class,u.getIndAccountID());
		i.setPresentSumRem(i.getPresentSumRem()+u.getSupMoney());
		i.setUsableRem(i.getUsableRem()+u.getSupMoney());
		
		ht.update(i);
		return 0;
	}
	
	public List bjse(int a){
		
		List list=ht.find("select new map(supMoney as supMoney,supMonth as supMonth,supDate as supDate) from Supdetailed s where s.indaccountinfo.indAccountId="+a+"");
		return list;
	}
	
	//根据idnum查询此单位是否存在此idnum
		public List sele_supidnum(int a,String idnum){
			String sql="select new map(ind.indAccountId as indAccountId,ind.trueName as trueName) from Indaccountinfo ind where ind.utinaccountinfo.utinAccountId="+a+" and"
					+ " ind.idnumber='"+idnum+"'";
			List list=ht.find(sql);
			
			return list;
		}
		
		//读取excel表格
		public List<Supdetailed> add_suo(File file) throws Exception{
			List<Supdetailed> list=new ArrayList();
			
			FileInputStream fis = new FileInputStream(file);
		 	Workbook wk=Workbook.getWorkbook(fis);
		 	
			Sheet sheet = null;
		 	 
		 	 try {
		 		 
		 	
		 		 sheet=wk.getSheet(0);
			 	 int rowNum=sheet.getRows();
			
		 	for(int i=1;i<rowNum;i++){
		 	
		 		Supdetailed sup=new Supdetailed();
		 		
		 		sup.setIdnum(sheet.getCell(0,i).getContents());//身份证号
		 		sup.setEmployeeName(sheet.getCell(1,i).getContents());//名字
		 		sup.setSupRadices(Float.parseFloat(sheet.getCell(2,i).getContents()));//基数
		 		sup.setIndDepositRatio(Float.parseFloat(sheet.getCell(3,i).getContents()));//比例
		 		sup.setSupMonth(Integer.parseInt(sheet.getCell(4,i).getContents()));//月数
		 		
		 		//sup.setSupMoney(Float.parseFloat(sheet.getCell(5,i).getContents()));//总金额
		 		list.add(sup);
		 		
		 	}
		 	} catch (Exception e) {
				// TODO: handle exception
		 		e.printStackTrace();
			}
		 	fis.close();
			wk.close();
			return list;
		}
}
