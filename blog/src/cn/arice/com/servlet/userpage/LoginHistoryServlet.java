package cn.arice.com.servlet.userpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.LoginHistoryBean;
import cn.arice.com.bean.PageBean;
import cn.arice.com.util.XMLHelper;
/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.servlet:LoginHistoryServlet.java 登录历史servlet
 * @version 1.0
 * @data 2016-5-25
 */
@SuppressWarnings("serial")
public class LoginHistoryServlet extends HttpServlet {
	private int startHistory;//开始的记录数
	private int endHistory;//结束的记录数
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageBean<LoginHistoryBean> page = new PageBean<LoginHistoryBean>();
		String cu = null;
		if(request.getParameter("currentPage") == ""||request.getParameter("currentPage")==null){
			cu = "1";
		}else{
			cu = request.getParameter("currentPage");
		}
		
		page.setCurrentPage(Integer.parseInt(cu));//设置当前页面数
		XMLHelper xml = new XMLHelper();
		page.setMaxResult(10);//设置每页最大的记录数
		page.setTotalCount(xml.getHistoryCount());//设置总记录数
		
		if(page.getCurrentPage() > page.getTotalPage()){
			page.setCurrentPage(page.getTotalPage());
		}
		if(page.getCurrentPage() < 1){
			page.setCurrentPage(1);
		}
		startHistory = (page.getCurrentPage() - 1)*page.getMaxResult() + 1;//记录是从1开始的
		endHistory = page.getCurrentPage()*page.getMaxResult();
		ArrayList<LoginHistoryBean> listHis = xml.parserXml();
		ArrayList<LoginHistoryBean> lists = new ArrayList<LoginHistoryBean>();
		for(int i = 0;i<listHis.size();i++){
			//如果LoginId在范围内就加入新的list中
			if(Integer.parseInt(listHis.get(i).getLoginId()) >= startHistory &&Integer.parseInt(listHis.get(i).getLoginId())<=endHistory){
				lists.add(listHis.get(i));
			}
		}
		page.setDataList(lists);
		request.setAttribute("page",page);
		request.getRequestDispatcher("history.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
