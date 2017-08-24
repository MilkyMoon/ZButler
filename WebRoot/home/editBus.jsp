<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>申请入驻</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>
<body>
	<div class="applyAdmission" style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<s:form id="signupForm" action="business_updateBus" namespace="/">
			<input type="hidden" name="busId" value="${store.busId}">
			<h5>基本资料填写（*为必填）</h5>
			<div class="m-cell">
				<div class="cell-item">
					<div class="cell-left">店铺名称*：</div>
					<div class="cell-right">
						<input type="text" name="busShopName" class="cell-input"
							value="${store.busShopName}" placeholder="" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">店铺描述*：</div>
					<div class="cell-right">
						<input type="text" name="busDesc" class="cell-input"
							value="${store.busDesc}" placeholder="" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">店主姓名*：</div>
					<div class="cell-right">
						<input type="text" name="busOwnerName" class="cell-input"
							value="${store.busOwnerName}" disabled="true" placeholder=""
							autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">手机号码*：</div>
					<div class="cell-right">
						<input type="text" name="busPhone" class="cell-input"
							value="${store.busPhone}" placeholder="" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">身份证号码*：</div>
					<div class="cell-right">
						<input type="text" name="busIdcardUrl" class="cell-input"
							value="${store.busIdcardUrl}" disabled="true" placeholder=""
							autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">所在地址*：</div>
					<div class="cell-right">
						<input type="text" name="baProvince" class="cell-input" readonly
							id="J_Address" placeholder="请选择">
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">详细地址*：</div>
					<div class="cell-right">
						<input type="text" name="baAddress" class="cell-input"
							placeholder="街道 门牌号等" autocomplete="off" />
					</div>
				</div>
				<div class="applyAdmission_map">
					<div id="allmap"></div>
					<input type="hidden" name="baLatitude" id="baLatitude"> <input
						type="hidden" name="baLongitude" id="baLongitude">
				</div>
				-->
				<div class="cell-item">
					<div class="cell-left">所在商圈*：</div>
					<label class="cell-right cell-arrow"> <select
						class="cell-select" name="busDistrict">
							<option value="">请选择</option>
							<option value="1">商业区</option>
							<option value="2">住宅区</option>
							<option value="3">文教区</option>
							<option value="4">办公区</option>
							<option value="5">工业区</option>
							<option value="6">混合区</option>
					</select>
					</label>
				</div>

				<div class="cell-item">
					<div class="cell-left">营业执照号*：</div>
					<div class="cell-right">
						<input type="text" name="busLicenseUrl" class="cell-input"
							value="${store.busLicenseUrl}" placeholder="" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">经营类别*：</div>
					<label class="cell-right cell-arrow"> <select
						class="cell-select" name="cateLine.calId" id="busCateId">
							<option value="">请选择类别</option>
							<c:forEach var="root" items="${roots}">
								<option value="${root.calId}">${root.calName}</option>
							</c:forEach>
					</select>
					</label>
				</div>
				<div class="cell-item">
					<div class="cell-left">经营小类别*：</div>
					<label class="cell-right cell-arrow"> <select
						class="cell-select" name="busSmallCate" id="busSmallCate">
							<option value="">请选择小类别</option>
					</select>
					</label>
				</div>
				<!--<div class="cell-item">
                <div class="cell-left">商家返利*：</div>
                <label class="cell-right cell-arrow">
                    <select class="cell-select">
                        <option value="">请选择</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                        <option value="3">未知</option>
                    </select>
                </label>
            </div> -->
				<p>
					<span>1、商家返点可以为1、2、3、4......任意自然数</span><br> <span>2、选择比例为1的，付款超过500元的部分，需加收0.6%交易手续费</span><br>
					<span>3、选择其他比例的，免收交易手续费</span><br> <span>4、变更返出比例需联系平台客服进行变更</span>
				</p>
				<h5>
					请输入银行卡信息<span>（营业款提到该银行卡）</span>
				</h5>
				<div class="cell-item">
					<div class="cell-left">开户行*：</div>
					<div class="cell-right">
						<input type="text" name="bbBank" class="cell-input" placeholder=""
							value="${store.bbBank}" autocomplete="off" />
					</div>
				</div>
				<div class="cell-item">
					<div class="cell-left">银行卡号*：</div>
					<div class="cell-right">
						<input type="text" name="bbBankCard" pattern="[0-9]*"
							class="cell-input" id="haorooms" placeholder=""
							value="${store.bbBankCard}" autocomplete="off" />
					</div>
				</div>
				<!-- <div class="cell-item">
                <div class="cell-left">开户银行*：</div>
                <label class="cell-right cell-arrow">
                    <select class="cell-select">
                        <option value="">请选择</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                        <option value="3">未知</option>
                    </select>
                </label>
            </div> -->
			</div>
			<button type="submit" class="btn-block btn-primary">修改</button>
		</s:form>

	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.citys.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=cVhx3uWyeevirtDxTzlz0GofE0qWHbR9"></script>
${error}
<script>

	//    选择地址
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

	function addBusAddress() {
		var str = $('#J_Address').val();
		var strs = new Array(); //定义一数组 
		strs = str.split(" "); //字符分割 

		var caProvince = strs[0];
		var caCity = strs[1];
		var caCounty = strs[2];

		var path = "business_add?baProvince="
			+ baProvince + "&baCity=" + baCity + "&baCounty=" + baCounty;

	/* $('#CusAddressAdd').attr("action", path).submit();; */
	}

	//    表单验证
	/* 
	    $.validator.setDefaults({
	        submitHandler: function () {
	            alert("提交事件!");
	        }
	    }); */
	$().ready(function() {

		$("#busCateId").change(function() {
			var pid = $(this).val();
			if (pid != '') {
				$.post("<%=basePath%>querySmallJson",
					{
						pid : pid,
					},
					function(data) {
						var obj = JSON.parse(data);
						opString = null;
						$("#busSmallCate").children().remove();
						for (var i = 0; i < obj.smalls.length; i++) {
							var opString = '<option value="' + obj.smalls[i].calId + '">' + obj.smalls[i].calName + '</option>';
							$("#busSmallCate").append(opString);
						}
					});
			}

		});

		// 在键盘按下并释放及提交后验证提交表单
		$("#signupForm").validate({
			rules : {
				busPhone : "required",
				busShopName : "required",
				busOwnerFname : "required",
				busIdcardUrl : "required",
				baProvince : "required",
				baAddress : "required",
				busDistrict : "required",
				busLicenseUrl : "required",
				bbBank : "required",
				busSmallCate : "required",
				bbBankCard : {
					required : true
				}
			},
			messages : {
				busPhone : '请输入手机号码',
				busShopName : "请输入店铺名称",
				busOwnerFname : "请输入店主姓名",
				busIdcardUrl : "请输入身份证号",
				baProvince : "请输入地址",
				baAddress : "请输入详细地址",
				busDistrict : "请选择所在商圈",
				busLicenseUrl : "请输入执照号",
				busSmallCate : "请选择经营小类别",
				bbBank : "请输入开户行",
				bbBankCard : {
					required : "请输入银行卡号"
				}
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
		});

		// 百度地图API功能
		var map = new BMap.Map("allmap");
		var point = new BMap.Point(116.331398, 39.897445);
		map.centerAndZoom(point, 12);
		var geoc = new BMap.Geocoder();
		var geolocation = new BMap.Geolocation();
		geolocation.getCurrentPosition(function(r) {
			if (this.getStatus() == BMAP_STATUS_SUCCESS) {
				var mk = new BMap.Marker(r.point);
				map.addOverlay(mk);
				map.panTo(r.point);
				$("#baLatitude").val(r.point.lat);
				$("#baLongitude").val(r.point.lng);
				var pt = new BMap.Point(r.point.lng, r.point.lat);
				//            鼠标点击拾取ip坐标 更新图标位置
				function showInfo(e) {
					var allOverlay = map.getOverlays();
					pt = new BMap.Point(e.point.lng, e.point.lat);
					mk = new BMap.Marker(e.point);
					map.removeOverlay(allOverlay[0]);
					map.removeOverlay(allOverlay[1]);
					map.addOverlay(mk);
					map.panTo(e.point);
					$("#baLatitude").val(e.point.lat);
					$("#baLongitude").val(e.point.lng);
				}
				map.addEventListener("click", showInfo);
			} else {
				alert('failed' + this.getStatus());
			}
		}, {
			enableHighAccuracy : true
		})

		// 添加定位控件
		var geolocationControl = new BMap.GeolocationControl();
		geolocationControl.addEventListener("locationSuccess", function(e) {
			// 定位成功事件
			var address = '';
			map.removeOverlay(allOverlay[0]);
			map.removeOverlay(allOverlay[1]);
			address += e.addressComponent.province;
			address += e.addressComponent.city;
			address += e.addressComponent.district;
			address += e.addressComponent.street;
			address += e.addressComponent.streetNumber;
			alert("当前定位地址为：" + address);
		});
		geolocationControl.addEventListener("locationError", function(e) {
			// 定位失败事件
			alert(e.message);
		});
		map.addControl(geolocationControl);
	});
</script>
</html>
