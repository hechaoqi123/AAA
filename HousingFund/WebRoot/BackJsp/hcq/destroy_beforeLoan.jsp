<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>冲贷信息管理</title>
    
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
       .tr:hover{
         background:#AEEEEE;
         cursor: pointer;
       }
       a{
         text-decoration: none;
       }
       a:hover{
         color:red;
       }
   </style>
  </head>
  
  <body>
     <h3>冲还贷信息管理</h3>
       <form action="getPart.action" method="post">
                 预留手机号：<input name="iphone" value="${iphone}"/> <input type="submit" value="查询"/>
       </form>
      <table border="1" bordercolor="#999" style="border-collapse: collapse;">
        <tr>
          <th style="width:100px;">业务编号</th>
          <th style="width:150px;">借贷合同编号</th>
          <th style="width:150px;">借款人姓名</th>
          <th>借款人身份证号</th>
          <th style="width:150px;">年利率(%)</th>
          <th>预留手机号</th>
          <th>划款银行卡号</th>
          <th>业务状态</th>
        </tr>
        <tr>
           <td colspan="11">
             <div style="height:490px;overflow:auto">
                <table >
                  <c:forEach items="${entity.list}" var="item">
                       <tr class="tr" ondblclick="find(${item.id})">
			           <td style="width:100px;">${item.id}</td>
	                   <td style="width:150px;">${item.borrowmoneyagreement.borrowMoneyAgreementId}</td>
		               <td style="width:150px;">${item.borrowmoneyagreement.borrowerName}</td>
			           <td>${item.borrowmoneyagreement.borrowerIdno}</td>
			           <td style="width:150px;">${item.borrowmoneyagreement.borrowerAnnualRate}</td>
			           <td>${item.iphone}</td>
		               <td>${item.number}</td>
			            <c:if test="${item.status eq '冻结'}">
			                <td style="color:red;"><b>${item.status}</b></td>
			            </c:if>
			             <c:if test="${item.status eq '正常'}">
			                <td style="color:#5ea6eb;"><b>${item.status}</b></td>
			            </c:if>
			        </tr>
                  </c:forEach>
                </table>
             </div>
           </td>
        </tr>
      </table>
       <div style="padding-left:450px;font-size: 20">
        第${entity.currentPage}页
        <a href="getPart.action?entity.currentPage=1" style="margin-left:20px;">首页</a>
           <c:if test="${entity.currentPage!=1}">
             <a  style="margin-left:20px;" href="getPart.action?entity.currentPage=${entity.currentPage-1}">上一页</a>
           </c:if>
            <c:if test="${entity.currentPage!=entity.totalPage}">
             <a style="margin-left:20px;" href="getPart.action?entity.currentPage=${entity.currentPage+1}">下一页</a>
           </c:if>
        <a style="margin-left:20px;margin-right:20px;"  href="getPart.action?entity.currentPage=${entity.totalPage}">尾页</a>
      共${entity.totalPage}页
        </div>
        <form action="check_push.action" style="display:none" id="push">
          <input name="id" id="id"/>
        </form>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
   function find(obj){
     $("#id").val(obj);
     $("#push").submit();
   }
</script>
