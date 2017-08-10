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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>众邦管理</title>

<!-- Bootstrap -->
<link
	href="<%=basePath%>admin/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<%=basePath%>admin/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="<%=basePath%>admin/vendors/nprogress/nprogress.css"
	rel="stylesheet">
<!-- Animate.css -->
<link href="<%=basePath%>admin/vendors/animate.css/animate.min.css"
	rel="stylesheet">
	
	<link href="<%=basePath%>admin/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="<%=basePath%>admin/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="<%=basePath%>admin/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="<%=basePath%>admin/build/css/custom.min.css"
	rel="stylesheet">

</head>

<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
				<form method="post"
					action="<%=basePath%>admin/adminLogin!login.action" id="signupForm">
					<h1>后台管理系统</h1>
					<div>
						<input type="text" class="form-control" placeholder="请输入用户名"
							name="thuUsername" required="" />
					</div>
					<div>
						<input type="password" class="form-control" placeholder="请输入密码"
							name="thuPassword" required="" />
					</div>
					<div>
						<div class="col-md-6">
							<input type="text" class="form-control" placeholder="验证码"
								id="code" name="code" required="" />
						</div>
						<div class="col-md-6">
							<img style="width:90%" id="checkImg" class="captchaImage"
								src="<%=basePath%>admin/code.action">
						</div>

					</div>
					<div style="width:100%;float:left">
						<button type="submit" class="btn btn-default submit">Log
							in</button>
						<p class="reset_pass">欢迎来到众帮管家!</p>
					</div>

					<div class="clearfix"></div>

					<div class="separator">

						<div class="clearfix"></div>
						<br />

						<div>
							<h1>
								<i class="fa fa-paw"></i> 众邦管家
							</h1>
							<p>©2017</p>
						</div>
					</div>
				</form>
				</section>
			</div>
		</div>
	</div>
	<input type="hidden" id="confire" value="${test}">
</body>
<!-- jQuery -->
<script src="<%=basePath%>admin/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script
	src="<%=basePath%>admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="<%=basePath%>admin/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="<%=basePath%>admin/vendors/nprogress/nprogress.js"></script>
<!-- bootstrap-progressbar -->
<script
	src="<%=basePath%>admin/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="<%=basePath%>admin/vendors/iCheck/icheck.min.js"></script>
<!-- PNotify -->
<script src="<%=basePath%>admin/vendors/pnotify/dist/pnotify.js"></script>
<script src="<%=basePath%>admin/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script
	src="<%=basePath%>admin/vendors/pnotify/dist/pnotify.nonblock.js"></script>
<script type="text/javascript">
	$("#checkImg").click(function() {
		var img1 = document.getElementById("checkImg");
		img1.src = "<%=basePath%>admin/code.action?d=" + new Date().getTime();
	});
	if ($("#confire").val() == '1') {
		new PNotify({
			title : '帐号密码错误!',
			text : '如果登陆不上请与超级管理员联系.',
			type : 'error',
			styling : 'bootstrap3'
		});
		
		$("#confire").val("123");
	}
</script>
</html>
