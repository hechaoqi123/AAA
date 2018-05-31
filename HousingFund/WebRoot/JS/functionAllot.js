

$(function(){
	gerRole();
	
});
//获取角色
 function gerRole(){
	 
	     $("#tab").html("");
	     $.ajax({
	      url:"ger_All_Role.action",
	      type:"post",
	      dataType:"json",
	      success:function(data){
	    	  var tr="";
	    	  for(var i=0;i<data.length;i++){
	    		  if(data[i].rid > 1)
	    		  tr = "<tr onclick='getTr("+data[i].rid+")' data-toggle='modal' data-target='#function_allot'>"+
		    		  		"<td>"+data[i].rname+"</td>"+
		    		  		"<td>"+data[i].rtype+"</td>"+
	    		  		"</tr>";
	    		  $("#tab").append(tr);
	    	  }
	    	  data = null;
	      },
	      error:function(){
	    	  alert(1);
	      }
	     });
   		} 
 //获取方法
 function ger_Powers_Role(obj){
	  $("#tabs").html("");
     $.ajax({
      url:"ger_Powers_Role.action",
      data:{"getRole":"getRole","role.rid":obj},
      type:"post",
      dataType:"json",
      success:function(data){
    	  var tr="";
    	  for(var i=0;i<data.length;i++){
    		  tr = "<tr onclick='getTr_role_del("+data[i].pid+")'>"+
	    		  		"<td>"+data[i].pname+"</td>"+
    		  		"</tr>";
    		  $("#tabs").append(tr);
    	  }
      },
      error:function(){
    	  alert(1);
      }
     });
     ger_Powers_NoRole(obj);
	}
 function ger_Powers_NoRole(obj){
		  $("#tabsNo").html("");
	     $.ajax({
	      url:"ger_Powers_Role.action",
	      data:{"getRole":"getNoRole","role.rid":obj},
	      type:"post",
	      dataType:"json",
	      success:function(data){
	    	  var tr="";
	    	  for(var i=0;i<data.length;i++){
	    		  if(data[i].pid > 3)
	    		  tr = "<tr onclick='getTr_role_add("+data[i].pid+")'>"+
		    		  		"<td>"+data[i].pname+"</td>"+
	    		  		"</tr>";
	    		  $("#tabsNo").append(tr);
	    	  }
	      },
	      error:function(){
	    	  alert(1);
	      }
	     });
		}
 //将方法增加到角色
 function getTr_role_add(obj){
	 $.ajax({
		 url:"getTr_role_add.action",
		 tyoe:"post",
		 data:{"rid":roleid,"pid":obj},
		 dataType:"json",
		 success:function(data){
			  ger_Powers_NoRole(roleid);
			  ger_Powers_Role(roleid);
		 },
		 error:function(){
			 alert("getTr_role_add错误");
		 }
	 });
 }
 function getTr_role_del(obj){
	 $.ajax({
		 url:"getTr_role_del.action",
		 tyoe:"post",
		 data:{"rid":roleid,"pid":obj},
		 dataType:"json",
		 success:function(data){
			 ger_Powers_NoRole(roleid);
			 ger_Powers_Role(roleid);
		 },
		 error:function(){
			 alert(1);
		 }
	 });
 }
 //获取需要的对象
 var roleid;
function getTr(obj){
	roleid = obj;
	 $.ajax({
		   url:"get_This_Role.action",
		   data:{"role.rid":obj},
		   type:"post",
		   dataType:"json",
		   success:function(data){
			   $(".myName").html("&nbsp;&nbsp;"+data.rname);
		   }
		  });
	 ger_Powers_Role(obj);
	
}
