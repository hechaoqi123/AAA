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
		   	    		  		"<td>"+data[i].utinProvRema+"</td>"+
		   	    		  		"<td>"+data[i].accountStatus+"</td>"+
		   	    		  		"<td>" +
			   	    		  		"<span class='btn btn-primary' onclick='addEmployeeOpen("+data[i].utinAccountId+")'>员工开户</span>" +
			   	    		  	"</td>"+
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
var ids;
function addEmployeeOpen(obj){
	//var bool = confirm("是否多添加");
	window.location.href = "BackJsp/LDL/employeeOpenImpls.jsp?ids="+obj;
/*	 if(bool){
	 }else{
		 window.location.href = "BackJsp/LDL/employeeOpenImpl.jsp?ids="+obj;
	 }*/
}
/**/
function getFuzzy(){
	 var utinName = $(".ss").val();
	 if(utinName=="输入单位名称"){
		 utinName=="%";
		 }
	 alert(utinName);
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
		   	    		  		"<td>"+data[i].utinProvRema+"</td>"+
		   	    		  		"<td>"+data[i].accountStatus+"</td>"+
		   	    		  		"<td>" +
			   	    		  		"<span class='btn btn-primary' onclick='addEmployeeOpen("+data[i].utinAccountId+")'>员工开户</span>" +
			   	    		  	"</td>"+
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

