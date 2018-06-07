<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提前还款申请书</title>
    
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
     <h2>提前还款须知：</h2>
      <form action="before_return.action" method="post">
        <ol>
        <li>办理提前还款须携带:贷款合同、最后一期的银行还款回单、本人身份证。</li>
        <li>申请人当前并没有处于逾期还款的状态中；</li>
        <li>公积金贷款提前还款需要满足申请人还款时间已经满一年的条件，提前还款只收取部分利息<br/>（提前还款利息=提前还款本金*（已用时长/12）*年利率）</li>
      </ol>
      <br/>
       输入借款人身份证号： <input id="number"/> <input type="button" id="index" value="点击索引贷款信息"/>
       <br/><br/>
       <!-- 住房公积金申请书  -->
      <table border="1px solid #999" id="tab">
         <tr>
           <td colspan="6"><h3>提前还款申请表</h3></td>
         </tr>
          <tr>
           <td>借款人姓名 </td>
           <td><input type="text" readonly="readonly" id="td1" required="true"/></td>
           <td>借款人账户 </td>
           <td><input type="text" id="td2" readonly="readonly"  required="true"/></td>
           <td>借贷合同编号 </td>
           <td><input type="text" readonly="readonly"  name="borrowmoneyagreement.borrowMoneyAgreementId" id="td3" required="true"/></td>
          </tr>
         
          <tr>
           <td>放款银行 </td>
           <td><input type="text" readonly="readonly"  name="borrowersUnit" id="td4" required="true"/></td>
           <td>合同签订日期 </td>
           <td><input type="text" readonly="readonly"  name="borrowerPhone" id="td5" required="true"/></td>
           <td>签订人 </td>
           <td><input type="text" readonly="readonly"  name="borrowerPhone" id="td6" required="true"/></td>
          </tr>
         
           <tr>
           <td>借款金额 </td>
           <td><input type="text" readonly="readonly"  id="td7" required="true"/></td>
           <td>已还本金 </td>
           <td><input type="text" readonly="readonly"  id="td8" name="returnMoney" required="true"/></td>
           <td>未还本金 </td>
           <td><input type="text" readonly="readonly"  id="td9" name="afterMoney" required="true"/></td>
          </tr>
          <tr>
           <td>年利率（%） </td>
           <td><input type="text" readonly="readonly"  id="td10" name="borrowerMonthMoney" required="true"/></td>
           <td>提前还款方式</td>
           <td colspan="3">
               <input type="radio" name="returnType" value="全部结清" checked="true"/>全部结清 
               <input type="radio" name="returnType" value="部分还款"/>部分还款 &nbsp&nbsp&nbsp
           </td>
          </tr>
          <tr>
            <td>联系方式:<span style="color:red">*</span></td>
            <td colspan="2"><input required="true" name="iphone" type="text"/></td>
            <td colspan="3" id="tr">
                                    未还利息:<input readonly="true" type="text" name="afterlixi" value="0" id="mm"/>元
            </td>
          </tr>
           <tr>
            <td>银行储蓄账户:<span style="color:red">*</span></td>
            <td colspan="2"><input required="true" name="indLoan" type="text"/></td>
            <td colspan="3" >
            </td>
          </tr>
          <tr>
            <td colspan="6">
               <div style="text-align:left;padding-left:150px;padding-bottom:20px;padding-top:10px">
                  相关规定：
                 <p style="">一、借款人须在按月正常偿还贷款本息6个月后，方才可提出首次提前偿还部分贷款或全部贷款；</p>
                 <p>二、贷款机构为严肃贷款管理，对提前偿还部分贷款规定了以万元为单位。</p>
                 <p>三、借款人提前还贷一般需提前10天或15天告知贷款机构，并须持原借款合同、银行还贷储蓄卡、<br/>
                                      &nbsp &nbsp&nbsp&nbsp每月还资本金利息表、本人身份证等资料向贷款机构提出书面申请，并须经其审核同意</p>
               </div>
            </td>
          </tr>
      </table>
      <br/>
          <input type="submit" value="提交申请"/>
      </form>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
  var money=0;
   //ajax获取借款信息
      $("#index").click(function(){
            var number=$("#number").val();
           $.ajax({
             url:'indexBorr.action',
             type:'post',
             dataType:'json',
             async:false,//同步
             data:{
                'borrowerIdno':number
             },
             success:function(data){//借款合同信息
                 //未还期数
               var num=parseInt((parseInt(data.borrowMoneyNumber*10000)-parseInt(data.coborrower))/(parseInt(data.borrowMoneyNumber*10000)/data.borrowerFixedYear));
               money=(parseInt(data.borrowMoneyNumber*10000)-parseInt(data.coborrower))*(data.borrowerAnnualRate/12/100)*(data.repaymentPlanDetailsiId);
                 $("#td1").val(data.borrowerName);
                 $("#td2").val(data.repaymentAccount);
                 $("#td3").val(data.borrowMoneyAgreementId);
                 $("#td4").val("中国银行");
                 $("#td5").val(data.borrowerPhone);
                 $("#td6").val(data.borrowerName);
                 $("#td7").val(parseInt(data.borrowMoneyNumber*10000));
                 $("#td8").val(parseInt(data.coborrower));
                 $("#td9").val(parseInt(data.borrowMoneyNumber*10000)-parseInt(data.coborrower));//未还本金
                 $("#td10").val(data.borrowerAnnualRate);
                 $("#mm").val(parseInt(money))
             },error:function(){
               alert("未检索到贷款结清证明或已领取！")
             }
           })
      })
    //全部还款[部分还款]选项卡
    $("input[name='returnType']").click(function(){
       if($(this).val()=="部分还款"){
              var html="";
			     html+="  提前还款金额（万元）:<span style='color:red'>*</span><input id='bfbj' required='true' name='money'/>";
			     $("#tr").html(html);
       }else{
        $("#tr").html("  未还利息:<input type='text' name='afterlixi' value='0' id='mm'/>元");
        
          $("#mm").val(parseInt(money));
       }
     })
 
</script>
