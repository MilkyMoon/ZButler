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
<title>主页</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="index">
		<div class="index_guessYourLike">
			
			<c:if test="${!empty buss}">
			<h5>商店</h5>
			<c:forEach items="${buss}" var="bus">
				<a
					href="<%=basePath%>offlineStore_queryBusines.action?city=${city}&busId=${bus.busId}"><div
						class="index_guessItem">
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
					</div> </a>
			</c:forEach>
			</c:if>
			
			
			<c:if test="${!empty cate}">
			<h5>分类</h5>
			<c:forEach items="${cate}" var="bus">
				<a
					href="<%=basePath%>offlineStore_queryBusines.action?city=${city}&busId=${bus.busId}"><div
						class="index_guessItem">
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
					</div> </a>
			</c:forEach>
			</c:if>
			<c:if test="${empty cate and empty cate}">
				<p style="text-align: center; font-size: 17px">没有相关商店</p>
				<p style="text-align: center"><a href="<%=basePath%>offlineStore!offline.action" style="color:red; font-size: 21px; margin-top: 5px;">返回</a></p>
			</c:if>
			<%-- <div class="index_guessItem">
				<img src="image/111.jpg" />
				<div class="guess_content">
					<div>
						<span class="guess_name">鲜乐多</span> <span class="guess_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div>
			<div class="index_guessItem">
				<img src="image/111.jpg" />
				<div class="guess_content">
					<div>
						<span class="guess_name">鲜乐多</span> <span class="guess_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div>
			<div class="index_guessItem">
				<img src="<%=basePath%>home/dist/wx_image/111.jpg" />
				<div class="guess_content">
					<div>
						<span class="guess_name">鲜乐多</span> <span class="guess_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div> --%>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.citys.js"></script>
</html>
