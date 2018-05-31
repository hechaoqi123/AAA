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
		<title>AAA住房公积金管理系统</title>
		<meta name="description" content="Restyling jQuery UI Widgets and Elements" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
			<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../assets/css/ace.min.css" id="main-ace-style" />
		
		<style type="text/css">
			.active{
				border: 1px solid #e3e3e3;
			}
			#sidebar{border-right: 1px solid #438EB9;}
			#navbar{height: 100px;}
			#demo{color: #fff;};
			.titles{
				font-size: 30px;
				text-align: center;
			}
		</style>
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<div id="navbar" class="navbar navbar-default" ><!-- style="background-color: #CDCDCD;" -->
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left" style="height: 100px; margin: 0;padding: 0;">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="#" class="navbar-brand">
							<img src="../bootstrap/logo.jpg" style="height: 80px;"width="250px;"></img>
					</a>
				</div>
				<div class="navbar-header" style="font-size: 55px;text-align:center; color: #FFF; letter-spacing: 10px; padding-left: 30px;">
					AAA住房公积金管理系统
				</div>
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#" style="background-color: #438EB9;">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"  ></i>
								<span class="badge badge-success">1</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-envelope-o"></i>
									1条未读信息
								</li>

								<li class="dropdown-content">
									<ul class="dropdown-menu dropdown-navbar">
										<li>
											<a href="#">
												<img src="../assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
												<span class="msg-body">
													<span class="msg-title">
														<span class="blue">B2C:</span>
														系统产生20个错误，12个警告...
													</span>

													<span class="msg-time">
														<i class="ace-icon fa fa-clock-o"></i>
														<span>2019-12-15 18:00:00</span>
													</span>
												</span>
											</a>
										</li>
									</ul>
								</li>

								<li class="dropdown-footer">
									<a href="inbox.html">
										查看全部消息
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									当前用户name		
								</span>
								<i class="ace-icon fa fa-caret-down"></i>
							</a>
							<span id="demo">1111</span>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										系统设置
									</a>
								</li>

								<li>
									<a href="profile.html">
										<i class="ace-icon fa fa-user"></i>
										个人信息设置
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#" onclick="quit_login()">
										<i class="ace-icon fa fa-power-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
		</div>
		<!--=====================================================================================  -->

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar responsive">
				<ul class="nav nav-list">
					<li class="active">
						<a href="#">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> 首页 </span>
						</a>
						<b class="arrow"></b>
					</li>
<!--需要增加一个新的功能块时复制这个<li>...</li>  -->
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text"> 公司</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
<!--需要增加一个新的功能时复制这个<li>...</li>  
		当需要链接到其他页面时超链接需要    target="right_main"
-->

							<li class="">
								<a href="../ssw/RemPro.jsp" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									汇缴办理
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="../ssw/extract.jsp" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									提取申请
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="../ssw/examine.jsp" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									提取审批
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="../ssw/RemitDetail.jsp" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									汇缴清册
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="../ssw/supple.jsp" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									补缴办理
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="../ssw/timer.jsp" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									定时缴费
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">个人 </span>
							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">

							<li class="">
								<a href="1.html" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									个人1
								</a>

								<b class="arrow"></b>
							</li>

							<li class="">
								<a href="1.html" target="right_main">
									<i class="menu-icon fa fa-caret-right"></i>
									个人2
								</a>

								<b class="arrow"></b>
							</li>
						</ul>
					</li>
				</ul><!-- /.nav-list -->
			</div>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<!-- /section:basics/content.breadcrumbs 右中部分 -->
				<div class="page-content">
					<iframe src="1.html" name="right_main" frameborder="0" scrolling="auto" width="80%" height="700px"></iframe> 
				</div>
			</div>
		</div><!-- /.main-container -->

		

	</body>
</html>
<script type="text/javascript">
			window.jQuery || document.write("<script src='../assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>
		<script src="../assets/js/bootstrap.min.js"></script>
		<script src="../assets/js/ace-elements.min.js"></script>
		<script src="../assets/js/ace.min.js"></script>
		<script type="text/javascript" src="../bootstrap/jquery.jclock.js"></script>
	    <script type="text/javascript">
	    	$(function(){
				$('#demo').jclock({withDate:true, withWeek:true});
			});
			function quit_login(){
				alert(1);
				if(confirm('是否要退出系統？'))window.top.location='login.jsp';
			}
	    </script>
