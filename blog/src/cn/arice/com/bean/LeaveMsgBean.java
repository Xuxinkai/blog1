package cn.arice.com.bean;
/**
 * 
 * @author Arice ���¿�
 * @description LeaveMsgBean �ο�������Ϣ��
 * @data 2016-4-3
 */
public class LeaveMsgBean {
	/**���Ա�� (20160506152335-������ʱ����)*/
	private String lmid;
	/**������*/
	private String lmname;
	/**l����������*/
	private String lmemail;
	/**��������*/
	private String lmcontent;
	/**����ʱ��*/
	private String lmtime;
	/**����IP*/
	private String lmip;
	/**�Ƿ��Ѿ��鿴*/
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
