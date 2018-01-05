package cn.arice.com.bean;
/**
 * 
 * @author Arice 徐新凯
 * @description ArticleBean  文章详细信息表
 * @data 2016-4-3
 */
public class ArticleBean {
	/**文章编号(20160506152335-年月日时分秒)*/
	private String aid;
	/**类别编号*/
	private int tid;
	/**标题*/
	private String title;
	/**作者*/
	private String author;
	/**文章内容*/
	private String content;
	/**浏览次数*/
	private int scantime;
	/**发表时间*/
	private String time;
	/**评论次数*/
	private int comments;
	
	public ArticleBean(String aid, int tid, String title, String author,
			String content, int scantime, String time, int comments) {
		super();
		this.aid = aid;
		this.tid = tid;
		this.title = title;
		this.author = author;
		this.content = content;
		this.scantime = scantime;
		this.time = time;
		this.comments = comments;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public ArticleBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ArticleBean(String aid, int tid, String title, String author,
			String content, int scantime, String time) {
		super();
		this.aid = aid;
		this.tid = tid;
		this.title = title;
		this.author = author;
		this.content = content;
		this.scantime = scantime;
		this.time = time;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getScantime() {
		return scantime;
	}
	public void setScantime(int scantime) {
		this.scantime = scantime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
	
	
	
}
