package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.ImgBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.dao:ImgDao.java
 * @version 1.0
 * @data 2016-5-30
 */
public interface ImgDao {
	/**������е�ͼƬ*/
	public List<ImgBean> getAllImg();
	/**����imgid��ȡͼƬ��Ϣ*/
	public ImgBean getImgByImgid(String imgid);
	/**����alid��ȡͼƬ*/
	public List<ImgBean> getImgsByAlid(int alid);
	/**�޸�ͼƬ���ڵ����  �޸�alid*/
	public int updateAlidByImgid(int alid,String imgid);
	/**����imgid�޸�ͼƬ��Ϣ*/
	public int updateImgByImgid(ImgBean img);
	/**����imgidɾ����Ƭ*/
	public int delImgByImgid(String imgid);
	/**���һ����Ƭ*/
	public int addImg(ImgBean img);
}
