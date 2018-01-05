<%@page import="cn.arice.com.service.impl.AlbumServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ImgServiceImpl"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String userid = (String) session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser", user);
	pageContext.setAttribute("listalbum",
			new AlbumServiceImpl().getAllAlbum());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>徐新凯个人博客后台管理-图片管理</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/respond.js"></script>
<script src="js/admin.js"></script>
<script type="text/javascript" src="js/simplepager.js"></script><!--runs the pagination-->
<link href="images/dribble.png" rel="shortcut icon" />

</head>

<body>
	<%@include file="header.jsp"%>
	<div class="admin">
		<div class="line-big">
			<div class="xm9" style="width: 100%">
				<form method="post" action="${pageContext.request.contextPath }/userpage/ImgDel?type=2">
					<div class="panel admin-panel">
						<div class="panel-head">
							<strong>内容列表</strong>
						</div>
						<div class="padding border-bottom">
							<input type="button" class="button button-small checkall" name="checkall" checkfor="cboximgid" value="全选" /> 
							<a href="imgupload.jsp" class="button button-small border-green">添加图片</a>
							<input type="submit" class="button button-small border-yellow" value="批量删除" /> 
								<select onchange="mbar(this)" name="select">
								<option value="${pageContext.request.contextPath }/userpage/ImgSelect?type=all"
									<c:if test="${alid==0 }"> selected='selected'</c:if>>全部图片</option>
								<c:forEach items="${listalbum }" var="album">
									<option
										value="${pageContext.request.contextPath }/userpage/ImgSelect?type=analbum&alid=${album.alid}"
										<c:if test="${alid==album.alid }"> selected='selected'</c:if>>${album.alname}</option>
								</c:forEach>
							</select>${fn:length(listimg) }张图片
						</div>
						<table class="table table-hover">
							<tr>
								<td width="5%">选择</td>
								<td width="15%">图片</td>
								<td width="10%">所属相册</td>
								<td width="15%">图片url</td>
								<td width="20%">描述</td>
								<td width="10%">照片大小</td>
								<td width="20%">上传时间</td>
								<td width="5%">操作</td>
							</tr>
							<c:forEach items="${listimg }" var="img">
								<tr>
									<td><input type="checkbox" name="cboximgid" value="${img.imgid }" /></td>
									<td><img src="${pageContext.request.contextPath }/${img.imgurl }" height="40px"/></td>
									<td><c:forEach items="${listalbum }" var="album">
											<c:if test="${album.alid == img.alid }">${album.alname }</c:if>
										</c:forEach></td>
									<td><a target="_blank" href="${pageContext.request.contextPath }/${img.imgurl }">${img.imgurl}</a>
									</td>
									<td>${img.imgdesc }</td>
									<td>${img.imginfo }</td>
									<td>${img.uptime }</td>
									<td><a class="button border-blue button-little" href="imgview.jsp?imgid=${img.imgid }">查看<br>修改</a>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function mbar(sobj) {
		var docurl = sobj.options[sobj.selectedIndex].value;
		if (docurl != "") {
			window.location.href = docurl;
		}
	}
</script>
</html>