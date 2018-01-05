package cn.arice.com.service.impl;

import java.util.List;

import cn.arice.com.bean.LeaveMsgBean;
import cn.arice.com.bean.PageBean;
import cn.arice.com.dao.LeaveMsgDao;
import cn.arice.com.dao.impl.LeaveMsgDaoImpl;
import cn.arice.com.service.LeaveMsgService;
import cn.arice.com.util.DateHelper;
import cn.arice.com.util.Random100;
import cn.arice.com.util.SensitiveWord;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.service.impl:LeaveMsgServiceImpl.java 对获取留言接口层实现
 * @version 1.0
 * @data 2016-5-25
 */
public class LeaveMsgServiceImpl implements LeaveMsgService {
	private LeaveMsgDao dao = new LeaveMsgDaoImpl();
	public List<LeaveMsgBean> getAllLeaveMsg() {
		return dao.getAllLeaveMsg();
	}

	public LeaveMsgBean getLeaveMsgById(String lmid) {
		return dao.getLeaveMsgById(lmid);
	}

	public int setLeaveMsgIsLookById(String lmid, int islook) {
		return dao.setLeaveMsgIsLookById(lmid, islook);
	}

	public int deleteLeaveMsgById(String lmid) {
		return dao.deleteLeaveMsgById(lmid);
	}

	public int addLeaveMsg(LeaveMsgBean lmsg) {
		LeaveMsgBean lmsgs = lmsg;
		lmsgs.setLmid(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		lmsgs.setLmtime(DateHelper.getDateTimeFormat());
		lmsgs.setLmcontent(SensitiveWord.filteSensitiveWord(lmsg.getLmcontent()));
		return dao.addLeaveMsg(lmsgs);
	}

	public int getNotLookLMCount() {
		return dao.getNotLookLMCount();
	}

	public int getLMCount() {
		return dao.getLMCount();
	}

	public List<LeaveMsgBean> getLeaveMsgByPage(int firstIndex, int pageSize) {
		return dao.getLeaveMsgByPage(firstIndex, pageSize);
	}

	public PageBean<LeaveMsgBean> getByPage(PageBean<LeaveMsgBean> page) {

		int totalCount = dao.getLMCount();//数据获取总记录数
		
		page.setTotalCount(totalCount);//分页对象  设值 总记录数
		/********************防止  页码  越界**************************/		
		if(page.getCurrentPage() <= 0){  //当前页小于等0
			page.setCurrentPage(1);//分页对象  设值  当前页
		}
		if(page.getCurrentPage() > page.getTotalPage()){ //当前页大于总页数
			page.setCurrentPage(page.getTotalPage());   //分页对象  设值  当前页
		}
		
		//开始条数
		int firstIndex = page.getFirstIndex();
		int pageSize = page.getMaxResult();
		//数据库分页记录
		List<LeaveMsgBean> list = null ;	
		
		list = dao.getLeaveMsgByPage(firstIndex, pageSize);
		
		
		page.setDataList(list);//分页对象  设值  分页数据
		
		return page;
	}

	

}
