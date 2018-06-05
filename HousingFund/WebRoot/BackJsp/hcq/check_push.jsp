<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人冲还贷信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <style>
      
       th,td{
         font-family:'楷体';
         width:180px;
         height:40px;
         line-height:40px;
         text-align:center;
       }
      </style>
  </head>
  
  <body>
  
        <h2>个人冲还贷信息</h2>
        <table>
          <tr>
             <td>冲还贷业务编号：</td>
             <td style="width:150px;">${push.id}</td>
             <td>借款人：</td>
             <td style="width:150px;">${push.borrowmoneyagreement.borrowerName}</td>
             <td>年利率：</td>
             <td style="width:150px;">${push.borrowmoneyagreement.borrowerAnnualRate}</td>
             <td>还款方式：</td>
             <td style="width:150px;">${push.borrowmoneyagreement.repaymentMode}</td>
          </tr>
          <tr>
             <td style="text-align:left;"><span style="margin-left:20px;">预留手机号：</span></td>
             <td>${push.iphone}</td>
             <td>银行卡号：</td>
             <td>${push.number}</td>
             <td>业务状态：</td>
               <c:if test="${push.status eq '冻结'}">
                  <td ><b style="color:red">${push.status}</b></td>
               </c:if>
               <c:if test="${push.status eq '正常'}">
                  <td ><b style="color:#5ea6eb">${push.status}</b></td>
               </c:if>
               <td colspan="2"></td>
          </tr>
        </table>
      <table border="1" bordercolor="#999" style="border-collapse: collapse;">
        <tr>
          <td>日志记录编号</td>
          <td>此期本金</td>
          <td>此期利息</td>
          <td>逾期罚息</td>
          <td>总金额</td>
          <td>冲贷日期</td>
          <td>冲贷状态</td>
          <td>备注</td>
        </tr>
        <tr>
           <td colspan="11">
             <div style="height:400px;">
                <table >
                  <c:forEach items="${list}" var="item">
                       <tr>
			          <td>${item.id }</td>
			             <c:if test="${empty item.repaymentplandetails}">
			               <td>无</td><td>无</td><td>无</td><td>无</td>
			             </c:if>
			             <c:if test="${!empty item.repaymentplandetails}">
			               <td>${item.repaymentplandetails.currentReturnedCorpus}</td>
				           <td>${item.repaymentplandetails.currentReturnedInterest}</td>
				           <td>${item.repaymentplandetails.overduePrincipalAndInte}</td>
				           <td>${item.money}</td>
			             </c:if>
			          <td>${item.riqi}</td>
			            <c:if test="${item.status eq '失败'}">
			                <td style="color:red;"><b>${item.status}</b></td>
			            </c:if>
			             <c:if test="${item.status eq '成功'}">
			                <td style="color:#5ea6eb;"><b>${item.status}</b></td>
			            </c:if>
			          <td>${item.remark}</td>
			        </tr>
                  </c:forEach>
                </table>
             </div>
           </td>
        </tr>
      </table>
        <div style="margin-left:480px;margin-top:20px;">
         <c:if test="${push.status eq '冻结'}">
            <form id="ok" action="renew.action" method="post">
             <input name="id" value="${push.id}" style="display:none"/>
             <input type="button" id="ok_click" value="激活" style="padding:10px 20px;"/>
            </form>
         </c:if>
         <c:if test="${push.status eq '正常'}">
              <form id="stop" action="logout.action" method="post">
                <input name="id" value="${push.id}" style="display:none"/>
                <input type="button" id="stop_click" value="冻结" style="padding:10px 20px;"/>
              </form>
         </c:if>
         <form action="removePush.action"id="remove" method="post">
             <input name="id" value="${push.id}" style="display:none"/>
             <input type="button" id="remove_click" value="注销" style="padding:10px 20px;margin-top:-58px;margin-left:200px;"/>
         </form>
         </div>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
  $("#stop_click").click(function(){
      if( confirm("确认冻结？")){
         $("#stop").submit();
      }  
  })
    $("#ok_click").click(function(){
      if( confirm("确认激活？")){
        $("#ok").submit();
      }  
  })
    $("#remove_click").click(function(){
      if( confirm("确认注销（无法恢复）？")){
        $("#remove").submit();
      }  
  })
</script>

