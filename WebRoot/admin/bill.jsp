<%@page import="java.math.BigDecimal"%>
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

<title>账单管理 | ${sessionScope.netName.setValue}</title>

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
<!-- bootstrap-daterangepicker -->
<link href="./vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
<!-- jQuery custom content scroller -->
<link href="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" rel="stylesheet"/>
<!-- iCheck -->
<link href="./vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- Datatables -->
<link href="./vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="./vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
<link href="./vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="./vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
<link href="./vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">


<!-- Custom Theme Style -->
<link href="./build/css/custom.min.css" rel="stylesheet">
<style type="text/css">
	.page-form{
		width:172px;
		margin:20px 0;
		float:right;
	}
	.page-form span{
		line-height:32px;
	}
</style>
</head>

<body class="nav-md">
<%!
	BigDecimal big;
 %>
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

						<%-- <form action="bill_select" method="get">
							<div class="title_right">
								<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control" name="keywords" placeholder="输入姓名、昵称或电话 ..."> 	
										<span class="input-group-btn">
											<button class="btn btn-default" type="submit">搜索</button>
										</span>
									</div>
								</div>
							</div>
						</form> --%>
					</div>

					<div class="clearfix"></div>
					
					<div class="row">
						

						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										用户账单列表 <small>用户账单管理</small>
									</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li>
											<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
										</li>
										<!-- <li class="dropdown">
											<a href="#" class="dropdown-toggle"
												data-toggle="dropdown" role="button" aria-expanded="false">
												<i class="fa fa-wrench"></i>
											</a>
											<ul class="dropdown-menu" role="menu">
												<li><a href="#">Settings 1</a></li>
												<li><a href="#">Settings 2</a></li>
											</ul>
										</li> -->
										<li><a class="close-link"><i class="fa fa-close"></i></a>
										</li>
									</ul>
									<div class="clearfix"></div>
								</div>
								
								<div class="col-md-6 col-sm-12 col-xs-12">
									<div class="x_content">
										<form action="bill_select" method="post" class="form-horizontal form-label-left">
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">订单类型</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<select class="form-control">
														<option>线下交易</option>
													</select>
												</div>
											</div>
											
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">交易时间</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<fieldset>
							                            <div class="control-group">
							                              <div class="controls">
							                                <div class="input-prepend input-group">
							                                  <span class="add-on input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-calendar"></i></span>
							                                  <input type="text" style="width: 100%" name="tranTime" id="reservation" class="form-control"  required="required"/>
							                                </div>
							                              </div>
							                            </div>
							                          </fieldset>
							                          <p><code>注意：</code>单次查询日期的最长跨度为两个月</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">支付场景</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<select class="form-control" name="">
														<option value="">线下支付</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">交易状态</label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<select class="form-control">
														<option>已完成</option>
													</select>
												</div>
											</div>
											<div class="form-group">
						                        <label class="control-label col-md-3 col-sm-3 col-xs-12">交易金额</label>
						                        <div class="col-md-4 col-sm-9 col-xs-12">
						                          <input type="text" name="amountMin" class="form-control" required="required">
						                        </div>
						                        <div class="col-md-1 col-sm-9 col-xs-12">
						                          <label class="control-label">至</label>
						                        </div>
						                        <div class="col-md-4 col-sm-9 col-xs-12">
						                          <input type="text" name="amountMax" class="form-control"  required="required">
						                        </div>
						                      </div>
						                      
						                      <div class="divider-dashed"></div>
						                      
						                      <div class="form-group">
						                        <label class="control-label col-md-3 col-sm-3 col-xs-12"></label>
						                        <div class="col-md-9 col-sm-9 col-xs-12">
						                          <button class="btn btn-success" type="submit">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
						                        </div>
						                      </div>						                      
										</form>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-12 col-xs-12">
									<div class="x_content">
										<form action="thuTrading_add" method="post" id="submitForm">
											<div class="bs-example" data-example-id="simple-jumbotron">
												<div class="jumbotron" style="padding: 5px 36px;">
													<h1>
														¥
														<c:if test="${(area.areaTotalMoney.divide(1000000000000) - 0.1) <= 0}">
															0
														</c:if>
														<c:if test="${(area.areaTotalMoney.divide(1000000000000) - 0.1) > 0}">
															<fmt:formatNumber type="number" maxFractionDigits="1"
															value="${area.areaTotalMoney.divide(1000000000000) - 0.1}"/>
														</c:if>
													</h1>
													<p>
														可提现总额
													</p>
												</div>
											</div>
											
											<div class="form-group">
						                        <div class="col-md-9 col-sm-9 col-xs-12">
						                          <input type="number" class="form-control" required="required" name="money" id="money" placeholder="请输入提现金额"/>
						                        </div>
						                        <div class="col-md-3 col-sm-9 col-xs-12">
						                          <button class="btn btn-success" type="submit" style="float:right">&nbsp;&nbsp;提现&nbsp;&nbsp;</button>
						                        </div>
						                      </div>	
										</form>
									</div>
								</div>
								
								<div class="x_panel">
				                  <div class="x_content">
				                    <p class="text-muted font-13 m-b-30">
				                      可以导出到Excel文件
				                    </p>
				                    <table id="datatable-buttons" class="table table-striped table-bordered" style="width:100%">
				                      <thead>
				                        <tr>
				                          <th>
												<th><input type="checkbox" id="check-all" class="flat" /></th>
											</th>
											<th class="column-title">用户</th>
											<th class="column-title">用户付款</th>
											<th class="column-title">商家</th>
											<th class="column-title">商家收款</th>
											<th class="column-title">物业</th>
											<th class="column-title">物业收款</th>
											<th class="column-title">县级代理</th>
											<th class="column-title">县级收款</th>
											<th class="column-title">市级代理</th>
											<th class="column-title">市级收款</th>
											<th class="column-title">省级代理</th>
											<th class="column-title">省级收款</th>
											
											<c:if test="${sessionScope.admin.area.pid == 0}">
												<th class="column-title">众帮收款</th>
											</c:if>
											<th class="column-title">订单时间</th>
											
											<th class="column-title no-link last">操作</th>
											<th class="bulk-actions" colspan="7"><a class="antoo"
												style="color:#fff; font-weight:500;">Bulk Actions ( <span
													class="action-cnt"> </span> ) <i
													class="fa fa-chevron-down"></i></a></th>
				                        </tr>
				                      </thead>
				
				
				                      <tbody>
				                      	<c:forEach var="root" items="${roots}">
					                        <tr>
					                          <td class="a-center ">
													<th><input type="checkbox" class="flat" name="table_records" /></th>
												</td>
												<td>${root.customer.cusNickname}</td>
												<td><fmt:formatNumber type="number" maxFractionDigits="12" value="${root.bilCusMoney.divide(1000000000000)}" /></td>
												<td>${root.business.busShopName}</td>
												<td><fmt:formatNumber type="number" maxFractionDigits="12" value="${root.bilBusMoney.divide(1000000000000)}" /></td>
												<td>${root.areaByThuPropertyId.area}</td>
												<td><fmt:formatNumber type="number" maxFractionDigits="12" value="${root.bilPropertyMoney.divide(1000000000000)}" /></td>
												<!-- 判断当前用户是否显示县级代理 -->					
												<c:if test="${sessionScope.admin.area.areId != root.areaByThuPropertyId.areId}">
													<td>${root.areaByThuCountyId.area}</td>
													<td><fmt:formatNumber type="number" maxFractionDigits="12" value="${root.bilCountyMoney.divide(1000000000000)}" /></td>
												</c:if>
												<c:if test="${sessionScope.admin.area.areId == root.areaByThuPropertyId.areId}">
													<td></td>
													<td></td>
												</c:if>
												<!-- 判断当前用户是否显示市级代理 -->	
												<c:if test="${sessionScope.admin.area.areId != root.areaByThuPropertyId.areId && sessionScope.admin.area.areId != root.areaByThuCountyId.areId}">
													<td>${root.areaByThuCityId.area}</td>
													<td><fmt:formatNumber type="number" maxFractionDigits="12" value="${root.bilCityMoney.divide(1000000000000)}" /></td>
												</c:if>
												<c:if test="${sessionScope.admin.area.areId == root.areaByThuPropertyId.areId || sessionScope.admin.area.areId == root.areaByThuCountyId.areId}">
													<td></td>
													<td></td>
												</c:if>
												<!-- 判断当前用户是否显示省级代理 -->	
												<c:if test="${sessionScope.admin.area.areId != root.areaByThuCityId.areId && sessionScope.admin.area.areId != root.areaByThuPropertyId.areId && sessionScope.admin.area.areId != root.areaByThuCountyId.areId}">
													<td>${root.areaByThuProvinceId.area}</td>
													<td><fmt:formatNumber type="number" maxFractionDigits="12" value="${root.bilProvinceMoney.divide(1000000000000)}" /></td>
												</c:if>
												<c:if test="${sessionScope.admin.area.areId == root.areaByThuCityId.areId || sessionScope.admin.area.areId == root.areaByThuPropertyId.areId || sessionScope.admin.area.areId == root.areaByThuCountyId.areId}">
													<td></td>
													<td></td>
												</c:if>
												<c:if test="${sessionScope.admin.area.pid == 0}">
													<td><fmt:formatNumber type="number" maxFractionDigits="12" value="${root.bilZongMoney.divide(1000000000000)}" /></td>
												</c:if>
												<td>${root.bilDate}</td>
												<td>
													<%-- <c:if test="${root.cusStatus == 1}">
														<a href="customer_update?cusStatus=0&cusId=${root.cusId}" class="btn btn-primary btn-xs">
															<i class="fa fa-folder"></i>&nbsp;&nbsp;关闭
														</a>&nbsp;&nbsp;&nbsp;&nbsp;
													</c:if>
													<c:if test="${root.cusStatus == 0}">
														<a href="customer_update?cusStatus=1&cusId=${root.cusId}" class="btn btn-primary btn-xs" style="background-color:#3bce83;border-color: #28b90e;">
															<i class="fa fa-folder"></i>&nbsp;&nbsp;开启
														</a>&nbsp;&nbsp;&nbsp;&nbsp;
													</c:if> --%>
													<a href="bill_read?bilId=${root.bilId}" class="btn btn-info btn-xs" style="background-color:#e08254;border-color: #d48e50;"><i class="fa fa-file-text"></i>&nbsp;&nbsp;查看</a>&nbsp;&nbsp;&nbsp;&nbsp;
												</td>
					                        </tr>
				                        </c:forEach>
				                      </tbody>
				                    </table>
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
	<script src="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- iCheck -->
	<script src="./vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
    <script src="./vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="./vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="./vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="./vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="./vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="./vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="./vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="./vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="./vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="./vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="./vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="./vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="./vendors/jszip/dist/jszip.min.js"></script>
    <script src="./vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="./vendors/pdfmake/build/vfs_fonts.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="./build/js/custom.min.js"></script>
	
	<script type="text/javascript">
		$("#submitForm").on("submit", function (event) {
			if ($("#money").val() > ${area.areaTotalMoney} || $("#money").val() <= 0 || checknumber($("#money").val())) {
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