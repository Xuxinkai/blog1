package cn.arice.com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.arice.com.bean.VisitBean;
import cn.arice.com.dao.VisitDao;
import cn.arice.com.util.JdbcSourceUtil;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.dao.impl:VisitDaoImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class VisitDaoImpl implements VisitDao {

	public List<VisitBean> getAllVisit() {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "select * from visit order by visitid desc;";
		List<VisitBean> listvi = null;
		try {
			listvi = runner.query(sql, new BeanListHandler<VisitBean>(VisitBean.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listvi;
	}

	public int addVisit(VisitBean vb) {
		QueryRunner runner = JdbcSourceUtil.getQueryRunner();
		String sql = "insert into visit values(?,?,?,?)";
		Object[] obj = new Object[]{vb.getVisitid(),vb.getVisitip(),vb.getVisitaddr(),vb.getVisittime()};
		int count = 0;
		try {
			count = runner.update(sql,obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
