<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>线下支付</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>支付</title>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>
<div class="pay">
	<form id="signupForm">
		<div class="m-cell">
			<div class="pay_store">
				<div class="pay_storeImg">
					<img src="${pay_business.busOrgUrl}" />
				</div>
				<div class="pay_storeName">
					<div>${pay_business.busShopName}</div>
					<span>${pay_business.baAddress}</span>
				</div>
				<div class="pay_storeTel">${pay_business.busPhone}</div>
			</div>
 			<c:if test="${empty sessionScope.payByCashMoney}">
				<input type="number" pattern="[0-9]*" name="num" class="cell-input"
					placeholder="消费金额" autocomplete="off" id="payNum" value="" />
			</c:if>
			<c:if test="${!empty sessionScope.payByCashMoney}">
				<input type="number" pattern="[0-9]*" name="num" class="cell-input"
					placeholder="消费金额" autocomplete="off" id="payNum" value="${sessionScope.payByCashMoney}" />
			</c:if>
			
			<div class="pay_button">
				<button type="button" class="btn-block btn-primary" id="pay">确认支付</button>
			</div>
		</div>
	</form>

</div>
</html>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script type="text/javascript">
	$.ajax({
		type : "post",
		dataType : "json",
		url : "<%=basePath%>WxJsApi",
		async : true,
		data : {
			url : location.href.split("#")[0]
		},
		success : function(result) {
			var config = JSON.parse(result);

			config.debug = false;
			config.jsApiList = [
				'onMenuShareTimeline',
				'onMenuShareAppMessage',
				'chooseWXPay'
			];
			wx.config(config)
		}
	});

	/* 	wx.ready(function() {
			wx.onMenuShareTimeline({
				title : '分享连接', // 分享标题
				link : 'http://yanglan520.com/ZButler/home/WeXinTest.jsp', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
				imgUrl : 'http://tvax3.sinaimg.cn/crop.0.0.996.996.180/006dDppTly8fhtoqtheunj30ro0rogn0.jpg', // 分享图标
				success : function() {
					// 用户确认分享后执行的回调函数
					alert("分享成功");
				},
				cancel : function() {
					// 用户取消分享后执行的回调函数
					alert("分享失败");
				}
			});
		}); */

	//时间监听，发起微信支付

	$("#pay").click(function() {
		// 获取支付金额
		var payNum = $("#payNum").val();
		if ('' != payNum) {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "<%=basePath%>WxPayJson",
				async : true,
				data : {
					payNum : payNum,
					service : "P",
					busId:${pay_business.busId}
					
				},
				success : function(result) {
					var config = JSON.parse(result);
					console.log(config.timeStamp)
					wx.chooseWXPay(
						{
							timestamp : config.timeStamp,
							nonceStr : config.nonceStr,
							signType : config.signType,
							package : config.package,
							paySign : config.paySign,
							success : function(res) {}
						})
				}
			});
		} else {
			window.YDUI.dialog.alert("请输入有效金额");
		}

	});
</script>