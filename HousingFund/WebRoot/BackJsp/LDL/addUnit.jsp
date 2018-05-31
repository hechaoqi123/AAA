<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addFunction</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="bootstrap/laydate/laydate.js"></script> <!-- 改成你的路径 -->
	<script type="text/javascript" src="JS/vendor/jquery.validate-1.13.1.js"></script>
	<script type="text/javascript" src="JS/vendor/messages_zh.js"></script>
    <script>
	    lay('#version').html('-v'+ laydate.v);
	
	    //执行一个laydate实例
	    //常规用法
	    laydate.render({
	      elem: '#testData' //指定元素
	       ,theme: '#438EB9'
	    });
	 
	  
    </script>
    <style>
   			/*去除input框number中的小箭头  */
			input::-webkit-outer-spin-button,
			input::-webkit-inner-spin-button{
			    -webkit-appearance: none !important;
			    margin: 0; 
			}
			input[type="number"]{-moz-appearance:textfield;}
			.indDepositRadices{
				width: 100px;
			}
   	</style>
 </head>
  <body>
  
  	<form action="saveUnitinfo.action" method="post" class="addUtitinfoForm">
    <table class="table" style="">
         <tr>
         	   <td colspan="6" class="active">单位账户信息</td>
         </tr>
          <tr>
	           <td>单位名称<span style="color:red">*</span></td>
	           <td colspan="3"><input class="form-control utinName" type="text" required="required" name="utitinfo.utinName"/></td>
	           <td>法人代表<span style="color:red">*</span></td>
	           <td><input type="text"  class="form-control" required="required" name="utitinfo.corpRepr"/></td>
          </tr>
          <tr>
				<td>经办人姓名<span style="color:red">*</span></td>
				<td><input type="text"  class="form-control" required="required" name="utitinfo.operatorName"/></td>
				<td>经办人联系方式<span style="color:red">*</span></td>
				<td><input type="text"  class="form-control" required="required" name="utitinfo.operatorPhone"/></td>
				<td>经办人证件号<span style="color:red">*</span></td>
	           <td><input type="text"  class="form-control" required="required" name="utitinfo.operatorIdnumber"/></td>
          </tr>
         
         
         
          <tr>
				<td>单位地址<span style="color:red">*</span></td>
				<td><input type="text"  class="form-control" required="required" name="utitinfo.utinAddress"/></td>
				<td>缴存比例<span style="color:red">*</span></td>
				<td class="input-group"><input type="number" min="0" max="12"  class="form-control" required="required" name="utinaccountinfo.utinDepositRatio"/> <span class="input-group-addon">%</span></td>
				<td>委托银行<span style="color:red">*</span></td>
				<td>
					<select class="form-control" name="utitinfo.bankName">
						<option>中国银行</option>
						<option>中国银行</option>
						<option>中国银行</option>
					</select>
				</td>
          </tr>
          <tr>
				<td>单位状态<span style="color:red">*</span></td>
				<td><span class="form-control"/>正常</span></td>
				<td>单位设立日期<span style="color:red">*</span></td>
				<td><input type="text" class="form-control utinFoundDate"  required="required" name="utitinfo.utinFoundDate" id="testData"/></td>
				<td>单位开户日期<span style="color:red">*</span></td>
				<td>
				    <input type="text" class="form-control" readonly="readonly" name="utitinfo.utinOpenDate" onblur="getDemo()" id="demo"/>
				</td>
          </tr>
           <tr>
         	   <td colspan="6" class="active">缴存单位信息</td>
         	</tr>
           <tr>
				<td>单位类型<span style="color:red">*</span></td>
				<td>
					<select class="form-control" name="">
						<option>私营企业</option>
						<option>国有企业</option>
						<option>国有控股企业</option>
						<option>外资企业</option>
						<option>合资企业</option>
						<option>事业单位</option>
					</select>
				</td>
				<td>单位所属行业<span style="color:red">*</span></td>
				<td>
					<select class="form-control" name="" >
						<option>农、林、牧、渔业</option>
						<option>采矿业</option>
						<option>制造业</option>
						<option>电力、热力、燃气及水的生产和供应业</option>
						<option>环境和公共设施管理业</option>
						<option>建筑业</option>
						<option>交通运输、仓储业和邮政业</option>
						<option>信息传输、计算机服务和软件业</option>
						<option>批发和零售业</option>
						<option>住宿、餐饮业</option>
						<option>金融、保险业</option>
						<option>其他</option>
					</select>
				</td>
				<td>单位隶属关系<span style="color:red">*</span></td>
				<td>
					<select class="form-control" name="" >
						<option>中央</option>
						<option>省</option>
						<option>市</option>
						<option>区</option>
						<option>县</option>
						<option>街道</option>
						<option>镇</option>
						<option>乡</option>
						
					</select>
				</td>
          </tr>
           <tr>
				<td>组织机构代码<span style="color:red">*</span></td>
				<td><input class="form-control" required="required" name="stringTest"/></td>
				<td>每月发薪日<span style="color:red">*</span></td>
				<td><input type="number" min="0" max="31"  class="form-control" required="required"/></td>
				<td>催缴人<span style="color:red">*</span></td>
				<td><input  class="form-control" required="required"  name="names"/></td>
          </tr>
           <tr>
				<td>电子邮箱<span style="color:red">*</span></td>
				<td><input class="form-control" required="required" name="emails" /></td>
				<td>邮政编码<span style="color:red">*</span></td>
				<td><input class="form-control" required="required" name="youb"/></td>
				<td></td><td></td>
          </tr>
          <tr></tr>
          <tr>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td>
                <input type="reset" style="padding:5px 10px" value="信息重置" class="btn btn-default"/>
      			<input type="submit" style="padding:5px 10px" value="提交申请" class="btn btn-default"/>
           </td>
          </tr>
      </table>
    </form>
  </body>
 <script type="text/javascript" src="JS/zhengze.js"></script>
<script>
$(function(){
getDemo();
			});
var  now;
function getDemo(){
	var myDate = new Date();
		//获取当前年
		var year=myDate.getFullYear();
		//获取当前月
		var month=myDate.getMonth()+1;
		//获取当前日
		var date=myDate.getDate();
		now=year+"-"+month+"-"+date;
		$("#demo").val(now);
}	
$("#testData").blur(function(){
});
</script>

</html>

