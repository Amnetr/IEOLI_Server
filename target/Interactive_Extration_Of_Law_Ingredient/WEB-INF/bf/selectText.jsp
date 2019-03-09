<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    <title>标注人员·选择文本</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="system-default.css">
	
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->
	<script type="text/javascript" src="bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css" type="text/css"/>
	</head>
	
	<body>
		<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">标注人员系统</a>
    </div>
    <div>
        <ul class="nav navbar-nav pull-right">
           <li><a>欢迎你，标注人员</a></li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    人员名字<b class="caret"></b>
                </a>
                <ul class="dropdown-menu pull-left">
                    <li><a href="#">查看我的信息</a></li>
                    <li><a href="#"></a></li>
                    <li class="divider"></li>
                    <li><a href="#">修改我的信息</a></li>
                    <li class="divider"></li>
                    <li><a href="#">退出登录</a></li>
                </ul>
            </li>
        </ul>
    </div>
	</div>
</nav>
<!--标题栏-->
     <div class="headline">
     <div class="row">
     	<div class="col-md-2"></div>
     	<div class="col-md-8">
     		<h3>选择文本 </h3>
    			<div class="composing" style="height: 40px;"></div>
     		  	
     		  	
<!-- 按钮触发模态框 -->
<button class="btn btn-link btn-lg" data-toggle="modal" data-target="#myModal">标题一</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">文本1</h4>
            </div>
            <div class="modal-body">
            	<iframe name="show"id="show" width="500" height="500"src="1.txt"></iframe>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="window.open('label.html') " type="submit" class="btn btn-primary">确认选择</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<button class="btn btn-link btn-lg" data-toggle="modal" data-target="#myModal">标题二</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">文本2</h4>
            </div>
            <div class="modal-body">
            	<iframe name="show"id="show" width="500" height="500"src="1.txt"></iframe>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="window.open('label.html') " type="submit" class="btn btn-primary">确认选择</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


	</body>
</html>
