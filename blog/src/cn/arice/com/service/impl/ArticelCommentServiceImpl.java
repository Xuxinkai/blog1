package cn.arice.com.service.impl;

import java.util.List;

import cn.arice.com.bean.ArticleCommentBean;
import cn.arice.com.dao.ArticelCommentDao;
import cn.arice.com.dao.impl.ArticelCommetDaoImpl;
import cn.arice.com.service.ArticelCommentService;
import cn.arice.com.util.DateHelper;
import cn.arice.com.util.Random100;
import cn.arice.com.util.SensitiveWord;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.service.impl:ArticelCommentServiceImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public  class ArticelCommentServiceImpl implements ArticelCommentService {
	private ArticelCommentDao dao = new ArticelCommetDaoImpl();
	public List<ArticleCommentBean> getAllComments() {
		return dao.getAllComments();
	}

	public List<ArticleCommentBean> getCommentsByAid(String aid) {
		return dao.getCommentsByAid(aid);
	}

	public int deleteCommentByCid(String cid) {
		return dao.deleteCommentByCid(cid);
	}

	public int deleteCommentsByAid(String aid) {
		return dao.deleteCommentsByAid(aid);
	}

	public int addCommentByAid(ArticleCommentBean acb) {
		ArticleCommentBean oacb = acb;
		oacb.setCid(DateHelper.getDateTimeForNumber()+Random100.getrandom100());
		oacb.setIslook(0);
		oacb.setCtime(DateHelper.getDateTimeFormat());
		oacb.setContent(SensitiveWord.filteSensitiveWord(acb.getContent()));
		return dao.addCommentByAid(oacb);
	}

	public int updateIsLookByCid(String cid) {
		return dao.updateIsLookByCid(cid);
	}

	public int getUnlookCountByAid(String aid) {
		return dao.getUnlookCountByAid(aid);
	}

	public int getUnlookCount() {
		return dao.getUnlookCount();
	}

}
