package cn.arice.com.bean;

import java.util.List;

public class PageBean<T> {

	/**当前页*/
	private int currentPage = 1;
	
	/**每页显示多少数据*/
	private int maxResult;
	
	/**要查询的第一条数据的索引*/
	private int firstIndex;
	
	/**总页数*/
	private int totalPage;
	
	/**总条数*/
	private int totalCount;
	
	/**分页的结果集*/
	private List<T> dataList;
	
	public int getTotalPage() {  //通过总记录数与每页显示多少条记录算出 总页数
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
