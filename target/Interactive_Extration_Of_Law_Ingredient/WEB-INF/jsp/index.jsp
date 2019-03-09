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
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>登录</title>
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/login.css" />
	</head>

	<body class="beg-login-bg">
		<div class="beg-login-box">
			<header>
				<h1>登录</h1>
			</header>
			<div class="beg-login-main">
				<form action="weblogin" class="layui-form" method="post">
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input type="text" name="username" lay-verify="username" autocomplete="off" placeholder="这里输入登录名" class="layui-input"  maxlength="20">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password" name="password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input" maxlength="8">
						 <font color="red"size="2">${Result }</font>
					</div>
					<div class="layui-form-item">
			
						
						  
					<div class="form-group">
						<button onclick="window.location.href='page?path=forgetpassword' " type="button" class="layui-btn layui-btn-primary layui-btn-small btn-forget " name="forget"style="width:40%">忘记密码</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button onclick="window.location.href='page?path=signup' " type="button" class="layui-btn layui-btn-primary layui-btn-small btn-login " style="width:40%"name="login" >用户注册</button>
						</div>
						<div class ="form-group login" style="margin-top:5px;">
						
						 <button type="submit" class="layui-btn btn-warning " name="submit" id = "submitlogin" >登录</button>
						</div>
						<div class="beg-clear"></div>
					</div>
				</form>
			</div>
			
		</div>
		<footer>
				<p>医患纠纷中的法律要素交互式提取</p>
			</footer>
		<script type="text/javascript" src="plugins/layui/layui.js"></script>
		<script>
			/*layui.use(['layer', 'form'], function() {
				var layer = layui.layer,
					$ = layui.jquery,
					form = layui.form();
					
				form.on('submit(login)',function(data){
					
					location.href='index.html';
					return false;
				});
			});*/
			window.onload=function()
{
var bt=document.getElementById("submitlogin");
bt.onclick=function(){
if(document.getElementById("username").value=="")
{
alert("用户名不能为空!");
return false;
} 
else if(document.getElementById("password").value=="")
{
alert("密码不能为空!");
return false; 
}
}
}
		</script>
		<style>
		.beg-login-box{
		height:350px;
		}
	#submitlogin{
	width:220px;}
	

		</style>
	</body>

</html>