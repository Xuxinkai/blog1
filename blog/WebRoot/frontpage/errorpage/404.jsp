<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>404</title>
		<link href="${pageContext.request.contextPath }/frontpage/errorpage/css/style.css" rel="stylesheet" type="text/css"  media="all" />
	<link href="${pageContext.request.contextPath }/frontpage/errorpage/images/dribble.png" rel="shortcut icon" />
	</head>
	<body>
		<!--start-wrap--->
		<div class="wrap">
			<!---start-header---->
				<div class="header">
					<div class="logo">
						<h1><a href="${pageContext.request.contextPath }/frontpage/indexfront.jsp">徐新凯个人博客</a></h1>
					</div>
				</div>
			<!---End-header---->
			<!--start-content------>
			<div class="content">
				<img src="${pageContext.request.contextPath }/frontpage/errorpage/images/error-img.png" title="error" />
				<p><span><label>O</label>hh.....</span>很抱歉，您想要的页面我们这里没有...</p>
				<a href="${pageContext.request.contextPath }/frontpage/indexfront.jsp">返回我的主页吧</a>
				<div class="copy-right">
					<p>&copy; Copyright 2016, Arice blog Powered  by <a href="http://www.arice.ren/">徐新凯</a></p>
				</div>
   			</div>
			<!--End-Cotent------>
		</div>
		<!--End-wrap--->
	</body>
</html>

