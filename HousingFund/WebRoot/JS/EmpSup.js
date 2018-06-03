﻿
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
				var tr =  "<tr>"+
			          	  " <td>"+data[i].indAccountId+"</td>"+
				          " <td>"+data[i].trueName+"</td>"+
				          " <td>"+data[i].duties+" </td>"+
				          " <td><input type='number' class='form-control indDepositRadices' name='indaccountinfo.indDepositRadices' value='"+data[i].indDepositRadices+"' readonly='readonly'> </td>"+
				          " <td>"+data[i].presentSumRem+"</td>"+
				          " <td>"+data[i].usableRem+"</td>"+
				          " <td class='indStatus"+data[i].indAccountId+"'>"+data[i].indStatus+"</td>"+
				          " <td>";
						  if(data[i].indStatus != "冻结"){
							  tr += "<input type='button' class='btn btn-primary' name='"+data[i].indAccountId+"' onclick='frozenEmp("+data[i].indAccountId+")' value='冻结'>";
						  }else{
							  tr += "<input type='button' class='btn btn-primary' name='"+data[i].indAccountId+"' onclick='thawEmp("+data[i].indAccountId+")' value='解冻'>";
						  };
				          tr += "<a href='getEmpinfo.action?indaccountinfo.indAccountId="+data[i].indAccountId+"' class='btn btn-primary' >修改信息</a>"+
				            "</td>"+
			         	"</tr>";
				           	$("#tbs").append(tr);
			}
		}
	});
}

function frozenEmp(obj){
	var bool = confirm("是否确认冻结该账户");
	if(bool){
		$.ajax({
			url:"frozenEmp.action",
			type:"post",
			data:{"indaccountinfo.indAccountId":obj},
			dataType:"json",
			success:function(data){
				if(data==0){
					alert("账户正在使用中");
				}
				getFuzzyEmp(0);
			}
		});
	}else{
		getFuzzyEmp(0);
	}
}
function thawEmp(obj){
	var bool = confirm("是否解冻该账户");
	if(bool){
		$.ajax({
			url:"thowEmp.action",
			type:"post",
			data:{"indaccountinfo.indStatus":"冻结","indaccountinfo.indAccountId":obj},
			dataType:"json",
			success:function(data){
				if(data==0){
					alert("账户正在使用中");
				}
				getFuzzyEmp(0);
			}
		});
	}else{
		getFuzzyEmp(0);
	}
}

