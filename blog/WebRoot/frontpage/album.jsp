<%@page import="cn.arice.com.service.impl.AlbumServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.arice.com.util.*"
	contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
pageContext.setAttribute("listalbum", new AlbumServiceImpl().getAllAlbum());

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>徐新凯个人博客</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<!--Needed for the prettyPhoto to function-->
<script type="text/javascript" src="js/simplepager.js"></script>
<!--runs the pagination-->
<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css"
	media="screen" title="prettyPhoto main stylesheet" charset="utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(document).ready(function() {
		$('span.category').hover(function() {
			$(this).next().css('background-color', '#e25050');
		}, function() {
			$(this).next().css('background-color', '#393939');
		});

		$(".pageing").quickPager({
			pageSize : 5,
		});
	});
</script>

<link href="images/dribble.png" rel="shortcut icon" />
</head>

<body>
	<div id="wrapper">

		<div id="main">
			<div id="navigation">
				<ul>
					<li><a href="indexfront.jsp">主页</a>
					</li>
					<li><a class="active"  href="album.jsp">相册</a>
					</li>
					<li><a href="userInfo.jsp">个人档案</a>
					</li>
					<li><a href="contact.jsp">留言板</a>
					</li>
				</ul>
			</div>
			<!--END navigation-->
			<div id="main-content">
				<div id="gallery-page">
            		<h1>相册列表</h1>
                    
                    <span class="main-border"></span>
                    
                    <ul id="filter">
                    	<li>相册:</li>
                    	<c:forEach items="${listalbum }" var="album">
                        <li><a href="imgview.jsp?alid=${album.alid }" title="${album.aldesc }">${album.alname }</a></li>
                        </c:forEach>
                    </ul>
                    <div id="gallery-wrapper">
                    	<ul id="gallery">    
                    	<c:forEach items="${listalbum }" var="album">                    	
                        	<li class="gallery-item">
	                        	<a href="imgview.jsp?alid=${album.alid }" >
	                        		<img src="images/album.png" height="150px" width="150px" title="${album.aldesc }"/>
	                        		<br>《${album.alname }》&nbsp;&nbsp;&nbsp;${album.imgnum }张图片
	                        	</a>
                        	</li>
                            </c:forEach>
                        </ul>
                        <div class="clear"></div>
						<div class="Pagination"></div>
                 <div class="clear"></div>
                    </div><!--END gallery-wrapper-->
				</div><!--END gallery-page-->
			
			</div>
			<!--END main-content-->
		</div>
		<!--END main-->
		<!-- start side -->

		<div id="side">
			<%@ include file="side.jsp"%>
		</div>
		<!-- end side -->

		<div class="clear"></div>
		<div class="push"></div>
	</div>
	<!--End wrapper-->

	<!-- Start Footer -->
	<%@ include file="footer.jsp"%>
	<!-- End Footer -->

	<script src="js/jquery.prettyPhoto.js" type="text/javascript"
		charset="utf-8"></script>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$("a[rel^='prettyPhoto']").prettyPhoto();
		});
	</script>
	<div style="display:none"></div>
</body>
</html>