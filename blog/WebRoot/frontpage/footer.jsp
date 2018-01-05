<%@page import="cn.arice.com.util.DateHelper"%>
<%@page import="cn.arice.com.util.GetIpAddr"%>
<%@page import="cn.arice.com.bean.VisitBean"%>
<%@page import="cn.arice.com.service.impl.VisitServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ImgServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.arice.com.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
pageContext.setAttribute("listimg", new ImgServiceImpl().getAllImg());
pageContext.setAttribute("user", new UserInfoServiceImpl().getUserInfo());

VisitServiceImpl vsi = new VisitServiceImpl();
if(session.getAttribute("visit") == null){
vsi.addVisit(new VisitBean(null,GetIpAddr.getIpAddr(request),null));
session.setAttribute("visit", 1);
}
pageContext.setAttribute("listvisit",vsi.getAllVisit());
 %>
<div id="footer">
        	<div id="footerwrap">
            	<div class="footerwidgets">
                	<div id="aboutauthor">
                    	<h1 class="title">关于博客网站作者</h1>
                        <span class="widget-border"></span>
                        <ul>
                        	<li><p>${user.introduce }</p></li>
                        	<li><span class="widget-border"></span></li>
                        	<li>网站访问次数：${fn:length(listvisit) }次</li>
                        	<li><span class="widget-border"></span></li>
                        </ul>
                    </div><!--END aboutauthor -->
                    </div><!--END footerwidets-->
                    
                    <div class="footerwidgets">
                    <div id="archives">
                    	<h1 class="title">我的链接</h1>
                        <span class="widget-border"></span>
                        <ul>
                        	<li><a href="http://weibo.com/xxkzai" target="_blank">我的新浪微博</a></li>
                            <li><span class="widget-border"></span></li>
                            <li><a href="http://blog.sina.com.cn/ariceone" target="_blank">我的新浪博客</a></li>
                            <li><span class="widget-border"></span></li>
                            <li><a href="http://git.oschina.net/arice" target="_blank">我的开源中国Git主页</a></li>
                            <li><span class="widget-border"></span></li>
                            
                        </ul>
                    </div><!--END archives-->
                    </div><!--END footerwidets-->
                    
                    <div class="footerwidgets">
                    	<div id="flickr">
                    	<h1 class="title">图片预览</h1>
                        <span class="widget-border "></span>
                        	<ul>
                        		<c:forEach begin="0" end="11" items="${listimg }" var="img">
                            	<li><a href="${pageContext.request.contextPath }/${img.imgurl}" rel="prettyPhoto[foogergallery]" class="gallery"><img src="${pageContext.request.contextPath }/${img.imgurl}" alt="${img.imgdesc }" height="46" width="46" /></a></li>
                            	</c:forEach>
                            </ul>
                         </div><!--END flickr-->
                    </div><!--END footerwidgets-->
                    
                    <div class="footerwidgets">
                    	<div id="archives">
                    	<h1>项目链接</h1>
                        <span class="widget-border"></span>
                            	<!--This empty div is the container to hold the twitter tweets-->
                        <ul>
                        	<li><a href="http://www.arice.ren/chatweb" target="_blank">聊天室</a></li>
                            <li><span class="widget-border"></span></li>
                            <li><a href="http://blog.sina.com.cn/ariceone" target="_blank">我的新浪博客</a></li>
                            <li><span class="widget-border"></span></li>
                            <li><a href="http://git.oschina.net/arice" target="_blank">我的开源中国Git主页</a></li>
                            <li><span class="widget-border"></span></li>
                            
                        </ul>
                        </div><!--END twitterfeed-->
                    </div><!--END footerwidgets-->
                <div class="clear"></div><!--clearing floats so it doesn't mess with footer border-->
            <span id="footer-border"></span>                
                <div id="footer-navigation">
                	<ul>
                    	<li><a href="indexfront.jsp">主页</a></li>
                        <li><a href="album.jsp">相册</a></li>
                        <li><a href="userInfo.jsp">个人档案</a></li>
                        <li><a href="contact.jsp">留言板</a></li>
                        <li><a href="${pageContext.request.contextPath }/adminLogin.jsp">管理员</a></li>
                    </ul>
                </div><!--END footer-navigation-->
                
                <div>
                	<span id="copyright">&copy; Copyright 2015-<%=DateHelper.getYearFormat() %>, Arice blog Powered  by <a href="http://www.arice.ren/">徐新凯</a></span>
                </div><!--END copywrite-->
            </div><!--END footerwrap-->
            <div class="clear"></div>
        </div><!--END footer-->	