package com.aaa.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.*;

@Repository
public class IndAccountinfoDaoImpl extends BaseDaoImpl<Indaccountinfo> implements IndAccountinfoDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	
	// ���֮��  ����> �޸ĸ����˻������
	/* (non-Javadoc)
	 * @see com.aaa.dao.IndaccountinfoDao#update_Indaccount(com.aaa.entity.Indaccountinfo)
	 */
	@Override
	public int update_Indaccount(Indaccountinfo ind,RDUtil rd){
		
		Indaccountinfo inds=hibernateTemplate.get(Indaccountinfo.class,rd.getIndAccountId());
		
		System.out.println(inds.getIndDepositRadices());
		
		//inds.setPeMonthDep(rd.getPeMonthDep());//�˴�double���ͱ�תΪfloat
		inds.setUsableRem(rd.getUsableRem()+rd.getPayinSumMoney());//ͬ��
		inds.setPresentSumRem( rd.getPresentSumRem()+rd.getPayinSumMoney());//ͬ��

		try {
			hibernateTemplate.saveOrUpdate(inds);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		hibernateTemplate.clear();
		
		return 0;
	}
	public List ind_MyMoney(String idnum){
	   String sql="select new map(ic.presentSumRem as presentSumRem,ic.indAccountId as indAccountId," +
	   		"ic.trueName as trueName,ic.utinaccountinfo.utinName as utinname," +
	   		"ic.utinaccountinfo.utinAccountId as utinaccountId) from Indaccountinfo ic where ic.idnumber="+idnum+"";
		List list=hibernateTemplate.find(sql);

		return list;
		
	}
	//�޸ĵ�λ�˻����
	public int update_utinmoney(RDUtil rd){
		
		Utinaccountinfo u=hibernateTemplate.get(Utinaccountinfo.class,rd.getUtinAccountId());
		u.setUtinProvRema(rd.getUtinprovrema());
		hibernateTemplate.update(u);
		
		return 0;
	}
	//���Ա����Ϣ
	@Override
	public int saveIndaccountinfo(Indinfo indinfo, Indaccountinfo indaccountinfo, Integer utinaccountinfoID) {
		String idnumber = indinfo.getIdnumber();
		indaccountinfo.setIdnumber(idnumber);
		indaccountinfo.setTrueName(indinfo.getTrueName());
		String sGender="";
		if(idnumber.length()<18){idnumber="410225199711014918";}
		String sCardNum = idnumber.substring(16, 17);  
	       if (Integer.parseInt(sCardNum) % 2 != 0) {  
	            sGender = "��";  
	       } else {  
	           sGender = "Ů";  
	      } 
		indinfo.setSex(sGender);
		indaccountinfo.setLoginAccount(idnumber);
		indaccountinfo.setIndStatus("����");
		indaccountinfo.setLoginPass(idnumber.substring(12,18));
		indaccountinfo.setThisPayRem((float) 0);
		indaccountinfo.setLastChangeRem((float) 0);
		indaccountinfo.setPresentSumRem((float) 0);
		indaccountinfo.setUsableRem((float) 0);

		Serializable save = hibernateTemplate.save(indinfo);
		Indinfo indinfoEntity = hibernateTemplate.get(Indinfo.class, save.hashCode());
		Utinaccountinfo utinaccountinfoEntity = hibernateTemplate.get(Utinaccountinfo.class, utinaccountinfoID);
		if(utinaccountinfoEntity.getUtinSumPeople() != null){
			utinaccountinfoEntity.setUtinSumPeople((utinaccountinfoEntity.getUtinSumPeople()+1));
			System.out.println("�ɴ���������=="+(utinaccountinfoEntity.getUtinDepositPeople()+1));
			utinaccountinfoEntity.setUtinDepositPeople((utinaccountinfoEntity.getUtinDepositPeople()+1));
		}else{
			System.out.println("�ɴ���������=="+(utinaccountinfoEntity.getUtinDepositPeople()+1));
			utinaccountinfoEntity.setUtinSumPeople(1);
			utinaccountinfoEntity.setUtinDepositPeople((utinaccountinfoEntity.getUtinDepositPeople()+1));
		}
		indaccountinfo.setIndDepositRatio(Float.valueOf(utinaccountinfoEntity.getUtinDepositRatio().toString()));
		hibernateTemplate.update(utinaccountinfoEntity);
		indaccountinfo.setIndinfo(indinfoEntity);
		indaccountinfo.setUtinaccountinfo(utinaccountinfoEntity);
		hibernateTemplate.save(indaccountinfo);
		return 0;
	};
	//��ȡָ����˾��Ա����Ϣ
	@Override
	public List<Indaccountinfo> getEmp(Integer utinaccountinfoID){
			DetachedCriteria criteria=DetachedCriteria.forClass(Indaccountinfo.class);
			criteria.add(Restrictions.eq("utinaccountinfo.utinAccountId", utinaccountinfoID));
			List<Indaccountinfo> list_Indaccountinfo = hibernateTemplate.findByCriteria(criteria);
			return list_Indaccountinfo;
		}
	//ģ��
	@Override
	public List getFuzzy(Integer utinaccountinfoID, Indaccountinfo indaccountinfo){
		String hql = "select new map(a.indAccountId as indAccountId, " +
									"a.indinfo.trueName as trueName, " +
									"a.indinfo.duties as duties, " +
									"a.indDepositRadices as indDepositRadices, " +
									"a.usableRem as usableRem, " +
									"a.indStatus as indStatus, " +
									"a.presentSumRem as presentSumRem" +
									") from Indaccountinfo a where a.indinfo.trueName like '%"+indaccountinfo.getIndinfo().getTrueName()+"%' and  a.utinaccountinfo.utinAccountId = "+utinaccountinfoID;
		if(utinaccountinfoID==-1){
			hql = "select new map(a.indAccountId as indAccountId, " +
					"a.indinfo.trueName as trueName, " +
					"a.indinfo.duties as duties, " +
					"a.indDepositRadices as indDepositRadices, " +
					"a.usableRem as usableRem, " +
					"a.indStatus as indStatus, " +
					"a.presentSumRem as presentSumRem) from Indaccountinfo a where a.indinfo.trueName like '%"+indaccountinfo.getIndinfo().getTrueName()+"%'";
		}
		if(utinaccountinfoID==0){
			hql = "select new map(a.indAccountId as indAccountId, " +
					"a.indinfo.trueName as trueName, " +
					"a.indinfo.duties as duties, " +
					"a.indDepositRadices as indDepositRadices, " +
					"a.usableRem as usableRem, " +
					"a.indStatus as indStatus, " +
					"a.presentSumRem as presentSumRem) from Indaccountinfo a ";
		}
		List list_Indaccountinfo = hibernateTemplate.find(hql);
		return list_Indaccountinfo;
		}
	//�޸�
	@Override
	public int updateRadices(Indaccountinfo indaccountinfo) {
		Indaccountinfo indaccountinfoEntity = hibernateTemplate.get(Indaccountinfo.class, indaccountinfo.getIndAccountId());
		if(indaccountinfo.getIndDepositRadices() != null){
			//��������
			indaccountinfoEntity.setIndDepositRadices(indaccountinfo.getIndDepositRadices());
			}
		if(indaccountinfo.getIndStatus() != null){
			//״̬
			indaccountinfoEntity.setIndStatus(indaccountinfo.getIndStatus());
			//������˾�����������������
			Utinaccountinfo utinaccountinfoEntity = hibernateTemplate.get(Utinaccountinfo.class, indaccountinfoEntity.getUtinaccountinfo().getUtinAccountId());
			if(indaccountinfo.getIndStatus().equals("���")){
				utinaccountinfoEntity.setUtinSealPeople(utinaccountinfoEntity.getUtinSealPeople()+1);
				utinaccountinfoEntity.setUtinDepositPeople((utinaccountinfoEntity.getUtinDepositPeople()-1));
			}
			if(indaccountinfo.getIndStatus().equals("����")){
				utinaccountinfoEntity.setUtinSealPeople(utinaccountinfoEntity.getUtinSealPeople()-1);
				utinaccountinfoEntity.setUtinDepositPeople((utinaccountinfoEntity.getUtinDepositPeople()+1));
			}
			hibernateTemplate.update(utinaccountinfoEntity);
			}
		    hibernateTemplate.update(indaccountinfoEntity);
		return 0;
	}
	//�޸���Ϣ
	public int updateEmpInfo(Indaccountinfo indaccountinfo, Indinfo indinfo, Integer utinaccountinfoID) {
		Utinaccountinfo utinaccountinfoEntity = hibernateTemplate.get(Utinaccountinfo.class, utinaccountinfoID);
		Indinfo indinfoEntity = hibernateTemplate.get(Indinfo.class, indinfo.getIndInfoId());
		Indaccountinfo indaccountinfoEntity = hibernateTemplate.get(Indaccountinfo.class, indaccountinfo.getIndAccountId());
		System.out.println(1112);
		indinfoEntity.setTrueName(indinfo.getTrueName());
		indinfoEntity.setIdnumber(indinfo.getIdnumber());
		indinfoEntity.setFixedPhone(indinfo.getFixedPhone());
		indinfoEntity.setPhoneNumber(indinfo.getPhoneNumber());
		indinfoEntity.setWedlockStatus(indinfo.getWedlockStatus());
		indinfoEntity.setFamilyAddress(indinfo.getFamilyAddress());
		indinfoEntity.setFamilyMonthIncome(indinfo.getFamilyMonthIncome());
		indinfoEntity.setDuties(indinfo.getDuties());
		indaccountinfoEntity.setTrueName(indinfo.getTrueName());
		indaccountinfoEntity.setIdnumber(indinfo.getIdnumber());
		indaccountinfoEntity.setBankSaAccount(indaccountinfo.getBankSaAccount());
		indaccountinfoEntity.setBankOpenAccount(indaccountinfo.getBankOpenAccount());
		try {
			hibernateTemplate.update(indinfoEntity);
			hibernateTemplate.update(indaccountinfoEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		hibernateTemplate.update(indinfoEntity);
		hibernateTemplate.update(indaccountinfoEntity);
		return 0;
	}
	//ɾ��
	@Override
	public int delEmp(Indaccountinfo indaccountinfo) {
		Indaccountinfo indaccountinfo2 = hibernateTemplate.get(Indaccountinfo.class, indaccountinfo.getIndAccountId());
		Indinfo indinfo = hibernateTemplate.get(Indinfo.class, indaccountinfo2.getIndinfo().getIndInfoId());
		if(indaccountinfo2.getIndStatus().equals("����")){
			return 0;
		}else{
			//������˾�����������������
			Utinaccountinfo utinaccountinfoEntity = hibernateTemplate.get(Utinaccountinfo.class, indaccountinfo2.getUtinaccountinfo().getUtinAccountId());
			utinaccountinfoEntity.setUtinSumPeople((utinaccountinfoEntity.getUtinSumPeople()-1));
			utinaccountinfoEntity.setUtinSealPeople(utinaccountinfoEntity.getUtinSealPeople()-1);
			hibernateTemplate.delete(indaccountinfo2);
			hibernateTemplate.delete(indinfo);
			return 1;
		}
	}
}
