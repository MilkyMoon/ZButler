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

<title>平台用户管理 | 众帮管家</title>

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
								消息管理 <small></small>
							</h3>
						</div>

						<form action="customer_select" method="get">
							<div class="title_right">
								<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control" name="keywords" placeholder="输入昵称、电话 ..."> 	
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


						<div class="clearfix"></div>

						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>
										消息管理 <small>消息推送</small>
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
									<div class="table-responsive">
										<table class="table table-striped jambo_table bulk_action">
											<thead>
												<tr class="headings">
													<th>
														<th><input type="checkbox" id="check-all" class="flat" /></th>
													</th>
													<th class="column-title">标题</th>
													<th class="column-title">详细内容</th>
													<th class="column-title">发布者</th>
													<th class="column-title">时间</th>
													<th class="column-title no-link last">操作</th>
													<th class="bulk-actions" colspan="7"><a class="antoo"
														style="color:#fff; font-weight:500;">Bulk Actions ( <span
															class="action-cnt"> </span> ) <i
															class="fa fa-chevron-down"></i></a></th>
												</tr>
											</thead>

											<tbody>
												<c:forEach var="root" items="${roots}">
													<tr class="even pointer">
														<td class="a-center ">
															<th><input type="checkbox" class="flat" name="table_records" /></th>
														</td>
														<td>
														
														</td>
														<td>
															<a href="customer_read?cusId=${root.cusId}" class="btn btn-info btn-xs" style="background-color:#e08254;border-color: #d48e50;"><i class="fa fa-file-text"></i>&nbsp;&nbsp;查看</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="#" class="btn btn-info btn-xs" disabled="disabled"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="#" class="btn btn-danger btn-xs" disabled="disabled"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="customer_reset?cusId=${root.cusId}" class="btn btn-info btn-xs"><i class="fa fa-refresh"></i>&nbsp;&nbsp;密码重置</a>
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
					<div class="row">
						<form action="customer_selectAll">
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
	                                    <button type="submit" class="btn btn-primary">Go!</button>
	                                </span>
		                        </div>
								<div class="dataTables_paginate paging_simple_numbers" id="datatable-checkbox_paginate">
									<ul class="pagination">
										<c:if test="${page.hasPrePage}">
											<li class="paginate_button previous" id="datatable-checkbox_previous">
												<a href="customer_selectAll?pageNow=${page.currentPage-1}&everyPage=${page.everyPage}" data-dt-idx="0" tabindex="0">上一页</a>
											</li>
											<li class="paginate_button">
												<a href="customer_selectAll?pageNow=1&everyPage=${page.everyPage}" data-dt-idx="1" tabindex="0">首页</a>
											</li>
										</c:if>
										<c:if test="${!page.hasPrePage}">
											<li class="paginate_button previous disabled" id="datatable-checkbox_previous">
												<a href="#" data-dt-idx="0" tabindex="0">上一页</a>
											</li>
											<li class="paginate_button active">
												<a href="customer_selectAll?pageNow=1&everyPage=${page.everyPage}" data-dt-idx="1" tabindex="0">首页</a>
											</li>
										</c:if>
										
										<c:if test="${page.hasNextPage}">
											<li class="paginate_button">
												<a href="customer_selectAll?pageNow=${page.totalPage}&everyPage=${page.everyPage}" data-dt-idx="3" tabindex="0">尾页</a>
											</li>
											<li class="paginate_button next" id="datatable-checkbox_next">
												<a href="customer_selectAll?pageNow=${page.currentPage+1}&everyPage=${page.everyPage}" data-dt-idx="4" tabindex="0">下一页</a>
											</li>
										</c:if>
										<c:if test="${!page.hasNextPage}">
											<li class="paginate_button active">
												<a href="customer_selectAll?pageNow=${page.totalPage}&everyPage=${page.everyPage}" data-dt-idx="3" tabindex="0">尾页</a>
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
	<!-- jQuery custom content scroller -->
	<script src="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- iCheck -->
	<script src="./vendors/iCheck/icheck.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="./build/js/custom.min.js"></script>
</body>
</html>