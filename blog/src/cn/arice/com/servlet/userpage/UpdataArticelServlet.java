package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.service.impl.ArticelServiceImpl;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.servlet.userpage:UpdataArticelServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class UpdataArticelServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticelServiceImpl aservice = new ArticelServiceImpl();
		ArticleBean ab = new ArticleBean();
		String aid = request.getParameter("aid");
		if(request.getParameter("content1") == ""||request.getParameter("content1") == null||request.getParameter("articeltitle") == "" ||request.getParameter("articeltitle") == null ||request.getParameter("zuozhe") == null||request.getParameter("zuozhe") == ""){
			request.setAttribute("aerrormsg", "请填写完整再提交");
			ab = aservice.getArticleById(aid);
			request.setAttribute("ab", ab);
			request.getRequestDispatcher("updataarticel.jsp").forward(request, response);
		}else{
			String htmlData = request.getParameter("content1") != "" ? request.getParameter("content1") : "";
			String tid = request.getParameter("tid") != "" ? request.getParameter("tid") : "";
			String articeltitle = request.getParameter("articeltitle") != "" ? request.getParameter("articeltitle") : "";
			String zuozhe = request.getParameter("zuozhe") != "" ? request.getParameter("zuozhe") : "";
			String date = request.getParameter("date") != "" ? request.getParameter("date") : "";
			ArticleBean abs= new ArticleBean(aid, Integer.parseInt(tid), articeltitle, zuozhe, htmlData, 0, date);
			int count = new ArticelServiceImpl().updataArticle(abs);
			if(count == 1){
				request.setAttribute("aerrormsg", "文章修改成功");
				request.setAttribute("ab", abs);
				request.getRequestDispatcher("updataarticel.jsp").forward(request, response);
			}else{
				request.setAttribute("aerrormsg", "文章修改失败");
				request.setAttribute("ab", abs);
				request.getRequestDispatcher("updataarticel.jsp").forward(request, response);
			}
		}
	}

}
