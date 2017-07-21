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
<title>注册</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="login">
		<form id="signupForm" method="post"
			action="<%=basePath%>Customer!login.action">
			<div class="m-cell">
				<div class="cell-item cell-item-first">
					<div class="cell-left">账号：</div>
					<div class="cell-right">
						<input type="number" name="cusPhone" pattern="[0-9]*"
							id="username" class="cell-input" placeholder="手机号"
							autocomplete="off" />
					</div>
				</div>
				<div class="cell-item cell-item-last">
					<div class="cell-left">密码：</div>
					<div class="cell-right">
						<input type="password" name="cusPassword" class="cell-input"
							id="password" placeholder="密码" autocomplete="off" />
					</div>
				</div>
			</div>
			<div class="login_remember">
				<input type="checkbox" id="che"> <span>记住密码</span>
			</div>
			<div class="login_button">
				<button type="submit" class="btn-block btn-primary login_button_now">立即登陆</button>
				<button type="button" class="btn-block btn-primary login_button_wei"><a  id="wxlogin"href="">微信登陆</a></button>
			</div>
			<div class="login_question">
				<a href="<%=basePath%>home/register.jsp">免费注册</a> <a href="#">忘记密码</a>
			</div>
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

    $().ready(function () {
    	${js}
    	if (window.localStorage.getItem("user")) {
    		$("#username").val(window.localStorage.getItem("user"));
    		$("#password").val(window.localStorage.getItem("pass"));
    		$("#che").attr("checked", true);
    	}
    	// 微信登陆
    	$.ajax({
		type : "get",
		dataType : "json",
		url : "<%=basePath%>/ZButler/WxOauthRedirect!WeXinLogin.action",
		success : function(result) {
			console.log(result)
			$(".login_button_wei").find("a").attr("href",JSON.parse(result).LoginUrl);
		}
	});
    	
    	
    	
// 在键盘按下并释放及提交后验证提交表单
        $("#signupForm").validate({
            rules: {
                cusPhone: {
                    required: true,
                    rangelength: [11,11]
                },
                cusPassword: "required"
            },
            messages: {
                cusPhone: {
                    required: "请输入用户名",
                    rangelength: "用户名无效"
                },
                cusPassword: "请输入密码"
            }
        });
        
        $("#signupForm").submit(function(e) {
			if ($("#che").is(":checked")) {
				window.localStorage.setItem("user", $("#username").val());
				window.localStorage.setItem("pass", $("#password").val());
			} else {
				window.localStorage.clear();
			}
		});
    });
</script>
</html>
