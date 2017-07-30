<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>提现账户</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="takeMoneyAccount" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>home/customer.jsp">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<c:forEach var="cusBank" items="${cusBanks}">
			<div class="takeMoneyAccountItem" id="${cusBank.cbId}">
				<div class="takeMoneyAccountItem_name">${cusBank.cbBank}</div>
				<span>${cusBank.cbBankCard}</span>
				<div class="takeMoneyAccountItem_del">
					<img src="<%=basePath%>home/dist/wx_image/del.png" />
				</div>
			</div>
		</c:forEach>
		<a href="<%=basePath%>home/bindCardTwo.jsp">添加新账户</a>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>

	$('.takeMoneyAccount').css('height', document.body.scrollHeight);
	$('.takeMoneyAccountItem').click(function(e) {
		//            点击区域外使阻止事件冒泡
		e.stopPropagation();
		$('.takeMoneyAccountItem_del').css('display', 'none');
		$(this).find('.takeMoneyAccountItem_del').css('display', 'block');
	});
	$('.takeMoneyAccountItem_del>img').click(function() {
		var Id = $(this).parent().parent().attr("id");
		$(this).parent().parent().remove();
		console.log(Id);
		$.post("<%=basePath%>CusBank!del.action",
			{
				cbId : Id,
			},
			function(data) {});
	});
	$('.takeMoneyAccount').click(function() {
		$('.takeMoneyAccountItem_del').css('display', 'none');
	})
</script>
</html>
