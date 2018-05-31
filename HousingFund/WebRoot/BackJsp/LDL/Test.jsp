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
  	
  	<form action="saveIndaccountinfo.action" method="post">
  	<table class="table" border="1px" bordercolor="#e3e3e3">
  		 <tr>
           <td><input class="utinid" name="utinaccountinfoID" style="display: none;"></td>
           <td>公司名称:</td>
           <td><span class="utinName"></span></td>
           <td>单位地址:</td>
           <td><span class="utinAddress"></span></td>
           <td>法人代表:</td>
           <td><span class="corpRepr"></span></td>
           <td>经办人姓名:</td>
           <td><span class="operatorName"></span></td>
           <td>经办人电话:</td>
           <td><span class="operatorPhone"></span></td>
           <td>公司现人数:</td>
           <td><span class="utinSumPeople"></span></td>
          </tr>
  	</table>
    <table class="table">
         <tr>
         	   <td colspan="10"><h3>员工开户</h3></td>
         </tr>
           <tr>
	           <td>姓名<span style="color:red">*</span></td>
	           <td>证件号<span style="color:red">*</span></td>
	           <td>手机号码<span style="color:red">*</span></td>
	           <td>现住址<span style="color:red">*</span></td>
	           <td>现基数<span style="color:red">*</span></td>
	           <td>储蓄账户<span style="color:red">*</span></td>
	           <td>开户银行<span style="color:red">*</span></td>
	           <td>婚姻状况<span style="color:red">*</span></td>
          </tr>
          <tr>
	          <td><input type='text'  class='form-control' required='required' name='list_indinfo[0].trueName'/></td>
	          <td><input type='text'  class='form-control' required='required' name='list_indinfo[0].idnumber'/></td>
	          <td><input type='text'  class='form-control' required='required' name='list_indinfo[0].phoneNumber'/></td>
	          <td><input type='text'  class='form-control' required='required' name='list_indinfo[0].familyAddress'/></td>
	          <td><input type='text'  class='form-control' required='required' name='list_indaccountinfo[0].indDepositRadices'/></td>
	          <td><input type='text'  class='form-control' required='required' name='list_indaccountinfo[0].bankSaAccount'/></td>
	          <td>
	          	<select class='form-control' name='list_indaccountinfo[0].bankOpenAccount'>
	          		<option>中国银行</option>
	          		<option>中国银行</option>
	          		<option>中国银行</option>
	          	</select>
	          </td>
	           <td>
	          		<input type='radio' checked='checked'name='list_indinfo[0].wedlockStatus' value='未婚'/>未婚
	          		<input type='radio'name='list_indinfo[0].wedlockStatus' value='已婚'/>已婚
	          </td>
         </tr>
          <tbody id="myTby">
          
          </tbody>
         
          <tr>
        
           <td> 
                <input type="button" style="padding:5px 10px" value="继续添加" onclick="addAppend()" class="btn btn-default"/>
           </td>
           <td>
      			<input type="submit" style="padding:5px 10px" value="提交申请" class="btn btn-default"/>
           </td>
          </tr>
      </table>
    </form>
  </body>
<script type="text/javascript" src="JS/AddRole.js"></script>
<script>
var href = decodeURI(subStr(window.location.href).ids);
$(function(){
	get_one_Utinaccountinfo(href);
	//utinSumPeopleTest ();
});
//解析路径 把路径分离数组
function subStr(url) {
		var obj = {};
		var str = url.split('?')[1];
		var str2 = str.split('&');
		for (var k in str2) {
			var str3 = str2[k].split('=');
			obj[str3[0]] = str3[1];
		}
		return obj;
	}
var utinSumPeople = 0;	
function get_one_Utinaccountinfo(obj){
	 $.ajax({
		 url:"get_one_Utinaccountinfo.action",
		 data:{"accountId":obj},
		 type:"post",
		 dataType:"json",
		 success:function(data){
			 $(".utinid").val(obj);
			 $(".utinName").html(data[0].utinName);
			 $(".utinAddress").html(data[0].utinAddress);
			 $(".corpRepr").html(data[0].corpRepr);
			 $(".operatorName").html(data[0].operatorName);
			 $(".operatorPhone").html(data[0].operatorPhone);
			 $(".utinSumPeople").html(data[0].utinSumPeople);
			 //utinSumPeople = data[0].utinSumPeople;
			 /* if(data[0].utinSumPeople<5){
				alert("初次添加必须5个员工");
				for(var n=data[0].utinSumPeople;n<4	;n++){
					addAppend();
				}
			} */
		 },
		 error:function(){
			 alert(1);
		 }
	 });
};

var i = 1;
function addAppend(){
	
	var trs = "<tr>"+
	          "<td><input type='text'  class='form-control' required='required' name='list_indinfo["+i+"].trueName'/></td>"+
	          "<td><input type='text'  class='form-control' required='required' name='list_indinfo["+i+"].idnumber'/></td>"+
	          "<td><input type='text'  class='form-control' required='required' name='list_indinfo["+i+"].phoneNumber'/></td>"+
	          "<td><input type='text'  class='form-control' required='required' name='list_indinfo["+i+"].familyAddress'/></td>"+
	          "<td><input type='text'  class='form-control' required='required' name='list_indaccountinfo["+i+"].indDepositRadices'/></td>"+
	          "<td><input type='text'  class='form-control' required='required' name='list_indaccountinfo["+i+"].bankSaAccount'/></td>"+
	          "<td>"+
	          "	<select class='form-control' name='list_indaccountinfo["+i+"].bankOpenAccount'>"+
	          "		<option>中国银行</option>"+
	          "		<option>中国银行</option>"+
	          "		<option>中国银行</option>"+
	          "	</select>"+
	          "</td>"+
	          " <td>"+
	          "		<input type='radio' checked='checked'name='list_indinfo["+i+"].wedlockStatus' value='未婚'/>未婚"+
	          "		<input type='radio'name='list_indinfo["+i+"].wedlockStatus' value='已婚'/>已婚"+
	          "</td>"+
         "</tr>";
         i++;
         $("#myTby").append(trs);
};
</script>

</html>

