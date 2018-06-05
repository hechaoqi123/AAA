package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.UtinaccountinfoDao;
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
	};
}
