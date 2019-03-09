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
		<title>下载标注结果</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">

		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/global.css" media="all">
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>
<body>
<script type="text/javascript" charset="UTF-8" >
function showhandled(modelid)
{
	
	window.location.href=("ShowHandLedText?modelid="+modelid);
}

function downloadd(textname)
{
$.ajax({
			url:"download",
			data:{filename:textname},
			method:"post",
			//dataType:"json"
			success:function(result){
			}
		});
}
</script>

<!--标题栏-->
     <div class="container">
     <div class="layui-row" style="background-color: #575757;height: 100vh;">
     	<div class="layui-col-md-2"></div>
     	<div class="layui-col-md-8" style="background-color: white;height: 100%;">
     		
     		<div style="margin: 40px">
     <form role="form">
  <div class="form-group">
    <label for="name" style="font-size: 20px">选择文本模型</label>
    
    
 <div class="form-group" style="margin: 30px">    
     <table align="center" width="960px">
     		<tr>
				<td align="left">  <c:forEach items="${list}" var="model">
				<div class="caption" align="left">
				<label><input id="radios" onclick= "showhandled('${model.modelid}')"name="models" type="radio" value="${model.modelid}"/>序号:${model.modelid} </label> 
								<p id="modeldescription">介绍：${model.modeldescription}</p>
								<p align="center">
								</p>
								</div>
				</c:forEach></td>
				
			
     		</tr>
     		</table>
    </div>
    
      <div class="form-group" style="margin-top: 30px">    
      <label for="name" style="font-size:20px;"  >下载（建议右键-目标另存为）</label>
     
<div>
		<table class="table">
			<thead>
				<tr>
					
					<th width="400px">文件名</th>
					<th width="200px">文件号</th>
					<th width="400px">操作</th>
					
				</tr>
			</thead>
			<tbody>
				
					
					<c:forEach items="${texts}" var="textss">
					<tr>
						<td>
							<div>
								<a href="./texts/${textss.textname}" >${textss.textname}</a>
							</div>	
						</td>
						<td>
							<span >${textss.textid}</span>	
						</td>
						
						<td>
							<!--   <input type="button" id="Insert" class=" form-control btn btn-primary" value="下载" onclick="download('${textss.textname}')">-->
							<a href="download?filename=${textss.textname}" >下载</a>
							
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
     <div class="col-md-2"></div>
     </div>
  <!--选择模型类型-->

</body>
<script type="text/javascript">
    $('#select-single').multiselect();
</script>
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
	
</style>
</html>