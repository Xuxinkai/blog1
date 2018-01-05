package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.LeaveMsgBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.dao:LeaveMsgDao.java ����dao����ӿ�
 * @version 1.0
 * @data 2016-5-25
 */
public interface LeaveMsgDao {
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
}
