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
   
     	<span class="btn btn-primary" data-toggle="modal" data-target="#addUsers">
			添加员工
		</span>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="addUsers" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 300px;margin-top: 120px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							添加员工
						</h4>
					</div>
					<div class="modal-body">
						<form id="myForm">
						    <table>
						    	<tr>
						    		<td>员工名称：</td>
						    		<td><input type="text" class="form-control" name="users.uname" required /></td>
						    	</tr>
						    	<tr>
						    		<td>员工账号：</td>
						    		<td><input type="text" class="form-control" name="users.unum" required /></td>
						    	</tr>
						    	<tr>
						    		<td>员工密码：</td>
						    		<td><input type="text" class="form-control" name="users.upass" required /></td>
						    	</tr>
						    	<tr>
						    		<td>员工证件：</td>
						    		<td><input type="text" class="form-control" name="users.udescription" required /></td>
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
    		<td>员工编号</td>
    		<td>员工名称</td>
    		<td>员工账号</td>
    		<td>员工密码</td>
    		<td>证件号码</td>
    		<td>员工状态</td>
    		<td>证件职务</td>
    		<td>操作</td>
    	</tr>
    	<tbody id="tab">
         		
        </tbody>
    </table>
    
    	<!-- 模态框（Modal） -->
		<div class="modal fade" id="add_update_Users" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 400px;margin-top: 120px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							修改员工信息
						</h4>
					</div>
					<div class="modal-body">
						<form id="myFormUpdate">
						    <table>
						    	<tr>
						    		<td>员工编号：</td>
						    		<td><input type="text" class="form-control uid" name="users.uid" readonly="readonly"/></td>
						    	</tr>
						    	<tr>
						    		<td>员工名称：</td>
						    		<td><input type="text" class="form-control uname" name="users.uname" required /></td>
						    	</tr>
						    	<tr>
						    		<td>员工账号：</td>
						    		<td><input type="text" class="form-control unum" name="users.unum" required /></td>
						    	</tr>
						    	<tr>
						    		<td>员工密码：</td>
						    		<td><input type="text" class="form-control upass" name="users.upass" required /></td>
						    	</tr>
						    	<tr>
						    		<td>证件号码：</td>
						    		<td><input type="text" class="form-control udescription" name="users.udescription" required /></td>
						    	</tr>
						    	
						    	<tr>
						    		<td>员工状态：</td>
						    		<td>
						    			<input type="radio" class="ustatic" name="users.ustatic" checked="checked" value="1" />正常
						    			<input type="radio" class="ustatic" name="users.ustatic" value="2" />冻结
						    		</td>
						    	</tr>
						    	<tr>
						    		<td>员工角色：</td>
						    		<td>
						    			<input type="text" class="urid" name="urid" value="12" style="display: none;"> <span class="urname"></span>
    									<span>
    									<span style="color: red;">修改为：</span>
								    			<select class="getUrid" size="2">
								    				
								    			</select>
								    	</span>
						    		</td>
						    	</tr>
						    	
						    </table>
					    </form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="update_users">
							提交修改
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
  </body>
</html>
<script type="text/javascript" src="JS/addUsers.js"></script>

