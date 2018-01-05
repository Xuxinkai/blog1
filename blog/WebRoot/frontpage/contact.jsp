<%@page import="cn.arice.com.service.impl.LeaveMsgServiceImpl"%>
<%@page import="cn.arice.com.service.LeaveMsgService"%>
<%@page import="cn.arice.com.bean.UserInfoBean"%>
<%@page import="cn.arice.com.service.UserInfoService"%>
<%@page import="cn.arice.com.service.impl.UserInfoServiceImpl"%>
<%@ page language="java" import="java.util.*,cn.arice.com.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<style type="text/css">
    html,body{margin:0;padding:0;}
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<style type="text/css">
a{
text-decoration:none;
}
a:hover{ 
text-decoration:none;    
color:#ff6633;
}

</style>
<%UserInfoService service = new UserInfoServiceImpl(); 
	UserInfoBean  user = service.getUserInfo();
	pageContext.setAttribute("user", user, pageContext.PAGE_SCOPE);
	LeaveMsgService lms = new LeaveMsgServiceImpl();
	pageContext.setAttribute("alllmsg", lms.getAllLeaveMsg(), pageContext.PAGE_SCOPE);
	
%>
 <link href="images/dribble.png" rel="shortcut icon" />
</head>
<body>
  <div id="wrapper">
    
      <div id="main">
        <div id="navigation">
            <ul>
                <li><a href="indexfront.jsp">主页</a></li> 
                <li><a href="album.jsp">相册</a></li>
                <li><a href="userInfo.jsp">个人档案</a></li>
                <li><a class="active" href="contact.jsp">留言板</a></li>
            </ul>
        </div><!--END navigation-->
        
         <div id="main-content">
            	<div id="contact-page">
                <h1>联系我</h1>
                
                <span class="main-border"></span>
                <div id="contact-info">
            	
                <h2>${user.realname }</h2>
                <ul class="contact-list">
                	<li>常德桃源<br/> 中国 , 湖南</li>
                </ul>
                <ul class="list2">
                    <li><span class="bold">电话: </span>${user.telnumber }</li> 
                    <li><span class="bold">邮箱:</span> ${user.email }</li>
                </ul>
               </div><!--END contact-info-->
                
                <div  style="width:425px;height:300px;border:#ccc solid 1px;" id="dituContent"></div>
                <!--END map-->
                
                <div class="clear"></div>
                <h1 id="contact-h1">给我留言</h1>
                <span class="main-border"></span>
                                
               <form class="contact_form" id="form" action="${pageContext.request.contextPath}/frontpage/LeaveMsgAdd" method="post" name="contact_form">
			    <ul>
			        <li>
			             <span class="required_notification">* 必须填写的项目</span>
			        </li>
			        <li>
			            <label for="contactname">姓名</label>
			            <input type="text" name="contactname" id="contactname" placeholder="你的大名哦" maxlength="15" required />
			        </li>
			        <li>
           	 			<label for="email">邮箱</label>
            			<input type="email" name="email" id="email" placeholder="name@host.com" required />
            			<span class="form_hint">Proper format "name@host.com"</span>
        			</li>
			        <li>
			            <textarea name="message" id = "message" cols="50" rows="7" maxlength="150" required></textarea>
			        </li>
			        <li>
			        	<button type="submit" class="submit" name="send">确认留言</button>
			        </li>
			    </ul>
				</form>		
				<div class="intro"></div>
				<h1 id="contact-h1">留言列表</h1>
                <span class="main-border"></span>
             <ul>
                <c:forEach items="${alllmsg }" var="msg" varStatus="state" begin="0" end="5">
                <li><span><a href="#" >${msg.lmcontent }</a></span></li>
                <li class="admin"><span>By <a href="#">${msg.lmname }</a>, ${msg.lmtime }</span></li>
                <span class="main-border"></span>
                </c:forEach>
            </ul>
				</div><!--END contact-page-->
            </div><!--END main-content-->
        
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
  <script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(111.704994,29.037723);//定义一个中心点坐标
        map.centerAndZoom(point,12);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    
    initMap();//创建和初始化地图
</script>
</html>
        
