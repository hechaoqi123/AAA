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
    
    <title>冲还贷日志</title>
    
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
       .check{
          width:20px;
          height:20px;
       }
       .success{
          display:none;
       }
       .loser{
          display:block;
       }
      </style>
  </head>
  
  <body>
         <h1 style="color:#999">${user.uname },欢迎回来！</h1> 
            <c:if test="${!empty list}">
               <h3 style="color:#999">冲贷业务冻结待通知项：</h3>
            </c:if>
              <c:if test="${empty list}">
               <center>
                 <h1 style="color:#5ea6eb;margin-top:200px;">当前没有待通知项</h1>
               </center>
            </c:if>
      <table border="0" bordercolor="#999" style="border-collapse: collapse;">
             <c:if test="${!empty list}">
		        <tr>
		          <td>借款人</td>
		          <td>总金额</td>
		          <td>冲贷日期</td>
		          <td>冲贷状态</td>
		          <td>预留手机号</td>
		          <td>备注</td>
		        </tr>
              </c:if>
        <tr>
           <td colspan="11">
             <div>
                <table  border="1" bordercolor="#999" style="border-collapse: collapse;">
                  <c:forEach items="${list}" var="item">
                      <c:if test="${item.status eq '成功'}">
			               <tr class="success">
			          </c:if>
                      <c:if test="${item.status eq '失败'}">
			               <tr class="loser">
			          </c:if>
			          <td>${item.fush.borrowmoneyagreement.borrowerName}</td>
			             <c:if test="${empty item.repaymentplandetails}">
			               <td>无</td><td>无</td><td>无</td><td>无</td>
			             </c:if>
			             <c:if test="${!empty item.repaymentplandetails}">
				           <td>${item.money}</td>
			             </c:if>
			          <td>${item.riqi}</td>
			            <c:if test="${item.status eq '失败'}">
			                <td style="color:red;"><b>${item.status}</b></td>
			            </c:if>
			             <c:if test="${item.status eq '成功'}">
			                <td style="color:#5ea6eb;"><b>${item.status}</b></td>
			            </c:if>
			          <td>${item.fush.iphone}</td>
			          <td>${item.remark}</td>
			        </tr>
                  </c:forEach>
                </table>
             </div>
           </td>
        </tr>
      </table>
  
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
      $(".check").click(
          function(){
	           if($(this).val()=="all"){
	              $(".loser").css("display","block")
	              $(".success").css("display","block")
	              
	           }
	           if($(this).val()=="loser"){
	              $(".success").css("display","none")
	              $(".loser").css("display","block")
	           }
	           if($(this).val()=="success"){
	             $(".success").css("display","block")
	             $(".loser").css("display","none")
	           }
	           
          }      
      )
      
</script>
