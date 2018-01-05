package cn.arice.com.service.impl;

import java.util.List;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.dao.ImgDao;
import cn.arice.com.dao.impl.ImgDaoImpl;
import cn.arice.com.service.ImgService;
import cn.arice.com.util.DateHelper;
import cn.arice.com.util.Random100;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.service.impl:ImgServiceImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class ImgServiceImpl implements ImgService {
	private ImgDao dao= new ImgDaoImpl();
	public List<ImgBean> getAllImg() {
		return dao.getAllImg();
	}

	public ImgBean getImgByImgid(String imgid) {
		return dao.getImgByImgid(imgid);
	}

	public List<ImgBean> getImgsByAlid(int alid) {
		return dao.getImgsByAlid(alid);
	}

	public int updateAlidByImgid(int alid, String imgid) {
		return dao.updateAlidByImgid(alid, imgid);
	}

	public int updateImgByImgid(ImgBean img) {
		return dao.updateImgByImgid(img);
	}

	public int delImgByImgid(String imgid) {
		return dao.delImgByImgid(imgid);
	}

	public int addImg(ImgBean img) {
		ImgBean oimg = img;
		oimg.setImgid(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		oimg.setUptime(DateHelper.getDateTimeFormat());
		return dao.addImg(oimg);
	}

}
