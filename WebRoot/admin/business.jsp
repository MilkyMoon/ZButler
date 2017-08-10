<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

    <title>招商管理</title>

    <!-- Bootstrap -->
    <link href="./vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
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
                <h3>商家管理<small>商家基本信息管理</small></h3>
              </div>

              <%-- <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div> --%>
            </div>

            <div class="clearfix"></div>

            <div class="row">

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>代理商管理<small>代理商基本信息管理</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                   <!--    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li> -->
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      供应商入驻列表
                    </p>
                    <table id="datatable-checkbox" class="table table-striped table-bordered bulk_action">
                      <thead>
                        <tr>
                          <th>
							 <th><input type="checkbox" id="check-all" class="flat"/></th>
						  </th>
                          <th>店铺名称</th>
                          <th>商家类别</th>
                          <th>商圈</th>
                          <th>店主姓名</th>
                       	  <c:if test="${opt == 0}">
                              <th>是否审核</th>
                       	  </c:if>
                       	  <c:if test="${opt == 1}">
                       		  <th>是否启用</th>
                       	  </c:if>
                       	  <c:if test="${opt == 2}">
                       		  <th>是否黑名单</th>
                       	  </c:if>
                          <th>操作</th>
                        </tr>
                      </thead>

                      <tbody>
                      	<c:forEach items="${list}" var="roots">
	                        <tr>
	                          <td>
								 <th><input type="checkbox" class="flat" name="table_records"/></th>
							  </td>
	                          <td>${roots.busShopName}</td>
	                          <td>
		                          <c:if test="${roots.busLevel == 0}">
		                          	商家
		                          </c:if>
		                          <c:if test="${roots.busLevel == 1}">
		                          	一级
		                          </c:if>
		                          <c:if test="${roots.busLevel == 2}">
		                          	二级
		                          </c:if>
		                          <c:if test="${roots.busLevel == 3}">
		                          	三级
		                          </c:if>
	                          </td>
	                          
	                          <td>
		                          <c:if test="${roots.busDistrict == 1}">
		                          	商业区
		                          </c:if>
		                          <c:if test="${roots.busDistrict == 2}">
		                          	住宅区
		                          </c:if>
		                          <c:if test="${roots.busDistrict == 3}">
		                          	文教区
		                          </c:if>
		                          <c:if test="${roots.busDistrict == 4}">
		                          	办公区
		                          </c:if>
		                          <c:if test="${roots.busDistrict == 5}">
		                          	工业区
		                          </c:if>
		                          <c:if test="${roots.busDistrict == 6}">
		                          	混合区
		                          </c:if>
	                          </td>
	                          <td>${roots.busOwnerName}</td>
	                          <%-- <td><s:property value="busStatus"></s:property></td> --%>
	                          <c:if test="${roots.busStatus == 0 || roots.busStatus == 2}">
	                          	<td style="color:red">否</td>
	                          </c:if>
	                          <c:if test="${roots.busStatus == 1 || roots.busStatus == 3}">
	                          	<td>是</td>
	                          </c:if>
	                          <td>
	                          	<c:if test="${roots.busStatus == 0}">
	                          		<a href="business_status?busId=${roots.busId}&busStatus=1&pagewhere=0" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;通过</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                          	</c:if>
	                          	<c:if test="${roots.busStatus == 1}">
	                          		<a href="business_status?busId=${roots.busId}&busStatus=2&pagewhere=1" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;关闭</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                          		<a href="business_status?busId=${roots.busId}&busStatus=3&pagewhere=1" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;加入黑名单</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                          	</c:if>
	                          	<c:if test="${roots.busStatus == 2}">
	                          		<a href="business_status?busId=${roots.busId}&busStatus=1&pagewhere=1" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;开启</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                          		<a href="business_status?busId=${roots.busId}&busStatus=3&pagewhere=1" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;加入黑名单</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                          	</c:if>
	                          	<c:if test="${roots.busStatus == 3}">
	                          		<a href="business_status?busId=${roots.busId}&busStatus=1&pagewhere=2" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;恢复</a>&nbsp;&nbsp;&nbsp;&nbsp;
	                          	</c:if>
		                          <a href="business_read?busId=${roots.busId}" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;查看</a>&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a href="business_edit?busId=${roots.busId}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
		                          <a href="business_delete?busId=${roots.busId}" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除</a>
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