package com.aaa.entity;

import java.util.List;

public class PageEntitys {
	  private int pageSize=2;//ÿҳ����
	   private int currPage=1;//��ҳ
	   private int allPage;//��ҳ��
	   private int allRows;//������
	   private boolean isFirst;//�Ƿ���ҳ
	   private boolean isLast;//�Ƿ�βҳ
	   private List list;//��ҳ����
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public int getAllRows() {
		return allRows;
	}
	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}
	public boolean isFirst() {
		return isFirst;
	}
	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}
	public boolean isLast() {
		return isLast;
	}
	public void setLast(boolean isLast) {
		this.isLast = isLast;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}


}
