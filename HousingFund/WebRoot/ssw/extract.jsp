<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提取申请</title>
    
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
 /*  #forms td{
  border:0px solid black;
  width:150px;
  height:45px;
  text-align: center;
  }
   #forms input{
  
  width:200px;
  height:35px;
  } */
  
  input{
  text-align: center;
  }
  select{
  text-align: center;
  }
 option{
  text-align: center;
  }
  #tab{
  margin-top:100px;
  border-collapse:collapse;
  }
    #tab td{
    border:1px solid black;
    height:50px;
    border-collapse:collapse;
    }
    /* .tabtd{
    width:150px;
    }
    
    .tabid{
    width:250px;
    }
    .tabid input{
    width:250px;
    } */
    .sp{
    color:red;
    }
   /*  }
    #reasonNo{
    width:200px;
    height:40px;
    boder:0px;
    }
	  .tabop{
	  width:250px;
	  }
	  
	  #subs{  
	  width:100px;
	  height:50px;
	  }
	   #subs input{
	  width:90px;
	  height:30px;
	  }
	   #subss{  
	  width:100px;
	  height:50px;
	  }
	   #subss input{
	  width:90px;
	  height:30px;
	  }
	   #subsss{  
	  width:100px;
	  height:50px;
	  }
	   #subsss input{
	  width:90px;
	  height:30px;
	  }
	  #zhu{
	  color:#95999d;
	  font-size:12px;
	  }
	  #mxseid{
	  width:150px;
	  height:30px;
	  }
	  #mx{
	  height:30px;
	  } */
	  /* #mx:HOVER {
	 background-color: #cbe1ee;
      } */
     /*  #mxtab td{
      width:150px;
      height:20px;
      } */
      
   #tabtwotwo{
   width:700px;
   border:1px solid #DDDDDD;
   border-collapse: collapse;
   margin-left:200px;
   } 
    #tabtwotwo td{
    width:150px;
    height:50px;
    border:1px solid #DDDDDD;
    text-align: center;
    } 
      .tto{
    width:200px;
    height:50px;
    border-top:0px;
    border-left:0px;
    border-right:0px;
    border-bottom:0px solid #DDDDDD;
    text-align: center;
    } 
    #shaddress,#puText{
    border-top:0px;
    border-left:0px;
    border-right:0px;
    border-bottom:0px solid black;
    width:600px;
    height:50px;
    }
    
    #pumoney, #puAddress{
    
    width:180px;
    height:50px;
    }
    #recnum{
    width:350px;height:50px;
    }
    #ffgg{
    border-bottom: 1px solid black;
    border-left: 0px;
    border-top: 0px;
    border-right: 0px;
    }
    
    
  </style>

</head>
  
  <body>
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
           
         <div class="modal-body"></div>
           
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div id="zhu"><span style="color:red;">注:公积金余额必须大于100才能够提取，需缴纳满3个月才能提取，否则无法提取。<br/>
  1、购买、建造、翻建、大修自住住房的:累计提取总额不应超过实际发生的住房支出;<br/>
  2、离休、退休的：提取全部本息余额<br/>
  3、完全丧失劳动能力，并与单位终止劳动关系的：提取全部本息余额<br/>
  </span></div>

<center>
 <p style="font-size:30px;color:#ADD1E9"id="sqone">申请人基本情况</p>
 <p style="font-size:30px;display:none;color:#ADD1E9" id="sqtwo">提取原因</p>
</center>
  <!-- <input type="radio" value="1" checked="checked" name="tq"/>部分提取
  <input type="radio" value="2" name="tq"/>销户提取 -->
  </br>
  <!-- 账户编号:<input id="mxseid"/><input type="button" value="查询缴纳明细"   id="mx" data-toggle="modal" data-target="#myModal"onclick="mxse()"/>
   账户编号:<input id="jl"/><input type="button" value="查询提取纪录"   id="mx" data-toggle="modal" data-target="#myModal"onclick="jlse()"/>
   账户编号:<input id="bj"/><input type="button" value="查询补缴纪录"   id="mx" data-toggle="modal" data-target="#myModal"onclick="bjse()"/> -->
  <form id="forms" action="save_exapp.action" method="post" >
   
  
  <table id="addse"  class="table">
   <tr>
    <td>姓名<span class="sp">*</span></td> <td><input name="m.extractdetails.extractionandapproval.workersName" id="workersName" readonly="readonly" /></td>  
     <td>证件号码<span class="sp">*</span></td> <td><input name="m.extractdetails.extractionandapproval.exidnum" id="idcard" onblur="money()"/></td>  
     <td>证件类型<span class="sp">*</span></td><td><input  value="身份证" readonly="readonly" name="m.extractdetails.extractionandapproval.exdoctype" id="exdoctype"/></td>
  </tr>
  <tr>
    <td>单位账户<span class="sp">*</span></td><td><input  name="m.extractdetails.extractionandapproval.exunitnum" id="exunitnum" readonly="readonly"/></td> 
    <td>单位名称<span class="sp">*</span></td><td><input  name="m.extractdetails.extractionandapproval.exunitname" id="exunitname" readonly="readonly"/></td>
    <td>个人账户<span class="sp">*</span></td> 
     <td><input  id="MyAccount" name="m.extractdetails.extractionandapproval.indaccountinfo.indAccountId" readonly="readonly"/></td>
  </tr>
  
 
  <tr>
     <td>个人账户状态<span class="sp">*</span></td><td>
     <input  name="m.extractdetails.extractionandapproval.indaccstatus" id="indaccstatus" readonly="readonly"/>
    </td>
     <td>性别<span class="sp">*</span></td><td><input  name="m.extractdetails.extractionandapproval.exsex" id="exsex" readonly="readonly"/>
    </td>
     <td>年龄<span class="sp">*</span></td><td><input   name="m.extractdetails.extractionandapproval.exage" id="exage"/></td>
  </tr>
 
  <tr>
  <td>手机号码<span class="sp">*</span></td><td><input name="m.extractdetails.extractionandapproval.exphone" id="exphone"/></td>
  <td class="tabtd">收款人<span class="sp">*</span></td>
       <td class="tabid"><input name="m.extractdetails.extractionandapproval.payee" id="payee"/></td>
  <td>个人账户余额<span class="sp">*</span></td><td><input id="Mymoney" readonly="readonly"/></td>
  </tr>
  
  <tr>
  <td>提取方式<span class="sp">*</span></td><td><input value="转账提取" readonly="readonly" name="m.extractdetails.extractionandapproval.exmodel"/></td>
      <td>开户银行<span class="sp">*</span></td>
       <td><input name="m.extractdetails.extractionandapproval.bankOfDeposit" id="bankOfDeposit"/></td>
       <td>收款账户<span class="sp">*</span></td>
       <td><input name="m.extractdetails.extractionandapproval.collectionAccount" id="collectionAccount"/></td>
     </tr>
     <tr>
     <td>提取金额<span class="sp">*</span> </td><td><input name="m.extractdetails.extractionandapproval.withdrawalAmount" id="withdrawalAmount"/></td>
     </tr>
  </table>
 
   <table id="testone" style="display:none; margin-left:200px;" class="table"></table>
   
     <div id="tabtwotwo" style="display:none;">

  </div>
  
  </form>
<center><div style="margin-top:50px;margin-left:-250px;"><a id='shangyiye' style="display:none;font-size:20px;">上一步</a></div> 
</center> 
   <center><a  style="font-size:20px;" id="xiayibu">下一步</a></center>

 


   
  </body>
</html>
<script>
$("#xiayibu").click(function(){
$("#addse tr").hide();
$(this).hide();
$("#sqone").hide();
$("#sqtwo").show();
$("#tabtwotwo").show();
$("#testone").show();
$("#shangyiye").show();
})

$("#shangyiye").click(function(){
$("#addse tr").show();
$(this).hide();
$("#sqone").show();
$("#sqtwo").hide();
$("#testone").hide();
$("#tabtwotwo").hide();
$("#xiayibu").show();
})
 $(function(){

  $.ajax({
    url:"cause_Sele.action",
    type:"post",
    dataType:"json",
    success:function(data){
   
     var tab="<tr>";
   tab+="<td>提取原因<span class='sp'>*</span></td>";
   tab+="<td>";
   tab+="<select id='reasonNo'name='reasonNo' onchange='opt(this)'>";
   tab+="<option value='0'>----请选择-----</option>";
   for(var i=0;i<data.length;i++){

   tab+="<option value='"+data[i].reasonNo+"' class='tabop' >"+data[i].causeDescription+"</option>";
   }
    tab+="</select>"; 
    
    tab+="</td>";
    tab+="</tr>";
    
   
  
    $("#testone").append(tab);
  
  
    }
  })
 })

	function opt(value){
	
	var optionvalue=value.options[value.selectedIndex];  
	$(".addtr").html("");
	$("#tabtwotwo").html("");
	$(".addtr").hide();
	
	if(optionvalue.value>0&&optionvalue.value<5){
	var tp="<table>";
	tp+="<tr><td colspan='4'>购房合同信息</td></tr>";
	 tp+="<tr>";
	 tp+="<td>购房人姓名<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.hbname' id='hbname' class='tto'/></td>";
	 tp+="<td>身份证号<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.shidnum' id='shidnum' class='tto'/></td>";
	 tp+="</tr>";
	 tp+="<tr>";
	 tp+="<td>售房单位<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.shutin' id='shunit' class='tto'/></td>";
	 tp+="<td>售房联系电话<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.shphone' id='shphone' class='tto'/></td>";
	 tp+="</tr>";
	 tp+="<tr>";
	 tp+="<td>售房地址<span class='sp'>*</span></td><td colspan='3'><input name='m.materialtype.purinfo.shaddress' id='shaddress'/></td>";
	 tp+="</tr>";
	 tp+="<tr>";
	 tp+="<td>房屋每平价<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.pumoney' id='pumoney'/><span style='font-size:15px;'>㎡</span></td>";
	 tp+="<td>房屋面积<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.puAddress' id='puAddress'/><span style='font-size:20px;'>㎡</span></td>";
	 tp+="</tr>";
	 tp+="<tr>";
	 //tp+="<td>房屋现状<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.houcs' id='houcs' class='tto'/></td>";
 tp+="<td>房屋现状<span class='sp'>*</span></td><td><select name='m.materialtype.purinfo.houcs' id='houcs' class='tto'>";
      tp+="<option value='已住' checked='checked'>已住</option><option  value='未住'>未住</option>";
      tp+="</select></td>";
	 tp+="<td>房屋总价<span class='sp'>*</span></td><td><input name='m.materialtype.purinfo.puType' id='puType'  class='tto'/></td>";
	 tp+="</tr>";
	 tp+="<tr>";
	 tp+="<td>购房合同编号<span class='sp'>*</span></td><td colspan='3'><input name='m.materialtype.purinfo.puText' id='puText'/></td>";
	 tp+="</tr>";
	 tp+="<tr>";
	 tp+="<td>所购住房坐落<span class='sp'>*</span></td><td colspan='3'><span style='font-size:10px;'>请按购房合同或房屋所有权证或不动产权证上的地址填写</span><input name='m.materialtype.purinfo.recnum' id='recnum'/></td>";
	 tp+="</tr>";
	 tp+="<tr>";
	 tp+="<td colspan='4'><span style='color:black;'>个人住房信息核查授权、承诺书</span></td>";
	 tp+="</tr>";
	 tp+="</table>";
	 tp+="<div style='width:700px;height:350px;border:0px solid black;'>";
	 tp+=" <p><br/><br/>&nbsp;&nbsp;本人因申请提取住房公积金，现授权北京住房公积金管理中心（以下简称管理中心）通";
	 tp+="过北京市住房<br/>&nbsp;&nbsp;和城乡建设委员会、北京市规划和国土资源管理委员会、北京市经济和信息化委员会等部门核查本人<br/>&nbsp;&nbsp;提交的提取材料及相关信息；授权管理中心通过中国人民银行金融信用信息基础数据库查询本人<br/>&nbsp;&nbsp;的个人信用信息，同意管理中心对此次提交的提取材料及相关信息进行现场核实。<br/></p>";
	 tp+="<p>&nbsp;&nbsp;本人郑重承诺：本人如实填写的上述各项信息及提交材料真实有效。若承诺失实，本人愿意承担以下后果：<br/>";
	 tp+="&nbsp;&nbsp;1.终止提取行为，并在规定期限内退还所提取金额；<br/>";
	 tp+="&nbsp;&nbsp;2.将违规行为通报所在单位并对外公布；<br/>";
	 tp+="&nbsp;&nbsp;3.将违规信息计入住房公积金个人不良信息库和国家有关征信系统；<br/>";
	 tp+="&nbsp;&nbsp;4.自违规发现之日起三年内不予办理住房公积金提取、不予受理住房公积金贷款申请；<br/>";
	 tp+="&nbsp;&nbsp;5.涉嫌构成犯罪的，移送司法机关处理。<br/>";
	 tp+="&nbsp;&nbsp;我已认真阅读上述内容，同意授权并遵守上述承诺。<br/>";
	 tp+="<div style='margin-left:400px;margin-top:40px;'>申请人签字<input id='ffgg'/></span></div>";
	 tp+="</div>";
	 tp+="<button type='button' style='margin-left:300px;'onclick='submits()'>提交</button>";
	
	
	}else if(optionvalue.value==5){
	var tab="<table><tr class='addtr'>";
	 tab+="<td class='tabtd'>姓名<span class='sp'>*</span></td><td class='tabid'><input name='m.materialtype.retireti.myName' id='myName'/></td>";
	 tab+="<td class='tabtd'>单位名称<span class='sp'>*</span></td><td class='tabid'><input name='m.materialtype.retireti.utinName' id='utinName'/></td>";
	 tab+="</tr>";
	 tab+="<tr class='addtr'>";
	 tab+="<td class='tabtd'>离休证明<span class='sp'>*</span></td><td class='tabid'><input name='m.materialtype.retireti.reasForRe' id='reasForRe'/></td>";
	 tab+="</tr>";
	 tab+="<tr class='addtr'>";
	 tab+="<td id='subss'><input type='button' value='申请提交' onclick='submits()'/></td>";
	 tab+="</tr></table>";
	 

	}else if(optionvalue.value==6){
	var tab="<table><tr class='addtr'>";
	 tab+="<td class='tabtd'>姓名<span class='sp'>*</span></td><td class='tabid'><input name='m.materialtype.proofofdeath.myName' id='proname'/></td>";
	 tab+="<td class='tabtd'>身份证号<span class='sp'>*</span></td><td class='tabid'><input name='m.materialtype.proofofdeath.idno' id='idno'/></td>";
	 tab+="</tr>";
	 tab+="<tr class='addtr'>";
	 tab+="<td class='tabtd'>户籍所在地<span class='sp'>*</span></td><td class='tabid'><input name='m.materialtype.proofofdeath.placeOfDomicile' id='placeOfDomicile'/></td>";
	 tab+="<td class='tabtd'>死亡原因<span class='sp'>*</span></td><td class='tabid'><input name='m.materialtype.proofofdeath.causeOfDeath' id='causeOfDeath'/></td>";
	 tab+="</tr>";
	 tab+="<tr class='addtr'>";
	 tab+="<td id='subs'><input type='button' value='申请提交' onclick='submits()'/></td>";
	 tab+="</tr></table>";
	}else{
	alert("不可为空");
	}
	 
	 $("#tabtwotwo").append(tp); 
	
	}
	function money(){
	  var tq=$("input:radio[name='tq']:checked").val();
	  
	var MyAccount=$("#MyAccount").val();
	var idcard=$("#idcard").val();
	$.ajax({
	 url:"ind_seleMoney",
	 type:"post",
	 dataType:"json",
	 data:{"idnum":idcard},
	 success:function(data){
	if(data==false){
	alert("无此用户");
	$("#Mymoney").val("");
	$("#workersName").val("");
	$("#MyAccount").val("");
	$("#exunitnum").val("");
	$("#exunitname").val("");
	}else{
	var s= parseFloat(data[0].presentSumRem).toFixed(2);
	$("#Mymoney").val(s);
	$("#workersName").val(data[0].trueName);
	$("#MyAccount").val(data[0].indAccountId);
	$("#exunitnum").val(data[0].utinaccountId);
	$("#exunitname").val(data[0].utinname);
	$("#exsex").val(data[0].sex);
	$("#indaccstatus").val(data[0].indStatus);
	
	}
	
	//$("#idcard").val(data[0].idnumber);
	/* if(tq==1){
	
	$("#Mymoney").val(parseFloat(s*0.8).toFixed(2));
	}else{
	
	$("#Mymoney").val(s);
	} */
	 
	 }
	})
	}
	
	function submits(){
	
	var exunitnum=$("#exunitnum").val();//单位账户
	var exunitname=$("#exunitname").val();//单位名称
	var exdoctype=$("#exdoctype").val();//证件类型
	var exage=$("#exage").val();//年龄
	var exphone=$("#exphone").val();//手机号
	
	var MyAccount=$("#MyAccount").val();//个人账户
	var workersName=$("#workersName").val();//姓名
	var idcard=$("#idcard").val();//IDNumber
	var payee=$("#payee").val();//收款人
	var Mymoney=$("#Mymoney").val();//个人账户余额
	var bankOfDeposit=$("#bankOfDeposit").val();//开户银行
	var collectionAccount=$("#collectionAccount").val();//收款账户
	var withdrawalAmount=$("#withdrawalAmount").val();//提取金额
	var reasonNo=$("#reasonNo").val();//选择原因 !=0
	
	var shphone=$("#shphone").val();//售房联系电话
	var shaddress=$("#shaddress").val();//售房地址
	var shunit=$("#shunit").val();//售房单位
	var shidnum=$("#shidnum").val();//IDNum
	var hbname=$("#hbname").val();//购房人姓名
	var recnum=$("#recnum").val();//不动产号
	var houcs=$("#houcs").val();//房屋现状	
	var puType=$("#puType").val();//房屋总价
	var puAddress=$("#puAddress").val();//房屋面积
	var pumoney=$("#pumoney").val();//房屋单价
	var puText=$("#puText").val();//购房合同编号
	var ffgg=$("#ffgg").val();
	
	
	var myName=$("#myName").val();//离休姓名
	var utinName=$("#utinName").val();//单位名称	
	var reasForRe=$("#reasForRe").val();//离休原因
	
	
	var proname=$("#proname").val();//死亡姓名
	var idno=$("#idno").val();//身份证号
	var placeOfDomicile=$("#placeOfDomicile").val();//户籍所在地
	var causeOfDeath=$("#causeOfDeath").val();//死亡原因
	var onep=parseFloat(withdrawalAmount).toFixed(2);
	var twop=parseFloat(Mymoney).toFixed(2);
	alert(onep);
	alert(twop);
	if(eval(onep)>eval(twop)){
	alert("金额错误");
	}else{
	
	if((exphone!=""&&exage!=""&&exdoctype!=""&&exunitname!=""&&exunitnum!=""&&MyAccount!=""&&
	workersName!=""&&idcard!=""&&payee!=""&&Mymoney!=""&&bankOfDeposit!=""
	&&collectionAccount!=""&&withdrawalAmount!=""&&reasonNo!=0)
	&&(
	(ffgg!=""&&shaddress!=""&&shunit!=""&&shidnum!=""&&hbname!=""&&recnum!=""&&houcs!=""&&shphone!=""&&puType!=""&&
	puAddress!=""&&pumoney!=""&&puText!=""&&hbname==ffgg)
	||(myName!=""&&utinName!=""&&reasForRe!="")
	||(proname!=""&&idno!=""&&placeOfDomicile!=""&&causeOfDeath!=""))){
	$("#forms").submit();
	}else{
	alert("信息不完整");
	}
	
	}
	
	
	
	}

function mxse(){
var s=$("#mxseid").val();

if(s!=""){

$.ajax({
  url:"sele_rd.action",
  type:"post",
  data:{"mxseid":s},
  dataType:"json",
  success:function(data){
  $(".modal-body").html("");
  if(data==false){
  var tab="没有汇缴信息";
  tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
  $(".modal-body").append(tab);
  }else{
    var tab="<table id='mxtab'>";
    
        tab+="<tr><td>缴存金额</td><td>缴存日期</td></tr>";
        
   for(var i=0;i<data.length;i++){
      tab+="<tr>";
	  tab+="<td>"+data[i].payinSumMoney+"</td>";
	  tab+="<td>"+new Date(data[i].payinDate).toLocaleDateString()+"</td>";
	  tab+="</tr>";
   }
   
   tab+="</table>";
    tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
   $(".modal-body").append(tab);
  }
  }
})
}else{
var tab="请输入账户编号";
  tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
  $(".modal-body").append(tab);
}
}




function jlse(){
 $(".modal-body").html("");
var s=$("#jl").val();
if(s!=""){

$.ajax({
  url:"sele_exre.action",
  type:"post",
  data:{"utlnid":s},
  dataType:"json",
  success:function(data){
  
  if(data==false){
  
  var tab="没有提取纪录";
  tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
  $(".modal-body").append(tab);
  
  }else{
  
  var tab="<table id='mxtab'>";
        tab+="<tr><td>提取金额</td><td>提取时间</td><td>放款时间</td></tr>";
   for(var i=0;i<data.length;i++){
      tab+="<tr>";
	  tab+="<td>"+data[i].withdrawalAmount+"</td>";
	  tab+="<td>"+data[i].extractionDate+"</td>";
	  tab+="<td>"+data[i].loanDate+"</td>";
	  tab+="</tr>";
   }
    tab+="</table>";
    tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
   $(".modal-body").append(tab);
  }
  }
})
}else{
var tab="请输入账户编号";
  tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
  $(".modal-body").append(tab);
}
}
function bjse(){
  $(".modal-body").html("");
 var s=$("#bj").val();
if(s!=""){

$.ajax({
  url:"bjse.action",
  type:"post",
  data:{"indid":s},
  dataType:"json",
  success:function(data){
  
  if(data==false){
  
  var tab="没有补缴纪录";
  tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
  $(".modal-body").append(tab);
  
  }else{
  
  var tab="<table id='mxtab'>";
        tab+="<tr><td>补缴时间</td><td>补缴金额</td><td>补缴月数</td></tr>";
   for(var i=0;i<data.length;i++){
      tab+="<tr>";
	  tab+="<td>"+data[i].supDate+"</td>";
	  tab+="<td>"+data[i].supMoney+"</td>";
	  tab+="<td>"+data[i].supMonth+"</td>";
	  tab+="</tr>";
   }
    tab+="</table>";
    tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
   $(".modal-body").append(tab);
  }
  
  }
})
}
else{
var tab="请输入账户编号";
  tab+="<button type='button' style='margin-left:500px;' class='btn btn-default' data-dismiss='modal'>关闭</button>";
  $(".modal-body").append(tab);
}

}


</script>