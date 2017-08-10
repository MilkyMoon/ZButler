<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>账单查看 | 众帮管家</title>

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
							<h3>账单管理</h3>
						</div>

						<<form action="bill_select" method="get">
							<div class="title_right">
								<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control" name="keywords" placeholder="输入姓名、昵称或电话 ..."> 	
										<span class="input-group-btn">
											<button class="btn btn-default" type="submit">Go!</button>
										</span>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										账单详情查看
										<!-- <small style="color:red">待审核</small> -->
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
									<br />
									<form action="thinkUser_update" method="post" class="form-horizontal form-label-left">
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">用户昵称:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${roots.customer.cusNickname}</div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">交付金额:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control"><fmt:formatNumber type="number" maxFractionDigits="12" value="${roots.bilCusMoney}" /></div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">物业名称:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${roots.areaByThuPropertyId.area}</div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">收取金额:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control"><fmt:formatNumber type="number" maxFractionDigits="12" value="${roots.bilPropertyMoney}" /></div>
											</div>
										</div>
										
										<!-- 判断当前用户是否显示县级代理 -->					
										<c:if test="${sessionScope.admin.area.areId != roots.areaByThuPropertyId.areId}">
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">县名称:</label>
												<div class="col-md-6 col-sm-9 col-xs-12">
													<div class="form-control">${roots.areaByThuCountyId.area}</div>
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">县收取金额:</label>
												<div class="col-md-6 col-sm-9 col-xs-12">
													<div class="form-control"><fmt:formatNumber type="number" maxFractionDigits="12" value="${roots.bilCountyMoney}" /></div>
												</div>
											</div>
										</c:if>
										<!-- 判断当前用户是否显示市级代理 -->	
										<c:if test="${sessionScope.admin.area.areId != roots.areaByThuPropertyId.areId && sessionScope.admin.area.areId != roots.areaByThuCountyId.areId}">
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">市名称:</label>
												<div class="col-md-6 col-sm-9 col-xs-12">
													<div class="form-control">${roots.areaByThuCityId.area}</div>
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">市收取金额:</label>
												<div class="col-md-6 col-sm-9 col-xs-12">
													<div class="form-control"><fmt:formatNumber type="number" maxFractionDigits="12" value="${roots.bilCityMoney}" /></div>
												</div>
											</div>
										</c:if>
										
										<!-- 判断当前用户是否显示省级代理 -->	
										<c:if test="${sessionScope.admin.area.areId != roots.areaByThuCityId.areId && sessionScope.admin.area.areId != roots.areaByThuPropertyId.areId && sessionScope.admin.area.areId != roots.areaByThuCountyId.areId}">
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">省名称:</label>
												<div class="col-md-6 col-sm-9 col-xs-12">
													<div class="form-control">${roots.areaByThuProvinceId.area}</div>
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">省收取金额:</label>
												<div class="col-md-6 col-sm-9 col-xs-12">
													<div class="form-control"><fmt:formatNumber type="number" maxFractionDigits="12" value="${roots.bilProvinceMoney}" /></div>
												</div>
											</div>
										</c:if>
										<c:if test="${sessionScope.admin.area.pid == 0}">
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">众帮收取金额:</label>
												<div class="col-md-6 col-sm-9 col-xs-12">
													<div class="form-control"><fmt:formatNumber type="number" maxFractionDigits="12" value="${roots.bilZongMoney}" /></div>
												</div>
											</div>
										</c:if>
														
														
										
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">账单日期:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${roots.bilDate}</div>
											</div>
										</div>
										
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-sm-9 col-xs-12 col-md-offset-3">
												<a href="bill_selectAll" class="btn btn-success" style="float:right;margin-right:0;">返回</a>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
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
</body>
</html>
