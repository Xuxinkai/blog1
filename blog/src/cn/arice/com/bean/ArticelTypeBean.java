package cn.arice.com.bean;
/**
 * 
 * @author Arice ���¿�
 * @description ArticelTypeBean ��������
 * @data 2016-4-3
 */
public class ArticelTypeBean {
	/**���������*/
	private int tid;
	/**�������*/
	private String tname;
	/**�������*/
	private String tdesc;
	
	/**����µ�������  ����ʡ��*/
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
