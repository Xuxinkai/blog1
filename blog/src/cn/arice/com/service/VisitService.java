package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.VisitBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.service:VisitService.java
 * @version 1.0
 * @data 2016-5-28
 */
public interface VisitService {
	/**��ȡ���еķ���*/
	public List<VisitBean> getAllVisit();
	/**���һ������*/
	public int addVisit(VisitBean vb);

}
