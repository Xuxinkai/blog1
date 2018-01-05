<%@page import="cn.arice.com.service.impl.ArticelServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ArticelCommentServiceImpl"%>
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
	pageContext.setAttribute("allcomment", new ArticelCommentServiceImpl().getAllComments());
	pageContext.setAttribute("allarticle", new ArticelServiceImpl().getAllArticle());
 %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>徐新凯个人博客后台管理-评论管理</title>
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
<script language="javascript">
// --列头全选框被单击---
function ChkAllClick(sonName, cbAllId){
    var arrSon = document.getElementsByName(sonName);
 var cbAll = document.getElementById(cbAllId);
 var tempState=cbAll.checked;
 for(i=0;i<arrSon.length;i++) {
  if(arrSon[i].checked!=tempState)
           arrSon[i].click();
 }
}

// --子项复选框被单击---
function ChkSonClick(sonName, cbAllId) {
 var arrSon = document.getElementsByName(sonName);
 var cbAll = document.getElementById(cbAllId);
 for(var i=0; i<arrSon.length; i++) {
     if(!arrSon[i].checked) {
     cbAll.checked = false;
     return;
     }
 }
 cbAll.checked = true;
}

// --反选被单击---
function ChkOppClick(sonName){
 var arrSon = document.getElementsByName(sonName);
 for(i=0;i<arrSon.length;i++) {
  arrSon[i].click();
 }
}
</script>

  <body>
    <%@include file="header.jsp" %>
<div class="admin">
	<div class="line-big">
        <div class="xm9" style="width: 100%">
         <div class="panel" id="hisdiv">
	            <div class="panel-head"><strong>所有评论</strong></div>
	             <table class="table">
	             <tr>
	             	 <td width="5%"><input type="checkbox" name="chkAll" id="chkAll" onClick="ChkAllClick('chkSon','chkAll')" ></td>
		             <td width="10%">评论编号</td>
		             <td width="15%">评论文章</td>
		             <td width="10%">评论人</td>
		             <td width="20%">评论内容</td>
		             <td width="15%">评论时间</td>
		             <td width="10%">IP地址</td>
		             <td width="10%">状态</td>
		             <td width="5%">操作</td>
	             </tr>
	             <c:forEach items="${allcomment }" var="acb" varStatus="stat">
	              <tr class="history">
	              	  <td><input type="checkbox" value="${acb.cid}" name="chkSon" id="chkSon${stat.count }" onclick="ChkSonClick('chkSon','chkAll')"  ></td>
		              <td>${acb.cid }</td> 
		              <td>
		              <c:forEach items="${ allarticle}" var="ab">
		              <c:if test="${ab.aid == acb.aid }"> ${ ab.title}</c:if>
		              </c:forEach>
		              </td>
		              <td>${acb.cuser }</td>
		              <td>${acb.content }</td>
		              <td>${acb.ctime }</td>
		              <td>${acb.cip }</td>
		              <td>
			              <c:if test="${acb.islook == 1 }"><span class="button button-little bg-main">已查看</span></c:if>
			              <c:if test="${acb.islook == 0 }"><a class="button button-little bg-red" href="${pageContext.request.contextPath }/userpage/ArticelCommentSetIsLook?geshu=1&cid=${acb.cid}">未查看</a></c:if>
		              </td>
		              <td>
		              <a class="button button-little bg-main" href="javascript:delpinglun('${acb.cid }')">删除</a>
		              </td>
	              </tr>
	              </c:forEach>
	              
	              <tr>
                		<td colspan="9">
                		<a class="button button-little bg-main" href="${pageContext.request.contextPath }/userpage/LeaveMsgSelect?currentPage=1">首&nbsp;页</a>
                		<select onchange=mbar(this) name="selectpage">
					    <c:forEach var="i" begin="1" end="${pageBean.totalPage }">
					    	<option value="${pageContext.request.contextPath }/userpage/LeaveMsgSelect?currentPage=${i}" 
					    	<c:if test="${i==pageBean.currentPage}">
					    	 selected="selected"
					    	 </c:if>
					    	>第${i}页</option>
					    </c:forEach>
					    </select>
					    <a class="button button-little bg-main" href="${pageContext.request.contextPath }/userpage/LeaveMsgSelect?currentPage=${pageBean.totalPage}">尾&nbsp;页</a>
					   <span class="button button-little bg-main">共${ pageBean.totalPage}页</span> 
					    </td>
                	</tr>
	             </table>
	       </div>
        </div>
    </div>
</div>
  </body>
  <script type="text/javascript">
    function delpinglun(id) {
	if (!confirm("确认删除评论[" + id + "]吗")) {
		window.event.returnValue = false;
	} else {
		var postForm = document.createElement("form");
		postForm.action = '${pageContext.request.contextPath }/userpage/ArticelCommentDel';
		postForm.method = "post";
		var useridinput = document.createElement("input");
		useridinput.setAttribute('name', 'cid');
		useridinput.setAttribute('value', id);
		postForm.appendChild(useridinput);
		document.body.appendChild(postForm);
		postForm.submit();
		document.body.removeChild(postForm);
	}
}
  </script>
</html>