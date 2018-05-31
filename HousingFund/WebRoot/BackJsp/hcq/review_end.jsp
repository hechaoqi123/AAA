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
    
    <title>借款终审</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <style>
     *{
       font-family: '楷体';
     }
       td{
         width:200px;
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
       #tab td,th{
         width:180px;
         height:30px;
       }
       .td{
         font-family: '楷体';
       }
       input[type=text]{
         border:0px;
       }
       
     </style>
  </head>
  
  <body>
     <form action="loan_final.action" method="post">
       <input name="loanFinalId" value="${loan.loanApplicationId}" style="display:none" />
     <table border="1">
         <tr>
           <td colspan="4"><h3>借款申请信息核对</h3></td>
         </tr>
          <tr>
           <td>借款人姓名 </td>
           <td>${loan.nameOfBorrower}</td>
           <td>身份证号 </td>
           <td>${loan.borrowerIdnumber}</td>
          </tr>
         
          <tr>
           <td>所在单位名称 </td>
           <td>${loan.borrowersUnit}</td>
           <td>联系电话 </td>
           <td>${loan.borrowerPhone}</td>
          </tr>
         
           <tr>
           <td>个人公积金账户 </td>
           <td>${loan.indAccount}</td>
           <td>借款金额（万元） </td>
           <td>${loan.borrowingBalance}</td>
          </tr>
         
          <tr>
           <td>借款时长（月） </td>
           <td>${loan.lentYearsNumber}</td>
           <td>年利率（%） </td>
           <td>${loan.annualRate}</td>
          </tr>
         
          <tr>
           <td>个人月收入（元） </td>
           <td>${loan.borrowerMonthMoney}</td>
           <td>还款方式 </td>
           <td>${loan.unitAddress}</td>
          </tr>
         
           <tr>
            <td>所购房型</td>
            <td>${loan.useoffunds.useDescription}</td>
            <td>是否首套房 </td>
            <td>${loan.remarks}</td>
           </tr>
           <!-------购房合同----->
           <tr>
            <td border="1" colspan="4"><b>购房合同</b></td>
           </tr>
           <tr>
            <td>购房人姓名  </td>
            <td>${loan.purchasecontract.homeBuyersName}</td>
            <td>购房人身份证号 </td>
            <td>${loan.purchasecontract.homeBuyersPhone}</td>
          </tr>
           <tr>
            <td>售房人姓名  </td>
            <td>${loan.purchasecontract.salesPersonName}</td>
            <td>售房人收款账户 </td>
            <td>${loan.purchasecontract.salesPersonPhone}</td>
          </tr>
          <tr>
            <td>房屋类型： </td>
            <td>${loan.purchasecontract.purchasedhinfo.housingType}</td>
            <td>房屋位置：  </td>
            <td>${loan.purchasecontract.purchasedhinfo.housingPosition}</td>
          </tr>
         
          <tr>
            <td>占地面积（㎡） </td>
            <td>${loan.purchasecontract.purchasedhinfo.floorSpace}</td>
            <td>所售房价（万元）  </td>
            <td>${loan.purchasecontract.purchasedhinfo.sellingPrice}</td>
          </tr>
         
          <tr>
            <td>  已付金额（万元） </td>
            <td> ${loan.purchasecontract.treatycCntents}</td>
            <td colspan="2"></td>
          </tr>
          <!----- 借款担保 ------>
               <!-- 抵押物 -->
                  <c:if test="${!empty coll}">
			       <tr>
			         <td colspan="4"><b>担保(抵押)信息</b></td>
			       </tr>
			       <tr border="0">
			         <td  colspan="4">
			           <div style="width:800px;height:300px;">
	                       <table border="1" id="tab" style="margin-left:40px;margin-top:50px">
	                         <tr>
	                            <td colspan="4" style="height:40px;">抵押物及评估信息</td>
	                         </tr>
	                          <tr>
	                            <td>抵押房屋类型</td>
	                            <td>${coll.pawnType}</td>
	                            <td>房屋占地面积</td>
	                            <td>${coll.pawnName}</td>
	                         </tr>
	                         <tr>
	                            <td>抵押物所处位置</td>
	                            <td>${coll.pawnAddress}</td>
	                            <td>所属人</td>
	                            <td>${coll.proof.person}</td>
	                         </tr>
	                         <tr>
	                            <td>权属证明开具单位</td>
	                            <td>${coll.proof.issuedName}</td>
	                            <td>权属证明开具时间</td>
	                            <td><fmt:formatDate value="${coll.proof.issuesDate}" pattern="yyyy-MM-dd"/></td>
	                         </tr>
	                          <tr>
	                            <td colspan="4">抵押物价值评估(万元)：${coll.pawnValueEsti}</td>
	                         </tr>
	                     </table>
			           </div>
			        </td>
			      </tr>
                  </c:if>
                 <!-- 担保人 -->
                  <c:if test="${!empty guar}">
			       <tr>
			           <td colspan="4"><b>担保(抵押)信息</b></td>
			       </tr>
			       <tr border="0">
			           <td  colspan="4">
			            <div style="width:800px;height:260px;">
			             <table border="1" id="tab" style="margin-left:40px;margin-top:50px">
	                         <tr>
	                            <td colspan="4" style="height:40px;">担保人及评估信息</td>
	                         </tr>
	                          <tr>
	                            <td>担保人姓名</td>
	                            <td>${guar.guarantorName }</td>
	                            <td>担保人身份证号</td>
	                            <td>${guar.guarantorIdno }</td>
	                         </tr>
	                         <tr>
	                            <td>担保人居住地址</td>
	                            <td>${guar.guarantorAddress}</td>
	                            <td>担保人所在单位</td>
	                            <td>${guar.guarantorUtin}</td>
	                         </tr>
	                         <tr>
	                            <td>担保人月收入(元)</td>
	                            <td>${guar.guarantorPhone}</td>
	                            <td>担保人价值评估（万元）</td>
	                            <td><fmt:formatNumber value="${guar.guarantorinfoestimate.guarantorFundAssess}" pattern="#"/></td>
	                         </tr>
	                     </table>
			           </div>
			           </td>
			      </tr>
                  </c:if>
                 <%--  <c:if test="${empty coll && empty guar}">
                  </c:if> --%>
          <!-- 共同借款人 -->
      <c:if test="${!empty loan.coborrower}">
             <tr>
             <td colspan="4" ><b>共同借款人</b></td>
           </tr>
          <table  id="cobTab" style="border-top:0px" border="1">
           <tr>
            <td style="border-top:0px;">共同借款人姓名：</td>
            <td style="border-top:0px;">${loan.coborrower.coborrowerName}</td>
            <td style="border-top:0px;">共同借款人手机号 </td>
            <td style="border-top:0px;">${loan.coborrower.coborrowerPhone}</td>
          </tr>
           <tr>
            <td>身份证号：</td>
            <td>${loan.coborrower.coborrowerIdno}</td>
            <td>所在单位 ：</td>
            <td>${loan.coborrower.coborrowerUtinName}</td>
          </tr>
           <tr>
            <td>公积金账户：</td>
            <td>${loan.coborrower.coborrowerAccount}</td>
            <td>与借款人关系 </td>
            <td>${loan.coborrower.relation}</td>
          </tr>
          </table>
            </c:if>
      </table><br/>
       <input type="submit" value="确认通过"/>
      </form>
         <form action="first_audit_end.action" method="post">
         <input name="status" value="审批驳回" style="display:none" />
         <input name="loanApplicationId" value="${loan.loanApplicationId}" style="display:none" />
          <input type="submit"  value="审批驳回"/>驳回原因：<textarea required="true" name="remarks"></textarea>
          </form>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
</script>
