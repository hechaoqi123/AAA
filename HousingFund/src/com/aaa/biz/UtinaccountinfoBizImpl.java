package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.UtinaccountinfoDao;
import com.aaa.entity.Unitinfo;
import com.aaa.entity.Utinaccountinfo;
@Service
@Transactional
public class UtinaccountinfoBizImpl implements UtinaccountinfoBiz{
	@Autowired
	private UtinaccountinfoDao utinaccountinfoDao;
	public List getUtinaccountinfo(){
		return utinaccountinfoDao.getUtinaccountinfo();
		}
	@Override
	public int saveUtinaccountinfo(Utinaccountinfo utinaccountinfo,int UnitinfoID) {
		utinaccountinfoDao.saveUtinaccountinfo(utinaccountinfo, UnitinfoID);
		return 0;
	}
	@Override
	public List get_one_Utinaccountinfo(Integer accountId) {
		return utinaccountinfoDao.get_one_Utinaccountinfo(accountId);
	}
	@Override
	public int update_utinAccount(Integer utinAccountId, String accountStatus) {
		utinaccountinfoDao.update_utinAccount(utinAccountId, accountStatus);
		return 0;
	}
	@Override
	public List getFuzzy(Utinaccountinfo utinaccountinfo) {
		return utinaccountinfoDao.getFuzzy(utinaccountinfo);
	}
	@Override
	public Utinaccountinfo getOneUtin(Utinaccountinfo utinaccountinfo) {
		Utinaccountinfo one = utinaccountinfoDao.getOne(utinaccountinfo.getUtinAccountId());
		return one;
	};
	@Override
	public void updateUtin(Utinaccountinfo utinaccountinfo) {
		Utinaccountinfo one = utinaccountinfoDao.getOne(utinaccountinfo.getUtinAccountId());
		Unitinfo u = one.getUnitinfo();
		u.setUtinName(utinaccountinfo.getUnitinfo().getUtinName());
		u.setCorpRepr(utinaccountinfo.getUnitinfo().getCorpRepr());
		u.setOperatorName(utinaccountinfo.getUnitinfo().getOperatorName());
		u.setOperatorIdnumber(utinaccountinfo.getUnitinfo().getOperatorIdnumber());
		u.setOperatorPhone(utinaccountinfo.getUnitinfo().getOperatorPhone());
		u.setUtinAddress(utinaccountinfo.getUnitinfo().getUtinAddress());
		one.setUtinDepositRatio(utinaccountinfo.getUtinDepositRatio()/100);
	};
	
}
