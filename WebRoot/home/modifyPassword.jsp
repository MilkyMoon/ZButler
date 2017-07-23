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
<title>修改密码</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="modifyPassword">
		<form id="signupForm" method="post" action="<%=basePath%>Customer!update.action">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-right">
						<input type="password"  class="cell-input" id="old" name="old"
							placeholder="原密码" autocomplete="off" />
						<input type="hidden" value="cusPassword" name="field">
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-right">
						<input type="password" id="password" name="cusPassword"
							class="cell-input" placeholder="新密码" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-right">
						<input type="password"  class="cell-input" id ="comfirm" name="new2"
							placeholder="重复密码" autocomplete="off" />
					</div>
				</div>
			</div>
			<button type="submit" class="btn-block btn-primary">确认修改</button>
		</form>
	</div>
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
				old : "required",
				cusPassword : "required",
				new2 : {
					required : true,
					equalTo : "#password"
				}
			},
			messages : {
				old : "请输入原密码",
				cusPassword : "请输入新密码",
				new2 : {
					required : "请重复新密码",
					equalTo : "两次输入不一致"
				}
			}
		});
		
		$("#signupForm").submit(function(e) {
			if (hex_md5($("#old").val()) != hex_md5("${user.cusPassword}")) {
				e.preventDefault();
				window.YDUI.dialog.alert('密码错误！');
			}
		});
	});
</script>
</html>
