package cn.arice.com.bean;

public class VisitBean {
	/**访问的id*/
	private String visitid;
	/**访问的ip*/
	private String visitip;
	/**ip对应的真实地址*/
	private String visitaddr;
	/**访问的时间*/
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
