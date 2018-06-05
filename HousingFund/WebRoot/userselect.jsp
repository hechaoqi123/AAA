<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'grxxcx.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=2">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
</head>
<style type="text/css">
.modal-body{width:550px;height:200px;
	}

	#choose{width:150px;margin-top:25px;
	        margin-right:60px;float:right;
	}
	#choose input[type="text"]{width:30px;height:20px;
	}
	#tab td,#tab th{text-align:center;
	}
	#tab{width:1100px;height:408px;margin:auto;
	}
	#container{width:1100px;height:453px;margin:auto;
	}
	.form-group{width:500px;height:30px;margin-left:80px;
	}
	.mid{margin-top:7px;float:left;
	}
	.wid{width:200px;
	}
	body{
	MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;

	}
	
	a{
	text-decoration:none;
	}
	 *{
  margin:0;
  padding:0;

 }
	li{
	list-style-type: none;
	}
	  #topmenu ul{
	   border:0px solid green;
	   width:1250px;
	   height:46px;
	   margin-left: 100px;
	  }
	  #topmenuul li:HOVER{
	  background-color:#016ec5;
	  }
	  #topmenu ul li{
	  border:0px solid black;
	  font-family:微软雅黑;
	  font-size:18px;
	  width:160px;
	  height:46px;
	  float: left;
	  color: white;
	  text-align:center;
	  line-height: 48px;
	  }
	  

	  #lunboleft{
	   border:0px solid #fff;
	  }
	  #shang{
	  width:310px;
	  height:65px;
	    border:1px solid #fff;
	    margin-top: 15px;
	  margin-left: 25px;
	  font-size: 18px;
	  line-height:125px;
	  text-align: center;
	  background:url(images/hu1.png) no-repeat;
	  }
	  	  #xia{
	  width:310px;
	  height:65px;
	     border:1px solid #fff;
	    margin-top: 15px;
	  margin-left: 25px;
	  font-size: 18px;
	  line-height:125px;
	  text-align: center;
	  
	  background:url(images/hu2.png) no-repeat;
	  }
	 
	 
	   #last ul li{
	   width:130px;

	   height:96px;
	   float: left;
	   } #last ul li img{
	 
	position: relative;
	top:20px;
	
	   }
#zong{
height:780px;
border:1px solid #000;
}
#tou{
height:200px;
border:1px solid #000;
}
#zhong{
height:376px;
background:url(images/hu3.jpg) no-repeat;
width:1190px;
margin-left:30px;
margin-top:20px;

}
#wei{
height:200px;
border:1px solid #000;
}
#myTab td{
   with:200px;
   border:1px solid #999;
}
#tr td{

}
</style>
<link rel="stylesheet" href="${path }/resource/bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"></link>
    <script type="text/javascript" src="${path }/resource/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </head>
  
 
  <div style="width: 100%;height: 805px;border: 0px solid red;">

<!-- 头部图片 -->
<div style="width:100%;height:135px;">
  <img alt="" src="images/2017112115540812702.jpg" style="height:135px;width:100%">
</div>
<!-- 头部菜单 -->
<div style="width: 100%;height:48px;background-color:#318cd4;margin-top:0px;" id="topmenu">
  <ul id="topmenuul">
  <a href="#"><li style="background-color: #016ec5">首页</li></a>
    <a href="#"><li>政务信息</li></a>
    <a href="#"><li>办事指南</li></a>
    <a href="#"><li>党建园地</li></a>
    <a href="#"><li>政策法规</li></a>
    <a href="#"><li>政民互动</li></a>
    <li style=" width:250px;"><form>
<!--     <input style="height: 30px;">
    <input type="submit" value="搜索" style="height:30px;width: 50px;"> -->
    </form></li>
  </ul>
</div>
 <div id="zhong">
  <div id="lunboleft" style="width:755px;height:250px;border:0px solid #000;margin-left:460px;padding-top:50px;">
   <%
    String ss=request.getParameter("uid");

    %>

  <input type="hidden" value="<%=ss%>" id="login">
  <input type="text" id="name" style="width:195px; height:30px;">
  <input type="button" value="搜索" onclick="shousuo()" style="width:50px; height:30px;  font-family:微软雅黑;
	  font-size:16px;
	  text-align:center;
	  line-height:30px;padding-top:-8px;">

  
  
        <table border="1" style="margin-top:5px;border-collapse:collapse;height:80px;width:728px;">
      <h4 style="margin-top:10px;">员工信息</h4>
         <tr id="tr">
            <td>员工编号</td>
          
            <td>姓名</td>
            <td>性别</td>
            <td>员工账户</td>
            <td>手机号码</td>
            <td>身份证号</td>
            <td>职务</td>
            <td>缴存基数</td>
            <td>操作</td>
           </tr>
            
         <tbody id="myTab"></tbody>
         <!--  <button onclick="add()">员工开户</button>
           <button onclick="addSubmit()">提交</button> -->
     </table>
        
 <input type="button" value="上一页" onclick="shangPage()">
         <input type="text" id="nowpage" readonly="readonly">/<input type="text" id="total" readonly="readonly"></span>
         <input type="button" value="下一页" onclick="xiaPage()">||
     <a onclick="tiao()">跳转到</a>
      <input type="text" id="na" value="0">页
      
      
</div>
</div>
<!-- 模态窗口 -->
<!--模态框 1--> 
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				  <h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<h4 style="margin-left:10px;">员工信息:</h4>
				<!--模态框主体  -->
				<div class="modal-body">  
				<table style="height:170px;">
				<tr>
			<td>员工编号:<input type="text" id="id" readonly="readonly"></td>
				<input type="hidden" id="indid" readonly="readonly">
			<td>姓名:<input type="text" id="xname"></td>
			</tr>
			<tr>
			<td>性别:<input type="text" id="sex"></td>
		<td>员工账户:<input type="text" id="indAccount" readonly="readonly"></td>
			</tr>
			<tr>
			<td>手机号码:<input type="text" id="phoneNumber"></td>
			<td>身份证号:<input type="text" id="idnumber" readonly="readonly"></td>
			</tr>
			<tr>
			<td>职务:<input type="text" id="duties"></td>
			<td>缴存基数:<input type="text" id="indDepositRadices"></td>
			<td><input type="hidden" id="uid"></td>
			 </tr>
			</table>
				</div>
				
				
				
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">关闭</button>
					<button class="btn btn-primary" id="sub" onclick="update1()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div> 
<!-- 尾部 -->
<div style="border:0px solid black; width:100%;height:220px;">

   <div style="border:0px solid black;width:100%;height:220px;background-color:#016EC5;">
    
    
     <div style="border:0px solid black;width:800px;height:200px;margin-left:220px;margin-top:0px;">
       <div style="border:0px solid black;width:800px;height:100px;color:white;font-size:10px;text-align: center;line-height: 100px; ">
       版权所有：**住房公积金管理中心 京公网安备10086 京ICP备1383838号 客服电话：10010
       </div>
       
       <div style="border:0px solid black;width:800px;height:100px;" id="last">
         <ul style="border:0px solid black;width:400px;height:100px;margin-left:200px;">
           <li><a href="#"><img alt="" src="images/blue.png" style="top:10px;left:30px;"></a> </li>
           <li><a href="#"><img alt="" src="images/jiucuo.png-v=-+sitecode+-.png"></a> </li>
           <li><a href="#"><img alt="" src="images/2018042315070456187.png"></a> </li>
         </ul>
       </div>
     </div>
     
   </div>
</div>
</div>
 
   
  </body>
</html>
<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
<script>
 var pageentity; 
   $(function(){
            showByPage(1);//初始值当前页为第一页
            showByPage(obj);
  });
  //分页
  function showByPage(obj){
    var zhi=$("#login").val();
          $("#myTab").html("");
     $.ajax({
            url:"query7.action",
            type:"post",
            data:{"utinAccountId":zhi,currPage:obj},
      dataType:"json",
      success:function(data){

                  pageentity=data;
           $("#total").val(pageentity.allPage);
           $("#nowpage").val(pageentity.currPage);
          for(var i=0;i<data.list.length;i++){
                   var tr="<tr>";
                   tr+="<td class='id'>"+data.list[i].indInfoId+"</td>";
                   tr+="<td class='indid'style='display:none'>"+data.list[i].indAccountId+"</td>";
                   tr+="<td class='name'>"+data.list[i].trueName+"</td>";
                   tr+="<td class='sex'>"+data.list[i].sex+"</td>";
                   tr+="<td class='indAccount'>"+data.list[i].indAccount+"</td>";
                   tr+="<td class='phoneNumber'>"+data.list[i].phoneNumber+"</td>";
                   tr+="<td class='idnumber'>"+data.list[i].idnumber+"</td>";
                   tr+="<td class='duties'>"+data.list[i].duties+"</td>";
                   tr+="<td class='indDepositRadices'>"+data.list[i].indDepositRadices+"</td>";
                
                   tr+="<td><button class='btn btn-primary' data-toggle='modal' data-target='#myModal' id='addBtn' onclick='update(this)'>修改员工信息</button></td>";
                 
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
      }}
     
     }); 
  }
  
  //页面跳转。
 function tiao(){   
          if(parseInt($("#na").val())>pageentity.allPage){
              showByPage(parseInt(pageentity.allPage));             
              }else if(parseInt($("#na").val())<0){
               showByPage(1);
              }else{
              showByPage(parseInt($("#na").val()));
              }
         
  }
    //上一页
  function shangPage(){
  $("#na").val(0);
     if(parseInt(pageentity.currPage)<=1){
                showByPage(1);
     }else{
          showByPage(parseInt(pageentity.currPage)-1); 
       } 
       
  }
  //下一页
  function xiaPage(){
  $("#na").val(0);
  if(parseInt(pageentity.currPage)<parseInt(pageentity.allPage)){
        showByPage(parseInt(pageentity.currPage)+1);}
   }
   //模糊查询
    function shousuo(){
      var id=$("#login").val();
      var name=$("#name").val();
          $.ajax({
             url:"query8.action",
             type:"post",
             data:{"utinAccountId":id,"indaccountinfo.indinfo.trueName":name},
             dataType:"json",
             success:function(data){
           	   
             //每次记载之前先清空当前页面的数据
                 $("#myTab").html('');
              
                    for(var i=0;i<data.length;i++){
               
                   var tr="<tr>";
                   tr+="<td class='id'>"+data[i].indInfoId+"</td>";
                   tr+="<td class='name'>"+data[i].trueName+"</td>";
                   tr+="<td class='sex'>"+data[i].sex+"</td>";
                   tr+="<td class='indAccount'>"+data[i].indAccount+"</td>";
                   tr+="<td class='phoneNumber'>"+data[i].phoneNumber+"</td>";
                   tr+="<td class='idnumber'>"+data[i].idnumber+"</td>";
                   tr+="<td class='duties'>"+data[i].duties+"</td>";
                   tr+="<td class='indDepositRadices'>"+data[i].indDepositRadices+"</td>";
                    
                   tr+="<td><button class='btn btn-primary' data-toggle='modal' data-target='#myModal' id='addBtn' onclick='update(this)'>修改员工信息</button></td>";
                   tr+="</tr>"; 
                   $("#myTab").append(tr);
      }
                   
                 
             }
          })
   }
   /*
   //添加一行
   function add(){
 var tr="<tr class='trinfo'>";
          tr+="<td><input class='id'/></td>";
          tr+="<td><input class='name'/></td>";
          tr+="<td><input class='sex'/></td>";
          tr+="<td><input class='indAccount'/></td>";
          tr+="<td><input class='phone'/></td>";
          tr+="<td><input class='idnumber'/></td>";
          tr+="<td><input class='duties'/></td>";
          tr+="<td><input class='indDepositRadices'/></td>";
          
     tr+="</tr>";
          $("#myTab").append(tr);
   
   }
    //循环获取数据
        function addSubmit(){
          var id=$("#login").val();
         
     var jsonArr=new Array();
           $(".trinfo").each(function (){
               var indInfoId=$(this).find(".id").val();
               var trueName=$(this).find(".name").val();
               var sex=$(this).find(".sex").val();
               var indAccount=$(this).find(".indAccount").val();
               var phoneNumber=$(this).find(".phone").val();
               var idnumber=$(this).find(".idnumber").val();
               var duties=$(this).find(".duties").val();
               var indDepositRadices=$(this).find(".indDepositRadices").val();//添加第一个表
               var josnStr={"indinfo.indInfoId":indInfoId,"utinaccountinfo.utinAccountId":id,"indinfo.trueName":trueName,"indinfo.sex":sex,"indinfo.indAccount":indAccount,"indinfo.phoneNumber":phoneNumber,"indinfo.idnumber":idnumber,"indinfo.duties":duties,"indDepositRadices":indDepositRadices};
               jsonArr.push(josnStr);
           });
            $.ajax({
             url:"add.action",
             type:"post",
             dataType:"json",
             data:{"jsonArr":JSON.stringify(jsonArr)},
             success:function(data){
             alert("添加成功")
                 //window.location.href="roleList.jsp";
             },error:function(){
                 alert("sss");
           
           }
           })
           } */
   //先查询要修改的数据
       function update(obj){
var id=$(obj).parent().parent().find(".id").html();
var name=$(obj).parent().parent().find(".name").html();
var sex=$(obj).parent().parent().find(".sex").html();
var indAccount=$(obj).parent().parent().find(".indAccount").html();
var phoneNumber=$(obj).parent().parent().find(".phoneNumber").html();
var idnumber=$(obj).parent().parent().find(".idnumber").html();
var duties=$(obj).parent().parent().find(".duties").html();
var indDepositRadices=$(obj).parent().parent().find(".indDepositRadices").html();
var uid=$("#login").val();
var indid=$(obj).parent().parent().find(".indid").html();
$("#uid").val(uid);
$("#indid").val(indid);
$("#id").val(id);
$("#xname").val(name);
$("#sex").val(sex);
$("#indAccount").val(indAccount);
$("#phoneNumber").val(phoneNumber);
$("#idnumber").val(idnumber);
$("#duties").val(duties);
$("#indDepositRadices").val(indDepositRadices);
}

  function update1(){
  var id=$("#id").val();
var xname=$("#xname").val();

var sex=$("#sex").val();
var phoneNumber=$("#phoneNumber").val();
var duties=$("#duties").val();
var indDepositRadices=$("#indDepositRadices").val();
var indid=$("#indid").val();
var uid=$("#uid").val();

          $.ajax({
             url:"update.action",
             type:"post",
             data:{
             "indinfo.indInfoId":id,
             "indinfo.trueName":xname,
             "indinfo.sex":sex,
             "indinfo.phoneNumber":phoneNumber,
             "indinfo.duties":duties,
             "indAccountId":indid,
             "indDepositRadices":indDepositRadices},
             dataType:"json",
             success:function(data){
             	 showByPage(1);
             	 
             },error:function(){
               alert("XX");
             }
          })
   }
</script>