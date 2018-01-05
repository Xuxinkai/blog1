package cn.arice.com.servlet.blog_wap;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arice.com.bean.ArticleBean;
import cn.arice.com.bean.ArticleCommentBean;
import cn.arice.com.service.ArticelCommentService;
import cn.arice.com.service.impl.ArticelCommentServiceImpl;
import cn.arice.com.service.impl.ArticelServiceImpl;
import cn.arice.com.util.GetIpAddr;
/**
 * 
 * @author ���¿�
 * @date 2017-2-25 ����2:06:49
 * @description ŷ������Servlet
 * 
 */
@SuppressWarnings("serial")
public class ArticleViewServlet extends HttpServlet {
	private ArticelServiceImpl aservice = new ArticelServiceImpl();
	private ArticelCommentService cservice = new ArticelCommentServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���Ҫ����ȥ����articelbean  ��Ҫ����ȥ����
		String aid = request.getParameter("aid");
		ArticleBean ab = aservice.getArticleById(aid);
		if(ab == null){
			response.sendError(404);
		}else{
			aservice.updataArticleScantimeByAid(aid);//�����Ķ�����
			List<ArticleCommentBean> acbs = cservice.getCommentsByAid(aid);//��ô�aid�µ�����
			request.setAttribute("ab", ab);
			request.setAttribute("acbs", acbs);
			request.getRequestDispatcher("articleView.jsp").forward(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����ͽ������۰ɣ���������
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String aid = request.getParameter("aid");
		//System.out.println(name+message+aid);
		ArticleCommentBean acb = new ArticleCommentBean(null, aid, name, message, null, GetIpAddr.getIpAddr(request), 0);
		int count = cservice.addCommentByAid(acb);
		if(count == 1){
			response.sendRedirect("ArticleViewServlet?aid="+aid);
		}else{
			response.sendError(404);
		}
	}

}
