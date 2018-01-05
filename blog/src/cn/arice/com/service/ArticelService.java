package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.ArticleBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.service:ArticelService.java
 * @version 1.0
 * @data 2016-5-25
 */
public interface ArticelService {
	/**查询所有的文章*/
	public List<ArticleBean> getAllArticle();
	/**按文章类别查询文章*/
	public List<ArticleBean> getArticleByTid(int tid);
	/**按时间查询文章*/
	public List<ArticleBean> getArticleByTime(String time);
	/**按文章编号降序查询前五篇文章*/
	public List<ArticleBean> getArticelFive();
	
	/**按文章编号查询文章*/
	public ArticleBean getArticleById(String aid);
	/**按文章编号删除文章*/
	public int deleteArticleById(String aid);
	/**添加文章*/
	public int addArticle(ArticleBean ab);
	/**修改文章*/
	public int updataArticle(ArticleBean ab);
	/**根据aid更新文章的阅读次数*/
	public int updataArticleScantimeByAid(String aid);
	/**获取文章总数*/
	public int countArticle();
}
