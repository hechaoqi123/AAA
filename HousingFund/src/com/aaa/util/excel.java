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
   //读
 public static List<List> ready() throws Exception{
	    //读取此工作册
	  Workbook book=Workbook.getWorkbook(new File( "D:/test.xls" ));
	    Sheet[] sheets=book.getSheets();//获取所有页
	     Sheet sheet1=sheets[0];//取出第一页
	      int rows=sheet1.getRows();//行数
	      List list=new ArrayList();
			for(int i=0;i<rows;i++){
				Cell[] cells = sheet1.getRow(i);//获取当前行的所有单元格
				   List row=new ArrayList();
				for (Cell cell : cells) {
					row.add(cell.getContents());
				}
				list.add(row);
			}
	return list;
  }
  //写
  public static  void write(){
	  try {
			//创建一个excal（输出流）
			WritableWorkbook book = Workbook.createWorkbook(new File( "D:/test.xls" ));
			//创建页（title,index）
			 WritableSheet sheet = book.createSheet( "sheet1" , 0 );
			//创建一个单元格（行，列，值）并将其添加到页(sheet)中
	         Label cell=new Label(0,0,"aaa"); 
	         sheet.addCell(cell); 
			 book.write();
			 book.close();//关闭输出流（必须要关闭。）
	} catch (Exception e) {
              e.printStackTrace();
	}
	  
  }
  
  public static void excelOut() {  
      WritableWorkbook bWorkbook = null;  
      try {  
          // 创建Excel对象  
          bWorkbook = Workbook.createWorkbook(new File("D:/book.xls"));  
          // 通过Excel对象创建一个选项卡对象  
          WritableSheet sheet=bWorkbook.createSheet("sheet1", 0);  
          //使用循环将数据读出   这个地方应该是从数据库查出
          for (int i = 0; i <3; i++) {  
              Label label=new Label(0,i,String.valueOf("qqq"));  //前一个参数代表列，后一个参数代表行,r
              Label label1=new Label(1,i,String.valueOf("aaa"));  
              Label label2=new Label(2,i,String.valueOf("ccc"));  
              sheet.addCell(label);  
              sheet.addCell(label1);  
              sheet.addCell(label2);  
          }  
          // 创建一个单元格对象，第一个为列，第二个为行，第三个为值  
          Label label = new Label(0, 2, "test");  
          // 将创建好的单元格放入选项卡中  
          //sheet.addCell(label);  
          // 写如目标路径  
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
			//导入已存在的Excel文件，获得只读的工作薄对象
			        FileInputStream fis=new FileInputStream("D:/公积金信息登记.xls");
			        Workbook wk=Workbook.getWorkbook(fis);
			        //获取第一张Sheet表 
			        Sheet sheet=wk.getSheet(0);
			        //拿到公司账户编号
			        utinaccountinfo.setUtinAccountId(Integer.parseInt(sheet.getCell(8, 1).getContents()));
			        //获取总行数
			        int rowNum=sheet.getRows();
			        //从数据行开始迭代每一行
			        for(int i=1;i<rowNum;i++){
			        	Indaccountinfo indaccountinfo=new Indaccountinfo();        
			        	Indinfo indinfo = new Indinfo();
						//getCell(column,row)，表示取得指定列指定行的单元格（Cell）
						//getContents()获取单元格的内容，返回字符串数据。适用于字符型数据的单元格
						//使用实体类封装单元格数据
			        	
			        	//个人信息
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
						
						
						//个人账户信息
						indaccountinfo.setIndDepositRadices(Float.valueOf(sheet.getCell(8, i).getContents()));
						indaccountinfo.setBankSaAccount(sheet.getCell(19, i).getContents());
						indaccountinfo.setBankOpenAccount(sheet.getCell(20, i).getContents());
						indaccountinfo.setTrueName(sheet.getCell(0, i).getContents());
						indaccountinfo.setIdnumber(sheet.getCell(4, i).getContents());
			            //判断单元格的类型，单元格主要类型LABEL、NUMBER、DATE                    
//			            if(sheet.getCell(2,i).getType==CellType.NUMBER){
						//转化为数值型单元格
					/*	NumberCell numCell=(NumberCell)sheet.getCell(2,i);
						//NumberCell的getValue()方法取得单元格的数值型数据
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
						//DateCell的getDate()方法取得单元格的日期型数据
						info.setDate(dateCell.getDate());
						}*/
			        	fis.close();
						wk.close();
			      		return list_indinfos;
			        }
}