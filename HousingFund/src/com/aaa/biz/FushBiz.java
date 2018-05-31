package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Fush;

//公积金冲还贷款
public interface FushBiz {
  //办理冲贷业务
	public void work(Fush entity);
  //查询所有办理冲贷的用户
	public List getAll();
  //冲还贷
	public void work2();
}
