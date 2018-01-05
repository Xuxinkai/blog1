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
 * @description blog:cn.arice.com.servlet:LeaveMsgDeleteServlet.java É¾³ýÁôÑÔ
 * @version 1.0
 * @data 2016-5-25
 */
public class LeaveMsgDeleteServlet extends HttpServlet {
private LeaveMsgService lmservice = new LeaveMsgServiceImpl();
	public void deleteOne(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("lmid");
		int count =lmservice.deleteLeaveMsgById(id);
		if(count == 1){
			response.sendRedirect("LeaveMsgSelect");
		}
	}
	public void deleteduo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("chkSon");
		LeaveMsgService service = new LeaveMsgServiceImpl();
		for(String id:ids){
			lmservice.deleteLeaveMsgById(id);
		}
		response.sendRedirect("LeaveMsgSelect");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String geshu = request.getParameter("geshu");
		if("1".equals(geshu)){
			deleteOne(request, response);
		}else if("2".equals(geshu)){
			deleteduo(request, response);
		}
		
	}

}
