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
<title>标注人员后台管理</title>
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
</head>

<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header header header-demo">
    <div class="layui-main">
      <div class="admin-login-box"> <a class="logo" style="left: 0;" href="#"> <span style="font-size: 22px;">后台管理系统</span> </a>
        <div class="admin-side-toggle"> <i class="fa fa-bars" aria-hidden="true"></i> </div>
      </div><br>
      <ul class="layui-nav admin-header-item">
        <li class="layui-nav-item"> <a href="javascript:;" class="admin-header-user"> <img src="images/0.jpg" /> <span>beginner</span> </a>
          <dl class="layui-nav-child">
            <dd> <a href="javascript:;"><i class="fa fa-user-circle" aria-hidden="true"></i> 个人信息</a> </dd>
            <dd> <a href="page?path=index"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a> </dd>
          </dl>
        </li>
      </ul>
      <ul class="layui-nav admin-header-item-mobile">
        <li class="layui-nav-item"> <a href="login.jsp"><i class="fa fa-sign-out" aria-hidden="true"></i> 注销</a> </li>
      </ul>
    </div>
  </div>
  
  <!--锁屏模板 start--> 
  <script type="text/template" id="lock-temp">
				<div class="admin-header-lock" id="lock-box">
					<div class="admin-header-lock-img">
						<img src="images/0.jpg"/>
					</div>
					<div class="admin-header-lock-name" id="lockUserName">beginner</div>
					<input type="text" class="admin-header-lock-input" value="输入密码解锁.." name="lockPwd" id="lockPwd" />
					<button class="layui-btn layui-btn-small" id="unlock">解锁</button>
				</div>
			</script> 
  <!--锁屏模板 end --> 
  
  <script type="text/javascript" src="plugins/layui/layui.js"></script> 
  <script type="text/javascript" src="datas/nav.js"></script> 
  <script src="js/index.js"></script> 
  <script>
				layui.use('layer', function() {
					var $ = layui.jquery,
						layer = layui.layer;

					$('#video1').on('click', function() {
						layer.open({
							title: 'YouTube',
							maxmin: true,
							type: 2,
							content: 'video.jsp',
							area: ['800px', '500px']
						});
					});

				});
			</script> 
</div>
<div class="row" style="margin-top: -20px">
  <div class="col-md-2"></div>
  <div class="middle col-md-8" style="background-color: white;">
    <div >
      <iframe id="external-frame" style="width: 100%;height:1000px; margin-top: 40px" src="jsp/dabiaoqian.jsp" frameborder="0" scrolling="no" onload="setIframeHeight(this)"></iframe>
    </div>
  </div>
  <div class="col-md-2"></div>
</div>
<script>
	function setIframeHeight(iframe) {
		if (iframe) {
			var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
			if (iframeWin.document.body) {
iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
}
}
};

window.onload = function () {
setIframeHeight(document.getElementById('external-frame'));
};
</script>
</body>
</html>