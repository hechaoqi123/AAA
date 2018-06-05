<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'supple.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
/*  #onetab{
 width:800px;
 height:400px;
 border:1px solid black;
 border-collapse: collapse;
 }
 .onetr td{
 width:190px;
 height:50px;
 border:1px solid black;
 }
  .onetr td input{
 width:190px;
 height:50px;
 border:0px solid black;
 }
 .onettd td{
 width:0px;
 height:50px;
 border:1px solid black;
 }
 #teshu input{
 width:500px;
 }
 #bjyy input{
 width:500px;
 }
  #twotab{
 width:950px;
  /*height:300px;
 border:1px solid black;
 border-collapse: collapse;
 } 
 .twotr td{
 width:150px;
 height:30px;
 border:0px solid black;
 }
 .addtr input{
 width:165px;
 height:30px;
 }
 .addtr select{
 width:165px;
 height:30px;
 }
 .addtr option{
 width:165px;
 height:30px;
 } */
 .biaoji{
 color:red;
 font-size:20px;
 }
</style>
<link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="JS/jquery-1.10.2.min.js"></script></head>
  
  <body>
   <table id="onetab" class="table">
   
    <tr class="onettd">
      <td colspan="4"><center>住房公积金补缴书</center></td>
     
    </tr>
    <tr class="onetr">
      <td>单位编号<span class="biaoji">*</span></td>
      <td><input  class="utinAccountID"/></td>
      <td>单位名称<span class="biaoji">*</span></td>
      <td><input class="utinNmae"/></td>
    </tr>
    <tr class="onetr">
      <td>补缴金额<span class="biaoji">*</span></td>
      <td><input  class="utinsupmoney" /></td>
      <td>补缴人数<span class="biaoji">*</span></td>
      <td><input  class="supSumple"/></td>
    </tr>
    <tr class="onetr">
      <td>支票号码<span class="biaoji">*</span></td>
      <td colspan="3" id="teshu"><input class="chequeID"/></td>
    </tr>
    <tr class="onetr">
    <td>补缴原因<span class="biaoji">*</span></td>
      <td colspan="3" id="bjyy"><input class="supCause"/></td>
    </tr>
   </table>
   
   <table id="twotab" class="table">
         <tr class="onettd">
      <td colspan="6"><center>住房公积金补缴清册</center></td>
       </tr>
    <tr class="twotr">
      <td>职工编号</td>
      <td>职工姓名</td>
      <td>月补缴基数</td>
      <td>缴存比例</td>
      <td>补缴月份</td>
      <td>应缴总金额</td>
      <td>操作</td>
    </tr>
   </table>
   <button onclick="add()" id="addba">添加</button><button onclick="summoney()" id="tf">计算总金额</button>
   <button onclick="sub()" id="sub">提交</button>
  </body>
</html>
<script>
		$(function(){
		
		$("#tf").hide();
		$("#sub").hide();
		})
		var s=1;
		 function add(){
		 //var what=$("tr").is(".addtr");
		   $("#tf").show();
		      var tr="<tr class='addtr'>";
		      tr+="<td><input class='indAccountID"+s+"'/></td>";
		     tr+="<td><input  class='employeeName"+s+"'/></td>";
		     tr+="<td><input class='supRadices"+s+"' onblur='supblur("+s+")'/></td>";
		     tr+="<td><select class='indDepositRatio"+s+"' onchange='onech("+s+")'>";
		     tr+="<option value='0'>--请选择--</option>";
		     tr+="<option value='0.05'>0.05</option>";
		     tr+="<option value='0.06'>0.06</option>";
		     tr+="<option value='0.07'>0.07</option>";
		     tr+="<option value='0.08'>0.08</option>";
		     tr+="<option value='0.09'>0.09</option>";
		     tr+="<option value='0.10'>0.10</option>";
		     tr+="<option value='0.11'>0.11</option>";
		     tr+="<option value='0.12'>0.12</option>";
		     tr+="</select></td>";
		     tr+="<td><select class='supMonth"+s+"' onchange='twoch("+s+")'>";
		      tr+=" <option value='0'>--请选择--</option>";
		       tr+="<option value='1'>1</option>";
		       tr+="<option value='2'>2</option>";
		       tr+="<option value='3'>3</option>";
		     tr+="</select></td>";
		      tr+="<td><input class='supMoney"+s+"' readonly='readonly'/></td>";
		      tr+="<td><input type='button'value='计算' onclick='jisu("+s+")'/></td>";
		    tr+="</tr>";
		    s++;
		    $("#twotab").append(tr);
		 
		 }
		 function supblur(obj){
		 var s1=$(".supRadices"+obj).val();
		 var s2=$(".indDepositRatio"+obj).val();
		 if(s1!=0&&s2!=0){
		 jisu(obj);
		 }
		 }
		function onech(obj){
		
		var ss=$(".supRadices"+obj).val();
		if(ss!=0){
		jisu(obj);
		}
		}
		function twoch(obj){
		
		var ss=$(".indDepositRatio"+obj).val();
		if(ss!=0){
		jisu(obj);
		}
		}
		function jisu(a){
		
		var indAccountID=$(".indAccountID"+a).val();
		var employeeName=$(".employeeName"+a).val();
		var supRadices=$(".supRadices"+a).val();
		var indDepositRatio=$(".indDepositRatio"+a).val();
		var supMonth=$(".supMonth"+a).val();
		
		if(indAccountID!=""&&employeeName!=""&&supRadices!=""&&indDepositRatio!=0&&supMonth!=0){
		var supRadices=parseFloat($(".supRadices"+a).val()).toFixed(2);//基数
		
		var indDepositRatio=parseFloat($(".indDepositRatio"+a).val()).toFixed(2);
		var s=parseFloat(supRadices*indDepositRatio*supMonth)*2;
		$(".supMoney"+a).val(s.toFixed(2));
		}else{
		alert("不能为空");
		}
		
		
		
		}
		
		function summoney(){
		var zhi=0;
		var list=new Array();
		
		for(var a=1;a<s;a++){
		  var why=$(".supMoney"+a).val();
		  if(why!=""){
		  list[list.length]=why;
		  }
		}
		if(list.length+1<s){
		 alert("信息不正确");
		}else{
		
		for(var a=1;a<s;a++){
		  var why=$(".supMoney"+a).val();
		  zhi=parseFloat(why)+parseFloat(zhi);
		}
		$("#kubi").html("");
		$("#addba").hide();
		 var tr="<tr id='kubi'>";
		 tr+="<td>总金额</td>";
		 tr+="<td><input value='"+zhi.toFixed(2)+"'  readonly='readonly' id='zongmoney'/></td>";
		 tr+="</tr>";
		 $("#twotab").append(tr);
		 $("#sub").show();
		}
		
		}
		
		function sub(){
		 var utinAccountID=$(".utinAccountID").val();//单位编号
		 var utinNmae=$(".utinNmae").val();//单位名称
		 var utinsupmoney=$(".utinsupmoney").val();//补缴金额
		 var supSumple=$(".supSumple").val();//补缴人数
		 var chequeID=$(".chequeID").val();//支票号码
		 var supCause=$(".supCause").val();//补缴原因
		 var zongmoney=$(".zongmoney").val();//缴存总金额
		 if(utinAccountID!=""&&utinNmae!=""&&utinsupmoney!=""&&supSumple!=""&&chequeID!=""&&
		 supCause!=""&&zongmoney!=""&&zongmoney!=""){
		
		 var one=$(".utinsupmoney").val();
		var two=$("#zongmoney").val();
		if(one==""||one<two){
		 alert("缴存金额不足");
		}else{
		 
		 var json=new Array();
		 
		 var utinAccountID=$(".utinAccountID").val();//单位编号
		 var utinNmae=$(".utinNmae").val();//单位名称
		 var utinsupmoney=$(".utinsupmoney").val();//补缴金额
		 var supSumple=$(".supSumple").val();//补缴人数
		 var chequeID=$(".chequeID").val();//支票号码
		 var supCause=$(".supCause").val();//补缴原因
		 var zongmoney=$(".zongmoney").val();//缴存总金额
		 var u=1;
		  $(".addtr").each(function(){
		  
		  var indAccountID= $(this).find(".indAccountID"+u).val();
		  var employeeName= $(this).find(".employeeName"+u).val();
		  var supRadices= $(this).find(".supRadices"+u).val();
		  var indDepositRatio= $(this).find(".indDepositRatio"+u).val();
		  var supMonth= $(this).find(".supMonth"+u).val();
		  var supMoney= $(this).find(".supMoney"+u).val();
		  var jsonstr={
		  "indAccountID":indAccountID,"employeeName":employeeName,
		  "supRadices":supRadices,"indDepositRatio":indDepositRatio,
		  "supMonth":supMonth,"supMoney":supMoney
		  };
		   
		  json.push(jsonstr);
		  u++;
		  });
		 $.ajax({
		     url:"inse_sup.action",
			 type:"post",
			 dataType:"html",
		    data:{"jsons":JSON.stringify(json),"utinAccountID":utinAccountID,
		   "u.utinNmae":utinNmae,"u.utinsupmoney":utinsupmoney,"u.supSumple":supSumple,
		   "u.chequeID":chequeID,"u.supCause":supCause,"u.zongmoney":zongmoney
		   },
		   success:function(data){
		   if(data=="www"){
		   alert("单位账号错误,请重新填写");
		   $(".utinAccountID").val("");
		   }else if(data=="error"){
		    alert("员工编号错误,请仔细确认");
		   }else{
		   alert("补缴成功");
		   window.location.href="<%=basePath%>ssw/supple.jsp";
		   }
		   }
		 })
		} 
		 }else{
		
		alert("信息不完整");
		
		 }
		
		}
</script>
<!--  -->