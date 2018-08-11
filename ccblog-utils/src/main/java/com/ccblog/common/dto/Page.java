package com.ccblog.common.dto;

import org.apache.commons.net.nntp.Article;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private int pageNo = 1;//页码，默认是第一页
    private int pageSize = 15;//每页显示的记录数，默认是15
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private String message;
    
    private List<Article> simpleResult=new ArrayList<Article>();//返回记录SimpleResult

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	

	public List<Article> getSimpleResult() {
		return simpleResult;
	}

	public void setSimpleResult(List<Article> simpleResult) {
		simpleResult = simpleResult;
	}

	public Page() {
		super();
	}

	public Page(int pageNo, int pageSize, int totalRecord, int totalPage, List<Article> simpleResult) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		simpleResult = simpleResult;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
