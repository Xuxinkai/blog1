package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.ArticleCommentBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.dao:ArticelCommentDao.java
 * @version 1.0
 * @data 2016-5-30
 */
public interface ArticelCommentDao {
	/**������е�����*/
	public List<ArticleCommentBean> getAllComments();
	/**��������id��ø��������е�����*/
	public List<ArticleCommentBean>  getCommentsByAid(String aid);
	/**��������idɾ������*/
	public int deleteCommentByCid(String cid);
	/**��������idɾ����������*/
	public int deleteCommentsByAid(String aid);
	/**��������id�����������*/
	public int addCommentByAid(ArticleCommentBean acb);
	/**��������id�޸����۲鿴״̬*/
	public int updateIsLookByCid(String cid);
	/**����aid��ȡδ�Ķ���������*/
	public int getUnlookCountByAid(String aid);
	/**��ȡδ�Ķ�����������*/
	public int getUnlookCount();
}
