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
	pageContext.setAttribute("listalbum", new AlbumServiceImpl().getAllAlbum());
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
<SCRIPT LANGUAGE="JavaScript">  
function setImagePreview(docObj,localImagId,imgObjPreview)     
    {    
          
        var name=docObj.value;  
        var type=name.split(".");  
        type=type[type.length-1];  
        if("jpg"!=type &&"png"!=type &&"jpeg"!=type&&"gif"!=type){  
            alert("错误的类型，请选择图片");  
            document.getElementById("txtSrc").value=null;//防止将非图片类型上传  
            return ;  
        }  
          
        if(docObj.files && docObj.files[0])    
        {    
  
            //alert("hello"+docObj.files[0]);  
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式      
            document.getElementById("imgDiv").style.display="block";  
            document.getElementById("img").src= window.URL.createObjectURL(docObj.files[0]);    
        }    
        else    
        {    
            //IE下，使用滤镜    
            docObj.select();    
            var imgSrc = document.selection.createRange().text;    
                
            //必须设置初始大小    
            localImagId.style.width = "300px";    
            localImagId.style.height = "200px";    
                
            //图片异常的捕捉，防止用户修改后缀来伪造图片    
            try    
            {    
                localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";    
                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;    
             }    
             catch(e)    
             {    
                alert("您上传的图片格式不正确，请重新选择!");    
                return false;    
             }                              
             imgObjPreview.style.display = 'none';    
             document.selection.empty();    
       }    
       return true;    
   }   
</SCript> 
<body>
	<%@include file="header.jsp"%>
	<div class="admin">
		<div class="line-big">
			<div class="xm9" style="width: 100%">
			<div style="width: 50%;margin-left: auto;margin-right: auto;float: none;">
				<form name="frm_test"
					action="${pageContext.request.contextPath}/userpage/FileUploadAndDown?method=upload"
					method="post" enctype="multipart/form-data">
					
					<div class="form-group">
							
						<div class="field">
						<label for="sitename">选择相册</label>								
							<select name="album">
							<c:forEach items="${listalbum }" var="album">
							<option value="${album.alid }" >${album.alname }</option>
							</c:forEach>
							</select>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="file" name="logo"
								data-validate="required:请选择上传文件,regexp#.+.(jpg|jpeg|png|gif)$:只能上传jpg|gif|png格式文件" 
								onChange="setImagePreview(this,imgDiv,img);"/>
							
						</div>
					</div>
					<div  align="center" id="imgDiv">  
				        <img alt="图片预览区域" src="images/defaultimg.png" id="img"  width="100%" >  
				    </div>
					<div class="form-group">
						<div class="label">
							<label for="sitename">照片描述</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="imgdesc" name="imgdesc"
								maxlength="25" placeholder="照片描述" data-validate="required:请填写对照片的描述" />
						</div>
					</div>
					<div class="form-button">
						<input type="submit" name="submit"  class="button bg-main" value="上传" />
					</div>
				</form>

			</div>
		</div>
	</div>
</body>
</html>