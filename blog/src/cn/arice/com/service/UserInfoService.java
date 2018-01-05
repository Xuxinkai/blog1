package cn.arice.com.service;

import cn.arice.com.bean.UserInfoBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.service:UserInfoService.java
 * @version 1.0
 * @data 2016-5-28
 */
public interface UserInfoService {

	/**�����û�Id��ȡ�û����е���Ϣ*/
	public UserInfoBean getUserInfoById(String userId);
	/**��ȡ�û����е���Ϣ*/
	public UserInfoBean getUserInfo();
	/**�޸��û�����*/
	public int updatePwdById(String userId,String newPwd);
	/**�û���¼*/
	public boolean login(String loginname, String password);
	/**�����û������userid*/
	public String getIdByName(String loginname);
	/**�����û���¼ʱ��*/
	public int updateLoginTime(String userId,String time);
	/**�޸��û���Ϣ(��������)*/
	public int updateUserInfoById(UserInfoBean user);

}
