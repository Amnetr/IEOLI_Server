<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>上传人员后台管理</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">

		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/global.css" media="all">
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<!--下拉复选框插件-->
</head>
<body>
<script type="text/javascript" charset="UTF-8" >
function upload()
{
	var form = document.getElementById('upload');
	var formData = new FormData(form); 
	var filename = document.getElementById('file').value;
	if(filename=='')
	{
	alert("请选择上传");
	return;
	}else
	{
	$.ajax({
			url:"UploadTexts",
			data:formData,
					type: 'POST',
                    cache: false,
						 contentType: false,  
				          processData: false,
			success:function(result){
			alert("上传成功");
			}
		});
	}
	
}

</script>

<!--标题栏-->
<div class= "container-big" >
     <div class="container" >
     <div class="layui-row" style="background-color: #575757;height: 100vh;">
     	<div class="layui-col-md-2"></div>
     	<div class="layui-col-md-8" style="background-color: white;height: 100%;	box-shadow: 0px 6px 5px lightgrey inset;background-image: url(img/bg.png)">

     		  <div class="model-class" style="margin-left: 30px;">
			<form id="upload" role="form" action="" enctype="multipart/form-data" method="post"> 
     		<tr>
				<hr>
			  <div class="composing" style="height: 40px; align:center"><h3>请上传文本</h3></div>
			  <hr align=left width=450 color=#987cb9 size=1  >
			  <br>
				  <input type="file"  id="file" name="file" multiple/>	
				  <br>
				  <br>
				  <br>
				 
				   <input type="button" id="Insert" class=" layui-btn" value="上传文件" onclick="upload()" >
				</td>
				    
     		</tr>
     		</form>
  </div>
    	
     	</div>
     	
     </div>
     </div>
  <!--选择模型类型-->
</div>
</body>
<style>
	
	lable{
		font-size: 20px;
		font-weight: 400;
	}
	.icons{
		height: 45px;
		width:45px;
	}
	a:link{
text-decoration:none;
}
	h3{
		font-family: PingHei;
		font-size: 25px;
	}
	hr{
		align=left;
		margin-top: -3px;
	}
	.inside{
		margin-left: 30px;
	}
	
	.navbar navbar-default{
		background-color:lightgrey;
		opacity:0.6;

	}
	.headline{
	

	}
	
</style>
</html>