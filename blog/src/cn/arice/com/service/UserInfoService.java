package cn.arice.com.service;

import cn.arice.com.bean.UserInfoBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.service:UserInfoService.java
 * @version 1.0
 * @data 2016-5-28
 */
public interface UserInfoService {

	/**根据用户Id获取用户所有的信息*/
	public UserInfoBean getUserInfoById(String userId);
	/**获取用户所有的信息*/
	public UserInfoBean getUserInfo();
	/**修改用户密码*/
	public int updatePwdById(String userId,String newPwd);
	/**用户登录*/
	public boolean login(String loginname, String password);
	/**根据用户名获得userid*/
	public String getIdByName(String loginname);
	/**更新用户登录时间*/
	public int updateLoginTime(String userId,String time);
	/**修改用户信息(除开密码)*/
	public int updateUserInfoById(UserInfoBean user);

}
