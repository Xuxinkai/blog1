package cn.arice.com.service.impl;

import cn.arice.com.bean.UserInfoBean;
import cn.arice.com.dao.impl.UserInfoDaoImpl;
import cn.arice.com.service.UserInfoService;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.service.impl:UserInfoServiceImpl.java
 * @version 1.0
 * @data 2016-5-27
 */
public class UserInfoServiceImpl implements UserInfoService {
	UserInfoDaoImpl userDao = new UserInfoDaoImpl();

	public UserInfoBean getUserInfoById(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUserInfoById(userId);
	}

	public int updatePwdById(String userId, String newPwd) {
		// TODO Auto-generated method stub
		return userDao.updatePwdById(userId, newPwd);
	}

	public boolean login(String loginname, String password) {
		// TODO Auto-generated method stub
		return userDao.login(loginname, password);
	}

	public String getIdByName(String loginname) {
		// TODO Auto-generated method stub
		return userDao.getIdByName(loginname);
	}

	public UserInfoBean getUserInfo() {
		// TODO Auto-generated method stub
		return userDao.getUserInfo();
	}

	public int updateLoginTime(String userId, String time) {
		// TODO Auto-generated method stub
		return userDao.updateLoginTime(userId, time);
	}

	public int updateUserInfoById(UserInfoBean user) {
		// TODO Auto-generated method stub
		return userDao.updateUserInfoById(user);
	}

}
