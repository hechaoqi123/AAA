<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'unitCheck.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="bootstrap/sousuo.css" type="text/css"></link>
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	 
  </head>
  
  <body>
    单位开户审批
    <hr/>
    <table class="table table-striped">
    	<tr>
    		<td>单位编号</td>
    		<td>单位名称</td>
    		<td>经办人</td>
    		<td>单位账户状态</td>
    		<td>操作</td>
    	</tr>
    	<tbody id="tab">
         		
        </tbody>
       
    </table>
    
    <!-- 模态框（Modal） -->
		<div class="modal fade" id="get_one_Utinaccountinfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
					<div class="modal-body">
						<form id="myFormUpdate">
						    <table class="table">
						    	 <tr>
						           <td colspan="4"><h3>公司开户详细信息</h3></td>
						         </tr>
						          <tr>
						           <td>公司名称:</td>
						           <td><span class="utinName"></span></td>
						           <td>单位地址:</td>
						           <td><span class="utinAddress"></span></td>
						          </tr>
						         
						          <tr>
						           <td>法人代表:</td>
						           <td><span class="corpRepr"></span></td>
						           <td>经办人姓名:</td>
						           <td><span class="operatorName"></span></td>
						          </tr>
						         
						           <tr>
						           <td>经办人电话:</td>
						           <td><span class="operatorPhone"></span></td>
						           <td>经办人证件号:</td>
						           <td><span class="operatorIdnumber"></span></td>
						          </tr>
						           <tr>
						           <td>开户银行名称:</td>
						           <td><span class="bankName"></span></td>
						           <td>单位设立日期:</td>
						           <td><span class="utinFoundDate"></span></td>
						          </tr>
						           <tr>
						           <td style="display: none;">单位账户编号:</td>
						           <td style="display: none;"><input type="text" readonly="readonly" class="utinAccountId" value=""></td>
						           <td>是否审核通过</td>
						           <td>
						           	<input type="radio" name="accountStatus" class="accountStatus" value="驳回"> 驳回
						           	<input type="radio" name="accountStatus" class="accountStatus" value="正常" checked="checked"> 通过审批
						           </td>
						          </tr>
						    	
						    </table>
					    </form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" id="update_utinAccount">
							提交
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
  </body>
  
  <script type="text/javascript" src="JS/unitCheck.js"></script>
</html>
