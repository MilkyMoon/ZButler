<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>兴趣爱好</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>

<body>
	<div class="myInterest" style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<form method="post" action="<%=basePath%>Customer!update.action">
			<div class="m-cell">
				<div class="cell-item">
					<div class="cell-right">
						<input type="hidden" value="cusHobby" name="field"> <input
							type="text" class="cell-input" placeholder="兴趣爱好"
							autocomplete="off" name="cusHobby" value="${user.cusHobby}" />
					</div>
				</div>
			</div>
			<span>多个用，隔开</span>
			<button type="submit" class="btn-block btn-primary">提交</button>
		</form>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>
