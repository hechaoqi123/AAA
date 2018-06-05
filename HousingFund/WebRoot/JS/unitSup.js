$(function(){
	getUtinaccountinfo();
});
function getUtinaccountinfo(){
	  $("#tab").html("");
	    $.ajax({
	     url:"getUtinaccountinfo.action",
	     type:"post",
	     dataType:"json",
	     success:function(data){
	    	 var tr="";
	      	  for(var i=0;i<data.length;i++){
	      		  if(data[i].accountStatus == "正常"){
		      		  tr = "<tr>"+
		   	    		  		"<td>"+data[i].utinAccountId+"</td>"+
		   	    		  		"<td>"+data[i].utinName+"</td>"+
		   	    		  		"<td>"+data[i].utinSumPeople+"</td>"+
		   	    		  		"<td>"+data[i].utinDepositPeople+"</td>"+
		   	    		  		"<td>"+data[i].utinSealPeople+"</td>"+
		   	    		  		"<td>"+data[i].utinProvRema+"</td>"+
		   	    		  		"<td>"+data[i].accountStatus+"</td>"+
		   	    		  		"<td><a class='btn btn-primary' href='getUtinSup.action?utinaccountinfo.utinAccountId="+data[i].utinAccountId+"'>修改信息</a>&nbsp;</td>"+
		      		  		"</tr>";
		      		  $("#tab").append(tr);
	      		  }
	      	  }
	     },
		error:function(){
			alert("获取全部错误");
		}
		
	});
}


function getFuzzy(){
	 var utinName = $(".ss").val();
	 if(utinName=="输入单位名称"){utinName=="";}
	 $(".ss").val("");
	 $("#tab").html("");
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
		   	    		  		"<td>"+data[i].utinSumPeople+"</td>"+
		   	    		  		"<td>"+data[i].utinDepositPeople+"</td>"+
		   	    		  		"<td>333</td>"+
		   	    		  		"<td>"+data[i].utinProvRema+"</td>"+
		   	    		  		"<td>"+data[i].accountStatus+"</td>"+
		   	    		  		"<td><a class='btn btn-primary' href='getEmp.action?utinaccountinfoID="+data[i].utinAccountId+"'>点击进入</a>&nbsp;</td>"+
		      		  		"</tr>";
		      		  $("#tab").append(tr);
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
