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

<title>My JSP 'WeXinTest.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>

<body>
	This is my JSP page.
	<br>
</body>

</html>
<script type="text/javascript">
	$.ajax({
		type : "post",
		dataType : "json",
		url : "<%=basePath%>/ZButler/WxJsApi!JsApiParams.action",
		async : true,
		data : {
			url : location.href.split("#")[0]
		},
		success : function(result) {
			var config = JSON.parse(result);

			config.debug = true;
			config.jsApiList = [
				'onMenuShareTimeline',
				'onMenuShareAppMessage'
			];
			wx.config(config)
		}
	});

	wx.onMenuShareTimeline({
		title : '', // 分享标题
		link : '', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
		imgUrl : '', // 分享图标
		success : function() {
			// 用户确认分享后执行的回调函数
			alert("分享成功");
		},
		cancel : function() {
			// 用户取消分享后执行的回调函数
			alert("分享失败");
		}
	});
</script>