<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>收货地址</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
</head>
<body>
	<div class="deliveryAddress"  style="padding-top:53px;">
		<jsp:include page="back.jsp" />
		<s:iterator id="cusAddress" value="cusAddressList" status="">


			<div class="deliveryAddressItem">
				<div class="deliveryAddressItem_content">
					<div class="deliveryAddressItem_content_title">
						<%-- <input type="hidden" name="caId" value="<s:property value='caId'></s:property>"/> --%>
						<span><s:property value="caName"></s:property></span> <span><s:property
								value="caPhone"></s:property></span>
					</div>
					<div class="deliveryAddressItem_content_address">
						<s:property value="caProvince"></s:property>
						<s:property value="caCity"></s:property>
						<s:property value="caAddress"></s:property>
					</div>
				</div>
				<div class="deliveryAddressItem_operation">
					<a
						href="<%=basePath%>CusAddress_del?caId=<s:property value='caId'></s:property>"
						class="btn btn-primary">删除</a>
					<%-- <a
					href="javascript:editCusAddress(<s:property value='caId'></s:property>);" class="btn btn-primary">编辑</a>
			 --%>
					<a
						href="<%=basePath%>CusAddress_select?caId=<s:property value='caId'></s:property>"
						class="btn btn-primary">编辑</a>
				</div>
			</div>
		</s:iterator>




		<%-- <div class="deliveryAddressItem">
			<div class="deliveryAddressItem_content">
				<div class="deliveryAddressItem_content_title">
					<span>刘德华</span> <span>185 4322 4594</span>
				</div>
				<div class="deliveryAddressItem_content_address">
					北京市朝阳区建国路建外SOHO</div>
			</div>
			<div class="deliveryAddressItem_operation">
				<a href="javascript:;" class="btn btn-primary">删除</a> <a
					href="javascript:;" class="btn btn-primary">编辑</a>
			</div>
		</div>
		<div class="deliveryAddressItem">
			<div class="deliveryAddressItem_content">
				<div class="deliveryAddressItem_content_title">
					<span>刘德华</span> <span>185 4322 4594</span>
				</div>
				<div class="deliveryAddressItem_content_address">
					北京市朝阳区建国路建外SOHO</div>
			</div>
			<div class="deliveryAddressItem_operation">
				<a href="javascript:;" class="btn btn-primary">删除</a> <a
					href="javascript:;" class="btn btn-primary">编辑</a>
			</div>
		</div> --%>
		<div class="deliveryAddress_addButton">
			<button type="button" class="btn-block btn-danger" onclick="goAdd();">添加</button>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script type="text/javascript">
	function goAdd() {
		window.location.href = "<%=basePath%>home/deliveryAddressAdd.jsp";

	}
</script>
</html>