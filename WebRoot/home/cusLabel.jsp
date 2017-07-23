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
<title>个性标签</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

</head>

<body>
	<div class="myLabel">
		<form>
			<div class="myLabel_list">
				<span onclick="checkLabel($(this))">可爱ing</span>
            	<span onclick="checkLabel($(this))">学习ing</span>
            	<span onclick="checkLabel($(this))">可爱ing</span>
            	<span onclick="checkLabel($(this))">学习ing</span>
            	<span onclick="checkLabel($(this))">可爱ing</span>
            	<span onclick="checkLabel($(this))">学习ing</span>
            	<span onclick="checkLabel($(this))">可爱ing</span>
            	<span onclick="checkLabel($(this))">学习ing</span>
            	<span onclick="checkLabel($(this))">可爱ing</span>
            	<span onclick="checkLabel($(this))">学习ing</span>
            	<span onclick="checkLabel($(this))">可爱ing</span>
            	<span onclick="checkLabel($(this))">学习ing</span>
			</div>
			<div class="checkedLabelItem"></div>
			<button type="button" class="btn-block btn-primary">提交</button>
		</form>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
    var myLabel = $('.myLabel_list>span');
    for (var i = 0; i < myLabel.length; i++) {
        myLabel.eq(i).attr('id', i + 1);
    }
    function checkLabel(checkLabel) {
        var clickId = checkLabel.attr('id');
        var clickText = checkLabel.text();
        var checkedLabelHtml = '<span>' + clickText + '<i class="icon-error-outline" id="' + clickId + '" onclick="delLabel($(this))"></i></span>';
        checkLabel.remove();
        $('.checkedLabelItem').append(checkedLabelHtml);
    }
    function delLabel(delLabel) {
        var delId = delLabel.attr('id');
        var delText = delLabel.parent().text();
        var delLabelHtml = '<span id="' + delId + '" onclick="checkLabel($(this))">' + delText + '</span>';
        delLabel.parent().remove();
        $('.myLabel_list').append(delLabelHtml);
    }
    $('.btn-primary').click(function () {
        for(var i = 0; i < $('.checkedLabelItem>span').length; i++){
            console.log($('.checkedLabelItem>span>i').eq(i).attr('id'))
        }
    })
</script>
</html>
