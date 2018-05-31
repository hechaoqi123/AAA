
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
				          " <td><input type='number' class='form-control indDepositRadices' name='indaccountinfo.indDepositRadices' value='"+data[i].indDepositRadices+"'> </td>"+
				          " <td>"+data[i].presentSumRem+"</td>"+
				          " <td>"+data[i].usableRem+"</td>"+
				          " <td class='indStatus"+data[i].indAccountId+"'>"+data[i].indStatus+"</td>"+
				          " <td>";
					      tr += "<input type='button' class='btn btn-primary' name='"+data[i].indAccountId+"' onclick='delEmp("+data[i].indAccountId+")' value='删除'>";
				          tr += "<a href='getEmpinfo.action?indaccountinfo.indAccountId="+data[i].indAccountId+"' class='btn btn-primary' >修改信息</a>"+
				            "</td>"+
			         	"</tr>";
				           	$("#tbs").append(tr);
			}
		}
	});
}

function delEmp(obj){
	$.ajax({
		url:"delEmp.action",
		type:"post",
		data:{"indaccountinfo.indAccountId":obj},
		dataType:"json",
		success:function(data){
			if(data==0){
				alert("账户正在使用中");
			}
			getFuzzyEmp();
		}
	});
}

