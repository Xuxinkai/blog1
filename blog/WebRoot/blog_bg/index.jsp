<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta charset="utf-8"/>
<title>博客后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
	var oldid='';
	function toLoad(html,id){
		$("#contentDiv").load(html);
		
		if(oldid !=id){
			//当前按钮添加active效果
			$("#"+id).addClass("active");
			//前面的按钮取消active效果
			$("#"+oldid).removeClass("active");
		}
	    oldid=id;
	}
	function loadMain(){
		$("#contentDiv").load('main.jsp');
	}
</script>
</head>
<body onload="loadMain()">
<!--header-->
<header>
 <h1><img src="images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a href="#" target="_blank" class="website_icon">博客首页</a></li>
  <li><a href="#" class="admin_icon">徐新凯</a></li>
  <li><a href="#" class="set_icon">账号设置</a></li>
  <li><a href="login.html" class="quit_icon">安全退出</a></li>
 </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.jsp">主页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>发布文章</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="#" onclick="toLoad('file1.jsp','file1')" id="file1">文章编辑</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>文章管理</dt>
    <dd><a href="#" onclick="toLoad('file2.jsp','file2')" id="file2">文章类别</a></dd>
    <dd><a href="#">文章列表</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>评论管理</dt>
    <dd><a href="#">查看评论</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>留言管理</dt>
    <dd><a href="#">查看留言</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>相册管理</dt>
    <dd><a href="#">相册管理</a></dd>
    <dd><a href="#">图片管理</a></dd>
    <dd><a href="#">上传图片</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>系统设置</dt>
    <dd><a href="#">访问记录</a></dd>
    <dd><a href="#">我的链接</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© arice.ren 版权所有</p>
  </li>
 </ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div id="contentDiv"></div>
</section>
</body>
</html>
