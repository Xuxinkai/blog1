package cn.arice.com.servlet.userpage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.UserInfoBean;
import cn.arice.com.service.UserInfoService;
import cn.arice.com.service.impl.UserInfoServiceImpl;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.servlet:ChangePwdServlet.java �޸�����
 * @version 1.0
 * @data 2016-5-25
 */
@SuppressWarnings("serial")
public class ChangePwdServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfoService service = new UserInfoServiceImpl();
		UserInfoBean user = service.getUserInfoById((String)request.getSession().getAttribute("userid"));
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		String password = user.getPassword();
		if(oldpwd.equals(password)){
			int count = service.updatePwdById(user.getUserid(), newpwd);
			if(count == 1){
				response.sendRedirect("index.jsp");
			}else{
				request.setAttribute("pwderrormsg", "�޸�����������Ժ��޸�");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else{
			
			request.setAttribute("pwderrormsg", "ԭ�����������������");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
