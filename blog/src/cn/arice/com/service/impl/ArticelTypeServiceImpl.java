package cn.arice.com.service.impl;

import java.util.List;

import cn.arice.com.bean.ArticelTypeBean;
import cn.arice.com.dao.ArticelTypeDao;
import cn.arice.com.dao.impl.ArticelTypeDaoImpl;
import cn.arice.com.service.ArticelTypeService;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.service.impl:ArticelTypeServiceImpl.java
 * @version 1.0
 * @data 2016-5-25
 */
public class ArticelTypeServiceImpl implements ArticelTypeService {
	ArticelTypeDao dao = new ArticelTypeDaoImpl();
	public List<ArticelTypeBean> getAllArticelType() {
		return dao.getAllArticelType();
	}

	public ArticelTypeBean getArticelType(int tid) {
		return dao.getArticelType(tid);
	}

	public int addArticelType(ArticelTypeBean atb) {
		return dao.addArticelType(atb);
	}

	public int deleteArticelTypeById(int tid) {
		if(tid != 0){
			return dao.deleteArticelTypeById(tid);
		}else{
			return 0;
		}
		
	}

	public int updataArticelTypeById(ArticelTypeBean atb) {
		return dao.updataArticelTypeById(atb);
	}

	public int countArticelType() {
		return dao.countArticelType();
	}

}
