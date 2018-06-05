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
    <title>My JSP 'userList.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=2">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.modal-body{width:500px;height:200px;
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
	
</style>
	<link rel="stylesheet" href="${path }/resource/bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css"></link>
    <script type="text/javascript" src="${path }/resource/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/resource/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
  </head>
  <body>
  <!--点击弹出模态窗口  -->
     <div style="float:right;margin-right:200px;">
        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="addBtn">新增</button>
     </div>
     
	<!--模态框 1--> 
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				  <h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				
				<!--模态框主体  -->
				<div class="modal-body">  
				<!-- 填写你想要的内容 -->	
				</div>
				
				
				
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">关闭</button>
					<button class="btn btn-primary" id="sub">保存</button>
				</div>
			</div>
		</div>
	</div> 

  </body>
</html>
