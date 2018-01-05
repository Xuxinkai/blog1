package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.ImgBean;

public interface ImgService {
	/**获得所有的图片*/
	public List<ImgBean> getAllImg();
	/**根据imgid获取图片信息*/
	public ImgBean getImgByImgid(String imgid);
	/**根据alid获取图片*/
	public List<ImgBean> getImgsByAlid(int alid);
	/**修改图片所在的相册  修改alid*/
	public int updateAlidByImgid(int alid,String imgid);
	/**根据imgid修改图片信息*/
	public int updateImgByImgid(ImgBean img);
	/**根据imgid删除照片*/
	public int delImgByImgid(String imgid);
	/**添加一张照片*/
	public int addImg(ImgBean img);
}
