package cn.arice.com.service.impl;

import java.util.List;

import cn.arice.com.bean.VisitBean;
import cn.arice.com.dao.VisitDao;
import cn.arice.com.dao.impl.VisitDaoImpl;
import cn.arice.com.service.VisitService;
import cn.arice.com.util.DateHelper;
import cn.arice.com.util.IPToAddr;
import cn.arice.com.util.Random100;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.service.impl:VisitServiceImpl.java
 * @version 1.0
 * @data 2016-5-27
 */
public class VisitServiceImpl implements VisitService {
	private VisitDao dao = new VisitDaoImpl();
	public List<VisitBean> getAllVisit() {
		return dao.getAllVisit();
	}

	public int addVisit(VisitBean vb) {
		VisitBean ovb = vb;
		ovb.setVisitid(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		ovb.setVisittime(DateHelper.getDateTimeFormat());
		ovb.setVisitaddr(IPToAddr.jiexiip(vb.getVisitip()));
		return dao.addVisit(vb);
	}

}
