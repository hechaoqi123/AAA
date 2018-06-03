
 $(document).ready(function () {
	 $(".addUtitinfoForm").validate({
		 rules:{
			 "utitinfo.utinName":{
				 required: true,
				 utinName:true
			 },
			 "utitinfo.corpRepr":{
				 required: true,
				 nameTest: true
			 },
			 "utitinfo.operatorName":{
				 required: true,
				 nameTest: true
			 },
			 "utitinfo.operatorPhone":{
				 required: true,
				 phoneTest: true
			 },
			 "utitinfo.operatorIdnumber":{
				 required: true,
				 idNumTest: true
			 },
			 "utitinfo.utinAddress":{
				 required: true,
				 utinName: true
			 },
			 "utinaccountinfo.utinDepositRatio":{
				 required: true,
				 min:1,
				 max:12
			 },
			 "utitinfo.utinFoundDate":{
				 required: true,
				 dateISO:true
			 },
			 "stringTest" :{
				 required: true,
				 stringTest:true,
				 minlength:6
			 },
			 "names" :{
				 required: true,
				 nameTest:true
			 },
			 "emails" :{
				 required: true,
				 email:true
			 },
			 "youb" :{
				 required: true,
				 minlength:6,
				 maxlength:6,
				 digits:true
			 }
		 }
		
	 });
	 $("#FormsaveIndaccountinfo").validate({
		 rules:{
			 "list_indinfo[0].trueName":{
				 required: true,
				 utinName:true
			 },
			 "list_indinfo[0].idnumber":{
				required: true,
				idNumTest:true
			 },
			 "list_indinfo[0].phoneNumber":{
				 phoneTest:true
			 },
			 "list_indaccountinfo[0].bankSaAccount":{
				 required: true,
				 creditcard:true
			 },
			 "list_indinfo[0].familyAddress":{
				 required: true,
				 utinName:true
			 },
			 "emails" :{
				 required: true,
				 email:true
			 },
			 "youb" :{
				 required: true,
				 minlength:6,
				 maxlength:6,
				 digits:true
			 }
		 },
	 message:{
		 "list_indaccountinfo[0].bankSaAccount":{
			 creditcard:" 必须输入合法的信用卡号。"
		 },
	 }
		 
	 });
	 //验证公司姓名
	 $.validator.addMethod("utinName", function(value){
         var postcode = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
         return postcode.test(value);
     }, $.validator.format("请填写中文、英文、数字组合"));
	 //姓名验证
	 $.validator.addMethod("nameTest", function(value){
		 var postcode = /[\u4e00-\u9fa5]/;
		 return postcode.test(value);
	 }, $.validator.format("请填写中文"));
	 //联系方式验证
	 $.validator.addMethod("phoneTest", function(value){
		 var postcode = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
		 return postcode.test(value);
	 }, $.validator.format("请填写正确的号码"));
	 //证件号码
	 $.validator.addMethod("idNumTest", function(value){
		 var postcode = /^\d{15}|\d{18}$/;
		 return postcode.test(value);
	 }, $.validator.format("请填写正确的身份证号码"));
	 //由数字和26个英文字母组成
	 $.validator.addMethod("stringTest", function(value){
		 var postcode = /^^[A-Za-z0-9]+$/;
		 return postcode.test(value);
	 }, $.validator.format("由数字和26个英文字母组成"));
	 //银行卡号验证
	 $.validator.addMethod("YinhkTest", function(value){
		 var postcode = /^([1-9]{1})(\d{14}|\d{18})$/;
		 return postcode.test(value);
	 }, $.validator.format("请输入正确的银行卡号"));
 });

var utinNameBoolent = false;

$(".utinName").blur(function (){
	var utinName = $(this).val();
	$.ajax({
		url:"selutinName.action",
		type:"post",
		data:{"utitinfo.utinName":utinName},
		dataType:"json",
		success:function(data){
			if(data){
				$(".utinName").css("color","red");
				 $(".utinName").val("该公司已经存在");
			}else{
				utinNameBoolent = true;
			}
		}
	});
});

$(".addUtitinfoForm").submit(function(){
	if(utinNameBoolent){
		return true;
	}else{
		 alert("信息不完整！");
		return false;
	}
});

$(".static").focus(function(){
	$(this).val("正常");
});