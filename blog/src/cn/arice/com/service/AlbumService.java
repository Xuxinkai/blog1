package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.AlbumBean;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.service:AlbumService.java
 * @version 1.0
 * @data 2016-5-28
 */
public interface AlbumService {
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
