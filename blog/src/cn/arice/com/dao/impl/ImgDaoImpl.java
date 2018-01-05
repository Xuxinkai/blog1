package cn.arice.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.dao.ImgDao;
import cn.arice.com.util.JdbcSourceUtil;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.dao.impl:ImgDaoImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class ImgDaoImpl implements ImgDao {

	public List<ImgBean> getAllImg() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from img order by imgid desc;";
		List<ImgBean> listimg  = null;
		try {
			listimg = runner.query(sql, new BeanListHandler<ImgBean>(ImgBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listimg;
	}

	public ImgBean getImgByImgid(String imgid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from img where imgid = '"+imgid+"' ;";
		ImgBean img = null;
		try {
			img = runner.query(sql, new BeanHandler<ImgBean>(ImgBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return img;
	}

	public List<ImgBean> getImgsByAlid(int alid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from img where alid = "+alid+" order by imgid desc;";
		List<ImgBean> listimg  = null;
		try {
			listimg = runner.query(sql, new BeanListHandler<ImgBean>(ImgBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listimg;
	}

	public int updateAlidByImgid(int alid, String imgid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update img set alid = ? where imgid = ?";
		Object[] obj = new Object[]{alid,imgid};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateImgByImgid(ImgBean img) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "update img set  alid = ?,imgdesc = ? where imgid =?";
		Object[] obj = new Object[]{img.getAlid(),img.getImgdesc(),img.getImgid()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int delImgByImgid(String imgid) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "delete from img where imgid =?";
		Object[] obj = new Object[]{imgid};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int addImg(ImgBean img) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into img values(?,?,?,?,?,?,?)";
		Object[] obj = new Object[]{img.getImgid(),img.getAlid(),img.getImgname(),img.getImgurl(),img.getImgdesc(),img.getImginfo(),img.getUptime()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
