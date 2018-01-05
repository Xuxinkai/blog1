package cn.arice.com.bean;
/**
 * 
 * @author Arice ���¿�
 * @description AlbumBean �����Ϣ��
 * @data 2016-4-3
 */
public class AlbumBean {
	/**�����*/
	private int alid;
	/**�������*/
	private String alname;
	/**�������*/
	private String aldesc;
	/**������Ƭ��*/
	private int imgnum;
	
	
	
	
	public AlbumBean(int alid, String alname, String aldesc, int imgnum) {
		super();
		this.alid = alid;
		this.alname = alname;
		this.aldesc = aldesc;
		this.imgnum = imgnum;
	}
	public AlbumBean( String alname, String aldesc) {
		super();
		this.alname = alname;
		this.aldesc = aldesc;
	}




	public int getImgnum() {
		return imgnum;
	}




	public void setImgnum(int imgnum) {
		this.imgnum = imgnum;
	}




	public AlbumBean(int alid, String alname, String aldesc) {
		super();
		this.alid = alid;
		this.alname = alname;
		this.aldesc = aldesc;
	}




	public AlbumBean() {
		super();
	}




	public int getAlid() {
		return alid;
	}




	public void setAlid(int alid) {
		this.alid = alid;
	}




	public String getAlname() {
		return alname;
	}




	public void setAlname(String alname) {
		this.alname = alname;
	}




	public String getAldesc() {
		return aldesc;
	}




	public void setAldesc(String aldesc) {
		this.aldesc = aldesc;
	}
	
}
