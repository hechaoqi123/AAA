<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title></title>

    <meta name="description" content="This is page-header (.page-header &gt; h1)" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="../assets/css/ace.min.css" id="main-ace-style" />


    <script src="../bootstrap/jquery.min.js"></script>
    <script src="../bootstrap/bootstrap.min.js"></script>

</head>
<body>
<div id="navbar" class="navbar navbar-default" ><!--style="background-color:#000 "  -->
   <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    AAA住房公积金管理系统
                </small>
            </a>
        </div>


        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="green">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
                        <span class="badge badge-success">1</span>
                    </a>
                </li>

                <li class="light-blue">
                    <a href="#">
                        <span class="">
									user name						
                        </span>
                    </a>
                </li>
                <li class="light-blue">
                    <a href="#" onclick="quit_login()">退出</a>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
<script>
	function quit_login(){
		if(confirm('是否要退出系統？'))window.top.location='login.jsp';
	}
</script>