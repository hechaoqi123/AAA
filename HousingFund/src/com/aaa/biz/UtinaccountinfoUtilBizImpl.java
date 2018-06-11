package com.aaa.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.UtinaccountinfoUtilDao;
import com.aaa.entity.*;


@Service
@Transactional
public class UtinaccountinfoUtilBizImpl implements UtinaccountinfoUtilBiz {

	@Resource
	private UtinaccountinfoUtilDao dao;
	
	public int upinse(Flupay fu){
		
		return dao.upinse(fu);
	}
	public List<Flupay> selefu(){
		
		return dao.selefu();
	}
	@Override//�ܽ��ɽ��
	public Double UtinSumMoneySele(Integer UtinId) {
		Double m=dao.UtinSumMoneySele(UtinId);
		return m;
	}
	@Override
	public List UtinInfoSele(Integer UtinId) {
		return dao.UtinInfoSele(UtinId);
	}
	//��ѯ��λԱ����Ϣ
	@Override
	public List IndAccountInfoSele(Integer UtinId) {
		return dao.IndAccountInfoSele(UtinId);
	}
	//��ѯ�ϴλ��
			public List sele_date(Integer UtinId){
				
				return dao.sele_date(UtinId);
			}
			//��ѯ��λ
			public TeachaerPageEntity sele_utin(TeachaerPageEntity page){
	 			
	 			return dao.sele_utin(page);
	 		}
			//��λidģ����ѯ
			public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids){
				
				return dao.sele_mohuid(page, ids);
			}
			//��λ����ģ����ѯ
			public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname){
				
				return dao.sele_mohuname(page, utinname);
			}
			//��ѯ�˵�λ�Ƿ����
			public List sele_utinid(int id){
				
				return dao.sele_utinid(id);
			}
			//��ѯ�˵�λ�Ƿ���ҵ���˲� ��ѯ��λ���˴���
			public List sele_fy(int id){
				
				return dao.sele_fy(id);
			}
			//��ѯ�˵�λ�� ���״̬ �Ƿ�
			public List sele_uufy(int id){
				
				return dao.sele_uufy(id);
			}
}
