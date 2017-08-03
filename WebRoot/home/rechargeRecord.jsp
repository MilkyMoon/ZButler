<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>提现记录</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">

</head>

<body>
	<div class="takeMoneyRecord" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>CusAccount!change.action">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<c:forEach var="cta" items="${ctas}">
			<div class="takeMoneyItem">
				<div class="takeMoney_num">	
					<c:if test="${cta.ctaType == 1}">${cta.ctaMoney}￥</c:if>
					<c:if test="${cta.ctaType == 11}">${cta.ctaMoney * 10}积分</c:if>
				</div>
				<div class="takeMoney_type">
					<c:if test="${cta.ctaType == 1}">充值零钱</c:if>
					<c:if test="${cta.ctaType == 11}">积分转零钱</c:if>
				</div>
				<div class="takeMoney_time"><fmt:formatDate value="${cta.ctaTime}" type="both"  /></div>
			</div>
		</c:forEach>
		<!-- <div class="takeMoneyItem">
			<div class="takeMoney_num">500.00</div>
			<div class="takeMoney_type">零钱</div>
			<div class="takeMoney_time">2017.06.30 &nbsp;12:35</div>
		</div>
		<div class="takeMoneyItem">
			<div class="takeMoney_num">500.00</div>
			<div class="takeMoney_type">零钱</div>
			<div class="takeMoney_time">2017.06.30 &nbsp;12:35</div>
		</div>
		<div class="takeMoneyItem">
			<div class="takeMoney_num">500.00</div>
			<div class="takeMoney_type">零钱</div>
			<div class="takeMoney_time">2017.06.30 &nbsp;12:35</div>
		</div> -->

	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>
