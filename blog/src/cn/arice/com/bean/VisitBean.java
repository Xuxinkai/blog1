package cn.arice.com.bean;

public class VisitBean {
	/**���ʵ�id*/
	private String visitid;
	/**���ʵ�ip*/
	private String visitip;
	/**ip��Ӧ����ʵ��ַ*/
	private String visitaddr;
	/**���ʵ�ʱ��*/
	private String visittime;
	
	public VisitBean(String visitid, String visitip, String visitaddr,
			String visittime) {
		super();
		this.visitid = visitid;
		this.visitip = visitip;
		this.visitaddr = visitaddr;
		this.visittime = visittime;
	}

	public String getVisitaddr() {
		return visitaddr;
	}

	public void setVisitaddr(String visitaddr) {
		this.visitaddr = visitaddr;
	}

	public VisitBean() {
	}
	
	public VisitBean(String visitid, String visitip, String visittime) {
		super();
		this.visitid = visitid;
		this.visitip = visitip;
		this.visittime = visittime;
	}
	public String getVisitid() {
		return visitid;
	}
	public void setVisitid(String visitid) {
		this.visitid = visitid;
	}
	public String getVisitip() {
		return visitip;
	}
	public void setVisitip(String visitip) {
		this.visitip = visitip;
	}
	public String getVisittime() {
		return visittime;
	}
	public void setVisittime(String visittime) {
		this.visittime = visittime;
	}
	
	
	

}
