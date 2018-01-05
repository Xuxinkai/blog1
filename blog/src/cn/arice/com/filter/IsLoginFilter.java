package cn.arice.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Arice 徐新凯
 * @description blog:cn.arice.com.filter:IsLoginFilter.java 判断用户是否登录
 * @version 1.0
 * @data 2016-5-7
 */

public class IsLoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1.转换
		HttpServletRequest httprequest = (HttpServletRequest)request;
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		
		//2.获取url地址
		String path = httprequest.getRequestURI();
		
		//3.login.jsp 访问， loginServlet 允许访问
		String action = path.substring(path.lastIndexOf("/")+1, path.length());

		if("login".equals(action)||"404.jsp".equals(action)||"login.jsp".equals(action)||"Image".equals(action)||action.endsWith("js")||action.endsWith("gif")||action.endsWith("css")||action.endsWith("png")||action.endsWith("jpg")||action.endsWith("ico")){
			//放行
			chain.doFilter(httprequest, httpresponse);
		}else{
			//判断是否登陆
			String user = (String) httprequest.getSession().getAttribute("userid");
			if(user != null){ //登陆
				chain.doFilter(httprequest, httpresponse);
			}else{//没有登陆
				httpresponse.sendRedirect("login.jsp");
			}
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
