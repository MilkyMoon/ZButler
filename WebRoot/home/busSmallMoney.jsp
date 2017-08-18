<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>零钱提现</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">

</head>

<body>
	<div class="takeSmallMoney" style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<form id="signupForm" method="post"
			action="<%=basePath%>CtaTrading!add.action">
			<div class="m-cell">
				<div class="cell-item takeSmallMoney_canUse">
					<div class="cell-left">
						可用的零钱：<span id="change"><fmt:formatNumber type="number" maxFractionDigits="2" value="${cac.cacChange}" /></span>元
					</div>
					<div class="cell-right"></div>
				</div>
				<div class="cell-item">
					<div class="cell-left">提现金额：</div>
					<div class="cell-right">
						<input type="test" name="ctaMoney" class="cell-input"
							placeholder="0.00" id="input" autocomplete="off" />
					</div>
				</div>
				<!-- <div class="cell-item">
                <div class="cell-left">收款人姓名：</div>
                <div class="cell-right"><input type="text" name="people" class="cell-input" placeholder="张三"
                                               autocomplete="off"/></div>
            </div>
            <div class="cell-item">
                <div class="cell-left">收款人储蓄卡号：</div>
                <div class="cell-right"><input type="number" name="bankNum" pattern="[0-9]*" class="cell-input"
                                               placeholder="0000****000" autocomplete="off"/></div>
            </div>
            <div class="cell-item">
                <div class="cell-left">存款银行名称：</div>
                <div class="cell-right"><input type="text" name="bankName" class="cell-input" placeholder="中国银行"
                                               autocomplete="off"/></div>
            </div>
            <div class="cell-item">
                <div class="cell-left">账户类型：</div>
                <div class="cell-right"><input type="text" name="bankType" class="cell-input" placeholder="个人/企业"
                                               autocomplete="off"/></div>
            </div> -->
			</div>
			<p>${lq.configValue}</p>
			<div class="takeSmallMoney_button">
				<button type="submit" class="btn-block btn-primary">提交</button>
			</div>
		</form>
	</div>

	<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
	<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
	${js}
	<script>
	
		<!--表单验证-->
	
		$.validator.setDefaults({
			submitHandler : function() {
				alert("提交事件!");
			}
		});
	
		$().ready(function() {
			// 在键盘按下并释放及提交后验证提交表单
			/*  $("#signupForm").validate({
			     rules: {
			         moneyNum: "required",
			         people: "required",
			         bankNum: "required",
			         bankName: "required",
			         bankType: "required"
			     },
			     messages: {
			         moneyNum: "请输入金额",
			         people: "请输入收款人",
			         bankNum: "请输入储蓄卡号",
			         bankName: "请输入银行名称",
			         bankType: "请输入账户类型"
			     }
			 }); */
	
			$("#signupForm").submit(function(e) {
				var point = $("#change").text();
				var input = $("#input").val();
				console.log(point);
				console.log(input);
				if (input == "") {
					e.preventDefault();
					window.YDUI.dialog.alert('请输入数字');
				} else {
					if (parseFloat(input) < 0.1) {
						e.preventDefault();
						window.YDUI.dialog.alert('最少输入的数字为：0.1');
					} else {
						if (parseFloat(point) < parseFloat(input)) {
							e.preventDefault();
							window.YDUI.dialog.alert('可用最大的金额为：${cac.cacChange}元');
						}
					}
	
				}
	
			});
		});
	</script>
</body>
</html>
