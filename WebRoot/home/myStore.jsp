<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>

<body>
	<div class="myStore" style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<div class="myStore_content">

					<c:if test="${!empty store and store.busStatus != 0}">
						<a href="<%=basePath%>busTrading_queryIncome"><div style="background-color: #D0021B">收款明细</div></a>
						<%-- <a href="<%=basePath%>busTrading_queryWithdraw"><div style="background-color: #F5A623">提现明细</div></a> --%>
						<!-- <div style="background-color: #C767DA">现金收款</div> -->
						<a href="<%=basePath%>cateLine_editBus"><div style="background-color: #8B572A">商户编辑</div></a>
						<a href="<%=basePath%>home/storeImg.jsp"><div style="background-color: #7ED321">店铺图片</div></a>
						<a href="<%=basePath%>pictures_Img"><div style="background-color: #B2EBF2">店铺轮播图</div></a>
						<a href="<%=basePath%>home/rebateProportion.jsp"><div style="background-color: #417505">返点比例</div></a>
						<a href="<%=basePath%>home/ePhone.jsp"><div style="background-color: #663399">店员手机</div></a>
						<a href="<%=basePath%>home/PayByCash.jsp"><div style="background-color: #006600">现金支付</div></a>
						<%-- <c:if test="${store.busLevel == 3}">
							<a href="<%=basePath%>home/busSmallMoney.jsp">
								<div style="background-color: #4A90E2">零钱提现</div>
							</a>
						</c:if> --%>
						<a href="<%=basePath%>home/storeReceipts.jsp"><div style="background-color: #4A90E2">商家收款</div></a>
					</c:if>
					<c:if test="${!empty store and store.busStatus == 0}">
						<p style="color:red;font-size:18px;text-align: center;width:100%">申请尚未通过，如有疑问请留言或质询客服</p>
					</c:if>

			<c:if test="${empty store}">
				<p style="color:red;font-size:18px;text-align:center;width:100%">还未申请商铺</p>
			</c:if>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
${js}
<script>
	$('.myStore').css('height', document.body.scrollHeight);
</script>
</html>
