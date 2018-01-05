package cn.arice.com.service;

import java.util.List;


import cn.arice.com.bean.LeaveMsgBean;
import cn.arice.com.bean.PageBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.service:LeaveMsgService.java 获取留言接口层接口
 * @version 1.0
 * @data 2016-5-25
 */
public interface LeaveMsgService {
	/**查询所有的留言信息*/
	public List<LeaveMsgBean> getAllLeaveMsg();
	/**按留言编号查询留言信息*/
	public LeaveMsgBean getLeaveMsgById(String lmid);
	/**按留言编号设置留言已查看*/
	public int setLeaveMsgIsLookById(String lmid,int islook);
	/**按留言编号删除留言*/
	public int deleteLeaveMsgById(String lmid);
	/**添加留言*/
	public int addLeaveMsg(LeaveMsgBean lmsg);
	/**获取没有阅读的留言数*/
	public int getNotLookLMCount();
	/**获得留言总数*/
	public int getLMCount();
	/**数据分页显示*/
	public List<LeaveMsgBean> getLeaveMsgByPage(int firstIndex,int pageSize);
	/**
	 * 通用的分页数据
	 */
	public PageBean<LeaveMsgBean> getByPage(PageBean<LeaveMsgBean> page);
}
