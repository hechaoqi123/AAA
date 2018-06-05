<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息信息</title>
    
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

<style type="text/css">

   body{
  font-family:宋体;
  }
 .sp{
    color:red;
    }
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
    input{
    text-align: center;
    }
    #ty{
    width:100px;
    height:40px;
    background-color:#cbe7b2;
    margin-left: 200px;
    margin-top:50px;
    }
     #bty{
    width:100px;
    height:40px;
    margin-left:500px;
    margin-top:50px;
    background-color:red;
    }
</style>
  </head>
  
  <body>
  <div style="width:100%;height:50px;text-align: center;line-height: 50px;font-size:20px;color:black;">申请人信息</div>
  <table class="table">
   
  <tr>
    <td>个人账户</td>
    <td><input value="${list[0].IndAccountID}" readonly="readonly"/></td>
    <td>姓名</td>
    <td><input value="${list[0].payee}" readonly="readonly"/></td>
    <td>证件类型</td>
    <td><input value="${list[0].exdoctype}" readonly="readonly"/></td>
  </tr>
 
  <tr>
   <td>身份证号</td>
   <td><input value="${list[0].exidnum}" readonly="readonly"/></td>
   <td>年龄</td>
   <td><input value="${list[0].exage}" readonly="readonly"/></td>
   <td>性别</td>
   <td><input value="${list[0].exsex}" readonly="readonly"/></td>
  </tr>
   <tr>
   <td>账户状态</td>
   <td><input value="${list[0].indaccstatus}" readonly="readonly"/></td>
   <td>提取方式</td>
   <td><input value="${list[0].exmodel}" readonly="readonly"/></td>
    <td>手机号码</td>
   <td><input value="${list[0].exphone}" readonly="readonly"/></td>
  </tr>

  
  <tr>
    <td>开户银行</td>
    <td><input value="${list[0].bankOfDeposit}" readonly="readonly"/></td>
    <td>银行账户</td>
    <td><input value="${list[0].collectionAccount}" readonly="readonly"/></td>
    <td>账户姓名</td>
    <td><input value="${list[0].workersName}" readonly="readonly"/></td>
  </tr>
  <tr>
    <td>提取金额</td>
    <td><input value="${list[0].withdrawalAmount}" readonly="readonly"/></td>
    <td>审批状态</td>
    <td><input value="${list[0].approvalStatus}" readonly="readonly"/></td>
    <td>申请时间</td>
     <td><input value="${list[0].applicationtime}" readonly="readonly"/></td>
  </tr>
  <tr>
    <td>单位账户</td>
    <td><input value="${list[0].exunitnum}" readonly="readonly"/></td>
    <td>单位名称</td>
    <td><input value="${list[0].exunitname}" readonly="readonly"/></td>
   
  </tr>
  </table>
  <div id="tabtwotwo">
   <table>
    <tr><td colspan='4'>购房合同信息</td></tr> 
	  <tr> 
	  <td>购房人姓名<span class='sp'>*</span></td><td><input value="${list[1].hbname}" readonly="readonly"name='m.materialtype.purinfo.hbname' id='hbname' class='tto'/></td> 
	  <td>身份证号<span class='sp'>*</span></td><td><input value="${list[1].shidnum }" readonly="readonly" name='m.materialtype.purinfo.shidnum' id='shidnum' class='tto'/></td> 
	  </tr> 
	  <tr> 
	  <td>售房单位<span class='sp'>*</span></td><td><input value="${list[1].shutin }" readonly="readonly"name='m.materialtype.purinfo.shutin' id='shunit' class='tto'/></td> 
	  <td>售房联系电话<span class='sp'>*</span></td><td><input value="${list[1].shphone }" readonly="readonly"name='m.materialtype.purinfo.shphone' id='shphone' class='tto'/></td> 
	  </tr> 
	  <tr> 
	  <td>售房地址<span class='sp'>*</span></td><td colspan='3'><input value="${list[1].shaddress }" readonly="readonly"name='m.materialtype.purinfo.shaddress' id='shaddress'/></td> 
	  </tr> 
	  <tr> 
	  <td>房屋每平价<span class='sp'>*</span></td><td><input value="${list[1].pumoney }" readonly="readonly"name='m.materialtype.purinfo.pumoney' id='pumoney'/><span style='font-size:15px;'>㎡</span></td> 
	  <td>房屋面积<span class='sp'>*</span></td><td><input value="${list[1].puAddress }" readonly="readonly"name='m.materialtype.purinfo.puAddress' id='puAddress'/><span style='font-size:20px;'>㎡</span></td> 
	  </tr> 
	  <tr> 
	  <td>房屋现状<span class='sp'>*</span></td><td><input value="${list[1].houcs }" readonly="readonly"name='m.materialtype.purinfo.houcs' id='houcs' class='tto'/></td> 
	  <td>房屋总价<span class='sp'>*</span></td><td><input value="${list[1].puType }" readonly="readonly"name='m.materialtype.purinfo.puType' id='puType'  class='tto'/></td> 
	  </tr> 
	  <tr> 
	  <td>购房合同编号<span class='sp'>*</span></td><td colspan='3'><input value="${list[1].puText }" readonly="readonly"name='m.materialtype.purinfo.puText' id='puText'/></td> 
	  </tr> 
	  <tr> 
	  <td>所购住房坐落<span class='sp'>*</span></td><td colspan='3'><span style='font-size:10px;'>请按购房合同或房屋所有权证或不动产权证上的地址填写</span><input value="${list[1].recnum }" readonly="readonly"name='m.materialtype.purinfo.recnum' id='recnum'/></td> 
	  </tr> 
	  <tr> 
	  <td colspan='4'><span style='color:black;'>个人住房信息核查授权、承诺书</span></td> 
	  </tr> 
	  </table> 
	  <div style='width:700px;height:350px;border:0px solid black;'> 
	   <p><br/><br/>&nbsp;&nbsp;本人因申请提取住房公积金，现授权北京住房公积金管理中心（以下简称管理中心）通 
	  过北京市住房<br/>&nbsp;&nbsp;和城乡建设委员会、北京市规划和国土资源管理委员会、北京市经济和信息化委员会等部门核查本人<br/>&nbsp;&nbsp;提交的提取材料及相关信息；授权管理中心通过中国人民银行金融信用信息基础数据库查询本人的个人<br/>&nbsp;&nbsp;信用信息，同意管理中心对此次提交的提取材料及相关信息进行现场核实。<br/></p> 
	  <p>&nbsp;&nbsp;本人郑重承诺：本人如实填写的上述各项信息及提交材料真实有效。若承诺失实，本人愿意承担以下后果：<br/> 
	  &nbsp;&nbsp;1.终止提取行为，并在规定期限内退还所提取金额；<br/> 
	  &nbsp;&nbsp;2.将违规行为通报所在单位并对外公布；<br/> 
	  &nbsp;&nbsp;3.将违规信息计入住房公积金个人不良信息库和国家有关征信系统；<br/> 
	  &nbsp;&nbsp;4.自违规发现之日起三年内不予办理住房公积金提取、不予受理住房公积金贷款申请；<br/> 
	  &nbsp;&nbsp;5.涉嫌构成犯罪的，移送司法机关处理。<br/> 
	  &nbsp;&nbsp;我已认真阅读上述内容，同意授权并遵守上述承诺。<br/> 
	  <div style='margin-left:400px;margin-top:40px;'>申请人签字<input value="${list[1].hbname}" readonly="readonly"id='ffgg'/></span></div> 
	 </div> 
	 
	 <div><p>备注:</p></div>
   <div><textarea rows="10" cols="95" style="font-size:15px;"></textarea></div>
   
   </table>
   </div>
   <div><button onclick="subs(${list[0].approvalNumberId},${list[0].IndAccountID},${list[0].withdrawalAmount},${list[0].applicationtime})" id="ty">同意提取</button>
   <button onclick="notsub(${list[0].approvalNumberId})" id="bty">不同意提取</button>
   </div>
  </body>
</html>
<script>
function subs(a,b,c,d){
	
	 $.ajax({
	 url:"yes_con.action",
	 type:"post",
	 data:{"appid":a,"indid":b,"money":c,"apptime":d},
	 dataType:"json",
	 success:function(data){
		 window.location.href="<%=basePath%>ssw/examine.jsp";
	 }
	}) 
	}
	function notsub(a){
	 alert(a); 
	$.ajax({
	 url:"not_con.action",
	 type:"post",
	 data:{"appid":a},
	 dataType:"json",
	 success:function(data){
		 window.location.href="<%=basePath%>ssw/examine.jsp";
	 }
	}) 
	}
</script>