<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-3 left_col menu_fixed">
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="index.html" class="site_title"><i class="fa fa-paw"></i>
				<span>众帮管家</span></a>
		</div>

		<div class="clearfix"></div>

		<!-- menu profile quick info -->
		<div class="profile clearfix">
			<div class="profile_pic">
				<img src="images/img.jpg" alt="..." class="img-circle profile_img">
			</div>
			<div class="profile_info">
				<span>欢迎,</span>
				<h2>${sessionScope.admin.thuName}</h2>
			</div>
		</div>
		<!-- /menu profile quick info -->

		<br />

		<!-- sidebar menu -->
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
			<div class="menu_section">
				<h3>General</h3>
				<ul class="nav side-menu">
					<li><a href="<%=basePath%>admin/index"><i
							class="fa fa-home"></i> 首页 </a> <!-- <ul class="nav child_menu">
                            <li><a href="index.html">Dashboard</a></li>
                            <li><a href="index2.html">Dashboard2</a></li>
                            <li><a href="index3.html">Dashboard3</a></li>
                        </ul> --></li>
					<%-- <li><a><i class="fa fa-table"></i> 供应商管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="#">供应商入驻管理</a></li>
                            <li><a href="business.jsp">供应商账号管理</a></li>
                            <li><a href="business.jsp">黑名单管理</a></li>
                        </ul>
                    </li> --%>
          
                    <li><a><i class="fa fa-edit"></i> 线下商家管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="business_enter">入驻管理</a></li>
                            <li><a href="business_selectAll">线下商家信息管理</a></li>
                            <li><a href="business_account">收款账号管理</a></li>
                            <!-- <li><a href="business_period">账期管理</a></li> -->
                            <li><a href="business_blacklist">黑名单管理</a></li>
                           <!--  <li><a href="form_validation.html">收款账号管理</a></li> -->
                        </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> 基础数据管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="<%=basePath%>admin/cateLine_selectAll">线下分类管理</a></li>
                            <li><a href="<%=basePath%>admin/area_select">地区管理</a></li>
                            <!-- <li><a href="media_gallery.html">品牌管理</a></li>
                            <li><a href="typography.html">商品属性模板管理</a></li> -->
                        </ul>
                    </li>
					<li><a><i class="fa fa-clone"></i> 用户管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                        	<li><a href="<%=basePath%>admin/customer_selectAll">用户管理</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-clone"></i>组织管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="<%=basePath%>admin/thinkUser_select">平台代理商</a></li>
                            <li><a href="<%=basePath%>admin/group_selectAll">角色管理</a></li>
                            <%-- <li><a href="<%=basePath%>admin/group_select">角色管理</a></li> --%>
                            <!-- <li><a href="#">权限管理</a></li> -->
                        </ul>
                    </li>
                    <li><a><i class="fa fa-clone"></i> 订单管理 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="<%=basePath%>admin/bill_selectAll">消费订单</a></li>
                            <li><a href="<%=basePath%>admin/trading_selectCash">提现订单</a></li>
                            <li><a href="<%=basePath%>admin/trading_selectRech">充值订单</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-clone"></i> 报表统计 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="<%=basePath%>admin/bill_report">订单报表</a></li>
                           <%--  <li><a href="<%=basePath%>admin/cateLine_selectAll">订单明细表</a></li>
                            <li><a href="<%=basePath%>admin/group_select">业务日志</a></li> --%>
                            <!-- <li><a href="#">权限管理</a></li> -->
                        </ul>
                    </li>
                    <li><a><i class="fa fa-clone"></i> 利润分配 <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="<%=basePath%>admin/area_agent">三级代理商</a></li>
                            <li><a href="<%=basePath%>admin/business_profit">线下商家</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-clone"></i> 消息管理 <span
							class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="<%=basePath%>admin/notice_selectAll.action">消息推送</a></li>
							<%-- <li><a href="<%=basePath%>admin/cateLine_selectAll">留言</a></li> --%>
						</ul>
					</li>
				</ul>
			</div>
			<div class="menu_section">
				<h3>站点配置</h3>
				<ul class="nav side-menu">
					<li><a><i class="fa fa-bug"></i> 广告管理 <span
							class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<!-- <li><a href="e_commerce.html">轮播图</a></li> -->
							<li><a href="siteConfig_SelectCustAdv">分类下广告</a></li>
							<li><a href="siteConfig_selectCustoemrConfig">客户端站点配置</a></li>
 							<!-- <li><a href="project_detail.html">友情链接</a></li> -->
						</ul></li>
					
					<%-- <li><a href="javascript:void(0)"><i class="fa fa-laptop"></i>
							Landing Page <span class="label label-success pull-right">Coming
								Soon</span></a></li> --%>
				</ul>
			</div>

		</div>
		<!-- /sidebar menu -->

		<!-- /menu footer buttons -->
		<div class="sidebar-footer hidden-small">
			<a data-toggle="tooltip" data-placement="top" title="Settings"> <span
				class="glyphicon glyphicon-cog" aria-hidden="true"></span>
			</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
				<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
			</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
				class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
			</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
				href="login.html"> <span class="glyphicon glyphicon-off"
				aria-hidden="true"></span>
			</a>
		</div>
		<!-- /menu footer buttons -->
	</div>
</div>