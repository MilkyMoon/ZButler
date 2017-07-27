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
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>提现账户2</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="takeMoneyAccount2">
		<form id="signupForm" action="<%=basePath%>CusBank!add.action" method="post">
			<div class="m-cell">
				<div class="cell-item">
					<div class="cell-left">账户姓名：</div>
					<div class="cell-right">
						<input type="text" name="cbBankPerson" class="cell-input" placeholder="张三"
							autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">储蓄卡号：</div>
					<div class="cell-right">
						<input type="text" name="cbBankCard"  id="haorooms"
							class="cell-input" placeholder="0000****000" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">银行名称：</div>
					<div class="cell-right">
						<input type="text" name="cbBank" class="cell-input" 
							placeholder="中国建设银行" autocomplete="off" />
					</div>
				</div>
			</div>
			<div class="takeMoneyAccount2_button">
				<button type="submit" class="btn-block btn-primary">添加</button>
			</div>
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
				cbBankPerson : "required",
				cbBankCard : {
					required:true,
					maxlength:23
				},
				cbBank : "required",
			},
			messages : {
				cbBankPerson : "请输入姓名",
				cbBankCard : {
					required: "请输入储蓄卡号",
					maxlength: "长度为23"
				},
				cbBank : "请输入银行名称",
			}
		});
		$('#haorooms').on('keyup', function(e) {
			//只对输入数字时进行处理
			if ((e.which >= 48 && e.which <= 57) ||
				(e.which >= 96 && e.which <= 105)) {
				//获取当前光标的位置
				var caret = this.selectionStart;
				//获取当前的value;
				var value = this.value;
				//从左边沿到坐标之间的空格数
				var sp = (value.slice(0, caret).match(/\s/g) || []).length;
				//去掉所有空格
				var nospace = value.replace(/\s/g, '');
				//重新插入空格
				var curVal = this.value = nospace.replace(/(\d{4})/g, "$1 ").trim();
				//从左边沿到原坐标之间的空格数
				var curSp = (curVal.slice(0, caret).match(/\s/g) || []).length;
				//修正光标位置
				this.selectionEnd = this.selectionStart = caret + curSp - sp;

			}
		})
	});
</script>
</html>
