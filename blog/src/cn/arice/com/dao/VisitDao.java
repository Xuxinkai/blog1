package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.VisitBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.dao:VisitDao.java
 * @version 1.0
 * @data 2016-6-1
 */
public interface VisitDao {
	/**��ȡ���еķ���*/
	public List<VisitBean> getAllVisit();
	/**���һ������*/
	public int addVisit(VisitBean vb);

}
