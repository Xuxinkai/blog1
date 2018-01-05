package cn.arice.com.bean;
/**
 * 
 * @author Arice 徐新凯
 * @description LeaveMsgBean 游客留言信息表
 * @data 2016-4-3
 */
public class LeaveMsgBean {
	/**留言编号 (20160506152335-年月日时分秒)*/
	private String lmid;
	/**留言人*/
	private String lmname;
	/**l留言人邮箱*/
	private String lmemail;
	/**留言内容*/
	private String lmcontent;
	/**留言时间*/
	private String lmtime;
	/**留言IP*/
	private String lmip;
	/**是否已经查看*/
	private int islook;
	
	
	public int getIslook() {
		return islook;
	}
	public void setIslook(int islook) {
		this.islook = islook;
	}
	
	
	
	public LeaveMsgBean() {
		super();
	}
	public LeaveMsgBean(String lmid, String lmname, String lmemail,String lmcontent,
			String lmtime, String lmip,int islook) {
		super();
		this.lmid = lmid;
		this.lmname = lmname;
		this.lmemail = lmemail;
		this.lmcontent = lmcontent;
		this.lmtime = lmtime;
		this.lmip = lmip;
		this.islook = islook;
	}
	public String getLmemail() {
		return lmemail;
	}
	public void setLmemail(String lmemail) {
		this.lmemail = lmemail;
	}
	public String getLmid() {
		return lmid;
	}
	public void setLmid(String lmid) {
		this.lmid = lmid;
	}
	public String getLmname() {
		return lmname;
	}
	public void setLmname(String lmname) {
		this.lmname = lmname;
	}
	public String getLmcontent() {
		return lmcontent;
	}
	public void setLmcontent(String lmcontent) {
		this.lmcontent = lmcontent;
	}
	public String getLmtime() {
		return lmtime;
	}
	public void setLmtime(String lmtime) {
		this.lmtime = lmtime;
	}
	public String getLmip() {
		return lmip;
	}
	public void setLmip(String lmip) {
		this.lmip = lmip;
	}
	
	
}
