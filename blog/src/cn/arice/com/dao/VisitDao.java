package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.VisitBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.dao:VisitDao.java
 * @version 1.0
 * @data 2016-6-1
 */
public interface VisitDao {
	/**获取所有的访问*/
	public List<VisitBean> getAllVisit();
	/**添加一个访问*/
	public int addVisit(VisitBean vb);

}
