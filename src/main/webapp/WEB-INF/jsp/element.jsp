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
    <title>要素挑选人员·要素列表</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="system-default.css">
	
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->
	<script type="text/javascript" src="bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css" type="text/css"/>
<style>
	body{
		overflow:scroll;
		overflow-x: hidden;
		overflow-y: hidden;
		}
	.container-fluid{
		background-color:lightgrey;
		opacity:0.6;
	}
	.row{
		margin-top:-20px;
		height:100vh;
		
	}
	.col-md-8{
		box-shadow: 0px 6px 5px lightgrey inset;
		background:url(img/bg.png);
		height:100vh;
		overflow-y: scroll;
		}	
	#rectrangle{
		float: left;
		height:35px;
		width:6px;
		background-color:#1AA094;
		margin:30px 7px 30px 30px;
	}
	#title{
		margin:30px 30px 30px 7px;
		padding:0px;
		font-family:"PingHei";	
		font-size: 30px;
	}
	.btn{
		background-color:#1AA094;
		border:none;
	}
	.prepanel{
		height:100vh;
		background-color: rgba(255,255,255,0.3);
		padding:10px 20px 0px 20px;
	}
	#pretiltle{
		font-family:"PingHei";
		font-size:20px;
		margin:0px 10px 20px 10px;
	}
	


</style>
	</head>
	<body>
	

<!--标题栏-->
     <div class="headline">
     <div class="row">
     	<div class="col-md-2"></div>
     	<div class="col-md-8">
     		<div id="rectrangle"></div>
     		<h3 id="title">挑选要素 </h3>
    			
    			<div class="prepanel">
 		
    			<div class="panel-group" id="accordion">	
    				
    					<c:forEach items="${list}" var="model">
    						<div style="margin-top: 10px">
						        <div class="thumbnail">
							        <div class="caption" align="center">
								        <p id="modelid" name="userID">序号:${model.modelid}</p>
								        <p id="modeldescription">要素：${model.modelname}</p>
								        <p align="center">
								            <a href="setTaskEle?models=${ model.modelid}" target="_blank" class="btn btn-info" role="button">选择</a>
								        </p>
							        </div>
						        </div>
					        </div>
                        </c:forEach>
                    
                </div>
                </div>
       </div>
       <div class="col-md-2"></div>
      </div>
 	
</div>

	</body>
</html>
 