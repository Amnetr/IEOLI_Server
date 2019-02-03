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
		<title>要素规则查看</title>
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

	<!--下拉复选框插件-->
</head>
<body>
<script type="text/javascript" charset="UTF-8" >
function showhandled(modelid)
{
	
	window.location.href=("page?path=showHandledRule&modelid="+modelid);
}
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
			url:"showrules",
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
     <form role="form">
  <div class="form-group">
    <label for="name" style="font-size: 20px">选择要素</label>
    
    
 <div class="form-group" style="margin: 30px">    
     <table align="center" width="960px">
     		<tr>
				<td align="left">  <c:forEach items="${list}" var="model">
				<div class="caption" align="left">
				<label><input id="radios" onclick= "showhandled('${model.modelid}')"name="models" type="radio" value="${model.modelid}"/>序号:${model.modelid} </label> 
								<p id="modeldescription">要素：${model.modelname}</p>
								<p align="center">
								</p>
								</div>
				</c:forEach></td>
				
			
     		</tr>
     		</table>
    </div>
    <hr>
      <div class="form-group" style="margin-top: 30px">    
      <label for="name" style="font-size:20px;"  >规则</label>
     <div><tr><td></td></tr></div>
<div>
		<table class="table">
			<thead>
				<tr>
					
					<td width="400px">中文描述</td>
					<td width="200px">正则表达式</td>
					<td width="400px">准确率</td>
					
				</tr>
			</thead>
			<tbody>
				
					
					<c:forEach items="${Rules}" var="results">
					<tr>
						<td>
							<div>
								<span>${results.description}</span>
							</div>	
						</td>
						<td>
							<span >${results.regex}</span>	
						</td>
						
						<td>
							<!--   <input type="button" id="Insert" class=" form-control btn btn-primary" value="下载" onclick="download('${textss.textname}')">-->
							<span >${results.rate }</span>
							
						</td>
					</tr>
				</c:forEach>
				
					
								
			</tbody>
		
		</table>
	</div>
    
    </div>
    
  </div>
</form>

  </div>
    	
     	</div>
     	
     </div>
     </div>
  <!--选择模型类型-->
</div>
</body>
<style>
	
	
</style>
</html>