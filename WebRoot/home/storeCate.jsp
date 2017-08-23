<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
                <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
                    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
                    <html>

                    <head>
                        <base href="<%=basePath%>">

                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
                        <title>分类</title>
                        <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/ydui.css">
                        <link rel="stylesheet" href="<%=basePath%>home/dist/wx_css/style.css">

                    </head>

                    <body>
                        <div class="fenlei">

                            <div class="fenlei_button">
                                <div class="fenlei_dialog_out">
                                    <span>全部分类&nbsp;</span> <i class="fa fa-caret-down"></i>
                                </div>
                                <div id="autoSort" class="zhineng_dialog_out">
                                    <span>智能排序&nbsp;</span> <i class="fa fa-caret-down"></i>
                                </div>
                            </div>

                            <div class="choose">
                                <ul>
                                    <li>按人气</li>
                                    <li>按返利</li>
                                </ul>
                            </div>
                            <div class="fenlei_dialog">
                                <div class="fenlei_dialog_content">
                                    <div class="fenlei_dialog_big">
                                        <c:forEach var="ca" items="${cateLines}" varStatus="i">
                                            <c:if test="${i.index == 0}">
                                                <span class="active" onclick="queryCate($(this))" cate="${ca.calId}"> ${ca.calName}</span>
                                            </c:if>
                                            <c:if test="${i.index != 0}">
                                                <span onclick="queryCate($(this))" cate="${ca.calId}">${ca.calName}</span>
                                            </c:if>
                                        </c:forEach>
                                        <!-- <span class="active">全部</span>
	                <span>没事</span>
	                <span>购物</span>
	                <span>医药</span>
	                <span>没事</span>
	                <span>医药</span> -->
                                    </div>
                                    <div class="fenlei_dialog_small" id="smallCate">
                                        <c:forEach var="cas" items="${cateLine}" varStatus="i">

                                            <span onclick="queryStore($(this))" cate="${cas.calId}">${cas.calName}</span>

                                        </c:forEach>
                                        <!-- <span>地方菜系</span>
	                <span>咖啡酒吧</span>
	                <span>甜点音频</span>
	                <span>甜点音频</span>
	                <span>其他没事</span>
	                <span>甜点音频</span>
	                <span>其他没事</span> -->
                                    </div>
                                </div>
                            </div>
                            <div class="fenleiList" id="close">
                                <c:forEach var="bus" items="${buss}">
                                    <a href="<%=basePath%>offlineStore_queryBusines.action?city=${city}&busId=${bus.busId}">
                                        <div class="fenleiItem">
                                            <img src="${bus.busOrgUrl}" />
                                            <div class="fenleiItem_content">
                                                <div class="fenleiItem_content_title">
                                                    <div class="fenleiItem_name">${bus.busShopName}</div>
                                                    <span class="fenleiItem_mark"><fmt:formatNumber
										type="number" maxFractionDigits="0"
										value="${bus.busScalePoints * 100}" />%</span>
                                                </div>
                                                <div>${name}</div>
                                                <div>
                                                    消费人数 <span class="findMe">${fn:length(bus.busTradings)}</span>人
                                                </div>
                                                <div class="businessCommend_title_starNum" data="3.1">
                                                    <!--<img src="image/star.png"/>-->
                                                    <!--<img src="image/star.png"/>-->
                                                    <!--<img src="image/star.png"/>-->
                                                    <!--<img src="image/star.png"/>-->
                                                    <!--<img src="image/star.png"/>-->
                                                    <!--<span>5.0</span>-->
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </c:forEach>

                            </div>

                        </div>
                    </body>
                    <script src="<%=basePath%>home/dist/wx_js/ydui.flexible.js"></script>
                    <script src="<%=basePath%>home/dist/wx_js/jquery.2.1.1min.js"></script>
                    <script src="<%=basePath%>home/dist/wx_js/ydui.js"></script>
                    <script src="<%=basePath%>home/dist/wx_js/score.js"></script>
                    <script type="text/javascript">
                        $('.fenlei_button>div').click(function() {
                            if ($(this).find('i').attr('class') === 'fa fa-caret-down') {
                                $('.fenlei_button').find('i').attr('class', 'fa fa-caret-down');
                                $(this).find('i').attr('class', 'fa fa-caret-up');
                            } else {
                                $(this).find('i').attr('class', 'fa fa-caret-down')
                            }
                        });
                        $('.fenlei_dialog_out').click(function() {
                            $('.choose').css('display', 'none');
                            if ($('.fenlei_dialog').css('display') === 'none') {
                                $('.fenlei_dialog').css('display', 'block');
                            } else {
                                $('.fenlei_dialog').css('display', 'none');
                            }
                        });
                        $('.fenlei_dialog_big>span').click(function() {
                            $('.fenlei_dialog_big').find('span').attr('class', '');
                            $(this).attr('class', 'active');
                        })

                        function queryCate(delLabel) {
                            console.log(delLabel.attr("cate"));
                            var pid = delLabel.attr("cate");
                            $.post("<%=basePath%>querySmallJson", {
                                    pid: pid,
                                },
                                function(data) {
                                    var obj = JSON.parse(data);
                                    opString = null;
                                    $("#smallCate").children().remove();
                                    for (var index = 0; index < obj.smalls.length; index++) {
                                        var opString = '<span cate=' + obj.smalls[index].calId + ' onclick="queryStore($(this))">' + obj.smalls[index].calName + '</span>';
                                        $("#smallCate").append(opString);
                                    }

                                });
                        }

                        function queryStore(searchOne) {
                            console.log(searchOne.attr("cate"));
                            var queryStoreId = searchOne.attr("cate");
                            window.location.href = '<%=basePath%>offlineStore_queryCate?cate=${cate}&child=' + queryStoreId;
                        }


                        /* $('body').click(function(e){
                        	console.log(e.target);
                        	var MyTarget = e.target;
                        	if (!MyTarget.is($('.fenlei_dialog_content'))) {
                        		$('.fenlei_dialog').css('display', 'none');
                        	}
                        }); */

                        $(".zhineng_dialog_out").click(function() {
                            //干掉打开的 fenlie
                            $('.fenlei_dialog').css('display', 'none');
                            $(".choose").toggle()
                        });
                        $(".choose").find("ul>li").each(function() {
                            $(this).click(function() {
                                if ($(this).text() == '按人气') {

                                    console.log('按人气');
                                    var arr = [];
                                    $('.fenleiList').children().map(function(index, value, array) {
                                        arr.push(value);
                                    });
                                    console.log(arr);
                                    arr.sort(function(objOne, objTwo) {
                                        var valOne = $(objOne).find('.findMe').html();
                                        var valTwo = $(objTwo).find('.findMe').html();
                                        if (valOne < valTwo) {
                                            return 1;
                                        } else if (valOne > valTwo) {
                                            return -1;
                                        } else {
                                            return 0;
                                        }
                                    });
                                    $('.fenleiList').children().remove();
                                    arr.map(function(index, value, array) {
                                        console.log(index);
                                        $('.fenleiList').append(index);
                                    });
                                }
                                if ($(this).text() == '按返利') {
                                    console.log('按返利');
                                    var arr = [];
                                    $('.fenleiList').children().map(function(index, value, array) {
                                        arr.push(value);
                                    });
                                    console.log(arr);
                                    arr.sort(function(objOne, objTwo) {
                                        var valOne = $(objOne).find('.fenleiItem_mark').html().slice(0, -1);
                                        console.log(valOne);
                                        var valTwo = $(objTwo).find('.fenleiItem_mark').html().slice(0, -1);
                                        console.log(valTwo);
                                        if (valOne < valTwo) {
                                            return 1;
                                        } else if (valOne > valTwo) {
                                            return -1;
                                        } else {
                                            return 0;
                                        }
                                    });
                                    $('.fenleiList').children().remove();
                                    arr.map(function(index, value, array) {
                                        console.log(index);
                                        $('.fenleiList').append(index);
                                    });
                                }
                                $(".choose").toggle()
                            });
                        });
                    </script>

                    </html>