package cn.arice.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.arice.com.bean.ArticleCommentBean;
import cn.arice.com.dao.ArticelCommentDao;
import cn.arice.com.util.JdbcSourceUtil;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.dao.impl:ArticelCommetDaoImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class ArticelCommetDaoImpl implements ArticelCommentDao {

	public List<ArticleCommentBean> getAllComments() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from articlecomment order by cid desc;";
		List<ArticleCommentBean> acbs = null;
		try {
			acbs = runner.query(sql, new BeanListHandler<ArticleCommentBean>(ArticleCommentBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acbs;
	}

	public List<ArticleCommentBean> getCommentsByAid(String aid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from articlecomment where aid = ? order by cid desc;";
		List<ArticleCommentBean> acbs = null;
		Object[] obj = new Object[]{aid};
		try {
			acbs = runner.query(sql, new BeanListHandler<ArticleCommentBean>(ArticleCommentBean.class),obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acbs;
	}

	public int deleteCommentByCid(String cid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from articlecomment where cid = "+cid+";";
		int count = 0;
		try {
			count = runner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int deleteCommentsByAid(String aid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from articlecomment where aid = "+aid+";";
		int count = 0;
		try {
			count = runner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int addCommentByAid(ArticleCommentBean acb) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into articlecomment values(?,?,?,?,?,?,?)";
		Object[] obj = new Object[]{acb.getCid(),acb.getAid(),acb.getCuser(),acb.getContent(),acb.getCtime(),acb.getCip(),acb.getIslook()};
		int count = 0;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public int updateIsLookByCid(String cid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update articlecomment set islook = 1 where cid = "+cid+";";
		int count = 0;
		try {
			count = runner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getUnlookCountByAid(String aid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*) from articlecomment where aid = '"+aid+"' and islook=0";
		Object[] count = null;
		try {
			count = runner.query(sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(count[0].toString());
	}

	public int getUnlookCount() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*) from articlecomment where islook=0";
		Object[] count = null;
		try {
			count = runner.query(sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(count[0].toString());
	}

}
