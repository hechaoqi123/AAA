<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'usershow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
	body{
	MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;

	}
	
	a{
	text-decoration:none;
	}
	 *{
  margin:0;
  padding:0;

 }
	li{
	list-style-type: none;
	}
	  #topmenu ul{
	   border:0px solid green;
	   width:1250px;
	   height:46px;
	   margin-left: 30px;
	  }
	  #topmenuul li:HOVER{
	  background-color:#016ec5;
	  }
	  #topmenu ul li{
	  border:0px solid black;
	  font-family:微软雅黑;
	  font-size:18px;
	  width:160px;
	  height:46px;
	  float: left;
	  color: white;
	  text-align:center;
	  line-height: 48px;
	  }
	  

	  #lunboleft{
	   border:0px solid #fff;
	  }
	  #shang{
	  width:310px;
	  height:65px;
	    border:1px solid #fff;
	    margin-top: 15px;
	  margin-left: 25px;
	  font-size: 18px;
	  line-height:125px;
	  text-align: center;
	  background:url(images/hu1.png) no-repeat;
	  }
	  	  #xia{
	  width:310px;
	  height:65px;
	     border:1px solid #fff;
	    margin-top: 15px;
	  margin-left: 25px;
	  font-size: 18px;
	  line-height:125px;
	  text-align: center;
	  
	  background:url(images/hu2.png) no-repeat;
	  }
	 
	 
	   #last ul li{
	   width:130px;

	   height:96px;
	   float: left;
	   } #last ul li img{
	 
	position: relative;
	top:20px;
	
	   }
#zong{
height:780px;
border:1px solid #000;
}
#tou{
height:200px;
border:1px solid #000;
}
#zhong{
height:376px;
background:url(images/hu3.jpg) no-repeat;
width:1190px;
margin-left:30px;
margin-top:30px;

}
#wei{
height:200px;
border:1px solid #000;
}
</style>
  </head>
  
  <body>
  
    <div style="width: 100%;height: 785px;border: 0px solid red;">

<!-- 头部图片 -->
<div style="width:100%;height:135px;">
  <img alt="" src="images/2017112115540812702.jpg" style="height:135px;width:100%">
</div>
<!-- 头部菜单 -->
<div style="width: 100%;height:48px;background-color:#318cd4;margin-top:0px;" id="topmenu">
  <ul id="topmenuul">
   <a href="#"><li style="background-color: #016ec5">首页</li></a>
    <a href="#"><li>政务信息</li></a>
    <a href="#"><li>办事指南</li></a>
    <a href="#"><li>党建园地</li></a>
    <a href="#"><li>政策法规</li></a>
    <a href="#"><li>政民互动</li></a>
    <li style=" width:250px;"><form>
    <input style="height: 30px;">
    <input type="submit" value="搜索" style="height:30px;width: 50px;">
    </form></li>
  </ul>
</div>
  
  <div id="zhong">
 <div id="lunboleft" style="width:565px;height:250px;border:0px solid #000;margin-left:570px;padding-top:60px;">
  <%
    String ss=request.getParameter("bo");
  %>
 
  <input type="hidden" value="<%=ss%>" id="login">
      <table border="1" style="margin-top:5px;border-collapse:collapse;">
      <h4 style="margin-top:30px;">我的贷款</h4>
         <tr>
            <td>借款编号</td>
            <td>借款人姓名</td>
            <td>个人公积金账户</td>
            <td>贷款状态</td>
            <td>贷款金额</td>
            <td>所贷年限</td>
             <td>贷款类型</td>
              <td>借款年利率</td>
         </tr>
         <tbody id="myTab"></tbody>
               
         
     </table>
     
       <button onclick="huankuanquery()">还款明细查询</button>
       <table border="1"style="border-collapse:collapse;">
<!--      <tr>
       
            <td>还款详情编号</td>
            <td>还款方式</td>
            <td>担保人姓名</td>
            <td>当期应还本金</td>
             <td>当期应还利息</td>
              <td>逾期本息</td>
              <td>当前期数</td>
               <td>本期还款日期</td>
   </tr> -->
      <tbody id="myTabs"></tbody>
      </table>
     </div>
     <!-- 尾部 -->
<div style="border:0px solid black; width:100%;height:220px;margin-top:40px">

   <div style="border:0px solid black;width:100%;height:220px;background-color:#016EC5;">
    
    
     <div style="border:0px solid black;width:800px;height:200px;margin-left:220px;margin-top:0px;">
       <div style="border:0px solid black;width:800px;height:100px;color:white;font-size:10px;text-align: center;line-height: 100px; ">
       版权所有：**住房公积金管理中心 京公网安备10086 京ICP备1383838号 客服电话：10010
       </div>
       
       <div style="border:0px solid black;width:800px;height:100px;" id="last">
         <ul style="border:0px solid black;width:400px;height:100px;margin-left:200px;">
           <li><a href="#"><img alt="" src="images/blue.png" style="top:10px;left:30px;"></a> </li>
           <li><a href="#"><img alt="" src="images/jiucuo.png-v=-+sitecode+-.png"></a> </li>
           <li><a href="#"><img alt="" src="images/2018042315070456187.png"></a> </li>
         </ul>
       </div>
     </div>
     
   </div>
</div>
</div>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
$(function(){
   querylist();
   //huankuanquery();
})
var aaa;
    function querylist(){
      var zhi=$("#login").val();
          $.ajax({
             url:"query5.action",
             type:"get",
             data:{"BorrowerIdnumber":zhi},
             dataType:"json",
             success:function(data){
           		var aaa=data;
             //每次记载之前先清空当前页面的数据
                 $("#myTab").html('');
                var tr="<tr>";
                   tr+="<td>"+aaa.loanApplicationId+"</td>";
                   tr+="<td>"+aaa.nameOfBorrower+"</td>";
                   tr+="<td>"+aaa.indAccount+"</td>";
                   tr+="<td>"+aaa.remarks+"</td>";
                   tr+="<td>"+aaa.borrowingBalance+"</td>";
                   tr+="<td>"+aaa.lentYearsNumber+"</td>";
                    tr+="<td>"+"公积金贷款"+"</td>";
                   tr+="<td>"+aaa.annualRate+"%"+"</td>";
            
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
                   
                 
             }
          })
          }
           function huankuanquery(){
      var zhi=$("#login").val();

          $.ajax({
             url:"query6.action",
             type:"get",
             data:{"BorrowerIdno":zhi},
             dataType:"json",
             success:function(data){
         
             //每次记载之前先清空当前页面的数据
                 $("#myTabs").html('');
                var tr="<tr>";
                    var tr="<tr>";
                
       
           tr+="<td>"+'还款详情编号'+"</td>";
           tr+="<td>"+'还款方式'+"</td>";
             tr+="<td>"+'担保人姓名'+"</td>";
            tr+="<td>"+'当期应还本金'+"</td>";
              tr+="<td>"+'当期应还利息'+"</td>";
             tr+="<td>"+'逾期本息'+"</td>";
           tr+="<td>"+'当前期数'+"</td>";
              tr+="<td>"+'本期还款日期'+"</td>";
 
        tr+="</tr>"; 
                   tr+="<td>"+data[0].repaymentPlanDetailsiId+"</td>";
                   tr+="<td>"+data[0].repaymentMode+"</td>";
                   tr+="<td>"+data[0].guarantorInfo+"</td>";
                   tr+="<td>"+data[0].currentReturnedCorpus+"</td>";
                   tr+="<td>"+data[0].currentReturnedInterest+"</td>";
                   tr+="<td>"+data[0].overduePrincipalAndInte+"</td>";
                   tr+="<td>"+data[0].currentPeriod+"</td>";
                   tr+="<td>"+data[0].repaymentDate+"</td>";
                     tr+="</tr>"; 
                   $("#myTabs").append(tr);
                   
               }   
             
          })
  
   }
</script>