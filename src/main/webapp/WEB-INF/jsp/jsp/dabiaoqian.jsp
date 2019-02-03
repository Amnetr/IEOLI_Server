<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<title>标注人员·打标签</title>
	<link href="system-default.css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->
	<script type="text/javascript">
	
    //回车事件
	document.onkeydown=keyListener;
   function keyListener(e){
    if(e.keyCode == 13){
     revise();
    }
   }
   
   function revise(btn,shuru){
		//alert(obj.id+obj.name);
		//var id = obj.id	
	document.getElementById(btn).style.backgroundColor="#32CD32";
	document.getElementById(btn).textContent=document.getElementById(btn).textContent+"&"+document.getElementById(shuru).value; 
		
	};		
	
		function tijiao(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
			var list = new Array();
			var max = ${fn:length(list)};
		for ( var i = 1 ; i <= max ; i++)
		{
		list[i]= document.getElementById(i).textContent;
		}
		var lists=list.join("$");
			$.ajax({
				url:"submitResult",
				data:{result:lists},
				method:"post",
				//dataType:"json"
				success:function(result){
					
						alert(result);
						window.opener=null;
						window.open('','_self');
						window.close();
		
					
				}
			});
		
	};
		
		
	
	</script>
	</head>
	<body>
<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
    <div class="navbar-header"> <a class="navbar-brand" href="page?path=selectType">标注人员系统</a> </div>
    <div>
          <ul class="nav navbar-nav pull-right">
        <li><a>欢迎你</a></li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" > ${user.username}<b class="caret"></b> </a>
              <ul class="dropdown-menu" style="text-align: center">
            <a href="index.action" style="text-decoration: none;text-align: center;color: black"  >退出登录</a>
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
    <div class="middle col-md-8" style="background-color: white;height: 100%;	box-shadow: 0px 6px 5px lightgrey inset;background-image: url(./img/bg.png)">   
          
          
          <h3 style="top: auto; font-family: youyuan;">为以下文本打标签</h1>
          
          
		
         
         <div style="border:2px solid #C9C9C9;margin: 20px;padding: 10px">

          <c:forEach items="${list}" var="word" varStatus="status">
        <button id="${status.count}" target="_blank" type="button" class="btn btn-default" style="margin-right:6px;margin-bottom:3px">${word}</button>
    <script type="text/javascript">  
                    $(function (){   
                        var ulstring=("<div align='centre'>"+"<input id='${status.count}shuru' type='text' align='left' style='width:130px;height:30px'></input>"  
					        +"<button id='biaoqianButton' style='width:45px;height:30px;' onclick=\"revise('${status.count}','${status.count}shuru' )\" >确认</button>"+"</div>");  
                        $("#${status.count}").popover({   
                            trigger:'manual',
                            placement : 'bottom',    
                            title:'<div style="text-align:left; color:gray; font-size:10%;">标签</div>',  
                            html: 'true',   
                            content : ulstring,  
                            animation: false  
                    								    }) .on("mouseenter", function () {  
                                    var _this = this;  
                                    $(this).popover("show");  
                                    $(this).siblings(".popover").on("mouseleave", function () {  
                                        $(_this).popover('hide');  
                                   																 }
                                   								);  
                        														        }
                        										).on("mouseleave", function () {  
                                    var _this = this;  
                                    setTimeout(function () {  
                                        if (!$(".popover:hover").length) {  
                                            $(_this).popover("hide")  
                                        									}  
                                   							 }, 100
                                   				);  
                                   																 }
                                   									)   
                   							 }); 	
                    
                    
                   </script>
      </c:forEach>
           </div>
           
           <div align="center"><button id="tijiao" class="btn btn-default" onClick="tijiao()">提交</button></div>
           
           
        </div>
    <div class="col-md-2"></div>
  </div>
    </div>
<!--选择模型类型-->

</body>

<style>

	#tijiao{
		background-color: #EFB336;
		border:none;
	}.middle{
		overflow-y: auto;
	}
.row{
		overflow-y: auto;
	}
</style>

</html>