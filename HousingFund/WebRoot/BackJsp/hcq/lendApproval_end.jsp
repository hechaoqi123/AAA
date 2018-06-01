<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>贷款资格信息评估详情页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <style>
       td{
         width:220px;
         height:40px;
         line-height:40px;
         text-align:center;
       }
       table{
       border-collapse: collapse;
       }
       .test{
           background:#F0F8FF;
       }
       .show{
         width:440px;
         height:220px;
         border-top:1px solid #999;
       }
       #tab td,th{
         width:140px;height:20px;
       }
        #tab2 td,th{
         width:150px;height:20px;
       }
       *{
         font-family: '楷体';
       }
     </style>
  </head>
  
  <body>
      <form action="first_audit_end.action" method="post">
       <!-- 住房公积金借款资格评估 -->
      <table border="1">
         <tr>
           <td colspan="4">住房公积金借款资格评估</td>
         </tr>
          <tr>
           <td class="td">借款人姓名</td>
           
           <td>${book.nameOfBorrower}</td>
           <td class="td">身份证号</td>
           <td>${book.borrowerIdnumber}</td>
          </tr>
         
          <tr>
           <td class="td">所在单位名称</td>
           <td>${book.borrowersUnit}</td>
           <td class="td">联系电话</td>
           <td>${book.borrowerPhone}</td>
          </tr>
           
          <tr>
           <td class="td">借款时长（月）<span style="color:red">*</span></td>
           <td>${book.lentYearsNumber}</td>
           <td class="td">年利率（%）<span style="color:red">*</span></td>
           <td>${book.annualRate}</td>
          </tr>
          
           <tr>
           <td class="td">个人公积金账户<span style="color:red">*</span></td>
           <td >${book.indAccount}</td>
           <td class="td">可贷金额(万元)<span style="color:red">*</span></td>
           <td id="limit">${maxMonry}</td>
          </tr>
            <tr>
              <td colspan="2">
               <center class="td">个人账户近期缴存记录</center>
                 <table style="border-top:1px solid #999">
                         <tr>
                          <th class="td">缴存记录编号</th>
                          <th class="td">缴存总金额</th>
                          <th class="td">缴存时间</th>
                         </tr>
                  </table>
                 <div class="show" style="overflow: auto;">
                 <table id="tab">
                       <c:forEach items="${rems}" var="rem">
                          <tr>
                            <td>${rem.depositInfoId}</td>
                            <td>${rem.payinSumMoney}</td>
                            <td><fmt:formatDate value="${rem.payinDate}" pattern="yyyy-MM-dd"/></td>
                          </tr>
                       </c:forEach>
                     </table>
                 </div>
              </td>
               <td colspan="2" >
               <center class="td" >个人账户历史借贷记录</center>
                  <table  style="border-top:1px solid #999;font-family: '楷体'">
                     <tr>
                        <th style="width:100px;padding-left:15px;">借款账户</th>
                        <th>借款人</th>
                        <th>借款时间</th>
                        <th>借款状态</th>
                       </tr>
                   </table>
                 <div class="show" style="font-size:15px;font-family:'楷体';overflow: auto;">
                    <table>
                      <c:forEach items="${loanMarks}" var="loan">
                          <tr>
                           <td style="width:130px">${loan.loanAccount}</td>
                           <td>${loan.lender}</td>
                           <td> 
                           <fmt:formatDate value="${loan.loanDate}" pattern="yyyy-MM-dd"/>
                           </td>
                           <td>${loan.loanStatus}</td>
                          </tr>
                      </c:forEach>
                   </table>
                 </div>
              </td>
            </tr>
          <tr>
            <td  class="td">是否首套房<span style="color:red">*</span></td>
            <td>${book.remarks}</td>
            <td  class="td">所购房屋占地面积（㎡）<span style="color:red">*</span></td>
            <td>${book.purchasecontract.purchasedhinfo.floorSpace}</td>
          </tr>
         
         
         
          <tr>
            <td  class="td">所购房屋价格（万元）<span style="color:red">*</span> </td>
            <td>${book.purchasecontract.purchasedhinfo.sellingPrice}</td>
            <td  class="td">借款金额（万元）<span style="color:red">*</span></td>
            <td  id="lendMoney"><b>${book.borrowingBalance}</b></td>
          </tr>
         
          <tr>
            <td  class="td">是否通过？<span style="color:red">*</span></td>
            <td  class="td">
              <input type="radio" value="待评估" required="true" id="success" name="status"/>审批通过<br/>
              <input type="radio" value="申请驳回" required="true" id="reject" name="status"/>审批驳回
            </td>
            <td colspan="2"  class="td">
                                驳回原因：<span id="rejectt" style="color:#fff">*</span><textarea id="cause" name="remarks" style="width:200px;height:100px;" rows="5" cols="20"></textarea>
            </td>
          </tr>
      </table>
      <br/>
      <input name="loanApplicationId" value="${book.loanApplicationId}" style="display: none;"/>
      <input type="submit" style="padding:5px 10px" value="提交"/>
      </form>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
     $("#reject").click(function(){
         if($(this).prop("checked")==true){
           $("#cause").prop("required",true);
           $("#rejectt").css("color","red")
         }
     })
      $("#success").click(function(){
            if($(this).prop("checked")==true){
           $("#cause").prop("required",false);
             $("#rejectt").css("color","#fff")
         }
     })
</script>
