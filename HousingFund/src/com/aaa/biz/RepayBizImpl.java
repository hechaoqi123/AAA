package com.aaa.biz;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.aaa.dao.RepayDao;
import com.aaa.entity.Borrowmoneyagreement;

@Repository
public class RepayBizImpl implements RepayBiz{
	@Autowired
	private RepayDao repayDao;

	@Override
	public List getSevens(String BorrowerIdno) {
		// TODO Auto-generated method stub
		return repayDao.getSevens(BorrowerIdno);
	}
}
