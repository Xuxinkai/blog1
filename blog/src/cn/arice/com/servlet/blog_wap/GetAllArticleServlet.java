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
 * @���� ���¿�
 * @��Ŀ���ƣ�blog  
 * @����ʱ�� 2017��2��24�� ����4:03:44
 * @����޸�ʱ�� 2017��2��24�� ����4:03:44
 * @���� ��ȡ���еĲ���  ������ʱ��������
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
