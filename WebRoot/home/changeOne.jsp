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
<title>零钱</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="smallMoney" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>home/customer.jsp">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<div class="smallMoney_content">
			<div class="smallMoney_content_left">
				<div class="smallMoney_content_canUse">
					可用零钱&nbsp;&nbsp;<span>${cac.cacChange}</span>元
				</div>
				<div class="smallMoney_content_cantUse">
					冻结零钱：&nbsp;&nbsp;<span>0.00</span>
				</div>
			</div>
			<div class="smallMoney_content_right">
				<i class="fa fa-angle-right"></i>
			</div>
		</div>
		<div class="smallMoney_operation">
			<a href="#">交易记录</a> <a
				href="<%=basePath%>WxOauthRedirect!IntoRechage.action">充值</a>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>
