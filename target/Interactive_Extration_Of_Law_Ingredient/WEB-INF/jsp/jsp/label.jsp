<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>标注人员·打标签</title>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link href="system-default.css">
	    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    
<style>
* {
    box-sizing: border-box;
}
.container{
	display:flex;
	flex-direction:column;
	flex-wrap: wrap;
	width:1100px;
	height:700px;
}
.showtext{
	background-color:lightgrey;
	border:solid 1px;
	width:850px;
	height:400px;
	padding:20px;
}
.dolabel{
    background-color:lightgrey;
    border:solid 1px;
	width:850px;
	height:200px;
	padding:20px;
}
.showlabel{
	background-color:lightgrey;
	border:solid 1px;
	width:250px;
	height:600px;
	padding:20px;
}


	</style>    
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
     		<h3>标注文本 </h3>
     	</div>
    </div>
    </div>
    <div class="composing" style="height: 20px;"></div>
    
    <div class="col-md-1"></div>
    <div class="col-md-8">

    		<div class="container">
    					    <div class="showtext" >文本内容</div>
    					    <div class="dolabel">
    					    	<textarea class="form-control" rows="5"></textarea>
    					    	<div class="composing" style="height: 10px;"></div>
    					    	<div class="form-group col-md-offset-9">
    					    		<button type="reset" class="btn btn-default" name="reset">重写标签</button>
    					    		<button type="submit" class="btn btn-default" name="submit">提交标签</button>
    					    	</div>	
    					    </div>
    					    
    					    <div class="showlabel">标签内容</div>			 		
     		</div>  	
	</body>
</html>

