package cn.arice.com.servlet.blog_wap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.service.ArticelService;
import cn.arice.com.service.impl.ArticelServiceImpl;
/**
 * 
 * @作者 徐新凯
 * @项目名称：blog  
 * @创建时间 2017年2月24日 下午4:03:44
 * @最后修改时间 2017年2月24日 下午4:03:44
 * @描述 获取所有的博文  安最新时间来排序
 * @version
 */
public class GetAllArticleServlet extends HttpServlet {
	private ArticelService aservice = new ArticelServiceImpl();
	private List<ArticleBean> abs = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		abs = aservice.getAllArticle();
		request.setAttribute("abs", abs);
		request.getRequestDispatcher("allArticle.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
