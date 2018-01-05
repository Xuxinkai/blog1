package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.service.LeaveMsgService;
import cn.arice.com.service.impl.LeaveMsgServiceImpl;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet.userpage:LeaveMsgSetIsLookServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class LeaveMsgSetIsLookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String geshu = request.getParameter("geshu");
		if("1".equals(geshu)){
			updataone(request, response);
		}else if("2".equals(geshu)){
			updataduo(request, response);
		}
	}
	public void updataone(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		LeaveMsgService service = new LeaveMsgServiceImpl();
		int count = service.setLeaveMsgIsLookById(id, 1);
		if(count == 1){
			response.sendRedirect("LeaveMsgSelect");
		}
	}
	public void updataduo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("chkSon");
		LeaveMsgService service = new LeaveMsgServiceImpl();
		for(String id:ids){
			service.setLeaveMsgIsLookById(id, 1);
		}
		response.sendRedirect("LeaveMsgSelect");
		
	}

}
