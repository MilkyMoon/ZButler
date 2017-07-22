<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
    <title>个人中心</title>
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>
<body>
<div class="mine">
    <div class="mine_myMessage">
        <div class="mine_myMessage_head">
            <img src="<%=basePath%>home/dist/wx_image/111.jpg"/>
        </div>
        <div class="mine_myMessage_content">
            <div>185 9832 8899</div>
            <span>普通会员</span>
        </div>
    </div>
    <div class="mine_myAccount">
        <div class="mine_mySmallMoney">
            <span>100.00</span>
            <span class="mine_myAccount_text">零钱</span>
        </div>
        <div class="mine_myIntegral">
            <span>100.00</span>
            <span class="mine_myAccount_text">积分</span>
        </div>
        <div class="mine_myBonus">
            <span>100.00</span>
            <span class="mine_myAccount_text">奖金</span>
        </div>
    </div>
    <div class="mine_order">
        <div class="mine_order_title">
            <div>全部订单</div>
            <a href="<%=basePath%>Order_selectAll">查看全部订单></a>
        </div>
        <div class="mine_order_content">
            <a href="<%=basePath%>Order_selectType?ordStatus=0">
                <div class="mine_order_content_fk"></div>
                <span>待付款</span>
            </a>
            <a href="<%=basePath%>Order_selectType?ordStatus=1">
                <div class="mine_order_content_fh"></div>
                <span>待发货</span>
            </a>
            <a href="<%=basePath%>Order_selectType?ordStatus=2">
                <div class="mine_order_content_sh"></div>
                <span>待收货</span>
            </a>
            <a href="<%=basePath%>Order_selectType?ordStatus=3">
                <div class="mine_order_content_pj"></div>
                <span>待评价</span>
            </a>
            <a href="<%=basePath%>Order_selectType?ordStatus=4">
                <div class="mine_order_content_tk"></div>
                <span>退款/售后</span>
            </a>
        </div>
    </div>
    <div class="mine_function">
        <a href="<%=basePath%>Friends_selectAll" class="mine_function_pyq">
            <div></div>
            <span>我的朋友圈</span>
        </a>
        <a href="#" class="mine_function_jfcz">
            <div></div>
            <span>积分充值</span>
        </a>
        <a href="<%=basePath%>Customer_myQRCode" class="mine_function_ewm">
            <div></div>
            <span>二维码</span>
        </a>
        <a href="<%=basePath%>Customer_askRegister?cusId=1" class="mine_function_fx">
            <div></div>
            <span>分享</span>
        </a>
        <a href="<%=basePath%>CusAddress_selectAll" class="mine_function_shdz">
            <div></div>
            <span>收货地址</span>
        </a>
        <a href="#" class="mine_function_xgmm">
            <div></div>
            <span>修改密码</span>
        </a>
        <a href="<%=basePath%>home/customerService.jsp" class="mine_function_kffw">
            <div></div>
            <span>客服服务</span>
        </a>
        <a href="#" class="mine_function_yhq">
            <div></div>
            <span>我的优惠券</span>
        </a>
        <a href="#" class="mine_function_sqrz">
            <div></div>
            <span>申请入驻</span>
        </a>
        <a href="#" class="mine_function_wddp">
            <div></div>
            <span>我的店铺</span>
        </a>
        <a href="#" class="mine_function_sjsk">
            <div></div>
            <span>商家收款</span>
        </a>
        <a href="#" class="mine_function_bdkh">
            <div></div>
            <span>绑定卡号</span>
        </a>
    </div>
    <div class="mine_button">
        <button type="submit" class="btn-block btn-primary">退出登录</button>
    </div>
</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>
