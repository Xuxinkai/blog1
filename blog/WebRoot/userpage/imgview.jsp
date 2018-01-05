<%@page import="cn.arice.com.service.impl.AlbumServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ImgServiceImpl"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String userid =  (String)session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser",user);
	String imgid = "";
	if(request.getParameter("imgid") == null){
		imgid = "";
	}else{
		imgid = request.getParameter("imgid");
	}
	pageContext.setAttribute("img", new ImgServiceImpl().getImgByImgid(imgid));
	pageContext.setAttribute("listalbum", new AlbumServiceImpl().getAllAlbum());
 %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>徐新凯个人博客后台管理-系统管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />
</head>
  
  <body>
    <%@include file="header.jsp" %>
<div class="admin">
	<div class="line-big">
        <div class="xm9" style="width: 100%">
        <c:if test="${img != null }">
        <div style="width: 50%;margin-left: auto;margin-right: auto;float: none;">
         <form name="frm_test"
					action="${pageContext.request.contextPath}/userpage/ImgUpdate"
					method="post">
					<input type="hidden" name="imgid" value="${img.imgid }"/>
        <table class="table">
        <tr><td colspan="2"><img title="${img.imgdesc }" src="${pageContext.request.contextPath }/${img.imgurl}" width="100%"></td><tr>
        <tr>
        <td>图片名称：</td>
        <td>${img.imgname }</td></tr>
        <tr>
        <td>所在相册：</td>
        <td>
        	<div class="form-group"> 
        	<select name="alid">
        		<c:forEach items="${listalbum }" var="album">
        		<option value="${album.alid }" <c:if test="${album.alid == img.alid }"> selected="selected" </c:if>>${album.alname }</option>
        		</c:forEach>
        	</select>	
        	</div>
        </td>
        </tr>
        <tr>
        <td>图片描述</td>
        <td><div class="form-group"><input type="text" name="imgdesc" class="input" value="${img.imgdesc }" placeholder="图片描述" data-validate="required:请填写对照片的描述"/></div></td>
        </tr>
        <tr>
        	<td><a href="javascript:delimg('${img.imgid}')" class="button bg-main"  >删除该照片</a></td>
        	<td><input type="submit" name="submit"  class="button bg-main" value="确认修改" /></td>
        </tr>
        </table>
        </form>
        </div>
        </c:if>
    </div>
</div>
  </body>
  <script type="text/javascript">
function delimg(imgid) {
  if (!confirm("确认删除图片[" + imgid + "]吗")) {
		window.event.returnValue = false;
	} else {
		var postForm = document.createElement("form");
		postForm.action = '${pageContext.request.contextPath }/userpage/ImgDel?type=1';
		postForm.method = "post";
		var useridinput = document.createElement("input");
		useridinput.setAttribute('name', 'imgid');
		useridinput.setAttribute('value', imgid);
		postForm.appendChild(useridinput);
		document.body.appendChild(postForm);
		postForm.submit();
		document.body.removeChild(postForm);
		}
	
}
</script>
</html>