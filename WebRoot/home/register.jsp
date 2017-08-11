<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>注册</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="register" style="margin-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>home/login.jsp">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<form id="signupForm" method="post"
			action="<%=basePath%>Customer!register.action">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-right" id="telDiv">
						<input type="number" pattern="[0-9]*" name="cusPhone" id="tel"
							class="cell-input" placeholder="请输入手机号" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-right" id="passDiv">
						<input type="password" name="cusPassword" class="cell-input"
							id="pass" placeholder="请输入登录密码" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-right">
						<input type="number" pattern="[0-9]*" class="cell-input"
							name="valid" id="code" placeholder="请输入验证码" autocomplete="off" />
						<button type="button" class="btn btn-primary" id="get">获取验证码</button>
					</div>
				</div>
			</div>
			<div class="register_readed">
				<input name="rePassword" type="checkbox" value="" /> <span>我已看过并接受<a
					href="<%=basePath%>">《用户协议》</a></span>
			</div>
			<div class="register_button">
				<button type="submit" class="btn-block btn-primary" id="zhuce">注册</button>
			</div>
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

	/* $.validator.setDefaults({
		submitHandler : function() {
			comsole.log("------------");
			if (data.code != $("#code").val()) {
				window.YDUI.dialog.alert('验证码错误！');
			}
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
				},
				cusPassword : "required"
			},
			messages : {
				cusPhone : {
					required : "请输入手机号"
				},
				cusPassword : "请输入密码"
			}
		});

		//        点击验证码验证手机号
		$('#get').click(function() {
			$("#data").val("empty");
			if ($('#tel').val().length !== 11) {
				$('#telDiv').find("label").remove();
				var telError = '<label style="width:50%;color:red;font-size:12px">手机号无效</label>';
				$('#telDiv').append(telError);
			} else if ($('#pass').val().length < 6) {
				$('#passDiv').find("label").remove();
				var passError = '<label style="width:50%;color:red;font-size:12px">密码长度必须大于等于6位</label>';
				$('#passDiv').append(passError);
			} else {
				var tel = $("#tel").val();
				$.post("<%=basePath%>CustomerJson",
					{
						cusPhone : tel,
					},
					function(data) {
					console.log(data);
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
		//        手机号获取焦点
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

		$('#zhuce').click(function() {
			if ($('input[name="rePassword"]').prop("checked")) {
				$('.register_readed').find('.error').remove();
			} else {
				var error = '<span class="error">请接受此项</span>';
				$('.register_readed').find('.error').remove();
				$('.register_readed').append(error);
				return false
			}
		});
	});
</script>
</html>
