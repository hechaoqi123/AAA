<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>单位信息</title>
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
	<link rel="stylesheet" href="bootstrap/sousuo.css" type="text/css"></link>
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	 
 </head>
  
  <body>
	<div class="searchbox mt1">
        <div class="search w960 center">
            <div class="form">
            	<div class="form_left">
                    <div class="form_right">
                     <input name="keyword" type="text" class="ss" style="width:330px;
																		height:34px;
																		padding-top:2px;
																		color:#a3a3a3;
																		line-height:36px;
																		font-size:14px;
																		background-image:url(../BackJsp/LDL/images/bg.png);
																		background-repeat:repeat-x;
																		background-position:0 -40px;" 
							value="输入单位名称" onfocus="if(this.value=='输入单位名称'){this.value='';}"  onblur="if(this.value==''){this.value='输入单位名称';}" />
                      <button type="submit" class="search-submit" onclick="getFuzzy()">搜索</button>
                    </div>
                </div>
            </div>
   		 </div>
	</div>
	
	
	
     <hr>
    <table class="table table-striped">
    	<tr>
    		<td>单位编号</td>
    		<td>单位名称</td>
    		<td>单位实存人数</td>
    		<td>单位缴存人数</td>
    		<td>单位封存人数</td>
    		<td>单位账户余额</td>
    		<td>单位账户状态</td>
    		<td>操作</td>
    	</tr>
    	<tbody id="tab">
         		
        </tbody>
       
    </table>
  </body>
<script type="text/javascript" src="JS/baseAlter.js"></script>
</html>

