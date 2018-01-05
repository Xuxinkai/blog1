<%@ page language="java" import="java.util.*,cn.arice.com.util.*" contentType="text/html; charset=utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>徐新凯个人博客</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script><!--Needed for the prettyPhoto to function-->
<script type="text/javascript" src="js/simplepager.js"></script><!--runs the pagination-->
<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet" charset="utf-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$(document).ready(function() {
	$('span.category').hover(function(){
    $(this).next().css('background-color','#e25050');
    },function(){
    $(this).next().css('background-color','#393939');
    });
	
		
	$(".pageing").quickPager({
		pageSize : 5,
	});
});
</script>
<!--[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

 <link href="images/dribble.png" rel="shortcut icon" />
</head>
<body>
  <div id="wrapper">
    
      <div id="main">
        <div id="navigation">
            <ul>
                <li><a href="indexfront.jsp">主页</a></li> 
                <li><a href="album.jsp">相册</a></li>
                <li><a class="active" href="userInfo.jsp">个人档案</a></li>
                <li><a href="contact.jsp">留言板</a></li>
            </ul>
        </div><!--END navigation-->
         <div id="main-content">
         	<h2>Arice 个人卡片</h2>
                <div class="clear"></div>
                <div class="panes">
                <div style="float: left;">
                	<table>
                		<tr><td><img src="images/arice.png" alt="徐新凯" height="194.55px" width="150px"/></td></tr>
                		<tr><td>&nbsp;</td></tr> 
                		<tr><td><a href="album.jsp" class="blue">更多照片</a></td></tr>
                		<tr><td>&nbsp;</td></tr>
                		<tr><td><a href="contact.jsp" class="blue">给我留言</a></td></tr>
                	</table>
               </div>
                <div>
                	<table>
                		<tr bgcolor="#eceaea"><td width="20%"><h6>姓名:</h6></td><td>${user.realname}</td></tr>
                		<tr bgcolor="#ccffcc"><td><h6>年龄:</h6></td><td>${user.birthday}</td></tr>
                		<tr bgcolor="#eceaea"><td><h6>性别:</h6></td><td>${user.sex }</td></tr>
                		<tr bgcolor="#ccffcc"><td><h6>邮箱:</h6></td><td>${user.email }</td></tr>
                		<tr bgcolor="#eceaea"><td><h6>号码:</h6></td><td>${user.telnumber}</td></tr>
                		<tr bgcolor="#ccffcc"><td><h6>家乡:</h6></td><td>${user.birthplace }</td></tr>
                		<tr bgcolor="#eceaea"><td><h6>居住地:</h6></td><td>${user.liveplace }</td></tr>
                		<tr bgcolor="#ccffcc"><td><h6>一点点简介:</h6></td><td><span>${user.introduce }</span></td></tr>
                	</table>
                	</div>
                </div><!--END panes-->
                
                
         		<h2>我的简历</h2>
                <div class="clear"></div>
                <div class="panes">
                <ul class="gallery">
                <li><a href="images/jianli.jpg" rel="prettyPhoto[jianli]" class="gallery"><img src="images/jianli.jpg" alt="我的简历" width="550px"/></a></li>
                </ul>
                </div>
         </div><!-- end main-content -->
        
        </div><!-- end main -->
        
         <!-- start side -->
        
        <div id="side">
        <%@ include file="side.jsp" %>
        </div>
		<!-- end side -->
		
        <div class="clear"></div>
        <div class="push"></div>
        </div><!-- end wrapper -->
        <!-- Start Footer -->
	<%@ include file="footer.jsp" %>
	<!-- End Footer -->
	
<script src="js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>
         <script type="text/javascript" charset="utf-8">
  $(document).ready(function(){
    $("a[rel^='prettyPhoto']").prettyPhoto();
  });
</script>
<div style="display:none"></div>
  </body>
</html>
  </body>
</html>
