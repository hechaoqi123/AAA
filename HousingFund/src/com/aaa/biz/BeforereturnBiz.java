package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Beforereturn;
  //提前还款
public interface BeforereturnBiz {
   //提交提前还款申请
	public void save(Beforereturn entity);
   //查询未审核的提前还款申请
	public List find();
   //获取提前还款申请
	public Beforereturn getBefore(Integer id);
    //通过申请（即成功提前还款）
	public void success(Beforereturn entity);
	//申请驳回
	public void error(Beforereturn entity);
}
