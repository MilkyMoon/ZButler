<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
<title>我的昵称</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="myName" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a
					href="<%=basePath%>home/customer.jsp">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
		<form id="signupForm" method="post"
			action="<%=basePath%>Customer!update.action">
			<div class="m-cell">
				<div class="cell-item">
					<div class="cell-right">
						<input type="hidden" value="cusNickname" name="field"> <input
							type="text" class="cell-input" placeholder="昵称"
							value="${user.cusNickname}" name="cusNickname" autocomplete="off" />
					</div>
				</div>
			</div>
			<button type="submit" class="btn-block btn-primary">提交</button>
		</form>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.validate.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/messages_zh.js"></script>
<script>

//    表单验证

/*     $.validator.setDefaults({
        submitHandler: function () {
            alert("提交事件!");
        }
    }); */

/*  $().ready(function () {
// 在键盘按下并释放及提交后验证提交表单
     $("#signupForm").validate({
         rules: {
             cusNickname: "required"
         },
         messages: {
             cusNickname: "昵称不能为空"
         }
     });
 }); */
</script>
</html>
