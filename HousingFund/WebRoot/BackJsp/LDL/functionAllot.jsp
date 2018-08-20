<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<style>
		.function_allot_div_title div{
			float:left;
			width: 45%;
			height:10%;
			margin-left: 17px;
		}
		.function_allot_div div{
			width: 45%;
			height: 90%;
			border: 1px solid #e3e3e3;
			float: left;
			margin-left: 17px;
			overflow-y:auto;
		}
		
	</style>
  </head>
  
  <body>
	<table class="table table-striped">
    	<tr>
    		<td>角色名称</td>
    		<td>角色描述</td>
    	</tr>
    	<tbody id="tab">
         		
        </tbody>
    </table>
    
    <!-- 模态框（Modal） -->
		<div class="modal fade" id="function_allot" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 600px;margin-top: 120px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							<span class="myName"></span>
						</h4>
					</div>
					<div class="modal-body">
						<div style="width: 90%;height:200px; margin: 0 auto;">
							<div class="function_allot_div_title">
								<div>拥有功能</div>
								<div>未有功能</div>
							</div>
							<div  class="function_allot_div">
								<div>
									<table id="tabs" class="table table-striped">
										
									</table>
								</div>
								<div>
									<table id="tabsNo" class="table table-striped">
										
									</table>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">关闭
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
</body>
</html>
<script type="text/javascript" src="JS/functionAllot.js"></script>