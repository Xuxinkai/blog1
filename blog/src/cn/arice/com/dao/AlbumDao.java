package cn.arice.com.dao;

import java.util.List;

import cn.arice.com.bean.AlbumBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.dao:AlbumDao.java
 * @version 1.0
 * @data 2016-5-30
 */
public interface AlbumDao {
	/**������е������Ϣ*/
	public List<AlbumBean> getAllAlbum();
	/**���һ�������Ϣ*/
	public int addAlbum(AlbumBean album);
	/**�������id�޸������Ϣ*/
	public int updateAlbumByAlid(AlbumBean album);
	/**�������id��ȡһ��������Ϣ*/
	public AlbumBean getAlbumByAlid(int alid);
	/**�������idɾ��һ�����   ���������ͼƬת�Ƶ�Ĭ�����*/
	public int deleteAlbumByAlid(int alid);
	
}
