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
    
    <title>借款担保价值评估详情</title>
    
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
         width:140px;height:20px;
       }
        #tab2 td,th{
         width:140px;height:20px;
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
      <form action="cost_fixation.action" method="post">
       <!-- 住房公积金担保评估 -->
      <table border="1">
         <tr>
           <td colspan="4" style="height:60px"><b style="font-family: '黑体'">住房公积金担保信息评估</b></td>
         </tr>
          <tr>
           <td class="td">借款人姓名</td>
           
           <td>${loan.nameOfBorrower}</td>
           <td class="td">身份证号</td>
           <td>${loan.borrowerIdnumber}</td>
          </tr>
         
          <tr>
           <td class="td">所在单位名称</td>
           <td>${loan.borrowersUnit}</td>
           <td class="td">联系电话</td>
           <td>${loan.borrowerPhone}</td>
          </tr>
           
          <tr>
           <td class="td">借款时长（月）</td>
           <td><input name="loanPeriod"  style="font-size: 17;text-align: center" readonly="true" type="text" value="${loan.lentYearsNumber}"/></td>
           <td class="td">年利率（%）</td>
           <td><input name="loanRate" style="font-size: 17;text-align: center"  readonly="true" type="text" value="${loan.annualRate}"/></td>
          </tr>
          
           <tr>
           <td class="td">个人公积金账户</td>
           <td >${loan.indAccount}</td>
           <td class="td">贷款金额(万元)</td>
           <td><input name="loanDisbur" readonly="true" style="font-size: 17;text-align: center" type="text" value="<fmt:formatNumber value="${loan.borrowingBalance}" pattern="#"/>"/></td>
          </tr>
          <tr>
            <td class="td">担保方式</td>
            <td  id="way">${loan.guaranteemode.securityModeDes}</td>
            <td colspan="2"></td>
          </tr>
           <tr>
            <td  class="td" colspan="4">
               <center>相关材料证明</center>
               <div id="di" style="width:900px;padding-left:60px;height:300px;border-top:1px solid #999">

               </div>
            </td>
           </tr>
         
          <tr id="aa">
            <td colspan="4"  class="td" style="height:70px">抵押物(担保人)价值评定(万元)<span style="color:red">*</span>
             <input id="money" required="true" style="font-size: 16"/><br/>
            </td>
          </tr>
      </table>
      <br/>
       <input name="loan.loanApplicationId" value="${loan.loanApplicationId}" style="display:none" />
      <input type="submit" style="padding:5px 10px" value="提交"/>
      </form>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
        $(function(){
          if($("#way").html()=="拟购房抵押"){
            var html="";
              html+="<table border='1'  style='margin-top:30px;'>";
              html+=" <tr>";
              html+="  <td border='1' colspan='4'><b>购房合同</b></td>";
              html+=" </tr>";
              html+=" <tr>";
              html+="  <td>购房人姓名 </td>";
              html+="  <td>${loan.purchasecontract.homeBuyersName}</td>";
              html+="  <td>购房人身份证号</td>";
              html+="  <td>${loan.purchasecontract.homeBuyersPhone}</td>";
              html+=" </tr>";
              html+=" <tr>";
              html+="  <td>售房人姓名 </td>";
              html+="  <td>${loan.purchasecontract.salesPersonName}</td>";
              html+="  <td>售房人收款账户</td>";
              html+="  <td>${loan.purchasecontract.salesPersonPhone}</td>";
              html+=" </tr>";
              html+=" <tr>";
              html+="  <td>房屋类型：</td>";
              html+="  <td>${loan.purchasecontract.purchasedhinfo.housingType}</td>";
              html+="  <td>房屋位置： </td>";
              html+="  <td>${loan.purchasecontract.purchasedhinfo.housingPosition}</td>";
              html+=" </tr>";
              html+=" <tr>";
              html+="  <td>占地面积（㎡）</td>";
              html+="  <td>${loan.purchasecontract.purchasedhinfo.floorSpace}</td>";
              html+="  <td>所售房价（万元） </td>";
              html+="  <td><fmt:formatNumber value='${loan.purchasecontract.purchasedhinfo.sellingPrice}' pattern='#'/></td>";
              html+=" </tr>";
              html+="</table>";
              $("#aa").remove();
            $("#di").html(html);
          }
          if($("#way").html()=="其他房产抵押"){
                var html="";
                html+="<table border='1'  style='margin-top:50px;'>";
                html+=" <tr>";
                html+="  <td border='1' colspan='4'><b>房屋信息及权属证明</b></td>";
                html+=" </tr>";
                html+=" <tr>";
                html+="  <td>抵押房屋类型 </td>";
                html+="  <td><input name='coll.collateralvalueestimate.pawnType'  style='font-size: 17;text-align: center' readonly='true' type='text' value='${coll.pawnType}'/></td>";
                html+="  <td>抵押房屋大小</td>";
                html+="  <td><input style='font-size: 17;text-align: center' readonly='true' type='text' value='${coll.pawnName}'/></td>";
                html+=" </tr>";
                html+=" <tr>";
                html+="  <td>抵押房屋位置</td>";
                html+="  <td><input name='coll.collateralvalueestimate.pawnAddress'  style='font-size: 17;text-align: center' readonly='true' type='text' value='${coll.proof.address}'/></td>";
                html+="  <td>房屋所属人</td>";
                html+="  <td><input name='coll.collateralvalueestimate.pawnOwner'  style='font-size: 17;text-align: center' readonly='true' type='text' value='${coll.proof.person}'/></td>";
                html+=" </tr>";
                html+=" <tr>";
                html+="  <td>证明开具单位：</td>";
                html+="  <td><input  style='font-size: 17;text-align: center' readonly='true' type='text' value='${coll.proof.issuedName}'/></td>";
                html+="  <td>证明开具时间：</td>";
                html+="  <td><input   style='font-size: 17;text-align: center' readonly='true' type='text' value='<fmt:formatDate value='${coll.proof.issuesDate}' pattern='yyyy-MM-dd'/>'/></td>";
                html+=" </tr>";
                html+="</table> ";
                html+="<input name='coll.collateralInfoId' type='text' value='${coll.collateralInfoId}' style='display:none'/>"
                $("#money").prop("name","coll.pawnValueEsti")
               $("#di").html(html);
          }
          if($("#way").html()=="担保人担保"){
               var html="";
                    html+="";
                html+="<table border='1' style='margin-top:50px;'>";
                html+="<tr>";
                html+="<td border='1' colspan='4'><b>担保人信息</b></td>";
                html+="</tr>";
                html+="<tr>";
                html+="<td>担保人姓名 </td>";
                html+="<td><input style='font-size: 17;text-align: center' readonly='true' type='text' value='${guar.guarantorName}'/></td>";
                html+="<td>担保人身份证号</td>";
                html+="<td><input style='font-size: 17;text-align: center' readonly='true' type='text' value='${guar.guarantorIdno}'/></td>";
                html+="</tr>";
                html+="<tr>";
                html+="<td>担保人居住地址</td>";
                html+="<td><input  style='font-size: 17;text-align: center' readonly='true' type='text' value='${guar.guarantorAddress}'/></td>";
                html+="<td>担保人所在单位</td>";
                html+="<td><input name='guar.guarantorinfoestimate.guarantorUtin'  style='font-size: 17;text-align: center' readonly='true' type='text' value='${guar.guarantorUtin}'/></td>";
                html+="</tr>";
                html+="<tr>";
                html+="<td>担保人月收入</td>";
                html+="<td><input name='guar.guarantorinfoestimate.guarantorYearIncome'  style='font-size: 17;text-align: center' readonly='true' type='text' value='${guar.guarantorPhone}'/></td>";
                html+="<td colspan='2'>(担保人收入证明)</td>";
                html+="</tr>";
                html+="</table> ";
                 html+="<input name='guar.guarantorInfoId' type='text' value='${guar.guarantorInfoId}' style='display:none'/>"
                $("#money").prop("name","guar.guarantorinfoestimate.guarantorFundAssess")
               $("#di").html(html);
          }
        
        })
</script>
