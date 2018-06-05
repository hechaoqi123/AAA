<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提取纪录与进展</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" href="<%=basePath%>bootstrap/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="<%=basePath%>JS/jquery-1.10.2.min.js"></script>
  </head>
  
  <body>
     <table style="border:0px solid red;height:50px;font-size: 20px;" class="">
       <tr>
        <td>身份证号:</td>
         <td><input id="utinid" style="width:300px;height:35px;font-size:30px;"onkeyup="idsousuo(1,0)"/></td>
         
       </tr>
    </table>
    <div id="tab"></div>
  </body>
</html>
<script>


 
$(function(){
 
 jiazai(1,0);
 });
    


// 加载页面是执行
function jiazai(dian,what){
 $("#tab").html("");
if(what==1){
	if(dian-1==0){
	dian=1;
	}else{
	dian=dian-1;
	}

}else if(what==2){

dian=dian+1;
}


 
  $.ajax({
   url:"sele_allex.action",
   type:"post",
   dataType:"json",
   data:{"page.currPage":dian},
   success:function(data){
 
  var trs="";
   trs+="<table class='table'>";
   trs+="<tr style='background-color:#BFDCEC'><td>身份证号</td><td>姓名</td><td>性别</td><td>个人账户</td><td>单位名称</td>";
   trs+="<td>提取金额</td><td>手机号</td><td>账户状态</td><td>申请时间</td><td>审批状态</td></tr>";
   for(var dl=0;dl<data.list.length;dl++){
      trs+="<tr>";
      trs+="<td>"+data.list[dl].exidnum+"</td>";
      trs+="<td>"+data.list[dl].workersName+"</td>";
      trs+="<td>"+data.list[dl].exsex+"</td>";
      trs+="<td>"+data.list[dl].indAccountId+"</td>";
      trs+="<td>"+data.list[dl].exunitname+"</td>";
      trs+="<td>"+data.list[dl].withdrawalAmount+"</td>";
      trs+="<td>"+data.list[dl].exphone+"</td>";
      trs+="<td>"+data.list[dl].indaccstatus+"</td>";
      trs+="<td>"+data.list[dl].applicationtime+"</td>";
      trs+="<td>"+data.list[dl].approvalStatus+"</td>";
      //trs+="<td><button onclick='ss("+data.list[dl].utinAccountId+")'>汇缴详情</button></td>";
      trs+="</tr>";
   } 
   
   if(data.currPage!=1&&data.currPage+1<=data.allPage){
 
    trs+="<center><tr><td><a onclick='jiazai("+data.currPage+",1)'>上一页</a><td>";
    trs+="<td><a onclick='jiazai("+data.currPage+",2)'>下一页</a></td>";
    trs+="</tr></center>";
   }else{
   if(data.currPage==1){
   
   }else{
   trs+="<tr><td><a onclick='jiazai("+data.currPage+",1)'>上一页</a><td></tr>";
   }
   
   if(data.currPage+1>data.allPage){
   
   }else{
   trs+="<tr><td><a onclick='jiazai("+data.currPage+",2)'>下一页</a></td></tr>";
   }
   }
   trs+="</table>";
   $("#tab").append(trs);
   }
   
  })
 }
 //身份证号查询
function idsousuo(dian,what){
   $("#tab").html("");
  
  if($("#utinid").val()==""){
  jiazai(dian,what);
}else{
  $.ajax({
   url:"idsele_allex.action",
   type:"post",
   dataType:"json",
   data:{"idnum":$("#utinid").val()},
   success:function(data){
   
   if(data=="false"){
   
   }
    var trs="";
   trs+="<table class='table'>";
   trs+="<tr style='background-color:#BFDCEC'><td>身份证号</td><td>姓名</td><td>性别</td><td>个人账户</td><td>单位名称</td>";
   trs+="<td>提取金额</td><td>手机号</td><td>账户状态</td><td>申请时间</td><td>审批状态</td></tr>";
   for(var dl=0;dl<data.length;dl++){
      trs+="<tr>";
      trs+="<td>"+data[dl].exidnum+"</td>";
      trs+="<td>"+data[dl].workersName+"</td>";
      trs+="<td>"+data[dl].exsex+"</td>";
      trs+="<td>"+data[dl].indAccountId+"</td>";
      trs+="<td>"+data[dl].exunitname+"</td>";
      trs+="<td>"+data[dl].withdrawalAmount+"</td>";
      trs+="<td>"+data[dl].exphone+"</td>";
      trs+="<td>"+data[dl].indaccstatus+"</td>";
      trs+="<td>"+data[dl].applicationtime+"</td>";
      trs+="<td>"+data[dl].approvalStatus+"</td>";
      //trs+="<td><button onclick='ss("+data.list[dl].utinAccountId+")'>汇缴详情</button></td>";
      trs+="</tr>";
   } 
   /* if(data.currPage!=1&&data.currPage+1<=data.allPage){
 
    trs+="<center><tr><td><a onclick='jiazai("+data.currPage+",1)'>上一页</a><td>";
    trs+="<td><a onclick='jiazai("+data.currPage+",2)'>下一页</a></td>";
    trs+="</tr></center>";
   }else{
    if(data.currPage==1){
   
   }else{
   trs+="<tr><td><a onclick='idsousuo("+data.currPage+",1)'>上一页</a><td></tr>";
   }
   if(data.currPage+1>data.allPage){
   
   }else{
   trs+="<tr><td><a onclick='idsousuo("+data.currPage+",2)'>下一页</a></td></tr>";
   }
   } */
   trs+="</table>";
   $("#tab").append(trs);
   }
  })
  }
  }
</script>