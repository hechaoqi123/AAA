<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>按揭偿还贷款</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <style>
    table{
       border-collapse: collapse;
       font-family: '楷体';
       }
    td,th{
         width:150px;
         height:40px;
         line-height:40px;
         text-align:left;
       }
       #tab td{
        width:140px;
         height:20px;
         text-align:center;
       }
       .le
   </style>
</head>
  
  <body> 
    <h2>贷款进度查询</h2>
      请输入个人身份证号：<input type="text" id="id"/>   <button id="index">点击查询</button><br/><br/>
      <form action="sure_borr.action" method="post">
          <div style="border:1px solid #999;width:900px;padding-bottom:20px;">
          <table style="margin-left:70px;padding-right:70px;">
            <tr>
               <th colspan="8" style="height:50px;text-align: center">贷款申请进度查询</th>
            </tr>
            <tr>
               <td>申请书编号：</td>
               <td class="le" colspan="3" id="td1"></td>
               <td></td>
               <td>借款人姓名：</td>
               <td class="le" colspan="3" id="td2"></td>
            </tr>
            <tr> 
               <td>身份证号码：</td>
               <td class="le" colspan="3" id="td3"></td>
               <td></td>
               <td>所在单位名称：</td>
               <td class="le" colspan="3" id="td4"></td>
            </tr>
            <tr>
               <td>联系电话：</td>
               <td class="le" colspan="3" id="td5"></td>
               <td></td>
               <td>借款金额：</td>
               <td class="le" colspan="3" id="td6"></td>
            </tr>
            <tr>
               <td>担保方式：</td>
               <td class="le" colspan="3" id="td7"></td>
               <td></td>
               <td>共同借款人：</td>
               <td class="le" colspan="3" id="td8"></td>
            </tr>
            <tr>
               <td>年利率（%）：</td>
               <td class="le" colspan="3" id="td9"></td>
               <td></td>
               <td>所购房型：</td>
               <td class="le" colspan="3" id="td10"></td>
            </tr>
            <tr>
               <td>还款方式：</td>
               <td class="le" colspan="3" id="td11"></td>
               <td></td>
               <td>申请书状态：</td>
               <td class="le" colspan="3" id="td12"></td>
            </tr>
             <tr>
               <td>备注：</td>
               <td class="le" colspan="3" id="td13"></td>
            </tr>
          </table>
          </div>
          <br/>
      </form>
  </body>
</html>
 <script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
  $("#index").click(function(){
           var id=$("#id").val();
      if(id==""){
         alert("身份证号不能为空");
               $("#td1").html("");
               $("#td2").html("");
               $("#td3").html("");
               $("#td4").html("");
               $("#td5").html("");
               $("#td6").html("");
               $("#td7").html("");
               $("#td8").html("");
               $("#td9").html("");
               $("#td10").html("");
               $("#td11").html("");
               $("#td12").html("");
               $("#td13").html("");
      }else{
       $.ajax({
           url:'find_Loan.action',
           type:'post',
           data:{'borrowerIdnumber':id},
           dataType:'json',
           success:function(data){
	           if(data=="error"){
	             alert("error")
	           }
               $("#td1").html(data.loanApplicationId);
               $("#td2").html(data.nameOfBorrower);
               $("#td3").html(data.borrowerIdnumber);
               $("#td4").html(data.borrowersUnit);
               $("#td5").html(data.borrowerPhone);
               $("#td6").html(parseInt(data.borrowingBalance)+"（万元）");
               $("#td7").html(data.guaranteemode.securityModeDes);
               $("#td8").html(data.coborrower.coborrowerName);
               $("#td9").html(data.annualRate);
               $("#td10").html(data.remarks);
               $("#td11").html(data.unitAddress);
               $("#td12").html(data.status);
               $("#td13").html(data.coborrower.coborrowerAddress); 
            
           },error:function(){
             alert("操作异常！")
           }
        })
      } 
  })
</script>
