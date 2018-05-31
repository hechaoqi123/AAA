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
    
    <title>贷款终审目录</title>
    
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
    <h2>贷款终审</h2>
      <ol>
        <li>最终核实借款信息,判定申请是否通过</li>
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
			          <th>担保方式</th>
			          <th>审核状态</th>
			          <th></th>
			        </tr>
	             <c:forEach items="${list}" var="item">
			        <tr>
			          <td>${item.loanApplicationId}</td>
			          <td>${item.nameOfBorrower}	</td>
			          <td>${item.guaranteemode.securityModeDes}</td>
			          <td>${item.status}</td>
			          <c:choose>
			               <c:when test="${item.guaranteemode.securityModeDes eq '拟购房抵押'}">
                    <td><a href="final_check.action?loan.loanApplicationId=${item.loanApplicationId}">审查</a></td>			               
			               </c:when>
			               <c:when test="${item.guaranteemode.securityModeDes eq '担保人担保'}">
                    <td><a href="final_check.action?loan.loanApplicationId=${item.loanApplicationId}&&guar.guarantorInfoId=1">审查</a></td>
                           </c:when>
			               <c:when test="${item.guaranteemode.securityModeDes eq '其他房产抵押'}">
                     <td><a href="final_check.action?loan.loanApplicationId=${item.loanApplicationId}&&coll.collateralInfoId=1">审查</a></td>
                           </c:when>
			          </c:choose>
			        </tr>
			     </c:forEach>
			   </table>
            </c:otherwise>
          </c:choose>
  </body>
</html>
