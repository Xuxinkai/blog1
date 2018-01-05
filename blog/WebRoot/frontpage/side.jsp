<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@page import="cn.arice.com.service.impl.LeaveMsgServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ArticelServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.arice.com.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
pageContext.setAttribute("fivearticel", new ArticelServiceImpl().getArticelFive());
pageContext.setAttribute("leavemsgs", new LeaveMsgServiceImpl().getAllLeaveMsg());
pageContext.setAttribute("ats", new ArticelTypeServiceImpl().getAllArticelType());
 %>
<div id="side">
    	<div id="sidebar-header">
        	<div id="header">
            	<a href="indexfront.jsp"><span id="logo">arice<img src="images/period.png" alt="period" height="8" width="9" /></span></a>
            </div><!--END header-->
            <span class="border"></span>
           </div><!--END sidebar-header-->
           
           <div id="sidebar-widgets">
           
           <div class="widget recentposts">
           	<h3>最新博文</h3>
           	<c:forEach items="${fivearticel}" var="fa">
           		<ul>
            		<li class="thumb"><img src="images/articlelog.png" alt="toons" height="61" width="57" /></li>
               		<li><span class="title"><a href="${pageContext.request.contextPath }/frontpage/ArticelView.jsp?aid=${fa.aid}">${fa.title }</a></span></li>
                	<li><span class="date">By <a href="userInfo.jsp">${fa.author }</a><br>${fa.time }</span></li>
                </ul>
            <span class="widget-border"></span>
           	</c:forEach>
           </div><!--END widget-->
           
           <div class="widget recentposts">
           	<h3>博文分类</h3>
           	<c:forEach items="${ats}" var="at">
           		<ul><a href="${pageContext.request.contextPath }/frontpage/articellistbytype.jsp?tid=${at.tid }">
            		<li class="thumb"><img src="images/booktubiao.png" alt="toons" height="61" width="57" /></li>
               		<li><span class="title">${at.tname }</span></li>
                	<li><span class="title">${at.tdesc }<br>共有 ${at.anum }篇文章</span></li>
                	</a>
                </ul>
            <span class="widget-border"></span>
           	</c:forEach>
           </div><!--END widget-->
           
           <div class="widget">
           	<h3>最新留言</h3>
            
            <ul>
            <c:forEach items="${ leavemsgs}" var="lm" begin="0" end="4">
            	<li><span class="title"><a href="contact.jsp">${lm.lmcontent }</a></span></li>
                <li><span class="date">By <a href="contact.jsp">${lm.lmname }</a><br>DATE:${lm.lmtime }</span></li>
            	<li><span class="widget-border"></span></li>
            
            	</c:forEach>
            </ul>
            
           </div><!--END widget-->
     </div><!--END sidebar-widgets-->
</div><!--END Side--><!--This div keeps the sidebar from floating right when the main content is empty-->