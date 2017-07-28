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
</head>

<body>
	<div class="integral2">
		<div class="integral2_content">
			<a href="javascript:;" class="active"> <span>￥<span>2</span></span>
				</span>
			</a> <a href="javascript:;"> <span>￥<span>1</span></span> </span>
			</a> <a href="javascript:;"> <span>￥<span>5</span></span> </span>
			</a> <a href="javascript:;"> <span>￥<span>10</span></span> </span>
			</a> <a href="javascript:;"> <span>￥<span>50</span></span> </span>
			</a> <a href="javascript:;"> <span>￥<span>100</span></span> </span>
			</a>
		</div>
		<div class="m-celltitle">其他数量:</div>
		<div class="cell-item">
			<input type="number" id="otherNum" pattern="[0-9]*"
				class="cell-input" placeholder="请输入金额" autocomplete="off" />
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

	$('#otherNum').val($('.active').find('span').eq(0).find('span').eq(0).text());
	$('.integral2_content a').click(function() {
		$('#otherNum').val('');
		$('.integral2_content').find('a').attr('class', '');
		$(this).attr('class', 'active');
		$('#otherNum').val($(this).find('span').eq(0).find('span').eq(0).text());
	});
	$('#otherNum').click(function() {
		$('.integral2_content').find('a').attr('class', '');
	});
	$('.btn-primary').click(function() {
		$('.dialog').css('display', 'block');
	});
	$('.no').click(function() {
		$('.dialog').css('display', 'none');
	})

	$('.yes').click(function() {
		// 获取金额，启用微信支付
		var payNum = $("#otherNum").val();
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
					console.log(config.timeStamp)
					wx.chooseWXPay(
						{
							timestamp : config.timeStamp,
							nonceStr : config.nonceStr,
							signType : config.signType,
							package : config.package,
							paySign : config.paySign,
							success : function(res) {
								alert(res)
							}
						})
				}
			});
		} else {
			window.YDUI.dialog.alert("请输入有效金额");
		}
	})
</script>
