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
	<title>标注人员·打标签</title>
	<link href="system-default.css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->
	</head>
	<body>

    
    <div class="container" style="height: auto;">
			<div class="row">
				
				<div class="col-sm-12 col-lg-8" style="border-right: 0px #3C3C3C solid;margin-top: 30px; height: auto;">
					
					<h2 class="page-header" >请从以下文本提取相关要素</h2>
					
					<div  style="margin-bottom: 10px;border: 0px;">
						
						<c:forEach items="${list}" var="word" varStatus="status">
                      <div id="${status.index}" class="thumbnail">
                           <p class="pull-left"><span class="badge" style="background-color:#122B40;">${status.count}</span></p><br></br>
                             <p id="article${status.index}" class="article"> ${word.article}</p>
                      </div>
                   
                   </c:forEach>
						
							
					</div>
					
					<div style="margin-bottom: 30px;text-align: center;">
						 <button id="fanye" class="btn btn-default" onClick="window.location.href='page?path=nextpage	'">下一页</button>
					</div>
					
					<form role="form"  action="" method="post" style="margin:0px auto;">
					<div class="row">
						     	<div class="col-md-8" style="margin-bottom: 30px;"> <input  id="bcontent"  type="text" class="form-control" placeholder="请输入规则描述" /></div>
			<div class="col-md-4">
				<div><input type="button" class=" btn btn-warning" onclick="tijiao()" value="提交" />
			 <input type="button" class=" btn btn-default" onclick="ceshi()" value="测试" /></div>
				
			</div>
			 </div>
		</form>
		
		<div  style="margin-top: 10px;margin-bottom: 30px;border: 0px;">
			<b>书写规范：</b>
			<h4 align="center"><b>字符类型（字符个数）[精确查找内容]</b> </h4>
			<span>1、字符类型可为“数字”、“汉字”、“字符串”，其中“字符串”可匹配到任意字符</span><br />
			<span>2、字符类型、字符个数对应精确查找内容前的字符</span><br />
			<span>3、若精确查找内容前无所需匹配的字符请输入“任意字符类型(0)”</span><br />
			<span>4、字符个数可以为空，默认为匹配任意个数的字符</span><br />
			<span>5、字符个数若有多种选择，请用逗号隔开</span><br />
			<span>6、所有标点请使用纯英文标点，使用"[]"将需要精确查找的内容括起来</span><br />
			<span>7、如果需要同时满足多种规则，可以用\n来分隔多个规则来表示“或”关系</span><br />
			<br />
			<b>举例</b><br />
			<span>Exp1.</span><br />
			<i>匹配项：</i> 2018年3月17日<br />
		
			<i>规则：</i>数字(4)[年]数字(1,2)[月]数字(1,2)[日]<br />
				<span>Exp2.</span><br />
			<i>匹配项：</i> 《高等数学》<br />
			<i>规则：</i>数字(0)[《]汉字()[》]<br />
				<span>Exp3.</span><br />
			<i>匹配项：</i> 《高等数学_A》<br />
			<i>规则：</i>数字(0)[《]字符串()[》]<br />
				<span>Exp4.</span><br />
			<i>匹配项1：</i> 《高等数学_A》<br />
			<i>匹配项2：</i> 2018年3月17日<br />
			<i>如果要同时匹配两者，则规则为：</i>数字(0)[《]字符串()[》]\n数字(4)[年]数字(1,2)[月]数字(1,2)[日]<br />
			此时，两种情况都能匹配到<br />
		</div>
		
				</div>
				
				<div class="col-sm-12 col-lg-4 " style="border-left: 1px purple solid">
					<h3 class="page-header" style="opacity: 1;color: purple;">已有要素规则</h3>
					
					<script type="text/javascript">
						$('.collapse').collapse()
					</script>
					
					
					 <c:forEach items="${rules}" var="result" varStatus="status">
                       <div class="panel panel-default">
							<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse"  href="#c${status.index}">
									<span id="${result.ruleid }content">${result.description}</span> 
									<span class="caret"></span>
								</a>
							</h4>
						</div>
						<div id="c${status.index}" class="panel-collapse collapse ">
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-8">
										<p>作者：${result.userid}</p>
								        <p>正确率：${result.rate }</p>
								        <p>标注时间：${result.lastupdatetime }</p>
									</div>
									<div class="col-lg-4" style="text-align: center;">
										<button title="修改规则" class="btn btn-default" 
										onclick="revises('${result.ruleid }','${result.description}')"
										type="button"  >
										<span class="glyphicon glyphicon-edit"></span>
										</button>
									</div>
								</div>
								
								
							</div>
							
						</div>
						</div>
		            
                   </c:forEach>
					
					</div>
				
				</div>
			
			</div>
    
    
    
    <!-- ------------------------------------------------------------------------------------------------------------------ -->

<!--标题栏-->

<!--选择模型类型-->
    <script type="text/javascript">  
	//document.onkeydown=keyListener;
   function keyListener(e){
    if(e.keyCode == 13){
     revise();
    }
   }
   
   function revise(btn,shuru){
		//alert(obj.id+obj.name);
		//var id = obj.id	
	document.getElementById(btn).style.backgroundColor="#EFB336";
	document.getElementById(btn).textContent=document.getElementById(btn).textContent+"&"+document.getElementById(shuru).value; 
		
	};		
	
	function revises(rid,rcontent){
		var content=document.getElementById(rid+"content").textContent;
		var update=prompt("修改为：",content);
		if(update!=null&& update!=""&&update!=content){
		$.ajax({
			url:"submitresult",
			data:{code:"2",description:update,ruleid:rid},
			method:"post",
			//dataType:"json"
			success:function(result){
				$("#"+rid+"content").text(update);
					alert(result);
				window.location.reload();
			}
		});
		}
	}
	
		function tijiao(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
			var content=document.getElementById("bcontent").value;
			

			$.ajax({
				url:"submitresult",
				data:{code:"1",description:content},
				method:"post",
				//dataType:"json"
				success:function(result){
					
						alert(result);
					window.location.reload();
				}
			});
		
	}
		
		function ceshi(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
		
			var content=document.getElementById("bcontent").value;
			var article=document.getElementById("article0").textContent+"#"+document.getElementById("article1").textContent;

			$.ajax({
				url:"submitresult",
				data:{code:"0",description:content,article:article},
				method:"post",
				//dataType:"json"
				success:function(result){
					
						alert(result);
					
				}
			});
		
	}
			function fanye(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
		
			$.ajax({
				url:"page?path=nextpage",
				method:"post",
				//dataType:"json"
				success:function(result){

					
				}
			});
		
	};
                   </script>
</body>

<style>
	.input-border{
		border:2px solid #C9C9C9;margin: 20px;padding: 10px
	}
	.row{
		overflow-y: auto;
	}
	#tijiao{
		background-color: #EFB336;
		border:none;
	}
	.middle{
		overflow-y: auto;
	}
</style>
</html>