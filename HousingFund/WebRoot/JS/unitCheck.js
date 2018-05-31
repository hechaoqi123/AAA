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
	      		  if(data[i].accountStatus == "审核中"){
		      		  tr = "<tr>"+
		   	    		  		"<td>"+data[i].utinAccountId+"</td>"+
		   	    		  		"<td>"+data[i].utinName+"</td>"+
		   	    		  		"<td>"+data[i].operatorName+"</td>"+
		   	    		  		"<td>"+data[i].accountStatus+"</td>"+
		   	    		  		"<td><span class='btn btn-primary' onclick='get_one_Utinaccountinfo("+data[i].utinAccountId+")' data-toggle='modal' data-target='#get_one_Utinaccountinfo'>详细信息</span></td>"+
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
 function get_one_Utinaccountinfo(obj){
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
			 $(".operatorIdnumber").html(data[0].operatorIdnumber);
			 $(".bankName").html(data[0].bankName);
			 $(".utinAccountId").val(data[0].utinAccountId);
			 $(".utinFoundDate").html(new Date(data[0].utinFoundDate).toLocaleDateString());
		 },
		 error:function(){
			 alert(1);
		 }
		 
	 });
 }
 
 $("#update_utinAccount").click(function(){
	 var bool = true;
	 var accountStatus = $("input:radio[name='accountStatus']:checked").val();
	 if(accountStatus == "通过审批")
	 bool = confirm("是否确认材料通过");
	 if(accountStatus == "驳回")
		 bool = confirm("是否确认材料驳回");
	 if(bool){
		 var utinAccountId = $(".utinAccountId").val();
		 $.ajax({
			 url:"update_utinAccount.action",
			 data:{"utinaccountinfo.utinAccountId":utinAccountId, "utinaccountinfo.accountStatus":accountStatus},
			 type:"post",
			 dataType:"json",
			 success:function(data){
				 getUtinaccountinfo();
			 },
			 error:function(){
				 alert(1);
			 }
		 });
	 } else{
		 window.location.href = "BackJsp/LDL/unitCheck.jsp";
	 }
 });
 
 