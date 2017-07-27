<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
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
<title>我的朋友圈</title>
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
<link rel="stylesheet"
	href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
</head>
<body>
	<div class="myFriendO">
		<div class="myFriendO_myMessage">
			<div class="myFriendO_myMessage_head">
				<img src="${user.cusImgUrl}" />
			</div>
			<div class="myFriendO_myMessage_content">
				<div class="userName">${user.cusNickname}</div>
				<span>普通会员</span>
			</div>
		</div>
		<div class="myFriendO_myFriends">
			<div class="myFriendO_myFriends_num">
				<a href="#"> 我的朋友：<span><s:property
							value="%{friendsList.size()}" /></span>
				</a>
			</div>
			<%-- <s:iterator id="friends" value="friendsList" status="">
				<div class="myFriendO_myFriendItem">
					<a href="#"><s:property value="friPhone" /> </a>
				</div>
			</s:iterator> --%>
			
			<div class="myFriendO_myFriendItem">
				我的朋友A<span>50</span>
				<div class="myFriendO_myFriendItem_down">
					<div>18831655696</div>
					<div>18831655696</div>
					<div>18831655696</div>
				</div>
			</div>
			<div class="myFriendO_myFriendItem">
				我的朋友B<span>50</span>
				<div class="myFriendO_myFriendItem_down">
					<div>18831655696</div>
					<div>18831655696</div>
					<div>18831655696</div>
				</div>
			</div>
			<div class="myFriendO_myFriendItem">
				我的朋友C<span>50</span>
				<div class="myFriendO_myFriendItem_down">
					<div>18831655696</div>
					<div>18831655696</div>
					<div>18831655696</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
<script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
<script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
<script>
    $('.myFriendO_myFriendItem').click(function () {
        if ($(this).find('.myFriendO_myFriendItem_down').css('display') === 'block') {
            $('.myFriendO_myFriendItem_down').css('display', 'none');
        } else {
            $('.myFriendO_myFriendItem_down').css('display', 'none');
            $(this).find('.myFriendO_myFriendItem_down').css('display', 'block');
        }
    })
</script>
</html>