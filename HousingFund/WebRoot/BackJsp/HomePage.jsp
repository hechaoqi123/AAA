<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" href="../bootstrap/font-awesome-4.7.0/css/font-awesome.css" type="text/css"></link></head>

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
							</a>
						</li>

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									当前用户
										${user.uname }
								</span>
							</a>
							<span id="demo"></span>

				
				
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
			<div id="sidebar" class="sidebar responsive" style="font-size:17px">
				<ul class="nav nav-list">
					<li class="active">
						<a href="welcomePage.jsp" id="home" target="right_main">
							<i class="menu-icon fa fa-television"></i>
							<span class="menu-text"> 首页 </span>
						</a>
						<b class="arrow"></b>
					</li>
					<!-- 进度查询 -->
					<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-clock-o"></i>
							<span class="menu-text">进度查询</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '进度查询'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!-- 信息管理 -->
					<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-address-card-o"></i>
							<span class="menu-text">信息管理</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '信息管理'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!--个人业务-->
					<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-user-o"></i>
							<span class="menu-text">个人业务</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '个人业务'}">
									<li>
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!--单位业务-->
					<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-gg"></i>
							<span class="menu-text">单位业务</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '单位业务'}">
									<li>
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!-- 汇缴业务 -->
						<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-superpowers"></i>
							<span class="menu-text">汇缴业务</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '汇缴提取'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
						<!-- 提取业务 -->
						<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-ravelry"></i>
							<span class="menu-text">提取业务</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '提取业务'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!-- 信贷业务 -->
						<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-object-group"></i>
							<span class="menu-text">信贷业务</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '信贷业务'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
						<!-- 还贷业务 -->
						<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-refresh"></i>
							<span class="menu-text">还款业务</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '还款业务'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!-- 冲贷业务 -->
						<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-eercast"></i>
							<span class="menu-text">冲贷业务</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '冲贷业务'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!-- 员工管理 -->
					<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-user-plus"></i>
							<span class="menu-text">员工管理</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '员工管理'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
					<!-- 权限管理 -->
					<li class="Myli">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-cog"></i>
							<span class="menu-text">系统设置</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>

						<ul class="submenu">
							<c:forEach items="${list_Powers}" var="Powers">
								<c:if test="${Powers.ptype == '权限管理'}">
									<li class="">
									<a href="${Powers.purl }" class="test" target="right_main">
										<i class="menu-icon fa fa-caret-right"></i>
										${Powers.pname }
									</a>
									<b class="arrow"></b>
									</li>
								</c:if>
							</c:forEach>
							
							
									<li class="">
									<a href="cancel.action"  id="cancel" class="test">
									    注销登陆
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
					<iframe src="welcomePage.jsp" name="right_main" frameborder="0" scrolling="auto" width="100%" height="1900px"></iframe> 
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
	    $("#cancel").click(function(){
	        if(confirm("是否退出？")){
	           return true;
	        }else{
	          return false;
	        }
	    })
	    	$(function(){
	    		//创造时间
				$('#demo').jclock({withDate:true, withWeek:true});
			});
			function quit_login(){
				if(confirm('是否要退出系統？'))window.top.location='login.jsp';
			};
			function Myli_none(){
				var myli_html = $(".Myli ul").html();
				if(myli_html == ""){
					$(".Myli").css("display","none");
				}
			};
			$("#home").click(function(){
			  $(".test").css("background","#ffffff")
			})
			$(".test").click(function(){
		       $(".test").css("background","#ffffff")
			   $(this).css("background","#AFEEEE")
			})
	    </script>
