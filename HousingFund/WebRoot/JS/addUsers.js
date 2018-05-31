

$(function(){
	gerUsers();
	
});
//添加
function addsubmit(){
	var myForm = $("#myForm").serialize();
   $.ajax({
	   url:"addUsers.action",
	   data:myForm,
	   type:"post",
	   dataType:"text",
	   success:function(data){
		   $("#myForm")[0].reset();
			   gerUsers();
	      //window.location.href="ajax/show.jsp";
	   },
	   error:function(HTMLHttpRequest, textStatus, errorThrown){
			alert(HTMLHttpRequest.status);
			alert(HTMLHttpRequest.readyState);
			alert(textStatus);
		}
   	});
   };
   
   function gerUsers(){
	     $("#tab").html("");
	     $.ajax({
	      url:"get_UsersAll.action",
	      type:"post",
	      dataType:"json",
	      success:function(data){
	    	  var tr="";
	    	  for(var i=0;i<data.length;i++){
	    		  if(data[i].ustatic==1){data[i].ustatic='正常';};
	    		  if(data[i].ustatic==2){data[i].ustatic='冻结';};
	    		  if(data[i].uid > 1)
	    		  tr = "<tr>"+
		    		  		"<td>"+data[i].uid+"</td>"+
		    		  		"<td>"+data[i].uname+"</td>"+
		    		  		"<td>"+data[i].unum+"</td>"+
		    		  		"<td>"+data[i].upass+"</td>"+
		    		  		"<td>"+data[i].udescription+"</td>"+
		    		  		"<td>"+data[i].ustatic+"</td>"+
		    		  		"<td>"+data[i].urname+"</td>"+
		    		  		"<td><span class='btn btn-primary' onclick='del_Users("+data[i].uid+")'>删除</span>&nbsp;"+
		    		  		"<span class='btn btn-primary' onclick='get_This_Users("+data[i].uid+")' data-toggle='modal' data-target='#add_update_Users'>修改</span></td>"+
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
   function del_Users(obj){
	   $("#tab").html("");
	   $.ajax({
		   url:"del_Users.action",
		   data:{"users.uid":obj},
		   type:"post",
		   dataType:"text",
		   success:function(data){
				   gerUsers();
		   },
		   error:function(HTMLHttpRequest, textStatus, errorThrown){
			   gerUsers();
			   alert("正在使用");
			}
	   	});
   }
   //获取一个用户
   function get_This_Users(obj){
	   $.ajax({
		   url:"get_This_Users.action",
		   data:{"users.uid":obj},
		   type:"post",
		   dataType:"json",
		   success:function(data){
			   $(".uid").val(data[0].uid);
			   $(".uname").val(data[0].uname);
			   $(".unum").val(data[0].unum);
			   $(".upass").val(data[0].upass);
			   $(".udescription").val(data[0].udescription);
			   $(".ustatic").val(data[0].ustatic);
			   $(".urid").val(data[0].urid);
			   $(".urname").html(data[0].urname);
			   gerRole();
		   },
		   error:function(HTMLHttpRequest, textStatus, errorThrown){
			   alert("error");
			}
	   	});
	   //下拉框改变时获取值、、
	   $(".getUrid").change(function(){
		   var select = $('.getUrid option:selected');
		   var selectValue = select.val();
		   var selectedText = select.text();
		   $(".urid").val(selectValue);
		   $(".urname").html(selectedText);
		   
	   });
	   //获取所有的角色
	   function gerRole(){
		     $(".getUrid").html("");
		     $.ajax({
		      url:"ger_All_Role.action",
		      type:"post",
		      dataType:"json",
		      success:function(data){
		    	  var opn="";
		    	  for(var i=0;i<data.length;i++){
		    		  if(data[i].rid>1)
		    		  opn = "<option value="+data[i].rid+">"+data[i].rname+"</option>"+
		    		  $(".getUrid").append(opn);
		    	  }
		    	  data = null;
		      },
		      error:function(){
		    	  alert(1);
		      }
		     });
	   		}
	   
	   //点击事件不能使用
	   $("#update_users").click(function(){
		   update_users();
	   });
	   function update_users(){
			var myForm = $("#myFormUpdate").serialize();
		   $.ajax({
			   url:"update_users.action",
			   data:myForm,
			   type:"post",
			   dataType:"text",
			   success:function(data){
				   $("#tab").html("");
				   gerUsers();
			   },
			   error:function(HTMLHttpRequest, textStatus, errorThrown){
					alert("error");
				}
		   	});
		   };
		   
   }
   
   
  