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
    <title>投放人员·下载模型</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="system-default.css">
	
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->
	<script type="text/javascript" src="bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css" type="text/css"/>
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

<nav class="navbar navbar-default" role="navigation";
	<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">投放人员系统</a>
    </div>
    <div>
        <ul class="nav navbar-nav pull-right">
           <li><a>欢迎你，投放人员</a></li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    ${user.username}<b class="caret"></b>
                </a>
                <ul class="dropdown-menu pull-left">
                        <a href="index.action">退出登录</a>
                </ul>
            </li>
        </ul>
    </div>
	</div>
</nav>

<!--标题栏-->
     <div class="headline">
     <div class="row" style="background-color: #575757;margin-top: -20px;height: 100vh;">
     	<div class="col-md-2"></div>
     	<div class="col-md-8" style="background-color: white;height: 100%;	box-shadow: 0px 6px 5px lightgrey inset;background-image: url(bg.png)">
     	<div style="margin:20px">
     		<table align="center">
     		<tr>
				<td align="center"><a href="page?path=upload-text"><font face="PingHei" size="+2" style="font-weight:400" color="black">上传文本</font></a></td>
				<td align="center" valign="top"><img class="icons"src="./img/箭头 (1).png"/></td>
				<td align="center"><a href="page?path=chakanModel"><font face="PingHei" size="+2" style="font-weight:400" color="#9A9A9A">查看/修改模型</font></a></td>
								<td align="center" valign="top"><img class="icons"src="./img/箭头 (1).png"/></td>
				<td align="center"><a href="#"><font face="PingHei" size="+2" style="font-weight:400" color="#9A9A9A">查看/下载</font></a></td>
     		</tr>
     		</table>
     		</div>
     		
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