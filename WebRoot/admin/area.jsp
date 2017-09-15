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

<title>地区管理 | ${sessionScope.netName.setValue}</title>

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
	#qrcode{
		position: fixed;
	    top: 22%;
	    left: 50%;
	    background-color: #fff;
	    padding: 42px 42px 58px 42px;
	    border: 1px solid #dedede;
	    border-radius: 5px;
	    display: none;
	}
	
	#qrcode i{
        float: right;
	    padding-bottom: 10px;
	    font-size: 16px;
	    position: absolute;
	    right: 10px;
	    top: 10px;
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
								<a href="area_add"><button type="button" class="btn btn-success btn-lg">添加地区</button></a> <small>只能添加自己管理地区之下的地区</small>
							</h3>
						</div>

						<form action="area_search" method="get">
							<div class="title_right">
								<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control" name="keywords" placeholder="输入地区 ..."> 	
										<span class="input-group-btn">
											<button class="btn btn-default" type="submit">搜索</button>
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
										平台用户管理 <small>管理员基本信息管理</small>
									</h2>
									<div class="clearfix"></div>
								</div>

								<div class="x_content">
									<p>
										<code>注意：</code>
										1.有下级时将不能删除&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</p>
									<div class="table-responsive">
										<table class="table table-striped jambo_table bulk_action">
											<thead>
												<tr class="headings">
													<th><input type="checkbox" id="check-all" class="flat">
													</th>
													<th class="column-title">编号</th>
													<th class="column-title">名称</th>
													<th class="column-title">是否启用</th>
													<th class="column-title no-link last">操作</th>
													</th>
													<th class="bulk-actions" colspan="7"><a class="antoo"
														style="color:#fff; font-weight:500;">Bulk Actions ( <span
															class="action-cnt"> </span> ) <i
															class="fa fa-chevron-down"></i></a></th>
												</tr>
											</thead>

											<tbody>
												<c:forEach var="root" items="${list}">
													<tr class="even pointer">
														<td class="a-center ">
															<input type="checkbox" class="flat" name="table_records">
														</td>
														<td class=" ">${root.areId}</td>
														<td class=" ">${root.area}</td>
														<td class=" ">
															<c:if test="${root.status == 1}">
																是
															</c:if>
															<c:if test="${root.status == 0}">
																<c style="color:#d9534f">否</c>
															</c:if>
														</td>
														<td>
															<c:if test="${root.status == 1}">
																<a href="area_status?status=0&areId=${root.areId}" class="btn btn-primary btn-xs">
																	<i class="fa fa-folder"></i>&nbsp;&nbsp;关闭
																</a>&nbsp;&nbsp;&nbsp;&nbsp;
															</c:if>
															<c:if test="${root.status == 0}">
																<a href="area_status?status=1&areId=${root.areId}" class="btn btn-primary btn-xs" style="background-color:#3bce83;border-color: #28b90e;">
																	<i class="fa fa-folder"></i>&nbsp;&nbsp;开启
																</a>&nbsp;&nbsp;&nbsp;&nbsp;
															</c:if>
															
															<a href="area_edit?areId=${root.areId}" class="btn btn-info btn-xs">
															    <i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑
															</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="area_status?areId=${root.areId}&status=2" class="btn btn-danger btn-xs" onclick="javascript:return del('您真的确定要删除吗？\n\n删除后将不能恢复!');">
																<i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除
															</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div id="qrcode">
											<a onclick="javascript:return (function () { 
																$('#qrcode').css('display','none');
															}())">
												<i class="fa fa-close"></i>
											</a>
											<a href="thinkUser_select" class="btn btn-primary btn-xs" style="position: absolute;bottom: 0;margin: 18px 0;left:40%">已成功绑定!</a>	
										</div>
										<%-- <img alt="显示图片" src="<s:url action='thinkUser_viewImages'><s:param name='thuId' value='1'></s:param></s:url>"></img> --%>
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
	<!-- jQuery custom content scroller -->
	<script src="./vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- iCheck -->
	<script src="./vendors/iCheck/icheck.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="./build/js/custom.min.js"></script>
	
	<script type="text/javascript" src="./build/js/qrcode.min.js"></script>
	<script type="text/javascript">
		function del(msg) { 
		//    var msg = "您真的确定要删除吗？相应地区的平台代理商将一并删除。\n\n删除后将不能恢复!请确认！"; 
		    if (confirm(msg)==true){ 
		            return true; 
		        }else{ 
		            return false; 
		    }
		} 
	</script>
</body>
</html>