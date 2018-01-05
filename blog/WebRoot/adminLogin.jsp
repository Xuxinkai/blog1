<%@page import="cn.arice.com.util.HttpRequestDeviceUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
  boolean flag = false;
  if(HttpRequestDeviceUtils.isMobileDevice(request)){
	  response.sendRedirect("userpage/login.jsp");//手机访问   blog_bg/login.html
  }else{
	  response.sendRedirect("userpage/login.jsp");//电脑访问
  }
  %>