package com.aaa.biz;

import com.aaa.entity.Unitinfo;

public interface UnitinfoBiz {
	public int saveUnitinfo(Unitinfo utitinfo);
	//查看公司是否存在
	public boolean selutinName(Unitinfo utitinfo);
}
