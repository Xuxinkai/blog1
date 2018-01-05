<%@page import="cn.arice.com.service.impl.LeaveMsgServiceImpl"%>
<%@page import="cn.arice.com.service.LeaveMsgService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>徐新凯个人博客后台管理-留言管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    <link type="text/css" rel="stylesheet" href="css/showBo.css" />
	<script type="text/javascript" src="js/showBo.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />
</head>
  <%
	String userid =  (String)session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser",user);
	pageContext.setAttribute("lmunlook",new LeaveMsgServiceImpl().getNotLookLMCount());
	pageContext.setAttribute("lmcount",new LeaveMsgServiceImpl().getLMCount());
 %>
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
<script type="text/javascript">
   function sub(a){
   var arrSon = document.getElementsByName("chkSon");
   var form1 = document.getElementById("form1");
   var count = 0;
    for(var i=0; i<arrSon.length; i++) {
     if(arrSon[i].checked) {
     	count = count + 1;
     	}
 	}
 	if(count == 0){
 	Showbo.Msg.alert("您没有选中任何选项，请选择后再进行操作");
 	return;
 	}else{
 	if(a == 2){
   	form1.action='${pageContext.request.contextPath }/userpage/LeaveMsgSetIsLook?geshu=2';
   	form1.submit() ;
   }else if(a == 1){
   	form1.action='${pageContext.request.contextPath }/userpage/LeaveMsgDelete?geshu=2';
   	form1.submit() ;
   } 
 	}
   
   
   }
</script>
<body>
<%@include file="header.jsp" %>
<div class="admin">
	<div class="line-big">
        <div class="xm9" style="width: 100%">
         <div class="panel" id="hisdiv">
         <form name="form1" id="form1" method="post">
            <div class="panel-head">
            
            	<strong>留言列表</strong> &nbsp;
            	
	            <a href="javascript:sub(1)" class="button button-little bg-main">删除</a>&nbsp;
	            <a href="javascript:sub(2)" class="button button-little bg-main">设置为已阅读</a>
	            <span>-----</span>
	            <span class="button button-little bg-gray">全部留言&nbsp;${lmcount}</span>&nbsp;
            	<span class="button button-little bg-gray">已阅读&nbsp;${lmcount -lmunlook }</span>&nbsp; 
	            <span class="button button-little bg-gray">未阅读&nbsp;${lmunlook }</span>
            </div>
             <table class="table">
                	<tr>
                		<td width="5%"><input type="checkbox" name="chkAll" id="chkAll" onClick="ChkAllClick('chkSon','chkAll')" ></td>
	                	<td width="10%">留言编号</td>
	                	<td width="10%">姓名</td>
	                	<td width="15%">邮箱</td>
	                	<td width="25%">留言内容</td>
	                	<td width="15%">留言时间</td>
	                	<td width="10%">留言IP</td>
	                	<td width="5%">状态</td>
	                	<td width="5%">操作</td>
                	</tr>
                	<c:forEach var="msg" items="${pageBean.dataList}" varStatus="stat">
                	<tr class="history">
                		<td><input type="checkbox" value="${msg.lmid}" name="chkSon" id="chkSon${stat.count }" onclick="ChkSonClick('chkSon','chkAll')"  ></td>
                		<td>${msg.lmid}</td>
	                	<td>${msg.lmname }</td>
	                	<td>${msg.lmemail }</td>
	                	<c:if test="${fn:length(msg.lmcontent)>18}">
	                	<td><a href="#" onclick="Showbo.Msg.alert('${msg.lmcontent}')">${fn:substring(msg.lmcontent,0,18)}... ...</a></td>
	                	</c:if>
	                	<c:if test="${fn:length(msg.lmcontent)<18}">
	                	<td><a href="#" onclick="Showbo.Msg.alert('${msg.lmcontent}')">${msg.lmcontent }</a></td>
	                	</c:if>
	                	
	                	<td>${msg.lmtime}</td>
	                	<td>${msg.lmip }</td>
	                	<td>
	                	<c:if test="${msg.islook == 0}">
	                	<a href="${pageContext.request.contextPath }/userpage/LeaveMsgSetIsLook?geshu=1&id=${msg.lmid}" class="float-right badge bg-red">未阅读</a>
	                	</c:if>
	                	<c:if test="${msg.islook == 1}">
	                	<span class="float-right badge bg-main" >已阅读</span>
	                	</c:if>
	                	
	                	</td>
	                	<td>
	                		<a href="javascript:delCheck('${msg.lmid}')" class="button button-little bg-main">删除</a>
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
                	</form>
            </div>
      </div>
   </div>
</div>
  </body>
  <script type="text/javascript">
  function delCheck(id) {
	if (!confirm("确认删除[" + id + "]吗")) {
		window.event.returnValue = false;
	} else {
		var postForm = document.createElement("form");
		postForm.action = '${pageContext.request.contextPath }/userpage/LeaveMsgDelete?geshu=1';
		postForm.method = "post";
		var useridinput = document.createElement("input");
		useridinput.setAttribute('name', 'lmid');
		useridinput.setAttribute('value', id);
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
