<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>我的店铺</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="myStore">
		<div class="myStore_content">
			<div style="background-color: #D0021B">收款明细</div>
			<div style="background-color: #F5A623">提现明细</div>
			<div style="background-color: #C767DA">现金收款</div>
			<div style="background-color: #8B572A">商户编辑</div>
			<div style="background-color: #7ED321">店铺图片</div>
			<div style="background-color: #417505">返点比例</div>
			<div style="background-color: #4A90E2">提现账户</div>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
    $('.myStore').css('height', document.body.scrollHeight);
</script>
</html>
