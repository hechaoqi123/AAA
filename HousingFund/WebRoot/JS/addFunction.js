

$(function(){
	gerPowers();
	
});
//添加
function addsubmit(){
	var myForm = $("#myForm").serialize();
   $.ajax({
	   url:"addFunction.action",
	   data:myForm,
	   type:"post",
	   dataType:"text",
	   success:function(data){
		   $("#myForm")[0].reset();
		   if(data){
			   gerPowers();
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
   
   function gerPowers(){
	     $("#tab").html("");
	     $.ajax({
	      url:"ger_Powers_Role.action",
	      data:{"getRole":null,"role.rid":null},
	      type:"post",
	      dataType:"json",
	      success:function(data){
	    	  var tr="";
	    	  for(var i=0;i<data.length;i++){
	    		  if(data[i].pid > 3)
	    		  tr = "<tr>"+
		    		  		"<td>"+data[i].pid+"</td>"+
		    		  		"<td>"+data[i].pname+"</td>"+
		    		  		"<td>"+data[i].purl+"</td>"+
		    		  		"<td>"+data[i].ptype+"</td>"+
		    		  		"<td><span class='btn btn-primary' onclick='del_Powers("+data[i].pid+")'>删除</span>&nbsp;"+
		    		  		"<span class='btn btn-primary' onclick='get_This_Powers("+data[i].pid+")' data-toggle='modal' data-target='#add_update_Powers'>修改</span></td>"+
	    		  		"</tr>";
	    		  $("#tab").append(tr);
	    	  }
	      },
	      error:function(){
	    	  alert(122);
	      }
	     });
   		}
   //删除
   function del_Powers(obj){
	   $("#tab").html("");
	   $.ajax({
		   url:"del_Prowers.action",
		   data:{"powers.pid":obj},
		   type:"post",
		   dataType:"text",
		   success:function(data){
			   if(data){
				   gerPowers();
			   }
		   },
		   error:function(HTMLHttpRequest, textStatus, errorThrown){
			   gerPowers();
			   alert("正在使用1");
			}
	   	});
   }
   function get_This_Powers(obj){
	   $.ajax({
		   url:"get_This_Powers.action",
		   data:{"powers.pid":obj},
		   type:"post",
		   dataType:"json",
		   success:function(data){
			   $(".pid").val(data.pid);
			   $(".pname").val(data.pname);
			   $(".purl").val(data.purl);
			   $(".ptype").val(data.ptype);
		   },
		   error:function(HTMLHttpRequest, textStatus, errorThrown){
			   alert("error");
			}
	   	});
	   $("#update_powers").click(function(){
		   update_powers();
	   });
	   function update_powers(){
			var myForm = $("#myFormUpdate").serialize();
		   $.ajax({
			   url:"update_powers.action",
			   data:myForm,
			   type:"post",
			   dataType:"text",
			   success:function(data){
				   if(data){
					   $("#tab").html("");
					   gerPowers();
				   }
			      //window.location.href="ajax/show.jsp";
			   },
			   error:function(HTMLHttpRequest, textStatus, errorThrown){
					alert("error");
				}
		   	});
		   };
		   
   }
   
   
  