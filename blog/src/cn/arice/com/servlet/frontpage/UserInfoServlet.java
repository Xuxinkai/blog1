package cn.arice.com.servlet.frontpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.UserInfoBean;
import cn.arice.com.service.UserInfoService;
import cn.arice.com.service.impl.UserInfoServiceImpl;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.servlet:UserInfoServlet.java 个人信息servlet
 * @version 1.0
 * @data 2016-5-25
 */
public class UserInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfoServiceImpl userService = new UserInfoServiceImpl();
		UserInfoBean user = userService.getUserInfo();
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("userinfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
