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
		<title>注册</title>
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="css/login.css"  media="all"/>
	</head>

	<body class="beg-login-bg">
		<div class="beg-login-box">
			<header>
				<h1>注册</h1>
			</header>
			<div class="beg-login-main">
				
					<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
						<input type="text" id="username" name="username" autocomplete="off" placeholder="请输入邮箱" class="layui-input"  maxlength="20">
					</div>
					<div class="layui-form-item">
						<label class="beg-login-icon pull-left">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="text" id="code" name="code"  autocomplete="off" placeholder="请输入验证码 "class="layui-input" maxlength="8">
						<button onclick="sendmail()" class="layui-btn layui-btn-small" name="submitf">发送验证码</button>
					</div>
										<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password" id="password"name="password" lay-verify="password" autocomplete="off" placeholder="请输入新密码" class="layui-input" maxlength="8">
					
					</div>
										<div class="layui-form-item">
						<label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
						<input type="password"id="repassword" name="repassword" lay-verify="password" autocomplete="off" placeholder="再次输入密码" class="layui-input" maxlength="8">
						
					</div>
					
				

						<div class ="form-group" style="margin-top:5px;">
						
						 <button onclick=check(0) class="layui-btn layui-btn-small"  style="margin-top:5px;">注册</button>
						 </br>
						<!--   <button onclick=check(2) class="layui-btn layui-btn-small"  style="margin-top:5px;">作为规则提取人员注册</button>
						 </br>
						 <button onclick=check(3) class="layui-btn layui-btn-small"  style="margin-top:5px;">作为投放人员注册</button>
						-->
						</div>
						<div class="beg-clear"></div>
				
				
			</div>
			
				  </div>
		<footer>
				<p style="color:white">医患纠纷中的法律要素交互式提取</p>
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
function sendmail(){
		//alert(obj.id+obj.name);
		//var id = obj.id;
		var aname  = document.getElementById("username").value;
		$.ajax({
			url:"SendMail",
			data:{username:aname},
			method:"post",
			//dataType:"json"
			success:function(result){
				if(result=="failed")
				{
				alert("发送失败！请检查邮箱是否正确");
				}else
				{
				alert("已发送，请在填写的邮箱中查收验证码");
				}
			}
		});
	}
	
function check(actor)
{
	var aname        = document.getElementById("username").value;
	var password     = document.getElementById("password").value;
	var repassword   = document.getElementById("repassword").value;
	var cod          = document.getElementById("code").value;
	var reg = /^-?\d+$/; 
	if(aname==""||password==""||cod=="")
	{
	alert("请填写完整");
	}else if (password==repassword)
	{
	if(reg.test(cod))
	{
	$.ajax({
			url:"Signup",
			data:{username:aname,code:cod,password:password,actor:actor},
			method:"post",
			//dataType:"json"
			success:function(result){
			if(result=="success")
			{
			window.location.href ="page?path=index";
			}else if(result=="existed")
			{
			alert("用户名不存在");
			}
			else
			{
			alert("验证码错误！");
			}
			}
		});
	}else
	{
	alert("验证码格式错误！");
	}
	
	}else
	{
	alert("请确认两次密码一致");
	}
}
	</script>
			<style>
		.beg-login-box{
		height:500px;
		width:500px;
		}
	#resure{
	width:320px;}
	

		</style>
	</body>

</html>