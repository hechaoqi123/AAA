<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'timer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="JS/jquery-1.10.2.min.js"></script>
  <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css"></link>
  <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
  
  <style>
  body{
  font-family: '楷体';
  }
  input{
  border-left:0px;
  border-right:0px;
  border-top:0px;
  border-bottom: 1px solid black;
  }
  select{
   text-align: center;
     text-align-last: center;
    border-left:0px;
  border-right:0px;
  border-top:0px;
  border-bottom: 1px solid black;
  }
  #onediv{
  
  border:1px solid black;
  width:900px;
  height:750px;
  margin-left: 200px;
  }
  #headdiv{
  
 border-bottom:1px solid black;
 width:900px;
  height:50px;
  }
  #bodydiv{
  margin-left:100px;
  margin-top:50px;
  border:1px solid black;
  width:698px;
  height:200px;
  }
  #weidiv{
  margin-left:100px;
  margin-top:50px;
  border:1px solid black;
  width:698px;
  height:300px;
  }
  </style>
  </head>
  
  <body>
  

   
   
    <form action="" method="post" >
   
     <div id="onediv">
     <div id="headdiv"><center>
  <span style="font-size:15px; text-align: center;line-height: 50px;font-size:20px;color:black;">到时缴费协议书</span>
  </center></div>
  
  <div id="bodydiv">
  <p style="font-size:20px;color:black;"><center>甲方信息</center></p>
  <div>

 <table class="table">
      <tr>
	    <td>单位账号</td><td><input id="utinid" onblur="yanz(this.value)"/>
	    <input id="pa" style="display:none"/>
	    <span id="utinidspan" style="color:red;"></span></td>
	     <td>单位名称</td> <td><input id="utinname"/></td>
     </tr>
     <tr>
       <td>是否已开启此业务</td><td><select style="width:170px;height:30px;">
       <option>是</option>
       <option>否</option>
       </select></td>
       <td>申请人</td><td><input/></td>
     </tr>
    <!--  <tr>
        <td>业务证明</td><td><input /></td>
        <td>状态</td>
        <td><select style="width:200px;height:30px;" id="ifelseFP"><option value="是">开启</option><option value="否">关闭</option></select></td>
     </tr> -->
      
     
      
    </table>
  </div>
  </div>
  <div id="weidiv">
  <div style="width:698px;height:50px;border-bottom:1px solid black; text-align: center;line-height: 50px;font-size:20px;color:black;">授权书</div>
 <br/> <br/>授权内容:<br/>
 
  &nbsp; &nbsp;甲方已知悉"到时缴费"业务须知，(开启时)授权并委托乙方将本单位账户余额充足时,每月月末将自动缴费到
   &nbsp; &nbsp;单位正常人员账户，账户余额不足时将不会自动缴费，但不会关闭此功能，需甲方提交此业务申请可关闭。
   (关闭时)委托方将不会缴存，需开启才业务才能自动缴存。<br/><br/><br/>
   <div style="width:698px;height:50px;">

   <div style="margin-left:400px;"> 
   
   业务功能<select style="width:200px;height:30px;" id="ifelseFP">
       <option value="是">开启</option><option value="否">关闭</option>
       </select></div>
  
  
       
    </div>
    <div style="width:698px;height:50px;">
    <div style="margin-left:400px;">申请人签字<input id="FluPayprove"/></span></div>
    </div> 
    
       
     
  
  
  </div>
   <button onclick="sub()" style="margin-left:650px;margin-top: 40px;width:100px;">提交</button>
     
     </div>
	    
        
     
      
     
      

   </form>
  
  
 
  
  
 
  </body>
</html>
<script>
function yanz(obj){

$.ajax({
  url:"idsele.action",
  type:"post",
  dataType:"json",
  data:{"UtinId":obj},
  success:function(data){
  if(data!=false){
  $("#utinidspan").html("");
 $("#pa").val(1);
   $("#utinname").val(data[0].utinName);
  }else{
 $("#pa").val(2);
   $("#utinidspan").html("");
  $("#utinidspan").html("无此账户");
  }
  }
})
}
	function sub(){
	var FluPayprove=$("#FluPayprove").val();
	var utinid=$("#utinid").val();
	var pa=$("#pa").val();
	var utinname=$("#utinname").val();
	var ifelseFP=$("#ifelseFP").val(); 
	if(FluPayprove!=""&&utinid!=""&&pa!=2&&utinname!=""){
	
	  $.ajax({
		  url:"upinse.action",
		  type:"post",
		  dataType:"json",
		  data:{"fu.fluPayprove":FluPayprove,"fu.utinName":utinname,"fu.ifelseFp":ifelseFP,
		  "fu.utinaccountinfo.utinAccountId":utinid},
		  success:function(data){
		  if(data==1){
		  alert("SUCCESS");

		  window.href.location="HousingFund/LDL/success.jsp";
		  }else{
		  
		  }
		  }
	})
	}
	}

</script>
