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
<title>现金付款</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>
<body>
	<div class="xianjinfukuan">
		<form id="signupForm" method="post" action="<%=basePath%>busTrading_payByCash">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-right">
						<input type="number" class="cell-input" name="tel" id="Phone"
							placeholder="请输入手机号码" autocomplete="off" /> <input type="hidden"
							name="busId" value="${store.busId }" />
					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-right">
						<input type="text" class="cell-input" id="number" name="money"
							placeholder="会员消费金额，需大于10元" autocomplete="off" />
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
	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		$("#signupForm").validate({
			rules : {
				tel : {
					required : true,
					rangelength : [ 11, 11 ]
				}
			},
			messages : {
				tel : {
					required : "请输入手机号",
					rangelength : "手机号无效"
				}
			}
		});

		$("#signupForm").submit(function(e) {
			if ($("#number").val() < 0) {
				e.preventDefault();
				window.YDUI.dialog.alert('输入金额必须大于10！');
			}
			if ($("#Phone").val() == ${user.cusPhone}) {
				e.preventDefault();
				window.YDUI.dialog.alert('不能输入自己的电话号码！');
			}
		});
	});
</script>
</html>
