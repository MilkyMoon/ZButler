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
<title>忘记密码</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">

</head>

<body>
	<div class="forgetPassword2" style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<form id="signupForm" method="post"
			action="<%=basePath%>Customer!update.action">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-right">
						<input type="password" id="cusPassword" name="cusPassword"
							class="cell-input" placeholder="请输入新密码" autocomplete="off" /> <input
							type="hidden" value="cusPassword" name="field">
					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-right">
						<input type="password" name="newPassword2" class="cell-input"
							placeholder="重复新密码" autocomplete="off" />
					</div>
				</div>
			</div>
			<button type="submit" class="btn-block btn-primary">提交</button>
		</form>
	</div>
</body>

<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
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
				cusPassword : "required",
				newPassword2 : {
					required : true,
					equalTo : "#cusPassword"
				}
			},
			messages : {
				cusPassword : "请输入新密码",
				newPassword2 : {
					required : "请再次输入",
					equalTo : "两次输入不一致"
				}
			}
		});
	});
</script>
</html>
