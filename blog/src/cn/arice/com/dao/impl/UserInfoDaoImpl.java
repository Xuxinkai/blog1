package cn.arice.com.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.arice.com.bean.UserInfoBean;
import cn.arice.com.dao.UserInfoDao;
import cn.arice.com.util.JdbcSourceUtil;

/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.dao.impl:UserInfoDaoImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class UserInfoDaoImpl implements UserInfoDao {

	public UserInfoBean getUserInfoById(String userId) {
		UserInfoBean user = null;
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userinfo where userid='"+userId+"'";
		try {
			user = runner.query(sql,new BeanHandler<UserInfoBean>(UserInfoBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public UserInfoBean getUserInfo() {
		UserInfoBean user = null;
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userinfo";
		try {
			user = runner.query(sql, new BeanHandler<UserInfoBean>(UserInfoBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public int updatePwdById(String userId, String newPwd) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update userinfo set password=? where userid=?";
		Object[] objs = new Object[]{newPwd,userId};
		int count = 0;
		try {
			count = runner.update(sql, objs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean login(String loginname, String password) {
		boolean fig = false;
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from userinfo where loginname =? and password=?";
		Object[] obj = new Object[]{loginname,password};
		UserInfoBean user = null;
		try {
			user = runner.query(sql, new BeanHandler<UserInfoBean>(UserInfoBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user!=null){
			fig = true;
		}
		return fig;
	}

	public String getIdByName(String loginname) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql ="select userid from userinfo where loginname = '"+loginname+"'";
		
		Object[] obj=null;
		try {
			obj = runner.query(sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj[0].toString();
	}

	


	public int updateUserInfoById(UserInfoBean user) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update userinfo set loginname=?,realname=?,sex=?,birthday=?," +
				"email=?,telnumber=?,birthplace=?,liveplace=?,introduce=? where userid=?";
		Object[] objs = new Object[]{user.getLoginname(),user.getRealname(),user.getSex(),user.getBirthday(),
										user.getEmail(),user.getTelnumber(),user.getBirthplace(),user.getLiveplace(),user.getIntroduce(),user.getUserid()};
		int count = 0;
		try {
			count = runner.update(sql, objs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateLoginTime(String userId, String time) {
		// TODO Auto-generated method stub
		return 0;
	}


}
