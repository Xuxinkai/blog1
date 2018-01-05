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
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.servlet.userpage:LeaveMsgSelectServlet.java
 * @version 1.0
 * @data 2016-6-2
 */
public class LeaveMsgSelectServlet extends HttpServlet {
	private LeaveMsgService  service = new LeaveMsgServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//初始化 pageBean
		PageBean<LeaveMsgBean> pageBean = new PageBean<LeaveMsgBean>();
		pageBean.setCurrentPage(1);
		pageBean.setMaxResult(10);//一页显示10条数据
		
		//页面传递过来的   当前页
		String page = request.getParameter("currentPage");
		if(page !=null && !"".equals(page.trim())){ //pageBean 对象 设置 当前页
			pageBean.setCurrentPage(Integer.parseInt(page));
		}		
				
		pageBean = service.getByPage(pageBean); //数据库查询总记录数
				
//		//分页bean放到作用域
		request.setAttribute("pageBean", pageBean);
				
		//转发
		request.getRequestDispatcher("leavemsgmanage.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
