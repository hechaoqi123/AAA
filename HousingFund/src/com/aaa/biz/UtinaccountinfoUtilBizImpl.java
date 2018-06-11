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
	@Override//总缴纳金额
	public Double UtinSumMoneySele(Integer UtinId) {
		Double m=dao.UtinSumMoneySele(UtinId);
		return m;
	}
	@Override
	public List UtinInfoSele(Integer UtinId) {
		return dao.UtinInfoSele(UtinId);
	}
	//查询单位员工信息
	@Override
	public List IndAccountInfoSele(Integer UtinId) {
		return dao.IndAccountInfoSele(UtinId);
	}
	//查询上次汇缴
			public List sele_date(Integer UtinId){
				
				return dao.sele_date(UtinId);
			}
			//查询单位
			public TeachaerPageEntity sele_utin(TeachaerPageEntity page){
	 			
	 			return dao.sele_utin(page);
	 		}
			//单位id模糊查询
			public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids){
				
				return dao.sele_mohuid(page, ids);
			}
			//单位名称模糊查询
			public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname){
				
				return dao.sele_mohuname(page, utinname);
			}
			//查询此单位是否存在
			public List sele_utinid(int id){
				
				return dao.sele_utinid(id);
			}
			//查询此单位是否开启业务了并 查询单位法人代表
			public List sele_fy(int id){
				
				return dao.sele_fy(id);
			}
			//查询此单位的 冲缴状态 是否
			public List sele_uufy(int id){
				
				return dao.sele_uufy(id);
			}
}
