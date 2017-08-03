<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
    <title>返点比例</title>
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

  </head>
  
  <body>
    <div class="rebateProportion">
    <div><span></span>10%</div>
    <div>您的返点比例</div>
</div>
  </body>
  <script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
	$('.rebateProportion').css('height', document.body.scrollHeight);
</script>
</html>
