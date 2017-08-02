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
	<div id="localImag" style="width: 300px; height: 200px">
		<img id="preview" alt="预览图片" src="" width="300px" height="200px" />
	</div>
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		uploader:<input type="text" name="uploader"> select file:<input
			type="file" name="upload"  onchange="ImagePreview(this)"> <input type="submit"
			value="Upload">
	</form>
</body>
</html>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script type="text/javascript">
	function ImagePreview(docObj) {
		console.log(window.webkitURL.createObjectURL(docObj.files[0]))
		$("#preview").attr("src", window.webkitURL.createObjectURL(docObj.files[0]));
	}
</script>
