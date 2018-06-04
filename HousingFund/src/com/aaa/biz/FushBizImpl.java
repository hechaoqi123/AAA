package com.aaa.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.BorrDao;
import com.aaa.dao.FushDao;
import com.aaa.dao.IndAccountinfoDao;
import com.aaa.entity.Borrowmoneyagreement;
import com.aaa.entity.Fush;
import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Log;
import com.aaa.entity.PageEntity;
import com.aaa.entity.Repaymentplandetails;
@Service
@Transactional
//�廹��ҵ�����
public class FushBizImpl implements FushBiz {
	@Autowired
	private FushDao dao;
	@Autowired
	private BorrDao borrDao;
	@Autowired
	private  RepaymentPlanDetailsBiz repayBiz;
	@Autowired
	private  BorrBiz borrBiz;
	@Autowired
	private  LogBiz logBiz;
	@Autowired
	private  IndaccountinfoBiz indBiz;
 //ҵ�����
	@Override
	public void work(Fush entity) {
		Borrowmoneyagreement borr = borrDao.getOne(entity.getBorrowmoneyagreement().getBorrowMoneyAgreementId());
		entity.setBorrowmoneyagreement(borr);
		dao.save(entity);
	}
  //��ѯ����
	@Override
	public List getAll() {
		return dao.getAll();
	}
	
  //�廹��	
	@Override
	public void work2() {
		 SimpleDateFormat fmt=new SimpleDateFormat("yyyy/MM/dd");
		try {
		    List<Fush> list=getAll();
		     System.out.println("�������:"+list.size());
		     for (Fush fush : list) {
		    	 
		    	 if(fush.getStatus().equals("����")){
		    //ȡ�������¼
		    	  Repaymentplandetails repay = borrBiz.getRepay(fush.getBorrowmoneyagreement());
		        if(repay==null){//δ��ѯ��δ�����¼
		        	  System.out.println("�쳣����");
		        	  Log log=new Log();
		        	  log.setFush(fush);
		        	  log.setRiqi(fmt.format(new Date()));
		        	  log.setStatus("ʧ��");
		        	  log.setRepaymentplandetails(repay);
		        	  log.setRemark("��δ�����");
		        	  fush.setStatus("����");
		        	    //��¼��־
		        	  logBiz.add(log);
		        	  continue;
		        }
		            	  
		    	  
		    //���л���
		         //�˻����
		             Indaccountinfo ind=new Indaccountinfo();
		             ind.setIdnumber(repay.getBorrowmoneyagreement().getBorrowerIdno());
		             int money=indBiz.getMoney(ind);
	             //Ӧ�����
	 	        float money2 = repay.getAmountOfRepayRecei()+repay.getOverduePrincipalAndInte();
		          if(money>=money2){//��������
		        	  System.out.println("��������");
		        	     //�����˻�������  ����״̬�ı�   ��¼��־
		        	  indBiz.return_loan(ind,money2);
		        	  borrBiz.return_loan(repay.getRepaymentPlanDetailsiId());
		        	   Log log=new Log();
		        	      log.setFush(fush);
		        		  log.setMoney(String.valueOf(money2));
		        		  System.out.println("repay"+repay);
			        	  log.setRepaymentplandetails(repay);
			        	  log.setRiqi(fmt.format(new Date()));
			        	  log.setStatus("�ɹ�");
			        	  log.setRemark("����ɹ���");
		        	  logBiz.add(log);
		          }else{//�쳣�������ʧ�ܣ����㣩
		        	  System.out.println("�쳣����");
		        	  Log log=new Log();
		        	  log.setFush(fush);
		        	  log.setRepaymentplandetails(repay);
		        	  log.setMoney(String.valueOf(money2));
		        	  log.setRiqi(fmt.format(new Date()));
		        	  log.setStatus("ʧ��");
		        	  log.setRemark("���㡣");
		        	    //��¼��־
		        	  logBiz.add(log);
		          }
		    	 
			}
		     }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//��ҳ��ѯ
	@Override
	public PageEntity getPart(PageEntity entity, Criterion criterion) {
		return dao.findByPage(entity, Order.asc("id"), criterion);
	}
	//��ȡ���˳����Ϣ
	@Override
	public Fush getOne(Integer id) {
		return dao.getOne(id);
	}
	//�޸�״̬
	@Override
	public void update(int id, String status) {
		dao.getOne(id).setStatus(status);
	}
	//ɾ����¼
	@Override
	public void remove(int id) {
		dao.delect(dao.getOne(id));
	}
	

}
