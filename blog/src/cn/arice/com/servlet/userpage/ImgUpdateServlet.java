package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.service.impl.ImgServiceImpl;
/***
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet.userpage:ImgUpdateServlet.java
 * @version 1.0
 * @data 2016-5-31
 */
public class ImgUpdateServlet extends HttpServlet {
	private ImgServiceImpl imgser = new ImgServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int alid = Integer.parseInt(request.getParameter("alid"));
		String imgdesc = request.getParameter("imgdesc");
		String imgid = request.getParameter("imgid");
		int count = imgser.updateImgByImgid(new ImgBean(imgid, alid, null, null, imgdesc, null, null));
		if(count == 1){
			response.sendRedirect("imgview.jsp?imgid="+imgid);
		}else{
			response.sendError(404);
		}
	}

}
