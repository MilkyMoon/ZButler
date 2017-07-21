<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%  String path = request.getContextPath();
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
    <title>客服</title>
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css"> 
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>
<body>
<div class="customerService">
    <form action="<%=basePath%>Message_add">
        <div class="m-cell">
            <div class="cell-item cell-item-first">
                <div>
                    <input type="radio" name="mesType" value="1">留言
                </div>
                <div>
                    <input type="radio" name="mesType" value="2">投诉
                </div>
                <div>
                    <input type="radio" name="mesType" value="3">询问
                </div>
                <div>
                    <input type="radio" name="mesType" value="4">售后
                </div>
                <div>
                    <input type="radio" name="mesType" value="5">求购
                </div>
            </div>
            <div class="cell-item">
                <div class="cell-left">主题：</div>
                <div class="cell-right"><input type="text" name="mesTitle" class="cell-input" placeholder="" autocomplete="off" /></div>
            </div>
            <div class="cell-item cell-item-last">
                <div class="cell-right">
                    <textarea class="cell-textarea" name="mesContent" placeholder="输入留言内容或直接电话联系400-800-0000"></textarea>
                </div>
            </div>
        </div>
     <!--    <button type="button" class="btn-block btn-primary">提交</button> -->
     <input type="submit" class="btn-block btn-primary" value="提交"/>
    </form>
    <a href="<%=basePath%>Message_selectAll.action">查看我的留言</a>
</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
</html>