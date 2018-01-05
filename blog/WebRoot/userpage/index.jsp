<%@page import="cn.arice.com.util.XMLHelper"%>
<%@page import="cn.arice.com.service.impl.ImgServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ArticelCommentServiceImpl"%>
<%@page import="cn.arice.com.service.impl.ArticelServiceImpl"%>
<%@page import="cn.arice.com.service.impl.LeaveMsgServiceImpl"%>

<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <title>徐新凯个人博客后台管理-后台管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <script src="js/admin.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />
</head>
<%
	String userid =  (String)session.getAttribute("userid");
	UserInfoService service = new UserInfoServiceImpl();
	UserInfoBean user = service.getUserInfoById(userid);
	pageContext.setAttribute("loginuser",user);
	XMLHelper xml = new XMLHelper();
	pageContext.setAttribute("history",xml.getPenultHistory());
	pageContext.setAttribute("listhistory",xml.parserXml());
	pageContext.setAttribute("lmunlook",new LeaveMsgServiceImpl().getNotLookLMCount());
	pageContext.setAttribute("lmcount",new LeaveMsgServiceImpl().getLMCount());
	pageContext.setAttribute("articelcount",new ArticelServiceImpl().countArticle());
	pageContext.setAttribute("unlookcomment",new ArticelCommentServiceImpl().getUnlookCount());
	pageContext.setAttribute("comments",new ArticelCommentServiceImpl().getAllComments());
	pageContext.setAttribute("listimg", new ImgServiceImpl().getAllImg());
 %>

<body>
<%@include file="header.jsp" %>
<div class="admin">
	<div class="line-big">
    	<div class="xm3">
        	<div class="panel border-back">
            	<div class="panel-body text-center">
                	<img src="images/face.jpg" width="120" class="radius-circle" /><br />
                    ${loginuser.realname }
                </div>
                <div class="panel-foot bg-back border-back">
                		您好，${loginuser.realname }，上次登录时间为:<br>
                		${history.loginTime }。<br>
                		登录时间有错误？<br>
                		<a class="button border-main" id="showchangepwd" href="javascript:showchangepwd()">修改密码</a>
                		<a class="button border-main" href="${pageContext.request.contextPath }/userpage/LoginHistory">登录记录</a>
                </div>
            </div>
            <br>
            <div class="panel" id="showdiv" style="display: none;">
            <form action="${pageContext.request.contextPath }/userpage/ChangePwd" id="form2" name="form2" method="post" onsubmit="return submittopwd();">
            <div class="panel-head"><strong>修改密码</strong>&nbsp;<font color="red" id="changepwdmsg">${pwderrormsg }</font></div>
            	<table class="table" id="userpwdtab">
                	<tr>
	                	<td width="40%" align="right">原密码：</td>
	                	<td><input type="password" class="input" name="oldpwd" id="oldpwd"/></td>
                	</tr>
                	<tr>
	                	<td align="right">新密码：</td>
	                	<td><input type="password" class="input" name="newpwd" id="newpwd"/></td>
                	</tr>
                	<tr>
	                	<td align="right">确认密码：</td>
	                	<td><input type="password" class="input" name="repwd" id = "repwd"/></td>
                	</tr>
                	<tr>
	                	<td align="right" colspan="2"><button class="button bg-main" type="submit" id="btnpwd">确认修改</button></td>
                	</tr>
                </table>
            </form>
            </div>
            
            <br />
        	<div class="panel">
            	<div class="panel-head"><strong>站点统计</strong></div>
                <ul class="list-group">
                	<li><span class="float-right badge bg-main">${articelcount }</span><span class="icon-file"></span> 总文章</li>
                    <li><span class="float-right badge bg-main">${fn:length(comments) }</span><span class="icon-comment"></span> 总评论</li>
                    <li><span class="float-right badge bg-main">${lmcount }</span><span class="icon-comment"></span> 总留言</li>
                    <li><span class="float-right badge bg-main">${fn:length(listimg) }</span><span class="icon-picture-o"></span> 总图片</li>
                </ul>
            </div>
            <br />
            <div class="panel">
            	<div class="panel-head"><strong>系统信息</strong></div>
                <ul class="list-group">
                	<li><span class="float-right"><%= System.getProperty("os.name")%></span> 操作系统</li>
                    <li><span class="float-right">Tomcat</span>Web服务器</li>
                    <li><span class="float-right">java</span>程序语言</li>
                    <li><span class="float-right">MySQL</span>数据库</li>
                </ul>
            </div>
            <br />
        </div>
        <div class="xm9">
        	<c:if test="${lmunlook != 0 }">
        	<div class="alert alert-yellow"><span class="close"></span><strong>注意：</strong>您有${lmunlook }条未读留言，<a href="LeaveMsgSelect">点击查看</a>。</div>
            </c:if>
            <c:if test="${unlookcomment != 0 }">
        	<div class="alert alert-yellow"><span class="close"></span><strong>注意：</strong>您有${fn:length(comments) }条未读文章评论，<a href="pinglunmanage.jsp">点击查看</a>。</div>
            </c:if>
            <!--  <div class="alert">
                <h4>拼图前端框架介绍</h4>
                <p class="text-gray padding-top">拼图是优秀的响应式前端CSS框架，国内前端框架先驱及领导者，自动适应手机、平板、电脑等设备，让前端开发像游戏般快乐、简单、灵活、便捷。</p>
            	<a class="button bg-dot icon-code" href="#"> 下载示例代码</a> 
            	<a class="button bg-main icon-download" href="#"> 下载拼图框架</a> 
            	<a class="button border-main icon-file" href="#"> 拼图使用教程</a>
            </div>-->
            <br>
            <div class="panel">
            	<div class="panel-head"><strong>管理员信息</strong>&nbsp;<font color="red">${errormsg }</font></div>
            	<form action="${pageContext.request.contextPath }/userpage/UpdateUserInfo" method="post" name="form1"  onsubmit="return submitto()">
                <table class="table" id="usermsgtab">
                	<tr>
	                	<td width="110" align="right">用户编号：</td>
	                	<td>${loginuser.userid }<input type="hidden" id="userid" name="userid" value="${loginuser.userid }"  ></td>
                	</tr>
                    <tr>
	                    <td align="right">登陆名：</td>
	                    <td><input type="text" id="logname" name="logname" class="input" value="${loginuser.loginname }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">真实姓名：</td>
	                    <td><input type="text" id="realName" name="realName" class="input" value="${loginuser.realname }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">性别：</td>
	                    <td><input type="text" id="sex" name="sex" class="input" value="${loginuser.sex }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">出生日期：</td>
	                    <td><input type="text" id="birthday" name="birthday" class="input" value="${loginuser.birthday }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">邮箱：</td>
	                    <td><input type="text" id="email" name="email" class="input" value="${loginuser.email }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">电话号码：</td>
	                    <td><input type="text" id="telNumber" name="telNumber" class="input" value="${loginuser.telnumber }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">出生地址：</td>
	                    <td><input type="text" id="birthplace" name="birthplace" class="input" value="${loginuser.birthplace }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">居住地址：</td>
	                    <td><input type="text" id="liveplace" name="liveplace" class="input" value="${loginuser.liveplace }" disabled="disabled" ></td>
                    </tr>
                    <tr>
	                    <td align="right">介绍：</td>
	                    <td><textarea id="introduce" name="introduce" class="input" rows="7" cols="50" maxlength="300" disabled="disabled" >${loginuser.introduce }</textarea></td>
                    </tr>
                    <tr>
	                    <td align="right"><a class="button bg-main" href="javascript:input()" id="changmsg">点击修改</a> </td>
	                    <td><button class="button bg-main" type="submit" id="changebtn"  style="display:none;">确认保存</button></td>
                    </tr>
                </table>
                </form>
            </div><br>
        </div>
    </div>
    <br />
</div>
<script type="text/javascript">
function input(){
var changmsg = document.getElementById("changmsg");
if(changmsg.innerHTML=='点击修改'){
	changmsg.innerHTML='取消修改';
	document.getElementById("changebtn").style.display = 'block';
	$("#usermsgtab").find("input,textarea,select").attr("disabled", false); 
	
}else if(changmsg.innerHTML=='取消修改'){
	 changmsg.innerHTML='点击修改';
	 document.getElementById("changebtn").style.display = 'none';
	 $("#usermsgtab").find("input,textarea,select").attr("disabled", true);
	 
}
}
function submitto(){
var bool = true;
for(var i=0;i<document.form1.elements.length-1;i++){
   if(document.form1.elements[i].value==""){
        alert("当前表单不能有空项,请重新输入");
        document.form1.elements[i].focus();
        bool = false;
   }
 }
 return bool;
}
function showchangepwd(){
	var changmsg = document.getElementById("showchangepwd");
if(changmsg.innerHTML=='修改密码'){
	changmsg.innerHTML='取消修改';
	document.getElementById("showdiv").style.display = 'block';
	
}else if(changmsg.innerHTML=='取消修改'){
	 changmsg.innerHTML='修改密码';
	 document.getElementById("showdiv").style.display = 'none';
}
}
function submittopwd(){
	var bool = true;
	var oldpwd = document.getElementById("oldpwd").value;
	var newpwd = document.getElementById("newpwd").value;
	var repwd = document.getElementById("repwd").value;
	if(oldpwd ==""||newpwd ==""||repwd ==""){
		document.getElementById("changepwdmsg").innerHTML = '你还没有填写完毕哦';
		bool = false;
	}else if(newpwd != repwd){
		document.getElementById("changepwdmsg").innerHTML = '两次密码输入错误';
		bool = false;
	}
	return bool;
}
</script>

</body>
</html>