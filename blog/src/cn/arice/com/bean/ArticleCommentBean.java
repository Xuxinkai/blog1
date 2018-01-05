package cn.arice.com.bean;
/**
 * 
 * @author Arice 徐新凯
 * @description ArticleCommentBean 文章评论表
 * @data 2016-4-3
 */
public class ArticleCommentBean {
	/**评论编号(20160506152335-年月日时分秒)*/
	private String cid;
	/**文章编号*/
	private String aid;
	/**评论人*/
	private String cuser;
	/**评论内容*/
	private String content;
	/**评论时间*/
	private String ctime;
	/**评论的ip*/
	private String cip;
	/**是否已经查看*/
	private int islook;
	
	public ArticleCommentBean() {
	}
	public ArticleCommentBean(String cid, String aid, String cuser,
			String content, String ctime, String cip, int islook) {
		super();
		this.cid = cid;
		this.aid = aid;
		this.cuser = cuser;
		this.content = content;
		this.ctime = ctime;
		this.cip = cip;
		this.islook = islook;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getCuser() {
		return cuser;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public int getIslook() {
		return islook;
	}
	public void setIslook(int islook) {
		this.islook = islook;
	}
	
	
	
	
	
}
