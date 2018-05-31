package com.aaa.biz;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.LogDao;
import com.aaa.entity.Log;
@Service
@Transactional
//冲还贷日志
public class LogBizImpl implements LogBiz {
	 @Autowired
	 private LogDao dao;
   //记录日志
	@Override
	public void add(Log log) {
		dao.save(log);
	}
   //查询日志
	@Override
	public List getAll() {
		return dao.findByCriteria(null, Order.desc("id"));
	}

}
