<%@page import="cn.arice.com.service.impl.AlbumServiceImpl"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String userid = (String) session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser", user);
	pageContext.setAttribute("listalbum",new AlbumServiceImpl().getAllAlbum());
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
<link href="images/dribble.png" rel="shortcut icon" />

</head>
<script type="text/javascript">
function addalbum() {
		var changmsg = document.getElementById("addalbum");
		if (changmsg.innerHTML == '添加相册') {
			changmsg.innerHTML = '取消添加';
			document.getElementById("addalbumdiv").style.display = 'block';

		} else if (changmsg.innerHTML == '取消添加') {
			changmsg.innerHTML = '添加相册';
			document.getElementById("addalbumdiv").style.display = 'none';
		}
	}
function updatealbum(btndiv,yuandiv,divid,upatebtnid) {
		var changmsg = document.getElementById(upatebtnid);
		if (changmsg.innerHTML == '修改相册信息') {
			changmsg.innerHTML = '取消修改';
			document.getElementById(divid).style.display = 'block';
			document.getElementById(yuandiv).style.display = 'none';
			document.getElementById(btndiv).style.display = 'none';
	
		} else if (changmsg.innerHTML == '取消修改') {
			changmsg.innerHTML = '修改相册信息';
			document.getElementById(divid).style.display = 'none';
			document.getElementById(yuandiv).style.display = 'block';
			document.getElementById(btndiv).style.display = 'block';
		}
	}
</script>
<body>
	<%@include file="header.jsp"%>
	<div class="admin">
		<div class="line-big">
			<div class="panel">
				<div class="panel-head">
					<a class="button border-main" href="javascript:addalbum();"
						id="addalbum" >添加相册</a><br>
					<div style="width: 50%;display: none;" id="addalbumdiv"
						name="addalbumdiv">
						<form
							action="${pageContext.request.contextPath }/userpage/AlbumAdd"
							method="post" class="form-x">
							<div class="form-group">
								<div class="label">
									<label>相册名：</label>
								</div>
								<div class="field">
									<input class="input" name="alname" type="text" maxlength="15"
										placeholder="相册名称" data-validate="required:请填写相册名称">
								</div>
							</div>
							<div class="form-group">
								<div class="label">
									<label>相册描述：</label>
								</div>
								<div class="field">
									<input class="input" name="aldesc" type="text" maxlength="25"
										placeholder="相册描述" data-validate="required:请填写相册描述">
								</div>

								<button class="button bg-main" type="submit" id="btnpwd">确认添加</button>
						</form>
					</div>
				</div>
				<br>
				<table class="table">
					<c:forEach items="${listalbum }" var="album">
							<div class="xm3">
								<div class="panel border-back">
								<a href="${pageContext.request.contextPath }/userpage/ImgSelect?type=analbum&alid=${album.alid}">
									<img src="images/face.jpg" width="100%" /><br />
									<div class="panel-foot bg-back border-back">
										<div id="yuandiv${album.alid }">
										相册名：《${album.alname }》<br> 相册描述：${album.aldesc }<br>
										相册图片数：${album.imgnum }<br>
										<br>
										</div>
										</a>
										<c:if test="${album.alid != 1 }">
											<div style="display: none" id="updatediv${album.alid }">
											<form name="frm_test" action="${pageContext.request.contextPath }/userpage/AlbumUpdate" method="post">
												<div class="form-group">
												<input type="hidden" name="alid" value="${album.alid }"/>
												相册名：<input class="input" maxlength="15" type="text" name="alname" value="${album.alname }" data-validate="required:请填写"/>
												</div>
												<div class="form-group">
												相册描述：<input class="input" maxlength="25" type="text" name="aldesc" value="${album.aldesc }" data-validate="required:请填写"/>
												</div>
												<button class="button button-little bg-main" type="submit" >确认修改</button>
												<a class="button button-little bg-main"  id="updatebtn${album.alid }" href="javascript:updatealbum('btndiv${album.alid }','yuandiv${album.alid }','updatediv${album.alid }','updatebtn${album.alid }')">修改相册信息</a>
											</form>
											</div>
											<div id="btndiv${album.alid }">
												<a class="button button-little bg-main" id="updatebtn${album.alid }"  href="javascript:updatealbum('btndiv${album.alid }','yuandiv${album.alid }','updatediv${album.alid }','updatebtn${album.alid }')">修改相册信息</a>
												<a class="button button-little bg-main" href="javascript:delalbum('${album.alid }','${album.alname }')">删除相册</a>
											</div>
										</c:if>
										<c:if test="${album.alid == 1 }">
											<a class="button button-little bg-gray">默认相册，不能修改</a>
										</c:if>
									</div>
								</div>
							</div> 
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function delalbum(alid,alname){
	if (!confirm("确认删除相册[" + alname + "]吗，相册下所有的图片会转移到默认相册中")) {
		window.event.returnValue = false;
	} else {
		var postForm = document.createElement("form");
		postForm.action = '${pageContext.request.contextPath }/userpage/AlbumDel';
		postForm.method = "post";
		var useridinput = document.createElement("input");
		useridinput.setAttribute('name', 'alid');
		useridinput.setAttribute('value', alid);
		postForm.appendChild(useridinput);
		document.body.appendChild(postForm);
		postForm.submit();
		document.body.removeChild(postForm);
	}

}
</script>

</html>
