package com.aaa.biz;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.aaa.dao.LoanDao;

import com.aaa.entity.Loanapplication;






@Repository
public class LoanBizImpl implements LoanBiz {
	/**
	 *   ������ѯ   set����
	 *   ������������һ��ѧ��������Ҫ�޸�ѧ����ͬʱ�޸İ༶����
	 *      ����ͨ����ѯ���ѧ����ͬʱ��ѯ���༶����ѧ����ӳ���ļ����޸İ༶�ļ��ز���Ϊfetch=join��
	 *      Ȼ��  stu.setName("����")  stu.getCla.setClaName("����")
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