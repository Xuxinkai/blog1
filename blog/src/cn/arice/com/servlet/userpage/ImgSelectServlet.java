package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ImgBean;
import cn.arice.com.service.impl.ImgServiceImpl;
/**
 * 
 * @author Arice ÐìÐÂ¿­
 * @description blog:cn.arice.com.servlet.userpage:ImgSelectServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
@SuppressWarnings("serial")
public class ImgSelectServlet extends HttpServlet {
	private ImgServiceImpl imgser = new ImgServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if("all".equals(type)||"".equals(type)||type==null){
			List<ImgBean> listimg = imgser.getAllImg();
			request.setAttribute("listimg", listimg);
			request.setAttribute("alid", 0);
			request.getRequestDispatcher("imgmanage.jsp").forward(request, response);
		}else if("analbum".equals(type)){
			String id = null;
			if(request.getParameter("alid")==""||request.getParameter("alid")==null){
				id = "1";
			}else{
				id = request.getParameter("alid");
			}
			int alid = Integer.parseInt(id);
			List<ImgBean> listimg = imgser.getImgsByAlid(alid);
			request.setAttribute("listimg", listimg);
			request.setAttribute("alid", alid);
			request.getRequestDispatcher("imgmanage.jsp").forward(request, response);
		}
		
	}

}
