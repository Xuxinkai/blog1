package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.ArticleBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.service:ArticelService.java
 * @version 1.0
 * @data 2016-5-25
 */
public interface ArticelService {
	/**��ѯ���е�����*/
	public List<ArticleBean> getAllArticle();
	/**����������ѯ����*/
	public List<ArticleBean> getArticleByTid(int tid);
	/**��ʱ���ѯ����*/
	public List<ArticleBean> getArticleByTime(String time);
	/**�����±�Ž����ѯǰ��ƪ����*/
	public List<ArticleBean> getArticelFive();
	
	/**�����±�Ų�ѯ����*/
	public ArticleBean getArticleById(String aid);
	/**�����±��ɾ������*/
	public int deleteArticleById(String aid);
	/**�������*/
	public int addArticle(ArticleBean ab);
	/**�޸�����*/
	public int updataArticle(ArticleBean ab);
	/**����aid�������µ��Ķ�����*/
	public int updataArticleScantimeByAid(String aid);
	/**��ȡ��������*/
	public int countArticle();
}
