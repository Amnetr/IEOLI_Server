<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%String path = request.getContextPath(); %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>

		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>邮件验证码示例</title>
		

		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
		<link rel="stylesheet" type="text/css" href="<%=path %>/assets/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/assets/css/form-elements.css">
		<link rel="stylesheet" type="text/css" href="<%=path %>/assets/css/style.css">
		
			<!-- Javascript -->
		<script type="text/javascript" src="<%=path %>/assets/js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="<%=path %>/assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=path %>/assets/js/jquery.backstretch.min.js"></script>
		<script type="text/javascript" src="<%=path %>/assets/js/scripts.js"></script>
		
		<script type="text/javascript">
		    window.onload=function(){
		    	var result=${result};
				if(result!=null&&!result.equals("")){
					var f=document.getElementById("login");
					var p=document.createElement("font");
					p.color="red";
					p.innerHTML=result;
					f.insertBefore(p,f.childNodes[2]);
				}
		    }
									
	  </script>

		<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
		



		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

		<!-- Favicon and touch icons -->
		<!--<link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">-->

	</head>

	<body>

		<!-- Top content -->
		<div class="top-content">

			<div class="inner-bg">
				<div class="container">
					<div class="row">
						<div class="col-sm-8 col-sm-offset-2 text">
							<h1><strong>注册用 </strong> 邮件验证码示例</h1>

						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 col-sm-offset-3 form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>输入邮箱</h3>
									<p>输入邮箱中收到的验证码</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">
								<form role="form" id="login" action="SendMail" method="post" target = "nm_iframe">
									<div class="form-group">
										<label for="Mail">Mail</label>
										<input type="text" name="username" placeholder="MailAddress..." class="form-username form-control" id="form-username">
									</div>
									<div class="form-group">
									</div>
									
								
									
									<button type="submit" class="btn">获取验证码</button>
									
								</form>
							 <iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>    
								<form role="form" id="logsub" action="Signup" method="post" class="logsub-form">
								<label for="Code">Code</label>
										<input type="text" name="code" placeholder="Code..." class="form-password form-control" id="form-password">
											<div></div>
											<font color="red">${Result}</font>
								<button type="submit" class="btn">提交</button>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>

		</div>

	
	</body>

</html>