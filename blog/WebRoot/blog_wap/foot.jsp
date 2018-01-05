<%@page import="cn.arice.com.util.GetIpAddr"%>
<%@page import="cn.arice.com.util.DateHelper"%>
<%@page import="cn.arice.com.bean.VisitBean"%>
<%@page import="cn.arice.com.service.impl.VisitServiceImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
VisitServiceImpl vsi = new VisitServiceImpl();
if(session.getAttribute("visit") == null){
vsi.addVisit(new VisitBean(null,GetIpAddr.getIpAddr(request),null));
session.setAttribute("visit", 1);
}
pageContext.setAttribute("listvisit",vsi.getAllVisit());
%>
<a href="#">····</a> | 触屏版 | <a href="#">····</a><p></p>
<span>&copy; Copyright 2015-<%=DateHelper.getYearFormat() %>, Arice`s blog Powered  by <a href="http://www.arice.ren/">徐新凯</a> 
<br>湘ICP备<a href="http://www.miitbeian.gov.cn/">15019550号</a></span>
