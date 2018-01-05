package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.AlbumBean;
import cn.arice.com.service.AlbumService;
import cn.arice.com.service.impl.AlbumServiceImpl;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet.userpage:AlbumAddServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class AlbumAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String alname = request.getParameter("alname");
		String aldesc = request.getParameter("aldesc");
		AlbumService service = new AlbumServiceImpl();
		int count = service.addAlbum(new AlbumBean( alname, aldesc));
		if( count == 1){
			response.sendRedirect("albummanage.jsp");
		}else{
			response.sendError(404);
		}
	}

}
