package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.ArticelTypeBean;
import cn.arice.com.bean.ArticleBean;

/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.dao:ArticelDao.java
 * @version 1.0
 * @data 2016-5-25
 */
public interface ArticelDao {
	/**��ѯ���е�����*/
	public List<ArticleBean> getAllArticle();
	/**����������ѯ����*/
	public List<ArticleBean> getArticleByTid(int tid);
	/**
	 * time�ĸ�ʽ��'2016-05-25' 
	 * ��ʱ���ѯ����*/
	public List<ArticleBean> getArticleByTime(String time);
	
	/**�����±�Ž����ѯǰ��ƪ����*/
	public List<ArticleBean> getArticelFive();
	
	/**�����±�Ų�ѯ����*/
	public ArticleBean getArticleById(String aid);
	/**��ȡ��������*/
	public int countArticle();
	/**�����±��ɾ������*/
	public int deleteArticleById(String aid);
	/**�������*/
	public int addArticle(ArticleBean ab);
	/**�޸�����*/
	public int updataArticle(ArticleBean ab);
	/**����aid�������µ��Ķ�����*/
	public int updataArticleScantimeByAid(String aid);
	
}
