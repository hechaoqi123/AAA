<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script>
	    lay('#version').html('-v'+ laydate.v);
	
	    //执行一个laydate实例
	    //常规用法
	    laydate.render({
	      elem: '#testData' //指定元素
	       ,theme: '#438EB9'
	    });
	    laydate.render({
	      elem: '#testDatak' //指定元素
	       ,theme: '#438EB9'
	    });
	  
    </script>
 </head>
  <body>
  	
  	<form action="updateIndaccountinfo.action" method="post">
	  	<table class="table" border="1px" bordercolor="#e3e3e3">
			<tr>
	           <td>公司名称:</td>
	           <td>
	           		<span class="utinName">${indaccountinfoObject.utinaccountinfo.unitinfo.utinName }</span>
	           		<input class="utinid" name="utinaccountinfoID" style="display: none;" value="${indaccountinfoObject.utinaccountinfo.utinAccountId }">
	           </td>
	           <td>单位地址:</td>
	           <td><span class="utinAddress">${indaccountinfoObject.utinaccountinfo.unitinfo.utinAddress }</span></td>
	           <td>法人代表:</td>
	           <td><span class="corpRepr">${indaccountinfoObject.utinaccountinfo.unitinfo.corpRepr }</span></td>
	           <td>经办人姓名:</td>
	           <td><span class="operatorName">${indaccountinfoObject.utinaccountinfo.unitinfo.operatorName }</span></td>
	           <td>经办人电话:</td>
	           <td><span class="operatorPhone">${indaccountinfoObject.utinaccountinfo.unitinfo.operatorPhone }</span></td>
	           <td>公司现人数:</td>
	           <td><span class="utinSumPeople">${indaccountinfoObject.utinaccountinfo.utinSumPeople }</span></td>
	          </tr>
	  	</table>
	    <table class="table" style="">
	         <tr>
	         	   <td colspan="6" class="active">个人信息</td>
	         </tr>
	          <tr>
		           <td>姓名<span style="color:red">*</span></td>
		           <td>
			           <input class="form-control utinName" type="text" required="required" name="list_indinfo[0].trueName" value="${indaccountinfoObject.indinfo.trueName }"/>
			           <input class="form-control utinName" type="text" required="required" name="list_indinfo[0].indInfoId" value="${indaccountinfoObject.indinfo.indInfoId }" style="display: none;"/>
			           <input class="form-control utinName" type="text" required="required" name="indaccountinfo.indAccountId" value="${indaccountinfoObject.indAccountId }" style="display: none;"/>
		           </td>
		          	<td>证件类型<span style="color:red">*</span></td>
					<td>
						<select class="form-control">
							<option>居民身份证</option>
							<option>士兵证</option>
							<option>军官证</option>
							<option>护照</option>
							<option>其它</option>
						</select>
					</td>
					<td>证件号码<span style="color:red">*</span></td>
					<td><input type="text"  class="form-control idnumber" required="required" name="list_indinfo[0].idnumber" onblur="idNum(this)"   value="${indaccountinfoObject.indinfo.idnumber }"/></td>
	          </tr>
	          <tr>
		           <td>单位名称<span style="color:red">*</span></td>
		           <td>
		           	<span class="form-control utinNames">${indaccountinfoObject.utinaccountinfo.unitinfo.utinName }</span>
		           </td>
					<td>年龄<span style="color:red">*</span></td>
					<td><input type="text"  class="form-control age" readonly="readonly"/></td>
					<td>性别<span style="color:red">*</span></td>
					<td><input type="text"  class="form-control sex" readonly="readonly"/></td>
					
	          </tr>
	         
	         
	         
	          <tr>
					<td>出生年月<span style="color:red">*</span></td>
					<td><input type="text"  class="form-control birthday" readonly="readonly"/></td>
					<td>固定号码<span style="color:red">*</span></td>
					<td><input type="text"  class="form-control" required="required" name="list_indinfo[0].fixedPhone" value="${indaccountinfoObject.indinfo.fixedPhone }"/></td>
					<td>手机号码<span style="color:red">*</span></td>
					<td><input type="text"  class="form-control" required="required" name="list_indinfo[0].phoneNumber" value="${indaccountinfoObject.indinfo.phoneNumber }"/></td>
	          </tr>
	          <tr>
					
					<td>婚姻状况<span style="color:red">*</span></td>
					<td>
						<c:if test="${indaccountinfoObject.indinfo.wedlockStatus == '未婚' }">
			          		<input type='radio' checked='checked'name='list_indinfo[0].wedlockStatus' value='未婚'/>未婚
			          		<input type='radio'name='list_indinfo[0].wedlockStatus' value='已婚'/>已婚
		          		</c:if>
						<c:if test="${indaccountinfoObject.indinfo.wedlockStatus == '已婚' }">
			          		<input type='radio' name='list_indinfo[0].wedlockStatus' value='未婚'/>未婚
			          		<input type='radio' checked='checked' name='list_indinfo[0].wedlockStatus' value='已婚'/>已婚
		          		</c:if>
		          	</td>
					<td>储蓄账户<span style="color:red">*</span></td>
					<td><input type="text" class="form-control utinFoundDate"  required="required" name="indaccountinfo.bankSaAccount" value="${indaccountinfoObject.bankSaAccount }"/></td>
					<td>储蓄银行<span style="color:red">*</span></td>
	 				<td>
			          	<select class='form-control' name='indaccountinfo.bankOpenAccount'>
			          		<option>中国银行</option>
			          		<option>工商银行</option>
			          		<option>建设银行</option>
			          	</select>
			         </td>
	          </tr>
	          <tr>
					<td>家庭住址<span style="color:red">*</span></td>
					<td><input type="text" class="form-control utinFoundDate"  required="required" name="list_indinfo[0].familyAddress" value="${indaccountinfoObject.indinfo.familyAddress }"/></td>
					<td>家庭月收入<span style="color:red">*</span></td>
					<td class="input-group">
						<input type="text" class="form-control" name="list_indinfo[0].familyMonthIncome" value="${indaccountinfoObject.indinfo.familyMonthIncome }"/> 
						<span class="input-group-addon">元</span>
					</td>
					<td>学历<span style="color:red">*</span></td>
					<td>
		          		<select  class="form-control">
		          			<option>初等教育</option>
		          			<option>中等教育</option>
		          			<option>高等教育</option>
		          		</select>
		          	</td>
	          </tr>
	          <tr>
		          	<td>职业<span style="color:red">*</span></td>
					<td>
						<select class="form-control" >
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
					<td>职务<span style="color:red">*</span></td>
					<td>
					    <input type="text" class="form-control" name="list_indinfo[0].duties" onfocus="value=''" value="${indaccountinfoObject.indinfo.duties }"/>
					</td>
	          </tr>
	           <tr>
	         	   <td colspan="6" class="active">个人账户信息</td>
	         </tr>
	           <tr>
	           		<td>员工基数<span style="color:red">*</span></td>
	           		<td><input type='text'  class='form-control' required='required' name="indaccountinfo.indDepositRadices" onblur="MonthDep(this)"value="${indaccountinfoObject.indDepositRadices }"/></td>
					<td>单位缴存比例<span style="color:red">*</span></td>
					<td class="input-group"><input class="form-control utinDepositRatio" readonly="readonly" value="${indaccountinfoObject.utinaccountinfo.utinDepositRatio*100 }"/> <span class="input-group-addon">%</span></td>
					<td>个人缴存比例<span style="color:red">*</span></td>
					<td class="input-group"><input class="form-control utinDepositRatio" readonly="readonly" value="${indaccountinfoObject.utinaccountinfo.utinDepositRatio*100 }"/> <span class="input-group-addon">%</span></td>
	          </tr>
	           <tr>
					<td>单位月缴存额<span style="color:red">*</span></td>
					<td><input  class="form-control utinMonthDep" required="required" readonly="readonly" name="indaccountinfo.utinMonthDep" value="${indaccountinfoObject.utinMonthDep }"/></td>
					<td>个人月缴存额<span style="color:red">*</span></td>
					<td><input  class="form-control utinMonthDep" required="required" readonly="readonly" name="indaccountinfo.peMonthDep"  value="${indaccountinfoObject.peMonthDep }"/></td>
					<td>月缴存合计<span style="color:red">*</span></td>
					<td>
						<input class="form-control utinMonthDeputinMonthDep" required="required" readonly="readonly"/>
					</td>
	          </tr>
	           <tr>
	           	
	           		<td>员工状态<span style="color:red">*</span></td>
					<td><span class="form-control">${indaccountinfoObject.indStatus}</span></td>
					<td>电子邮箱<span style="color:red">*</span></td>
					<td><input min="0" max="1"  class="form-control" required="required"value="${indaccountinfoObject.utinMonthDep}1780@qq.com" /></td>
					<td>邮政编码<span style="color:red">*</span></td>
					<td><input class="form-control" required="required" value="498901"/></td>
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
<script type="text/javascript" src="JS/AddRole.js"></script>
<script>



function MonthDep(obj){
	var MonthDep = obj.value;
	var utinDepositRatio = $(".utinDepositRatio").val()/100;
	var a = MonthDep*utinDepositRatio;
	$(".utinMonthDep").val(a);
	$(".utinMonthDeputinMonthDep").val(a*2);
	
}
function idNum(obj){
	//获取输入身份证号码 
	var idNum = obj.value; 
	if(idNum != null && idNum != ''){
	//获取出生日期 
	var birthday = idNum.substring(6, 10) + "-" + idNum.substring(10, 12) + "-" + idNum.substring(12, 14); 
	$(".birthday").val(birthday);
	//获取性别 
	if (parseInt(idNum.substr(16, 1)) % 2 == 1) { 
	 $(".sex").val("男");//男 
	} else { 
	 $(".sex").val("女");//女 
	} 
	//获取年龄 
	var myDate = new Date(); 
	var month = myDate.getMonth() + 1; 
	var day = myDate.getDate();
	
	var age = myDate.getFullYear() - idNum.substring(6, 10) - 1; 
	if (idNum.substring(10, 12) < month || idNum.substring(10, 12) == month && idNum.substring(12, 14) <= day) { 
	age++; 
	}
	//年龄 age
	$(".age").val(age);
}
}
</script>

</html>

