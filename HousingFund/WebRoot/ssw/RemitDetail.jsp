<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>汇缴办理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="JS/jquery-1.10.2.min.js"></script>
  <style>
  
  body{
background-color:#FAFAFA;
font-family:宋体;
}
  #add table{
  border-collapse:collapse;
  }
  #add td{
  width:200px;
  height:30px;
  border:1px solid black;
  }
 /*  #onetab{
   border-collapse:collapse;
  }
   #onetab td{
  width:80px;
  height:20px;
  border:0px solid black;
  } */
  </style>
  </head>
  
  <body>
  <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css"></link>
    <table style="border:0px solid red;height:50px;font-size: 20px;" class="">
       <tr>
        <td>单位编号:</td>
         <td><input id="utinid" style="width:300px;height:35px;font-size:30px;"/></td>
         <td><input type="button" value="搜索" style="height:35px;width:100px;" onclick="ss()"/></td>
         
       </tr>
    </table>

   <div id="add">
   
   </div>
  </body>
</html>
<script>
 
  function ss(){
   var s=$("#utinid").val();
   $("#add").html("");
   if(s==""){
   alert("不能为空");
   }else{
   $.ajax({
     url:"sele_urd.action",
     type:"post",
     data:{"utlnid":s},
     dataType:"json",
     success:function(data){
     if(data==false){
     alert("无此账户汇缴纪录信息");
     }else{
      var tab="<table id='what' class='table'>";
         tab+="<tr>";
         tab+="<td>单位名称</td><td>汇缴金额</td><td>汇缴人数</td><td>汇缴时间</td>";
         tab+="<td>起始日期</td><td>最终日期</td><td>汇缴月数</td><td>制单人</td>";
          tab+="</tr>";
      for(var i=0;i<data.length;i++){
        tab+="<tr>";
        tab+="<td>"+data[i].utinName+"</td>";
        tab+="<td>"+data[i].payinSumMoney+"</td>";
        tab+="<td>"+data[i].depositPeople+"</td>";
        tab+="<td>"+data[i].depositDate+"</td>";
        tab+="<td>"+data[i].oridate+"</td>";
        tab+="<td>"+data[i].finaldate+"</td>";
        tab+="<td>"+data[i].remonth+"</td>";
        tab+="<td>"+data[i].adminname+"</td>";
        tab+="</tr>";
      }
     tab+="</table>";
     $("#add").append(tab);
     }
     }
   })
  }}
</script>