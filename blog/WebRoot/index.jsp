<%@page import="cn.arice.com.util.HttpRequestDeviceUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>欢迎来到我的博客</title>
	
  </head>
  <body>
  <%
  boolean flag = false;
  if(HttpRequestDeviceUtils.isMobileDevice(request)){
	  response.sendRedirect("blog_wap/index.jsp");
  }else{
	  response.sendRedirect("frontpage/indexfront.jsp");
  }
  %>
  </body>
</html>
