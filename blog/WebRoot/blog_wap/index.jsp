<%@page import="cn.arice.com.service.impl.ImgServiceImpl"%>
<%@page import="cn.arice.com.bean.ArticleCommentBean"%>
<%@page import="cn.arice.com.service.impl.ArticelCommentServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.com.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.arice.com.service.impl.ArticelServiceImpl"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
pageContext.setAttribute("allimg", new ImgServiceImpl().getAllImg());
pageContext.setAttribute("allarticel", new ArticelServiceImpl().getAllArticle());
pageContext.setAttribute("articletypes",new ArticelTypeServiceImpl().getAllArticelType());
 %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0"/>
<meta name="keywords" content="博客，徐新凯，徐新凯的个人微博"/>
<meta name="description" content="徐新凯的个人微博"/>
<link href="css/main.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/trimpath-template-1.0.38.min.js"></script>
<script type="text/javascript" src="js/common.min.js"></script>
<link rel="apple-touch-icon-precomposed" href="images/icons.png" />
<title>徐新凯个人微博</title>
</head>

<body>
<div class="box">
	<div class="header">
		<div class="header_left">
			<img src="images/logo.png" height="38" />
		</div>
		<div class="header_right"><a href="#">··· ···</a></div>
	</div>
	<div class="menu"> 
		<span class="menu1">主页</span> 
		<a href="#">分类</a> 
		<a href="#">相册</a>  
		<a href="#">个人</a>  
		<a href="#">留言</a>
	</div>
	<!-- start 图片跑马灯 -->
<div class="banner1">
	<div id='mySwipe' style='margin: 0 auto' class='swipe'>
		<div class='swipe-wrap'>
		<c:forEach items="${allimg }" var="img" begin="0" end="5">
		<div>
			<a href="#"><img src="${pageContext.request.contextPath }/${img.imgurl}" width="100%" height="200px"/></a> 
				<div class="mySwipeceng">
					<div class="left">${img.imgdesc}</div>
					<div class="right" style="height: 26px;">图片预览</div>
				</div>
		</div>
		</c:forEach>
		</div>
	</div>
</div>
<!-- end 图片跑马灯 -->
<!-- start 无图片博文列表 -->
<c:forEach items="${ allarticel}" var="articel">
<div class="news_list"> 
<c:forEach items="${articletypes}" var="at">
	<c:if test="${articel.tid==at.tid }">【${at.tname }】</c:if>
</c:forEach>
<a href="${pageContext.request.contextPath }/blog_wap/ArticleViewServlet?aid=${articel.aid}">${articel.title }</a>
	<br />
	<div class="news_list_t">
		<div class="left">${articel.author } ｜</div>
		<div class="left">${articel.time }</div>
		<div class="right">
		<span>${articel.comments }</span><a href="#"><img src="images/ico_plun.png" alt="" width="17" height="17" /></a>
		<span>${articel.scantime }</span><a href="#"><img src="images/readbook.png" alt="" width="17" height="17" /></a>
		</div>
	</div>
</div>
</c:forEach>
<!-- end 无图片博文列表 -->
<!-- start 有图片博文列表 
<div class="banner2">
	<ul>
		<li><a href="#"><img src="http://news.mydrivers.com/Img/20140221/title_173338081.jpg" width="140" height="105" /><span>触目惊心 揭秘iPhone翻新全过程</span></a>
		</li>
		<li><a href="#"><img src="http://news.mydrivers.com/Img/20140221/title_173118413.jpg" width="140" height="105" /><span>东芝消费级5TB硬盘突然上市 真便宜</span></a>
		</li>
	</ul>
</div>
<div class="news_list"> <a href="#">魔兽6.0重磅试玩剧透！</a>
	<br />
	<div class="news_list_t">
		<div class="left">小路 ｜</div>
		<div class="left">4小时前</div>
		<div class="right"><span>22</span><a href="#"><img src="images/ico_plun.png" alt="" width="17" height="17" /></a>
		</div>
	</div>
</div>
 end 有图片博文列表 -->
<!-- 
<div class="nextpager"><a href="#">【下一页】</a>
</div> -->
<div class="footer"> 
<%@ include file="foot.jsp" %>
</div>
</div>
<script type="text/javascript" src="js/swipe.min.js"></script>
<script type="text/javascript">
	var elem = document.getElementById('mySwipe');
	window.mySwipe = Swipe(elem, {
		startSlide: 0,
		auto: 3000,
		continuous: true,
		disableScroll: true,
		stopPropagation: true,
		callback: function (index, element) {},
		transitionEnd: function (index, element) {}
	});
</script>
</body>

</html>
