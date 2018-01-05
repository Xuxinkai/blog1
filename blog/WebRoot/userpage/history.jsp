
<%@page import="cn.arice.com.util.XMLHelper"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>徐新凯个人博客后台管理-登录历史</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />
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
</head>
<%
	String userid =  (String)session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser",user);
	XMLHelper xml = new XMLHelper();
	pageContext.setAttribute("history",xml.getPenultHistory());
 %>

<body>
<%@include file="header.jsp" %>

<div class="admin">
	<div class="line-big">
    	<div class="xm3">
        	<div class="panel border-back">
            	<div class="panel-body text-center">
                	<img src="images/face.jpg" width="120" class="radius-circle" /><br />
                    ${loginuser.realname }
                </div>
                <div class="panel-foot bg-back border-back">
                		您好，${loginuser.realname }，上次登录时间为:<br>
                		${history.loginTime }。<br>
                		<a class="button border-main" href="index.jsp">返回主页</a>
                </div>
            </div>
        </div>
        <div class="xm9">
         <div class="panel" id="hisdiv">
            <div class="panel-head"><strong>登录记录</strong></div>
             <table class="table">
                	<tr>
                		<td>编号</td>
	                	<td>登录用户编号</td>
	                	<td>登录时间</td>
	                	<td>登录IP</td>
                	</tr>
                	<c:forEach var="his" items="${ page.dataList}" >
                	<tr class="history">
                		<td>${his.loginId}</td>
	                	<td>${his.loginUserId }</td>
	                	<td>${his.loginTime }</td>
	                	<td>${his.loginIp }</td>
                	</tr>
                	</c:forEach>
                	<tr>
                		<td colspan="4">
                		<a class="button button-little bg-main" href="${pageContext.request.contextPath }/userpage/LoginHistory?currentPage=1">首&nbsp;页</a>
                		<select onchange="mbar(this)" name="select">
					    <c:forEach var="i" begin="1" end="${page.totalPage }">
					    	<option value="${pageContext.request.contextPath }/userpage/LoginHistory?currentPage=${i}" 
					    	<c:if test="${i==page.currentPage}">
					    	 selected="selected"
					    	 </c:if>
					    	>第${i}页</option>
					    </c:forEach>
					    </select>
					    <a class="button button-little bg-main" href="${pageContext.request.contextPath }/userpage/LoginHistory?currentPage=${page.totalPage}">尾&nbsp;页</a>
					   <span class="button button-little bg-main">共${ page.totalPage}页</span> 
					    </td>
                	</tr>
                	</table>
            </div>
      </div>
   </div>
</div>
           
</body>
  <script type="text/javascript">
    function mbar(sobj) {
       var docurl =sobj.options[sobj.selectedIndex].value;
       if (docurl != "") {
       window.location.href=docurl;
       }
}
 </script>

</html>

