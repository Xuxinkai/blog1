<%@page import="cn.arice.com.util.DateHelper"%>
<%@page import="cn.arice.com.service.impl.ArticelTypeServiceImpl"%>
<%@page import="cn.arice.com.service.ArticelTypeService"%>

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
	ArticelTypeService ats = new ArticelTypeServiceImpl();
	pageContext.setAttribute("articeltypes",ats.getAllArticelType());
 %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>徐新凯个人博客后台管理-发布文章</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    
    <link rel="stylesheet" href="kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor/kindeditor-all.js"></script>
	<script charset="utf-8" src="kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="kindeditor/plugins/code/prettify.js"></script>
    
    <link href="images/dribble.png" rel="shortcut icon" />
    <script type="text/javascript" src="jedate/jedate.js"></script>
    
    
    <script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : 'kindeditor/plugins/code/prettify.css',
				uploadJson : 'kindeditor/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
<style type="text/css">
select{
	border: solid 0px #fff;
	appearance:none;
  -moz-appearance:none;
  -webkit-appearance:none;
  	color: #09c;
	padding-right: 14px;
}
select::-ms-expand { display: none; }
</style>

<style>
.datainp{ width:200px; height:30px; border:0px  solid;}

</style>

</head>
<body>
    <%@include file="header.jsp" %>
<div class="admin">
	<div class="line-big">
        <div class="xm9" style="width: 75%;margin-left: auto;margin-right: auto;float: none;">
			<form name="example" id="form" method="post" action="AddArticel" >
			<table class="table" style="width: 100%;" >
				<tr>
					<td>文章题目：</td>
					<td><input type="text" id="articeltitle" name="articeltitle" class="input" value="<%=DateHelper.getDateTimeFormat() %>写的文章" /></td>
					<td>所属栏目：</td>
					<td><select name="tid" id="tid">
					<c:forEach items="${articeltypes }" var="st">
					<option value="${st.tid }">${ st.tname}</option>
					</c:forEach>
					</select>
					<a class="button button-little bg-main" href="#" >添加栏目</a>
					</td>
				</tr>
				
				<tr>
					<td>作者：</td>
					<td><input type="text" id="zuozhe" name="zuozhe" class="input" value="${loginuser.realname }" /></td>
					<td>时间：</td>
					<td><input class="datainp" id="datebut" name="date" type="text" value="<%=DateHelper.getDateTimeFormat() %>" readonly>
					<input class="button button-little bg-main" type="button" onClick="jeDate({dateCell:'#datebut',isTime:true,format:'YYYY-MM-DD hh:mm:ss'})" value="选择时间">
					</td>
				</tr>
				<tr>
				<td colspan="4">
				<textarea id="content1" name="content1" cols="100" rows="8" style="width:100%;height:600px;"></textarea>
				<br />
				<input class="button button-big bg-main" type="submit" name="button" value="提交内容" /> &nbsp;&nbsp;<font color="red">${aerrormsg }</font>
				</td>
				</tr>
				</table>
			</form>
        </div>
    </div>
</div>

</body>
</html>

