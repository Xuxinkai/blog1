<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.com.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.arice.com.service.impl.ArticelServiceImpl"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
pageContext.setAttribute("articletypes",new ArticelTypeServiceImpl().getAllArticelType());
 %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="${ab.title },徐新凯个人博客,个人博客">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0"/>
<title>${ab.title }-徐新凯个人博客</title>

<link href="css/main.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/trimpath-template-1.0.38.min.js"></script>
<script type="text/javascript" src="js/common.min.js"></script>

</head>

<body>
<div class="box">
	<div class="header">
		<div onClick="gohome()" class="header_left">
			<img src="images/logo.png" height="38" />
		</div>
		<div class="header_right"><a href="#">···</a>
		</div>
	</div>
	<div class="news_t">${ab.title }</div>
	<div class="news_t1"> 
	<span> 
	<c:forEach items="${articletypes}" var="at">
		<c:if test="${ab.tid==at.tid }"><a href="#">【${at.tname}】</a></c:if>
	</c:forEach>
	</span>
	<span>${ab.time }</span>
	<span>${ab.author }</span>
	<div id="div_reviewcount" class="news_t1_plun">${ab.comments }</div>
	</div>
	<div id="content" class="news">
		${ab.content }
	</div>
	<script type="text/javascript">
		if (getCookie("fontsize") != null) setFontSize(getCookie("fontsize"));
		else setFontSize(18);
	</script>
	
	<div id="div_relatednews" class="news_xg"></div>
	<div class="news_plun ">
		<div class="news_plun_left news_plun2"> <a id="a_comments1"  href="javascript:;"
			class="currtab">最新评论</a>
		</div>
	</div>
<div id="MyComments">
<c:if test="${empty acbs}"> 还没有评论哦，快来给这篇文章评论一个吧。</c:if>
<c:forEach items="${acbs }" var="acb" begin="0" end="3">
<div class="news_list"> <a href="#">${acb.content }</a>
	<br />
	<div class="news_list_t">
		<div class="left">${acb.cuser }｜</div>
		<div class="left">${acb.ctime }</div>
		<!--  div class="right"><span>22</span><a href="#"><img src="images/ico_plun.png" alt="" width="17" height="17" /></a>
	</div>-->
</div>
</div>
</c:forEach>
<div id="displayDiv" style="display: none;">
<c:forEach items="${acbs }" var="acb" begin="4" >
<div class="news_list"> <a href="#">${acb.content }</a>
	<br />
	<div class="news_list_t">
		<div class="left">${acb.cuser }｜</div>
		<div class="left">${acb.ctime }</div>
		<!--  div class="right"><span>22</span><a href="#"><img src="images/ico_plun.png" alt="" width="17" height="17" /></a>
	</div>-->
</div>
</div>
</c:forEach>
</div>
</div>
	
	<div id="div_seeall" onClick="showOtherComment()" class="ck_all">查看所有<span id="span_reviewcount">${ab.comments }</span>条评论</div>
	
	<div id="div_reply_0"></div>
	<div id="div_reply_0">
	<form class="contact_form" action="${pageContext.request.contextPath }/blog_wap/ArticleViewServlet" method="post" name="comment_form" id="comment_form">
	<input type="hidden" value="${ab.aid }" name = "aid"/>
	<span>给这篇文章评论吧!</span>
		<div style="padding-top: 5px;">
			<div class="plun_input">
				<span>姓名:</span>
				<input type="text" id="name" name="name" placeholder="你的大名哦" maxlength="15" />
			</div>
			<div class="plunxx_center1">
			<textarea name="message" id="message" cols="45" rows="5" class="plun_login_textarea"></textarea>
			</div>
			<div class="plun_bt_tj_button">
			<div style="float:left;width:200px;">
			</div>
			<input type="button" name="btnlogin" id="btnlogin" value="发表评论" onclick="checkSubmit()" class="button_style1">	
			</div>
		</div>
		</form>
	</div>
	<div class="footer">
	<%@ include file="foot.jsp" %>
	</div>
	<script type="text/javascript" src="js/jia.js" charset="utf-8"></script>
	<script type="text/javascript">
	function checkSubmit(){
		var name = document.getElementById("name").value;
		var message = document.getElementById("message").value;
		if(name != "" && message != ""){
			document.getElementById("comment_form").submit();
		}else{
			alert("请填写完整的信息！");
		}
	}
	function showOtherComment(){
		$("#displayDiv").show(); 
		$("#div_seeall").hide();
	}
	</script>
</div>
</body>

</html>
