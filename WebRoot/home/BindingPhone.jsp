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
			action="<%=basePath%>Customer!update.action">
			<input type="hidden" name="busId" value="${store.busId}">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-right" id="telDiv">
						<input type="number" class="cell-input" name="cusPhone" id="tel"
							placeholder="请输入手机号" autocomplete="off" /> <input type="hidden"
							value="cusPhone" name="field">
					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-right">
						<input type="number" pattern="[0-9]*" class="cell-input" id="code"
							placeholder="请输入验证码" autocomplete="off" />
						<button type="button" class="btn btn-primary" id="get">获取验证码</button>
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
		var $getCode = $('#get');

		/* 定义参数 */
		$getCode.sendCode({
			disClass : 'btn-disabled',
			secs : 60,
			run : false,
			runStr : '{%s}秒后重新获取',
			resetStr : '重新获取验证码'
		});
		// 在键盘按下并释放及提交后验证提交表单
		$("#signupForm").validate({
			rules : {
				cusPhone : {
					required : true,
				}
			},
			messages : {
				cusPhone : {
					required : "请输入手机号",
				}
			}
		});

		$('#get').click(function() {
			if ($('#tel').val().length !== 11) {
				$('#telDiv').find("label").remove();
				var telError = '<label style="width:50%;color:red;font-size:12px">手机号无效</label>';
				$('#telDiv').append(telError);
			} else {
				var tel = $("#tel").val();
				$.post("<%=basePath%>BindPhoneJson",
					{
						cusPhone : tel,
					},
					function(data) {
						data = $.parseJSON(data);
						if (data.isError === "true") {
							window.YDUI.dialog.alert(data.ErrorMessage);
						} else {
							$("#data").val(hex_md5(data.code));
							YDUI.dialog.loading.open('发送中');
							setTimeout(function() {

								YDUI.dialog.loading.close();

								$getCode.sendCode('start');


							}, 1500);
						}
					});
			}
		});

		$('#tel').focus(function() {
			$('#telDiv').find("label").remove();
		});

		$("#signupForm").submit(function(e) {
			if ($("#data").val() != "empty") {
				if ($("#data").val() != hex_md5($("#code").val())) {
					e.preventDefault();
					window.YDUI.dialog.alert('验证码错误！');
				}
			} else {
				e.preventDefault();
				window.YDUI.dialog.alert('请获取验证码！');
			}
		});
	});
</script>
</html>
