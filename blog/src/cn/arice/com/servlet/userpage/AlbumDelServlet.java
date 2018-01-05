package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.service.AlbumService;
import cn.arice.com.service.ImgService;
import cn.arice.com.service.impl.AlbumServiceImpl;
import cn.arice.com.service.impl.ImgServiceImpl;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.servlet.userpage:AlbumDelServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class AlbumDelServlet extends HttpServlet {
	private ImgService imgser = new ImgServiceImpl();
	private AlbumService albumser = new AlbumServiceImpl();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int alid = Integer.parseInt(request.getParameter("alid"));
		//��Ҫ�ı�����������ͼƬ��alid����  ��ΪĬ�ϵ����id  Ϊ1��
		List<ImgBean> listimg = imgser.getImgsByAlid(alid);
		if(listimg != null){
			for(ImgBean img : listimg){
				imgser.updateAlidByImgid(1, img.getImgid());
			}
		}
		int count = albumser.deleteAlbumByAlid(alid); 
		if(count == 1){
			response.sendRedirect("albummanage.jsp");
		}else{
			response.sendError(404);
		}
	}
}
