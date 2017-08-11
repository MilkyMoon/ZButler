 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
    <title>店铺照片</title>
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>home/dist/wx_css/cropper.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>home/dist/wx_css/mui.min.css">
    <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/font-awesome.min.css">
    <script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
    <script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
    
    <script type="text/javascript" src="<%=basePath%>home/dist/wx_js/lrz.all.bundle.js"></script>
    <script type="text/javascript" src="<%=basePath%>home/dist/wx_js/cropper.min.js"></script> 
    <script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
    

</head>

<body>
	<div class="addHeadImg" style="padding-top:53px;">
		<div class="integral2_top">
			<div class="integral2_top_left">
				<i class="fa fa-angle-left"></i> <a style="color:#FFF"
					href="<%=basePath%>home/myStore.jsp">返回</a>
			</div>
			<div class="integral2_top_center"></div>
		</div>
	<div id="showResult">
	    <div id="changeAvatar" style="margin-top: 60px;">
	        <img src='${store.busOrgUrl}' style="width: 100px;display:block;">
	    </div>
	</div>
    <div class="addHeadImg_button">
        <div class="my_input">上传图片</div>
        <input id="image" type="file" accept="image/*" capture="caera"/>
    </div>

	<div id="showEdit" style="display: none;width:100%;height: 100%;position: absolute;top:0;left: 0;z-index: 9;">
	    <div style="width:100%;position: absolute;top:10px;left:0px;">
	        <button class="mui-btn" data-mui-style="fab" id='cancleBtn' style="margin-left: 10px;">取消</button>
	        <button class="mui-btn" data-mui-style="fab" data-mui-color="primary" id='confirmBtn'
	                style="float:right;margin-right: 10px;">确定
	        </button>
	    </div>
	    <div id="report"></div>

	</div>
	<div style="width:98%; margin:50px auto;display: none">
	    <textarea name="txt" rows="10" id="basetxt" style="width:100%; border-radius:5px" onclick="this.checked = true"
	              placeholder="base64码"></textarea>
	</div>
</div>
</body>

<script type="text/javascript">
        $(function () {
            $('.addHeadImg').css('height', document.body.scrollHeight);
            function toFixed2(num) {
                return parseFloat(+num.toFixed(2));
            }

            $('#cancleBtn').on('click', function () {
                $("#showEdit").fadeOut();
                $('#showResult').fadeIn();
            });

            $('#confirmBtn').on('click', function () {
                $("#showEdit").fadeOut();

                var $image = $('#report > img');
                var dataURL = $image.cropper("getCroppedCanvas");
                var imgurl = dataURL.toDataURL("image/jpeg", 0.5);
                $("#changeAvatar > img").attr("src", imgurl);
                $("#basetxt").val(imgurl);
                console.log(imgurl);
                $('#showResult').fadeIn();
                $.post("<%=basePath%>business!updateBus.action", 
                {
                	busOrgUrl: imgurl,
                	busId: ${store.busId}
                },
                function(data){
                	console.log("-------------");
                	
                });

            });

            function cutImg() {
                $('#showResult').fadeOut();
                $("#showEdit").fadeIn();
                var $image = $('#report > img');
                $image.cropper({
                    aspectRatio: 1 / 1,
                    autoCropArea: 0.7,
                    strict: true,
                    guides: false,
                    center: true,
                    highlight: false,
                    dragCrop: false,
                    cropBoxMovable: false,
                    cropBoxResizable: false,
                    zoom: -0.2,
                    checkImageOrigin: true,
                    background: false,
                    minContainerHeight: 400,
                    minContainerWidth: 300
                });
            }

            function doFinish(startTimestamp, sSize, rst) {
                var finishTimestamp = (new Date()).valueOf();
                var elapsedTime = (finishTimestamp - startTimestamp);
                //$('#elapsedTime').text('压缩耗时： ' + elapsedTime + 'ms');

                var sourceSize = toFixed2(sSize / 1024),
                    resultSize = toFixed2(rst.base64Len / 1024),
                    scale = parseInt(100 - (resultSize / sourceSize * 100));
                $("#report").html('<img src="' + rst.base64 + '" style="width: 100%;height:100%">');
                cutImg();
            }

            $('#image').on('change', function () {
                var startTimestamp = (new Date()).valueOf();
                var that = this;
                lrz(this.files[0], {
                    width: 800,
                    height: 800,
                    quality: 0.7
                })
                    .then(function (rst) {
                        //console.log(rst);
                        doFinish(startTimestamp, that.files[0].size, rst);
                        return rst;
                    })
                    .then(function (rst) {
                        // 这里该上传给后端啦
                        // 伪代码：ajax(rst.base64)..
                        console.log(rst.base64);

                        return rst;
                    })
                    .then(function (rst) {
                        // 如果您需要，一直then下去都行
                        // 因为是Promise对象，可以很方便组织代码 \(^o^)/~
                    })
                    .catch(function (err) {
                        // 万一出错了，这里可以捕捉到错误信息
                        // 而且以上的then都不会执行

                        alert(err);
                    })
                    .always(function () {
                        // 不管是成功失败，这里都会执行
                    });
            });

        });
    </script>
</html>
