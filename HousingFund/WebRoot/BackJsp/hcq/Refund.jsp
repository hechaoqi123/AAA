<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>公积金贷款结清证明</title>
    
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
       font-family: '楷体';
       }
    td,th{
         width:130px;
         height:40px;
         line-height:40px;
         text-align:center;
       }
        ol li{
         color:#999;
         font-family: '楷体';
         font-size: 20;
       }
       #oo li{
       font-size: 16;
       margin:0px;
       padding:0px;
       text-align: left;
       }
       a{
         text-decoration: none;
         color: #000
       }
        a:hover{
          color:red
        }
        input{
          text-align:center;
        }
   </style>
</head>
  
  <body> 
    <h2>公积金结清证明</h2>
      请输入个人身份证号：<input type="text" id="id"/>   <button id="index">点击检索</button><br/><br/>
      <form action="sure_end.action" method="post">
      <input type="text" id="a" style="display:none" name="loanApplicationId" />
          <table border="1">
            <tr>
               <th colspan="8" style="font-size: 20px;height:60px">公积金贷款结清证明</th>
            </tr>
            <tr>
               <td>借款人</td>
               <td><input id="td1"  style="border: 0px" readonly="true"/></td>
               <td style="width:200px">借款金额（万元）</td>
               <td id="td5" ></td>
               <td>未还本金</td>
               <td id="money"></td>
               <td>未还利息</td>
               <td id="money2"></td>
            </tr>
             <tr>
               <td>公积金账户</td>
               <td><input id="td2" name="repaymentAccount" style="border: 0px" readonly="true"/></td>
               <td>年利率（%）</td>
               <td id="td4"></td>
               <td>借款期限（月）</td>
               <td id="td6"></td>
               <td>还款方式</td>
               <td id="td3"/>
            </tr>
            <tr>
               <th colspan="8">个人还款记录</th>
               
            </tr>
            <tr>
               <th colspan="8" style="height:500px;bapadding-left:30px;overflow: auto;">
                  <table id="tb">
                  </table>
               </th>
            </tr>
          </table>
          <input type="submit" value="确认结清（打印证明）"/>
      </form>
  </body>
</html>
 <script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
  var money=0;//未还剩余本金	
  var money2=0;//未还剩余利息
   var success=true;//判断借款是否还清
   var success2=false;//判断是否调用ajax
  $("#index").click(function(){
           var id=$("#id").val();
      if(id==""){
         alert("身份证号不能为空");
               $("#tb").html(""); 
               $("#td1").val("");
               $("#td2").val("");
               $("#td3").html("");
               $("#td4").html("");
               $("#td5").html("");
               $("#td6").html("");
      }else{
        $.ajax({
           url:'refund.action',
           type:'post',
           data:{'borrowerIdnumber':id},
           dataType:'json',
           success:function(data){
           if(data!=null){
            success=true;
            success2=true;
              var html="";
              html+="<tr>";
              html+="<th>当前期数</th>";
              html+="<th>当期应还本金</th>";
              html+="<th>当期应还利息</th>";
              html+="<th>逾期罚息</th>";
              html+="<th>应还金额</th>";
              html+="<th>还款状态</th>";
              html+="<th>实收金额</th>";
              html+="<th>还款日期</th>";
              html+="</tr>";  
				 for(var i=0;i<data.length-1;i++){
                 html+="<tr>";
                 html+="<td>第"+data[i].currentPeriod+"期</td>" ;
                 html+="<td>"+data[i].currentReturnedCorpus+"</td>" ;
                 html+="<td>"+data[i].currentReturnedInterest+"</td>" ;
                 html+="<td>"+data[i].overduePrincipalAndInte+"</td>" ;
                 html+="<td>"+data[i].amountOfRepayRecei+"</td>" ;
                    if(data[i].repaymentStatus=="已还"){
                     html+="<td style='color:#5ea6eb'>"+data[i].repaymentStatus+"</td>" ;
                    }else{
                     html+="<td  style='color:red'>"+data[i].repaymentStatus+"</td>" ;
                    }
                  if(data[i].repaymentsReceived==null){
                   html+="<td></td>" ;
                   html+="<td></td>" ;
                   success=false;//借款未还清
                   money+=parseInt(data[i].currentReturnedCorpus);//未还本金累加
                   money2+=parseInt(data[i].currentReturnedInterest);//未还利息累加
                  }else{
                   html+="<td>"+data[i].repaymentsReceived+"</td>" ;
                   html+="<td>"+new Date(data[i].repaymentDate).toLocaleDateString()+"</td>" ;
                  }
                 html+="</tr>" ;
               }
               $("#tb").html(html); 
               $("#td1").val(data[data.length-1].nameOfBorrower);
               $("#td2").val(data[data.length-1].indAccount);
               $("#td3").html(data[data.length-1].unitAddress);
               $("#td4").html(data[data.length-1].annualRate);
               $("#td5").html(data[data.length-1].borrowingBalance);
               $("#td6").html(data[data.length-1].lentYearsNumber);
               $("#money").html(money);
               $("#money2").html(money2);
            }else{
               $("#tb").html(""); 
               $("#td1").val("");
               $("#td2").val("");
               $("#td3").html("");
               $("#td4").html("");
               $("#td5").html("");
               $("#td6").html("");
               alert("没有查询到记录！")
                success2=false;
            }
           },error:function(){
             success2=false;
              alert("没有查询到记录或证明已结清！")
           }
        })
      }
  })
  
    $("form").submit(function(){
		   if(success&&success2){
		     return true;
		   }else{
		     alert("贷款不存在或未还清！");
		     return false;
		   }
    })
</script>
