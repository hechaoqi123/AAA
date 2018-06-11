package com.aaa.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.BeforereturnDao;
import com.aaa.dao.BorrDao;
import com.aaa.dao.RepaymentPlanDetailsDao;
import com.aaa.entity.Beforereturn;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Repaymentplandetails;
//��ǰ����
@Service
@Transactional
public class BeforereturnBizImpl implements BeforereturnBiz {
	@Autowired
	private BeforereturnDao dao;
	@Autowired
	BorrDao borrDao;
	@Autowired
	RepaymentPlanDetailsDao repayDao;
   //�ύ��ǰ��������
	@Override
	public void save(Beforereturn entity) {
		Integer id=entity.getBorrowmoneyagreement().getBorrowMoneyAgreementId();
		entity.setStatus("����");
		entity.setBorrowmoneyagreement(borrDao.getOne(id));
		 dao.save(entity);
	}
	//��ѯδ��˵���ǰ��������
	public List find() {
		return dao.findByCriteria(new Criterion[]{Restrictions.eq("status", "����")}, Order.asc("id"));
	}
	//��ȡ��ǰ����������Ϣ
	@Override
	public Beforereturn getBefore(Integer id) {
		Beforereturn before=dao.getOne(id);
		before.setBorrowmoneyagreement(borrDao.getOne(before.getBorrowmoneyagreement().getBorrowMoneyAgreementId()));
		return before;
	}
	//ͨ������
	@Override
	public void success(Beforereturn entity) {
		//�ı�����״̬��
		  Beforereturn before=dao.getOne(entity.getId());
		   before.setStatus("��ͨ��");
		   if(before.getReturnType().equals("ȫ������")){
			    //ȫ������:�������л���ƻ�(ɾ��δ�����¼,�����ǰ�����¼)
			   Borrowmoneyagreement borr = before.getBorrowmoneyagreement();
			   Set<Repaymentplandetails> set = borr.getRepaymentplandetailses();
			   List list=new ArrayList();
			   for (Repaymentplandetails repay : set) {
					if(repay.getRepaymentStatus().equals("δ��")||repay.getRepaymentStatus().equals("����δ��")){
						list.add(repay);
					}
				}
			   Repaymentplandetails re=(Repaymentplandetails) list.get(list.size()-1);
			   for (Object object : list) {
				  set.remove(object);
			  }
			   re.setCurrentReturnedInterest(Float.valueOf(before.getAfterlixi()));//��Ϣ
			   re.setCurrentReturnedCorpus(Float.valueOf(before.getAfterMoney()));//����
			   re.setRepaymentsReceived(re.getCurrentReturnedCorpus()+re.getCurrentReturnedInterest());//ʵ�ս��
			   re.setAmountOfRepayRecei(re.getRepaymentsReceived());//Ӧ�����
			   re.setRepaymentDate(new Date());//��������
			   re.setRepaymentStatus("��ǰ����");
			   set.add(re);
			   repayDao.del();
			   }else if(before.getReturnType().equals("���ֻ���")){
			   //���ֻ���������л���ƻ�,�޸ı�����Ϣ �����ǰ�����¼
			   System.out.println("----���ֻ���----");
			   Borrowmoneyagreement borr = before.getBorrowmoneyagreement();
			   Set<Repaymentplandetails> set = borr.getRepaymentplandetailses();
			   List list=new ArrayList();
			     for (Repaymentplandetails repay : set) {
					if(repay.getRepaymentStatus().equals("δ��")){
					    list.add(repay);
					}
				}
			     int count=list.size();//ʣ������
			        //ÿ��Ӧ������=(δ������-��ǰ�����)/ʣ������
			    double money=(Integer.valueOf(before.getAfterMoney())-before.getMoney()*10000)/count;//ÿ��Ӧ�����
			       //ÿ��Ӧ����Ϣ=(����Ϣ)/ʣ������
			    Double lixi=(double) ((Float.valueOf(before.getAfterMoney())-before.getMoney()*10000)*((borr.getBorrowerAnnualRate()/100)*count/12)/count);//ÿ��Ӧ����Ϣ
			    for (Repaymentplandetails repay : set) {
					if(list.contains(repay)){
			   repay.setCurrentReturnedInterest(Float.valueOf(lixi.toString()));//��Ϣ
			   repay.setCurrentReturnedCorpus((float)money);//����
			     //Ӧ�����
			   repay.setAmountOfRepayRecei((float) (money+lixi));
					}
				}
			    //������ǰ�����¼
			    Repaymentplandetails instance=new Repaymentplandetails(); 
			    instance.setCurrentPeriod(0);
			    instance.setCurrentReturnedCorpus(Float.valueOf(before.getMoney()*10000));
			    //������ǰ���������Ϣ
			    //instance.setCurrentReturnedInterest(before.getMoney()*10000*(borr.getBorrowerFixedYear()-count)/12*borr.getBorrowerAnnualRate()/100);
			    instance.setRepaymentsReceived(instance.getCurrentReturnedCorpus());//ʵ�ս��
			    instance.setAmountOfRepayRecei(instance.getRepaymentsReceived());//Ӧ�����
			    instance.setRepaymentStatus("��ǰ����");
			    instance.setRepaymentDate(new Date());//��������
				set.add(instance);
		   }else{
			   System.out.println("�쳣����ǰ�������룡");
		   }
	}
	//���벵��
	@Override
	public void error(Beforereturn entity) {
		String remark=entity.getRemark();//������Ϣ
		Beforereturn before=dao.getOne(entity.getId());
		before.setStatus("�Ѳ���");
		before.setRemark(remark);
	}
	
}
