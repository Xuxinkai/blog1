package cn.arice.com.bean;
/**
 * 
 * @author Arice ���¿�
 * @description ArticleCommentBean �������۱�
 * @data 2016-4-3
 */
public class ArticleCommentBean {
	/**���۱��(20160506152335-������ʱ����)*/
	private String cid;
	/**���±��*/
	private String aid;
	/**������*/
	private String cuser;
	/**��������*/
	private String content;
	/**����ʱ��*/
	private String ctime;
	/**���۵�ip*/
	private String cip;
	/**�Ƿ��Ѿ��鿴*/
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
