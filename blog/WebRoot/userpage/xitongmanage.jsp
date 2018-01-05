<%@page import="cn.arice.com.service.impl.VisitServiceImpl"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String userid =  (String)session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser",user);
	pageContext.setAttribute("listvisit",new VisitServiceImpl().getAllVisit());
 %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>徐新凯个人博客后台管理-系统管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />
</head>
  
  <body>
    <%@include file="header.jsp" %>
<div class="admin">
	<div class="tab">
      <div class="tab-head">
        <strong>系统设置</strong>
        <ul class="tab-nav">
          <li class="active"><a href="#tab-visit">访问记录</a></li>
          <li><a href="#tab-yejiao">页脚设置</a></li>
          <li><a href="#tab-myurl">我的链接设置</a></li>
          <li><a href="#tab-sysurl">项目链接设置</a></li>
        </ul>
      </div>
      <div class="tab-body">
        <br />
        <div class="tab-panel active" id="tab-visit">
        	 <div class="panel admin-panel">
        	 <div class="padding border-bottom">
            	<span >总访问量：${fn:length(listvisit) }</span>
        </div>
        <table class="table table-hover">
        	<tr>
        	<th width="25%">访问编号</th>
        	<th width="25%">访问IP</th>
        	<th width="25%">访问时间</th>
        	<th width="25%">访问地址</th></tr>
        	<c:forEach items="${listvisit }" var="visit">
            <tr>
            	<td>${visit.visitid }</td>
            	<td>${visit.visitip }</td>
            	<td>${visit.visittime }</td>
            	<td>${visit.visitaddr }</td></tr>
        	</c:forEach>
        </table>
        <div class="panel-foot text-center">
            
        </div>
    </div>
        </div>
        <div class="tab-panel" id="tab-yejiao">页脚设置</div>
        <div class="tab-panel" id="tab-myurl">我的链接设置</div>
        <div class="tab-panel" id="tab-sysurl">项目链接设置</div>
      </div>
    </div>
</div>
  </body>
</html>