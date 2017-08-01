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

<title>My JSP 'WeXinTest.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>

<body>
	<button id="imgUpload">图片上传</button>
	</br>
	<button id="map">地图</button>
	<br>
</body>

</html>
<script type="text/javascript">

	$.ajax({
		type : "post",
		dataType : "json",
		url : "<%=basePath%>WxJsApi!JsApiParams.action",
		async : false,
		data : {
			url : location.href.split("#")[0]
		},
		success : function(result) {
			var config = JSON.parse(result);
			config.debug = true;
			config.jsApiList = [
				'onMenuShareTimeline',
				'onMenuShareAppMessage',
				'uploadImage',
				'chooseImage',
				'openLocation',
				'getLocation'
			];
			wx.config(config)
		}
	});

	/* wx.onMenuShareTimeline({
		title : '', // 分享标题
		link : '', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
		imgUrl : '', // 分享图标
		success : function() {
			// 用户确认分享后执行的回调函数
			alert("分享成功");
		},
		cancel : function() {
			// 用户取消分享后执行的回调函数
			alert("分享失败");
		}
	}); */
	/* 	$("#imgUpload").click(function() {

			wx.chooseImage({
				count : 1, // 默认9
				sizeType : [ 'original', 'compressed' ], // 可以指定是原图还是压缩图，默认二者都有
				sourceType : [ 'album', 'camera' ], // 可以指定来源是相册还是相机，默认二者都有
				success : function(res) {
					var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
					a(res);
				}
			})

			function a(res) {
				alert(res.localIds);
				wx.uploadImage({
					localId : res, // 需要上传的图片的本地ID，由chooseImage接口获得
					isShowProgressTips : 1, // 默认为1，显示进度提示
					success : function(res) {
						var serverId = res.serverId; // 返回图片的服务器端ID
						console.log(res)
					}
				});
			} */

	$("#map").click(function() {

		wx.getLocation({
			type : 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
			success : function(res) {
				var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
				var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
				var speed = res.speed; // 速度，以米/每秒计
				var accuracy = res.accuracy; // 位置精度

				wx.openLocation({
					latitude : latitude, // 纬度，浮点数，范围为90 ~ -90
					longitude : longitude, // 经度，浮点数，范围为180 ~ -180。
					name : '', // 位置名
					address : '', // 地址详情说明
					scale : 15, // 地图缩放级别,整形值,范围从1~28。默认为最大
					infoUrl : '' // 在查看位置界面底部显示的超链接,可点击跳转
				});
			}
		});

	})

/* 	$(function() {
		pushHistory();
		window.addEventListener("popstate", function(e) {
			//history.go(-2);
			console.log(window.history)
		}, false);
		function pushHistory() {
			var state = {
				title : "title",
				url : "#"
			};
			window.history.pushState(state, "title", "#");
		}
	}); */
	/* wx.uploadImage({
		localId : '', // 需要上传的图片的本地ID，由chooseImage接口获得
		isShowProgressTips : 1, // 默认为1，显示进度提示
		success : function(res) {
			var serverId = res.serverId; // 返回图片的服务器端ID
		}
	}); */
</script>