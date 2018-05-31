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
    <h2>按揭偿还贷款</h2>
      请输入个人身份证号：<input type="text" id="id"/>   <button id="index">点击检索</button><br/><br/>
      <form action="sure_borr.action" method="post">
          <div style="border:1px solid #999;width:900px;">
          <table style="margin-left:70px;padding-right:70px;">
            <tr>
               <th colspan="8" style="height:50px;text-align: center">个人住房公积金贷款还款凭证（电子回单）</th>
            </tr>
            <tr>
               <td>借款账户：</td>
               <td class="le" colspan="3" id="td1"></td>
               <td></td><td>贷款银行：
               <td class="le" colspan="3" id="td2"></td>
            </tr>
            <tr> 
               <td>贷款人姓名：</td>
               <td class="le" colspan="3" id="td3"></td>
               <td></td><td>贷款人身份证号：</td>
               <td class="le" colspan="3" id="td4"></td>
            </tr>
            <tr>
               <td>贷款金额：</td>
               <td class="le" colspan="3" id="td5"></td>
               <td></td><td>贷款利率：</td>
               <td class="le" colspan="3" id="td6"></td>
            </tr>
            <tr>
               <td>合同签订日：</td>
               <td class="le" colspan="3" id="td7"></td>
               <td></td><td>贷款期限：</td>
               <td class="le" colspan="3" id="td8"></td>
            </tr>
             <tr>
               <td>还款方式：</td>
               <td class="le" colspan="3" id="td9"></td>
            </tr>
             <tr>
               <td colspan="8"  id="show">
               </td>
             </tr>
          </table>
          </div>
          <br/>
          <input  name="borrowMoneyAgreementId" id="return_id"  style="display:none"/>
          <input style="margin-left:300px;" type="submit" value="确认还款（打印凭证）"/>
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
               $("#show").html("");
                $("#return_id").val("");
      }else{
       $.ajax({
           url:'get_borr.action',
           type:'post',
           data:{'borrowerIdno':id},
           dataType:'json',
           success:function(data){
               $("#td1").html(data[1].repaymentAccount);
               $("#td2").html("中国银行");
               $("#td3").html(data[1].borrowerName);
               $("#td4").html(data[1].borrowerIdno);
               $("#td5").html(parseInt(data[1].borrowMoneyNumber*10000));
               $("#td6").html(data[1].borrowerAnnualRate);
               $("#td7").html(data[1].borrowerPhone);
               $("#td8").html(data[1].borrowerFixedYear);
               $("#td9").html(data[1].repaymentMode);
               $("#return_id").val(data[0].repaymentPlanDetailsiId);
              var html="<table id='tab' border='1'>";
		          html+="<tr>";
		          html+="<td>还款日期</td>";
		          html+="<td>还款类别</td>";
		          html+="<td>还款期数</td>";
		          html+="<td>还款本金</td>";
		          html+="<td>还款利息</td>";
		          html+="<td>逾期罚息</td>";
		          html+="<td>还款合计</td>";
		          html+="<td>逾期日期</td>";
		          html+="</tr>";
		          html+="<tr>";
			      html+="<td>"+new Date().toLocaleDateString()+"</td>";
			       alert
		          if(data[0].overduePrincipalAndInte>0){
			          html+="<td>逾期还款</td>";
		          }else{
			          html+="<td>正常还款</td>";
		          }
		          html+="<td>"+data[0].currentPeriod+"</td>";
			      html+="<td>"+data[0].currentReturnedCorpus+"</td>";
			      html+="<td>"+data[0].currentReturnedInterest+"</td>";
			      html+="<td>"+data[0].overduePrincipalAndInte+"</td>";
			      html+="<td>"+parseInt(parseFloat(data[0].amountOfRepayRecei)+parseFloat(data[0].overduePrincipalAndInte))+"</td>";
			       html+="<td>"+data[0].repaymentDeadline.replace("-","/").replace("-","/")+"</td>";
		          html+="</tr>";
			      html+="</table>";
		          html+="<div style='margin-top:20px;text-align: right'>打印日期："+new Date().toLocaleDateString()+"</div>";
                  $("#show").html(html);
           },error:function(){
             $("#return_id").val("");
              alert("ajax访问错误！");
                   $("#td1").html("");
	               $("#td2").html("");
	               $("#td3").html("");
	               $("#td4").html("");
	               $("#td5").html("");
	               $("#td6").html("");
	               $("#td7").html("");
	               $("#td8").html("");
	               $("#td9").html("");
	               $("#show").html("");
           }
        })
      } 
  })
  
  $("form").submit(function(){
     if($("#return_id").val()==""){
        alert("未检索到还款信息！");
        return false;
     }
  })
</script>
