package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.LoginHistoryBean;
import cn.arice.com.bean.UserInfoBean;
import cn.arice.com.service.UserInfoService;
import cn.arice.com.service.impl.UserInfoServiceImpl;
import cn.arice.com.util.DateHelper;
import cn.arice.com.util.GetIpAddr;
import cn.arice.com.util.XMLHelper;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.servlet:LoginServlet.java ��¼servlet
 * @version 1.0
 * @data 2016-5-25
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfoService service = new UserInfoServiceImpl();
		//��ȡ�û��������Ϣ
		String admin = request.getParameter("admin");//�û���
		String password = request.getParameter("password");//����
		String passcode = request.getParameter("passcode");//��֤��
		String captcha = (String)request.getSession().getAttribute("captcha");
		if(service.login(admin, password) && passcode.equals(captcha)){
			String userid = service.getIdByName(admin);
			XMLHelper xml = new XMLHelper();
			xml.addElement(new LoginHistoryBean((xml.getHistoryCount()+1)+"", userid, DateHelper.getDateTimeFormat(), GetIpAddr.getIpAddr(request)));
			request.getSession().setAttribute("userid", userid);
			response.sendRedirect("index.jsp");
		}else{
			if(!service.login(admin, password)){
				request.setAttribute("errormsg", "�û��������������");
			}else if(!passcode.equals(captcha)){
				request.setAttribute("errormsg", "��֤�����");
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
