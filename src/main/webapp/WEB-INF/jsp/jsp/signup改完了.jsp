<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<script type="text/javascript" charset="UTF-8" >
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
	
function check()
{
	var aname        = document.getElementById("username").value;
	var password     = document.getElementById("password").value;
	var repassword   = document.getElementById("repassword").value;
	var cod          = document.getElementById("code").value;
	var radios 		 = document.getElementsByName("actor");
	var actor;
	for(var i=0;i<radios.length;i++){
    if(radios[i].checked){
      actor = radios[i].value;
    break;
    }
    }
	var reg = /^-?\d+$/; 
	if (password==repassword)
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
			alert("注册成功");
			window.location.href ="page?path=index";
			}else if(result=="existed")
			{
			alert("用户名已存在");
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
    <div class="background"></div>
    <div class="container">
    	<div class="row">
    		<div class="col-md-6 text">
               <h1 class="total-title">医学法律文书<br><strong>标注</strong>系统</h1>
                <div class="description">
                </div>
            </div>
        <div class="col-md-4 form-box signup">   
        	<div class="form-top">
        		<h4 class="form-title"align="center">注册</h4>
        	</div>
        <div class="form-horizontal" id="login_form" >
                <div class="form-bottom">
                    <div class="form-group input">
                    	<i class="fa fa-user fa-lg"></i><!--图标-->
                        <input class="form-control required" type="text" placeholder="请输入邮箱" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group input checkword">
                    	
                    	<span class="form-group input left">
                    		<!--<i class="fa fa-user fa-lg"></i>-->
                            <input class="form-control required" type="text" placeholder="请输入验证码" id="code" name="code" autofocus="autofocus" maxlength="20"/>
                    	</span>
                    	<span class="form-group input right">
                    		<button onclick="sendmail()" class="btn btn-warning " name="submitf">发送验证码</button>
                    	</span>
                    </div>
                    <div class="form-group input">
                    	<i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password" name="password" maxlength="8"/>
                    </div>
                    <div class="form-group input">
                    	<i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="再次输入密码" id="repassword" name="repassword" maxlength="8"/>
                    </div>
                  
                        <label><input id="radios" name="actor" type="radio" value="0" checked="checked"/>作为标记人员注册  </label> 
                        <label><input id="radios" name="actor" type="radio" value="1" />作为投放人员注册 </label> 
             
                    <div class="form-group col-md-offset-6"align="center">
                        <button onclick="check()"class="btn btn-warning "  >确认</button>
                    </div>
                </div>
       
        </div>
        </div>
       </div>
    </div>
</body>
</html>