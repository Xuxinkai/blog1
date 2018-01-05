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
 * @author Arice ���¿�
 * @description blog:cn.arice.com.service.impl:LeaveMsgServiceImpl.java �Ի�ȡ���Խӿڲ�ʵ��
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

		int totalCount = dao.getLMCount();//���ݻ�ȡ�ܼ�¼��
		
		page.setTotalCount(totalCount);//��ҳ����  ��ֵ �ܼ�¼��
		/********************��ֹ  ҳ��  Խ��**************************/		
		if(page.getCurrentPage() <= 0){  //��ǰҳС�ڵ�0
			page.setCurrentPage(1);//��ҳ����  ��ֵ  ��ǰҳ
		}
		if(page.getCurrentPage() > page.getTotalPage()){ //��ǰҳ������ҳ��
			page.setCurrentPage(page.getTotalPage());   //��ҳ����  ��ֵ  ��ǰҳ
		}
		
		//��ʼ����
		int firstIndex = page.getFirstIndex();
		int pageSize = page.getMaxResult();
		//���ݿ��ҳ��¼
		List<LeaveMsgBean> list = null ;	
		
		list = dao.getLeaveMsgByPage(firstIndex, pageSize);
		
		
		page.setDataList(list);//��ҳ����  ��ֵ  ��ҳ����
		
		return page;
	}

	

}
