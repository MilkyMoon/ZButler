<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Gentelella Alela! |</title>

<!-- Bootstrap -->
<link href="./vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="./vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- jQuery custom content scroller -->
<link href="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
<!-- iCheck -->
<link href="./vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- bootstrap-wysiwyg -->
<link href="./vendors/google-code-prettify/bin/prettify.min.css"
	rel="stylesheet">
<!-- Select2 -->
<link href="./vendors/select2/dist/css/select2.min.css" rel="stylesheet">
<!-- Switchery -->
<link href="./vendors/switchery/dist/switchery.min.css" rel="stylesheet">
<!-- starrr -->
<link href="./vendors/starrr/dist/starrr.css" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="./vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="./build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="left.jsp" />

			<!-- top navigation -->
			<jsp:include page="header.jsp" />
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<!-- <h3>Form Elements</h3> -->
						</div>

						
					</div>
					<div class="clearfix"></div>
					<div class="row">

						<s:iterator value="#request.businessResult" id="businessList">
							<div class="col-md-4 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>
											<s:property value="busShopName" />
											<small style="color:red">
												<s:if test="%{#businessList.busStatus == 0}">
                       								待审核
                      							</s:if> 
                      							<s:if test="%{#businessList.busStatus == 1}">
													已通过
                      							</s:if>
                      						</small>
										</h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
<!-- 											<li class="dropdown"><a href="#" class="dropdown-toggle"
												data-toggle="dropdown" role="button" aria-expanded="false"><i
													class="fa fa-wrench"></i></a>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Settings 1</a></li>
													<li><a href="#">Settings 2</a></li>
												</ul></li> -->
											<li><a class="close-link"><i class="fa fa-close"></i></a>
											</li>
										</ul>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<br />
										<s:form action="#"
											class="form-horizontal form-label-left">

											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">店铺名称</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="busShopName"
														value="<s:property value='busShopName'/>" disabled="disabled"/>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">店主姓名</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="busOwnerName"
														value="<s:property value='busOwnerName'/>" disabled="disabled"/>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">身份证号</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="busIdcardUrl"
														value="<s:property value='busIdcardUrl'/>" disabled="disabled"/>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">营业执照</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="busLicenseUrl"
														value="<s:property value='busLicenseUrl'/>" disabled="disabled"/>
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">税务登记<span
													class="required">*</span>
												</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<textarea class="form-control" rows="3" name="busTaxUrl"
														placeholder='<s:property value="busTaxUrl"/>' disabled="disabled"><s:property value="busTaxUrl"/></textarea>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">商家图片<span
													class="required">*</span>
												</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<img src="<s:property value="busOrgUrl"/>" style="max-width:100%"/>
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">商圈</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<select class="form-control" disabled="disabled"
														name="busDistrict">
														<s:if test="%{#businessList.busDistrict == 1}">
															<option value="1" selected="selected">商业区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict != 1}">
															<option value="1">商业区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict == 2}">
															<option value="2" selected="selected">住宅区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict != 2}">
															<option value="2">住宅区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict == 3}">
															<option value="3" selected="selected">文教区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict != 3}">
															<option value="3">文教区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict == 4}">
															<option value="4" selected="selected">办公区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict != 4}">
															<option value="4">办公区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict == 5}">
															<option value="5" selected="selected">工业区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict != 5}">
															<option value="5">工业区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict == 6}">
															<option value="6" selected="selected">混合区</option>
														</s:if>
														<s:if test="%{#businessList.busDistrict != 6}">
															<option value="6">混合区</option>
														</s:if>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">经营类别</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<select class="form-control" name="cateLine.calId"
														id="busCateId" disabled="disabled">
														<option value="${businessList.cateLine.calId}">${businessList.cateLine.calName}</option>
													</select>
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">经营小类别</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<select class="form-control" name="cateLine.calId"
														id="busCateId" disabled="disabled">
														<c:forEach var="root" items="${roots}">
															<c:if
																test="${root.calId ==  businessList.busSmallCate}">
																<option value="${root.calId}" selected="selected">${root.calName}</option>
															</c:if>
															<c:if
																test="${root.calId !=  businessList.busSmallCate}">
																<option value="${root.calId}">${root.calName}</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">审核状态</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<div class="radio">
														<label> <s:if test="%{#businessList.busStatus == 0}">
			                          								<input type="radio" class="flat" checked
																		name="" value="0" disabled="disabled"> 未通过
		                          								</s:if>
		                          								<s:if test="%{#businessList.busStatus != 0}">
																	<input type="radio" class="flat" checked
																		name="" value="1" disabled="disabled"> 通过
		                          								</s:if>

														</label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">商家类别</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<select class="form-control" name="busLevel" disabled="disabled">
														<s:if test="%{#businessList.busLevel == 0}">
															<option value="0" selected="selected">商家</option>
														</s:if>
														<s:if test="%{#businessList.busLevel != 0}">
															<option value="0">商家</option>
														</s:if>
														<s:if test="%{#businessList.busLevel == 1}">
															<option value="1" selected="selected">会员</option>
														</s:if>
														<s:if test="%{#businessList.busLevel != 1}">
															<option value="1">会员</option>
														</s:if>
														<s:if test="%{#businessList.busLevel == 2}">
															<option value="2" selected="selected">合伙人</option>
														</s:if>
														<s:if test="%{#businessList.busLevel != 2}">
															<option value="2">合伙人</option>
														</s:if>													
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">银行卡号</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="bbBankCard"
														value="<s:property value="bbBankCard"/>" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">银行卡所属人</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="bbBankPerson"
														value="<s:property value="bbBankPerson"/>" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">国家</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="baCountry"
														value="中国" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">省</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="baProvince"
														value="<s:property value="baProvince"/>" id="baProvince" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">市</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="baCity"
														value="<s:property value="baCity"/>" id="baCity" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">县</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="baCounty"
														value="<s:property value="baCounty"/>" id="baCounty" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">详细地址</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="baAddress"
														value="<s:property value="baAddress"/>" id="baAddress" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">经度</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="baLongitude"
														value="${businessList.baLongitude}" id="baLongitude" disabled="disabled">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">纬度</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" name="baLatitude"
														value="${businessList.baLatitude}" id="baLatitude" disabled="disabled">
												</div>
											</div>
											<div class="ln_solid"></div>
										</s:form>
									</div>
								</div>
							</div>
							<div class="col-md-8 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>
											<s:property value="busShopName" />
										</h2>
										<ul class="nav navbar-right panel_toolbox">
											<li><a class="collapse-link"><i
													class="fa fa-chevron-up"></i></a></li>
											<li class="dropdown"><a href="#" class="dropdown-toggle"
												data-toggle="dropdown" role="button" aria-expanded="false"><i
													class="fa fa-wrench"></i></a>
												<ul class="dropdown-menu" role="menu">
													<li><a href="#">Settings 1</a></li>
													<li><a href="#">Settings 2</a></li>
												</ul></li>
											<li><a class="close-link"><i class="fa fa-close"></i></a>
											</li>
										</ul>
										<div class="clearfix"></div>
									</div>

									<div class="x_content">
										<div id="allmap" style="height:600px;"></div>
									</div>
								</div>
							</div>
						</s:iterator>
					</div>
				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
				<jsp:include page="footer.jsp" />
			</footer>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<script src="./vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="./vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="./vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="./vendors/nprogress/nprogress.js"></script>
	<!-- jQuery custom content scroller -->
	<script src="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- bootstrap-progressbar -->
	<script
		src="./vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
	<!-- iCheck -->
	<script src="./vendors/iCheck/icheck.min.js"></script>
	<!-- bootstrap-daterangepicker -->
	<script src="./vendors/moment/min/moment.min.js"></script>
	<script src="./vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap-wysiwyg -->
	<script src="./vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
	<script src="./vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
	<script src="./vendors/google-code-prettify/src/prettify.js"></script>
	<!-- jQuery Tags Input -->
	<script src="./vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
	<!-- Switchery -->
	<script src="./vendors/switchery/dist/switchery.min.js"></script>
	<!-- Select2 -->
	<script src="./vendors/select2/dist/js/select2.full.min.js"></script>
	<!-- Parsley -->
	<script src="./vendors/parsleyjs/dist/parsley.min.js"></script>
	<!-- Autosize -->
	<script src="./vendors/autosize/dist/autosize.min.js"></script>
	<!-- jQuery autocomplete -->
	<script
		src="./vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
	<!-- starrr -->
	<script src="./vendors/starrr/dist/starrr.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="./build/js/custom.min.js"></script>
	<script type="text/javascript"
		src="http://api.map.baidu.com/api?v=2.0&ak=cVhx3uWyeevirtDxTzlz0GofE0qWHbR9"></script>

	<script type="text/javascript">
		// 百度地图API功能
/* 		var map = new BMap.Map("allmap");
		var point = new BMap.Point(${businessList.baLatitude}, ${businessList.baLongitude});
		map.centerAndZoom(point, 12);
		
		var mk = new BMap.Marker(point);
		map.addOverlay(mk);
		map.panTo(point); */
		
		// 百度地图API功能
		var map = new BMap.Map("allmap");
		var point = new BMap.Point(${businessList.baLongitude}, ${businessList.baLatitude});
		var marker = new BMap.Marker(point);  // 创建标注
		map.addOverlay(marker);              // 将标注添加到地图中
		map.centerAndZoom(point, 15);
		
		map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
		
		//            鼠标点击拾取ip坐标 更新图标位置
		
		
		function showAddress(){
			var gc = new BMap.Geocoder();  //初始化，Geocoder类
        	gc.getLocation(point, function (rs) {   //getLocation函数用来解析地址信息，分别返回省市区街等
            var addComp = rs.addressComponents;
            province = addComp.province;//获取省份
            city = addComp.city;//获取城市
            district = addComp.district;//区
            street = addComp.street;//街

			$("#baProvince").val(province);
			$("#baCity").val(city);
			$("#baCounty").val(district);
			$("#baAddress").val(street);
           });
		}
	</script>
</body>
</html>
