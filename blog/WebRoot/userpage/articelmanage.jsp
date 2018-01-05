<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String userid =  (String)session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser",user);
	pageContext.setAttribute("articletypes",new ArticelTypeServiceImpl().getAllArticelType());
 %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   
    <title>徐新凯个人博客后台管理-文章管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />
</head>
  <style type="text/css">
.history:HOVER{
    background-color: #eaeaea;
    }
    select{
	border: solid 0px #fff;
	appearance:none;
  -moz-appearance:none;
  -webkit-appearance:none;
  	color: #09c;
	padding-right: 14px;
}
select::-ms-expand { display: none; }
</style>
<body>
    <%@include file="header.jsp" %>
<div class="admin">
	<div class="line-big">
        <div class="xm9" style="width: 100%">
	        <div class="panel" id="hisdiv">
	            <div class="panel-head"><strong>栏目列表</strong></div>
	             <table class="table">
	             <tr><td>栏目编号</td><td>栏目名称</td><td>栏目介绍</td><td>栏目文章数</td><td>操作</td></tr>
	             <c:forEach items="${articletypes }" var="at">
	              <tr class="history">
		              <td>${at.tid }</td> 
		              <td>${at.tname }</td>
		              <td>${at.tdesc }</td>
		              <td><a class="button button-little bg-main" href="${pageContext.request.contextPath }/userpage/ArticelSelect?type=anatype&tid=${at.tid }">${at.anum }</a></td>
		              <td>
		              <c:if test="${at.tid !=1 }"><a class="button button-little bg-main" href="">删除</a>
		              	<a class="button button-little bg-main" href="">修改</a>
		              </c:if>
		              <c:if test="${at.tid ==1 }"><span class="button button-little bg-gray">默认不能操作</span></c:if>
		              </td>
	              </tr>
	              </c:forEach>
	             </table>
	       </div>
        </div>
    </div>
</div>
  </body>
</html>