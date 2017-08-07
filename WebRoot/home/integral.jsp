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

<title>零钱充值</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>

<body>
	<div class="integral2">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>CusAccount!change.action">返回</a>
			</div>
			<div class="integral2_top_center"></div>
			<div class="integral2_top_right">
				<i class="icon-refresh"></i> <a
					href="<%=basePath%>WxOauthRedirect!IntoRechage.action">刷新</a>
			</div>
		</div>
		<div class="integral2_content">
			<div>
				<a href="javascript:;" class="active"> <span>￥<span>1</span>
					</span>
				</a>
			</div>
			<div>
				<a href="javascript:;"> <span>￥<span>2</span></span>
				</a>
			</div>
			<div>
				<a href="javascript:;"> <span>￥<span>5</span></span>
				</a>
			</div>
			<div>
				<a href="javascript:;"> <span>￥<span>10</span></span>
				</a>
			</div>
			<div>
				<a href="javascript:;"> <span>￥<span>20</span></span>
				</a>
			</div>
			<div>
				<a href="javascript:;"> <span>￥<span>30</span></span>
				</a>
			</div>
			<div>
				<a href="javascript:;"> <span>￥<span>50</span></span>
				</a>
			</div>
			<div>
				<a href="javascript:;"> <span>￥<span>100</span></span>
				</a>
			</div>

		</div>
		<div class="m-celltitle" style="color:#1C1C20">其它金额:</div>
		<div class="cell-item">
			<input type="text" id="otherNum" pattern="[0-9]*"
				class="cell-input" placeholder="请输入金额" autocomplete="off" />
		</div>
		<div class="integral2_moneyNum">
			￥<span></span>
		</div>
		<button type="button" class="btn-block btn-primary">提交</button>

		<div class="dialog">
			<div class="dialog_bg"></div>
			<div class="dialog_message">
				<div class="dialog_content">
					<div class="dialog_title">提示</div>
					<span>充值后无法退换<br>请按需求充值
					</span>
					<div class="dialog_operation">
						<div class="no">取消</div>
						<div class="yes">确定充值</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>


	$.ajax({
		type : "post",
		dataType : "json",
		url : "<%=basePath%>WxJsApi",
		async : false,
		data : {
			url : location.href.split("#")[0]
		},
		success : function(result) {
			var config = JSON.parse(result);

			config.debug = false;
			config.jsApiList = [
				'chooseWXPay'
			];
			wx.config(config)
		}
	});



	var money = $('.active').find('span').eq(0).find('span').eq(0).text();
	var moneyNum = parseFloat(money);

	$('.integral2_moneyNum>span').text(moneyNum.toFixed(2));
	$('.integral2_content a').click(function() {
		$("#otherNum").val('');
		$('.integral2_content').find('a').attr('class', '');
		$(this).attr('class', 'active');
		money = $(this).find('span').eq(0).find('span').eq(0).text();
		moneyNum = parseFloat(money);
		$('.integral2_moneyNum>span').text(moneyNum.toFixed(2));

	});
	$('#otherNum').click(function() {
		$('.integral2_content').find('a').attr('class', '');
	});
	$('#otherNum').bind('input propertychange', function() {
		money = $("#otherNum").val();
		moneyNum = parseFloat(money);

		if (isNaN(moneyNum)) {
			$('.integral2_moneyNum>span').text("0.00");
		} else {
			$('.integral2_moneyNum>span').text(moneyNum.toFixed(2));
		}

	});
	$('.btn-primary').click(function() {
		if ($('.integral2_moneyNum>span').text() === '0.00') {
			alert('请输入正确金额!')
		} else {
			$('.dialog').css('display', 'block');
		}
	});
	$('.no').click(function() {
		$('.dialog').css('display', 'none');
	});


	$('.yes').click(function() {
		// 获取金额，启用微信支付
		var payNum = $('.integral2_moneyNum>span').text();
		if ('' != payNum) {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "<%=basePath%>WxPayJson",
				async : true,
				data : {
					payNum : payNum,
					service : "R"
				},
				success : function(result) {
					var config = JSON.parse(result);

					wx.chooseWXPay(
						{
							timestamp : config.timeStamp,
							nonceStr : config.nonceStr,
							signType : config.signType,
							package : config.package,
							paySign : config.paySign,
							success : function(res) {
								$('.dialog').css('display', 'none');
								window.location.href = "<%=basePath%>CusAccount!change.action"
							}
						})
				}
			});
		} else {
			window.YDUI.dialog.alert("请输入有效金额");
		}
	})
</script>
