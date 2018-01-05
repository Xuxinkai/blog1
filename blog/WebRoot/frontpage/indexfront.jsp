<%@page import="cn.arice.com.bean.ArticleCommentBean"%>
<%@page import="cn.arice.com.service.impl.ArticelCommentServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.arice.com.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.arice.com.service.impl.ArticelServiceImpl"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
pageContext.setAttribute("allarticel", new ArticelServiceImpl().getAllArticle());
pageContext.setAttribute("articletypes",new ArticelTypeServiceImpl().getAllArticelType());
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width"/>
<title>徐新凯个人博客</title>
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
            	<ul class="pageing">
                <!--li>
            	<div class="post">
            		<h1 class="title">有图片的博客</h1>
                    <div class="meta">
                    	<ul >
                        	<li class="admin"><a href="userInfo.jsp">徐新凯</a></li>
                            <li class="date">November 21, 2012</li>
                            <li class="category"><a href="#">计算机种类</a></li>
                            <li class="comments"><a href="#">0 评论</a></li>
                        </ul>
                    </div><!--end meta
                    
                    <span class="main-border"></span>
                     <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                    <img class="post-image" src="images/post-image.jpg" alt="post image" height="214" width="609" />
                    
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                    <a class="read-more" href="#">Read More</a>
                    <div class="clear"></div>
  				</div><!--END post
                </li>-->
                
                <c:forEach items="${ allarticel}" var="articel">
                <li>
                
                <div class="post">
            		<h1 class="title"><a href="${pageContext.request.contextPath }/frontpage/ArticelView.jsp?aid=${articel.aid}">${articel.title }</a></h1>
                    <div class="meta">
                        <ul>
                        	<li class="admin"><a href="userInfo.jsp">${articel.author }</a></li>
                            <li class="date">${articel.time }</li>
                            <li class="category">
	                            <a href="#">
	                              <c:forEach items="${articletypes}" var="at">
					              <c:if test="${articel.tid==at.tid }"> ${at.tname }</c:if>
					              </c:forEach>
					             </a>
				            </li>
                            <li class="readtime"><a href="#" style="color: red"> ${articel.scantime }</a>阅读</li>
                            <li class="comments"><a href="#" style="color: red">${articel.comments } </a>评论</li>
                           
                        </ul>
                    </div><!--end meta-->
                    <p>
                    	<a href="${pageContext.request.contextPath }/frontpage/ArticelView.jsp?aid=${articel.aid}">
                    	<div style="height: 160px; overflow:  hidden;text-overflow:  ellipsis; -o-text-overflow: ellipsis;">${articel.content }</div>
                    	</a>
		            </p>
                     <a class="read-more" href="${pageContext.request.contextPath }/frontpage/ArticelView.jsp?aid=${articel.aid}">Read more</a>
  				 <div class="clear"></div>
  				 <span class="main-border"></span>
  				</div><!--END post-->
                </li>
                </c:forEach>
                </ul>
                
                <div class="Pagination"></div>
                <div class="clear"></div>
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
