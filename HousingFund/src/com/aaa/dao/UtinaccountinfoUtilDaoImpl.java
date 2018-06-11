package com.aaa.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.*;
import com.aaa.util.TeacherPageUtil;


@Repository
public class UtinaccountinfoUtilDaoImpl implements UtinaccountinfoUtilDao {

	@Resource
	private HibernateTemplate ht;
	@Resource
	private TeacherPageUtil util;
	
	@Override
	public Double UtinSumMoneySele(Integer UtinId) {
		
		List list= ht.find("select SUM((IndDepositRadices*IndDepositRatio)*2) from Indaccountinfo where UtinAccountID="+UtinId+"  and indStatus='����'");
		Double m=(Double)list.get(0);
		return m;
	}
	public List<Utinaccountinfo> ss(int id){
		
		
		List<Utinaccountinfo> list=ht.find(
				"from Utinaccountinfo  where UtinAccountID="+id+" and accountStatus='����'");
	return list;
	}
	public List<Flupay> selefu(){
		
		List<Flupay> list=ht.find(" from Flupay where ifelseFp='��'");
		return list;
	}
	
	//��ӻ����޸�
		public int upinse(Flupay fu){
			List<Flupay> list=ht.find("from Flupay f where f.utinaccountinfo.utinAccountId="+fu.getUtinaccountinfo().getUtinAccountId()+"");
			
			
			if(list.size()>0){
				
				Flupay f=ht.get(Flupay.class,list.get(0).getFluPayid());
				f.setIfelseFp(fu.getIfelseFp());
				ht.update(f);	
				
				return 1;
			}else{
				
				ht.save(fu);
				return 1;
			}
			
		}
	
	@Override
	public List UtinInfoSele(Integer UtinId) {
		try {
			List list=ht.find("select new map(" +
					            "utinAccountId as utinAccountId," +
								"accountStatus as accountStatus," +
								"utinDepositRatio as utinDepositRatio," +
								"utinSumPeople as utinSumPeople," +
								"utinDepositPeople as utinDepositPeople," +
								"utinSealPeople as utinSealPeople," +
								"utinName as utinName," +
								"utinProvRema as utinProvRema"+
								") from Utinaccountinfo  where utinAccountId="+UtinId+"");
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
				
	}
	//��λԱ����Ϣ
	@Override
	public List IndAccountInfoSele(Integer UtinId) {
		try {
			List list=ht.find("select  new map(i.indAccountId as indAccountId,i.idnumber as iDNumber,i.trueName as trueName,i.indDepositRadices as indDepositRadices,i.indDepositRatio as indDepositRatio,i.presentSumRem as presentSumRem,i.usableRem as usableRem) from Indaccountinfo i where i.indStatus='����'  and  i.utinaccountinfo.utinAccountId="+UtinId+"");
			
			return list;
		} catch (Exception e) {
			System.out.println("UtinaccountinfoUtilDaoImpl�е�IndAccountInfoSele���������쳣���쳣��Ϣ����");
			e.printStackTrace();
		}
		return null;
	}
	//��ѯ�ϴλ��
   public List sele_date(Integer UtinId){
		
		List list= ht.find("select new map(u.payinSumMoney as PayinSumMoney,u.depositPeople as DepositPeople,u.depositDate as DepositDate ) from Utinremittancedetail u where u.utinaccountinfo.utinAccountId="+UtinId+" ORDER BY   STR_TO_DATE(u.depositDate,'%Y-%m-%d %H:%i') DESC ");
	     
		return list;
	}
 //��ѯ��λ
 		public TeachaerPageEntity sele_utin(TeachaerPageEntity page){
 			String sql="select new map(u.utinAccountId as utinAccountId," +
 					"u.accountStatus as accountStatus,u.utinName as utinName," +
 					"u.unitinfo.utinAddress as utinAddress," +
 					"u.unitinfo.corpRepr as corpRepr," +
 					"u.unitinfo.operatorName as operatorName) " +
 					"from Utinaccountinfo u where u.accountStatus='����' order by u.utinAccountId";
 			//String sql="from Proof";
 			TeachaerPageEntity pa=util.getPage(sql, page);
 			
 			return pa;
 		}
 		//��λidģ����ѯ
 				public TeachaerPageEntity sele_mohuid(TeachaerPageEntity page,int ids){
 					String sql="select new map(u.utinAccountId as utinAccountId," +
 		 					"u.accountStatus as accountStatus,u.utinName as utinName," +
 		 					"u.unitinfo.utinAddress as utinAddress," +
 		 					"u.unitinfo.corpRepr as corpRepr," +
 		 					"u.unitinfo.operatorName as operatorName) " +
 		 					"from Utinaccountinfo u where u.accountStatus='����' and u.utinAccountId  like '%"+ids+"%'";
 		 			//String sql="from Proof";
 		 			TeachaerPageEntity pa=util.getPage(sql, page);	
 					return pa;
 				}
 				//��λ����ģ����ѯ
 				public TeachaerPageEntity sele_mohuname(TeachaerPageEntity page,String utinname){
 					
 					String sql="select new map(u.utinAccountId as utinAccountId," +
 		 					"u.accountStatus as accountStatus,u.utinName as utinName," +
 		 					"u.unitinfo.utinAddress as utinAddress," +
 		 					"u.unitinfo.corpRepr as corpRepr," +
 		 					"u.unitinfo.operatorName as operatorName) " +
 		 					"from Utinaccountinfo u where u.accountStatus='����' and u.utinName  like '%"+utinname+"%'";
 		 			//String sql="from Proof";
 		 			TeachaerPageEntity pa=util.getPage(sql, page);	
 					return pa;	
 				}

 				//������λ
				@Override
				public List<Utinaccountinfo> utinse() {
					// TODO Auto-generated method stub
					List<Utinaccountinfo> list=ht.find("from Utinaccountinfo where accountStatus='����'");
					return list;
				}
				//�����Ƿ���ɹ�
				public List sele_uddate(int id){
					
					List utlist=ht.find("select depositDate from Utinremittancedetail ut " +
							"where ut.utinaccountinfo.utinAccountId="+id+" " +
									"order by STR_TO_DATE(DepositDate,'%Y-%m-%d') desc ");
					return utlist;
				}
				//�õ��˻����
				public Double sele_yue(int id){
					
					List list=ht.find("select utinProvRema from Utinaccountinfo where utinAccountId="+id+"");
				  Double money=(Double) list.get(0);
				  return money;
				}
				//�õ����и����˻���Ϣ 
				public List<Indaccountinfo> sele_Allindinfo(int id){
					
			List<Indaccountinfo> list=ht.find(
							"from Indaccountinfo ind where" +
							" ind.utinaccountinfo.utinAccountId="+id+" and " +
							" ind.indStatus='����'");
					return list;
				}
				//�õ�������Ϣ���޸�
				public Indaccountinfo sele_oneindinfo(int uid,int iid,String uname){
					//�Ȳ�ѯ
					Indaccountinfo ind=ht.get(Indaccountinfo.class, iid);
					//�˻����=�����+���»���*����*2
					ind.setPresentSumRem(ind.getPresentSumRem()+
							ind.getIndDepositRadices()*ind.getIndDepositRatio()*2);
					//�������ͬ��
					ind.setUsableRem(ind.getUsableRem()+
							ind.getIndDepositRadices()*ind.getIndDepositRatio()*2);
					//�޸�
					ht.update(ind);
					
					//��Ӹ��˻�ɼ�¼
					Remittancedetail rd=new Remittancedetail();
					Utinaccountinfo uti=ht.get(Utinaccountinfo.class, uid);
					//��λ�˻����
					rd.setUtinaccountinfo(uti);
					//�����˻�id
					rd.setIndAccountId(Integer.toString(iid));
					rd.setUtinAccount(uname);
					rd.setIndAccount(Integer.toString(iid));
					rd.setPayinSumMoney(ind.getIndDepositRadices()*ind.getIndDepositRatio()*2);
					rd.setPayinDate(new Date(new java.util.Date().getTime()));
					ht.save(rd);
					
					return null;
				}
				//�޸��˻����
				public int update_utinmoney(int id,Double money){
					Utinaccountinfo utin=ht.get(Utinaccountinfo.class, id);
					//�޸ĵ�λ���
					utin.setUtinProvRema(utin.getUtinProvRema()-money);
					ht.update(utin);
					return 0;
				}
				//��ӵ�λ��ɼ�¼
				public int add_rd(int id,Double money){
					Date d=new Date();
					SimpleDateFormat ftm=new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat ftm2=new SimpleDateFormat("yyyy-MM");
					String date=ftm.format(d);
					String month=ftm2.format(d);//��
					//��λ��ɼ�¼
					Utinremittancedetail ud=new Utinremittancedetail();
					Utinaccountinfo utin=ht.get(Utinaccountinfo.class, id);
					ud.setUtinaccountinfo(utin);
					ud.setUtinName(utin.getUtinName());
					ud.setPayinSumMoney(money);//�ܽ��
					ud.setDepositPeople(utin.getUtinDepositPeople());//�������
					ud.setDepositDate(date);
					ud.setFinaldate(month);
					ud.setOridate(month);
					ud.setRemonth(Integer.toString(1));
					ud.setAdminname("�Զ����");
					ht.save(ud);
					return 0;
				}
				
				//��ѯ�˵�λ�Ƿ����
				
				public List sele_utinid(int id){
					
					String sql="select new map(utinAccountId as utinAccountId,utinName as utinName,utinDepositRatio as utinDepositRatio) from Utinaccountinfo where utinAccountId="+id+"";
					
               
					List list=ht.find(sql);
					return list;
				}
				//��ѯ�˵�λ�Ƿ���ҵ���˲� ��ѯ��λ���˴���
				public List sele_fy(int id){
					String sql="select new map(u.utinAccountId as utinAccountId,"
							+ "u.unitinfo.utinName as utinName,"
							+ "u.unitinfo.corpRepr as corpRepr)"
							+ "from Utinaccountinfo u  where u.utinAccountId="+id+"";
					List list=ht.find(sql);
				
						return list;
					
				}
				//��ѯ�˵�λ�� ���״̬ �Ƿ�
				public List sele_uufy(int id){
					String sql="select new map(f.ifelseFp as ifelseFp)"
							+ "from Flupay f where f.utinaccountinfo.utinAccountId="+id+"";
					List list=ht.find(sql);
					return list;
				}
				
				
				
				}
   

