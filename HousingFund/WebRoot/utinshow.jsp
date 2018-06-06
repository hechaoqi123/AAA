<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usershow.jsp' starting page</title>
    
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
	  #topmenu ul{
	   border:0px solid green;
	   width:1250px;
	   height:46px;
	   margin-left: 30px;
	  }
	  #topmenuul li:HOVER{
	  background-color:#016ec5;
	  }
	  #topmenu ul li{
	  border:0px solid black;
	  font-family:微软雅黑;
	  font-size:18px;
	  width:160px;
	  height:46px;
	  float: left;
	  color: white;
	  text-align:center;
	  line-height: 48px;
	  }
	  

	  #lunboleft{
	   border:0px solid #fff;
	  }
	  #shang{
	  width:310px;
	  height:65px;
	    border:1px solid #fff;
	    margin-top: 15px;
	  margin-left: 25px;
	  font-size: 18px;
	  line-height:125px;
	  text-align: center;
	  background:url(images/hu1.png) no-repeat;
	  }
	  	  #xia{
	  width:310px;
	  height:65px;
	     border:1px solid #fff;
	    margin-top: 15px;
	  margin-left: 25px;
	  font-size: 18px;
	  line-height:125px;
	  text-align: center;
	  
	  background:url(images/hu2.png) no-repeat;
	  }
	 
	 
	   #last ul li{
	   width:130px;

	   height:96px;
	   float: left;
	   } #last ul li img{
	 
	position: relative;
	top:20px;
	
	   }
#zong{
height:780px;
border:1px solid #000;
}
#tou{
height:200px;
border:1px solid #000;
}
#zhong{
height:376px;
background:url(images/hu3.jpg) no-repeat;
width:1190px;
margin-left:30px;
margin-top:30px;

}
#wei{
height:200px;
border:1px solid #000;
}
</style>
  </head>
  
  <body>
  
    <div style="width: 100%;height: 785px;border: 0px solid red;">

<!-- 头部图片 -->
<div style="width:100%;height:135px;">
  <img alt="" src="images/2017112115540812702.jpg" style="height:135px;width:100%">
</div>
<!-- 头部菜单 -->
<div style="width: 100%;height:48px;background-color:#318cd4;margin-top:0px;" id="topmenu">
  <ul id="topmenuul">
   <a href="#"><li style="background-color: #016ec5">首页</li></a>
    <a href="#"><li>政务信息</li></a>
    <a href="#"><li>办事指南</li></a>
    <a href="#"><li>党建园地</li></a>
    <a href="#"><li>政策法规</li></a>
    <a href="#"><li>政民互动</li></a>
    <li style=" width:250px;"><form>
    <input style="height: 30px;">
    <input type="submit" value="搜索" style="height:30px;width: 50px;">
    </form></li>
  </ul>
</div>
  
  <div id="zhong">
 <div id="lunboleft" style="width:785px;height:250px;border:0px solid #000;margin-left:400px;padding-top:72px;">
  <%
    String ss=new String(request.getParameter("ut").getBytes("ISO-8859-1"),"UTF-8");
  %>
 
  <input type="hidden" value="<%=ss%>" id="login">
      <table border="1" style="margin-top:5px; border-collapse:collapse;">
      <h4 style="margin-top:50px;">本单位住房公积金</h4>
         <tr>
            <td>单位编号</td>
            <td>单位名称</td>
            <td>单位缴存比例:</td>
            <td>单位总人数:</td>
            <td>单位缴存人数:</td>
             <td>单位暂存款余额:</td>
              <td>单位缴存方式:</td>
         </tr>
          <tbody id="myTab"></tbody>
     </table>
    <table>
     <tr><td><button class="but" onclick="querydanwei()" style="width:90px;height:35px;margin-left:685px;margin-top:5px;">员工管理</button></td></tr>
    </table>
     </div>
     <!-- 尾部 -->
<div style="border:0px solid black; width:100%;height:220px;margin-top:20px">

   <div style="border:0px solid black;width:100%;height:220px;background-color:#016EC5;">
    
    
     <div style="border:0px solid black;width:800px;height:200px;margin-left:220px;margin-top:0px;">
       <div style="border:0px solid black;width:800px;height:100px;color:white;font-size:10px;text-align: center;line-height: 100px; ">
       版权所有：**住房公积金管理中心 京公网安备10086 京ICP备1383838号 客服电话：10010
       </div>
       
       <div style="border:0px solid black;width:800px;height:100px;" id="last">
         <ul style="border:0px solid black;width:400px;height:100px;margin-left:200px;">
           <li><a href="#"><img alt="" src="images/blue.png" style="top:10px;left:30px;"></a> </li>
           <li><a href="#"><img alt="" src="images/jiucuo.png-v=-+sitecode+-.png"></a> </li>
           <li><a href="#"><img alt="" src="images/2018042315070456187.png"></a> </li>
         </ul>
       </div>
     </div>
     
   </div>
</div>
</div>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
var uid;
$(function(){
   querylist();
   
})
    function querylist(){
      var zhi=$("#login").val();
          $.ajax({
             url:"query3.action",
             type:"post",
             data:{"utinName":zhi},
             dataType:"json",
             success:function(data){
             //每次记载之前先清空当前页面的数据
                 $("#myTab").html('');
                    var tr="<tr class='trinfo'>";
                   tr+="<td class='uid'>"+data.utinAccountId+"</td>";
                   tr+="<td>"+data.utinName+"</td>";
                   tr+="<td>"+data.utinDepositRatio+"%"+"</td>";
                   tr+="<td>"+data.utinSumPeople+"</td>";
                   tr+="<td>"+data.utinDepositPeople+"</td>";
                   tr+="<td>"+data.utinProvRema+"</td>";
                   tr+="<td>"+data.utinPayinWay+"</td>";
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
        
             }
          })
             }
               function querydanwei(){
     //循环获取数据
    
           $(".trinfo").each(function (){
              
               var uid=$(this).find(".uid").html();
          
            window.location.href="userselect.jsp?uid="+uid;
           });
           
}
</script>