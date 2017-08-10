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

<title>平台管理员管理 | 众帮管家</title>

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
	    z-index:100;
	}
	
	#qrcode i{
        float: right;
	    padding-bottom: 10px;
	    font-size: 16px;
	    position: absolute;
	    right: 10px;
	    top: 10px;
	}
	
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
								<a href="thinkUser_add"><button type="button" class="btn btn-success btn-lg">添加管理员</button></a> <small>只能添加自己权限以下的管理员</small>
							</h3>
						</div>

						<form action="thinkUser_select" method="get">
							<div class="title_right">
								<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
									<div class="input-group">
										<input type="text" class="form-control" name="keywords" placeholder="输入地区、姓名、电话或邮箱 ..."> 	
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
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
									<!-- 	<li class="dropdown"><a href="#" class="dropdown-toggle"
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
									<div class="table-responsive">
										<table class="table table-striped jambo_table bulk_action">
											<thead>
												<tr class="headings">
													<th><input type="checkbox" id="check-all" class="flat">
													</th>
													<th class="column-title">姓名</th>
													<th class="column-title">地区</th>
													<th class="column-title">电话</th>
													<th class="column-title">邮箱</th>
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
														
														<c:if test="${empty root.thuName}">
															<td class=" " style="color:red">未指定</td>
														</c:if>
														<c:if test="${!empty root.thuName}">
															<td class=" ">${root.thuName }</td>
														</c:if>
														<td class=" ">${root.area.area}</td>
														<td class=" ">${root.thuPhone}</td>
														<td class=" ">${root.thuEmail}</td>
														<c:if test="${root.thuStatus == 1}">
															<td class=" ">是</td>
														</c:if>
														<c:if test="${root.thuStatus == 0}">
															<td class=" " style="color:#d9534f">否</td>
														</c:if>
														<td>
															<c:if test="${root.thuStatus == 1}">
																<a href="thinkUser_status?thuStatus=0&thuId=${root.thuId}" class="btn btn-primary btn-xs">
																	<i class="fa fa-folder"></i>&nbsp;&nbsp;关闭
																</a>&nbsp;&nbsp;&nbsp;&nbsp;
															</c:if>
															<c:if test="${root.thuStatus == 0}">
																<a href="thinkUser_status?thuStatus=1&thuId=${root.thuId}" class="btn btn-primary btn-xs" style="background-color:#3bce83;border-color: #28b90e;">
																	<i class="fa fa-folder"></i>&nbsp;&nbsp;开启
																</a>&nbsp;&nbsp;&nbsp;&nbsp;
															</c:if>
															
															<a href="thinkUser_edit?thuId=${root.thuId}" class="btn btn-info btn-xs">
															    <i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑
															</a>&nbsp;&nbsp;&nbsp;&nbsp;
															<a href="thinkUser_delete?thuId=${root.thuId}" class="btn btn-danger btn-xs" onclick="javascript:return del('您真的确定要删除吗？\n\n删除后将不能恢复!');">
																<i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除
															</a>
															<a href="#" class="btn btn-danger btn-xs" onclick="javascript:return (function () { 
																$('#qrcode').css('display','block');
																<%-- var url = '<%=basePath %>'+'WxOauthRedirect!adminBindWeChat?thuId=${root.thuId}'; --%>
																var url = 'http://yanglan520.com/ZButler/WxOauthRedirect!adminBindWeChat.action?thuId=${root.thuId}';
																new QRCode(document.getElementById('qrcode'), url);
																if ($('#qrcode').children('img').length > 1) {
																	$('#qrcode img:first').remove();
																	$('#qrcode canvas:first').remove();
																}
																}())" style="background-color: #13ce33;border-color:#22dc29">绑定微信</a>
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
					
					<div class="row">
						<form action="thinkUser_select">
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
												<a href="thinkUser_select?pageNow=${page.currentPage-1}&everyPage=${page.everyPage}" data-dt-idx="0" tabindex="0">上一页</a>
											</li>
											<li class="paginate_button">
												<a href="thinkUser_select?pageNow=1&everyPage=${page.everyPage}" data-dt-idx="1" tabindex="0">首页</a>
											</li>
										</c:if>
										<c:if test="${!page.hasPrePage}">
											<li class="paginate_button previous disabled" id="datatable-checkbox_previous">
												<a href="#" data-dt-idx="0" tabindex="0">上一页</a>
											</li>
											<li class="paginate_button active">
												<a href="thinkUser_select?pageNow=1&everyPage=${page.everyPage}" data-dt-idx="1" tabindex="0">首页</a>
											</li>
										</c:if>
										
										<c:if test="${page.hasNextPage}">
											<li class="paginate_button">
												<a href="thinkUser_select?pageNow=${page.totalPage}&everyPage=${page.everyPage}" data-dt-idx="3" tabindex="0">尾页</a>
											</li>
											<li class="paginate_button next" id="datatable-checkbox_next">
												<a href="thinkUser_select?pageNow=${page.currentPage+1}&everyPage=${page.everyPage}" data-dt-idx="4" tabindex="0">下一页</a>
											</li>
										</c:if>
										<c:if test="${!page.hasNextPage}">
											<li class="paginate_button active">
												<a href="thinkUser_select?pageNow=${page.totalPage}&everyPage=${page.everyPage}" data-dt-idx="3" tabindex="0">尾页</a>
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
	
	<script type="text/javascript" src="./build/js/qrcode.min.js"></script>
	
	<script type="text/javascript">
		function del(msg) { 
		//    var msg = "您真的确定要删除吗？\n\n删除后将不能恢复!请确认！"; 
		    if (confirm(msg)==true){ 
		            return true; 
		        }else{ 
		            return false; 
		    }
		} 
	</script>

</body>
</html>