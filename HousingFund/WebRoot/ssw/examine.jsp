<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提取审批</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="<%=basePath%>bootstrap/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath%>bootstrap/bootstrap.min.js"></script>
  
  <style>"WebRoot/JS/jquery-1.10.2.min.js"
  body{
  font-family:宋体;
  }
  #tab{
   border-collapse:collapse;
  }
   .times{
  width:300px;
  }
  .sp{
  width:100px;
  color:#FF2525;
  }
  .inp{
  width:100px;
  height:30px;
  }
  #tab td{
  width:200px;
  border:1px solid black;
  text-align:center;
  height:30px;
  }
 
 .modal-content{
 margin-left:-50px;
  width:800px;
 }
 input{
 text-align: center;
 }
  .modal-body{
   width:800px;
   border:1px solid black;
   border-collapse: collapse;
   } 
    .modal-body table td{
    width:150px;
    height:50px;
    border:1px solid black;
    text-align: center;
    line-height:50px;
    } 
      .tto{
    width:200px;
    height:50px;
    border-top:0px;
    border-left:0px;
    border-right:0px;
    border-bottom:0px solid black;
    text-align: center;
    } 
    #shaddress,#puText{
     border-top:0px;
    border-left:0px;
    border-right:0px;
    border-bottom:0px solid black;
    width:600px;
    height:50px;
    }
    
    #pumoney, #puAddress{
    
    width:180px;
    height:50px;
    }
    #recnum{
    width:350px;height:50px;
    }
    #ffgg{
    border-bottom: 1px solid black;
    border-left: 0px;
    border-top: 0px;
    border-right: 0px;
    }
 
  
  </style>
  
  </head>
  
  <body>
  
<!-- 模态框（Modal） -->
<!--  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
           
         <div class="modal-body">
           
         </div>
           
        </div>/.modal-content
    </div>/.modal
</div>  -->


   <table id="tab">
   <tr style="background-color:#BFDCEC">
  <td>个人账户</td>
  <td>申请人姓名</td>
  <td class="tiems">申请时间</td>
  <td>开户银行</td>
  <td>银行账户</td>
  <td>账户姓名</td>
  <td>提取金额</td>
  <td>审批状态</td>
  <td style="width:100px">操作</td>
  </tr>
   
   <tbody id="twot">
     
   </tbody>
   </table>
  
     
  
  </body>
</html>
<script>

$(
function(){
gggg(1,0);
}
);

  
function  gggg(dian,what){
	$("#twot").html("");
	if(what==1){
		if(dian-1==0){
		dian=1;
		}else{
		dian=dian-1;
		}

	}else if(what==2){

	dian=dian+1;
	}
 $.ajax({
   url:"sele_ex.action",
   type:"post",
   data:{"page.currPage":dian},
   dataType:"json",
   success:function(data){
  	
   var tab="";
  
   for(var i=0;i<data.list.length;i++){
    tab+="<tr>";
    tab+="<td>"+data.list[i].IndAccountID+"</td>";
    tab+="<td>"+data.list[i].workersName+"</td>";
    tab+="<td class='tiems'>"+new Date(data.list[i].applicationtime).toLocaleDateString()+"</td>";
    tab+="<td>"+data.list[i].bankOfDeposit+"</td>";
    tab+="<td>"+data.list[i].collectionAccount+"</td>";
    tab+="<td>"+data.list[i].payee+"</td>";
    tab+="<td>"+data.list[i].withdrawalAmount+"</td>";
    tab+="<td>"+data.list[i].approvalStatus+"</td>";
    
    //tab+="<td style='width:100px'><input value='查看信息' type='button'  class='btn btn-primary' data-toggle='modal' data-target='#myModal' onclick='se("+data[i].approvalNumberId+","+data[i].IndAccountID+","+data[i].withdrawalAmount+",\""+data[i].applicationtime+"\")'/></td>";
    //tab+="<button class='btn btn-primary btn-lg" data-toggle="modal" data-target='#myModal'>开始演示模态框</button>";
   tab+="<td style='width:100px'><a href='sele_contract.action?appid="+data.list[i].approvalNumberId+"'method='post'>查询</a></td>"
    tab+="</tr>";
   //onclick='se("+data[i].approvalNumberId+","+data[i].IndAccountID+","+data[i].withdrawalAmount+")'
   }
   if(data.currPage!=1&&data.currPage+1<=data.allPage){
	   
	    trs+="<center><tr><td><a onclick='gggg("+data.currPage+",1)'>上一页</a><td>";
	    trs+="<td><a onclick='gggg("+data.currPage+",2)'>下一页</a></td>";
	    trs+="</tr></center>";
	   }else{
	   if(data.currPage==1){
	   
	   }else{
	   trs+="<tr><td><a onclick='gggg("+data.currPage+",1)'>上一页</a><td></tr>";
	   }
	   
	   if(data.currPage+1>data.allPage){
	   
	   }else{
	   trs+="<tr><td><a onclick='gggg("+data.currPage+",2)'>下一页</a></td></tr>";
	   }
	   }
  $("#twot").append(tab);
   }
   })

};
	/*function se(obj,a,b,c){
	$(".modal-body").html("");
	
	$.ajax({
	 url:"sele_contract.action",
	 type:"post",
	 data:{"appid":obj},
	 dataType:"json",
	 success:function(data){
	  var tab="<table id='what' class='table'>";
	 if(data[0].piId!=null){//购房
	 
	 tab+="<tr><td colspan='4'>购房合同信息</td></tr>";
	 tab+="<tr>";
	 tab+="<td>购房人姓名<span class='sp'>*</span></td><td><input  value='"+data[0].hbname+"'class='tto' readonly='readonly'/></td>";
	 tab+="<td>身份证号<span class='sp'>*</span></td><td><input  value='"+data[0].shidnum+"'class='tto'readonly='readonly'/></td>";
	 tab+="</tr>";
	 tab+="<tr>";
	 tab+="<td>售房单位<span class='sp'>*</span></td><td><input  value='"+data[0].shutin+"' class='tto'readonly='readonly'/></td>";
	 tab+="<td>售房联系电话<span class='sp'>*</span></td><td><input value='"+data[0].shphone+"' class='tto'readonly='readonly'/></td>";
	 tab+="</tr>";
	 tab+="<tr>";
	 tab+="<td>售房地址<span class='sp'>*</span></td><td colspan='3'><input value='"+data[0].shaddress+"' id='shaddress' readonly='readonly'/></td>";
	 tab+="</tr>";
	 tab+="<tr>";
	 tab+="<td>房屋单价<span class='sp'>*</span></td><td><input value='"+data[0].pumoney+"' id='pumoney' readonly='readonly'/><span style='font-size:15px;'>㎡</span></td>";
	 tab+="<td>房屋面积<span class='sp'>*</span></td><td><input value='"+data[0].puAddress+"' id='puAddress' readonly='readonly'/><span style='font-size:20px;'>㎡</span></td>";
	 tab+="</tr>";
	 tab+="<tr>";
	 tab+="<td>房屋现状<span class='sp'>*</span></td><td><input value='"+data[0].houcs+"' class='tto' readonly='readonly'/></td>";
	 tab+="<td>房屋总价<span class='sp'>*</span></td><td><input  value='"+data[0].puType+"'  class='tto' readonly='readonly'/></td>";
	 tab+="</tr>";
	 tab+="<tr>";
	 tab+="<td>购房合同编号<span class='sp'>*</span></td><td colspan='3'><input  value='"+data[0].puText+"' id='puText' readonly='readonly'/></td>";
	 tab+="</tr>";
	 tab+="<tr>";
	 tab+="<td>所购住房坐落<span class='sp'>*</span></td><td colspan='3'><span style='font-size:10px;'>请按购房合同或房屋所有权证或不动产权证上的地址填写</span><input  value='"+data[0].recnum+"' id='recnum' readonly='readonly'/></td>";
	 tab+="</tr>";
	 tab+="<tr>";
	 tab+="<td colspan='4'><span style='color:black;'>个人住房信息核查授权、承诺书</span></td>";
	 tab+="</tr>";
	tab+="</table>";
	 tab+="<div style='width:700px;height:350px;border:0px solid black;'>";
	 tab+=" <p><br/><br/>&nbsp;&nbsp;本人因申请提取住房公积金，现授权北京住房公积金管理中心（以下简称管理中心）通";
	 tab+="过北京市住房和城乡建设委员会、北京市规划和国土资源管理委员会、北京市经济和信息化委员会等部门核查本人提交的提取材料及相关信息；授权管理中心通过中国人民银行金融信用信息基础数据库查询本人的个人信用信息，同意管理中心对此次提交的提取材料及相关信息进行现场核实。<br/></p>";
	 tab+="<p>&nbsp;&nbsp;本人郑重承诺：本人如实填写的上述各项信息及提交材料真实有效。若承诺失实，本人愿意承担以下后果：<br/>";
	tab+="&nbsp;&nbsp;1.终止提取行为，并在规定期限内退还所提取金额；<br/>";
	tab+="&nbsp;&nbsp;2.将违规行为通报所在单位并对外公布；<br/>";
	tab+="&nbsp;&nbsp;3.将违规信息计入住房公积金个人不良信息库和国家有关征信系统；<br/>";
	tab+="&nbsp;&nbsp;4.自违规发现之日起三年内不予办理住房公积金提取、不予受理住房公积金贷款申请；<br/>";
	tab+="&nbsp;&nbsp;5.涉嫌构成犯罪的，移送司法机关处理。<br/>";
	tab+="&nbsp;&nbsp;我已认真阅读上述内容，同意授权并遵守上述承诺。<br/>";
	tab+="<div style='margin-left:400px;margin-top:40px;'>申请人签字<input id='ffgg' value='"+data[0].hbname+"' readonly='readonly'/></span></div>";
	 tab+="</div>";
	  
	  
	  tab+=" <div class='modal-footer'>";
      tab+="<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>";
      tab+="<button type='button' class='btn btn-primary'  data-dismiss='modal'onclick='subs("+obj+","+a+","+b+",\""+c+"\")'>同意提取</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='notsub("+obj+")'>不同意提取</button>";
       tab+="</div>";
	 }else if(data[0].deathCertificateId!=null){//死亡证明
	  tab+="<tr>";
	  tab+="<td>姓名</td>";
	  tab+="<td>身份证号</td>";
	  tab+="<td>户籍所在地</td>";
	  tab+="<td>死亡原因</td>";
	  tab+="</tr>";
	  tab+="<tr>";
	  tab+="<td>"+data[0].myName+"</td>";
	  tab+="<td>"+data[0].idno+"</td>";
	  tab+="<td>"+data[0].placeOfDomicile+"</td>";
	  tab+="<td>"+data[0].causeOfDeath+"</td>";
	  tab+="</tr>";
	  tab+="</table>";
	   tab+=" <div class='modal-footer'>";
      tab+="<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='subs("+obj+","+a+","+b+",\""+c+"\")'>同意提取</button>";
       tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='notsub("+obj+")'> 不同意提取</button>";
       tab+="</div>";
	 }else if(data[0].retireId!=null){//离职退休
	  tab+="<tr>";
	  tab+="<td>姓名</td>";
	  tab+="<td>单位名称</td>";
	  tab+="<td>离休原因</td>";
	  tab+="</tr>";
	  tab+="<tr>";
	  tab+="<td>"+data[0].myName+"</td>";
	  tab+="<td>"+data[0].utinName+"</td>";
	  tab+="<td>"+data[0].reasForRe+"</td>";
	  tab+="</tr>";
	  tab+="</table>";
	  tab+=" <div class='modal-footer'>";
      tab+="<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='subs("+obj+","+a+","+b+",\""+c+"\")'>同意提取</button>";
      tab+="<button type='button' class='btn btn-primary' data-dismiss='modal' onclick='notsub("+obj+")'>不同意提取</button>";
       tab+="</div>";
	 }
	  
	 $(".modal-body").append(tab);
	 
	 }
	})
	}*/
	
	
	function subs(a,b,c,d){
	
	$.ajax({
	 url:"yes_con.action",
	 type:"post",
	 data:{"appid":a,"indid":b,"money":c,"apptime":d},
	 dataType:"json",
	 success:function(data){
	window.href.location=="<%=basePath%>ssw/examine.jsp";
	 }
	})
	}
	function notsub(a){
	/* alert(a); */
	$.ajax({
	 url:"not_con.action",
	 type:"post",
	 data:{"appid":a},
	 dataType:"json",
	 success:function(data){
	 window.href.location=="<%=basePath%>ssw/examine.jsp";
	 }
	})
	}


</script>
