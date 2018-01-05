package cn.arice.com.servlet.frontpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.service.impl.ArticelServiceImpl;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet:ArticelListByTypeServlet.java
 * @version 1.0
 * @data 2016-5-28
 */
@SuppressWarnings("serial")
public class ArticelListByTypeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tid = "";
		if(request.getParameter("tid") == null||request.getParameter("tid") == ""){
			tid = "0";
		}else{
			tid = request.getParameter("tid");
		}
		List<ArticleBean> abs = new ArticelServiceImpl().getArticleByTid(Integer.parseInt(tid));
		request.setAttribute("abs", abs);
		request.getRequestDispatcher("articlelist.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(404);
	}

}
