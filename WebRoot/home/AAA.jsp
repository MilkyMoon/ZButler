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


<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
<style>
.file {
	position: absolute;
	font-size: 100px;
	opacity: 0;
	filter: alpha(opacity = 0);
	border: 1px solid red;
	width: 100px;
	height: 100px;
	cursor: pointer;
	z-index: 1000;
}

.addImg img {
	position: absolute;
}
</style>

</head>

<body>
	<div class="storeImg">
		<div class="storeImg_content">
			<div class="storeImg_addImg">
				<div class="addImg">
					<img src="<%=basePath%>home/dist/wx_image/addImg.png" /> <input
						type="file" class="file">
				</div>
			</div>
			<div class="storeImg_img">
				<img src="<%=basePath%>home/dist/wx_image/111.jpg" />
				<div class="storeImg_del">
                    <a href=""><img src="<%=basePath%>home/dist/wx_image/del.png"/></a>
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

		$('.storeImg').css('height', document.body.scrollHeight);
		var img = $('input[type="file"]');
		img.change(function() {
			var imgFile = new FileReader();
			imgFile.readAsDataURL(img[0].files[0]);
			imgFile.onload = function() {
				var imgData = this.result; //base64数据
				// 创建img 对象
				console.log(imgData)
			}
		});

	})(jQuery);
</script>
</html>
