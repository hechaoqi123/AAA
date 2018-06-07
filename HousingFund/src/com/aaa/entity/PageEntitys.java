package com.aaa.entity;

import java.util.List;

public class PageEntitys {
	  private int pageSize=2;//每页条数
	   private int currPage=1;//首页
	   private int allPage;//总页数
	   private int allRows;//总条数
	   private boolean isFirst;//是否首页
	   private boolean isLast;//是否尾页
	   private List list;//分页数据
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
