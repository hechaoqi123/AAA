<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公积金冲贷业务办理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <style>
     th{
      font-family: '楷体'
     }
    table{
    border-collapse:collapse;
    }
      td,th{
         width:160px;
         height:50px;
         line-height:50px;
         text-align:center;
      }
      #ta{
        margin-top:30px;
      }
      #td1,#td2,#td3,#td4,#td5,#td6{
        text-align:left;
      }
     .tx{
       border:1px solid #999;
       margin-left:20px;
        width:200px;
        height:30px;
        font-size:18px;
      }
   </style>
  <script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
  </head>
  
  <body style="padding-left:50px;">
  <form action="save_fush.action" method="post">
  <h1 style="width:500px;">公积金冲还贷款业务办理</h1>
   <!--  公积金冲贷（年冲，月冲）（公积金账户绑定一个借款合同，定期缴纳）（余额不足时，取消冲贷业务，并以电话的形式通知）<br/> -->
   
    身份证号:<input type="" id="number"/>
    <input type="button" id="index" value="检索信息"/><br/><br/>
    <table  border="1" bordercolor="#999" >
      <tr>
        <th colspan="8" style="font-size: 20px;height:60px;line-height:60px;">提取住房公积金"冲还贷"划款委托书</th>
      </tr>
       <tr>
        <th colspan="8">
           <div style="text-align:left;height:120px;padding-left:30px;font-size:20px; font-weight:15;">
             <sapn>委托方（甲方）:</sapn><br/>
             <span style="position: relative;top:-15px;">受托方（乙方）：AAA住房公积金中心</span><br/>
             <span style="position: relative;top:-30px;">委托信息如下：</span>
           </div>
        <!-- 委托方信息 -->
          <table style="width:800px;margin-top:10px;">
            <tr>
              <th  colspan="8" style="position: absolute;left:500px">委托方信息</th>
            </tr>
             <tr>
              <th  colspan="8" style="padding-left:30px;padding-right:30px;">
                 <div style="width:900px;height:300px;padding-left:100px;border:1px solid #999">
                     <table>
                       <tr>
                         <td></td><td></td><td></td><td></td><td></td><td></td>
                       </tr>
                       <tr>
                         <td>委托人姓名:</td>
                         <td colspan="2" id="td1"></td>
                         <td>借款金额:</td>
                         <td colspan="2" id="td2"></td>
                       </tr>
                       <tr>
                         <td>个人公积金账户:</td>
                         <td colspan="2" id="td3"></td>
                         <td>公积金账户余额:</td>
                         <td colspan="2" id="td4"></td>
                       </tr>
                       <tr>
                         <td>借贷合同编号:</td>
                         <td colspan="2" id="td5"></td>
                         <td>还款方式:</td>
                         <td colspan="2" id="td6"></td>
                       </tr>
                       <tr>
                         <td>预留手机号:<span style="color: red">*</span></td>
                         <td colspan="2" style="text-align:left"><input type="text" name="iphone" required="true"  style="border:0px;height:25px;border-bottom:1px solid #000"/></td>
                         <td>预留银行卡:<span style="color: red">*</span></td>
                         <td colspan="2" style="text-align:left"><input type="text" name="number" required="true" style="border:0px;height:25px;border-bottom:1px solid #000"/></td>
                       </tr>
                     </table>
                 </div>
              </th>
            </tr>
        </th>
      </tr>
      
          <!-- 委托授权书 -->
             <table id="ta" border="1" style="margin-bottom:50px;position:relative;left:30;" bordercolor="#999">
               <tr>
               <th colspan="6">委托授权书</th>
               </tr>
               <tr>
               <td colspan="6" style="margin-left:30px;">
                 <div style="width:950px;text-align:left;padding-left:50px;font-size: 19px;">
                    <p style="text-align: left;padding-left:50px;">委托内容:</p> 
                    <p style="text-align: left;padding-left:130px;margin-top:-20px;"> 甲方已知悉“公积金冲还贷”业务须知，授权并委托乙方将本人申请归还的贷款从本人<br/>
                    住房公积金个人账户中划至上述委托方信息内指定的公积金账户，冲抵该笔住房公积金<br/>贷款。 </p>
                    
                  <p style="text-align:right;margin-right:30px;">委托方签名:<span style="color:red">*</span><input type="text"  required="true" style="border:0px;height:25px;border-bottom:1px solid #000"/></p>
                  <p style="text-align:right;margin-right:30px;">日期:<input id="td7" readonly="true" type="text" style="border:0px;height:25px;width:170px;border-bottom:1px solid #000;font-size: 17px;text-align:center;"/></p>
                 </div>
                </td>
               </tr>
            </table>
          </div>
               </td>
               </tr>
             </table>
          </div>
   
    </table>
      <p style="font-size: 17px;color: #999">注：本委托书一式三联，委托方、受托方、贷款银行各留存一份。</p>
    <input name="borrowmoneyagreement.borrowMoneyAgreementId" id="borrid" style="display:none" />
        <input type="submit" value="确认办理"/>
      </form>
  </body>
</html>
<script>
    $("#index").click(function(){
       $.ajax({
            url:'index_push.action',
            type:'post',
            dataType:'json',
            async:false,//同步
            data:{
                'borr.borrowerIdno':$("#number").val()
            },
            success:function(data){
               $("#td1").html(data.borrowerName);
               $("#td2").html(parseInt(data.borrowMoneyNumber*10000));
               $("#td3").html(data.repaymentAccount);
               $("#td4").html(data.coborrower);
               $("#td5").html(data.borrowMoneyAgreementId);
               $("#td6").html(data.repaymentMode);
               $("#td7").val(new Date().toLocaleDateString());
               $("#borrid").val(data.borrowMoneyAgreementId);
            },error:function(e){
              alert("未查询到信息记录！")
            }
       
       })
    })
    $("form").submit(function(){
        if($("#td7").val()==""){
           alert("信息不完整！");
           return false;        
        }
    })
</script>
