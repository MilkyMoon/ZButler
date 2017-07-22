<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>个人信息</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="myMessage">
		<div class="dialog_guide">
			<div class="dialog_guide_bg"></div>
			<div class="dialog_guide_content">
				<a href="myMessage.html" class="btn btn-primary">下一步</a> <span>点击这里，绑定手机、微信</span>
				<img src="home/dist/wx_image/guide2.png">
				<div></div>
			</div>
		</div>
		<div class="m-cell">
			<a href="#">
				<div class="cell-item">
					<div class="cell-left">头像</div>
					<div class="cell-right cell-arrow">
						<img src="${user.cusImgUrl}" />
					</div>
				</div>
			</a> <a href="<%=basePath%>home/updateNickname.jsp">
				<div class="cell-item">
					<div class="cell-left">昵称</div>
					<div class="cell-right cell-arrow">${user.cusNickname}</div>
				</div>
			</a> <a href="<%=basePath%>home/updateBirth.jsp">
				<div class="cell-item" style="margin-top: 12px">
					<div class="cell-left">生日</div>
					<div class="cell-right cell-arrow">
						<fmt:formatDate value="${user.cusBirth}" pattern="yyyy-MM-dd" />
					</div>
				</div>
			</a>
			<div class="cell-item">
				<div class="cell-left">性别</div>
				<div class="cell-right cell-arrow sex">
					<c:if test="${user.cusSex == 1}">男</c:if>
					<c:if test="${user.cusSex == 2}">女</c:if>
				</div>
			</div>
			<a href="<%=basePath%>home/updateHobby.jsp">
				<div class="cell-item">
					<div class="cell-left">兴趣爱好</div>
					<div class="cell-right cell-arrow">${user.cusHobby}</div>
				</div>
			</a> <a href="<%=basePath%>home">
				<div class="cell-item">
					<div class="cell-left">个人标签</div>
					<div class="cell-right cell-arrow">勿忘初心点丶一路向西</div>
				</div>
			</a> <a href="<%=basePath%>home/forgetPasswordOne.jsp">
				<div class="cell-item" style="margin-top: 12px">
					<div class="cell-left">忘记密码</div>
					<div class="cell-right cell-arrow"></div>
				</div>
			</a> <a href="<%=basePath%>home/modifyPassword.jsp">
				<div class="cell-item">
					<div class="cell-left">修改密码</div>
					<div class="cell-right cell-arrow"></div>
				</div>
			</a> <a href="<%=basePath%>home/BindingPhone.jsp">
				<div class="cell-item">
					<div class="cell-left">
						<c:if test="${empty user.cusOpenId}">微信绑定</c:if>
						<c:if test="${empty user.cusPhone}">手机绑定</c:if>
						<c:if test="${!empty user.cusPhone and !empty user.cusOpenId}">解除绑定</c:if>
					</div>
					<div class="cell-right cell-arrow"></div>
				</div>
			</a> <a href="<%=basePath%>home/setPayPassword.jsp">
				<div class="cell-item">
					<div class="cell-left">支付密码</div>
					<div class="cell-right cell-arrow"></div>
				</div> 
			</a>
		</div>
		<div class="dialog">
			<div class="dialog_bg"></div>
			<div class="dialog_message">
				<div class="dialog_content">
					<div class="dialog_title">性别</div>
					<div class="dialog_select">
						<div>男</div>
						<div>女</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
	!(function($) {
		$('.dialog_guide_bg').css('height', document.body.scrollHeight);
		$('.sex').click(function() {
			$('.dialog').css('display', 'block')
		});
		$('.dialog_select>div').click(function() {
			$('.sex').text($(this).text());
			$('.dialog').css('display', 'none');
			var sex;
			if ($(this).text() === '男') {
				sex = 1;
			} else {
				sex = 2;
			}
			$.post("<%=basePath%>Customer!update.action",
				{
					field : "cusSex",
					cusSex : sex,
				},
				function(data) {});
		});
	})(jQuery);
	
	if (${!empty user.cusPhone and !empty user.cusOpenId}) {
    	$('.dialog_guide').css('display', 'none');
    }
</script>
</html>
