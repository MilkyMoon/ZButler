<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    <link href="./vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="./vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="./build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <jsp:include page="left.jsp"/>

        <!-- top navigation -->
        <jsp:include page="header.jsp"/>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Tables
                            <small>Some examples to get you started</small>
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="输入地区、姓名、电话或邮箱 ...">
                                <span class="input-group-btn">
                      <button class="btn btn-default" type="button">搜索</button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    

                    <div class="clearfix"></div>

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>平台用户管理
                                    <small>管理员基本信息管理</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i
                                                class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Settings 1</a>
                                            </li>
                                            <li><a href="#">Settings 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>

                            <div class="x_content">
                                <p><code>注意：</code>删除上级管理员会删除所有下级管理员</p>
                                <div class="table-responsive">
                                    <table class="table table-striped jambo_table bulk_action">
                                        <thead>
	                                        <tr class="headings">
	                                            <th>
	                                                <input type="checkbox" id="check-all" class="flat">
	                                            </th>
	                                            <th class="column-title">姓名</th>
	                                            <th class="column-title">地区</th>
	                                            <th class="column-title">电话</th>
	                                            <th class="column-title">邮箱</th>
	                                            <th class="column-title">是否启用</th>
	                                            <th class="column-title no-link last">操作</th>
	                                            </th>
	                                            <th class="bulk-actions" colspan="7">
	                                                <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i
	                                                        class="fa fa-chevron-down"></i></a>
	                                            </th>
	                                        </tr>
                                        </thead>

                                        <tbody>
	                                        <tr class="even pointer">
	                                            <td class="a-center ">
	                                                <input type="checkbox" class="flat" name="table_records">
	                                            </td>
	                                            <td class=" ">张三</td>
	                                            <td class=" ">众帮管家</td>
	                                            <td class=" ">1324585545</td>
	                                            <td class=" ">1400251@qq.com</td>
	                                            <td class=" ">是</td>
	                                            <td>
	                                            	<a href="business_read?busId=<s:property value='busId'></s:property>" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;关闭</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_edit?busId=<s:property value='busId'></s:property>" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_delete?busId=<s:property value='busId'></s:property>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除</a>
							                    </td>
	                                        </tr>
	                                        <tr class="even pointer">
	                                            <td class="a-center ">
	                                                <input type="checkbox" class="flat" name="table_records">
	                                            </td>
	                                            <td class=" ">张三</td>
	                                            <td class=" ">|——北京市</td>
	                                            <td class=" ">1324585545</td>
	                                            <td class=" ">1400251@qq.com</td>
	                                            <td class=" ">是</td>
	                                            <td>
	                                            	<a href="business_read?busId=<s:property value='busId'></s:property>" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;关闭</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_edit?busId=<s:property value='busId'></s:property>" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_delete?busId=<s:property value='busId'></s:property>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除</a>
							                    </td>
	                                        </tr>
	                                        <tr class="even pointer">
	                                            <td class="a-center ">
	                                                <input type="checkbox" class="flat" name="table_records">
	                                            </td>
	                                            <td class=" ">张三</td>
	                                            <td class=" ">|——|——北京市</td>
	                                            <td class=" ">1324585545</td>
	                                            <td class=" ">1400251@qq.com</td>
	                                            <td class=" ">是</td>
	                                            <td>
	                                            	<a href="business_read?busId=<s:property value='busId'></s:property>" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;关闭</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_edit?busId=<s:property value='busId'></s:property>" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_delete?busId=<s:property value='busId'></s:property>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除</a>
							                    </td>
	                                        </tr>
	                                        <tr class="even pointer">
	                                            <td class="a-center ">
	                                                <input type="checkbox" class="flat" name="table_records">
	                                            </td>
	                                            <td class=" ">张三</td>
	                                            <td class=" ">|——|——|——海淀区</td>
	                                            <td class=" ">1324585545</td>
	                                            <td class=" ">1400251@qq.com</td>
	                                            <td class=" ">是</td>
	                                            <td>
	                                            	<a href="business_read?busId=<s:property value='busId'></s:property>" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;关闭</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_edit?busId=<s:property value='busId'></s:property>" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_delete?busId=<s:property value='busId'></s:property>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除</a>
							                    </td>
	                                        </tr>
	                                        <tr class="even pointer">
	                                            <td class="a-center ">
	                                                <input type="checkbox" class="flat" name="table_records">
	                                            </td>
	                                            <td class=" ">张三</td>
	                                            <td class=" ">|——河北省</td>
	                                            <td class=" ">1324585545</td>
	                                            <td class=" ">1400251@qq.com</td>
	                                            <td class=" ">是</td>
	                                            <td>
	                                            	<a href="business_read?busId=<s:property value='busId'></s:property>" class="btn btn-primary btn-xs"><i class="fa fa-folder"></i>&nbsp;&nbsp;关闭</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_edit?busId=<s:property value='busId'></s:property>" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>&nbsp;&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
							                        <a href="business_delete?busId=<s:property value='busId'></s:property>" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>&nbsp;&nbsp;删除</a>
							                    </td>
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
        <!-- /page content -->

        <!-- footer content -->
        <jsp:include page="footer.jsp"/>
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
<!-- iCheck -->
<script src="./vendors/iCheck/icheck.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="./build/js/custom.min.js"></script>
</body>
</html>
