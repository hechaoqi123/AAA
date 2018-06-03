<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
			
			<c:if test="${list_Indaccountinfo == null }">
			<div class="row" style="margin: 0 auto;">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<!-- #section:pages/error -->
					<div class="error-container">
						<div class="well">
							<h1 class="grey lighter smaller">
								<span class="blue bigger-125" style="color: red">
									<i class="ace-icon fa fa-random"></i>
									文件中存在异常未处理<br/>
								</span>
									<span>
									建议<br/>
										<ul>
											<li>将Excel另存为xls格式</li>
											<li>将表格中数据复制到新表重新添加</li>
										</ul>
									</span>
								
							</h1>
							<hr />
							<div class="space"></div>
							<hr />
						</div>
					</div>
				</div><!-- /.col -->
			</div><!-- /.row -->
				
			</c:if>
			<c:if test="${list_Indaccountinfo != null }">
				<div class="row" style="margin: 0 auto;">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<!-- #section:pages/error -->
					<div class="error-container">
						<div class="well">
							<h1 class="grey lighter smaller">
								<span class="blue bigger-125">
									<i class="ace-icon fa fa-random"></i>
									提交成功
								</span>
							</h1>
							<hr />
							<div class="space"></div>
						</div>
					</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
				
			</c:if>
			
  </body>
</html>
