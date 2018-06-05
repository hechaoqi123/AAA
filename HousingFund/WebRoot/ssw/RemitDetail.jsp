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
<link rel="stylesheet" href="<%=basePath %>bootstrap/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="<%=basePath%>JS/jquery-1.10.2.min.js"></script>
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
  border:0px solid black;
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
         <td><input id="utinid" style="width:300px;height:35px;font-size:30px;"onkeyup="idsousuo(1,0)"/></td>
        <td>单位名称</td>
         <td><input id="utinname" style="width:300px;height:35px;font-size:20px;" onkeyup="namesousuo(1,0)"/></td>
         
       </tr>
    </table>

   <div id="add">
   
   </div>
  </body>
</html>
<script>
$(function(){
 
 jiazai(1,0);
 });
 
// 加载页面是执行
function jiazai(dian,what){
 $("#add").html("");
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
   url:"sele_utin.action",
   type:"post",
   dataType:"json",
   data:{"what.currPage":dian},
   success:function(data){
 
  var trs="";
   trs+="<table class='table'>";
   trs+="<tr style='background-color:#BFDCEC'><td>单位账户</td><td>单位名称</td><td>单位地址</td><td>法人代表</td>";
   trs+="<td>经办人姓名</td><td>单位状态</td><td>操作</td></tr>";
   for(var dl=0;dl<data.list.length;dl++){
      trs+="<tr>";
      trs+="<td>"+data.list[dl].utinAccountId+"</td>";
      trs+="<td>"+data.list[dl].utinName+"</td>";
      trs+="<td>"+data.list[dl].utinAddress+"</td>";
      trs+="<td>"+data.list[dl].corpRepr+"</td>";
      trs+="<td>"+data.list[dl].operatorName+"</td>";
      trs+="<td>"+data.list[dl].accountStatus+"</td>";
      trs+="<td><button onclick='ss("+data.list[dl].utinAccountId+",1,0)'>汇缴详情</button></td>";
      trs+="</tr>";
   } 
   //一起显示
   if(data.currPage!=1&&data.currPage+1<=data.allPage){
 
    trs+="<center><tr><td><a onclick='jiazai("+data.currPage+",1)'>上一页</a><td>";
    trs+="<td><a onclick='jiazai("+data.currPage+",2)'>下一页</a></td>";
    trs+="</tr></center>";
   }else{
   //显示上一页
   if(data.currPage==1){
   
   }else{
   trs+="<tr><td><a onclick='jiazai("+data.currPage+",1)'>上一页</a><td></tr>";
   }
   //显示下一页
   if(data.currPage+1>data.allPage){
   
   }else{
   trs+="<tr><td><a onclick='jiazai("+data.currPage+",2)'>下一页</a></td></tr>";
   }
   }
   trs+="</table>";
   $("#add").append(trs);
   }
   
  })
 }
 
 
 //单位id模糊查询
  function idsousuo(dian,what){
   $("#add").html("");
   $("#utinname").val("")
  if($("#utinid").val()==""&&$("#utinname").val()==""){
  jiazai(dian,what);
  }
  if(what==1){ //上一页
  
	if(dian-1==0){
	dian=1;
	}else{
	dian=dian-1;
	}

}else if(what==2){//下一页

dian=dian+1;
}
  $.ajax({
   url:"sele_mohuid.action",
   type:"post",
   dataType:"json",
   data:{"what.currPage":dian,"UtinId":$("#utinid").val()},
   success:function(data){
    var trs="";
    trs+="<table class='table'>";
   trs+="<tr style='background-color:#BFDCEC'><td>单位账户</td><td>单位名称</td><td>单位地址</td><td>法人代表</td>";
   trs+="<td>经办人姓名</td><td>单位状态</td><td>操作</td></tr>";
   for(var dl=0;dl<data.list.length;dl++){
      trs+="<tr>";
      trs+="<td>"+data.list[dl].utinAccountId+"</td>";
      trs+="<td>"+data.list[dl].utinName+"</td>";
      trs+="<td>"+data.list[dl].utinAddress+"</td>";
      trs+="<td>"+data.list[dl].corpRepr+"</td>";
      trs+="<td>"+data.list[dl].operatorName+"</td>";
      trs+="<td>"+data.list[dl].accountStatus+"</td>";
      trs+="<td><button onclick='ss("+data.list[dl].utinAccountId+")'>汇缴详情</button></td>";
      trs+="</tr>";
   } 
   
   if(data.currPage!=1&&data.currPage+1<=data.allPage){
 
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
   }
   trs+="</table>";
   $("#add").append(trs);
   }
  })
  }

 //单位名称模糊查询
  function namesousuo(dian,what){
   $("#add").html("");
  $("#utinid").val("");
  if(what==1){ //上一页
  
	if(dian-1==0){
	dian=1;
	}else{
	dian=dian-1;
	}

}else if(what==2){//下一页

dian=dian+1;
}
  $.ajax({
   url:"sele_mohuname.action",
   type:"post",
   dataType:"json",
   data:{"what.currPage":dian,"utinname":$("#utinname").val()},
   success:function(data){
    var trs="";
    trs+="<table class='table'>";
   trs+="<tr style='background-color:#BFDCEC'><td>单位账户</td><td>单位名称</td><td>单位地址</td><td>法人代表</td>";
   trs+="<td>经办人姓名</td><td>单位状态</td><td>操作</td></tr>";
   for(var dl=0;dl<data.list.length;dl++){
      trs+="<tr>";
      trs+="<td>"+data.list[dl].utinAccountId+"</td>";
      trs+="<td>"+data.list[dl].utinName+"</td>";
      trs+="<td>"+data.list[dl].utinAddress+"</td>";
      trs+="<td>"+data.list[dl].corpRepr+"</td>";
      trs+="<td>"+data.list[dl].operatorName+"</td>";
      trs+="<td>"+data.list[dl].accountStatus+"</td>";
      trs+="<td><button onclick='ss("+data.list[dl].utinAccountId+")'>汇缴详情</button></td>";
      trs+="</tr>";
   } 
   if(data.currPage!=1&&data.currPage+1<=data.allPage){
 
    trs+="<center><tr><td><a onclick='jiazai("+data.currPage+",1)'>上一页</a><td>";
    trs+="<td><a onclick='jiazai("+data.currPage+",2)'>下一页</a></td>";
    trs+="</tr></center>";
   }else{
    if(data.currPage==1){
   
   }else{
   trs+="<tr><td><a onclick='namesousuo("+data.currPage+",1)'>上一页</a></td></tr>";
   }
   if(data.currPage+1>data.allPage){
   
   }else{
   trs+="<tr><td><a onclick='namesousuo("+data.currPage+",2)'>下一页</a></td></tr>";
   }
   }
   trs+="</table>";
   $("#add").append(trs);
   }
  })
  }
  
  //汇缴详情
  function ss(obj,dian,what){
     alert();
   $("#add").html("");
  if(what==1){ //上一页
  
	if(dian-1==0){
	dian=1;
	}else{
	dian=dian-1;
	}

}else if(what==2){//下一页

dian=dian+1;
}
   $.ajax({
     url:"sele_urd.action",
     type:"post",
     data:{"page.currPage":dian,"utlnid":obj},
     dataType:"json",
     success:function(data){
     if(data==false){
     alert("无此账户汇缴纪录信息");
     }else{
      var tab="<table id='what' class='table'>";
         tab+="<tr style='background-color:#BFDCEC'>";
         tab+="<td>单位编号</td><td>单位名称</td><td>汇缴金额</td><td>汇缴人数</td><td>汇缴时间</td>";
         tab+="<td>起始日期</td><td>最终日期</td><td>汇缴月数</td><td>制单人</td>";
          tab+="</tr>";
      for(var i=0;i<data.list.length;i++){
        tab+="<tr>";
        tab+="<td>"+data.list[i].utinAccountId+"</td>";
        tab+="<td>"+data.list[i].utinName+"</td>";
        tab+="<td>"+data.list[i].payinSumMoney+"</td>";
        tab+="<td>"+data.list[i].depositPeople+"</td>";
        tab+="<td>"+data.list[i].depositDate+"</td>";
        tab+="<td>"+data.list[i].oridate+"</td>";
        tab+="<td>"+data.list[i].finaldate+"</td>";
        tab+="<td>"+data.list[i].remonth+"</td>";
        tab+="<td>"+data.list[i].adminname+"</td>";
        tab+="</tr>";
      }
      //上下页判断
      if(data.currPage!=1&&data.currPage+1<=data.allPage){
 
    tab+="<center><tr><td><a onclick='ss("+data.list[0].utinAccountId+","+data.currPage+",1)'>上一页</a><td>";
    tab+="<td><a onclick='ss("+data.list[0].utinAccountId+","+data.currPage+",2)'>下一页</a></td>";
    tab+="</tr></center>";
   }else{
    if(data.currPage==1){
   
   }else{
   tab+="<tr><td><a onclick='ss("+data.list[0].utinAccountId+","+data.currPage+",1)'>上一页</a></td></tr>";
   }
   if(data.currPage+1>data.allPage){
   
   }else{
   tab+="<tr><td><a onclick='ss("+data.list[0].utinAccountId+","+data.currPage+",2)'>下一页</a></td></tr>";
   }
   }
     tab+="</table>";
     $("#add").append(tab);
     }
     }
   })
  }
</script>