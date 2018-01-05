package cn.arice.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.dao.ArticelDao;
import cn.arice.com.util.JdbcSourceUtil;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.dao.impl:ArticleDaoImpl.java
 * @version 1.0
 * @data 2016-5-27
 */
public class ArticleDaoImpl implements ArticelDao {

	public List<ArticleBean> getAllArticle() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select art.* ,count(artc.cid) comments from articel art left join articlecomment artc " +
				"on art.aid = artc.aid group by art.aid ORDER BY art.aid desc ;";
		List<ArticleBean> abs = null;
		try {
			abs = runner.query(sql, new BeanListHandler<ArticleBean>(ArticleBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abs;
	}

	public List<ArticleBean> getArticleByTid(int tid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select art.* ,count(artc.cid) comments from articel art left join articlecomment artc " +
				"on art.aid = artc.aid where art.tid= "+tid+" group by art.aid ORDER BY art.aid desc ";
		List<ArticleBean> abs = null;
		try {
			abs = runner.query(sql, new BeanListHandler<ArticleBean>(ArticleBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abs;
	}

	public List<ArticleBean> getArticleByTime(String time) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from articel where LEFT(time,10) = '"+time+"' order by aid desc;";
		List<ArticleBean> abs = null;
		try {
			abs = runner.query(sql, new BeanListHandler<ArticleBean>(ArticleBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abs;
	}

	public ArticleBean getArticleById(String aid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select art.* ,count(artc.cid) comments from articel art left join articlecomment artc " +
				"on art.aid = artc.aid where art.aid ='"+aid+"'  group by art.aid;";
		ArticleBean ab = null;
		try {
			ab = runner.query(sql, new BeanHandler<ArticleBean>(ArticleBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ab;
	}

	public int deleteArticleById(String aid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from articel where aid = "+aid;
		int count = 0 ;
		try {
			count = runner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int addArticle(ArticleBean ab) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into articel values(?,?,?,?,?,?,?)";
		Object[] obj = new Object[]{ab.getAid(),ab.getTid(),ab.getTitle(),ab.getAuthor(),ab.getContent(),ab.getScantime(),ab.getTime()};
		int count = 0 ;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updataArticle(ArticleBean ab) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update articel set tid=?,title=?,author=?,content=?,time=? where aid=?";
		Object[] obj = new Object[]{ab.getTid(),ab.getTitle(),ab.getAuthor(),ab.getContent(),ab.getTime(),ab.getAid()};
		int count = 0 ;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updataArticleScantimeByAid(String aid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update articel set scantime=? where aid=?";
		int scantime = getArticleById(aid).getScantime()+1;
		Object[] obj = new Object[]{scantime,aid};
		int count = 0 ;
		try {
			count = runner.update(sql, obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int countArticle() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select count(*) from articel";
		Object[] count =null;
		try {
			count = runner.query(sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(count[0].toString());
	}

	public List<ArticleBean> getArticelFive() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from (select * from articel ORDER BY aid desc ) as a LIMIT 0,5;";
		List<ArticleBean> abs = null;
		try {
			abs = runner.query(sql, new BeanListHandler<ArticleBean>(ArticleBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return abs;
	}

}
