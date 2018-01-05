package cn.arice.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.arice.com.bean.ArticelTypeBean;
import cn.arice.com.dao.ArticelTypeDao;
import cn.arice.com.util.JdbcSourceUtil;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.dao.impl:ArticelTypeDaoImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class ArticelTypeDaoImpl implements ArticelTypeDao {

	public List<ArticelTypeBean> getAllArticelType() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select aty.* ,count(a.tid) as anum from articeltype aty left JOIN articel a on aty.tid = a.tid GROUP BY aty.tid;";
		List<ArticelTypeBean> atbs = null;
		try {
			atbs = runner.query(sql, new BeanListHandler<ArticelTypeBean>(ArticelTypeBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atbs;
	}
	public ArticelTypeBean getArticelType(int tid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from articeltype where tid =?";
		Object[] obj = new Object[]{tid};
		ArticelTypeBean atb = null;
		try {
			atb = runner.query(sql, new BeanHandler<ArticelTypeBean>(ArticelTypeBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atb;
	}

	public int addArticelType(ArticelTypeBean atb) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into articeltype(tname,tdesc) values(?,?)";
		Object[] obj = new Object[]{atb.getTname(),atb.getTdesc()};
		int count = 0;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteArticelTypeById(int tid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from articeltype where tid =?";
		Object[] obj = new Object[]{tid};
		int count = 0;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updataArticelTypeById(ArticelTypeBean atb) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update articeltype set tname = ? ,tdesc=? where tid = ?";
		Object[] obj = new Object[]{atb.getTname(),atb.getTdesc(),atb.getTid()};
		int count = 0;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int countArticelType() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*) from articeltype";
		Object[] count = null;
		try {
			count = runner.query(sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(count[0].toString());
	}

	

}
