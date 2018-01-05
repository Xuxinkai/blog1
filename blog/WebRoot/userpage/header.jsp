<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String url = request.getRequestURI();
String jspname = url.substring(url.lastIndexOf("/")+1, url.length());
pageContext.setAttribute("jspname", jspname,pageContext.PAGE_SCOPE );
%>
<div class="lefter">
    <div class="logo"><a href="index.jsp"><img src="images/logo.png" alt="后台管理系统" width="150px" height="40px"/></a></div>
</div>
<div class="righter nav-navicon" id="admin-nav">
    <div class="mainer">
        <div class="admin-navbar">
            <span class="float-right">
            	<a class="button button-little bg-main" href="${pageContext.request.contextPath }/frontpage/indexfront.jsp" target="_blank">前台首页</a>
                <a class="button button-little bg-yellow" href="${pageContext.request.contextPath }/userpage/logout">注销登录</a>
            </span>
            <ul class="nav nav-inline admin-nav">
                <li <c:if test="${jspname == 'index.jsp' ||jspname == 'history.jsp'}"> class="active"</c:if>><a href="index.jsp" class="icon-home"> 开始</a>
                    <ul>
						<li><a href="fabuarticel.jsp">发布文章</a></li>
						<li><a href="articelmanage.jsp">文章管理</a></li>
						<li><a href="pinglunmanage.jsp">评论管理</a></li>
						<li><a href="${pageContext.request.contextPath }/userpage/LeaveMsgSelect">留言管理</a></li>
						<li><a href="imgmanage.jsp">相册管理</a></li>
						<li><a href="xitongmanage.jsp">系统设置</a></li>
					</ul>
                </li>
                <li <c:if test="${jspname == 'fabuarticel.jsp'}"> class="active"</c:if>><a href="fabuarticel.jsp" class="icon-file-text"> 发布文章</a>
                <ul>
						<li class="active"><a href="#">文章编辑</a></li>
					</ul>
					</li>
                <li <c:if test="${jspname == 'articelmanage.jsp' ||jspname == 'articel.jsp' ||jspname == 'updataarticel.jsp' }"> class="active"</c:if>><a href="articelmanage.jsp" class="icon-file-text"> 文章管理</a>
                <ul>
						<li <c:if test="${jspname == 'articelmanage.jsp'}"> class="active" </c:if>><a href="articelmanage.jsp">文章类别</a></li>
						<li <c:if test="${jspname == 'articel.jsp'||jspname == 'updataarticel.jsp'}"> class="active" </c:if>><a href="${pageContext.request.contextPath }/userpage/ArticelSelect?type=all">文章列表</a></li>
					</ul>
                </li>
                <li <c:if test="${jspname == 'pinglunmanage.jsp'}"> class="active"</c:if>><a href="pinglunmanage.jsp" class="icon-comment"> 评论管理</a>
                <ul>
						<li class="active"><a href="#">查看评论</a></li>
					</ul>
                </li>
                <li <c:if test="${jspname == 'leavemsgmanage.jsp'}"> class="active"</c:if>><a href="LeaveMsgSelect" class="icon-comment"> 留言管理</a>
                	<ul>
						<li class="active"><a href="LeaveMsgSelect">查看留言</a></li>
					</ul>
                </li>
                <li <c:if test="${jspname == 'albummanage.jsp' ||jspname == 'imgmanage.jsp'||jspname == 'imgupload.jsp' ||jspname == 'imgview.jsp'}"> class="active"</c:if>><a href="albummanage.jsp" class="icon-picture-o"> 相册管理</a>
                <ul>
						<li <c:if test="${jspname == 'albummanage.jsp'}"> class="active"</c:if>><a href="albummanage.jsp">相册管理</a></li>
						<li <c:if test="${jspname == 'imgmanage.jsp'||jspname == 'imgview.jsp'}"> class="active"</c:if>><a href="ImgSelect?type=all">图片管理</a></li>
						<li <c:if test="${jspname == 'imgupload.jsp'}"> class="active"</c:if>><a href="imgupload.jsp">上传图片</a></li>
					</ul>
                </li>
                <li <c:if test="${jspname == 'xitongmanage.jsp'}"> class="active"</c:if>><a href="xitongmanage.jsp" class="icon-cog"> 系统设置</a>
                <ul>
					<li class="active"><a href="#">系统设置</a></li>
				</ul>
                </li>
            </ul>
        </div>
        <div class="admin-bread">
            <span>您好，${loginuser.realname }，欢迎您的光临。</span>
            <ul class="bread">
                <li><a href="index.jsp" class="icon-home"> 开始</a></li>
                <c:if test="${jspname == 'index.jsp'}"><li><a href="index.jsp">后台首页</a></li></c:if>
                <c:if test="${jspname == 'leavemsgmanage.jsp'}"><li><a href="LeaveMsgSelect">留言管理</a></li></c:if>
                <c:if test="${jspname == 'fabuarticel.jsp'}"><li><a href="fabuarticel.jsp">发布文章</a></li></c:if>
                <c:if test="${jspname == 'xitongmanage.jsp'}"><li><a href="xitongmanage.jsp">系统管理</a></li></c:if>
                <c:if test="${jspname == 'albummanage.jsp'}"><li><a href="albummanage.jsp">相册管理</a></li></c:if>
                <c:if test="${jspname == 'pinglunmanage.jsp'}"><li><a href="pinglunmanage.jsp">评论管理</a></li></c:if>
                <c:if test="${jspname == 'articelmanage.jsp'}"><li><a href="articelmanage.jsp">文章管理</a></li></c:if>
                <c:if test="${jspname == 'history.jsp'}"><li><a href="index.jsp">后台首页</a></li><li><a href="LoginHistory">登录历史</a></li></c:if>
            	<c:if test="${jspname == 'articel.jsp'}"><li><a href="articelmanage.jsp">文章管理</a></li><li><a href="${pageContext.request.contextPath }/userpage/ArticelSelect?type=all">文章列表</a></li></c:if>
            	<c:if test="${jspname == 'updataarticel.jsp'}"><li><a href="articelmanage.jsp">文章管理</a></li><li><a href="${pageContext.request.contextPath }/userpage/ArticelSelect?type=all">文章列表</a></li><li>文章查看与修改</li></c:if>
            	<c:if test="${jspname == 'imgmanage.jsp'}"> <li><a href="albummanage.jsp">相册管理</a></li><li><a href="${pageContext.request.contextPath }/userpage/ImgSelect?type=all">图片管理</a></li></c:if>
            	<c:if test="${jspname == 'imgupload.jsp'}"> <li><a href="albummanage.jsp">相册管理</a></li><li><a href="imgupload.jsp">上传图片</a></li></c:if>
            	<c:if test="${jspname == 'imgview.jsp'}"> <li><a href="albummanage.jsp">相册管理</a></li><li><a href="${pageContext.request.contextPath }/userpage/ImgSelect?type=all">图片管理</a></li><li><a href="${pageContext.request.contextPath }/userpage/imgview.jsp">查看修改</a></li></c:if>
            </ul>
        </div>
    </div>
</div>
