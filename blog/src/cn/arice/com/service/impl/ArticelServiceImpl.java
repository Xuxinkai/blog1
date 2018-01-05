package cn.arice.com.service.impl;

import java.util.List;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.dao.ArticelDao;
import cn.arice.com.dao.impl.ArticleDaoImpl;
import cn.arice.com.service.ArticelService;
import cn.arice.com.util.DateHelper;
import cn.arice.com.util.Random100;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.service.impl:ArticelServiceImpl.java
 * @version 1.0
 * @data 2016-5-25
 */
public class ArticelServiceImpl implements ArticelService {
	private ArticelDao dao = new ArticleDaoImpl();
	public List<ArticleBean> getAllArticle() {
		return dao.getAllArticle();
	}

	public List<ArticleBean> getArticleByTid(int tid) {
		List<ArticleBean> abs = dao.getAllArticle();
		boolean flag = false;
		for(ArticleBean ab:abs){
			if(ab.getTid() == tid){
				flag = true;
			}
		}
		if(flag == true){
			return dao.getArticleByTid(tid);
		}else{
			return dao.getArticleByTid(1);
		}
		
	}

	public List<ArticleBean> getArticleByTime(String time) {
		return dao.getArticleByTime(time);
	}

	public ArticleBean getArticleById(String aid) {
		return dao.getArticleById(aid);
	}

	public int deleteArticleById(String aid) {
		return dao.deleteArticleById(aid);
	}

	public int addArticle(ArticleBean ab) {
		ArticleBean abs = ab;
		abs.setAid(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		abs.setScantime(0);
		return dao.addArticle(abs);
	}

	public int updataArticle(ArticleBean ab) {
		return dao.updataArticle(ab);
	}

	public int updataArticleScantimeByAid(String aid) {
		
		return dao.updataArticleScantimeByAid(aid);
	}

	public int countArticle() {
		return dao.countArticle();
	}

	public List<ArticleBean> getArticelFive() {
		return dao.getArticelFive();
	}

}
