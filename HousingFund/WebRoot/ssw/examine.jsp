<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提取审批</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=basePath%>bootstrap/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>bootstrap/bootstrap.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>JS/jquery-1.10.2.min.js"></script>
  <style>
  body{
  font-family:宋体;
  }
  #tab{
   border-collapse:collapse;
  }
   .times{
  width:300px;
  }
  .sp{
  width:100px;
  color:#FF2525;
  }
  .inp{
  width:100px;
  height:30px;
  }
  #tab td{
  width:200px;
  border:1px solid black;
  text-align:center;
  height:30px;
  }
  #what td{
  border:1px solid black;
  width:150px;
  height:30px;
  }
 
  
  </style>
  
  </head>
  
  <body>
  
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
           
         <div class="modal-body"></div>
           
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


   <table id="tab">
   <tr style="background-color:#BFDCEC">
  <td>个人账户</td>
  <td>申请人姓名</td>
  <td class="tiems">申请时间</td>
  <td>开户银行</td>
  <td>银行账户</td>
  <td>账户姓名</td>
  <td>提取金额</td>
  <td>账户状态</td>
  <td style="width:100px">操作</td>
  </tr>
   
   </table>
  </body>
</html>
<script>

$(function(){
alert();
   $.ajax({
   url:"sele_ex.action",
   type:"post",
   dataType:"json",
   success:function(data){
  	
   var tab="";
  
   for(var i=0;i<data.length;i++){
    tab+="<tr>";
    tab+="<td>"+data[i].IndAccountID+"</td>";
    tab+="<td>"+data[i].workersName+"</td>";
    tab+="<td class='tiems'>"+data[i].applicationtime+"</td>";
    tab+="<td>"+data[i].bankOfDeposit+"</td>";
    tab+="<td>"+data[i].collectionAccount+"</td>";
    tab+="<td>"+data[i].payee+"</td>";
    tab+="<td>"+data[i].withdrawalAmount+"</td>";
    tab+="<td>"+data[i].approvalStatus+"</td>";
    
    tab+="<td style='width:100px'><input value='查看信息' type='button'  class='btn btn-primary' data-toggle='modal' data-target='#myModal' onclick='se("+data[i].approvalNumberId+","+data[i].IndAccountID+","+data[i].withdrawalAmount+",\""+data[i].applicationtime+"\")'/></td>";
    //tab+="<button class='btn btn-primary btn-lg" data-toggle="modal" data-target='#myModal'>开始演示模态框</button>";
    tab+="</tr>";
   //onclick='se("+data[i].approvalNumberId+","+data[i].IndAccountID+","+data[i].withdrawalAmount+")'
   }
  
  $("#tab").append(tab);
   }
   })
})
	function se(obj,a,b,c){
	$(".modal-body").html("");
	$.ajax({
	 url:"sele_contract.action",
	 type:"post",
	 data:{"appid":obj},
	 dataType:"json",
	 success:function(data){
	  var tab="<table id='what' class='table'>";
	 if(data[0].piId!=null){//购房
	  tab+="<tr>";
	  tab+="<td>房屋总价</td>";
	  tab+="<td>"+data[0].puType+"</td>";
	  tab+="<td>房屋面积</td>";
	  tab+="<td>"+data[0].puAddress+"</td>";
	  tab+="</tr>";
	  
	  tab+="<tr>";
	  tab+="<td>房屋单价</td>";
	  tab+="<td>"+data[0].pumoney+"</td>";
	  tab+="<td>购房合同</td>";
	  tab+="<td>"+data[0].puText+"</td>";
	  tab+="</tr>";
	  
	  tab+="<tr>";
	  tab+="<td>售房联系电话</td>";
	  tab+="<td>"+data[0].shphone+"</td>";
	  tab+="<td>售房地址</td>";
	  tab+="<td>"+data[0].shaddress+"</td>";
	  tab+="</tr>";
	  
	  tab+="<tr>";
	  tab+="<td>售房单位</td>";
	  tab+="<td>"+data[0].shutin+"</td>";
	  tab+="<td>身份证号</td>";
	  tab+="<td>"+data[0].shidnum+"</td>";
	  tab+="</tr>";
	  //"+data[0].hbname"  "+data[0].houcs"
	  tab+="<tr>";
	  tab+="<td>购房人姓名</td>";
	  tab+="<td>"+data[0].hbname+"</td>";
	  tab+="<td>房屋现状</td>";
	  tab+="<td>"+data[0].houcs+"</td>";
	  tab+="</tr>";
	  
	  
	  tab+="</table>";
	  
	  
	  tab+=" <div class='modal-footer'>";
      tab+="<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>";
      tab+="<button type='button' class='btn btn-primary'  data-dismiss='modal'onclick='subs("+obj+","+a+","+b+",\""+c+"\")'>同意提取</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='notsub("+obj+")'>不同意提取</button>";
       tab+="</div>";
	 }else if(data[0].deathCertificateId!=null){//死亡证明
	  tab+="<tr>";
	  tab+="<td>姓名</td>";
	  tab+="<td>身份证号</td>";
	  tab+="<td>户籍所在地</td>";
	  tab+="<td>死亡原因</td>";
	  tab+="</tr>";
	  tab+="<tr>";
	  tab+="<td>"+data[0].myName+"</td>";
	  tab+="<td>"+data[0].idno+"</td>";
	  tab+="<td>"+data[0].placeOfDomicile+"</td>";
	  tab+="<td>"+data[0].causeOfDeath+"</td>";
	  tab+="</tr>";
	  tab+="</table>";
	   tab+=" <div class='modal-footer'>";
      tab+="<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='subs("+obj+","+a+","+b+",\""+c+"\")'>同意提取</button>";
       tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='notsub("+obj+")'> 不同意提取</button>";
       tab+="</div>";
	 }else if(data[0].retireId!=null){//离职退休
	  tab+="<tr>";
	  tab+="<td>姓名</td>";
	  tab+="<td>单位名称</td>";
	  tab+="<td>离休原因</td>";
	  tab+="</tr>";
	  tab+="<tr>";
	  tab+="<td>"+data[0].myName+"</td>";
	  tab+="<td>"+data[0].utinName+"</td>";
	  tab+="<td>"+data[0].reasForRe+"</td>";
	  tab+="</tr>";
	  tab+="</table>";
	  tab+=" <div class='modal-footer'>";
      tab+="<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='subs("+obj+","+a+","+b+",\""+c+"\")'>同意提取</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='notsub("+obj+")'>不同意提取</button>";
       tab+="</div>";
	 }
	  
	 $(".modal-body").append(tab);
	 
	 }
	})
	}
	function subs(a,b,c,d){
	/* alert(a);
	alert(b);
	alert(c);
	alert(d); */
	$.ajax({
	 url:"yes_con.action",
	 type:"post",
	 data:{"appid":a,"indid":b,"money":c,"apptime":d},
	 dataType:"json",
	 success:function(data){
	 window.href.location="/ssw/examine.jsp";
	 }
	})
	}
	function notsub(a){
	/* alert(a); */
	$.ajax({
	 url:"not_con.action",
	 type:"post",
	 data:{"appid":a},
	 dataType:"json",
	 success:function(data){
	 window.href.location="/ssw/examine.jsp";
	 }
	})
	}


</script>
