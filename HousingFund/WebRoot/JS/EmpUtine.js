
$(function(){
	getFuzzyEmp(0);
});
function getFuzzyEmp(obj){
	var trueName = $(".trueName").val();
	if(trueName=="输入员工姓名"){
		trueName = "";
	}
	$("#tbs").html("");
	$.ajax({
		url:"getFuzzyEmp.action",
		type:"post",
		data:{"utinaccountinfoID":obj,"indaccountinfo.indinfo.trueName":trueName},
		dataType:"json",
		success:function(data){
			for(var i=0;i<data.length;i++){
				if(data[i].indStatus == "封存"){
				var tr =  "<tr>"+
			          	  " <td>"+data[i].indAccountId+"</td>"+
				          " <td>"+data[i].trueName+"</td>"+
				          " <td>"+data[i].duties+" </td>"+
				          " <td><input type='number' class='form-control indDepositRadices' name='indaccountinfo.indDepositRadices' value='"+data[i].indDepositRadices+"' readonly='readonly'> </td>"+
				          " <td>"+data[i].presentSumRem+"</td>"+
				          " <td>"+data[i].usableRem+"</td>"+
				          " <td class='indStatus"+data[i].indAccountId+"'>"+data[i].indStatus+"</td>"+
				          " <td>";
				          tr += "<buttion onclick='UtinegetOneEmp("+data[i].indAccountId+")' class='btn btn-primary' data-toggle='modal' data-target='#EmpUtine'>账户转移</buttion>"+
				          "</td>"+
			         	"</tr>";
				           	$("#tbs").append(tr);
				}
			}
		}
	});
}

function UtinegetOneEmp(obj){
	 $.ajax({
		 url:"UtinegetOneEmp.action",
		 type:"post",
		 data:{"indaccountinfo.indAccountId":obj},
		 dataType:"json",
		 success:function(data){
			 $(".indAccountId").val(data[0].indAccountId);
			 $(".trueName").val(data[0].trueName);
			 $(".utinName").val(data[0].utinName);
		 }
	 });
};


function getFuzzy(){
	 var utinName = $("#utinName").val();
	 $("#myTbo").html("");
	    $.ajax({
	     url:"getFuzzy.action",
	     type:"post",
	     data:{"utinaccountinfo.unitinfo.utinName":utinName},
	     dataType:"json",
	     success:function(data){
	    	 var tr="";
	      	  for(var i=0;i<data.length;i++){
	      		  if(data[i].accountStatus == "正常"){
		      		  tr = "<tr>"+
		   	    		  		"<td>"+data[i].utinAccountId+"</td>"+
		   	    		  		"<td>"+data[i].utinName+"</td>"+
		   	    		  		"<td><input type='button' class='but' onclick='setUtine(this)' name='"+data[i].utinName+"' id='"+data[i].utinAccountId+"' value='选择'/></td>"+
		      		  		"</tr>";
		      		  $("#myTbo").append(tr);
	      		  }
	      	  }
	     },
	     error:function(HTMLHttpRequest, textStatus, errorThrown){
				alert(HTMLHttpRequest.status);
				alert(HTMLHttpRequest.readyState);
				alert(textStatus);
			}
		
	});
}

function setUtine(obj){
	var utinAccountId = obj.id;
	var utinName = obj.name;
	$(".utinId").val(utinAccountId);
	$(".utinNames").val(utinName);
	$("#utinName").val("");
	$("#myTbo").html("");
}