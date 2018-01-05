package cn.arice.com.service;

import java.util.List;

import cn.arice.com.bean.AlbumBean;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.service:AlbumService.java
 * @version 1.0
 * @data 2016-5-28
 */
public interface AlbumService {
	/**获得所有的相册信息*/
	public List<AlbumBean> getAllAlbum();
	/**添加一个相册信息*/
	public int addAlbum(AlbumBean album);
	/**根据相册id修改相册信息*/
	public int updateAlbumByAlid(AlbumBean album);
	/**根据相册id获取一个相册的信息*/
	public AlbumBean getAlbumByAlid(int alid);
	/**根据相册id删除一个相册   下面的所有图片转移到默认相册*/
	public int deleteAlbumByAlid(int alid);

}
