package com.aaa.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Unitinfo;
import com.aaa.entity.Utinaccountinfo;
import com.alibaba.fastjson.JSON;
@Repository
public class UtinaccountinfoDaoImpl extends BaseDaoImpl<Utinaccountinfo> implements UtinaccountinfoDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public List getUtinaccountinfo(){
		String hql = "select new Map(u.utinAccountId as utinAccountId, " +
						"u.unitinfo.utinName as utinName, " +
						"u.unitinfo.utinNumber as utinNumber, " +
						"u.unitinfo.utinAddress as utinAddress, " +
						"u.unitinfo.corpRepr as corpRepr, " +
						"u.unitinfo.operatorName as operatorName, " +
						"u.unitinfo.operatorPhone as operatorPhone, " +
						"u.unitinfo.operatorIdnumber as operatorIdnumber, " +
						"u.unitinfo.bankName as bankName, " +
						"u.unitinfo.utinFoundDate as utinFoundDate, " +
						"u.utinSumPeople as utinSumPeople, " +
						"u.utinDepositPeople as utinDepositPeople, " +
						"u.utinProvRema as utinProvRema, " +
						"u.utinSealPeople as utinSealPeople, " +
						"u.accountStatus as accountStatus) from Utinaccountinfo u";
		List list_Utinaccountinfo = hibernateTemplate.find(hql);
		return list_Utinaccountinfo;
		}
	//添加单位账户
	@Override
	public int saveUtinaccountinfo(Utinaccountinfo utinaccountinfo, Integer UnitinfoID) {
		Unitinfo unitinfo = hibernateTemplate.get(Unitinfo.class, UnitinfoID);
		utinaccountinfo.setUnitinfo(unitinfo);
		utinaccountinfo.setUtinSumPeople(0);
		utinaccountinfo.setUtinDepositRatio(utinaccountinfo.getUtinDepositRatio()/100);
		utinaccountinfo.setUtinDepositPeople(0);
		utinaccountinfo.setUtinSealPeople(0);
		utinaccountinfo.setUtinProvRema(0D);
		utinaccountinfo.setAccountStatus("审核中");
		utinaccountinfo.setUtinPayinWay("柜台缴纳");
		utinaccountinfo.setUtinAccountPass(String.valueOf(UnitinfoID));
		hibernateTemplate.save(utinaccountinfo);
		return 0;
	}
	@Override
	public List get_one_Utinaccountinfo(Integer accountId) {
		String hql = "select new Map(u.utinAccountId as utinAccountId, " +
				"u.unitinfo.utinName as utinName, " +
				"u.unitinfo.utinNumber as utinNumber, " +
				"u.unitinfo.utinAddress as utinAddress, " +
				"u.unitinfo.corpRepr as corpRepr, " +
				"u.unitinfo.operatorName as operatorName, " +
				"u.unitinfo.operatorPhone as operatorPhone, " +
				"u.unitinfo.operatorIdnumber as operatorIdnumber, " +
				"u.unitinfo.bankName as bankName, " +
				"u.unitinfo.utinFoundDate as utinFoundDate, " +
				"u.utinSumPeople as utinSumPeople, " +
				"u.utinDepositPeople as utinDepositPeople, " +
				"u.utinProvRema as utinProvRema, " +
				"u.utinDepositRatio as utinDepositRatio, " +
				"u.accountStatus as accountStatus) from Utinaccountinfo u where u.utinAccountId ="+accountId;
				List list_Utinaccountinfo = hibernateTemplate.find(hql);
				return list_Utinaccountinfo;
	}
	@Override
	public int update_utinAccount(Integer utinAccountId, String accountStatus) {
		Utinaccountinfo u = hibernateTemplate.get(Utinaccountinfo.class, utinAccountId);
		if(accountStatus.equals("驳回")){
			Unitinfo unitinfo = hibernateTemplate.get(Unitinfo.class,u.getUnitinfo().getUtinId());
			hibernateTemplate.delete(u);
			hibernateTemplate.delete(unitinfo);
		}else{
			u.setAccountStatus(accountStatus);
			hibernateTemplate.update(u);
		}
		return 0;
	};
	
	
	//模糊查询
	
	@Override
	public List getFuzzy(Utinaccountinfo utinaccountinfo) {
		try {
			String hql = "select new Map(u.utinAccountId as utinAccountId, " +
					"u.unitinfo.utinName as utinName, " +
					"u.unitinfo.utinNumber as utinNumber, " +
					"u.unitinfo.utinAddress as utinAddress, " +
					"u.unitinfo.corpRepr as corpRepr, " +
					"u.unitinfo.operatorName as operatorName, " +
					"u.unitinfo.operatorPhone as operatorPhone, " +
					"u.unitinfo.operatorIdnumber as operatorIdnumber, " +
					"u.unitinfo.bankName as bankName, " +
					"u.unitinfo.utinFoundDate as utinFoundDate, " +
					"u.utinSumPeople as utinSumPeople, " +
					"u.utinDepositPeople as utinDepositPeople, " +
					"u.utinProvRema as utinProvRema, " +
					"u.utinDepositRatio as utinDepositRatio, " +
					"u.accountStatus as accountStatus) from Utinaccountinfo u where u.unitinfo.utinName like '%"+utinaccountinfo.getUnitinfo().getUtinName()+"%'";
			List list_Utinaccountinfo = hibernateTemplate.find(hql);
			return list_Utinaccountinfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
