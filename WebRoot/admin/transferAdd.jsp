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


<title>人工转账 | 众帮管家</title>

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
							<h3>人工转账</h3>
						</div>

						
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										用户资料查看
										<!-- <small style="color:red">待审核</small> -->
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
<!-- 										<li class="dropdown"><a href="#" class="dropdown-toggle"
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
									<div class="col-md-8 form-horizontal form-label-left">
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">用户昵称:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${root.busOwnerName}</div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">店铺名称:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${root.busShopName}</div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">银行卡号:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${root.bbBankCard}</div>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">所属银行:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${root.bbBank}</div>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">剩余零钱:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<div class="form-control">${cusroot.cacChange}</div>
											</div>
										</div>
									</div>
									<form action="transfer_save" method="post" id="submitForm" class="col-md-4 form-horizontal form-label-left">
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">转账金额:</label>
											<div class="col-md-6 col-sm-9 col-xs-12">
												<input type="number" name="traMoney" id="money" class="form-control" required="required" placeholder="请输入转账金额"/>
											</div>
										</div>
										
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-sm-9 col-xs-12 col-md-offset-3">
												<input type="hidden" name="business.busId" value="${root.busId}">
												<input type="hidden" name="thinkUser.thuId" value="${sessionScope.admin.thuId}">
												<button type="submit" class="btn btn-success" style="float:right;margin-right:0;">提交</button>
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
		
		<script type="text/javascript">
		$("#submitForm").on("submit", function (event) {
			if ($("#money").val() > ${cusroot.cacChange} || $("#money").val() <= 0 || checknumber($("#money").val())) {
				alert("请输入正确的值！");
				event.preventDefault();   //阻止表单提交
			} else {
				event.submit();  //提交表单
			}
		})
		
		function checknumber(String) { 
	　　　　var Letters = "1234567890"; 
	　　　　var i; 
	　　　　var c; 
	　　　　for( i = 0; i < Letters.length(); i ++ )   {   //Letters.length() ->>>>取字符长度
	　　　　　　c = Letters.charAt( i ); 
	　　　　　　if (Letters.indexOf( c ) ==-1)   { //在"Letters"中找不到"c"   见下面的此函数的返回值
	　　　　　　　　return true; 
	　　　   　　} 
	　　　　} 
	　　　　return false; 
	　　}
	</script>
</body>
</html>
