package com.aaa.dao;

import com.aaa.entity.Unitinfo;

public interface UnitinfoDao extends BaseDao<Unitinfo> {
	public int saveUnitinfo(Unitinfo utitinfo);
	//�鿴��˾�Ƿ����
	public boolean selutinName(Unitinfo utitinfo);
}
