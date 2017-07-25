<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<form action="<%=basePath%>Customer!update.action" method="post">
			<div class="myLabel_list">
				
			</div>
			<div class="checkedLabelItem">
			</div>
			<input type="hidden" id="data" name="cusTagId" value="${user.cusTagId}">
			<input type="hidden"  name="field" value="cusTagId">
			<button type="submit" class="btn-block btn-primary">提交</button>
		</form>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
	var map = new Map([
		<c:forEach var="tag" items="${tags}">
        	["${tag.tagId}","${tag.tagName}"],
        </c:forEach>
	]);
	var tags = "${user.cusTagId}";
	tags = tags.split(',');
	console.log(tags);
	var selected = new Map();
	var unselected = new Map();
	for (var x of map) {
		if (tags.indexOf(x[0]) != -1) {
			selected.set(x[0], x[1]);
		} else {
			unselected.set(x[0], x[1]);
		}
	}
	for (var z of selected) {
		var SelectedHtml = '<span>' + z[1] + '<i class="icon-error-outline" id="' + z[0] + '" onclick="delLabel($(this))"></i></span>';
		$('.checkedLabelItem').append(SelectedHtml);
	}
	
	for (var y of unselected) {
		 var unselectedHtml = '<span id="' + y[0] + '" onclick="checkLabel($(this))">' + y[1] + '</span>';
		 $('.myLabel_list').append(unselectedHtml);
	}
	
    var myLabel = $('.myLabel_list>span');
    function checkLabel(checkLabel) {
        var clickId = checkLabel.attr('id');
        var clickText = checkLabel.text();
        var checkedLabelHtml = '<span>' + clickText + '<i class="icon-error-outline" id="' + clickId + '" onclick="delLabel($(this))"></i></span>';
        checkLabel.remove();
        $('.checkedLabelItem').append(checkedLabelHtml);
        jiancha();
    }
    function delLabel(delLabel) {
        var delId = delLabel.attr('id');
        var delText = delLabel.parent().text();
        var delLabelHtml = '<span id="' + delId + '" onclick="checkLabel($(this))">' + delText + '</span>';
        delLabel.parent().remove();
        $('.myLabel_list').append(delLabelHtml);
        jiancha();
    }
    function jiancha() {
    	console.log("-----");
    	var ids = "";
        for(var i = 0; i < $('.checkedLabelItem>span').length; i++){
        	if (i == $('.checkedLabelItem>span').length - 1) {
        		ids += $('.checkedLabelItem>span>i').eq(i).attr('id');
        	} else {
        		ids += $('.checkedLabelItem>span>i').eq(i).attr('id') + ",";
        	}
        }
        $("#data").attr("value", ids);
    }
</script>
</html>
