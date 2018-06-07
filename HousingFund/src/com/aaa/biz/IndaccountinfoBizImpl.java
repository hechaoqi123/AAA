package com.aaa.biz;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.IndAccountinfoDao;
import com.aaa.dao.IndAccountinfoDaoImpl;
import com.aaa.dao.UnitinfoDao;
import com.aaa.dao.UtinaccountinfoDao;
import com.aaa.entity.*;
import com.aaa.util.JSON;

@Service
@Transactional
public class IndaccountinfoBizImpl implements IndaccountinfoBiz {

	@Resource
	private IndAccountinfoDao dao;
	@Autowired
	private UtinaccountinfoDao uDao;
	
	
	
	// 汇缴之后  ——> 修改个人账户的余额
	/* (non-Javadoc)
	 * @see com.aaa.dao.IndaccountinfoDao#update_Indaccount(com.aaa.entity.Indaccountinfo)
	 */
	@Override
	public int update_Indaccount(Indaccountinfo ind,RDUtil rd){
		dao.update_Indaccount(ind, rd);
		return 0;
	}
	//修改单位账户余额
	public int update_utinmoney(RDUtil rd){
		return dao.update_utinmoney(rd);
	}
  //获取个人账户信息	
	@Transactional(readOnly=true)
	public Indaccountinfo getOne(int id) {
		return dao.getOne(id);
	}
  //获取个人账户信息
	@Transactional(readOnly=true)
	public List fingByExample(Indaccountinfo entity) {
		return dao.findByExample(entity);
	}

	@Override
	public List ind_MyMoney(String idnum) {
		return dao.ind_MyMoney(idnum);
	}
	
	
	
	//增加
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
		//获取总金额
		@Override
		public int getMoney(Indaccountinfo entity) {
			   if(entity!=null){
				  Float money=dao.findByExample(entity).get(0).getPresentSumRem();
				   return money.intValue();
			   }
			   throw new RuntimeException("没查询到个人账户");
		}
		//冲还贷款
		@Override
		public void return_loan(Indaccountinfo entity,Float money) {
			Indaccountinfo ind=dao.findByExample(entity).get(0);
			ind.setPresentSumRem(ind.getPresentSumRem()-money);
		}
		//冻结
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
		public List saveFileIndaccountinfo(File file, Integer utinaccountinfoID) throws Exception {
			return dao.saveFileIndaccountinfo(file, utinaccountinfoID);
		}
		@Override
		public List getOneIndaf(Indinfo indinfo) {
			return dao.getOneIndaf(indinfo);
		}
		@Override
		public List UtinegetOneEmp(Indaccountinfo indaccountinfo) {
			return dao.UtinegetOneEmp(indaccountinfo);
		}
		//账户转移
		@Override
		public void utine(int indId, int unitId) {
			 
			Indaccountinfo ind = dao.getOne(indId);
			  //原单位单位总人数减一
			ind.getUtinaccountinfo().setUtinSumPeople(ind.getUtinaccountinfo().getUtinSumPeople()-1);
			   //原单位封存人数减一
			ind.getUtinaccountinfo().setUtinSealPeople(ind.getUtinaccountinfo().getUtinSealPeople()-1);
			   //恢复个人账户状态   
			ind.setIndStatus("正常");;
			   //新单位
		    Utinaccountinfo unit = uDao.getOne(unitId);
			     //新单位总人数加一缴存人数加一
			    unit.setUtinSumPeople(unit.getUtinSumPeople()+1);
			    unit.setUtinDepositPeople(unit.getUtinDepositPeople()+1);
			 //更换单位   
			ind.setUtinaccountinfo(unit);
		}

}
