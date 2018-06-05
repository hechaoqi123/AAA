<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'grzfcx.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
body{
	MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;
	}
	
	a{
	text-decoration:none;
	}
	 *{
  margin:0;
  padding:0;
   
 }
 	li{
	list-style-type: none;
	}
	input, textarea {
    padding: 4px;
    border: solid 1px #E5E5E5;
    outline: 0;
    font: normal 13px/100% Verdana, Tahoma, sans-serif;
    width: 200px;
    background: #FFFFFF;
    box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
    -moz-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;
    -webkit-box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 8px;    
}
#one{

width:800px;
height:500px;
margin-left:240px;
}
#two{

width:800px;
height:75px;
border-top:2px solid #006EC5
}
#three{
width:800px;
height:42px;
border:1px solid #7B7B7B;
}

#three ul li{
float:left;
 text-align:center;
	  line-height: 40px;
	  font-family:微软雅黑;
	  font-size:17px;
	  color:#7B7B7B;
	  margin-left:40px;
}
#zhong{
width:800px;
height:230px;
border:1px solid #7B7B7B;
border-top:0px;
border-bottom:0px;


}
#zhong div{

}
#zuo{
width:430px;
height:240px;

float: left;
}
#zuo ul{
margin-left:60px;
margin-top:30px;
}
#zuo ul li{
  font-family:微软雅黑;
  margin-top:20px;
}
#you{
width:430px;
height:240px;
display:none;
float: left;
}
#you ul{
margin-left:60px;
margin-top:30px;
}
#you ul li{
  font-family:微软雅黑;
  margin-top:20px;
}
#five{
width:364px;
height:240px;
float: right;
}
#six{
width:800px;
border:1px solid #7B7B7B;
height:143px;

}
#six ul{
margin-top:5px;
}
#six ul li{
font-family:微软雅黑;
font-size:14px;
}
#wei{
width:830px;
height:72px;
margin-top:20px;
margin-left:223px;
background:#00599F;

border:1px solid #00599F;

}
#wei ul{
margin-top:16px;
}
#wei ul li{
font-family:微软雅黑;
font-size:14px;
}
</style>
  
  <body>
 
<div id="one">
<div id="two"><img src="images/hu6.gif" style="margin-top:10px;"></div>

<div id="three">
<ul>
<li id="geren">个人登记号</li>
<li id="danwei">单位登记号</li>
</ul>
</div>

<div id="zhong">

<div id="zuo">

<ul>
<li>个人登记号:&nbsp&nbsp<input type="text"  id="zh"  style="width:270px;height:32px;border:1.5px solid #747474;"></li>
<li>&nbsp&nbsp&nbsp查询密码:&nbsp&nbsp<input type="password" style="width:270px;height:32px;border:1.5px solid #747474;"></li>
<li>图文验证码:&nbsp&nbsp<input type="text" id="input" style="width:140px;height:32px;border:1.5px solid #747474;"> <input type="button" id="code" onclick="createCode()" style="width:85px;height:35px;" title='点击更换验证码' /></li>
</ul>

<input type="button" onclick="querylist()" value="查&nbsp询"; style="width:80px;height:30px;background:#FFB533;color:white;border-radius:5px;font-family:微软雅黑;margin-left:180px;margin-top:14px;">


</div>

<div id="you">

<ul>
<li>单位登记号:&nbsp&nbsp<input type="text" id="zhi" style="width:270px;height:32px;border:1.5px solid #747474;"></li>
<li>&nbsp&nbsp&nbsp查询密码:&nbsp&nbsp<input type="password" style="width:270px;height:32px;border:1.5px solid #747474;"></li>

</ul>
<input type="button" onclick="querylistdw()" value="查&nbsp询"; style="width:80px;height:30px;background:#FFB533;color:white;border-radius:5px;font-family:微软雅黑;margin-left:180px;margin-top:44px;">

</div>

<div id="five">
<img src="images/hu8.png" style="width:300px;margin-left:32px;margin-top:26px;">
</div>

</div>


<div id="six">
<ul>
<center>
<li>提示：1、本查询功能只面向已成功申领住房公积金联名卡，且住房公积金账户处于“缴存”</li>
<li>和“封存”状态的缴存职工提供。未办理联名卡的缴存职工，请尽快办理。</li>
<li>点击此处查看北京住房公积金联名卡办理条件和办理流程</li>
<li>点击此处查看公积金卡样式</li>
<li>2、如您在使用住房公积金查询系统时某些页面无法正常打开，建议使用IE8及以下浏</li>
<li>览器，我中心目前正在积极升级系统解决该问题，由此带来的不便敬请谅解。</li>
</center>
</ul>
</div>



</div>
<div id="wei">
<ul>
<center>
<li style="color:#FFFFFF">版权所有(2003-2009)北京住房公积金管理中心</li>
<li style="color:#DFDF00">联系我们 意见建议 客服电话 12323</li>
</center>
</ul>
</div>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
//获取随机验证码
	  //设置一个全局的变量，便于保存验证码
	 var code;
	 function createCode(){
	  //首先默认code为空字符串
	  code ="";
	  //设置长度为4
	  var codeLength = 4;
	  var codeV = document.getElementById("code");
	  //设置随机字符
	  var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
	  //循环
	  for(var i = 0; i < codeLength; i++){
	   //设置随机数范围为0 ~ 36
	    var index = Math.floor(Math.random()*36);
	    //字符串拼接 将每次随机的字符 进行拼接
	    code += random[index]; 
	  }
	  //赋值
	  codeV.value = code;
	"G:/111/index7.jsp" }
	 //判断
	 function validate(){
	  var oValue = document.getElementById('input').value.toUpperCase();
	  if(oValue ==0){
	   alert("请输入验证码");
	  }else if(oValue != code){
	   alert("验证码不正确，请重新输入");
	   oValue = ' ';
	   createCode();
	  }else{
	   window.open('http://www.baidu.com','_self');
	  }
	 }
	 //设置此处的原因是每次进入界面展示一个随机的验证码，不设置则为空
	 window.onload = function (){
	  createCode();
	 }
	 
		 /*点击切换*/
	$("#danwei").click(
function(){
 /*$("#zy").css("background","#f7f7f7");
$("#zz").css("background","#EEEEEE");*/
$("#danwei").css("border-top","2.0px solid #0084BB");
$("#geren").css("border-top","0px solid #fff");
/* $("#three").css("border-bottom","0px");  */
$("#danwei").css("color","#0084BB");
$("#geren").css("color","");
$("#you").css("display","block");
$("#zuo").css("display","none");
}
)
$("#geren").click(
function(){
/* $("#zz").css("background","#f7f7f7");
$("#zy").css("background","#EEEEEE");*/
$("#danwei").css("border-top","0px solid #fff");
$("#geren").css("border-top","2.0px solid #0084BB");
$("#geren").css("color","#0084BB");
$("#danwei").css("color","");
$("#zuo").css("display","block");
$("#you").css("display","none");
}
)

  
 function querylist(){
       var zh=$("#zh").val();
       
       if(zh==""){
       alert("请输入账号密码");
       return flase;
       }else{
    $.ajax({
             url:"query.action",
             type:"get",
             data:{"loginAccount":zh},
             dataType:"json",
             success:function(data){
                 /* //每次记载之前先清空当前页面的数据
             $("#myTab").html('');
                 for(var i=0;i<data.list.length;i++){
                   var tr="<tr>";
                   tr+="<td>"+data.list[i].sid+"</td>";
                   tr+="<td>"+data.list[i].sname+"</td>";
                   tr+="<td>"+data.list[i].cname+"</td>";
                  
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
                   } */
                    window.location.href="usershow.jsp?lo="+zh;
                 },
                 error:function(date){
                 alert("输入信息有误，请重新输入");
                 }
                 
          })
         } 
          }
 function querylistdw(){
       var zhi=$("#zhi").val();
       
       if(zhi==""){
       alert("请输入账号密码");
       return flase;
       }else{
    $.ajax({
             url:"query2.action",
             type:"post",
             data:{"utinNumber":zhi},
             dataType:"json",
             success:function(data){
            
                 /* //每次记载之前先清空当前页面的数据
             $("#myTab").html('');
                 for(var i=0;i<data.list.length;i++){
                   var tr="<tr>";
                   tr+="<td>"+data.list[i].sid+"</td>";
                   tr+="<td>"+data.list[i].sname+"</td>";
                   tr+="<td>"+data.list[i].cname+"</td>";
                  
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
                   } */
                    window.location.href="utinshow.jsp?ut="+zhi;
                 },
                  error:function(date){
                 alert("输入信息有误，请重新输入");
                 } 
          })
}
    }      
</script>