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
<title>分类</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="fenlei">
		<div class="m-cell">
			<div class="cell-item">
				<label class="cell-right"> <select class="cell-select"
					id="selectCate">
						<c:forEach var="cate" items="${cates}" varStatus="i">
							<c:if test="${child eq -1}">
								<c:if test="${i.index eq 0}">
									<option value="${cate.calId}" selected="selected">${cate.calName}</option>
								</c:if>
								<c:if test="${i.index ne 0}">
									<option value="${cate.calId}">${cate.calName}</option>
								</c:if>
							</c:if>
							<c:if test="${child ne -1}">
								<c:if test="${cate.calId eq child}">
									<option value="${cate.calId}" selected="selected">${cate.calName}</option>
								</c:if>
								<c:if test="${cate.calId ne child}">
									<option value="${cate.calId}">${cate.calName}</option>
								</c:if>
							</c:if>
						</c:forEach>
				</select>
				</label>
			</div>
		</div>
		<div class="fenleiList">
			<c:forEach var="bus" items="${buss}">
				<a href="<%=basePath%>offlineStore_queryBusines.action?city=${city}&busId=${bus.busId}">
					<div class="fenleiItem">
						<img src="${bus.busOrgUrl}" />
						<div class="fenleiItem_content">
							<div class="fenleiItem_content_title">
								<div class="fenleiItem_name">${bus.busShopName}</div>
								<span class="fenleiItem_mark"><fmt:formatNumber type="number" maxFractionDigits="0" value="${bus.busScalePoints * 100}" />%</span>
							</div>
							<div>${name}</div>
							<div>
								消费人数 <span>${fn:length(business.busTradings)}</span>人
							</div>
							<div class="businessCommend_title_starNum" data="3.1">
								<!--<img src="image/star.png"/>-->
								<!--<img src="image/star.png"/>-->
								<!--<img src="image/star.png"/>-->
								<!--<img src="image/star.png"/>-->
								<!--<img src="image/star.png"/>-->
								<!--<span>5.0</span>-->
							</div>
						</div>
					</div>
				</a>
			</c:forEach>

		</div>

	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/score.js"></script>
<script type="text/javascript">
	$("#selectCate").change(function(){
		window.location.href = "<%=basePath%>offlineStore!queryCate.action?cate=${cate}&child="+$(this).val();
	});
</script>
</html>
