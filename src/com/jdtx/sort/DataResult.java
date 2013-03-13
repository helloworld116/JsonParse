package com.jdtx.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataResult {

//	private String status;
//	private PageInfo pageInfo;
//	public PageInfo getPageInfo() {
//		return pageInfo;
//	}
//	public void setPageInfo(PageInfo pageInfo) {
//		this.pageInfo = pageInfo;
//	}
//	private List<DataInfo> dataInfo;
//	
//	public List<DataInfo> getDataInfo() {
//		return dataInfo;
//	}
//	public void setDataInfo(List<DataInfo> dataInfo) {
//		this.dataInfo = dataInfo;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	
	private String ID;
	private String name;
	private String state;
	private String desciption;
	private LinkedList<Chapter> chapters;

	public LinkedList<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(LinkedList<Chapter> chapters) {
		this.chapters = chapters;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
}

class Chapter{
	private String chapter_id;
	private String chapter_name;
	public String getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(String chapter_id) {
		this.chapter_id = chapter_id;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	
}
