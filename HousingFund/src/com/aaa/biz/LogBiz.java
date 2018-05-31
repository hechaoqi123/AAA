package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Log;
 //冲贷日志记录
public interface LogBiz {
  //添加记录
   public void add(Log log); 
  //查询所有记录
   public List getAll();
}
