package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.VisitBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.service:VisitService.java
 * @version 1.0
 * @data 2016-5-28
 */
public interface VisitService {
	/**获取所有的访问*/
	public List<VisitBean> getAllVisit();
	/**添加一个访问*/
	public int addVisit(VisitBean vb);

}
