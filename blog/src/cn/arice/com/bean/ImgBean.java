package cn.arice.com.bean;
/**
 * 
 * @author Arice ���¿�
 * @description ImgBean ͼƬ��Ϣ��
 * @data 2016-4-3
 */
public class ImgBean {
	
	/**ͼƬ���(20160506152335-������ʱ����)*/
	private String imgid;
	/**�����*/
	private int alid;
	/**ͼƬ����*/
	private String imgname;
	/**ͼƬ��ַ*/
	private String imgurl;
	/**ͼƬ����*/
	private String imgdesc;
	/**ͼƬ��Ϣ ( ��*��|��С ) */
	private String imginfo;
	/**�ϴ�ʱ��*/
	private String uptime;
	
	
	
	
	public ImgBean() {
		super();
	}




	public ImgBean(String imgid, int alid, String imgname, String imgurl,
			String imgdesc, String imginfo, String uptime) {
		super();
		this.imgid = imgid;
		this.alid = alid;
		this.imgname = imgname;
		this.imgurl = imgurl;
		this.imgdesc = imgdesc;
		this.imginfo = imginfo;
		this.uptime = uptime;
	}




	public String getImgid() {
		return imgid;
	}




	public void setImgid(String imgid) {
		this.imgid = imgid;
	}




	public int getAlid() {
		return alid;
	}




	public void setAlid(int alid) {
		this.alid = alid;
	}




	public String getImgname() {
		return imgname;
	}




	public void setImgname(String imgname) {
		this.imgname = imgname;
	}




	public String getImgurl() {
		return imgurl;
	}




	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}




	public String getImgdesc() {
		return imgdesc;
	}




	public void setImgdesc(String imgdesc) {
		this.imgdesc = imgdesc;
	}




	public String getImginfo() {
		return imginfo;
	}




	public void setImginfo(String imginfo) {
		this.imginfo = imginfo;
	}




	public String getUptime() {
		return uptime;
	}




	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	
}
