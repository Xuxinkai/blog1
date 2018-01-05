package cn.arice.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.arice.com.bean.AlbumBean;
import cn.arice.com.dao.AlbumDao;
import cn.arice.com.util.JdbcSourceUtil;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.dao.impl:AlbumDaoImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class AlbumDaoImpl implements AlbumDao {

	

	public int addAlbum(AlbumBean album) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into album(alname,aldesc) values(?,?)";
		Object[] obj = new Object[]{album.getAlname(),album.getAldesc()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateAlbumByAlid(AlbumBean album) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update album set alname=? ,aldesc = ? where alid = ?;";
		Object[] obj = new Object[]{album.getAlname(),album.getAldesc(),album.getAlid()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public AlbumBean getAlbumByAlid(int alid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select a.* ,count(i.alid) as imgnum from album a left join img i on a.alid = i.alid where a.alid = "+alid+" GROUP BY a.alid ;";
		AlbumBean album = null;
		try {
			album = runner.insert(sql, new BeanHandler<AlbumBean>(AlbumBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return album;
	}

	public int deleteAlbumByAlid(int alid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from album where alid = ?";
		Object[] obj = new Object[]{alid};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<AlbumBean> getAllAlbum() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select a.* ,count(i.alid) as imgnum from album a left join img i on a.alid = i.alid GROUP BY a.alid ";
		List<AlbumBean> listalbum = null;
		try {
			listalbum = runner.query(sql, new BeanListHandler<AlbumBean>(AlbumBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listalbum;
	}

}
