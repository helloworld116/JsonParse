package com.jdtx.sort;

public class PageInfo {

	private String currentPage;//��ʾ��ǰҳ����
	private String pageSize;//��ʾҳ����ʾ��¼��
	private String totalNum;//��ʾ�ܼ�¼��
	private String totalPage;//��ʾ��ҳ��
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

}
