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
    <title>分享</title>
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>
<body>
<div class="share">
    <div class="share_register">
        <div class="share_register_introduce">
            积分宝是国内首家消费养老平台， 全国有600多个县区服务中心，遍及西藏以外的所有省市。<br><br>
            积分宝推出充值赚钱小游戏，是为了更好的锁定会员消费，积累会员数据！
        </div>
        <form id="signupForm">
            <div class="m-cell">
                <div class="cell-item cell-item-first">
                    <div class="cell-right">
                        <input type="number" name="tel" pattern="[0-9]*" class="cell-input"placeholder="输入手机号，立即注册积分宝" autocomplete="off" />
                    </div>
                </div>
                <div class="cell-item cell-item-last">
                    <div class="cell-right">
                        <input type="number" pattern="[0-9]*" class="cell-input" placeholder="请输入验证码" autocomplete="off"/>
                        <button type="button" class="btn btn-danger">获取验证码</button>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn-block btn-primary">注册</button>
        </form>
    </div>
    <div class="share_comment">
        <div class="share_commentItem">
            <div class="share_comment_head">
                <img src="<%=basePath%>home/dist/wx_image/111.jpg"/>
            </div>
            <div class="share_comment_content">
                <div>185 9832 8899</div>
                <span>80后，处女座，程序员</span>
                <p>"我第一次想着充了10元试试，没想到第二天真的赚回20元！我又充值了100元，这次得到200元奖金，哈 哈！充得多赚得多！爽！我现在准备充500块，准备赚回1500元呢！"</p>
            </div>
        </div>
        <div class="share_commentItem">
            <div class="share_comment_head">
                <img src="<%=basePath%>home/dist/wx_image/111.jpg"/>
            </div>
            <div class="share_comment_content">
                <div class="userName"></div>
                <span>80后，处女座，程序员</span>
                <p>"我第一次想着充了10元试试，没想到第二天真的赚回20元！我又充值了100元，这次得到200元奖金，哈 哈！充得多赚得多！爽！我现在准备充500块，准备赚回1500元呢！"</p>
            </div>
        </div>
    </div>
    <div class="share_QRCode">
        <img src="<%=basePath%>home/dist/wx_image/QRCode.png"/>
        <div>目前已经有100万用户加入积分宝商城<br>微信扫一扫关注积分宝</div>
    </div>
</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
<script>

    //    表单验证

    $.validator.setDefaults({
        submitHandler: function () {
            alert("提交事件!");
        }
    });

    $().ready(function () {
// 在键盘按下并释放及提交后验证提交表单
        $("#signupForm").validate({
            rules: {
                tel: {
                    required: true,
                    rangelength: [11,11]
                }
            },
            messages: {
                tel: {
                    required: "请输入手机号",
                    rangelength: "无效手机号"
                }
            }
        });
    });
</script>
</html>