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
    
    <title>addFunction</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="bootstrap/sousuo.css" type="text/css"></link>
	<script type="text/javascript" src="JS/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
   	<style>
   			/*去除input框number中的小箭头  */
			input::-webkit-outer-spin-button,
			input::-webkit-inner-spin-button{
			    -webkit-appearance: none !important;
			    margin: 0; 
			}
			input[type="number"]{-moz-appearance:textfield;}
			.indDepositRadices{
				width: 100px;
			}
   	</style>
 </head>
  <body>
  	
  	<div class="searchbox mt1">
        <div class="search w960 center">
            <div class="form">
            	<div class="form_left">
                    <div class="form_right">
                    <input class="utinid" name="utinaccountinfoID" style="display: none;" value="0" >
                     <input class="trueName" name="indaccountinfo.indinfo.trueName" type="text" class="ss" style="width:330px;
																		height:34px;
																		padding-top:2px;
																		color:#a3a3a3;
																		line-height:36px;
																		font-size:14px;
																		background-image:url(../BackJsp/LDL/images/bg.png);
																		background-repeat:repeat-x;
																		background-position:0 -40px;" 
							value="输入员工姓名" onfocus="if(this.value=='输入员工姓名'){this.value='';}"  onblur="if(this.value==''){this.value='输入员工姓名';}" />
                      <button type="button" class="search-submit" onclick="getFuzzyEmp(-1)">搜索</button>
                    </div>
                </div>
            </div>
   		 </div>
	</div>
    <table class="table">
          <tr>
	           <td>员工编号</td>
	           <td>姓名</td>
	           <td>职务</td>
	           <td>缴存基数</td>
	           <td>当前余额</td>
	           <td>可取现余额</td>
	           <td>状态</td>
	           <td>操作</td>
          </tr>
          <tbody id="tbs">
         
          </tbody>
      </table>
    
  </body>
<script type="text/javascript" src="JS/EmpSup.js"></script>

</html>

