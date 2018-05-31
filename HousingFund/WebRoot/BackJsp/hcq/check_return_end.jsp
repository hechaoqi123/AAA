<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提前还款详情页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <style>
       td,th{
         font-family:'楷体';
         width:180px;
         height:40px;
         line-height:40px;
         text-align:center;
       }
       select{
         width:160px;
         height:30px;
         font-size:17px;
         text-align:center;
         line-height:30px;
         border:0px;
         font-family:'楷体';
       }
       table{
       border-collapse: collapse;
       }
       input[type=text]{
         border:0px;
         width:160px;
         font-size:15px;
         text-align:center
       }
       #cobTab td{
         border:0px;
       }
         ol li{
         color:#999;
         font-family: '楷体';
         font-size: 20;
       }
     </style>
  </head>
  
  <body>
     <h2>提前还款详情页：</h2>
      <form action="submit_check_return.action" method="post">
      <input name="id" value="${before.id}"/>
      <ol>
        <li>办理提前还款须携带:贷款合同、最后一期的银行还款回单、本人身份证。</li>
        <li>申请人当前并没有处于逾期还款的状态中；</li>
        <li>公积金贷款提前还款需要满足申请人还款时间已经满一年的条件，提前还款只收取部分利息<br/>（提前还款利息=提前还款本金*（已用时长/12）*年利率）</li>
      </ol>
      <br/>
       <br/><br/>
       <!-- 住房公积金申请书  -->
      <table border="1px solid #999" id="tab">
         <tr>
           <td colspan="6"><h3>提前还款审核表</h3></td>
         </tr>
          <tr>
           <td>借款人姓名 </td>
           <td><input type="text" value="${before.borrowmoneyagreement.borrowerName }" readonly="readonly" id="td1" required="true"/></td>
           <td>借款人账户 </td>
           <td><input type="text" id="td2" value="${before.borrowmoneyagreement.repaymentAccount}" readonly="readonly"  required="true"/></td>
           <td>借贷合同编号 </td>
           <td><input type="text" readonly="readonly" value="${before.borrowmoneyagreement.borrowMoneyAgreementId}" name="borrowmoneyagreement.borrowMoneyAgreementId" id="td3" required="true"/></td>
          </tr>
         
          <tr>
           <td>放款银行 </td>
           <td><input type="text" readonly="readonly" value="中国银行" id="td4" required="true"/></td>
           <td>合同签订日期 </td>
           <td><input type="text" readonly="readonly" value="${before.borrowmoneyagreement.borrowerPhone}" id="td5" required="true"/></td>
           <td>签订人 </td>
           <td><input type="text" readonly="readonly" value="${before.borrowmoneyagreement.borrowerName }" id="td6" required="true"/></td>
          </tr>
         
           <tr>
           <td>借款金额 </td>
           <td><input type="text" readonly="readonly" value="${before.borrowmoneyagreement.borrowMoneyNumber}"  id="td7" required="true"/></td>
           <td>已还本金 </td>
           <td><input type="text" readonly="readonly"  id="td8" value="${before.returnMoney}" required="true"/></td>
           <td>未还本金 </td>
           <td><input type="text" readonly="readonly"  id="td9" value="${before.afterMoney}" required="true"/></td>
          </tr>
          <tr>
           <td>年利率（%） </td>
           <td><input type="text" readonly="readonly"  id="td10" value="${before.borrowmoneyagreement.borrowerAnnualRate}" required="true"/></td>
           <td>提前还款方式</td>
           <td>${before.returnType}</td>
           <td>银行储蓄账户:</td>
           <td><input required="true" value="${before.indLoan}" type="text"/></td>
          </tr>
          <tr>
            <td>联系方式:</td>
            <td colspan="2">${before.iphone}</td>
            <td>是否通过？<span style="color:red">*</span></td>
            <td colspan="2">
                   <input required="true" checked="true" name="status" value="已通过" type="radio"/>是
                   <input required="true" name="status" value="已驳回" type="radio"/>否
            </td>
          </tr>
          <tr>
            <th colspan="6" style="height:50px;">
                  历史还款记录
            </th>
          </tr>
          <tr>
            <th colspan="6">
               <div style="height:410px;overflow: auto">
                   <table>
	                 <tr>
		              <th>当前期数</th>
		              <th>当期应还本金</th>
		              <th>当期应还利息</th>
		              <th>逾期罚息</th>
		              <th>应还金额</th>
		              <th>还款状态</th>
		              <th>实收金额</th>
		              <th>还款日期</th>
	                 </tr>  
                  <c:forEach items="${list}" var="item">
                     <tr></tr>
                     <td>第${item.currentPeriod}期</td>
	                 <td>${item.currentReturnedCorpus}</td>
	                 <td>${item.currentReturnedInterest}</td>
	                 <td>${item.overduePrincipalAndInte}</td>
	                 <td>${item.amountOfRepayRecei}</td>
	                 <td>${item.repaymentStatus}</td>
	                 <td>${item.repaymentsReceived}</td>
	                 <td><fmt:formatDate value="${item.repaymentDate}" pattern="yyyy/MM/dd"/></td>
                   </c:forEach>
                  </table>
               </div>
            </th>
          </tr>
           <tr id="tr">
          </tr>
      </table>
      <br/>
          <input type="submit" value="提交申请"/>
      </form>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
     var html="";
         html+="<td>驳回原因:<span style='color:red'>*</span></td>";
         html+="<td><textarea name='remark' required='true' />";
         html+="</td>";
   $("input[name='status']").click(function(){
       if($(this).val()=="已通过"){
          $("#tr").html("");
       }else{
           $("#tr").html(html);
       }
     })
</script>
