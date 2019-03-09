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
		<title>修改要素</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/global.css" media="all">
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>
<body>
<script type="text/javascript" charset="UTF-8" >
function smedit()
{
	var desc = document.getElementById("textar").value;
	var radios 		 = document.getElementsByName("models");
	var taskid=-1;
	if(desc=='')
	{
	alert("请输入介绍内容");
	return;
	}
	for(var i=0;i<radios.length;i++){
    if(radios[i].checked){
      taskid = radios[i].value;
    break;
    }
    }
	$.ajax({
			url:"UploadModels",
			data:{taskid:taskid,description:desc},
			method:"post",
			//dataType:"json"
			success:function(result){
			window.location.reload();  
			alert("成功");
			
			}
		});
}
function snmedit()
{
	var desc = document.getElementById("textar").value;
	var taskid=-1;
	if(desc=='')
	{
	alert("请输入介绍内容");
	return;
	}
	$.ajax({
			url:"UploadModels",
			data:{taskid:taskid,description:desc},
			method:"post",
			//dataType:"json"
			success:function(result){
			window.location.reload();  
			alert("成功");
			
			}
		});
}
</script>


<!--标题栏-->
	<div class="container">
     <div class="layui-row">
     	<div class="layui-col-md-2"></div>
     	<div class="layui-col-md-8"style="background-color: white;height: 100%;">
     		
     		<div style="margin: 40px">
     
  <div class="form-group">
    <label for="name" style="font-size: 20px">标注任务</label>
    
    <div class="form-group" style="margin: 30px">    
     <table align="center" width="960px">
     		<tr>
				<td align="left">  <c:forEach items="${list}" var="model">
				<div class="caption" align="left">
				<label><input id="radios" name="models" type="radio" value="${model.taskid}"/>序号:${model.taskid} </label> 
								<p id="taskdescription">介绍：${model.taskdescription}</p>
								<p align="center">
								</p>
								</div>
				</c:forEach></td>
				
			
     		</tr>
     		</table>
    </div>
     <label for="name" style="font-size:20px;"  >任务内容</label>
      <div class="form-group" style="margin: 30px">    
     
	  </br>
      <textarea class="form-control" rows="10" id="textar" name=uploadarea style="width: 700px"></textarea>
    
    </div>
    
  </div>
  <div class="last" style="margin-left:350px;">
  <button onclick="snmedit()" class="layui-btn " name="button">新增</button>
  <button onclick="smedit()" class="layui-btn " name="button">修改</button>
  			</div>
   			</div>
    			
     </div>
     <div class="layui-col-md-2"></div>
     </div>
  <!--选择模型类型-->
</div>
</body>
<style>
	
	.row{
		margin-top:-20px;
		background-color: #575757;margin-top: -20px;height: 100vh;
	}
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
	#Insert{
		background-color: #EFB336;
		border:none;
	}
	.navbar navbar-default{
		background-color:lightgrey;
		opacity:0.6;

	}
	.headline{
	

	}
	.last{
		margin-top: -10px;
		
	}
	</style>
</html>