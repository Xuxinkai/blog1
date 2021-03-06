<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>徐新凯个人博客后台管理-管理员登录</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <link href="images/dribble.png" rel="shortcut icon" />

  </head>
  
  <body>
    <div class="container">
    <div class="line">
        <div class="xs6 xm4 xs3-move xm4-move">
            <br /><br /> <br /><br /> <br /><br />
            <br /><br />
            <form action="${pageContext.request.contextPath }/userpage/login" method="post">
            <div class="panel">
                <div class="panel-head"><strong>登录徐新凯个人博客后台管理系统</strong></div>
                <div class="panel-body" style="padding:30px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input" name="admin" value="arice" placeholder="登录账号" data-validate="required:请填写账号,length#>0:账号长度不符合要求" />
                            <span class="icon icon-user"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input" name="password" value="" placeholder="登录密码" data-validate="required:请填写密码,length#>0:密码长度不符合要求" />
                            <span class="icon icon-key"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input" name="passcode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码"/>
                           <font color="red"> ${errormsg }</font>
                            <a href="javascript:reloadVerifyCode();"><img  id="safecode" src="Image" width="80" height="32" class="passcode" /></a>
                        </div>
                    </div>
                </div>
                <div class="panel-foot text-center"><button class="button button-block bg-main text-big">立即登录后台</button></div>
            </div>
            </form>
            </div>
    </div>
</div>

</body>
<script type="text/javascript">
function reloadVerifyCode(){  
	var timenow = new Date().getTime();
	document.getElementById("safecode").src="${pageContext.request.contextPath }/userpage/Image?d="+timenow;
}
</script>
</html>
