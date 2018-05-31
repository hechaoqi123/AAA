<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>贷款资格信息评审</title>
    
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
       }
    td,th{
         width:180px;
         height:40px;
         line-height:40px;
         text-align:center;
       }
       a{
         text-decoration:none;
       }
       a:hover{
         color:red
       }
       ol li{
         color:#999;
         font-family: '楷体';
         font-size: 20;
       }
   </style>
  </head>
  
  <body> 
    <h2>借款资格评估</h2>
      <ol>
        <li>连续缴纳住房公积金满6个月</li>
        <li>当前账户没有未还完的贷款记录</li>
        <li>单人贷款所贷金额不能超过个人公积金账户余额*20且最高不能超过50w  不能超过房价70%</li>
        <li>夫妻共同贷款所贷金额不能超过双方公积金余额总和*20且最高不能超过70w  不能超过房价70%</li>
      </ol>
          <c:choose>
            <c:when test="${empty list}"><br/>
               <div style="color:#5ea6eb;padding-left:300px;;height:300px;font-size:30px;">当前没有借款申请</div>
            </c:when>
            <c:otherwise>
                <table border="1">
			        <tr>
			          <th>借款申请书编号</th>
			          <th>借款人姓名</th>
			          <th>借款金额(万元)</th>
			          <th>所借期限(月)</th>
			          <th>年利率(%)</th>
			          <th></th>
			        </tr>
	             <c:forEach items="${list}" var="item">
			        <tr>
			          <td>${item.loanApplicationId}</td>
			          <td>${item.nameOfBorrower}	</td>
			          <td>${item.borrowingBalance}</td>
			          <td>${item.lentYearsNumber}</td>
			          <td>${item.annualRate}</td>
			          <td><a href="firs_tiral.action?loanApplicationId=${item.loanApplicationId}">点击评估</a></td>
			        </tr>
			     </c:forEach>
			   </table>
            </c:otherwise>
          </c:choose>
  </body>
</html>
