package com.aaa.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.*;

import jxl.Sheet;
import jxl.Workbook;

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
			utinaccountinfoEntity.setUtinDepositPeople((utinaccountinfoEntity.getUtinDepositPeople()+1));
		}else{
			utinaccountinfoEntity.setUtinSumPeople(1);
			utinaccountinfoEntity.setUtinDepositPeople((utinaccountinfoEntity.getUtinDepositPeople()+1));
		}
		indaccountinfo.setIndDepositRatio(Float.valueOf(utinaccountinfoEntity.getUtinDepositRatio().toString()));
		hibernateTemplate.update(utinaccountinfoEntity);
		indaccountinfo.setIndinfo(indinfoEntity);
		indaccountinfo.setUtinaccountinfo(utinaccountinfoEntity);
		Serializable save2 = hibernateTemplate.save(indaccountinfo);//��ӳɹ����ȡ����������
		return save2.hashCode();
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
		//����ĳ����˾��Ա��
		String hql = "select new map(a.indAccountId as indAccountId, " +
									"a.indinfo.trueName as trueName, " +
									"a.indinfo.duties as duties, " +
									"a.indDepositRadices as indDepositRadices, " +
									"a.usableRem as usableRem, " +
									"a.indStatus as indStatus, " +
									"a.presentSumRem as presentSumRem" +
									") from Indaccountinfo a where a.indinfo.trueName like '%"+indaccountinfo.getIndinfo().getTrueName()+"%' and  a.utinaccountinfo.utinAccountId = "+utinaccountinfoID;
		//Ա����Ϣ�޸�ʱģ����ѯ
		if(utinaccountinfoID==-1){
			hql = "select new map(a.indAccountId as indAccountId, " +
									"a.indinfo.trueName as trueName, " +
									"a.indinfo.duties as duties, " +
									"a.indDepositRadices as indDepositRadices, " +
									"a.usableRem as usableRem, " +
									"a.indStatus as indStatus, " +
									"a.presentSumRem as presentSumRem) from Indaccountinfo a where a.indinfo.trueName like '%"+indaccountinfo.getIndinfo().getTrueName()+"%'";
		}
		//Ա����Ϣ�޸�ʱ��ѯ����Ա��
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
	//�޸Ļ�����״̬
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
			//���Ա��
			if(indaccountinfo.getIndStatus().equals("���")){
				utinaccountinfoEntity.setUtinSealPeople(utinaccountinfoEntity.getUtinSealPeople()+1);//utinaccountinfoEntity.getUtinSealPeople()��λ�������
				utinaccountinfoEntity.setUtinDepositPeople((utinaccountinfoEntity.getUtinDepositPeople()-1));//�����ɴ�����
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
	//����
	@Override
	public int frozenEmp(Indaccountinfo indaccountinfo) {
		Indaccountinfo indaccountinfo2 = hibernateTemplate.get(Indaccountinfo.class, indaccountinfo.getIndAccountId());
		Utinaccountinfo utinaccountinfoEntity = hibernateTemplate.get(Utinaccountinfo.class, indaccountinfo2.getUtinaccountinfo().getUtinAccountId());
		if(indaccountinfo2.getIndStatus().equals("����")){
			return 0;
		}else if(indaccountinfo2.getIndStatus().equals("����")){
			utinaccountinfoEntity.setUtinSealPeople(utinaccountinfoEntity.getUtinSealPeople()+1);
			indaccountinfo2.setIndStatus("���");
			hibernateTemplate.update(indaccountinfo2);
			hibernateTemplate.update(utinaccountinfoEntity);
			return -1;
		}else{
			//������˾�����������������
			utinaccountinfoEntity.setUtinSealPeople(utinaccountinfoEntity.getUtinSealPeople()-1);
			indaccountinfo2.setIndStatus("����");
			hibernateTemplate.update(indaccountinfo2);
			hibernateTemplate.update(utinaccountinfoEntity);
			return 1;
		}
	}
	/* (non-Javadoc)
	 * @see com.aaa.dao.IndAccountinfoDao#saveFileIndaccountinfo(java.io.File)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List saveFileIndaccountinfo(File file) throws Exception {
	 	List<Indinfo> list_indinfos = new ArrayList<Indinfo>();
	 	List<Indaccountinfo> list_indaccountinfo = new ArrayList<Indaccountinfo>();
	 	List<Indaccountinfo> list_indaccountinfos = new ArrayList<Indaccountinfo>();
	 	Utinaccountinfo utinaccountinfo = new Utinaccountinfo();
		//�����Ѵ��ڵ�Excel�ļ������ֻ���Ĺ���������
	 	//File f =new File("D:/��������Ϣ�Ǽ�.xls");
	 	FileInputStream fis = new FileInputStream(file);
	 	Workbook wk=Workbook.getWorkbook(fis);
	 	Sheet sheet = null;
	 	try {
	 		sheet=wk.getSheet(0);
	 		 //��ȡ��һ��Sheet�� 
	        //�õ���˾�˻����
	        utinaccountinfo.setUtinAccountId(Integer.parseInt(sheet.getCell(8, 1).getContents()));
	        //��ȡ������
	        int rowNum=sheet.getRows();
	        //�������п�ʼ����ÿһ��
	        for(int i=1;i<rowNum;i++){
	        	Indaccountinfo indaccountinfo=new Indaccountinfo();        
	        	Indinfo indinfo = new Indinfo();
				//getCell(column,row)����ʾȡ��ָ����ָ���еĵ�Ԫ��Cell��
				//getContents()��ȡ��Ԫ������ݣ������ַ������ݡ��������ַ������ݵĵ�Ԫ��
				//ʹ��ʵ�����װ��Ԫ������
	        	
	        	//������Ϣ
				indinfo.setTrueName(sheet.getCell(0, i).getContents());
				indinfo.setFixedPhone(sheet.getCell(2, i).getContents());
				indinfo.setPhoneNumber(sheet.getCell(3, i).getContents());
				indinfo.setIdnumber(sheet.getCell(4, i).getContents());
				indinfo.setWedlockStatus(sheet.getCell(5, i).getContents());
				indinfo.setFamilyAddress(sheet.getCell(6, i).getContents());
				indinfo.setFamilyMonthIncome(Integer.parseInt(sheet.getCell(7, i).getContents()));
				indinfo.setDuties(sheet.getCell(10, i).getContents());
				
				
				
				//�����˻���Ϣ
				indaccountinfo.setIndDepositRadices(Float.valueOf(sheet.getCell(11, i).getContents()));
				indaccountinfo.setBankSaAccount(sheet.getCell(19, i).getContents());
				indaccountinfo.setBankOpenAccount(sheet.getCell(20, i).getContents());
				indaccountinfo.setTrueName(sheet.getCell(0, i).getContents());
				indaccountinfo.setIdnumber(sheet.getCell(4, i).getContents());
	            //�жϵ�Ԫ������ͣ���Ԫ����Ҫ����LABEL��NUMBER��DATE                    
//			            if(sheet.getCell(2,i).getType==CellType.NUMBER){
				//ת��Ϊ��ֵ�͵�Ԫ��
			/*	NumberCell numCell=(NumberCell)sheet.getCell(2,i);
				//NumberCell��getValue()����ȡ�õ�Ԫ�����ֵ������
				info.setRscore(numCell.getValue());*/
				String hql = "From Indaccountinfo where idnumber ='"+sheet.getCell(4, i).getContents()+"'";//��ѯ���ڸ�Ա���Ƿ����
				List<Indaccountinfo> find = hibernateTemplate.find(hql);
				if(find.size()>0){
					for (Indaccountinfo indaccountinfo2 : list_indaccountinfos) {
						//���list���Ƿ��Ѿ����ڸö���
						if(!(indaccountinfo2.getIndAccountId().equals(find.get(0).getIndAccountId()))){
							list_indaccountinfos.add(find.get(0));
						}
					}
				}else{
					Integer utinAccountId = utinaccountinfo.getUtinAccountId();
					int indid = saveIndaccountinfo(indinfo, indaccountinfo, utinAccountId);
					Indaccountinfo indaccountinfoObject = hibernateTemplate.get(Indaccountinfo.class, indid);
					list_indaccountinfo.add(indaccountinfoObject);
				}
	        }
        	fis.close();
			wk.close();
			List<List<Indaccountinfo>> list = new ArrayList<List<Indaccountinfo>>();
			list.add(list_indaccountinfos);
			list.add(list_indaccountinfo);
			return list;
		} catch (Exception e) {
			List<String> errot_list = new ArrayList();
			errot_list.add("errorFile");
			return errot_list;
		}
	}
	
	//������ѯһ����Ϣ
	public List getOneIndaf(Indinfo indinfo){
		String hql = null;
		List<Indaccountinfo> oneIndaccountinfoObject = null;
		if(indinfo.getIdnumber() != null){
			hql = "FROM Indaccountinfo i WHERE i.idnumber ='"+indinfo.getIdnumber()+"'";
			oneIndaccountinfoObject = hibernateTemplate.find(hql);
		}
		return oneIndaccountinfoObject;
		}
	@Override
	public List UtinegetOneEmp(Indaccountinfo indaccountinfo) {
		String hql = null;
		List oneIndaccountinfoObject = null;
		if(indaccountinfo.getIndAccountId() != 0){
			hql = "Select new Map(i.indAccountId as indAccountId,"
								+ "i.trueName as trueName, "
								+ "i.utinaccountinfo.unitinfo.utinName as utinName ) "
								+ "FROM Indaccountinfo i WHERE i.indAccountId ="+indaccountinfo.getIndAccountId();
			oneIndaccountinfoObject = hibernateTemplate.find(hql);
		}
		return oneIndaccountinfoObject;
	}
}

