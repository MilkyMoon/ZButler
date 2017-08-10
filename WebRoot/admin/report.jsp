<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>账单管理 | 众帮管家</title>

<!-- Bootstrap -->
<link href="./vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="./vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="./vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">
<!-- jQuery custom content scroller -->
<link
	href="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"
	rel="stylesheet" />
<!-- iCheck -->
<link href="./vendors/iCheck/skins/flat/green.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="./build/css/custom.min.css" rel="stylesheet">
<style type="text/css">
.page-form {
	width: 172px;
	margin: 20px 0;
	float: right;
}

.page-form span {
	line-height: 32px;
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
							<h3>
								账单管理 <small>只可查询与自己相关的账单</small>
							</h3>
						</div>

						<form action="bill_select" method="get">
							<div class="title_right">
								<%-- <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control" name="keywords" placeholder="输入姓名、昵称或电话 ..."> 	
										<span class="input-group-btn">
											<button class="btn btn-default" type="submit">Go!</button>
										</span>
									</div>
								</div> --%>
							</div>
						</form>
					</div>

					<div class="clearfix"></div>

					<div class="row">


						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>账单收益查询</h2>
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

								<div class="col-md-6 col-sm-12 col-xs-12">
									<div class="x_content">
										<form class="form-horizontal form-label-left" method="post"
											action="bill_query">
											<div class="form-group">
												<!-- <label class="control-label col-md-3" style="width:100px;">交易时间</label> -->
												<%-- <div class="col-md-4 col-sm-9 col-xs-12" style="width:100px;">
													<select class="form-control">
														<option>北京</option>
														<option>河北</option>
													</select>
												</div> --%>

												<div class="form-group">
													<label class="control-label col-md-3" style="width:100px;">交易开始时间</label>
													<fieldset class="col-md-8 col-sm-9 col-xs-12">
														<div class="control-group">
															<div class="controls">
																<div
																	class="col-md-11 xdisplay_inputx form-group has-feedback">
																	<input type="text"
																		class="form-control has-feedback-left"
																		id="single_cal2" placeholder="First Name"
																		aria-describedby="inputSuccess2Status2"
																		name="startTime"> <span
																		class="fa fa-calendar-o form-control-feedback left"
																		aria-hidden="true"></span> <span
																		id="inputSuccess2Status2" class="sr-only">(success)</span>
																</div>
															</div>
														</div>
													</fieldset>
												</div>

												<div class="form-group">
													<label class="control-label col-md-3" style="width:100px;">交易结束时间</label>
													<fieldset class="col-md-8 col-sm-9 col-xs-12">
														<div class="control-group">
															<div class="controls">
																<div
																	class="col-md-11 xdisplay_inputx form-group has-feedback">
																	<input type="text"
																		class="form-control has-feedback-left"
																		id="single_cal3" placeholder="First Name"
																		aria-describedby="inputSuccess2Status2" name="endTime">
																	<span
																		class="fa fa-calendar-o form-control-feedback left"
																		aria-hidden="true"></span> <span
																		id="inputSuccess2Status2" class="sr-only">(success)</span>
																</div>

															</div>
														</div>
													</fieldset>

												</div>
												<c:if test="${!empty seachError}">
													<p>
														<code>错误：查询开始时间必须小于结束时间</code>
													</p>
												</c:if>
												<div class="col-md-1 col-sm-9 col-xs-12">
													<button class="btn btn-success" type="submit">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>

												</div>
											</div>

											<div class="divider-dashed"></div>



										</form>
									</div>
								</div>
								<c:if test="${!empty profit}">
									<div class="col-md-6 col-sm-12 col-xs-12">
										<div class="x_content">
											<div class="bs-example" data-example-id="simple-jumbotron">
												<div class="jumbotron" style="padding: 5px 36px;">
													<h1>
														¥
														<fmt:formatNumber type="number" maxFractionDigits="10"
															value="${profit}" />
													</h1>
													<p>
														${dateOne}
														－
														${dateTwo}
														累计收益
													</p>
												</div>
											</div>
										</div>
									</div>
								</c:if>
								<div class="x_content">
									<div class="table-responsive">
										<c:set var="now" value="<%=new java.util.Date()%>" />
										<p class="lead">
											收益详情
											<fmt:formatDate pattern="MM/dd/yyyy" value="${now}" />
										</p>
										<div class="table-responsive">
											<table class="table">
												<tbody>
													<tr>
														<th style="width:50%">当日收益:</th>
														<td>￥<fmt:formatNumber type="number"
																maxFractionDigits="10" value="${Today}" /></td>
													</tr>
													<tr>
														<th>当月收益:</th>
														<td>￥<fmt:formatNumber type="number"
																maxFractionDigits="10" value="${Month}" /></td>
													</tr>
													<tr>
														<th>当年收益:</th>
														<td>￥<fmt:formatNumber type="number"
																maxFractionDigits="10" value="${Year}" /></td>
													</tr>
													<tr>
														<th>累计收益:</th>
														<td>￥<fmt:formatNumber type="number"
																maxFractionDigits="10" value="${Total}" /></td>
													</tr>
												</tbody>
											</table>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<jsp:include page="footer.jsp" />
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
	<!-- bootstrap-daterangepicker -->
	<script src="./vendors/moment/min/moment.min.js"></script>
	<script src="./vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- jQuery custom content scroller -->
	<script
		src="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- iCheck -->
	<script src="./vendors/iCheck/icheck.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="./build/js/custom.min.js"></script>
</body>
</html>