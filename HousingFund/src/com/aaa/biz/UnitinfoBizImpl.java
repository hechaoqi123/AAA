package com.aaa.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.UnitinfoDao;
import com.aaa.entity.Unitinfo;
@Service
@Transactional
public class UnitinfoBizImpl implements UnitinfoBiz {
	@Autowired
	UnitinfoDao unitinfoDao;
	@Override
	public int saveUnitinfo(Unitinfo utitinfo) {
		return unitinfoDao.saveUnitinfo(utitinfo);
	}
	@Override
	public boolean selutinName(Unitinfo utitinfo) {
		return unitinfoDao.selutinName(utitinfo);
	}

}
