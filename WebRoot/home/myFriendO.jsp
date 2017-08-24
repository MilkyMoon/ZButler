<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>我的朋友圈</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>
<body>
	<div class="myFriendO" style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<div class="myFriendO_myMessage">
			<div class="myFriendO_myMessage_head">
				<img src="${user.cusImgUrl}" />
			</div>
			<div class="myFriendO_myMessage_content">
				<div class="userName">${user.cusNickname}</div>
				<span><c:if test="${empty user.businesses}">普通会员</c:if> <c:forEach
						var="business" items="${user.businesses}" begin="0" end="0">
						<c:if test="${business.busLevel == 1}">会员</c:if>
						<c:if test="${business.busLevel == 0}">商家</c:if>
						<c:if test="${business.busLevel == 2}">创业合伙人</c:if>
					</c:forEach></span>
			</div>
		</div>
		<div class="myFriendO_myFriends">
			<div class="myFriendO_myFriends_num">
				我的朋友：<span>${fn:length(friA) + fn:length(friB) + fn:length(friC)}</span>
			</div>
			<%-- <s:iterator id="friends" value="friendsList" status="">
				<div class="myFriendO_myFriendItem">
					<a href="#"><s:property value="friPhone" /> </a>
				</div>
			</s:iterator> --%>

			<div class="myFriendO_myFriendItem">
				我的朋友A<span>${fn:length(friA)}</span>
				<div class="myFriendO_myFriendItem_down">
					<c:forEach var="A" items="${friA}">
						<div>${A.friPhone}</div>
					</c:forEach>
				</div>
			</div>
			<div class="myFriendO_myFriendItem">
				我的朋友B<span>${fn:length(friB)}</span>
				<div class="myFriendO_myFriendItem_down">
					<c:forEach var="B" items="${friB}">
						<div>${B.friPhone}</div>
					</c:forEach>
				</div>
			</div>
			<div class="myFriendO_myFriendItem">
				我的朋友C<span>${fn:length(friC)}</span>
				<div class="myFriendO_myFriendItem_down">
					<c:forEach var="C" items="${friC}">
						<div>${C.friPhone}</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
	$('.myFriendO_myFriendItem').click(function() {
		if ($(this).find('.myFriendO_myFriendItem_down').css('display') === 'block') {
			$('.myFriendO_myFriendItem_down').css('display', 'none');
		} else {
			$('.myFriendO_myFriendItem_down').css('display', 'none');
			$(this).find('.myFriendO_myFriendItem_down').css('display', 'block');
		}
	})
</script>
</html>