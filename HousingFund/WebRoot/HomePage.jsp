<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>AAA住房公积金</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	body{
	MARGIN-RIGHT: auto;
MARGIN-LEFT: auto;
	}
	a{
	text-decoration:none;
	}
	 *{
  margin:0;
  padding:0;
 }
	li{
	list-style-type: none;
	}
	  #topmenu ul{
	   border:0px solid green;
	   width:1250px;
	   height:46px;
	   margin-left: 370px;
	  }
	  #topmenuul li:HOVER{
	  background-color:#016ec5;
	  }
	  #topmenu ul li{
	  border:0px solid black;
	  font-family:微软雅黑;
	  font-size:18px;
	  width:160px;
	  height:46px;
	  float: left;
	  color: white;
	  text-align:center;
	  line-height: 48px;
	  }
	  
	  
	  #lunbo div{
	  float: left;
	  }
	  
	  
	  #lunboleftul li{
	  width:231px;
	  height:75px;
	  border: 0px solid red;
	  margin-top: 45px;
	  margin-left: 25px;
	  color:white;
	  font-size: 18px;
	  line-height:125px;
	  text-align: center;
	  }
	  
	  #mainfunction ul{
	  width:1200px;
	  height:150px;
	  border: 0px solid red;
	  }
	 #mainfunction ul li{
	  width:169px;
	  float:left;
	  height:150px;
	  border: 0px solid green;
	  text-align:center;
	  line-height: 250px;
	  font-size: 15px;
	  color:black;
	  } 
	  #mainfunction ul li:HOVER{
	   color:blue;
	  }
	  
	  
	  #infoone ul{
	  width:340px;
	  height:260px;
	  border: 0px solid red;
	  margin-top: 40px;
	  }
	   #infoone ul li{
	  width:338px;
	  height:40px;
	  border: 0px solid red;
	  line-height: 40px;
	  font-size: 15px;
	  
	  }
	   #infotwo ul{
	  width:340px;
	  height:260px;
	  border: 0px solid red;
	  margin-top: 40px;
	  }
	   #infotwo ul li{
	  width:338px;
	  height:40px;
	  border: 0px solid red;
	  line-height: 40px;
	  font-size: 15px;
	  
	  }
	   #infothree ul{
	  width:510px;
	  height:260px;
	  border: 0px solid red;
	  margin-top: 40px;
	  }
	   #infothree ul li{
	  width:510px;
	  height:40px;
	  border: 0px solid red;
	  line-height: 40px;
	  font-size: 15px;
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	  #service ul{
	  width:1200px;
	  height:200px;
	  border: 0px solid red;
	  }
	  #service ul li{
	  float:left;
	  width:198px;
	  height:160px;
	  border: 0px solid black;
	  
	  background-color:#F9F9F8;
	  
	  /*  */
	  }
	   #service ul li img{
	  position:relative;
	  top:40px;
	  left:50px;
	   }
	   #last ul li{
	   width:130px;
	   border:0px solid red;
	   height:96px;
	   float: left;
	   } #last ul li img{
	 
	position: relative;
	top:20px;
	
	   }
	</style>
  </head>
  
  <body>
<div style="width: 100%;height: 1505px;border: 0px solid red;">

<!-- 头部图片 -->
<div style="width:100%;height:135px;">
  <img alt="" src="png/2017112115540812702.jpg" style="height:135px;width:100%">
</div>
<!-- 头部菜单 -->
<div style="width: 100%;height:48px;background-color:#318cd4;margin-top:0px;" id="topmenu">
  <ul id="topmenuul">
    <a href="#"><li style="background-color: #016ec5">首页</li></a>
    <a href="#"><li>政务信息</li></a>
    <a href="#"><li>办事指南</li></a>
    <a href="#"><li>党建园地</li></a>
    <a href="#"><li>政策法规</li></a>
    <a href="#"><li>政民互动</li></a>
    <li style=" width:250px;"><form>
    <input style="height: 30px;">
    <input type="submit" value="搜索" style="height:30px;width: 50px;">
    </form></li>
  </ul>
</div>
<!-- 中间部分 -->
<div style="width:1200px;height:1100px;border:0px solid black;margin-left: 370px;">

<!-- 宣传图片 -->
<div style="width:1200px;height:90px;border: 0px solid red;"><img src="png/2018042317261663771.png" > </div>
<!-- 图片轮播部分 -->
<div style="width:1200px;height:310px;border: 0px solid black;" id="lunbo">

  <div style="width:800px;height:310px;border: 0px solid black;">
   <img alt="" src="png/2018041617041731019.jpg"style="width:800px;height:310px;">
  </div>
  <!--  -->
  <div id="lunboleft" style="width:295px;height:312px;border:0px solid black;margin-left:100px;background-image:url('png/2017051714392351103.png'); ">
  <ul style="width:290px;height:310px;border:0px solid black;" id="lunboleftul">
    <a href="grxxcx.jsp"><li style="background-image: url('png/2017112711180357414.png');">
    个人网上业务平台
    </li></a>
    
    <a href="#"> <li style="background-image: url('png/2017112711181595227.png');">
    单位网上业务平台
    </li></a>
  </ul>
  
  </div>
  
  <!-- 主要功能区 -->
  <div style="width:1200px;height:150px;border: 0px solid black;" id="mainfunction">
    <ul>
      <a href="#"> <li style="background-image: url('png/2018042501.png');background-position:center; background-repeat:no-repeat;">
       公积金开户</li></a>
       
       <a href="#"><li style="background-image: url('png/2018042502.png');background-position:center; background-repeat:no-repeat;">
       公积金缴存</li></a>
       <a href="#"><li style="background-image: url('png/2018042503.png');background-position:center; background-repeat:no-repeat;">
      我要提取 </li></a>
      <a href="#"> <li style="background-image: url('png/2018042504.png');background-position:center; background-repeat:no-repeat;">
      我要贷款 </li></a>
      <a href="#"> <li style="background-image: url('png/2018042505.png');background-position:center; background-repeat:no-repeat;">
   我要查询    </li></a>
       <a href="#"><li style="background-image: url('png/2018042506.png');background-position:30px 20px; background-repeat:no-repeat;">
     公积金转移  </li></a>
       <a href="#"><li style="background-image: url('png/2018042507.png');background-position:center; background-repeat:no-repeat;">
     经办网点  </li></a>
    </ul>
  </div>
  
  <!-- 信息区 -->
  <div style="width:1200px;height:300px;border: 0px solid black;margin-top: 30px;" id="infos">
  <div style="height:300px;border: 0px solid black;width:340px;" id="infoone">
  <div style="height:36px;border: 0px solid black;width:340px;background-image: url('png/2017051711342597367.png');background-repeat:no-repeat;background-color: #EFEFEF;font-size: 16px;line-height: 30px;color:white;" >
   &nbsp;&nbsp;常见问题
  </div>
    <ul >
  <li>
住房公积金归集执法-单位登记开户
  </li>
  <li>住房公积金归集执法-公积金查询
</li>
  <li>住房公积金归集执法-单位信息变更
</li>
  <li>住房公积金归集执法-个人信息变更
</li>
  <li>住房公积金归集执法-单位汇缴、补缴
</li>
  <li>住房公积金归集执法-购买北京市行政区域...
</li>
  </ul>
  </div>
  
  <div style="height:300px;border: 0px solid black;width:340px;" id="infotwo">
  
  <div style="height:36px;border: 0px solid black;width:340px;background-image: url('png/2017051711342597367.png');background-repeat:no-repeat;background-color: #EFEFEF;font-size: 16px;line-height: 30px;color:white;">
   &nbsp;&nbsp;最新重要事项
  </div>
 <ul >
  <li>
住房公积金归集执法-单位登记开户
  </li>
  <li>住房公积金归集执法-公积金查询
</li>
  <li>住房公积金归集执法-单位信息变更
</li>
  <li>住房公积金归集执法-个人信息变更
</li>
  <li>住房公积金归集执法-单位汇缴、补缴
</li>
  <li>住房公积金归集执法-购买北京市行政区域...
</li>
  </ul>
  </div>
  
  <div style="height:300px;border: 0px solid black;width:510px;"id="infothree">
  <div style="height:36px;border: 0px solid black;width:510px;background-image: url('png/2017051711342597367.png');background-repeat:no-repeat;background-color: #EFEFEF;font-size: 16px;line-height: 30px;color:white;">
   &nbsp;&nbsp;政务信息
  </div>
   <ul >
  <li>
住房公积金归集执法-单位登记开户
  </li>
  <li>住房公积金归集执法-公积金查询
</li>
  <li>住房公积金归集执法-单位信息变更
</li>
  <li>住房公积金归集执法-个人信息变更
</li>
  <li>住房公积金归集执法-单位汇缴、补缴
</li>
  <li>住房公积金归集执法-购买北京市行政区域...
</li>
  </ul>
  </div>
  
  </div>
 
 <!-- 互动服务 -->
 <div style="width:1200px;height:200px;border:0px solid black;" id="service">
 <div style="height:36px;border: 0px solid black;width:1200px;background-image: url('png/2017051711342597367.png');background-repeat:no-repeat;background-color: #EFEFEF;font-size: 16px;line-height: 30px;color:white;">
  &nbsp;&nbsp; 互动服务
  </div>
  <ul>
    <li><a href="#"><img alt="" src="png/2018042601.png" ></a> </li>
    <li><a href="#"><img alt="" src="png/2018042602.png" ></a>  </li>
    <li><a href="#"><img alt="" src="png/2018042603.png" ></a>  </li>
    <li><a href="#"><img alt="" src="png/2018042604.png" ></a>  </li>
    <li><a href="#"><img alt="" src="png/2018042605.png" ></a>  </li>
    <li><a href="#"><img alt="" src="png/2018042606.png" ></a>  </li>
  </ul>
 </div>
  
</div>





</div>
<!-- 尾部 -->
<div style="border:0px solid black; width:100%;height:225px;">

   <div style="border:0px solid black;width:1500px;height:220px;margin-left: 200px;background-color:#016EC5;">
    
    
     <div style="border:0px solid black;width:800px;height:200px;margin-left:360px;margin-top:0px;">
       <div style="border:0px solid black;width:800px;height:100px;color:white;font-size:10px;text-align: center;line-height: 100px; ">
       版权所有：**住房公积金管理中心 京公网安备10086 京ICP备1383838号 客服电话：10010
       </div>
       
       <div style="border:0px solid black;width:800px;height:100px;" id="last">
         <ul style="border:0px solid black;width:400px;height:100px;margin-left:200px;">
           <li><a href="#"><img alt="" src="png/blue.png" style="top:10px;left:30px;"></a> </li>
           <li><a href="#"><img alt="" src="png/jiucuo.png-v=-+sitecode+-.png"></a> </li>
           <li><a href="#"><img alt="" src="png/2018042315070456187.png"></a> </li>
         </ul>
       </div>
     </div>
     
   </div>

</div>




</div>
  </body>
  <script type="text/javascript">
 /*  $("#topmenuul li").hover(
  function(){
  alert(11);
    $(this).css("background-color","#016ec5");
  },function(){
  $(this).css("background-color","#318cd4");
  }
  	) */
  
  
  
  </script>
</html>
