package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.ArticelTypeBean;

/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.dao:ArticelTypeDao.java
 * @version 1.0
 * @data 2016-5-25
 */
public interface ArticelTypeDao {
	/**��ȡ�����������*/
	public List<ArticelTypeBean> getAllArticelType();
	/**����id��ȡ���������Ϣ*/
	public ArticelTypeBean getArticelType(int tid);
	/**����������*/
	public int addArticelType(ArticelTypeBean atb);
	/**ɾ���������  �����������id*/
	public int deleteArticelTypeById(int tid);
	/**�������������Ϣ �����������id*/
	public int updataArticelTypeById(ArticelTypeBean atb);
	/**��ȡ�����������*/
	public int countArticelType();

}
