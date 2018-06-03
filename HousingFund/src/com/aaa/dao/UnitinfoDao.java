package com.aaa.dao;

import com.aaa.entity.Unitinfo;

public interface UnitinfoDao extends BaseDao<Unitinfo> {
	public int saveUnitinfo(Unitinfo utitinfo);
	//查看公司是否存在
	public boolean selutinName(Unitinfo utitinfo);
}
