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

</head>

<body>
	<div class="forgetPassword">
		<form id="signupForm" action="<%=basePath%>Customer!toForgetTwo.action" method="post">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-right" id="telDiv">
						<input type="number" name="tel" class="cell-input" id="tel"
							placeholder="请输入手机号" autocomplete="off" value="${user.cusPhone}" />
					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-right">
						<input type="number" pattern="[0-9]*" class="cell-input" id="code"
							placeholder="请输入验证码" autocomplete="off" />
						<button type="submit" class="btn btn-primary" id="get">获取验证码</button>
					</div>
				</div>
			</div>
			<button type="submit" class="btn-block btn-primary">下一步</button>
		</form>
	</div>
	<input type="hidden" id="data" value="empty" />
</body>

<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
<script>

	//    表单验证

	/* $.validator.setDefaults({
	    submitHandler: function () {
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

		$getCode.on('click', function() {
			/* ajax 成功发送验证码后调用【start】 */
			YDUI.dialog.loading.open('发送中');
			setTimeout(function() {

				YDUI.dialog.loading.close();

				$getCode.sendCode('start');


			}, 1500);
		});
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
		//        点击验证码验证手机号
		$('#get').click(function() {
			if ($('#tel').val().length !== 11) {
				$('#telDiv').find("label").remove();
				var telError = '<label style="width:50%;color:red;font-size:12px">手机号无效</label>';
				$('#telDiv').append(telError);
			} else {
				var tel = $("#tel").val();
				if (tel != "${user.cusPhone}") {
					window.YDUI.dialog.alert("请输入绑定手机号");
				} else {

					$.post("<%=basePath%>ForgetPassJson",
						{
							cusPhone : tel,
						},
						function(data) {
							data = $.parseJSON(data);
							console.log(data);
							if (data.isError === "true") {
								window.YDUI.dialog.alert(data.ErrorMessage);
							} else {

								$("#data").val(data.code);
							}
						});
				}

			}
		});

		$('#tel').focus(function() {
			$('#telDiv').find("label").remove();
		});

		$("#signupForm").submit(function(e) {

			if ($("#data").val() != $("#code").val()) {
				e.preventDefault();
				window.YDUI.dialog.alert('验证码错误！');
			}

		});

	});
</script>
</html>