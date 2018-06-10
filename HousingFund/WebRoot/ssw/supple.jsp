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
 
 .onettdd td{
 width:0px;
 height:50px;
 border:0px solid black;
 }
 .twotr td{
 width:150px;
 height:50px;
 border-left:0px solid black;
 border-right:0px solid black;
 border-bottom:1px solid black;
 border-top:1px solid black;
 text-align: center;
 }
 .biaoji{
 color:red;
 font-size:20px;
 }
 #twotab input{
 text-align: center;
 }
  .addtr td{
  height:50px;
  }.addtr td input{
  height:45px;
  }
</style>
<link rel="stylesheet" href="<%=basePath%>bootstrap/bootstrap.min.css" type="text/css"></link>
  <%-- <script type="text/javascript" src="<%=basePath%>JS/jquery-1.10.2.min.js"></script>  --%>
  
  <script type="text/javascript" src="<%=basePath%>JS/jquery-3.3.1.min.js"></script>
  
  </head>
  
  
  <body>
  
  <!-- action="add_sup.action" method="post" enctype="multipart/form-data" -->
   <form id="fdata" enctype="multipart/form-data">
	  	<table class="table">
	  		<tr class="form-group">
	  			<td width="140px">
		  			
		  			<!-- <input class="utinid" name="utinaccountinfoID" style="display: none;"> -->
	  			</td>
	  		 	<td width="200px"><input type="file"  name="files" id="fileif" required="required"></td>
	  			<td><input type="button" value="提交" id="filesub"></td>
	  		</tr>
	  	</table>
  	</form>
  
  
  
  
  
   <table id="onetab" class="table">
   
    <tr class="onettd">
      <td colspan="4"><center>住房公积金补缴书</center></td>
     
    </tr>
    <tr class="onetr">
      <td>单位编号<span class="biaoji">*</span></td>
      <td><input  class="utinAccountID" onblur="utinid(this.value)"/><span id="idspan" style="color:red;font-size:10px;"></span></td>
      <td>单位名称<span class="biaoji">*</span></td>
      <td><input class="utinNmae" readonly="readonly"/></td>
    </tr>
    <tr class="onetr">
      <td>补缴金额<span class="biaoji">*</span></td>
      <td><input  class="utinsupmoney" readonly="readonly"/></td>
      <td>补缴人数<span class="biaoji">*</span></td>
      <td><input  class="supSumple" readonly="readonly"/></td>
    </tr>
    <tr class="onetr">
      <td>支票号码<span class="biaoji">*</span></td>
      <td colspan="3" id="teshu"><input class="chequeID"/></td>
    </tr>
    <tr class="onetr">
    <td>补缴原因<span class="biaoji">*</span></td>
      <td colspan="3" id="bjyy" ><input class="supCause"/></td>
    </tr>
   </table>
   
  
   
   
   
   
   
   <table id="twotab" class="table">
         
    
   </table>
   <center style="margin-top: 50px;" >
   <button onclick="add()" id="addba" style="width:100px;height:30px;font-size:15px;margin-left: -200px;background-color: #acd18e;color:black;display:none;">确认信息</button> 
   <button onclick="summoney()" id="tf" style="width:150px;height:30px;font-size:15px;margin-left: 200px;background-color: #438eb9;color:black;display:none;">计算总金额</button>
  </center>
  <center> <button onclick="sub()" id="sub" style="margin-left:-200px;;width:100px;height:30px;font-size:20px;background-color: #929390;color:white;display:none;">提交</button>
   </center>
   <span style="display:none"  id="diaoyong"></span>
 
  </body>
</html>
<script>


		$("#filesub").click(function(){
		
		var fil=$("#fileif").val();
		var utid=$(".utinAccountID").val();
		
		if(fil!=""&&utid!=""){
		
		$("#twotab").html("");
		$("#addba").hide();
		$("#sub").hide();
		var formData=new FormData($("#fdata")[0]);
		
		 $.ajax({
		   url:"add_sup.action",
		   type:"post",
		   dataType:"json",
		   data:formData,
		   contentType: false,
		   processData: false,
		   success:function(data){
		    var tr="";
		    
		  tr+="<tr class='onettdd'>";
        tr+="<td colspan='6'><center>住房公积金补缴清册</center></td>";
        tr+="</tr>";
        tr+="<tr class='twotr'>";
        tr+="<td>身份证号</td>";
        tr+="<td>职工姓名</td>";
        tr+="<td>月补缴基数</td>";
        tr+="<td>缴存比例</td>";
        tr+="<td>补缴月份</td>";
        tr+="<td>应缴总金额</td>";      
        tr+="</tr>";
		  var summon=0;
		   for(var i=0;i<data.length;i++){
		   var yimon=data[i].supRadices*data[i].indDepositRatio*data[i].supMonth;
		     tr+="<tr class='addtr'>";
             tr+="<td><input class='idnumber"+i+"' value='"+data[i].idnum+"' readonly='readonly'/></td>";
		     tr+="<td style='display:none'><input style='display:none' class='indacid"+i+"' readonly='readonly'/></td>";
		     tr+="<td><input class='employeeName"+i+"' value='"+data[i].employeeName+"' readonly='readonly'/></td>";
		     tr+="<td><input class='supRadices"+i+"' value='"+data[i].supRadices+"' readonly='readonly'/></td>";
		     tr+="<td><input class='indDepositRatio"+i+"'  value='"+data[i].indDepositRatio+"' readonly='readonly'/></td>";
		     tr+="<td><input class='supMonth"+i+"' value='"+data[i].supMonth+"' readonly='readonly'/></td>";
		     tr+="<td><input class='supMoney"+i+"' value='"+yimon+"' readonly='readonly'/></td>";
		     tr+="</tr>";
		    summon+=yimon;
		  
		  
		   }
		  
		   //tr+="<center><button type='button'>确认信息</button></center>";
	
		   $("#twotab").append(tr);
		   $("#addba").show();
		   $(".utinsupmoney").val(summon)
		   $(".supSumple").val(data.length);
		   }
		  })
		
		 
		  
		}else{
		alert("单位编号和excel表格不能为空");
		}
		
		
		})
		
		
		
		
		function utinid(obj){
		
		$(".utinNmae").val("");
		if(obj==""){
					$("#twotab").html("");
					 $(".utinsupmoney").val("")
				   $(".supSumple").val("");
				   $("#addba").hide();
					$("#tf").hide();
					 $("#addba").hide();
		     $("#sub").hide();
		
		}else{
		 $(".utinsupmoney").val("")
				   $(".supSumple").val("");
				   $("#addba").hide();
		$("#twotab").html("");
		 $("#addba").hide();
		     $("#sub").hide();
		$.ajax({
		  url:"sele_utinid.action",
		  type:"post",
		  data:{"uuid":obj},
		  dataType:"json",
		  success:function(data){
		  if(data!=""){
		     
		   uRatio=data[0].utinDepositRatio;
		  $("#idspan").html("");
		  $(".utinNmae").val(data[0].utinName);
		  }else{
		  $("#idspan").html("无此单位");
		  }
		  }
		})
		}
		
		
		}

var uRatio;
function idnum(obj){
var utinAccountID=$(".utinAccountID").val();
  var idnumber=$(".idnumber"+obj+"").val();
 
  $.ajax({
    url:"sele_supidnum.action",
    type:"post",
    data:{"indid":utinAccountID,"idnum":idnumber},
    dataType:"json",
    success:function(data){
    
    
    if(data!=""){
 
    $(".indacid"+obj).val(data[0].indAccountId);
    $(".employeeName"+obj).val(data[0].trueName);
    $(".pan"+obj+"").html("");
    }else{
    $(".indacid"+obj).val("");
    $(".pan"+obj+"").html("此单位没有此人");
    }
    }
  })
}
		$(function(){
		
		$("#tf").hide();
		$("#sub").hide();
		})
		
		
		
		
		function add(){
		var json=new Array();
		var u=0;
		 $(".addtr").each(function(){
		  var idnumber= $(this).find(".idnumber"+u).val();
		  var jsonstr={ "idnum":idnumber};
		  json.push(jsonstr);
		  u++;
		  }
		  )
		    $.ajax({
		    url:"sele_supidnum.action",
		    type:"post",
		    data:{"jsons":JSON.stringify(json),"indid":$(".utinAccountID").val()},
		    dataType:"json",
		    success:function(data){
		   alert(data[0].indAccountId);
		    for(var i=0;i<data.length;i++){
		     
		     if(data[i].indAccountId=="null"){
		     $("#sub").hide();
		     $(".idnumber"+i).parent().parent().css("color","red");
		     $(".idnumber"+i).parent().parent().css("background-color","#DBDBDB");
		     $(".idnumber"+i).parent().parent().find("input").css("background-color","#DBDBDB");
		     }else{
		    
		     $(".indacid"+i).val(data[i].indAccountId);
		     
		     $("#addba").hide();
		     $("#sub").show();
		     }
		     
		    }
		    
		    }
		  })
		}
		
		
		
		 /*
		 var s=1;
		 function add(){
		 //var what=$("tr").is(".addtr");
		 
		 if($(".utinAccountID").val()==""){
		 alert("单位账号不允许为空！");
		 }else{
		      $("#tf").show();
		      var tr="<tr class='addtr'>";
tr+="<td><input class='idnumber"+s+"' onblur='idnum("+s+")'/><span class='pan"+s+"' style='font-size:10px;color:red;'></span></td>";
		     tr+="<td style='display:none'><input style='display:none' class='indacid"+s+"' /></td>";
		     tr+="<td><input  class='employeeName"+s+"' readonly='readonly'/></td>";
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
		     tr+="<td><input class='indDepositRatio"+s+"' value='"+uRatio+"' readonly='readonly'/></td>";
		     tr+="<td><select class='supMonth"+s+"' onchange='twoch("+s+")'>";
		      tr+=" <option value='0'>--请选择--</option>";
		       tr+="<option value='1'>1</option>";
		       tr+="<option value='2'>2</option>";
		       tr+="<option value='3'>3</option>";
		     tr+="</select></td>";
		      tr+="<td><input class='supMoney"+s+"' readonly='readonly'/></td>";
		      //tr+="<td><input type='button'value='计算' onclick='jisu("+s+")'/></td>";
		    tr+="</tr>";
		    s++;
		    $("#twotab").append(tr);
		 }
		 }*/
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
		
		var idnumber=$(".idnumber"+a).val();
		var employeeName=$(".employeeName"+a).val();
		var supRadices=$(".supRadices"+a).val();
		var indDepositRatio=$(".indDepositRatio"+a).val();
		var supMonth=$(".supMonth"+a).val();
		
		if(idnumber!=""&&employeeName!=""&&supRadices!=""&&indDepositRatio!=0&&supMonth!=0){
		var supRadices=parseFloat($(".supRadices"+a).val()).toFixed(2);//基数
		
		var indDepositRatio=parseFloat($(".indDepositRatio"+a).val()).toFixed(2);
		var s=parseFloat(supRadices*indDepositRatio*supMonth)*2;
		$(".supMoney"+a).val(s.toFixed(2));
		}else{
		
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
		 $(".supSumple").val(s-1);
		 $("#tf").hide();
		 $("#sub").show();
		}
		
		}
		
		function sub(){
		//alert((".pla").text());
		//$("#diaoyong").html("");
		/* for(var a=1;a<s;a++){
		
		var pan=$(".pan"+a).html();
		$("#diaoyong").append(pan);
		} */
		
		
		
		/* if($("#diaoyong").html()==""){
		}else{
		alert("信息错误不能提交");
		} */
		
		 var utinAccountID=$(".utinAccountID").val();//单位编号
		 var utinNmae=$(".utinNmae").val();//单位名称
		 var utinsupmoney=$(".utinsupmoney").val();//补缴金额
		 var supSumple=$(".supSumple").val();//补缴人数
		 var chequeID=$(".chequeID").val();//支票号码
		 var supCause=$(".supCause").val();//补缴原因
		 var zongmoney=$(".zongmoney").val();//缴存总金额
		 if(utinAccountID!=""&&utinNmae!=""&&utinsupmoney!=""&&supSumple!=""&&chequeID!=""&&
		 supCause!=""&&zongmoney!=""&&zongmoney!=""){
		
		 var one=parseFloat($(".utinsupmoney").val()).toFixed(2);
		var two=parseFloat($("#zongmoney").val()).toFixed(2);
		
		if(one==""||eval(one)<eval(two)){
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
		 var u=0;
		  $(".addtr").each(function(){
		  
		  var indacid= $(this).find(".indacid"+u).val();
		  
		  var employeeName= $(this).find(".employeeName"+u).val();
		  var supRadices= $(this).find(".supRadices"+u).val();
		  var indDepositRatio= $(this).find(".indDepositRatio"+u).val();
		  var supMonth= $(this).find(".supMonth"+u).val();
		  var supMoney= $(this).find(".supMoney"+u).val();
		  var jsonstr={
		  "indAccountID":indacid,"employeeName":employeeName,
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
		    data:{"jsons":JSON.stringify(json),"utinAccountID":utinAccountID,//单位id
		   "u.utinNmae":utinNmae,"u.utinsupmoney":utinsupmoney,"u.supSumple":supSumple,
		   "u.chequeId":chequeID,"u.supCause":supCause
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