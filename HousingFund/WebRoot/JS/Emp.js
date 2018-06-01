var href = decodeURI(subStr(window.location.href).utinaccountinfoID);
$(function(){
	get_one_Utinaccountinfo(href);
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

	
function get_one_Utinaccountinfo(obj){
	$(".utinid").val(obj);
	 $.ajax({
		 url:"get_one_Utinaccountinfo.action",
		 data:{"accountId":obj},
		 type:"post",
		 dataType:"json",
		 success:function(data){
			 $(".utinName").html(data[0].utinName);
			 $(".utinAddress").html(data[0].utinAddress);
			 $(".corpRepr").html(data[0].corpRepr);
			 $(".operatorName").html(data[0].operatorName);
			 $(".operatorPhone").html(data[0].operatorPhone);
			 $(".utinDepositRatio").html(data[0].utinDepositRatio);
		 },
		 error:function(){
			 alert(1);
		 }
	 });
};

//修改基数
$(".indDepositRadices").blur(function(){
	var indAccountId = $(this).attr("name");
	var Ids = "indStatus"+indAccountId;
	var indDepositRadices = indDepositRadices = $(this).val();
	var tests = /^([1-9][0-9]*)+(.[0-9]{1,2})?$/;
	if(tests.test(indDepositRadices)){
		$.ajax({
			url:"updateRadices.action",
			type:"post",
			data:{"indaccountinfo.indAccountId":indAccountId, "indaccountinfo.indDepositRadices":indDepositRadices}
		});
	}else{
		alert("输入错误");
	}
});
/*
function updateRadices(obj){
	$.ajax({
		url:"updateRadices.action",
		type:"post",
		data:{"indaccountinfo.indAccountId":obj, "indaccountinfo.indDepositRadices":indDepositRadices}
	});
};*/
//账号封存
function updateRadicesSeal(obj){
	var valSeal = obj.value;
	var Ids = "indStatus"+obj.name;
	if(valSeal=="正常"){
		obj.value="封存";
		$.ajax({
			url:"updateRadices.action",
			type:"post",
			data:{"indaccountinfo.indAccountId":obj.name, "indaccountinfo.indStatus":"正常"}
		});
		$("."+Ids).html("正常");
	};
	if(valSeal=="封存"){
		obj.value="正常";
		$.ajax({
			url:"updateRadices.action",
			type:"post",
			data:{"indaccountinfo.indAccountId":obj.name, "indaccountinfo.indStatus":"封存"}
		});
		$("."+Ids).html("封存");
	};
};
function getFuzzyEmp(){
	var utinid = $(".utinid").val();
	var trueName = $(".trueName").val();
	$("#tbs").html("");
	$.ajax({
		url:"getFuzzyEmp.action",
		type:"post",
		data:{"utinaccountinfoID":utinid,"indaccountinfo.indinfo.trueName":trueName},
		dataType:"json",
		success:function(data){
			for(var i=0;i<data.length;i++){
				var tr =  "<tr>"+
			          	  " <td>"+data[i].indAccountId+"</td>"+
				          " <td>"+data[i].trueName+"</td>"+
				          " <td>"+data[i].duties+" </td>"+
				          " <td><input type='number' class='form-control indDepositRadices' name='"+data[i].indAccountId+"' value='"+data[i].indDepositRadices+"'> </td>"+
				          " <td>"+data[i].presentSumRem+"</td>"+
				          " <td>"+data[i].usableRem+"</td>"+
				          " <td class='indStatus"+data[i].indAccountId+"'>"+data[i].indStatus+"</td>"+
				          " <td>";
				          if(data[i].indStatus == '正常'){
				        	 tr += "<input type='button' class='btn btn-primary' name='Indaccountinfo.indAccountId' onclick='updateRadicesSeal(this)' value='封存'>";
				          }
				          if(data[i].indStatus == '封存'){
					         tr += "<input type='button' class='btn btn-primary' name='Indaccountinfo.indAccountId' onclick='updateRadicesSeal(this)' value='正常'>";
					      }
				          
				           	tr += "<input type='button' class='btn btn-primary'  value='修改基数'>"+
				            "</td>"+
			         	"</tr>";
				           	$("#tbs").append(tr);
			}
		}
	});
}