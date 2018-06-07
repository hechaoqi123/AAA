package com.aaa.dao;

import java.text.SimpleDateFormat;
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
		System.out.println(time);
		Utinaccountinfo uc=ht.get(Utinaccountinfo.class, a);
		u.setUtinaccountinfo(uc);
		u.setApplyDate(time);
		try {
			ht.save(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		ht.save(u);
		
		int hi=u.getApplyId();
		System.out.println(hi);
		return hi;
	}
	
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
			String sql="select new map(ind.indAccountId as indAccountId) from Indaccountinfo ind where ind.utinaccountinfo.utinAccountId="+a+" and"
					+ " ind.idnumber="+idnum+"";
			List list=ht.find(sql);
			return list;
		}
}
