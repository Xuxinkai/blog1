package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.service.impl.ArticelServiceImpl;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet.userpage:ArticelDeleteServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class ArticelDeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aid = request.getParameter("aid");
		ArticelServiceImpl service = new ArticelServiceImpl();
		int count  = service.deleteArticleById(aid);
		if(count == 1){
			response.sendRedirect("ArticelSelect");
		}
	}

}
