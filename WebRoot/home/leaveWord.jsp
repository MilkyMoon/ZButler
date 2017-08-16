<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<title>留言</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>
<body>
	<div class="leaveWord" style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<s:iterator id="message" value="messageList" status="">
			<div class="leaveWordItem">
				<div class="leaveWord_title">
					<div>
						留言：<span><s:property value="customer.cusNickname"></s:property></span>-<span><s:property
								value="mesTimeStr"></s:property></span>
					</div>
					<a
						href="<%=basePath%>Message_del?mesId=<s:property value="mesId"></s:property>">删除</a>
				</div>
				<div class="leaveWord_content">
					<span><s:property value="mesContent"></s:property>
				</div>
			</div>
		</s:iterator>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>