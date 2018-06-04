package com.aaa.biz;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.aaa.entity.Fush;
import com.aaa.entity.PageEntity;

//公积金冲还贷款
public interface FushBiz {
  //办理冲贷业务
	public void work(Fush entity);
  //查询所有办理冲贷的用户
	public List getAll();
  //冲还贷
	public void work2();
  //分页查询办理冲还贷的用户	
	public PageEntity getPart(PageEntity entity, Criterion criterion);
  //个人冲贷日志	
	public Fush getOne(Integer id);
  //修改个人业务状态
	public void update(int id,String status);
  //删除
	public void remove(int id);
}
