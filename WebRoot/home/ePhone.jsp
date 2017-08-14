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
<title>手机绑定</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">

</head>

<body>
	<div class="phoneBind" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>home/customer.jsp">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<form id="signupForm" method="post"
			action="<%=basePath%>business_updateEPhone.action">
			<input type="hidden" name="busId" value="${store.busId}">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-right" id="telDiv">
						<input type="number" class="cell-input" name="busEphone" id="tel" value="${store.busEphone}"
							placeholder="请输入手机号" autocomplete="off" /> 
					</div>
				</div>
			</div>
			<button type="submit" class="btn-block btn-primary">提交</button>
		</form>
	</div>
	<input type="hidden" id="data" value="empty" />
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
<script src="<%=basePath%>home/dist/wx_js/md5.js"></script>
<script>

	//    表单验证

	/* 	$.validator.setDefaults({
			submitHandler : function() {
				alert("提交事件!");
			}
		}); */

	$().ready(function() {
		
		// 在键盘按下并释放及提交后验证提交表单
		$("#signupForm").validate({
			rules : {
				busEphone : {
					required : true,
					rangelength : [ 11, 11 ]
				}
			},
			messages : {
				busEphone : {
					required : "请输入手机号",
					rangelength : "手机号长度为11位"
				}
			}
		});

		
	});
</script>
</html>
