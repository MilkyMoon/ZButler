<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>我的订单</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>
<body>
	<div class="myOrder" style="padding-top:53px;">
			<div class="integral2_top">
				<div class="integral2_top_left">
					<i class="fa fa-angle-left"></i> <a
						href="<%=basePath%>home/customer.jsp">返回</a>
				</div>
				<div class="integral2_top_center"></div>
			</div>
			<%-- <s:iterator id="order" value="orderList" status=""> --%>
			<c:forEach items="${orderList}" var="order">
				<div class="myOrderItem">
					<div class="myOrder_content">
						<div class="myOrder_message">
							<div class="myOrder_storeName">订单ID： ${order.ordId}</div>
							<div class="myOrder_order">
								<div class="myOrder_orderImg">
									<img src="<%=basePath%>home/dist/wx_image/111.jpg" />
								</div>
								<div class="myOrder_orderContent">
									<div class="myOrder_food">A1套餐+饮料【不存在的】</div>
									<div class="myOrder_price">￥${order.ordMoney }</div>
								</div>
							</div>
						</div>
						<div class="myOrder_state">
							<span> <c:if test="${order.ordStatus=='0'}">尚未付款</c:if> <c:if
									test="${order.ordStatus=='1'}">等待发货</c:if> <c:if
									test="${order.ordStatus=='2'}">等待收货</c:if> <c:if
									test="${order.ordStatus=='3'}">尚未评价</c:if> <c:if
									test="${order.ordStatus=='4'}">交易完成</c:if>
							</span> <span>${order.ordStartTimeStr }</span>
						</div>
					</div>
					<button type="button" class="btn btn-primary">
						<c:if test="${order.ordStatus=='0'}">去付款</c:if>
						<c:if test="${order.ordStatus=='1'}">查看物流</c:if>
						<c:if test="${order.ordStatus=='2'}">确认收货</c:if>
						<c:if test="${order.ordStatus=='3'}">评价</c:if>
						<c:if test="${order.ordStatus=='4'}">退换/售后</c:if>
					</button>
				</div>
			</c:forEach>
			<c:forEach items="${bills}" var="bill">
				<div class="myOrderItem">
					<div class="myOrder_content">
						<div class="myOrder_message">
							<div class="myOrder_storeName">订单ID： ${bill.bilId}</div>
							<div class="myOrder_order">
								<div class="myOrder_orderImg">
									<img src="<%=basePath%>home/dist/wx_image/111.jpg" />
								</div>
								<div class="myOrder_orderContent">
									<div class="myOrder_food">线下付款</div>
									<div class="myOrder_price">￥<fmt:formatNumber type="number" maxFractionDigits="12" value="${bill.bilCusMoney}" /></div>
								</div>
							</div>
						</div>
						<div class="myOrder_state">
							<span>交易完成
							</span> <span><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${bill.bilDate}" /></span>
						</div>
					</div>
				</div>
			</c:forEach>
			<%-- <div class="myOrderItem">
			<div class="myOrder_content">
				<div class="myOrder_message">
					<div class="myOrder_storeName">安徽牛肉板面</div>
					<div class="myOrder_order">
						<div class="myOrder_orderImg">
							<img src="<%=basePath%>home/dist/wx_image/111.jpg" />
						</div>
						<div class="myOrder_orderContent">
							<div class="myOrder_food">A1套餐+饮料</div>
							<div class="myOrder_price">￥22.00</div>
						</div>
					</div>
				</div>
				<div class="myOrder_state">
					<span>交易完成</span> <span>2017.06.30</span>
				</div>
			</div>
			<button type="button" class="btn btn-primary">去付款</button>
		</div>
		<div class="myOrderItem">
			<div class="myOrder_content">
				<div class="myOrder_message">
					<div class="myOrder_storeName">安徽牛肉板面</div>
					<div class="myOrder_order">
						<div class="myOrder_orderImg">
							<img src="<%=basePath%>home/dist/wx_image/111.jpg" />
						</div>
						<div class="myOrder_orderContent">
							<div class="myOrder_food">A1套餐+饮料</div>
							<div class="myOrder_price">￥22.00</div>
						</div>
					</div>
				</div>
				<div class="myOrder_state">
					<span>交易完成</span> <span>2017.06.30</span>
				</div>
			</div>
			<button type="button" class="btn btn-primary">确认收货</button>
		</div> --%>
		</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>