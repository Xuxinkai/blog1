package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.ArticleCommentBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.service:ArticelCommentService.java
 * @version 1.0
 * @data 2016-5-28
 */
public interface ArticelCommentService {
	/**获得所有的评论*/
	public List<ArticleCommentBean> getAllComments();
	/**根据文章id获得该文章所有的评论*/
	public List<ArticleCommentBean>  getCommentsByAid(String aid);
	/**根据评论id删除评论*/
	public int deleteCommentByCid(String cid);
	/**根据文章id删除批量评论*/
	public int deleteCommentsByAid(String aid);
	/**根据文章id添加文章评论*/
	public int addCommentByAid(ArticleCommentBean acb);
	/**根据评论id修改评论查看状态*/
	public int updateIsLookByCid(String cid);
	/**根据aid获取未阅读的评论数*/
	public int getUnlookCountByAid(String aid);
	/**获取未阅读的总评论数*/
	public int getUnlookCount();
}
