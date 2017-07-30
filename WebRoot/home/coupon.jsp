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
<title>优惠券</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="coupon" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>home/customer.jsp">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<c:forEach var="coupon" items="${usable}" varStatus="i">
			<div class="couponItem">
				<div class="couponItem_num">
					<span>${coupon.busCoupon.bcRebate}</span>&nbsp;元
				</div>
				<div class="couponItem_name">
					<fmt:formatDate value="${coupon.busCoupon.bcEndDate}"
						pattern="yyyy-MM-dd" />
					截止<br>未使用
				</div>
			</div>
		</c:forEach>

		<c:forEach var="coupon" items="${used}" varStatus="i">
			<div class="couponItem">
				<div class="cantUse"></div>
				<div class="couponItem_num">
					<span>${coupon.busCoupon.bcRebate}</span>&nbsp;元
				</div>
				<div class="couponItem_name">
					<fmt:formatDate value="${coupon.busCoupon.bcEndDate}"
						pattern="yyyy-MM-dd" />
					截止<br>已使用
				</div>
			</div>
		</c:forEach>

		<c:forEach var="coupon" items="${expired}" varStatus="i">
			<div class="couponItem">
				<div class="cantUse"></div>
				<div class="couponItem_num">
					<span>${coupon.busCoupon.bcRebate}</span>&nbsp;元
				</div>
				<div class="couponItem_name">
					<fmt:formatDate value="${coupon.busCoupon.bcEndDate}"
						pattern="yyyy-MM-dd" />
					截止<br>已过期
				</div>
			</div>
		</c:forEach>

	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>
