package cn.arice.com.service;

import java.util.List;


import cn.arice.com.bean.LeaveMsgBean;
import cn.arice.com.bean.PageBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.service:LeaveMsgService.java ��ȡ���Խӿڲ�ӿ�
 * @version 1.0
 * @data 2016-5-25
 */
public interface LeaveMsgService {
	/**��ѯ���е�������Ϣ*/
	public List<LeaveMsgBean> getAllLeaveMsg();
	/**�����Ա�Ų�ѯ������Ϣ*/
	public LeaveMsgBean getLeaveMsgById(String lmid);
	/**�����Ա�����������Ѳ鿴*/
	public int setLeaveMsgIsLookById(String lmid,int islook);
	/**�����Ա��ɾ������*/
	public int deleteLeaveMsgById(String lmid);
	/**�������*/
	public int addLeaveMsg(LeaveMsgBean lmsg);
	/**��ȡû���Ķ���������*/
	public int getNotLookLMCount();
	/**�����������*/
	public int getLMCount();
	/**���ݷ�ҳ��ʾ*/
	public List<LeaveMsgBean> getLeaveMsgByPage(int firstIndex,int pageSize);
	/**
	 * ͨ�õķ�ҳ����
	 */
	public PageBean<LeaveMsgBean> getByPage(PageBean<LeaveMsgBean> page);
}
