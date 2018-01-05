package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.ImgBean;

public interface ImgService {
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
