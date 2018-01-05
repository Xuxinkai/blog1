package cn.arice.com.bean;
/**
 * 
 * @author Arice 徐新凯
 * @description ImgBean 图片信息表
 * @data 2016-4-3
 */
public class ImgBean {
	
	/**图片编号(20160506152335-年月日时分秒)*/
	private String imgid;
	/**相册编号*/
	private int alid;
	/**图片名字*/
	private String imgname;
	/**图片地址*/
	private String imgurl;
	/**图片描述*/
	private String imgdesc;
	/**图片信息 ( 长*宽|大小 ) */
	private String imginfo;
	/**上传时间*/
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
