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

	<script type="text/javascript" src="../bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
</head>
<body>

<div id="left_one">
    <div>
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
                    <span class="menu-text"> 333333</span>
                </a>
            </li>
        </ul>
    </div>
</div>

</body>
</html>
