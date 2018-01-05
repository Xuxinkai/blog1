<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.arice.com.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.arice.com.service.impl.ArticelServiceImpl"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
pageContext.setAttribute("articletypes",new ArticelTypeServiceImpl().getAllArticelType());
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>徐新凯个人博客</title>
<meta name="keywords" content="${ab.title },徐新凯个人博客,个人博客">
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script><!--Needed for the prettyPhoto to function-->
<script type="text/javascript" src="js/simplepager.js"></script><!--runs the pagination-->
<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet" charset="utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function() {
	$('span.category').hover(function(){
    $(this).next().css('background-color','#e25050');
    },function(){
    $(this).next().css('background-color','#393939');
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
                <li><a class="active" href="indexfront.jsp">主页</a></li> 
                <li><a href="album.jsp">相册</a></li>
                <li><a href="userInfo.jsp">个人档案</a></li>
                <li><a href="contact.jsp">留言板</a></li>
            </ul>
        </div><!--END navigation-->
            <div id="main-content">
	            <div id="post-page">                    
	                    <div class="post">
		            		<h1 class="title">${ab.title }</h1>
		                    <div class="meta">
		                    	<ul >
		                        	<li class="admin"><a href="userInfo.jsp">${ab.author }</a></li>
		                            <li class="date">${ab.time }</li>
		                            <li class="category"><a href="#">
		                            <c:forEach items="${articletypes}" var="at">
						              <c:if test="${ab.tid==at.tid }"> ${at.tname }</c:if>
						              </c:forEach></a></li>
		                            <li class="readtime"><a href="#" style="color: red"> ${ab.scantime }</a>阅读</li>
                           			<li class="comments"><a href="#" style="color: red">${ab.comments } </a>评论</li>
		                        </ul>
		                    </div><!--end meta-->
		                    <span class="main-border"></span>
		                    ${ab.content }
						 <span class="main-border"></span>
						 <div class="comment-meta">
							 <ul>
							 <li><a href="indexfront.jsp" >返回列表</a></li>
							 </ul>
						 </div>
						 <span class="main-border"></span>
						 <!-- start 查看评论区 -->
                    <h1 id="commenth1">一些评论</h1>
                    <c:if test="${empty acbs}"> 还没有评论哦，快来给这篇文章评论一个吧。</c:if>
                    <c:forEach items="${acbs }" var="acb" begin="0" end="3">
	                    <div class="user-comment">
	                    	<div class="avatar"><img src="images/pinglun.png" alt="avatar" height="51" width="51" /></div>
	                        <div class="comment-meta">
	                        	<ul>
	                            	<li class="comment-author">${acb.cuser },</li>
	                                <li class="comment-date">${acb.ctime }  </li>
	                            </ul>
	                        </div><!--END comment-meta-->
	                        <p>${acb.content }</p>
	                        <div class="clear"></div>
	                    </div><!--END user-comment-->
                    </c:forEach>
                    <span class="main-border"></span>
                    <!-- end 查看评论区 -->
                    
                    <h1 id="commenth1">给这篇文章评论吧</h1>
	                     <form class="contact_form" action="${pageContext.request.contextPath }/frontpage/ArticelView.jsp" method="post" name="comment_form">
		                    <ul>
		                        <input type="hidden" value="${ab.aid }" name = "aid"/>
		                        <li>
		                            <label for="name">姓名</label>
		                            <input type="text" id="name" name="name" placeholder="你的大名哦" maxlength="15" required />
		                        </li>
		                        <li>
		                            <textarea name="message" cols="40" rows="6" maxlength="120"  required ></textarea>
		                        </li>
		                        <li>
		                            <button class="submit" type="submit">确认评论</button>
		                        </li>
		                    </ul>
	                	</form>	
	             </div><!--END post-->
	            </div>
            </div><!--END main-content-->
        </div><!--END main-->
        <!-- start side -->
        
        <div id="side">
        <%@ include file="side.jsp" %>
        </div>
		<!-- end side -->
		
        <div class="clear"></div>
        <div class="push"></div>
    </div><!--End wrapper-->
    
	<!-- Start Footer -->
	<%@ include file="footer.jsp" %>
	<!-- End Footer -->
	
<script src="js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>
         <script type="text/javascript" charset="utf-8">
  $(document).ready(function(){
    $("a[rel^='prettyPhoto']").prettyPhoto();
  });
</script>
<div style="display:none"></div>
  </body>
</html>
            