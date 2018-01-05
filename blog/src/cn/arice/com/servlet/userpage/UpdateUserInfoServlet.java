package cn.arice.com.servlet.userpage;

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
 * @description blog:cn.arice.com.servlet:UpdateUserInfoServlet.java 更新管理员的信息servlet
 * @version 1.0
 * @data 2016-5-25
 */
public class UpdateUserInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String logname = request.getParameter("logname");
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String telNumber = request.getParameter("telNumber");
		String birthplace = request.getParameter("birthplace");
		String liveplace = request.getParameter("liveplace");
		String introduce = request.getParameter("introduce");
		UserInfoBean user = new UserInfoBean(userid, logname, null, realName, sex, birthday, email, telNumber, birthplace, liveplace, null, introduce);
		UserInfoService service = new UserInfoServiceImpl();
		int count =service.updateUserInfoById(user);
		if(count==1){
			response.sendRedirect("index.jsp");
		}else{
			request.setAttribute("errormsg", "信息修改错误");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
