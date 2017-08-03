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
<title>提现记录</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="takeMoneyRecord">
		<c:forEach var="item" items="${Withdraw}">
			<div class="takeMoneyItem">
				<div class="takeMoney_num">${item.btaMoney}¥</div>
				<div class="takeMoney_type">提现零钱</div>
				<c:if test="${item.btaStatus == 0}"><div style="color:red">待审核</div> </c:if>
				<c:if test="${item.btaStatus == 1}"><div>已审核</div></c:if>
				<div class="takeMoney_time"><fmt:formatDate value="${item.btaTime}" type="both" /> </div>
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
		</div> -->

	</div>
</body>

<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>
