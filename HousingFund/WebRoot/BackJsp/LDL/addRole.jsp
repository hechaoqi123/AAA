<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>addFunction</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=UTF-8">
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
	 
 </head>
  
  <body>
   
     	<span class="btn btn-primary" data-toggle="modal" data-target="#addrole">
			添加角色
		</span>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="addrole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 120px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							添加角色
						</h4>
					</div>
					<div class="modal-body">
						<form id="myForm">
						    <table>
						    	<tr>
						    		<td>角色名称：</td>
						    		<td><input type="text" class="form-control" name="role.rname" required /></td>
						    	</tr>
						    	<tr>
						    		<td>角色描述：</td>
						    		<td><input type="text" class="form-control" name="role.rtype" required /></td>
						    	</tr>
						    	
						    </table>
					    </form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary" onclick="addsubmit()">
							提交添加
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
     <hr>
    <table class="table table-striped">
    	<tr>
    		<td>角色编号</td>
    		<td>角色名称</td>
    		<td>角色描述</td>
    		<td>操作</td>
    	</tr>
    	<tbody id="tab">
         		
        </tbody>
    </table>
    
    	<!-- 模态框（Modal） -->
		<div class="modal fade" id="add_update_Role" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 120px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							修改角色
						</h4>
					</div>
					<div class="modal-body">
						<form id="myFormUpdate">
						    <table>
						    	<tr>
						    		<td>角色编号：</td>
						    		<td><input type="text" class="form-control rid" name="role.rid" readonly="readonly"/></td>
						    	</tr>
						    	<tr>
						    		<td>角色名称：</td>
						    		<td><input type="text" class="form-control rname" name="role.rname" required /></td>
						    	</tr>
						    	
						    	<tr>
						    		<td>角色描述：</td>
						    		<td><input type="text" class="form-control rtype" name="role.rtype" required /></td>
						    	</tr>
						    	
						    </table>
					    </form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary" id="update_Role" data-dismiss="modal">
							提交修改
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
  </body>
</html>
<script type="text/javascript" src="JS/AddRole.js"></script>

