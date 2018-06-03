package com.aaa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.aaa.entity.Indaccountinfo;
import com.aaa.entity.Indinfo;
import com.aaa.entity.Utinaccountinfo;


public class excel {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	
  public static void main(String[] args) throws Exception {
	  String c = new String("b");
	  String b = new String("b");
	  String a = "b";
	  System.out.println(a==b);
	  System.out.println(a.equals(b));
	  System.out.println(b==c);
	  System.out.println(b!=c);
}
   //��
 public static List<List> ready() throws Exception{
	    //��ȡ�˹�����
	  Workbook book=Workbook.getWorkbook(new File( "D:/test.xls" ));
	    Sheet[] sheets=book.getSheets();//��ȡ����ҳ
	     Sheet sheet1=sheets[0];//ȡ����һҳ
	      int rows=sheet1.getRows();//����
	      List list=new ArrayList();
			for(int i=0;i<rows;i++){
				Cell[] cells = sheet1.getRow(i);//��ȡ��ǰ�е����е�Ԫ��
				   List row=new ArrayList();
				for (Cell cell : cells) {
					row.add(cell.getContents());
				}
				list.add(row);
			}
	return list;
  }
  //д
  public static  void write(){
	  try {
			//����һ��excal���������
			WritableWorkbook book = Workbook.createWorkbook(new File( "D:/test.xls" ));
			//����ҳ��title,index��
			 WritableSheet sheet = book.createSheet( "sheet1" , 0 );
			//����һ����Ԫ���У��У�ֵ����������ӵ�ҳ(sheet)��
	         Label cell=new Label(0,0,"aaa"); 
	         sheet.addCell(cell); 
			 book.write();
			 book.close();//�ر������������Ҫ�رա���
	} catch (Exception e) {
              e.printStackTrace();
	}
	  
  }
  
  public static void excelOut() {  
      WritableWorkbook bWorkbook = null;  
      try {  
          // ����Excel����  
          bWorkbook = Workbook.createWorkbook(new File("D:/book.xls"));  
          // ͨ��Excel���󴴽�һ��ѡ�����  
          WritableSheet sheet=bWorkbook.createSheet("sheet1", 0);  
          //ʹ��ѭ�������ݶ���   ����ط�Ӧ���Ǵ����ݿ���
          for (int i = 0; i <3; i++) {  
              Label label=new Label(0,i,String.valueOf("qqq"));  //ǰһ�����������У���һ������������,r
              Label label1=new Label(1,i,String.valueOf("aaa"));  
              Label label2=new Label(2,i,String.valueOf("ccc"));  
              sheet.addCell(label);  
              sheet.addCell(label1);  
              sheet.addCell(label2);  
          }  
          // ����һ����Ԫ����󣬵�һ��Ϊ�У��ڶ���Ϊ�У�������Ϊֵ  
          Label label = new Label(0, 2, "test");  
          // �������õĵ�Ԫ�����ѡ���  
          //sheet.addCell(label);  
          // д��Ŀ��·��  
          bWorkbook.write();  
      } catch (Exception e) {  
          // TODO Auto-generated catch block  
          e.printStackTrace();  
      } finally {  
          try {  
              bWorkbook.close();  
          } catch (Exception e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }  }
      } 
  
 

}


class a {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	 public List<Indinfo> loadScoreInfo() throws IOException, BiffException{
		 	List<Indinfo> list_indinfo = new ArrayList<Indinfo>();
		 	List<Indinfo> list_indinfos = new ArrayList<Indinfo>();
		 	List<Indaccountinfo> list_indaccountinfo = new ArrayList<Indaccountinfo>();
		 	List<Indaccountinfo> list_indaccountinfos = new ArrayList<Indaccountinfo>();
		 	Utinaccountinfo utinaccountinfo = new Utinaccountinfo();
			//�����Ѵ��ڵ�Excel�ļ������ֻ���Ĺ���������
			        FileInputStream fis=new FileInputStream("D:/��������Ϣ�Ǽ�.xls");
			        Workbook wk=Workbook.getWorkbook(fis);
			        //��ȡ��һ��Sheet�� 
			        Sheet sheet=wk.getSheet(0);
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
						
						
						System.out.println(sheet.getCell(0, i).getContents());
						System.out.println(sheet.getCell(4, i).getContents());
						
						
						//�����˻���Ϣ
						indaccountinfo.setIndDepositRadices(Float.valueOf(sheet.getCell(8, i).getContents()));
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
						String hql = "From Indaccountinfo i where i.idnumber = "+sheet.getCell(4, i).getContents();
						List find = hibernateTemplate.find(hql);
						if(find.size()>0){
							list_indinfo.add(indinfo);
							list_indaccountinfo.add(indaccountinfo);
						}else{
							list_indinfos.add(indinfo);
							list_indaccountinfos.add(indaccountinfo);
						}
			        	}
						/*if(sheet.getCell(3,i).getType==CellType.NUMBER){
						NumberCell numCell=(NumberCell)sheet.getCell(3,i);
						info.setRscore(numCell.getValue);
						}
						 
						if(sheet.getCell(4,i).getType==CellType.DATE){
						DateCell dateCell=(DateCell)sheet.getCell(4,i);
						//DateCell��getDate()����ȡ�õ�Ԫ�������������
						info.setDate(dateCell.getDate());
						}*/
			        	fis.close();
						wk.close();
			      		return list_indinfos;
			        }
}