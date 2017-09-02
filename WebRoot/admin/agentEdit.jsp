<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>地区添加 | ${sessionScope.netName.setValue}</title>

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
	<!-- Dropzone.js -->
	<link href="./vendors/dropzone/dist/min/dropzone.min.css" rel="stylesheet">
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
	<style>
		.dropzone{
			min-height: 194px;
			width: 194px;
		}
	</style>
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
							<h3>店铺分类管理</h3>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										添加地区
									</h2>
									
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<br />
									<div class="col-md-8">
										<form action="area_update" method="post" class="form-horizontal form-label-left">
											<div class="">
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">名&nbsp;&nbsp;&nbsp;&nbsp;称</label>
													<div class="col-md-6 col-sm-9 col-xs-12">
														<input type="text" class="form-control" name="area" value="${roots.area}">
													</div>
												</div>
												
												<%-- <div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">抽成比例(方式一)</label>
													<div class="col-md-6 col-sm-9 col-xs-12">
														<input type="text" class="form-control" name="areaScale" value="${roots.areaScale}">
													</div>
												</div> --%>
												
												<div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">抽成比例</label>
													<div class="col-md-6 col-sm-9 col-xs-12">
														<input type="text" class="form-control" name="areaScaleTwo" value="${roots.areaScaleTwo}">
													</div>
												</div>
												
												<%-- <div class="form-group">
													<label class="control-label col-md-3 col-sm-3 col-xs-12">启&nbsp;&nbsp;&nbsp;&nbsp;用</label>
													<div class="col-md-9 col-sm-9 col-xs-12">
														<div class="radio">
															<label> 
																<c:if test="${roots.areaWay == 1}">
																	<input type="radio" class="flat" checked name="areaWay" value="1"> 方式一
			                          								<input type="radio" class="flat" name="areaWay" value="2"> 方式二
																</c:if>
																<c:if test="${roots.areaWay == 2}">
																	<input type="radio" class="flat" name="areaWay" value="1"> 方式一
			                          								<input type="radio" class="flat" checked name="areaWay" value="2"> 方式二
																</c:if>
																<c:if test="${empty roots.areaWay}">
																	<input type="radio" class="flat" name="areaWay" value="1"> 方式一
			                          								<input type="radio" class="flat" name="areaWay" value="2"> 方式二
																</c:if>
															</label>
														</div>
													</div>
												</div> --%>
											</div>
											
											<div class="ln_solid"></div>
											<div class="form-group">
												<div class="col-md-6 col-sm-9 col-xs-12 col-md-offset-3">
													<input type="hidden" name="pagewhere" value="2"/>
													<input type="hidden" name="areId" value="${roots.areId}"/>
													<input type="hidden" class="flat" name="areaWay" value="2">
													<button type="submit" class="btn btn-success" style="float:right;margin-right:0;">提交</button>
												</div>
											</div>
										</form>
									</div>
									<!-- <div class="col-md-4">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">图&nbsp;&nbsp;&nbsp;&nbsp;标</label>
										<div class="col-md-9">
											<form id="fileupload-form">
											     <input id="fileupload" type="file" name="file" >
											     <img style="width:100%" alt="" id="theImg" src=""/> 
											</form>
											<form action="#" id="fileupload-form" method="post" class="dropzone" enctype="multipart/form-data"></form>
						                    <br />
						                    <br />
										</div>
					                    
									</div> -->
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
	<!-- Dropzone.js -->
    <script src="./vendors/dropzone/dist/min/dropzone.min.js"></script>
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
	
</body>
</html>
