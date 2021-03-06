package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.AlbumBean;
import cn.arice.com.service.impl.AlbumServiceImpl;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.servlet.userpage:AlbumUpdateServlet.java
 * @version 1.0
 * @data 2016-6-1
 */
public class AlbumUpdateServlet extends HttpServlet {
	private AlbumServiceImpl alser = new AlbumServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String alname = request.getParameter("alname");
		String aldesc = request.getParameter("aldesc");
		int alid = Integer.parseInt(request.getParameter("alid"));
		int count = alser.updateAlbumByAlid(new AlbumBean(alid, alname, aldesc));
		if(count == 1){
			response.sendRedirect("albummanage.jsp");
		}else{
			response.sendError(404);
		}
	}

}
