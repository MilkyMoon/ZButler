<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>收益统计 | 众帮管家</title>

    <!-- Bootstrap -->
    <link href="./vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="./vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="./vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="./build/css/custom.min.css" rel="stylesheet">
    
    <style type="text/css">
	#container {
	    height: 640px; 
	    min-width: 310px; 
	    max-width: 900px; 
	    margin: 0 auto
	}
	.loading {
	    margin-top: 10em;
	    text-align: center;
	    color: gray;
	}
	.tx-icon{
		font-size:60px;
	    float: right;
	    margin-right: 12px;
	}
	.tx-icon a{
	    display: block;
	    width: 105px;
	    height: 40px;
	    text-align: left;
	}
	.tx-icon small{
		font-size: 20px;
	    float: left;
	    margin-top: 30px;
	    padding-right: 6px;
	}
	</style>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <jsp:include page="left.jsp" />

		<!-- top navigation -->
		<jsp:include page="header.jsp" />
		<!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>众帮平台收益详情<small>个人收益提现</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">搜索</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
            
            <div class="clearfix"></div>
            
            

            <div class="row">
              <div class="col-md-8 col-sm-8 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>全国收益分布</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
					<!-- <div id="mainb" style="height:350px;"></div> -->
                    
                    <div id="container"></div>

                  </div>
                </div>
              </div>
			
			  <div class="animated flipInY col-lg-4 col-md-3 col-sm-6 col-xs-12">
                 <div class="tile-stats" onclick="tikuan()">
                   <div class="tx-icon"><a href="#"><small>提现</small><i class="fa fa-check-square-o"></a></i>
                   </div>
                   <div class="count">￥179</div>

                   <h3>可提现金额</h3>
                   <p><code>提现钱请先绑定微信，提现后钱自动到账微信零钱.</code></p>
                 </div>
               </div>
               
               <div class="col-md-4 col-sm-6 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Daily active users <small>Sessions</small></h2>
                  <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                      <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Settings 1</a>
                        </li>
                        <li><a href="#">Settings 2</a>
                        </li>
                      </ul>
                    </li>
                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                    </li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <ul class="list-unstyled timeline">
                    <li>
                      <div class="block">
                        <div class="tags">
                          <a href="" class="tag">
                            <span>Entertainment</span>
                          </a>
                        </div>
                        <div class="block_content">
                          <h2 class="title">
                                          <a>Who Needs Sundance When You’ve Got&nbsp;Crowdfunding?</a>
                                      </h2>
                          <div class="byline">
                            <span>13 hours ago</span> by <a>Jane Smith</a>
                          </div>
                          <p class="excerpt">Film festivals used to be do-or-die moments for movie makers. They were where you met the producers that could fund your project, and if the buyers liked your flick, they’d pay to Fast-forward and… <a>Read&nbsp;More</a>
                          </p>
                        </div>
                      </div>
                    </li>
                    <li>
                      <div class="block">
                        <div class="tags">
                          <a href="" class="tag">
                            <span>Entertainment</span>
                          </a>
                        </div>
                        <div class="block_content">
                          <h2 class="title">
                                          <a>Who Needs Sundance When You’ve Got&nbsp;Crowdfunding?</a>
                                      </h2>
                          <div class="byline">
                            <span>13 hours ago</span> by <a>Jane Smith</a>
                          </div>
                          <p class="excerpt">Film festivals used to be do-or-die moments for movie makers. They were where you met the producers that could fund your project, and if the buyers liked your flick, they’d pay to Fast-forward and… <a>Read&nbsp;More</a>
                          </p>
                        </div>
                      </div>
                    </li>
                    <li>
                      <div class="block">
                        <div class="tags">
                          <a href="" class="tag">
                            <span>Entertainment</span>
                          </a>
                        </div>
                        <div class="block_content">
                          <h2 class="title">
                                          <a>Who Needs Sundance When You’ve Got&nbsp;Crowdfunding?</a>
                                      </h2>
                          <div class="byline">
                            <span>13 hours ago</span> by <a>Jane Smith</a>
                          </div>
                          <p class="excerpt">Film festivals used to be do-or-die moments for movie makers. They were where you met the producers that could fund your project, and if the buyers liked your flick, they’d pay to Fast-forward and… <a>Read&nbsp;More</a>
                          </p>
                        </div>
                      </div>
                    </li>
                  </ul>

                </div>
              </div>
            </div>
               
               
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
        	<jsp:include page="footer.jsp" />
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
	<script src="./vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
    <script src="./vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="./vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="./vendors/nprogress/nprogress.js"></script>
    <!-- ECharts -->
    <script src="./vendors/echarts/dist/echarts.min.js"></script>
    <script src="./vendors/echarts/map/js/world.js"></script> 
    <!-- Highmaps -->
    <script src="./js/highmaps/highcharts.js"></script>
	<script src="./js/highmaps/modules/map.js"></script>
	<!--<script src="http://code.highcharts.com/maps/highmaps.js"></script>-->
	<script src="./js/highmaps/modules/data.js"></script>
	<script src="./js/highmaps/modules/drilldown.js"></script>
	<script src="./js/layer/layer.js"></script>
	<script type="text/javascript" src="./js/highmaps/cn-china-by-peng8.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="./build/js/custom.min.js"></script>
    
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    
    <script type="text/javascript">
    	function tikuan(){
	  		layer.open({
				  	title: "提现金额",
				  	content: "<form class='layui-form' action='#' method='post'>"+
					  			 "<div class='input-group' style='width:100%'>"+
	                             	"<input type='text' class='form-control' name='money' style='width:100%'>"+
	                            		"<p>"+
	                                    	"<code>注意：</code>最高可提￥179"+
	                                    "</p>"+
	                                     "<button type='submit' class='btn btn-success' style='float:right'>立即提交</button>"+
	                             "</div>"+
                             "</form>",
				  	closeBtn: 2,
				  	btn: false,
				  	area: ['640px', 'auto']
				});
    	}
    
	  $(function () {
		    Highcharts.setOptions({
		        lang:{
		            drillUpText:"返回 > {series.name}"
		        }
		    });
		    
		    var data = Highcharts.geojson(Highcharts.maps['countries/cn/custom/cn-all-china']),small = $('#container').width() < 400;
			
		    // 给城市设置随机数据
		    $.each(data, function (i) {
		        this.drilldown = this.properties['drill-key'];
	
		        this.value = i;
		    });
		    
		    //获取 point name
			function getPoint(e){
				//console.log(e.point.name);
				$.ajax({
		            cache: false,
		            type: 'POST',
		            url:'billMapInfo.action',
		            data : {
		            	userName: e.point.name,
		            	passWord: '12346'
		            },
		            dataType: 'json',
		            success: function(result) {
		            	var member = eval("("+result+")");    //包数据解析为json 格式
	               		layer.open({
						  	title: e.point.name,
						  	content: member.name,
						  	closeBtn: 2,
						  	area: ['640px', 'auto']
						});
	                },
	                error: function(error){
	                	console.log(error);
	                	layer.open({
						  	title: e.point.name,
						  	content: '<a href="#" >1231</a></br>',
						  	closeBtn: 2,
						  	area: ['640px', 'auto']
						});
	                }
	            });
	
			}
			function getShow(e){
				alert(1);
			}
		    //初始化地图
		    $('#container').highcharts('Map', {
	
		        chart : {
					spacingBottom:30,
						 
		            events: {
		                drilldown: function (e) {
	
		                    if (!e.seriesOptions) {
		                        var chart = this;
		                              /*   mapKey = 'countries/china/' + e.point.drilldown + '-all',
		                              fail = setTimeout(function () {
		                                    if (!Highcharts.maps[mapKey]) {
		                                        chart.showLoading('<i class="icon-frown"></i> 加载失败 ' + e.point.name);
	
		                                        fail = setTimeout(function () {
		                                            chart.hideLoading();
		                                        }, 1000);
		                                    }
		                                }, 10000);*/
		                        var cname=e.point.properties["cn-name"];//cname =获取到的 “cn-name”
		                        chart.showLoading('<i class="icon-spinner icon-spin icon-3x"></i>');
		                        // 加载城市数据
		                        $.ajax({
		                            type: "GET",
		                            url: "http://data.hcharts.cn/jsonp.php?filename=GeoMap/json/"+ e.point.drilldown+".geo.json",
		                            contentType: "application/json; charset=utf-8",
		                            dataType:'jsonp',
		                            crossDomain: true,
		                            success: function(json) {
		                                data = Highcharts.geojson(json);
																	 
		                                $.each(data, function (i) {
																			 
		                                    this.value = i;//随机值，进入省份以后城市的值
											this.events={};
											this.events.click=getPoint;
																				
		                                });
		                                chart.hideLoading();
	
		                                chart.addSeriesAsDrilldown(e.point, {
		                                    name: e.point.name,
		                                    data: data,
											events:{
												show:function(){
													alert(1);
												}
											},
		                                    dataLabels: {
		                                        enabled: true,
		                                        format: '{point.name}'//设置显示形式，这里显示的是 各省的城市数据
		                                    }
		                                });
		                            },
		                            error: function (XMLHttpRequest, textStatus, errorThrown) {
	
		                            }
		                        });
		                    }
	
	
		                    this.setTitle(null, { text: cname });//这显示 图右侧 省份名称，可以回退
		                },
		                drillup: function () {
		                    this.setTitle(null, { text: '中国' }); //右侧 显示中国，进入省份则显示省份
		                }
		            }
		        },
				tooltip: { 
					formatter:function(){
						var htm="累计收益";
						var str="";
						if(this.point.drilldown){
						    str=this.point.properties["cn-name"]+"</br>"+htm;
						}else{
							 str=this.point.name+"</br>"+htm;
						}
						str+=":"+this.point.value+"元";
						return str;
						 
					}
				},
		        credits:{
					href:"javascript:goHome()",
		            text:"众帮管家分销收入"
		        },
		        //标题
		        title : {
		            text : '全国收益图'
		        },
	
		        subtitle: {
		            text: '中国',
		            floating: true,
		            align: 'right',
		            y: 50,
		            style: {
		                fontSize: '16px'
		            }
		        },
	
		        legend: small ? {} : {
					// enabled: false,
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle'
		        },
		        //tooltip:{
		        //pointFormat:"{point.properties.cn-name}:{point.value}"
		        //},
		        //省市程度色彩设置
		        colorAxis: {
		            min: 0,
		            minColor: '#c4e8e0',
		            maxColor: '#087e65',
						labels:{
							style:{
									"color":"red","fontWeight":"bold"
							}
						}
		        },
	
		        mapNavigation: {
		            enabled: true,
		            buttonOptions: {
		                verticalAlign: 'bottom'
		            }
		        },
	
		        plotOptions: {
		            map: {
		                states: {
		                    hover: {
		                        color: '#BADA55'
		                    }
		                }
		            }
		        },
		        
				//默认状态下，地图图表均不显示数据标签。用户需要在数据列中启用才可以。这时，需要使用配置项enabled为true
		        series : [{
		            data : data,
		            name: '中国',
		            joinBy: 'hc-key',
		            states: {
		                hover: {
		                    color: '#BADA55'
		                }
		            },
		            dataLabels: {
		                enabled: true,
		                format: '{point.properties.cn-name}'//设置显示形式，这里显示的是 各城市名称
		            }
		        }],
	
		        drilldown: {
							
		            activeDataLabelStyle: {
		                color: '#FFFFFF',
		                textDecoration: 'none',
		                textShadow: '0 0 3px #000000'
		            },
		            drillUpButton: {
		                relativeTo: 'spacingBox',
		                position: {
		                    x: 0, //水平偏移距离
		                    y: 60
		                }
		            }
		        },
		        
		        
		    });
		});

  </script>
	
  </body>
</html>
