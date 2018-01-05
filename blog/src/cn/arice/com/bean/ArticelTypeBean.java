package cn.arice.com.bean;
/**
 * 
 * @author Arice 徐新凯
 * @description ArticelTypeBean 文章类别表
 * @data 2016-4-3
 */
public class ArticelTypeBean {
	/**文章类别编号*/
	private int tid;
	/**类别名字*/
	private String tname;
	/**类别描述*/
	private String tdesc;
	
	/**类别下的文章数  可以省略*/
	private int anum;
	public int getAnum() {
		return anum;
	}



	public void setAnum(int anum) {
		this.anum = anum;
	}



	
	
	
	
	public ArticelTypeBean() {
		super();
	}



	public int getTid() {
		return tid;
	}



	public void setTid(int tid) {
		this.tid = tid;
	}



	public String getTname() {
		return tname;
	}



	public void setTname(String tname) {
		this.tname = tname;
	}



	public String getTdesc() {
		return tdesc;
	}



	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}
	
	
	
	
	
	
}
