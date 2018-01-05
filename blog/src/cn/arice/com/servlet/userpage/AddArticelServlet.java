package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.service.impl.ArticelServiceImpl;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.servlet.userpage:AddArticelServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
@SuppressWarnings("serial")
public class AddArticelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("content1") == ""||request.getParameter("content1") == null||request.getParameter("articeltitle") == "" ||request.getParameter("articeltitle") == null ||request.getParameter("zuozhe") == null||request.getParameter("zuozhe") == ""){
			request.getSession().setAttribute("aerrormsg", "请填写完整再提交");
			response.sendRedirect("fabuarticel.jsp");
		}else{
			String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
			String tid = request.getParameter("tid") != null ? request.getParameter("tid") : "";
			String articeltitle = request.getParameter("articeltitle") != null ? request.getParameter("articeltitle") : "";
			String zuozhe = request.getParameter("zuozhe") != null ? request.getParameter("zuozhe") : "";
			String date = request.getParameter("date") != null ? request.getParameter("date") : "";
			ArticleBean ab= new ArticleBean(null, Integer.parseInt(tid), articeltitle, zuozhe, htmlData, 0, date);
			int count = new ArticelServiceImpl().addArticle(ab);
			if(count == 1){
				request.getSession().setAttribute("aerrormsg", "文章添加成功");
				response.sendRedirect("fabuarticel.jsp");
			}else{
				request.getSession().setAttribute("aerrormsg", "文章添加失败");
				response.sendRedirect("fabuarticel.jsp");
			}
		}
		
	}

}
