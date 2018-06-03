package com.aaa.biz;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.IndAccountinfoDao;
import com.aaa.dao.IndAccountinfoDaoImpl;
import com.aaa.entity.*;

@Service

public class IndaccountinfoBizImpl implements IndaccountinfoBiz {

	@Resource
	private IndAccountinfoDao dao;
	
	
	
	// ���֮��  ����> �޸ĸ����˻������
	/* (non-Javadoc)
	 * @see com.aaa.dao.IndaccountinfoDao#update_Indaccount(com.aaa.entity.Indaccountinfo)
	 */
	@Override
	public int update_Indaccount(Indaccountinfo ind,RDUtil rd){
		dao.update_Indaccount(ind, rd);
		return 0;
	}
	//�޸ĵ�λ�˻����
	public int update_utinmoney(RDUtil rd){
		return dao.update_utinmoney(rd);
	}
  //��ȡ�����˻���Ϣ	
	@Transactional(readOnly=true)
	public Indaccountinfo getOne(int id) {
		return dao.getOne(id);
	}
  //��ȡ�����˻���Ϣ
	@Transactional(readOnly=true)
	public List fingByExample(Indaccountinfo entity) {
		return dao.findByExample(entity);
	}

	@Override
	public List ind_MyMoney(String idnum) {
		return dao.ind_MyMoney(idnum);
	}
	
	
	
	//����
		@Override
		public int saveIndaccountinfo(Indinfo indinfo,Indaccountinfo indaccountinfo, Integer utinaccountinfoID) {
			dao.saveIndaccountinfo(indinfo, indaccountinfo, utinaccountinfoID);
			return 0;
		}
		@Override
		public List<Indaccountinfo> getEmp(Integer utinaccountinfoID) {
			return dao.getEmp(utinaccountinfoID);
		}
		@Override
		public int updateRadices(Indaccountinfo indaccountinfo) {
			dao.updateRadices(indaccountinfo);
			return 0;
		}
		@Override
		public List getFuzzy(Integer utinaccountinfoID,
				Indaccountinfo indaccountinfo) {
			return dao.getFuzzy(utinaccountinfoID, indaccountinfo);
		}
		//��ȡ�ܽ��
		@Override
		public int getMoney(Indaccountinfo entity) {
			   if(entity!=null){
				  Float money=dao.findByExample(entity).get(0).getPresentSumRem();
				   return money.intValue();
			   }
			   throw new RuntimeException("û��ѯ�������˻�");
		}
		//�廹����
		@Override
		public void return_loan(Indaccountinfo entity,Float money) {
			Indaccountinfo ind=dao.findByExample(entity).get(0);
			ind.setPresentSumRem(ind.getPresentSumRem()-money);
		}
		//ɾ��Ա��
		@Override
		public int frozenEmp(Indaccountinfo indaccountinfo) {
			return dao.frozenEmp(indaccountinfo);
		}
		@Override
		public int updateEmpInfo(Indaccountinfo indaccountinfo,
				Indinfo indinfo, Integer utinaccountinfoID) {
			dao.updateEmpInfo(indaccountinfo, indinfo, utinaccountinfoID);
			return 0;
		}
		@Override
		public List saveFileIndaccountinfo(File file) throws Exception {
			return dao.saveFileIndaccountinfo(file);
		}
		@Override
		public List getOneIndaf(Indinfo indinfo) {
			return dao.getOneIndaf(indinfo);
		}

}
