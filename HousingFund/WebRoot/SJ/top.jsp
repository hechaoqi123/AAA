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


    <script src="../bootstrap/jquery.js"></script>
    <script src="../bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="../bootstrap/jquery.jclock.js"></script>
    <script type="text/javascript">
    	$(function(){
			$('#demo').jclock({withDate:true, withWeek:true});
		});
		
    </script>
	<style type="text/css">
		.active{
			border: 1px solid #e3e3e3;
		}
		#sidebar{border-right: 1px solid #438EB9;}
		#navbar{height: 100px;}
		#demo{color: #fff;};
	</style>
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
									当前用户:&nbsp;&nbsp;user name						
                        </span>
                    </a>
                    <span id="demo"></span>
                </li>
            </ul>
        </div>
    </div>
    
</div>
	<div id="left_one">
		<div id="sidebar" class="sidebar responsive">
		        <ul class="nav nav-list">
		            <li class="active" data-toggle="collapse" data-parent="#left_one" data-target="#a">
		                <a class="dropdown-toggle">
		                    <span class="menu-text"> AAAAA</span>
		                </a>
		            </li>
		        </ul>
		        <ul id="a" class="nav nav-list collapse">
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> AAAAA </span>
		                </a>
		            </li>
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> AAAAA </span>
		                </a>
		            </li>
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> AAAAA </span>
		                </a>
		            </li>
		        </ul>
		
		
		        <ul class="nav nav-list">
		            <li class="active" data-toggle="collapse" data-parent="#left_one" data-target="#b">
		                <a href="#" class="dropdown-toggle">
		                    <span class="menu-text"> BBBBB</span>
		                </a>
		            </li>
		        </ul>
		        <ul id="b" class="nav nav-list collapse">
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> 22222 </span>
		                </a>
		            </li>
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> 333333 </span>
		                </a>
		            </li>
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> 22222 </span>
		                </a>
		            </li>
		        </ul>
		
		
		        <ul class="nav nav-list">
		            <li class="active" data-toggle="collapse" data-parent="#left_one" data-target="#c">
		                <a href="#" class="dropdown-toggle">
		                    <span class="menu-text"> ccc</span>
		                </a>
		            </li>
		        </ul>
		        <ul id="c" class="nav nav-list collapse">
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> 333333</span>
		                </a>
		            </li>
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text"> 333333 </span>
		                </a>
		            </li>
		            <li class="active">
		                <a href="1.html" target="right_main">
		                    <span class="menu-text" onclick()> 333333</span>
		                </a>
		            </li>
		        </ul>
		    </div>
	</div>
	<iframe src="1.html" name="right_main" id="right_main" frameborder="0" scrolling="auto" width="80%" height="700px"/>
	
	
	
</body>
</html>
<script type="text/javascript">
	function quit_login(){
		alert(1);
		if(confirm('是否要退出系統？'))window.top.location='login.jsp';
	}
</script>