<%@page import="cn.arice.com.util.DateHelper"%>
<%@page import="cn.arice.com.service.impl.ArticelCommentServiceImpl"%>
<%@page import="cn.arice.com.bean.ArticleCommentBean"%>
<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    
    <title>徐新凯个人博客后台管理-文章列表</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />
    
    <script type="text/javascript" src="jedate/jedate.js"></script>
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
<style>
.datainp{ width:100px; height:30px; border:0px  solid;}

</style>
  <body>
    <%@include file="header.jsp" %>
<div class="admin">
	<div class="line-big">
        <div class="xm9" style="width: 100%">
         <div class="panel" id="hisdiv">
	            <div class="panel-head">
	            <strong>文章列表</strong>
	            <input class="button button-little bg-main" id="datebut" name="date" type="button" onClick="jeDate({dateCell:'#datebut',isTime:true,format:'YYYY-MM-DD'})" value="<%=DateHelper.getDateTimeFormatDuan() %>">
				<a href="javascript:selectArticel()" class="button button-little bg-main" type="button">点击查询</a>--
	            <select onchange="mbar(this)" name="select">
	            <option value="${pageContext.request.contextPath }/userpage/ArticelSelect?type=all"
	            <c:if test="${tid==0 }"> selected='selected'</c:if>
	            >所有文章 </option>
	            <c:forEach items="${articletypes }" var="at">
	            <option value="${pageContext.request.contextPath }/userpage/ArticelSelect?type=anatype&tid=${at.tid }"
	            <c:if test="${tid==at.tid }"> selected='selected'</c:if>
	            >${at.tname }</option>
	            </c:forEach>
	            </select>
	            共${fn:length(abs) }篇文章
	            </div>
	             <table class="table">
	             <tr>
	             <td width="15%">文章编号</td>
	             <td width="10%">所属栏目</td>
	             <td width="15%">文章标题</td>
	             <td width="10%">作者</td>
	             <td width="20%">内容</td>
	             <td width="5%">阅读次数</td>
	             <td width="5%">评论次数</td>
	             <td width="10%">发表时间</td>
	             <td width="10%">操作</td></tr>
	             <c:forEach items="${abs}" var="ab">
	              <tr class="history">
		              <td>${ab.aid }</td> 
		              
		              <td>
		              <c:forEach items="${articletypes}" var="at">
		              <c:if test="${ab.tid==at.tid }"> ${at.tname }</c:if>
		              </c:forEach>
		              </td>
		              
		              <td>${ab.title }</td>
		              <td>${ab.author }</td>
		              <td>
		              	<a href="${pageContext.request.contextPath }/frontpage/ArticelView.jsp?aid=${ab.aid}" target="_blank">点击查看详情</a>
		              </td>
		              
		              <td><a class="button button-little bg-main" href="">${ab.scantime }</a></td>
		              <td><a class="button button-little bg-main" href="">${ab.comments }</a></td>
		              <td>${ab.time }</td>
		              
		              <td>
		              <a href="javascript:deleteArticel('${ab.aid }')" class="button button-little bg-main">删除</a>
		              <a href="javascript:updataArticel('${ab.aid }')" class="button button-little bg-main">查看|修改</a>
		              </td>
	              </tr>
	              </c:forEach>
	             </table>
	       </div>
        </div>
    </div>
</div>
  </body>
  <script type="text/javascript">
  function selectArticel() {
  		var datebut = document.getElementById("datebut").value;
		var postForm = document.createElement("form");
		postForm.action = '${pageContext.request.contextPath }/userpage/ArticelSelect?type=bytime';
		postForm.method = "post";
		var useridinput = document.createElement("input");
		useridinput.setAttribute('name', 'time');
		useridinput.setAttribute('value', datebut);
		postForm.appendChild(useridinput);
		document.body.appendChild(postForm);
		postForm.submit();
		document.body.removeChild(postForm);
	
}
  function updataArticel(aid) {
		var postForm = document.createElement("form");
		postForm.action = '${pageContext.request.contextPath }/userpage/ArticelSelect?type=updata';
		postForm.method = "post";
		var useridinput = document.createElement("input");
		useridinput.setAttribute('name', 'aid');
		useridinput.setAttribute('value', aid);
		postForm.appendChild(useridinput);
		document.body.appendChild(postForm);
		postForm.submit();
		document.body.removeChild(postForm);
	
}
  function deleteArticel(aid) {
  if (!confirm("确认删除[" + aid + "]吗")) {
		window.event.returnValue = false;
	} else {
		var postForm = document.createElement("form");
		postForm.action = '${pageContext.request.contextPath }/userpage/ArticelDelete';
		postForm.method = "post";
		var useridinput = document.createElement("input");
		useridinput.setAttribute('name', 'aid');
		useridinput.setAttribute('value', aid);
		postForm.appendChild(useridinput);
		document.body.appendChild(postForm);
		postForm.submit();
		document.body.removeChild(postForm);
		}
	
}
</script>
<script type="text/javascript">
    function mbar(sobj) {
       var docurl =sobj.options[sobj.selectedIndex].value;
       if (docurl != "") {
       window.location.href=docurl;
       }
}
 </script>
</html>