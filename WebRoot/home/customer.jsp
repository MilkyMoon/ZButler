<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>个人中心</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>

<body>
	<div class="mine">
		<div class="dialog">
			<div class="dialog_bg"></div>
			<div class="dialog_content">
				<img src="home/dist/wx_image/guide.png"> <span>点击这里，查看个人信息</span>
				<a href="<%=basePath%>home/cusMessage.jsp" class="btn btn-primary">下一步</a>
			</div>
		</div>
		<div class="mine_myMessage">
			<div class="mine_myMessage_head">
				<img src="${user.cusImgUrl}" />
			</div>
			<div class="mine_myMessage_content">
				<div>${user.cusNickname}</div>
				<span>普通会员</span>
			</div>
		</div>
		<div class="mine_myAccount">
				<div class="mine_mySmallMoney">
					<span>${cac.cacChange}</span> <span
						class="mine_myAccount_text">零钱</span>
				</div>
				<div class="mine_myIntegral">
					<span>${cac.cacPoints}</span> <span
						class="mine_myAccount_text">积分</span>
				</div>
				<div class="mine_myBonus">
					<span>${cac.cacBonus}</span> <span
						class="mine_myAccount_text">奖金</span>
				</div>
		</div>
		<div class="mine_order">
			<div class="mine_order_title">
				<div>全部订单</div>
				<a href="<%=basePath%>Order!selectAll.action">查看全部订单></a>
			</div>
			<div class="mine_order_content">
				<a href="<%=basePath%>Order_selectType?ordStatus=0">
					<div class="mine_order_content_fk"></div> <span>待付款</span>
				</a> <a href="<%=basePath%>Order_selectType?ordStatus=1">
					<div class="mine_order_content_fh"></div> <span>待发货</span>
				</a> <a href="<%=basePath%>Order_selectType?ordStatus=2">
					<div class="mine_order_content_sh"></div> <span>待收货</span>
				</a> <a href="<%=basePath%>Order_selectType?ordStatus=3">
					<div class="mine_order_content_pj"></div> <span>待评价</span>
				</a> <a href="#">
					<div class="mine_order_content_tk"></div> <span>退款/售后</span>
				</a>
			</div>
		</div>
		<div class="mine_function">
			<a href="<%=basePath%>Friends!selectAll.action" class="mine_function_pyq">
				<div></div> <span>我的朋友圈</span>
			</a> 
			<a href="<%=basePath%>WxOauthRedirect!IntoRechage.action" class="mine_function_jfcz">
				<div></div> <span>零钱充值</span>
			</a> 
			<a href="<%=basePath%>Customer!myQRCode.action" class="mine_function_ewm">
				<div></div> <span>二维码</span>
			</a> 
			<a href="<%=basePath%>Customer!askRegister.action" class="mine_function_fx">
				<div></div> <span>分享</span>
			</a> 
			<a href="<%=basePath%>CusAddress_selectAll.action" class="mine_function_shdz">
				<div></div> <span>收货地址</span>
			</a> 
			<a href="<%=basePath%>home/modifyPassword.jsp" class="mine_function_xgmm">
				<div></div> <span>修改密码</span>
			</a> 
			<a href="<%=basePath%>home/customerService.jsp"
				class="mine_function_kffw">
				<div></div> <span>客服服务</span>
			</a> 
			<a href="<%=basePath%>CusCoupon!grouping.action"
				class="mine_function_yhq">
				<div></div> <span>我的优惠券</span>
			</a> 
			<a href="<%=basePath%>cateLine_selectAll" class="mine_function_sqrz">
				<div></div> <span>申请入驻</span>
			</a> 
			<a href="<%=basePath%>home/myStore.jsp" class="mine_function_wddp">
				<div></div> <span>我的店铺</span>
			</a> 
			<a href="<%=basePath%>home/storeReceipts.jsp" class="mine_function_sjsk">
				<div></div> <span>商家收款</span>
			</a> 
			<a href="<%=basePath%>CusBank!queryAll.action" class="mine_function_bdkh">
				<div></div> <span>绑定卡号</span>
			</a>
		</div>
		<div class="mine_button">
			<a href="<%=basePath%>Customer!logout.action"><button type="submit" class="btn-block btn-primary">退出登录</button></a>
		</div>
	</div>
</body>

<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
${js}
<script>
    $('.dialog_bg').css('height',document.body.scrollHeight);
    if (${empty user.cusPhone or empty user.cusOpenId}) {
    	$('.dialog').css('display', 'block');
    }
    $(".mine_myMessage").click(function(){
    	window.location.href = "<%=basePath%>home/cusMessage.jsp";
    });
    
    $(".mine_mySmallMoney").click(function(){
    	window.location.href = "<%=basePath%>CusAccount!change.action";
    });
    $(".mine_myIntegral").click(function(){
    	window.location.href = "<%=basePath%>CusAccount!points.action";
    });
    
</script>
</html>
