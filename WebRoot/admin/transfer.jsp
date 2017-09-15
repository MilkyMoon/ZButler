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

<title>人工转账记录管理 | ${sessionScope.netName.setValue}</title>

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
								人工转账记录管理 <small></small>
							</h3>
						</div>

						<form action="transfer_select" method="get">
							
							<div class="title_right">
								
								<div class="col-md-4 col-sm-5 col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control" name="keywords" placeholder="输入店铺名称、姓名 ...">
										<span class="input-group-btn">
											<button class="btn btn-default" type="submit">搜索</button>
										</span>
									</div>
								</div>
								<div class="col-md-4 form-group pull-right">
			                        <div class="col-md-5 col-sm-9 col-xs-12">
			                          <input type="text" name="amountMin" class="form-control" required="required" placeholder="金额">
			                        </div>
			                        <div class="col-md-2 col-sm-9 col-xs-12">
			                          <label class="control-label">至</label>
			                        </div>
			                        <div class="col-md-5 col-sm-9 col-xs-12">
			                          <input type="text" name="amountMax" class="form-control"  required="required" placeholder="金额">
			                        </div>
			                      </div>
								<div class="col-md-4 col-sm-9 col-xs-12 form-group pull-right top_search">
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
								</div>
							</div>
						</form>
					</div>

					<div class="clearfix"></div>

					<div class="row">


						<div class="clearfix"></div>

						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										转账记录列表 <small>账单信息管理</small>
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
				                    <p class="text-muted font-13 m-b-30">
				                      可以导出到Excel文件
				                    </p>
				                    <table id="datatable-buttons" class="table table-striped table-bordered" style="width:100%">
				                      <thead>
				                        <tr class="headings">
											<th>
												<th><input type="checkbox" id="check-all" class="flat" /></th>
											</th>
											<th class="column-title">店铺名称</th>
											<th class="column-title">店主姓名</th>
											<th class="column-title">转账人</th>
											<th class="column-title">金额</th>
											<th class="column-title">时间</th>
											<th class="column-title no-link last">操作</th>
											<th class="bulk-actions" colspan="7"><a class="antoo"
												style="color:#fff; font-weight:500;">Bulk Actions ( <span
													class="action-cnt"> </span> ) <i
													class="fa fa-chevron-down"></i></a></th>
										</tr>
				                      </thead>
				
				
				                      <tbody>
				                      	<c:forEach var="list" items="${list}">
											<tr class="even pointer">
												<td class="a-center ">
													<th><input type="checkbox" class="flat" name="table_records" /></th>
												</td>
												
												<td>${list.business.busShopName}</td>
												<td>${list.business.busOwnerName}</td>
												<td>${list.thinkUser.thuName}</td>
												<td>${list.traMoney}</td>
												<td>${list.traDate}</td>
												<td>
													<a class="btn btn-primary btn-xs" href="thinkUser_select"><i class="fa fa-folder"></i>&nbsp;&nbsp;查看转账人</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a class="btn btn-primary btn-xs" href="business_read?busId=${list.business.busId}"><i class="fa fa-folder"></i>&nbsp;&nbsp;查看店铺</a>&nbsp;&nbsp;&nbsp;&nbsp;
												</td>
											</tr>
										</c:forEach>
				                      </tbody>
				                    </table>
				                  </div>
							</div>
						</div>
					</div>
					<%-- <div class="row">
						<form action="transfer_selectAll">
							<div class="col-sm-5">
								<div class="dataTables_info" id="datatable-checkbox_info" role="status" aria-live="polite" style="margin: 20px 0;height: 32px;line-height: 32px;">
									当前显示${(page.currentPage-1)*page.everyPage+1} ~  
									<c:if test="${page.hasNextPage}">${page.currentPage*page.everyPage}</c:if>
									<c:if test="${!page.hasNextPage}">${page.totalCount}</c:if>条记录（&nbsp;&nbsp;共${page.totalCount}条记录,共${page.totalPage}页&nbsp;&nbsp;）
								</div>
							</div>
							<div class="col-sm-7">
								<div class="input-group page-form" style="float: right;">
									<span style="float:left;padding:0 5px">跳转到</span>
									<input type="text" name="pageNow" value="${page.currentPage}" class="form-control" style="text-align:center;width:42px;padding:5px">
									<span style="float:right;padding:0 5px">页</span>
		                            <span class="input-group-btn">
	                                    <button type="submit" class="btn btn-primary">搜索</button>
	                                </span>
		                        </div>
								<div class="dataTables_paginate paging_simple_numbers" id="datatable-checkbox_paginate">
									<ul class="pagination">
										<c:if test="${page.hasPrePage}">
											<li class="paginate_button previous" id="datatable-checkbox_previous">
												<a href="transfer_selectAll?pageNow=${page.currentPage-1}&everyPage=${page.everyPage}" data-dt-idx="0" tabindex="0">上一页</a>
											</li>
											<li class="paginate_button">
												<a href="transfer_selectAll?pageNow=1&everyPage=${page.everyPage}" data-dt-idx="1" tabindex="0">首页</a>
											</li>
										</c:if>
										<c:if test="${!page.hasPrePage}">
											<li class="paginate_button previous disabled" id="datatable-checkbox_previous">
												<a href="#" data-dt-idx="0" tabindex="0">上一页</a>
											</li>
											<li class="paginate_button active">
												<a href="transfer_selectAll?pageNow=1&everyPage=${page.everyPage}" data-dt-idx="1" tabindex="0">首页</a>
											</li>
										</c:if>
										
										<c:if test="${page.hasNextPage}">
											<li class="paginate_button">
												<a href="transfer_selectAll?pageNow=${page.totalPage}&everyPage=${page.everyPage}" data-dt-idx="3" tabindex="0">尾页</a>
											</li>
											<li class="paginate_button next" id="datatable-checkbox_next">
												<a href="transfer_selectAll?pageNow=${page.currentPage+1}&everyPage=${page.everyPage}" data-dt-idx="4" tabindex="0">下一页</a>
											</li>
										</c:if>
										<c:if test="${!page.hasNextPage}">
											<li class="paginate_button active">
												<a href="transfer_selectAll?pageNow=${page.totalPage}&everyPage=${page.everyPage}" data-dt-idx="3" tabindex="0">尾页</a>
											</li>
											<li class="paginate_button next disabled" id="datatable-checkbox_next">
												<a href="#" data-dt-idx="4" tabindex="0">下一页</a>
											</li>
										</c:if>
									</ul>
								</div>
								<div class="input-group page-form">
									<span style="float:left;padding:0 5px">每页显示</span>
									<input type="text" value="${page.everyPage}" name="everyPage" class="form-control" style="text-align:center;width:42px;padding:5px">
									<span style="padding:0 5px">条数据</span>
		                        </div>
							</div>
						</form>
					</div> --%>
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
</body>
</html>