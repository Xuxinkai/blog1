package cn.arice.com.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.arice.com.bean.LeaveMsgBean;
import cn.arice.com.dao.LeaveMsgDao;
import cn.arice.com.util.JdbcSourceUtil;

/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.dao.impl:LeaveMsgDaoImpl.java 留言dao接口实现
 * @version 1.0
 * @data 2016-5-24
 */
public class LeaveMsgDaoImpl implements LeaveMsgDao {

	public List<LeaveMsgBean> getAllLeaveMsg() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from leavemsg order by lmid desc";
		List<LeaveMsgBean> list =null;
		try {
			list = runner.query(sql, new BeanListHandler<LeaveMsgBean>(LeaveMsgBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public LeaveMsgBean getLeaveMsgById(String lmid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from leavemsg where lmid =?";
		Object[] obj = new Object[]{lmid};
		LeaveMsgBean lm = null;
		try {
			lm = runner.query(sql,new BeanHandler<LeaveMsgBean>(LeaveMsgBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lm;
	}

	public int setLeaveMsgIsLookById(String lmid,int islook) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update leavemsg set islook = ? where lmid = ?";
		Object[] obj = new Object[]{islook,lmid};
		int count = 0;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteLeaveMsgById(String lmid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from leavemsg where lmid = ?";
		Object[] obj = new Object[]{lmid};
		int count = 0;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int addLeaveMsg(LeaveMsgBean lmsg) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into leavemsg values(?,?,?,?,?,?,?)";
		Object[] obj = new Object[]{lmsg.getLmid(),lmsg.getLmname(),lmsg.getLmemail(),lmsg.getLmcontent(),lmsg.getLmtime(),lmsg.getLmip(),lmsg.getIslook()};
		int count = 0;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	

	public int getNotLookLMCount() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql="select count(*) from leavemsg where islook = 0";
		int count = 0;
		try {
			Object[] obj= runner.query(sql, new ArrayHandler());
			count = Integer.parseInt(obj[0].toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getLMCount() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql="select count(*) from leavemsg";
		int count = 0;
		try {
			Object[] obj= runner.query(sql, new ArrayHandler());
			count = Integer.parseInt(obj[0].toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<LeaveMsgBean> getLeaveMsgByPage(int firstIndex, int pageSize) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select  o.* from (select * from leavemsg order by lmid desc) o limit "+firstIndex+","+pageSize+" ;";
		List<LeaveMsgBean> list =null;
		try {
			list = runner.query(sql, new BeanListHandler<LeaveMsgBean>(LeaveMsgBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
