<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>积分</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="integral">
		<div class="integral_content">
			<div class="integral_content_left">
				<div class="integral_content_canUse">
					我的积分&nbsp;&nbsp;<span>${cac.cacPoints}</span>
				</div>
				<div class="integral_content_cantUse">
					<span>亲，您没有积分，会错过奖金哦！</span><br> <span>线下消费、淘宝天猫京东购物、零钱充值，都可以获得积分！</span>
				</div>
			</div>
			<div class="integral_content_right">
				<i class="fa fa-angle-right"></i>
			</div>
		</div>
		<div class="integral_operation">
			<a href="#">充值记录</a>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>
