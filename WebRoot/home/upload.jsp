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

<title>My JSP 'upload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<!-- 	<form action="fileUpload" method="post" enctype="multipart/form-data">
		uploader:<input type="text" name="uploader"> select file:<input
			type="file" name="upload" onchange="ImagePreview(this)"> <input
			type="submit" value="Upload">
	</form> -->

	<form id="uploadForm">
			上传文件： <input type="file" name="upload" onchange="doUpload()"/>
	</form>
	<img id="imgPre">
</body>
</html>
<script src="<%=basePath%>home/dist/wx_js/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.uploadify.min.js"></script>
<script type="text/javascript">
	function doUpload() {
		var formData = new FormData($("#uploadForm")[0]);
		console.log(formData)
		$.ajax({
			url : '<%=basePath%>fileUpload', 
			type : 'POST',
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				$("#imgPre").attr("src",jQuery.parseJSON(data).filePath)
				console.log(jQuery.parseJSON(data).filePath)
			},
			error : function(data) {
				console.log(data)
			}
		});
	}
</script>
