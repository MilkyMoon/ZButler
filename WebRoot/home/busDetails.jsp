<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>商家详情</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>

<body>
	<div class="businessMessage" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>business_store.action">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<div class="businessMessage_bigImg">
			<img src="${business.busOrgUrl}" />
		</div>
		<div class="businessMessage_businessCommend">
			<div class="businessCommend_title">
				<div class="businessCommend_title_content">
					<h5>${business.busShopName}</h5>
					<div class="businessCommend_title_mark">
						<div class="businessCommend_title_starNum" data="4.2">
							<!--<img src="image/star.png"/>-->
							<!--<img src="image/star.png"/>-->
							<!--<img src="image/star.png"/>-->
							<!--<img src="image/star.png"/>-->
							<!--<img src="image/star.png"/>-->
							<!--<span>5.0</span>-->
						</div>
						<div class="businessCommend_title_buyNum">
							消费次数: <span>${fn:length(business.busTradings)}</span>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-primary" id="gotoPay">去付款</button>
			</div>
			<div class="businessCommend_detail">
				<h5>商家介绍</h5>
				<p>${business.busDesc}</p>
			</div>
			<div class="businessCommend_address">
				<div id="address" class="address">
					<i class="icon-location"></i>
					<p>${business.baProvince}${business.baCity}${business.baCounty}${business.baAddress}</p>
				</div>

				<div class="businessCommend_address_phone">
					<a href="tel:${business.busPhone}"><img
						src="<%=basePath%>home/dist/wx_image/ic_phone.png" /></a>
				</div>
			</div>
		</div>
<!-- 		<div class="businessMessage_evaluate">
			<h5>
				评价（<span>0</span>）
			</h5>
		</div> -->

		<div class="businessMessage_hotBusiness">
			<h5>热门商家</h5>
			<c:forEach items="${hots}" var="bus">
				<a
					href="<%=basePath%>offlineStore_queryBusines.action?city=${city}&busId=${bus.busId}">
					<div class="index_guessItem">
						<img src="${bus.busOrgUrl}" />
						<div class="guess_content">
							<div>
								<span class="guess_name">${bus.busShopName}</span> <span
									class="guess_mark"><fmt:formatNumber type="number" maxFractionDigits="0" value="${bus.busScalePoints * 100}" />%</span>
							</div>
							<div>
								<span>${bus.cateLine.calName}</span> <span>其他</span>
							</div>
						</div>
					</div>
				</a>
			</c:forEach>
			<!-- <div class="businessMessage_hotBusinessItem">
				<img src="image/111.jpg" />
				<div class="hotBusiness_content">
					<div>
						<span class="hotBusiness_name">鲜乐多</span> <span
							class="hotBusiness_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div>
			<div class="businessMessage_hotBusinessItem">
				<img src="image/111.jpg" />
				<div class="hotBusiness_content">
					<div>
						<span class="hotBusiness_name">鲜乐多</span> <span
							class="hotBusiness_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div>
			<div class="businessMessage_hotBusinessItem">
				<img src="image/111.jpg" />
				<div class="hotBusiness_content">
					<div>
						<span class="hotBusiness_name">鲜乐多</span>
						<span class="hotBusiness_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div> -->
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<%-- <script src="<%=basePath%>home/dist/wx_js/ydui.js"></script> --%>
<script type="text/javascript">

	$.ajax({
		type : "post",
		dataType : "json",
		url : "<%=basePath%>WxJsApi!JsApiParams.action",
		async : false,
		data : {
			url : location.href.split("#")[0]
		},
		success : function(result) {
			var config = JSON.parse(result);
			config.debug = false;
			config.jsApiList = [
				'openLocation',
			];
			wx.config(config)
		}
	});
	
	$("#gotoPay").click(function(){
		window.location.href = "<%=basePath%>WxOauthRedirect!IntoPayPage.action?busId=${business.busId}"
	});

	$("#address").click(function() {
		wx.openLocation({
			latitude : ${business.baLatitude},// 纬度，浮点数，范围为90 ~ -90
			longitude : ${business.baLongitude}, // 经度，浮点数，范围为180 ~ -180。
			name : '${business.baProvince}${business.baCity}${business.baCounty}',// 位置名
			address : '${business.baAddress}',// 地址详情说明
			scale : 18// 地图缩放级别,整形值,范围从1~28。默认为最大
		});

	})
</script>
</html>

