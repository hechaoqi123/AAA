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
    
    <title>签订借款合同</title>
    
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
         width:200px;
         height:40px;
         line-height:40px;
         text-align:left;
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
    <h2>签订借贷合同</h2>
      请输入个人身份证号：<input type="text" id="id"/>   <button id="index">点击检索</button><br/><br/>
      <form action="end_loan.action" method="post">
      <input type="text" id="a" style="display:none" name="loanApplicationId" />
         <div style="border:1px solid #999;padding-left:20px;width:800px;">
          <table>
             <tr>
               <th colspan="4" style="text-align:center;height:50px;"><span style="position: relative;left: -40px">借贷合同</span></th>
             </tr>
              <tr>
               <td style="width:80px;padding-left:100px;">贷款种类：</td>
               <td id="td1" style="text-align:left;width:150px"></td>
               <td style="width:130px;padding-left:80px;">合同编号：</td>
               <td id="td2" style="text-align:left"></td>
             </tr>
              <tr>
               <td style="width:80px;padding-left:100px;">借款人：</td>
               <td id="td3" style="text-align:left;width:150px"></td>
               <td style="width:130px;padding-left:80px;">借款公积金账户：</td>
               <td id="td4" style="text-align:left"></td>
             </tr>
               <tr>
               <td style="width:80px;padding-left:100px;">售房人：</td>
               <td id="td6" style="text-align:left;width:150px"></td>
               <td style="width:130px;padding-left:80px;">收款账户：</td>
               <td id="td7" style="text-align:left"></td>
             </tr>
             <tr>
               <td style="width:80px;padding-left:100px;">贷款期限：</td>
               <td id="tt" style="text-align:left;width:150px"></td>
               <td style="width:130px;padding-left:80px;">贷款银行：</td>
               <td id="td5" style="text-align:left"></td>
             </tr>
              <tr>
               <td colspan="4">
                   <div style="height:1400px;text-align: left;margin-left:50px;width:670px">
                   
                    借款人即抵押人（以下简称甲方）：贷款人即抵押权人（以下简称乙方）：保证人即售房单位（以下简称丙方）：
                    甲方因购买或建造或翻建或大修自有自住住房，根据XX市公积金管理中心和《职工住房抵押贷款办法》规定，向乙方申请借款，愿意以所购买或建修的住房作为抵押。
                    乙方经审查同意发放贷款。在抵押住房的房地产权证交乙方收押之前，丙方愿意为甲方提供保证。为明确各自的权利和义务，
                    甲，乙，丙三方遵照有关法律规定，经协商一致，订立本合同，共同遵守执行。 
                   <dl>
          <b>第一条：</b> 借款金额 　甲方向乙方借款人民币<input readonly="true" id="in1" style="border:0px; border-bottom:1px solid #000"/>万元。<br/>
          <b>第二条：</b> 借款用途 　甲方借款用于购买，建造，翻建，大修座落于<input id="in2"  readonly="true"style="border:0px; border-bottom:1px solid #000"/>。<br/>
          <b>第三条：</b> 借款期限 　借款合同期限至<input id="in3" readonly="true"style="border:0px; border-bottom:1px solid #000"/>。    <br/>
          <b>第四条：</b> 贷款利率 　贷款利率按签订本合同时公布的利率确定年利率为<input id="in4" readonly="true" style="border:0px;width:40px; border-bottom:1px solid #000"/>%。在借款期限内利率变更，按中国人民银行规定办理。<br/>
          <b>第五条:</b> 贷款拨付 　向售房单位购买住房或通过房地产交易市场购买私房的甲方在此不可撤销地授权乙方，在办理住房抵押登记获得认同（乙方确定）之日起的五个营业日内将贷款金额连同存入的自筹资金全数以甲方购房款的名义转入售房单位或房地产交易市场在银行开立的帐户。
                       甲方建造，翻建，大修自住住房的，在本合同生效后自筹资金用完或将要用完时，有乙方主动将贷款资金划入甲方在乙方开立的活期储蓄存款户储蓄卡帐户）按工程进度支用。<br/>
          <b>第六条：</b>贷款偿还 　　贷款本金和利息，采用按月等额还款方式。贷款从发放的次月起按月还本付息。根据等额还款的计算公式计算每月等额还贷款本息，去零进元确定每月还本息额，最后一次本息接清。<br/>
          <b>第七条：</b>贷款担保 　　本合同项下甲方购买的住房由丙方提供阶段性保证。在未将房地产权证交乙方收押前，如发生借款人违约连续三个月拖欠贷款本息，罚息及相关费用，丙方须在接到乙方发出《履行保证责任通知书》后的十日内负责代为清偿。保证期限从贷款发生之日起，至乙方取得房地产权证收押之日为止。
                       保证期间，借款合同的甲，乙方协议变更借款合同内容，应事先征得丙方的书面同意。本合同项下甲方购买，建造，翻建，大修的住房作为借款的抵押担保，由甲，乙方另行签订《住房抵押合同》。甲方购买期房的，应将购房预售合同交乙方保管。  <br/>
          <b>第八条：</b>合同公证 　　甲，乙，丙三方自本合同签订之日起的十日内，向公证机关办理本合同和甲，乙方签订的住房抵押合同公证。<br/>
          <b>第九条：</b>合同的变更和解除 　　本合同生效后，任何一方不得擅自变更和解除本合同。甲方如将本合同项下的权利，义务转让给第三方，应符合有关规定，并应事先经一方书面同意（如在保证期间应征得丙方同意），其转让行为在受让方和乙方重新签订借款合同后生效。 　　
                       <br/> <br/>    甲方：<input required="true" id="jia"  style="border:0px; border-bottom:1px solid #000"/>　　　 　       乙方：（私章） 　　　　 丙方：（私章） 　<br/> <br/> 
                        <span style="padding-left:400px;"></span><span style="position: relative;left: 70px;">合同签订日期:<input id="dat" readonly="true" style="border:0px; border-bottom:1px solid #000"/></span>
           </dl>
                   </div>
               </td>
             </tr>
             
          </table>
          </div>
          <input type="submit" value="确认签订（打印合同）"/>
      </form>
  </body>
</html>
 <script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
  $("#index").click(function(){
           var id=$("#id").val();
      if(id==""){
         alert("身份证号不能为空")
      }else{
        $.ajax({
           url:'get_loan.action',
           type:'post',
           data:{'borrowerIdnumber':id},
           dataType:'json',
           success:function(data){
             if(data==null){
                alert("此用户不存在未处理的借贷合同！")
             }else{
             $("#a").val(data.loanApplicationId);
             $("#td1").html("住房公积金贷款");
             $("#td2").html(data.borrowerPhone);
             $("#td3").html(data.nameOfBorrower);
             $("#td4").html(data.indAccount);
             $("#td5").html("中国银行");
             $("#td6").html(data.purchasecontract.salesPersonName);
             $("#td7").html(data.purchasecontract.salesPersonPhone);
             $("#tt").html(data.lentYearsNumber)
             $("#in1").val(parseInt(data.borrowingBalance));
             $("#in2").val(data.borrowersUnit);
             $("#in4").val(data.annualRate);
              var date=new Date();
              $("#dat").val(date.toLocaleDateString());
               for(var i=0;i<data.lentYearsNumber;i++){
                   date=addDateMonth(date);
                }
              $("#in3").val(date.toLocaleDateString()); 
             }
           },error:function(){
              alert("ajax访问错误！")
           }
        })
      }
  })
  $("form").submit(function(){
        if($("#a").val()==""){
          alert("合同信息不完整！")
          return false;
        }
        if($("#td3").html()!=$("#jia").val()){
           alert("甲方姓名填写错误！");
           return false;
        }
    return true;
  })
  function addDateMonth(date){
    var d = new Date(date);
    var month = d.getMonth();
    if(11 === month){
        var year = d.getFullYear();
        d.setMonth(0);
        d.setFullYear(year + 1);
    }else{
        d.setMonth(month + 1);
    }
    return d;
}
</script>
