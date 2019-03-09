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
	window.curid=0;
	window.curcond=0;
	window.editted = new Array();
	 window.array1= new Array();
	 window.colorc =  new Array();
                    window.array2= new Array();
                   <c:forEach items="${tasks}" var="task" varStatus="status">
                         window.array1.push(${task.taskid});
                         window.array2.push('${task.taskdescription}');
                        
                         </c:forEach>
                          window.p = new Array();
                          window.att=new Array();
                        for(var i = 0 ; i<array1.length;i++)
                        {
                         window.p.push(("<div><span style='font-weight:bold'>"+array2[i]+":  </span>"));
                         window.att.push(array1[i]);
                        }
    //回车事件
	//document.onkeydown=keyListener;
   function keyListener(e){
    if(e.keyCode == 13){
   //  revise();
    }
   }
   function revise(tsk,spd){
		//alert(obj.id+obj.name);
		//var id = obj.id
		
		editted.push(curid);
		document.getElementById(curid).style.backgroundColor="#32CD32";
		var radio1 = document.getElementsByName("shuru");
		var valuejieduan =0;
		for(var i = 0 ; i<radio1.length;i++)
		{
		if(radio1[i].checked)
		{
		valuejieduan = radio1[i].value;
		}
		}
		var content =document.getElementById(curid).textContent.split("&");
		var condxx=0;
		
		if(content.length>1)//有标签
		{
		
			for(var i = 1 ; i<content.length;i++)
			{
			
				if(tsk==content[i].split("_")[1])//找到了
				{
				
				condxx =1;
					if(spd!="0")
					{
						content[i] = valuejieduan+"_"+tsk+"_"+spd;
					}else
					{
						content[i]="";
						if(content.length==2)//只有这一个标签
						{
							reset();
						}
					}
					
				}
				
			}
			
			if(condxx==0)//没找到
			{
			if(spd!="0")
					{
				document.getElementById(curid).textContent+="&"+valuejieduan+"_"+tsk+"_"+spd;
				}else
				{
				
				}
			}else
			{
				document.getElementById(curid).textContent=content[0];
				for(var i = 1 ; i<content.length;i++)
				{
					if(content[i]!="")
					{
					document.getElementById(curid).textContent+="&"+content[i];
					}
				}
			}
			
		}else//没标签
		{
		if(spd!="0")
			{
			document.getElementById(curid).textContent=document.getElementById(curid).textContent.split("&")[0];//原文内容
			document.getElementById(curid).textContent+="&"+valuejieduan+"_"+tsk+"_"+spd;
			}else
			{
			
			}
		}
		
		
		//document.getElementById(curid).textContent+="&"+valuejieduan+"_"+attr+"_"+tempradio[j].value;
		/*
	document.getElementById(btn).textContent=document.getElementById(btn).textContent.split("&")[0]+"&"+document.getElementById(shuru).value
	+"_"+document.getElementById(shuru2).value; 
	var opts = document.getElementsByName(btn+"word");
	for(var i = 0 ; i<opts.length;i++)
	{
	if (opts[i].checked)
	{
	document.getElementById(btn).textContent=document.getElementById(btn).textContent+"_"+opts[i].value;
	}
	}
		*/
	
	update();
	};		
	function update()
	{
	for(var i = 0 ; i<att.length;i++)
	{
	document.getElementById(att[i]+"default").setAttribute("checked","true");
	}
	for( var i = 1 ; i<9;i++)
	{
	document.getElementById("jieduan"+i).setAttribute("style","display:none");//初始化所有阶段
	for(var j = 0 ; j<array1.length;j++)
	{
	document.getElementById("jieduan"+i+"-"+array1[j]).innerHTML = array2[j]+"：";//初始化所有子标签
	}
	var jj = document.getElementsByName("jieduan"+i+"son");
	for ( var j = 0 ; j<jj.length;j++)
	{
	jj[j].setAttribute("style","display:none");
	}
	}
	var list = new Array();
			var max = ${fn:length(list)};
		for ( var i = 1 ; i <= max ; i++)
		{
		if(document.getElementById(i).textContent.match("&"))
		{
		var labels = document.getElementById(i).textContent.split("&");
		for(var j = 1;j<labels.length;j++)
		{
		list.push(i+"$"+labels[0]+"&"+labels[j]);
		}
		
		}
		}
		//list为所有带标签内容
		var start = new Array();
		var end = new Array();
		var single = new Array();
		for( var i = 0 ; i <list.length;i++)
		{
		var str = list[i];
		temp = str.split("_");
		switch(temp[temp.length-1])
		{
		case "s":
		start.push(str);
		break;
		case "p":
		end.push(str);
		break;
		case "d":
		single.push(str);
		break;
		}
		}
		for (var i = 0 ; i <single.length;i++)
		{
		var labelxx = single[i].split("\$");
		var label = labelxx[1];
		var labels = label.split("&");
		var labelsp = labels[1].split("_");
		var jieduan = labelsp[0];
		var attr = labelsp[1];
		var word = labels[0];
		document.getElementById("jieduan"+jieduan).setAttribute("style","display:block");
		document.getElementById("jieduan"+jieduan+"-"+attr).setAttribute("style","display:block");
		document.getElementById("jieduan"+jieduan+"-"+attr).append(word+"、");
		}
		for(var i = 0 ; i <start.length;i++)
		{
		var index = start[i].split("\$")[0];
		var label = start[i].split("&")[1];
		label = label.substring(0,label.length-1);
		for(var j = 0 ; j<end.length;j++)
		{
		var endindex = end[j].split("\$")[0];
		var endlabel = end[j].split("&")[1];
		endlabel = endlabel.substring(0,endlabel.length-1);
		if(parseInt(endindex)>parseInt(index)&&label==endlabel)
		{
		//匹配成功
		var jieduan = endlabel.split("_")[0];
		var attr = endlabel.split("_")[1];
		var word = getcontent(index,endindex);
		document.getElementById("jieduan"+jieduan).setAttribute("style","display:block");
		document.getElementById("jieduan"+jieduan+"-"+attr).setAttribute("style","display:block");
		document.getElementById("jieduan"+jieduan+"-"+attr).append(word+"、");
		break;
		}
		}
		}
	};
	function reset()
	{
	document.getElementById(curid).style.backgroundColor="#EEEEEE";
	document.getElementById(curid).textContent=document.getElementById(curid).textContent.split("&")[0]; 
	for(var i = 0 ; i<editted.length;i++)
	{
	if(curid == editted[i])
	{
	editted[i]=0;
	}
	}
	update();
	};
	function getcontent(start,end)
	{
	var toR="";
	for(var i = parseInt(start) ; i<=parseInt(end);i++)
	{
	var a = document.getElementById(i).textContent;
	toR+= a.split("&")[0];
	}
	return toR;
	};
		function tijiao(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
        if(!confirm("确认提交标注结果？"))
		{
			return;
		}
		var list1 = new Array();
			var max1 = ${fn:length(list)};
				for ( var i = 1 ; i <= max1 ; i++)
		{
		if(document.getElementById(i).textContent.match("&"))
		{
		var labels = document.getElementById(i).textContent.split("&");
		for(var j = 1;j<labels.length;j++)
		{
		list1.push(i+"$"+labels[0]+"&"+labels[j]);
		}
		
		}
		}
		//list为所有带标签内容
		var start = new Array();
		var end = new Array();
		var single = new Array();
		for( var i = 0 ; i <list1.length;i++)
		{
		var str = list1[i];
		temp = str.split("_");
		switch(temp[temp.length-1])
		{
		case "s":
		start.push(str);
		break;
		case "p":
		end.push(str);
		break;
		case "d":
		single.push(str);
		break;
		}
		}
			for(var i = 0 ; i <start.length;i++)
		{
		var pipei =0;
		var index = Number(start[i].split("\$")[0]);
		var label = start[i].split("&")[1];
		label = label.substring(0,label.length-1);
		for(var j = 0 ; j<end.length;j++)
		{
		var endindex = Number(end[j].split("\$")[0]);
		var endlabel = end[j].split("&")[1];
		endlabel = endlabel.substring(0,endlabel.length-1);
		if(parseInt(endindex)>parseInt(index)&&label==(endlabel))
		{
		//匹配成功
		var jieduan = endlabel.split("_")[0];
		var attr = endlabel.split("_")[1];
		var word = getcontent(index,endindex);
		pipei =1;
		break;
		}
		}
		if(pipei==0)//没匹配到
		{
		document.getElementById(index).style.backgroundColor="#FF0000";
		
		alert("缺少结束词，出现问题之处已标红");
		return;
		}
		}
		for(var i = 0 ; i <end.length;i++)
		{
		var pipei =0;
		var index = Number(end[i].split("\$")[0]);
		var label = end[i].split("&")[1];
		label = label.substring(0,label.length-1);
		for(var j = 0 ; j<start.length;j++)
		{
		var startindex = Number(start[j].split("\$")[0]);
		var startlabel = start[j].split("&")[1];
		startlabel = startlabel.substring(0,startlabel.length-1);
		if(parseInt(startindex)<parseInt(index)&&label==(startlabel))
		{
		//匹配成功
		pipei =1;
		break;
		}
		}
		if(pipei==0)//没匹配到
		{
		document.getElementById(index).style.backgroundColor="#FF0000";
		
		alert("缺少开始词，出现问题之处已标红");
		return;
		}
		}
			var list = new Array();
			var max = ${fn:length(list)};
		for ( var i = 1 ; i <= max ; i++)
		{
		list[i]= document.getElementById(i).textContent;
		}
		var lists=list.join("$");
			$.ajax({
				url:"submitHT",
				data:{result:lists},
				method:"post",
				//dataType:"json"
				success:function(result){
					
						alert("提交成功");
						location.reload();
		
					
				}
			});
		
	};
		function action(id)
		{
				document.getElementById(id).style.backgroundColor="#32CD32";
		var preid = curid;
		curid = id;
		for (var i = 0 ; i<editted.length;i++)
		{
		if(preid == editted[i])//已打标签
		{
		return;
		}
		}
		document.getElementById(preid).style.backgroundColor="#EEEEEE";
		colorc.push(preid);
		for(cor in colorc)
		{
		if(id == cor)//在里面
		{
		document.getElementById(id).style.backgroundColor="#32CD32";
		cor="";
		}
		}
				};
		     
            function refresh()
            {
				if(confirm("如果更换文章，所有标注结果不会保存"))
				{
					location.reload();
				}
            
            }            
	
	</script>
	</head>
	<body>

<!--标题栏-->
<div class="container" style ="height: auto;">
      <div class="row" style="margin-top: 0px;height: 100vh; margin-left:0px">
 <div class="col-sm-2 col-lg-2" style="border-left: 1px purple solid">
 <h3 id="jieduan1" style= "display:none"> 第一阶段：</h3>
 <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan1son" id = "jieduan1-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
 <h3 id="jieduan2" style= "display:none"> 第二阶段：</h3>
  <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan2son" id = "jieduan2-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
  <h3 id="jieduan3"  style= "display:none"> 第三阶段：</h3>
   <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan3son" id = "jieduan3-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
  <h3 id="jieduan4"  style= "display:none"> 第四阶段：</h3>
   <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan4son" id = "jieduan4-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
  <h3 id="jieduan5"  style= "display:none"> 第五阶段：</h3>
   <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan5son" id = "jieduan5-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
  <h3 id="jieduan6"  style= "display:none"> 第六阶段：</h3>
   <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan6son" id = "jieduan6-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
  <h3 id="jieduan7"  style= "display:none"> 第七阶段：</h3>
   <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan7son" id = "jieduan7-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
  <h3 id="jieduan8"  style= "display:none"> 第八阶段：</h3>
   <c:forEach items="${tasks}" var="task" varStatus="status">
 <div name="jieduan8son" id = "jieduan8-${task.taskid}" style= "display:none">${task.taskdescription }:</div>
 </c:forEach>
       <h3></h3>
       
   <button class="btn btn-default" onClick="refresh()">换一篇</button>
   <button id="tijiao" class="btn btn-default" onClick="tijiao()">提交标注</button>
    </div>
    <div class="middle col-md-7" style="background-color: white;height: 100%;background-image: url(./img/bg.png)">   
          

         <div style="border:2px solid #C9C9C9;margin: 20px;padding: 5px">
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
          <c:forEach items="${list}" var="word" varStatus="status">
          <c:choose>
           <c:when test="${word=='/p'}">
          <div> <p id="${status.count}"></p></div>
          &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
            
          </c:when>
          <c:otherwise> 
            <span id="${status.count}" target="_blank" onClick="action('${status.count}')" style="font-size:20px;margin-right:2px;margin-bottom:3px;backgroundColor:#EEEEEE">${word}</span>
  
          </c:otherwise>
          </c:choose>
      
      </c:forEach>
           </div>
           
         
           
           
        </div>
  <div class="col-sm-8 col-lg-3" style="border-left: 1px purple solid">
<div align="centre">
                         <input type="radio" name="shuru" value=1 checked="true" ><span style="font-size:20px">第一阶段</span></input>
                         <input type="radio" name="shuru" value=2><span style="font-size:20px">第二阶段</span></input>
                          <div>&nbsp;</div>
                         <input type="radio" name="shuru" value=3><span style="font-size:20px">第三阶段</span></input>
                         <input type="radio" name="shuru" value=4><span style="font-size:20px">第四阶段</span></input>
                          <div>&nbsp;</div>
                         <input type="radio" name="shuru" value=5><span style="font-size:20px">第五阶段</span></input>
                         <input type="radio" name="shuru" value=6><span style="font-size:20px">第六阶段</span></input>
                          <div>&nbsp;</div>
                         <input type="radio" name="shuru" value=7><span style="font-size:20px">第七阶段</span></input>
                         <input type="radio" name="shuru" value=8><span style="font-size:20px">第八阶段</span></input></div>
                          <div>&nbsp;</div>
                           <c:forEach items="${tasks}" var="task" varStatus="status">
 <div><span style="font-size:18px;font-weight:bold;color:#00F" >${task.taskid}.${task.taskdescription }：</span></div>
 <div>
 <button onClick="revise('${task.taskid}','s')"><span style="font-size:16px">起始s</span></button>
 <span>&nbsp;&nbsp;</span>
 <button onClick="revise('${task.taskid}','p')"><span style="font-size:16px">结束p</span></button>
 <span>&nbsp;&nbsp;</span>
 <button onClick="revise('${task.taskid}','d')"><span style="font-size:16px">独立d</span></button>
  <span>&nbsp;&nbsp;</span>
  <button id="${task.taskid }default" onClick="revise('${task.taskid}','0')" style="font-size:16px"><span style="font-size:16px">无</span></button></div>
 <div>&nbsp;</div>
 </c:forEach>
                    <!--     <button id="biaoqianButton" style="width:120px;height:30px;" onclick="revise()" >确认</button>
                       <button id='resetButton' style='width:120px;height:30px;' onclick="reset()" >复位</button>-->
                       </div>
</div>

   
  </div>

    </div>
<!--选择模型类型-->

</body>

<style>
.middle{
		overflow-y: auto;
	}
.row{
		overflow-y: auto;
	}
	.popover {
            position: absolute;
            top: 0;
            left: 0;
            z-index: 1060;
            display: none;
            max-width: 325px;
            padding: 1px;
            font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
            font-size: 14px;
            font-style: normal;
            font-weight: 400;
            line-height: 1.42857143;
            text-align: left;
            text-align: start;
            text-decoration: none;
            text-shadow: none;
            text-transform: none;
            letter-spacing: normal;
            word-break: normal;
            word-spacing: normal;
            word-wrap: normal;
            white-space: normal;
            background-color: #fff;
            -webkit-background-clip: padding-box;
            background-clip: padding-box;
            border: 1px solid #ccc;
            border: 1px solid rgba(0,0,0,.2);
            border-radius: 6px;
            -webkit-box-shadow: 0 5px 10px rgba(0,0,0,.2);
            box-shadow: 0 5px 10px rgba(0,0,0,.2);
            line-break: auto;
        }
        input[type=radio]{
        	width:16px;
        	height:16px;
        }
</style>

</html>