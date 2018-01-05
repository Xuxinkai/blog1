package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.service.ArticelService;
import cn.arice.com.service.impl.ArticelServiceImpl;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet:ArticelSelectServlet.java
 * @version 1.0
 * @data 2016-5-27
 */
public class ArticelSelectServlet extends HttpServlet {
	private ArticelService aservice = new ArticelServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ArticleBean> abs = null;
		ArticleBean ab = null;
		String type = null;
		if(request.getParameter("type") == null||request.getParameter("type")==""){
			type="all";
		}else{
			type = request.getParameter("type");
		}
		if("anatype".equals(type)){
			String tid = request.getParameter("tid");
			abs = aservice.getArticleByTid(Integer.parseInt(tid));
			request.setAttribute("abs", abs);
			request.setAttribute("tid", Integer.parseInt(tid));
			request.getRequestDispatcher("articel.jsp").forward(request, response);
		}else if("all".equals(type)){
			abs = aservice.getAllArticle();
			request.setAttribute("abs", abs);
			request.setAttribute("tid", 0);
			request.getRequestDispatcher("articel.jsp").forward(request, response);
		}else if("bytime".equals(type)){
			String time = request.getParameter("time");
			abs = aservice.getArticleByTime(time);
			request.setAttribute("abs", abs);
			request.getRequestDispatcher("articel.jsp").forward(request, response);
		}else if("updata".equals(type)){
			String aid = request.getParameter("aid");
			ab = aservice.getArticleById(aid);
			request.setAttribute("ab", ab);
			request.getRequestDispatcher("updataarticel.jsp").forward(request, response);
		}else{
			abs = aservice.getAllArticle();
			request.setAttribute("abs", abs);
			request.setAttribute("tid", 0);
			request.getRequestDispatcher("articel.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
