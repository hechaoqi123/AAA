<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>借款申请书</title>
    
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
         width:200px;
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
         border:1px solid #000;
       }
         ol li{
         color:#999;
         font-family: '楷体';
         font-size: 20;
       }
     </style>
  </head>
  
  <body style="padding-left:160px;">
     <h2 style="margin-left:-160px;">公积金贷款所需具备条件：</h2>
      <form action="save_LoanApplication.action" method="post">
        <ol style="margin-left:-160px;">
        <li>所贷款项必须用于购买商品房、经济适用房、二手房、危改还原房以及自建房；</li>
        <li>有合法的购房合同和首期支付不低于购房总价款30％的自筹资金</li>
        <li> 有稳定的经济收入和偿还贷款本息的能力，有良好的信用记录，且具有完全民事行为能力的自然人；</li>
        <li>单人贷款所贷金额不能超过个人公积金账户余额*20且最高不能超过50w  不能超过房价70%</li>
        <li>夫妻共同贷款所贷金额不能超过双方公积金余额总和*20且最高不能超过70w  不能超过房价70%</li>
        <li>职工所在单位和本人按规定连续足额缴存住房公积金6个月以上（含6个月）未按规定逐月缴存公积金的不具备贷款条件；</li>
      </ol>
       <!-- 住房公积金申请书  -->
      <table border="1px solid #999">
         <tr>
           <td colspan="4"><h3>住房公积金借款申请书</h3></td>
         </tr>
          <tr>
           <td>借款人姓名<span style="color:red">*</span></td>
           <td><input type="text" name="nameOfBorrower" required="true"/></td>
           <td>身份证号<span style="color:red">*</span></td>
           <td><input type="text" name="borrowerIdnumber" id="idnumber" required="true"/></td>
          </tr>
         
          <tr>
           <td>所在单位名称<span style="color:red">*</span></td>
           <td><input type="text" name="borrowersUnit" required="true"/></td>
           <td>联系电话<span style="color:red">*</span></td>
           <td><input type="text" name="borrowerPhone" required="true"/></td>
          </tr>
         
           <tr>
           <td>个人公积金账户<span style="color:red">*</span></td>
           <td><input type="text" id="account" readonly="true" name="indAccount" required="true"/></td>
           <td>借款金额（万元）<span style="color:red">*</span></td>
           <td><input type="text" name="borrowingBalance" required="true"/></td>
          </tr>
         
          <tr>
           <td>借款时长（月）<span style="color:red">*</span></td>
           <td><input type="text" id="monthCount" name="lentYearsNumber" required="true"/></td>
           <td>年利率（%）<span style="color:red">*</span></td>
           <td><input type="text" name="annualRate" id="rate" value="2.75" readonly="true"/></td>
          </tr>
         
          <tr>
           <td>个人月收入（元）<span style="color:red">*</span></td>
           <td><input type="text" name="borrowerMonthMoney" required="true"/></td>
           <td>还款方式<span style="color:red">*</span></td>
           <td>
               <input type="radio" value="等额本息还款" name="unitAddress" checked="true"/>等额本息还款 <br/> 
               <input type="radio" value="等额本金还款" disabled="true" name="unitAddress"/>等额本金还款
           </td>
          </tr>
         
           <tr>
            <td>所购房型</td>
            <td><select  name="useoffunds.useOfFundsId">
                    <option value='2'>经济房</option>
                    <option value='1'>商品房</option>
                    <option value='3'>二手房</option>
                </select></td>
            <td>是否首套房<span style="color:red">*</span></td>
            <td><input type="radio" name="remarks" value="首套房" checked="true"/>首套房  <input name="remarks" value="二套房" type="radio"/>二套房</td>
           </tr>
           <!-------购房合同----->
           <tr>
            <td border="1" colspan="4"><b>购房合同</b></td>
           </tr>
           <tr>
            <td>购房人姓名 <span style="color:red">*</span></td>
            <td><input name="purchasecontract.homeBuyersName"type="text" required="true"/></td>
            <td>购房人身份证号<span style="color:red">*</span></td>
            <td><input type="text" name="purchasecontract.homeBuyersPhone" required="true"/></td>
          </tr>
         
           <tr>
            <td>售房人姓名 <span style="color:red">*</span></td>
            <td><input type="text" name="purchasecontract.salesPersonName" required="true"/></td>
            <td>售房人收款账户<span style="color:red">*</span></td>
            <td><input type="text" name="purchasecontract.salesPersonPhone" required="true"/></td>
          </tr>
         
          <tr>
            <td>房屋类型：<span style="color:red">*</span></td>
            <td><input type="text" name="purchasecontract.purchasedhinfo.housingType" required="true"/></td>
            <td>房屋位置：<span style="color:red">*</span> </td>
            <td><input type="text" name="purchasecontract.purchasedhinfo.housingPosition" required="true"/></td>
          </tr>
         
          <tr>
            <td>占地面积（㎡）<span style="color:red">*</span></td>
            <td><input type="text" name="purchasecontract.purchasedhinfo.floorSpace" required="true"/></td>
            <td>所售房价（万元）<span style="color:red">*</span> </td>
            <td><input type="text" name="purchasecontract.purchasedhinfo.sellingPrice" required="true"/></td>
          </tr>
         
          <tr>
            <td>  已付金额（万元）<span style="color:red">*</span></td>
            <td><input type="text" name="purchasecontract.treatycCntents" required="true"/></td>
            <td colspan="2"></td>
          </tr>
          <!----- 借款担保 ------>
        <tr>
           <td colspan="4"><b>借贷担保</b></td>
         </tr>
          <tr border="0">
           <td >担保方式：<span style="color:red">*</span></td>
           <td > <input type="radio" class="check" value="1" name="guaranteemode.guaranteeModeId" checked="true"/>拟购房产抵押</td>
           <td ><input type="radio"  class="check"value="3" name="guaranteemode.guaranteeModeId"/> 担保人担保</td>           
           <td ><input type="radio" class="check" value="2" name="guaranteemode.guaranteeModeId"/>其他房产抵押</td>               
           </td>
          </tr>
          
          <!-- 担保信息 -->
          <tbody id="assure"></tbody>
          <!-- 共同借款人 -->
          <tr>
           <td colspan="4" ><span style="color:#999">共同借款人[选填]</span>&nbsp&nbsp&nbsp&nbsp<input type="radio" name="cobTab" value="无" checked="true"/>无<input type="radio" id="cc" value="有" name="cobTab"/>有</td>
         </tr>
            <table  id="cobTab" style="display: none">
           <tr>
            <td style="border-top:0px;">共同借款人姓名：<span style="color:red">*</span></td>
            <td style="border-top:0px;"><input name="coborrower.coborrowerName" type="text"/></td>
            <td style="border-top:0px;">共同借款人手机号 <span style="color:red">*</span></td>
            <td style="border-top:0px;"><input name="coborrower.coborrowerPhone" type="text"/></td>
          </tr>
           <tr>
            <td>身份证号：<span style="color:red">*</span></td>
            <td><input name="coborrower.coborrowerIdno" id="number2" type="text"/></td>
            <td>所在单位 ：<span style="color:red">*</span></td>
            <td><input name="coborrower.coborrowerUtinName" type="text"/></td>
          </tr>
           <tr>
            <td>公积金账户：<span style="color:red">*</span></td>
            <td><input name="coborrower.coborrowerAccount" readonly="true" id="ddd" type="text"/></td>
            <td>与借款人关系 <span style="color:red">*</span></td>
            <td><input name="coborrower.relation" type="text"/></td>
          </tr>
          </table>
      </table>
      <br/>
      <input type="reset" style="padding:5px 10px;margin-left:260px;" value="信息重置"/>
      <input type="submit" style="padding:5px 10px;margin-left:40px;"  value="提交申请"/>
      </form>
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
    $("input[name=cobTab]").change(function(){
          if($(this).val()=="无"){
             $("#cobTab").css("display","none");
          }
          if($(this).val()=="有"){
           $("#cobTab").css("display","block");
          }
    
    })
     $(".check").change(function(){
           if($(this).val()=="1"){
                 $("#assure").html("");
           }else if($(this).val()=="3"){
           var html="<table>"; 
	          html+="<tr>"
	          html+="  <td colspan='4'><b>担保人信息</b></td>"
	          html+="</tr>"
	          html+="<tr>"
	          html+="  <td>担保人姓名<span style='color:red'>*</span></td>"
	          html+="  <td><input type='text' name='guarantorinfo.guarantorName' required='true'/></td>"
	          html+="  <td>担保人身份证号<span style='color:red'>*</span></td>"
	          html+="  <td><input type='text' name='guarantorinfo.guarantorIdno' required='true'/></td>"
	          html+="</tr>"
	          html+="<tr>"
	          html+="  <td>担保人居住地址<span style='color:red'>*</span></td>"
	          html+="  <td><input type='text' name='guarantorinfo.guarantorAddress' required='true'/></td>"
	          html+="  <td>担保人所在单位<span style='color:red'>*</span></td>"
	          html+="  <td><input type='text' name='guarantorinfo.guarantorUtin' required='true'/></td>"
	          html+="</tr>"
	          html+="<tr>"
	          html+="  <td>担保人月收入（元）<span style='color:red'>*</span></td>"
	          html+="  <td><input type='text' name='guarantorinfo.guarantorPhone' required='true'/></td>"
	          html+="  <td colspan='2'>(须提供收入证明)</td>"
	          html+="</tr>";
	          
	          html+="</table>";
                  $("#assure").html(html);
           }else if($(this).val()=="2"){
               var  html="<table>";
                 html+="<tr>";     
                 html+="  <td colspan='4'><b>抵押房屋信息<span style='color:red'>*</span></b></td>";
                 html+="</tr>";
                 html+="<tr>";
                 html+="  <td>抵押房屋类型<span style='color:red'>*</span></td>"
                 html+="  <td><input type='text'name='collateralinfo.pawnType' required='true'/></td>"
                 html+="  <td>抵押房屋大小（㎡）<span style='color:red'>*</span></td>"
                 html+="  <td><input type='text' name='collateralinfo.pawnName' required='true'/></td>"
                 html+="</tr>"
                 html+="<tr>";
                 html+="  <td>抵押房屋处所<span style='color:red'>*</span></td>"
                 html+="  <td><input type='text'name='collateralinfo.pawnAddress' required='true'/></td>"
                 html+="<td colspan='2'></td></tr>"
                 html+="<tr>"
                 html+="   <td colspan='4'><b>抵押物权属证明<span style='color:red'>*</span></b></td>"
                 html+="</tr>"
                 html+="<tr>"
                 html+="  <td>所属人：<span style='color:red'>*</span></td>"
		         html+="  <td><input type='text' name='collateralinfo.proof.person' required='true'/></td>"
		         html+="  <td>房屋位置：<span style='color:red'>*</span></td>"
		         html+="  <td><input type='text' name='collateralinfo.proof.address' required='true'/></td>"
		         html+="</tr>"
		         html+="<tr>"
		         html+="  <td>开具证明单位：<span style='color:red'>*</span></td><!-- 上海市浦东新区房地产登记处 -->"
		         html+="  <td><input type='text' name='collateralinfo.proof.issuedName' required='true'/></td>"
		         html+="  <td>证明开具时间：<span style='color:red'>*</span></td>"
		         html+="  <td><input type='text' name='collateralinfo.proof.issuesDate' required='true'/></td>"
		         html+="</tr>";
		         html+="</table>";
		           $("#assure").html(html);
           }
     
     })
     
     $("#monthCount").change(function(){
           var count=$(this).val();
           if((count/12)>5){
             $("#rate").val("3.25");
           }else{
             $("#rate").val("2.75");
           }
     })
     //通过身份证号检索个人账户ID
     $("#idnumber").change(function(){
        $.ajax({
            url:'get_Ind.action',
            type:'post',
            dataType:'json',
            async:false,
            data:{
              'loginAccount':$("#idnumber").val()
            },success:function(data){
               if(data!=null){
                 $("#account").val(data.indAccountId)
               }else{
                 alert("未检索到个人账户ID");
                 $("#account").val("");
               }
            },error:function(){
              alert("未检索到个人账户ID")
              $("#account").val("");
            }
        
        })
     })
          //通过身份证号检索个人账户ID
     $("#number2").change(function(){
        $.ajax({
            url:'get_Ind.action',
            type:'post',
            dataType:'json',
            async:false,
            data:{
              'loginAccount':$(this).val()
            },success:function(data){
               if(data!=null){
                 $("#ddd").val(data.indAccountId)
               }else{
                 alert("未检索到共同借款人账户ID");
                 $("#ddd").val("");
               }
            },error:function(){
              alert("未检索到账户ID")
              $("#ddd").val("");
            }
        
        })
     })
     $("form").submit(function(){
       var result=false;
        $.ajax({//判断个人账户是否存在
            url:'get_IndAccountInfo.action',
            type:'post',
            dataType:'text',
            async:false,//同步
            data:{
                'indAccountId':$("#account").val(),
                'loginAccount':$("#idnumber").val()
            },
            success:function(data){
              
               if(data=="true"){
                 result=true;
               }else{
                  alert("个人公积金账户不存在或与身份证信息不匹配！")
                  $("#account").focus();
                   result=false;
               }
               return result;
            }
        })
       if($("#cc").prop("checked")){//判断共同借款人账户是否为空
          if($("#ddd").val()==""){
          alert("共同借款人公积金账户不能为空！")
            return false;
          }
          if($("#ddd").val()==$("#account").val()){//判断共同借款人账户是否是借款账户
            alert("共同借款人账户不能与本人账户相同！");
            return false;
            
          }
         $.ajax({//判断共同借款人账户是否存在
            url:'get_IndAccountInfo.action',
            type:'post',
            dataType:'text',
            async:false,//同步
            data:{
                'indAccountId':$("#ddd").val()
            },
            success:function(data){
               alert("ww"+data)
               alert(data=="true")
               if(data=="true"){
                 result=true;
               }else{
                  alert("共同借款人公积金账户不存在！")
                  $("#account").focus();
                return false;
               }
            },error:function(){
              alert("操作异常！")
            }
        })
       }
       return false;
        return result;
     })
</script>
