<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>汇缴</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
	<link rel="stylesheet" href="<%=basePath %>bootstrap/bootstrap.min.css" type="text/css"></link>
	<script type="text/javascript" src="bootstrap/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath %>bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>JS/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>JS/My97DatePicker/WdatePicker.js"></script>

<style type="text/css">
 body{

MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;
}
/*a{
color:blue;
}
  #tabone{
   font-size: 15px;
   color:black;
   border:1px solid black;
  }
  
  
  #tabone{
  
   font-size:15px;
   color:black;
   border:1px solid black;
   border-collapse:collapse;
  }
   #tabone td{
   border:1px solid black;
   font-size:15px;
   width:150px;
   height:50px;
   text-align: center;
  }
  #tabone input{
   font-size:15px;
   color:black;
   border:1px solid #CACACA;
   border-collapse:collapse;
   width:200px;
   height:50px;
  }*/
  #tabtwo{
  border:1px solid black;
   border-collapse:collapse;
  }
 #tabtwo td{
 width:192px;height:25px;
 border:1px solid black;	

 } 
 .jstab{
 border:1px solid black;
   border-collapse:collapse;
 }
 .jstab td{
  width:192px;
  height:25px;
  font-size:15px;
  border:1px solid black;
  text-align: cenetr;
  }
  .jstab input{
  width:138px;
  height:25px;
  border:0px;
  text-align: cenetr;
  }
  
  #tabthree{
   border:1px solid black;
   border-collapse:collapse;
  }
  #tabthree td{
  border:1px solid black;
   font-size:15px;
   width:150px;
   height:30px;
   text-align: center;
  }
  #tabthree input{
   font-size:15px;
   color:black;
   border:0px solid #CACACA;
   border-collapse:collapse;
   width:150px;
   height:30px;
  }
 #threediv input{
 margin-left:250px;
 margin-top:20px;
 font-size:15px;
 height:40px;
 }
  #whatthefuck{
  border-collapse:collapse;
  }
  #whatthefuck td{
  width:200px;
  height:20px;
  border:1px solid black;
  }
</style>


</head>
 
  <body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
           
         <div class="modal-body">
         <table id="whatthefuck">
         
         </table>
         </div>
        <button type="button" style="margin-left: 530px;" class="btn btn-default" data-dismiss="modal">关闭</button>
        </div><!-- /.modal-content -->
         
    </div><!-- /.modal -->
</div>

  <div style="border:0px solid red;height:50px;width:100%;" >
  <table style="border:0px solid red;height:50px;font-size: 20px;">
       <tr>
        <td>单位编号:</td>
         <td><input id="utinid" style="width:300px;height:35px;font-size:30px;" onkeyup="idsousuo(1,0)"/></td>
         <!-- <td><input type="button" value="搜索" style="height:35px;width:100px;" onclick="sousuo(0)"/></td> -->
         
         <td>单位名称</td>
         <td><input id="utinname" style="width:300px;height:35px;font-size:20px;" onkeyup="namesousuo(1,0)"/></td>
       </tr>
    </table>
    </div>
    
    
     <div id="tab" style="border:0px solid black;height:600px;width:100%"> </div>
    
   
   <span id="UserName" style="display:none;"> ${user.uname}</span>

                                
	 	 							     
												  
  </body>
</html>
<script>
 var  zongzhi;
 var onelist=new Array();
 var twolist=new Array();
 //var sumindex=data[1].indAccount.length;
 
 //
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
      trs+="<td><button onclick='sousuo("+data.list[dl].utinAccountId+")'>汇缴</button></td>";
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
 //单位id模糊查询
  function idsousuo(dian,what){
   $("#tab").html("");
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
      trs+="<td><button onclick='sousuo("+data.list[dl].utinAccountId+")'>汇缴</button></td>";
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
   $("#tab").append(trs);
   }
  })
  }
  //单位名称模糊查询
  function namesousuo(dian,what){
   $("#tab").html("");
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
      trs+="<td><button onclick='sousuo("+data.list[dl].utinAccountId+")'>汇缴</button></td>";
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
   $("#tab").append(trs);
   }
  })
  }
 
 //账户信息
	function sousuo(hui){
	
	 $("#tab").html("");
	 var oneyin;
	if(hui!=0){
	oneyin=hui;
	}else{
	oneyin=$("#utinid").val();
	}
     
     
		  $.ajax({
		  url:"UtinMoney.action",
		  type:"post",
		  dataType:"json",
		  
		  data:{"UtinId":oneyin},
		  success:function(data){
		if(data!=false){
		zongzhi=data[1].SumMoney;
		    var tab="<table id='tabone' class='table'>";
		     tab+="<tr><td colspan=6>汇缴单</td></tr>";
		    tab+="<tr><td>单位编号</td>";
		    tab+="<td><input value='"+data[0].utinAccountId+"' readonly='readonly' class='utinAccountId'/></td>";
		    tab+="<td>单位名称</td>";
		    tab+="<td><input value='"+data[0].utinName+"' readonly='readonly' class='utinName'/></td>";
		    tab+="<td>记账日期</td>";
		    tab+="<td><input value='"+data[1].times+"' readonly='readonly'/></td>"; 
		    tab+="</tr>";
		    tab+="<tr>";
		    tab+="<td>单位总人数</td>";
		    tab+="<td><input value='"+data[0].utinSumPeople+"' readonly='readonly'/></td>";
		    tab+="<td>本次缴存人数</td>";
		    tab+="<td><input value='"+data[0].utinDepositPeople+"' readonly='readonly' id='depositPeople'/></td>";
		    tab+="<td>封存人数</td>";
		    tab+="<td><input value='"+data[0].utinSealPeople+"' readonly='readonly'/></td>";
		    tab+="</tr>";
		    
		   
		   if(data[1].dlist[0]!=null){
		    tab+="<tr>";
		    tab+="<td>上次汇缴金额</td><td><input value='"+data[1].dlist[0].PayinSumMoney+"' readonly='readonly'/></td><td>上次汇缴时间</td><td><input value='"+data[1].dlist[0].DepositDate+"' readonly='readonly'/></td>";
		    tab+="<td>上次汇缴人数</td><td><input value='"+data[1].dlist[0].DepositPeople+"' readonly='readonly'/></td>";
		    tab+="</tr>";
		   }else{
		    tab+="<tr>";
		    tab+="<td>上次汇缴金额</td><td><input value='无' readonly='readonly'/></td><td>上次汇缴时间</td><td><input value='无' readonly='readonly'/></td>";
		    tab+="<td>上次汇缴人数</td><td><input value='无' readonly='readonly'/></td>";
		    tab+="</tr>";
		   }
		   
		    tab+="<tr>";
		    tab+="<td>当前账户余额</td><td><input readonly='readonly' value='"+data[0].utinProvRema+"' id='utinProvRema'/></td>";
		    tab+="<td>本次应交金额</td><td><input  readonly='readonly' id='summoney'/></td>";
		    tab+="<td>实交金额</td><td><input  readonly='readonly' id='sjmoney'/></td>";
		    tab+="</tr>";
		    tab+="<tr>";
		    tab+="<td>汇缴起始年月</td><td><input id='oridate'  onblur='dblur(this.value)' class='Wdate' onclick='times()'  onload='tttt()'/></td>";

												
		    tab+="<td>汇缴最终年月</td><td><input id='finaldate' value='"+data[1].times.substring(0,7)+"' readonly='readonly'/></td>";
		    tab+="<td>汇缴月数</td><td><input id='remonth' readonly='readonly'/></td></tr>";
		  
		    tab+="";
		    
		    tab+="</table>";
		    tab+="<div style='border:0px solid green;width:100%px;height:300px; overflow:auto'>";
		    tab+="<table id='tabtwo'><tr><td>员工姓名 </td><td>身份证号 </td><td>缴存基数</td><td>单位缴存比例</td><td>个人缴存比例</td><td>个人应缴金额 </td><td>应缴总金额</td></tr></table>";
		    tab+=" <table class='jstab'>";
		  
		    for(var i=0;i<data[1].indAccount.length;i++){
			     tab+="<tr>";
			     tab+="<td style='display:none'> <input value='"+data[1].indAccount[i].indAccountId+"'readonly='readonly' class='indAccountId'/></td>";
			     tab+="<td>"+data[1].indAccount[i].trueName+"</td>";		   
			     tab+="<td><input value='"+data[1].indAccount[i].iDNumber+"' readonly='readonly' class='iDNumber'/></td>";		    
			     tab+="<td>"+data[1].indAccount[i].indDepositRadices+"</td>";	
			     tab+="<td>"+data[0].utinDepositRatio+"</td>";		   
			     tab+="<td>"+data[1].indAccount[i].indDepositRatio+"</td>";	
			     tab+="<td><input value='"+data[1].indAccount[i].indDepositRadices*data[1].indAccount[i].indDepositRatio+"' readonly='readonly' class='onePayin'/></td>";
			   
			    onelist.push(data[1].indAccount[i].indDepositRadices*data[1].indAccount[i].indDepositRatio);
			   
			     tab+="<td><input value='"+data[1].indAccount[i].indDepositRadices*data[1].indAccount[i].indDepositRatio*2+"'readonly='readonly' class='PayinSumMoney'/></td>";		
			  
			  twolist.push(data[1].indAccount[i].indDepositRadices*data[1].indAccount[i].indDepositRatio*2);
			   
			    tab+="<td style='display:none'> <input value='"+data[1].indAccount[i].usableRem+"' readonly='readonly' class='usableRem'/></td>";
			     tab+="<td style='display:none'> <input value='"+data[1].indAccount[i].presentSumRem+"' readonly='readonly' class='presentSumRem'/></td>";
			      tab+="</tr>";
			  
		     
		    }
            
             tab+="</table>";
             tab+="</div>";
             tab+="<table id='tabthree'>";
             tab+="<tr><td>缴存方式</td><td><input value='均缴' readonly='readonly' style=' background-color:white;'/></td>";
               tab+="<td>缴后账户余额</td>";
		    tab+="<td><input   readonly='readonly' id='jhqian'/></td>"; 
		    
             tab+="<td>实收金额<span style='color:red;font-size:20px;line-height: 20px;'>*</span></td><td><input id='smoney' style='background-color:white;' onblur='beginmoney(this.value)'/></td>";
             tab+="<td><a  data-toggle='modal' data-target='#myModal' onclick='URsele()'>汇缴清册</a></td>";
             tab+="<td>制单人</td><td><input  id='adminname'value='"+$("#UserName").html()+"'  readonly='readonly'/></td>";
             tab+="</tr>";
             
             tab+="</table>";
             tab+="<div style='border:0px solid green;width:100%px;height:100px;' id='threediv'>";
              tab+="<input type='button' value='重置实收金额' onclick='moneys()' style='width:100px;'/>";
              tab+=" <input type='button' value='提交' onclick='sub()'/>";
              
            tab+="</div>";
		    $("#tab").append(tab);
		     $("#utinid").val("");
		     
		     var dates=new Date();
		     var year=dates.getFullYear();		
		     var month=(dates.getMonth()+1>9)?dates.getMonth()+1:"0"+(dates.getMonth()+1);
		     $("#oridate").val(year+"-"+month);
		    var oridateval=$("#oridate").val();
		    dblur(oridateval);
		   }else{
		   alert("无此账号");
		    $("#tab").html("");
		   }
		  
		  }
	   })  
	 
	}
	// 获取当天的年月日
  
	//onFocus='WdatePicker({maxDate:'%y-%M'})';
	
	function times(){
	 WdatePicker({skin:'whyGreen',minDate:'%y-{%M-3}',readOnly:true, maxDate:'%y-%M'});
	}
	function tttt(){

	WdatePicker({dateFmt:'yyyy-MM'});
	}
	
	function dblur(obj){
	
	//var ones=new Date(obj);
	var twos=$("#finaldate").val();
	//日期转换
	date1 = obj.split('-');
	date1 = parseInt(date1[0]) * 12 + parseInt(date1[1]);
	date2 = twos.split('-');
	date2 = parseInt(date2[0]) * 12 + parseInt(date2[1]);
	var m = Math.abs(date1 - date2);
	
	/* alert(twos.setMonth(twos.getMonth+1) );
	alert(ones.setMonth(ones.getMonth+1));
	alert(new Date(twos-ones)); */
	/* var finaldate=$("#finaldate").val().substring(6,7);
	var o=obj.substring(6,7); */
	
	
	
	if(obj!=""){
	//日期计算
	var twos=$("#finaldate").val();
	date1 = obj.split('-');
	date1 = parseInt(date1[0]) * 12 + parseInt(date1[1]);
	date2 = twos.split('-');
	date2 = parseInt(date2[0]) * 12 + parseInt(date2[1]);
	var m = Math.abs(date1 - date2);//得到相差月数
	
	//var aps=finaldate-o+1;
	
	 $("#remonth").val(m+1); 
	
	//本次应缴金额
	 $("#summoney").val(parseFloat(zongzhi*(m+1)).toFixed(2));
	
	
	//个人应缴金额
	var  index=0;
	$(".onePayin").each(function(){
	
	/* var indexval=$(this).index();
	alert($(this).index());	 */
	$(this).val(onelist[index]*(m+1));
	index++;
	
	});
	// $(".usableRem").val(umo*aps);
	//应缴总金额
	var payindex=0;
	$(".PayinSumMoney").each(function(){
	//var indexval=$(this).index();
	
	$(this).val(twolist[payindex]*(m+1));
	payindex++;
	});
	
	var utinyue=parseFloat($("#utinProvRema").val()).toFixed(2);//账户余额
	var summoney=parseFloat($("#summoney").val()).toFixed(2);//本次应缴金额
	//var sjmon=parseFloat($("#sjmoney").val()).toFixed(2);
	
	
	if(eval(utinyue)<eval(summoney)){
	var sps=parseFloat(summoney).toFixed(2)-parseFloat(utinyue).toFixed(2);
	
	$("#sjmoney").val(parseFloat(sps).toFixed(2));
	}else{
	$("#sjmoney").val(parseFloat(0).toFixed(2));
	}
	
	}
	
	}
	
	//实收
	function beginmoney(obj){ //obj=实收
	
		var utinyue=parseFloat($("#utinProvRema").val()).toFixed(2);//账户余额
	var summoney=parseFloat($("#summoney").val()).toFixed(2);//本次应缴金额
	//alert($("#utinProvRema").val());
	//alert($("#summoney").val());
	//if(eval(parseFloat(utinyue).toFixed(2))>eval(parseFloat(summoney).toFixed(2))){
	if(utinyue>summoney){
	
	var sps=parseFloat(obj).toFixed(2)*1 + parseFloat(utinyue).toFixed(2)*1;
	$("#jhqian").val(sps);
	}else{
	
	var sps=parseFloat(obj).toFixed(2)*1 +parseFloat(utinyue).toFixed(2)*1-parseFloat(summoney).toFixed(2)*1;
	
	//
	//alert(sps);
	$("#jhqian").val(sps);
	}
	
	}
	
	
	//充值金额
	function moneys(){
	 $("#smoney").val("");
	}
	
	
	function sub(){
	var sjmoney=parseFloat($("#sjmoney").val()).toFixed(2);//实缴
	var smoney=parseFloat($("#smoney").val()).toFixed(2);//实收
	if(smoney*1<sjmoney*1){
    alert("金额不对等");
	
	} else if($("#oridate").val()==""){
	alert("不能为空");
	}else{

	var jsons=new Array();
	
	$(".jstab").find("tr").each(function(){
	var indAccountId=$(this).find(".indAccountId").val();
	
	var usableRem=$(this).find(".usableRem").val();
	var presentSumRem=$(this).find(".presentSumRem").val();
	var payinSumMoney=$(this).find(".PayinSumMoney").val();
	var iDNumber=$(this).find(".iDNumber").val();
	var jsonstr={"indAccountId":indAccountId,
	"usableRem":usableRem,"presentSumRem":presentSumRem,
	"payinSumMoney":payinSumMoney,
	"iDNumber":iDNumber,
	"utinAccountId":$(".utinAccountId").val(),
	"utinName":$(".utinName").val(),
	"depositPeople":$("#depositPeople").val(),
	"summoney":$("#summoney").val(),
	"oridate":$("#oridate").val(),
	"finaldate":$("#finaldate").val(),
	"remonth":$("#remonth").val(),
	"adminname":$("#adminname").val(),
	"utinprovrema":$("#jhqian").val()
	};
	
	jsons.push(jsonstr);
	})
	
	
	
	$.ajax({
	 url:"indAccountInfoAdd.action",
	 type:"post",
	 dataType:"json",
	 data:{"jsons":JSON.stringify(jsons)},
	 success:function(data){
	if(data=="false"){
	alert("汇缴失败");
	}else{
	alert("汇缴成功");
	window.location.href="/HousingFund/ssw/RemPro.jsp";
	}
	 }
	})
	} 
	
	
	 /* window.location.href="ssw/RemPro.jsp"; */
	}
	   
	   //汇缴纪录 目前失效
	   function URsele(){
	   var zhi=$(".utinAccountId").val();
	   
	 
	  $.ajax({
	 url:"seleUR.action",
     type:"post",
     data:{"utlnid":zhi},
     dataType:"json",
     success:function(data){
     $("#whatthefuck").html("");
     var tab;
	   
	   tab+="<tr>";
         tab+="<td>单位名称</td><td>汇缴金额</td><td>汇缴人数</td><td>汇缴时间</td>";
          tab+="</tr>";
	   for(var i=0;i<data.length;i++){
        tab+="<tr>";
        tab+="<td>"+data[i].utinName+"</td>";
        tab+="<td>"+data[i].payinSumMoney+"</td>";
        tab+="<td>"+data[i].depositPeople+"</td>";
        tab+="<td>"+data[i].depositDate+"</td>";
        tab+="</tr>";
      } 
	  
	   $("#whatthefuck").append(tab);
	   }
	   
	  })
	   }
	   /***************/
	


</script>