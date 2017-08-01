<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

</head>

<body>
	<div class="businessMessage">
		<div class="businessMessage_bigImg">
			<img src="${business.busOrgUrl}" />
		</div>
		<div class="businessMessage_businessCommend">
			<div class="businessCommend_title">
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
			<div class="businessCommend_detail">
				<h5>商家介绍</h5>
				<p>${business.busDesc}</p>
			</div>
			<div class="businessCommend_address">
				<i class="icon-location"></i>
				<p>${business.baProvince}${business.baCity}${business.baCounty}${business.baAddress}</p>
				<div class="businessCommend_address_phone">
					<img src="<%=basePath%>home/dist/wx_image/ic_phone.png" />
				</div>
			</div>
		</div>
		<div class="businessMessage_evaluate">
			<h5>
				评价（<span>0</span>）
			</h5>
			<!-- <div class="businessMessage_evaluateItem">
				<div class="businessMessage_evaluateItem_title">
					<div>肖*****浪</div>
					<span>6月5日</span>
				</div>
				<div class="businessMessage_evaluateItem_starNum" data="4">
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<span>5.0</span>
				</div>
				<p>非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃</p>
			</div>

			<div class="businessMessage_evaluateItem">
				<div class="businessMessage_evaluateItem_title">
					<div>肖*****浪</div>
					<span>6月5日</span>
				</div>
				<div class="businessMessage_evaluateItem_starNum" data="3.6">
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<img src="image/star.png"/>
					<span>5.0</span>
				</div>
				<p>非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃非常好吃</p>
			</div>
			<div class="businessMessage_evaluate_more">
				<a href="#">加载更多+</a>
			</div> -->
		</div>

		<div class="businessMessage_hotBusiness">
			<h5>热门商家</h5>
			<c:forEach items="${hots}" var="bus">
				<a href="<%=basePath%>offlineStore_queryBusines.action?city=${city}&busId=${bus.busId}">
					<div class="index_guessItem">
						<img src="${bus.busOrgUrl}" />
						<div class="guess_content">
							<div>
								<span class="guess_name">${bus.busShopName}</span> <span
									class="guess_mark">10%</span>
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
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/score.js"></script>
</html>
