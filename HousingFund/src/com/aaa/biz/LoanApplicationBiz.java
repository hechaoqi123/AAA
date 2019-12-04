package com.aaa.biz;

import java.util.List;

import com.aaa.actions.LoanApplicationAction;
import com.aaa.entity.Coborrower;
import com.aaa.entity.Collateralinfo;
import com.aaa.entity.Guaranteemode;
import com.aaa.entity.Guarantorinfo;
import com.aaa.entity.Loanaccountinfo;
import com.aaa.entity.Loanapplication;
import com.aaa.entity.Proof;
import com.aaa.entity.Purchasecontract;
import com.aaa.entity.Purchasedhinfo;
import com.aaa.entity.Useoffunds;


public interface LoanApplicationBiz{
	//�����������
	public void save(Loanapplication loanEntity,Loanaccountinfo loanaccountinfoEntity);
	//���������
	public List<Loanapplication> criteriaAssess(String state);
	//�������ѯ
	public Loanapplication getOne(int id);
	public Loanapplication getOne(Loanapplication model);
	//��ǰ���������ɴ����
	public Integer getLimit(Integer LoanapplicationId);
	//����������״̬
	public void successORreject(Loanapplication loanEntity,String cause);
	//δǩ�������ͬ�������ѯ
	public Object[] find(Loanapplication loan);
	//��ͬǩ��
	public void update(int i);
	//�����鼰���˻���ƻ�
	public Object[]  refund(Loanapplication loan);
}
