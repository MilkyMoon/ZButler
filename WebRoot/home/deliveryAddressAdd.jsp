<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>收货地址-添加</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>
<body>
	<div class="deliveryAddress2">
		<!-- action="BusAddress_add" method="post" -->
		<form id="CusAddressAdd" action="" method="post">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-left">收货人姓名：</div>
					<div class="cell-right">

						<input type="text" id="caName" class="cell-input" placeholder="必填" name="name"
							autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">手机：</div>
					<div class="cell-right">
						<input type="number" id="caPhone" pattern="[0-9]*" name="tel"
							class="cell-input" placeholder="必填" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">收货地址：</div>
					<div class="cell-right">
						<input type="text" class="cell-input" id="J_Address" name="address"
							placeholder="请选择" autocomplete="off" />

					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-left">详细地址：</div>
					<div class="cell-right">
						<textarea id="caAddress" class="cell-textarea" placeholder="必填" name="allAddress"></textarea>
					</div>
				</div>
			</div>

			<button type="submit" onclick="addCusAddress();"
				class="btn-block btn-primary">提交</button>
		</form>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.citys.js"></script>
<script>
	var $address = $('#J_Address');

	$address.citySelect();

	$address.on('click', function() {
		$address.citySelect('open');
	});

	$address.on('done.ydui.cityselect', function(ret) {
		/* 省：ret.provance */
		/* 市：ret.city */
		/* 县：ret.area */
		$(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
	});
	function addCusAddress() {
		var str = $('#J_Address').val();
		var strs = new Array(); //定义一数组 
		strs = str.split(" "); //字符分割 
		var caName = $('#caName').val();
		var caPhone = $('#caPhone').val();
		var caAddress = $('#caAddress').val();
		var caProvince = strs[0];
		var caCity = strs[1];
		var caCounty = strs[2];
		caAddress = caCounty + caAddress;

		var path = "<%=basePath%>CusAddress_add?caName=" + caName + "&caPhone=" + caPhone + "&caAddress=" + caAddress + "&caProvince=" + caProvince + "&caCity=" + caCity;
		$('#CusAddressAdd').attr("action", path).submit();
	}
	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		$("#CusAddressAdd").validate({
			rules : {
				name : "required",
				tel : {
					required : true,
					rangelength : [ 11, 11 ],
					digits : true
				},
				address : "required",
				allAddress : "required"
			},
			messages : {
				name : "请输入收款人",
				tel : {
					required : "请输入手机号",
					rangelength : "请输入正确手机号"
				},
				address : "请输入地址",
				allAddress : "请输入详细地址"
			}
		});
	});
</script>
</html>