package cn.arice.com.servlet.userpage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.arice.com.bean.LeaveMsgBean;
import cn.arice.com.bean.PageBean;
import cn.arice.com.service.LeaveMsgService;
import cn.arice.com.service.impl.LeaveMsgServiceImpl;
/**
 * 
 * @author Arice ���¿�
 * @description blog:cn.arice.com.servlet.userpage:LeaveMsgSelectServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class LeaveMsgSelectServlet extends HttpServlet {
	private LeaveMsgService  service = new LeaveMsgServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��ʼ�� pageBean
		PageBean<LeaveMsgBean> pageBean = new PageBean<LeaveMsgBean>();
		pageBean.setCurrentPage(1);
		pageBean.setMaxResult(10);//һҳ��ʾ10������
		
		//ҳ�洫�ݹ�����   ��ǰҳ
		String page = request.getParameter("currentPage");
		if(page !=null && !"".equals(page.trim())){ //pageBean ���� ���� ��ǰҳ
			pageBean.setCurrentPage(Integer.parseInt(page));
		}		
				
		pageBean = service.getByPage(pageBean); //���ݿ��ѯ�ܼ�¼��
				
//		//��ҳbean�ŵ�������
		request.setAttribute("pageBean", pageBean);
				
		//ת��
		request.getRequestDispatcher("leavemsgmanage.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
