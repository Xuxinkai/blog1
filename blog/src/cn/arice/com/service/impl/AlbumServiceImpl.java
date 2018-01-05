package cn.arice.com.service.impl;

import java.util.List;

import cn.arice.com.bean.AlbumBean;
import cn.arice.com.dao.AlbumDao;
import cn.arice.com.dao.impl.AlbumDaoImpl;
import cn.arice.com.service.AlbumService;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.service.impl:AlbumServiceImpl.java
 * @version 1.0
 * @data 2016-5-28
 */
public class AlbumServiceImpl implements AlbumService {
	private AlbumDao dao = new AlbumDaoImpl();
	public List<AlbumBean> getAllAlbum() {
		return dao.getAllAlbum();
	}

	public int addAlbum(AlbumBean album) {
		return dao.addAlbum(album);
	}

	public int updateAlbumByAlid(AlbumBean album) {
		return dao.updateAlbumByAlid(album);
	}

	public AlbumBean getAlbumByAlid(int alid) {
		return dao.getAlbumByAlid(alid);
	}

	public int deleteAlbumByAlid(int alid) {
		return dao.deleteAlbumByAlid(alid);
	}

}
