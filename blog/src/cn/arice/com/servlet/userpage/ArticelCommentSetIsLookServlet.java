package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.service.impl.ArticelCommentServiceImpl;
/***
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet.userpage:ArticelCommentSetIsLookServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class ArticelCommentSetIsLookServlet extends HttpServlet {
	private ArticelCommentServiceImpl  acser = new ArticelCommentServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ArticelCommentSetIsLook
		String geshu = request.getParameter("geshu");
		if("1".equals(geshu)){
			String cid = request.getParameter("cid");
			int count = acser.updateIsLookByCid(cid);
			if(count == 1){
				response.sendRedirect("pinglunmanage.jsp");
			}else{
				response.sendError(404);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
