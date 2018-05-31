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
   <span style="color: red; font-size: 30;"> 非技术人员慎重操作</span><br/>
   
     	<span class="btn btn-primary" data-toggle="modal" data-target="#addPowers">
			添加权限功能
		</span>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="addPowers" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 120px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							添加权限功能
						</h4>
					</div>
					<div class="modal-body">
						<form id="myForm">
						    <table>
						    	<tr>
						    		<td>功能名称：</td>
						    		<td><input type="text" class="form-control" name="powers.pname" required /></td>
						    	</tr>
						    	<tr>
						    		<td>功能地址：</td>
						    		<td><input type="text" class="form-control" name="powers.purl" required /></td>
						    	</tr>
						    	<tr>
						    		<td>功能基类：</td>
						    		<td><input type="text" class="form-control" name="powers.ptype" required /></td>
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
    		<td>功能编号</td>
    		<td>功能名称</td>
    		<td>功能地址</td>
    		<td>功能基类</td>
    		<td>操作</td>
    	</tr>
    	<tbody id="tab">
         		
        </tbody>
    </table>
    
    	<!-- 模态框（Modal） -->
		<div class="modal fade" id="add_update_Powers" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 120px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							修改权限功能
						</h4>
					</div>
					<div class="modal-body">
						<form id="myFormUpdate">
						    <table>
						    	<tr>
						    		<td>功能编号：</td>
						    		<td><input type="text" class="form-control pid" name="powers.pid" readonly="readonly"/></td>
						    	</tr>
						    	<tr>
						    		<td>功能名称：</td>
						    		<td><input type="text" class="form-control pname" name="powers.pname" required /></td>
						    	</tr>
						    	<tr>
						    		<td>功能地址：</td>
						    		<td><input type="text" class="form-control purl" name="powers.purl" required /></td>
						    	</tr>
						    	<tr>
						    		<td>功能基类：</td>
						    		<td><input type="text" class="form-control ptype" name="powers.ptype" required /></td>
						    	</tr>
						    	
						    </table>
					    </form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary" id="update_powers">
							提交修改
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
  </body>
</html>
<script type="text/javascript" src="JS/addFunction.js"></script>

