<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<script type="text/javascript">
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
<body>
	<div class="background"></div>
    <div class="container">
    	<div class="row">
    		<div class="col-md-6 text">
                            <h1 class="total-title">医学法律文书<br><strong>规则提取</strong>系统</h1>
                            <div class="description">
                            	
                            </div>
                        </div>
                        
    		<div class="col-md-4 form-box"> 
        	    <div class="form-top">
                    <h4 class="form-title"align="center">登录</h4>
        	    </div>
    	        <div class="form-horizontal">
    	    	    <form role="form" action="weblogin" method="post" class="login-form">
    	    		<div class="form-bottom">
    	    			<div class="form-group input">
			            <i class="fa fa-user fa-lg"></i><!--图标-->
			            <input class="form-control required" type="text" placeholder="用户名" id="username" name="username" autofocus="autofocus" maxlength="20"/>
			            </div>
			        <div class="form-group input">
			            <i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password" name="password" maxlength="8"/>
                        <font color="red"size="2">${Result }</font>
			        </div>
			        <div class="form-group">
                        <button onclick="window.location.href='page?path=Forgetpwd' " type="button" class="btn btn-forget btn-warning pull-left" name="forget">忘记密码</button>
                        <button onclick="window.location.href='page?path=signup' " type="button" class="btn btn-login btn-warning pull-right" name="login">用户注册</button>
                    </div>
                    <div class="form-group login" align="center">
                        <button type="submit" class="btn btn-warning " name="submit" id = "submitlogin">登录</button>
                    </div>
    	    		</div>
			        
			    </form>
    	    </div>
        
        	
</div>
        </div>
    </div>
</body>
</html>