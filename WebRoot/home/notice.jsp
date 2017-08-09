<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>消息中心</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">

</head>

<body>
	<div class="leaveWordList">
		<div class="leaveWordListItems">
			<c:forEach var="root" items="${roots}">
				<div class="leaveWordListItem">
					<span>${root.title}</span> <span class="leaveWordListItem_time">${root.time}</span>
					<div class="leaveWordListItem_dialog">${root.content}</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
	$('.leaveWordListItem').click(function() {
		if ($(this).find('.leaveWordListItem_dialog').css('display') === 'none') {
			$(this).find('.leaveWordListItem_dialog').css('display', 'block');
		} else {
			$(this).find('.leaveWordListItem_dialog').css('display', 'none');
		}
	})
</script>

</html>
