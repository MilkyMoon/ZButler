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

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>主页</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=cVhx3uWyeevirtDxTzlz0GofE0qWHbR9"></script>

</head>

<body>
	<div id="allmap" style="display: none"></div>
	<div class="index">
		<header class="m-navbar">
		<div class="navbar-item">
			<input type="text" readonly id="J_Address" placeholder='<c:if test="${empty city}">北京</c:if><c:if test="${!empty city}">${city}</c:if>'
				class="choosePlace">
		</div>
		<div class="navbar-center">
			<i class="icon-search"></i> <input type="search"
				placeholder="输入商家/品类/商圈">
		</div>
		<a href="<%=basePath%>home/login.jsp" class="navbar-item personIcon"> <img
			src="<%=basePath%>home/dist/wx_image/person.png" />
		</a> </header>

		<div class="m-slider" id="J_Slider">
			<div class="slider-wrapper">
				<div class="slider-item">
					<a href="#"> <img
						src="http://static.ydcss.com/uploads/ydui/1.jpg">
					</a>
				</div>
				<div class="slider-item">
					<a href="#"> <img
						src="http://static.ydcss.com/uploads/ydui/2.jpg">
					</a>
				</div>
				<div class="slider-item">
					<a href="#"> <img
						src="http://static.ydcss.com/uploads/ydui/3.jpg">
					</a>
				</div>
			</div>
			<div class="slider-pagination"></div>
			<!-- 分页标识 -->
		</div>

		<div class="index_classItems">
			<%-- <div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/Food.png" /> <span>美食</span>
			</div>
			<div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/shopping.png" /> <span>购物</span>
			</div>
			<div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/Medicine.png" /> <span>医药</span>
			</div>
			<div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/Entertainment.png" /> <span>娱乐</span>
			</div>
			<div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/Tourism.png" /> <span>旅游</span>
			</div>
			<div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/Beautiful.png" /> <span>靓丽</span>
			</div>
			<div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/Car.png" /> <span>汽车</span>
			</div>
			<div class="index_classItem">
				<img src="<%=basePath%>home/dist/wx_image/Life.png" /> <span>生活</span>
			</div> --%>
			
			<c:forEach items="${cateLins}" var="cate">
				<div class="index_classItem">
					<img src="${cate.calImg}" /> <span>${cate.calName}</span>
				</div>
			</c:forEach>
		</div>

		<div class="index_recommends">
			<div class="index_recommend_left">
				<img src="<%=basePath%>home/dist/wx_image/Trval.png" /> <span>我们旅行</span> <strong>恋人爱人好朋友</strong>
			</div>
			<div class="index_recommend_right">
				<div class="recommend_right">
					<img src="<%=basePath%>home/dist/wx_image/Food2.png" /> <span> 底价超值 <strong>十元惠生活</strong>
					</span>
				</div>
				<div class="recommend_right">
					<img src="<%=basePath%>home/dist/wx_image/Food2.png" /> <span> 底价超值 <strong>十元惠生活</strong>
					</span>
				</div>
			</div>
		</div>

		<div class="index_guessYourLike">
			<h5>猜你喜欢</h5>
			<c:forEach items="${buss}" var="bus">
				<div class="index_guessItem">
				<img src="${bus.busOrgUrl}" />
				<div class="guess_content">
					<div>
						<span class="guess_name">${bus.busShopName}</span> <span class="guess_mark">10%</span>
					</div>
					<div>
						<span>${bus.cateLine.calName}</span> <span>其他</span>
					</div>
				</div>
			</div>
			</c:forEach>
			<%-- <div class="index_guessItem">
				<img src="image/111.jpg" />
				<div class="guess_content">
					<div>
						<span class="guess_name">鲜乐多</span> <span class="guess_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div>
			<div class="index_guessItem">
				<img src="image/111.jpg" />
				<div class="guess_content">
					<div>
						<span class="guess_name">鲜乐多</span> <span class="guess_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div>
			<div class="index_guessItem">
				<img src="<%=basePath%>home/dist/wx_image/111.jpg" />
				<div class="guess_content">
					<div>
						<span class="guess_name">鲜乐多</span> <span class="guess_mark">10%</span>
					</div>
					<div>
						<span>靓丽类</span> <span>其他</span>
					</div>
				</div>
			</div> --%>
		</div>

	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.citys.js"></script>
<!--百度地图定位-->
<script type="text/javascript">
	// 百度地图API功能
	/* var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.331398, 39.897445);
	map.centerAndZoom(point, 12);
	var geoc = new BMap.Geocoder();
	var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r) {
		if (this.getStatus() == BMAP_STATUS_SUCCESS) {
			var mk = new BMap.Marker(r.point);
			map.addOverlay(mk);
			map.panTo(r.point);
			//            ip逆解析
			var pt = new BMap.Point(r.point.lng, r.point.lat);
			geoc.getLocation(pt, function(rs) {
				var addComp = rs.addressComponents;
				function province(pro) {
					var ans;
					if (pro[pro.length - 1] == "市") {
						ans = pro.substring(0, pro.length - 1);
					}
					return ans;
				}
				if (addComp.city == '') {
					$('#J_Address').attr('placeholder', '北京');
				} else {
					$('#J_Address').attr('placeholder', addComp.city);
				}
			});
		} else {
			$('#J_Address').attr('placeholder', province("北京"));
		}
	}, {
		enableHighAccuracy : true
	}) */

	//    轮播图初始化
	$('#J_Slider').slider({
		speed : 200,
		autoplay : 2000,
		lazyLoad : true
	});

	//    选择地区
	var $address = $('#J_Address');

	$address.citySelect();

	$address.on('click', function() {
		$address.citySelect('open');
	});

	$address.on('done.ydui.cityselect', function(ret) {
		/* 省：ret.provance */
		/* 市：ret.city */
		/* 县：ret.area */
		$(this).val(ret.city);
		window.location.href = "<%=basePath%>offlineStore!offline.action?city="+ret.city;
	});
</script>
</html>
