package com.aaa.biz;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.aaa.dao.LoanDao;

import com.aaa.entity.Loanapplication;






@Repository
public class LoanBizImpl implements LoanBiz {
	/**
	 *   关联查询   set属性
	 *   假如我现在有一个学生，现在要修改学生的同时修改班级名称
	 *      现在通过查询这个学生的同时查询出班级（在学生的映射文件中修改班级的加载策略为fetch=join）
	 *      然后  stu.setName("张三")  stu.getCla.setClaName("二班")
	 * **/
	@Autowired
	private LoanDao loanDao;
	/* (non-Javadoc)
	 * @see com.aaa.dao.UserDao#getOne(java.lang.String)
	 */
	@Override
	public Loanapplication getFive(String BorrowerIdnumber) {
		return loanDao.getFive(BorrowerIdnumber);
	}
	
	public Loanapplication getSix(String BorrowerIdnumber) {
		return loanDao.getSix(BorrowerIdnumber);
}
}