package cn.arice.com.bean;

import java.util.List;

public class PageBean<T> {

	/**��ǰҳ*/
	private int currentPage = 1;
	
	/**ÿҳ��ʾ��������*/
	private int maxResult;
	
	/**Ҫ��ѯ�ĵ�һ�����ݵ�����*/
	private int firstIndex;
	
	/**��ҳ��*/
	private int totalPage;
	
	/**������*/
	private int totalCount;
	
	/**��ҳ�Ľ����*/
	private List<T> dataList;
	
	public int getTotalPage() {  //ͨ���ܼ�¼����ÿҳ��ʾ��������¼��� ��ҳ��
		this.totalPage = totalCount % maxResult == 0 ? totalCount / maxResult : totalCount / maxResult + 1;
		return totalPage;
	}
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}


	public int getMaxResult() {
		return maxResult;
	}


	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}


	public int getFirstIndex() {
		this.firstIndex = (currentPage-1)*maxResult;
		return firstIndex;
	}


	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	
	
	
}
