package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.ArticelTypeBean;

/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.dao:ArticelTypeDao.java
 * @version 1.0
 * @data 2016-5-25
 */
public interface ArticelTypeDao {
	/**获取所有文章类别*/
	public List<ArticelTypeBean> getAllArticelType();
	/**根据id获取文章类别信息*/
	public ArticelTypeBean getArticelType(int tid);
	/**添加文章类别*/
	public int addArticelType(ArticelTypeBean atb);
	/**删除文章类别  根据文章类别id*/
	public int deleteArticelTypeById(int tid);
	/**更新文章类别信息 根据文章类别id*/
	public int updataArticelTypeById(ArticelTypeBean atb);
	/**获取文章类别数量*/
	public int countArticelType();

}
