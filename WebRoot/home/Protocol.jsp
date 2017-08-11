<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>用户协议</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>

<body>
	
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
	$('.rebateProportion').css('height', document.body.scrollHeight);
</script>
</html>
