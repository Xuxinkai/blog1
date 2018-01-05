package cn.arice.com.servlet.frontpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.LeaveMsgBean;
import cn.arice.com.service.LeaveMsgService;
import cn.arice.com.service.impl.LeaveMsgServiceImpl;
import cn.arice.com.util.GetIpAddr;
/**
 * 
 * @author Arice –Ï–¬ø≠
 * @description blog:cn.arice.com.servlet:LeaveMsgAddServlet.java ÃÌº”¡Ù—‘
 * @version 1.0
 * @data 2016-5-25
 */
public class LeaveMsgAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contactname = request.getParameter("contactname");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		LeaveMsgService service = new LeaveMsgServiceImpl();
		LeaveMsgBean msg = new LeaveMsgBean(null, contactname, email, message, null, GetIpAddr.getIpAddr(request), 0);
		int count = service.addLeaveMsg(msg);
		if(count == 1){
			response.sendRedirect("contact.jsp");
		}else{
			response.sendRedirect("errorpage/404.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
