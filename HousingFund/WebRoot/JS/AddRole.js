

$(function(){
	gerRole();
	
});
//添加
function addsubmit(){
	var myForm = $("#myForm").serialize();
   $.ajax({
	   url:"addRole.action",
	   data:myForm,
	   type:"post",
	   dataType:"text",
	   success:function(data){
		   $("#myForm")[0].reset();
		   if(data){
			   gerRole();
		   }
	      //window.location.href="ajax/show.jsp";
	   },
	   error:function(HTMLHttpRequest, textStatus, errorThrown){
			alert(HTMLHttpRequest.status);
			alert(HTMLHttpRequest.readyState);
			alert(textStatus);
		}
   	});
   };
   
   function gerRole(){
	     $("#tab").html("");
	     $.ajax({
	      url:"ger_All_Role.action",
	      type:"post",
	      dataType:"json",
	      success:function(data){
	    	  $("#tab").html("");
	    	  var tr="";
	    	  for(var i=0;i<data.length;i++){
	    		  if(data[i].rid>1)
	    		  tr = "<tr>"+
		    		  		"<td>"+data[i].rid+"</td>"+
		    		  		"<td>"+data[i].rname+"</td>"+
		    		  		"<td>"+data[i].rtype+"</td>"+
		    		  		"<td><span class='btn btn-primary' onclick='del_Role("+data[i].rid+")'>删除</span>&nbsp;"+
		    		  		"<span class='btn btn-primary' onclick='get_This_Role("+data[i].rid+")' data-toggle='modal' data-target='#add_update_Role'>修改</span></td>"+
	    		  		"</tr>";
	    		  $("#tab").append(tr);
	    	  }
	      },
	      error:function(){
	    	  alert(1);
	      }
	     });
   		}
   //删除
   function del_Role(obj){
 	   $.ajax({
		   url:"del_Role.action",
		   data:{"role.rid":obj},
		   type:"post",
		   dataType:"text",
		   success:function(data){
			   if(data){
				   gerRole();
			   }
		   },
		   error:function(HTMLHttpRequest, textStatus, errorThrown){
			   alert("存在关联关系");
			}
	   	});
   }
   function get_This_Role(obj){
	   $.ajax({
		   url:"get_This_Role.action",
		   data:{"role.rid":obj},
		   type:"post",
		   dataType:"json",
		   success:function(data){
			   $(".rid").val(data.rid);
			   $(".rname").val(data.rname);
			   $(".rtype").val(data.rtype);
		   },
		   error:function(HTMLHttpRequest, textStatus, errorThrown){
			   alert("error");
			}
	   	});
	   $("#update_Role").click(function(){
		   update_Role();
	   });
	   function update_Role(){
			var myForm = $("#myFormUpdate").serialize();
		   $.ajax({
			   url:"update_Role.action",
			   data:myForm,
			   type:"post",
			   dataType:"text",
			   success:function(data){
				   if(data){
					   gerRole();
				   }
			      //window.location.href="ajax/show.jsp";
			   },
			   error:function(HTMLHttpRequest, textStatus, errorThrown){
					alert("error");
				}
		   	});
		   };
		   
   }
   
   
  