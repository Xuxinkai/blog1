package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.service.impl.ImgServiceImpl;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet.userpage:ImgDelServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class ImgDelServlet extends HttpServlet {
	private ImgServiceImpl imgser = new ImgServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = "";
		if(request.getParameter("type") == ""||request.getParameter("type") == null){
			response.sendError(404);
		}else{
			type = request.getParameter("type");
		}
		if("1".equals(type)){
			String imgid = request.getParameter("imgid");
			int count = imgser.delImgByImgid(imgid);
			if(count == 1){
				response.sendRedirect("ImgSelect?type=all");
			}else{
				response.sendError(404);
			}
		}else if("2".equals(type)){
			String[] imgid = request.getParameterValues("cboximgid");
			for(String id:imgid){
				imgser.delImgByImgid(id);
			}
			response.sendRedirect("ImgSelect?type=all");
		}
		
	}

}
