<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>所有下级代理</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	 <!--图标样式-->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>

    <!--主要样式-->
    <link rel="stylesheet" type="text/css" href="css/style.css"/>

    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
    $(function () {
    	var json = jQuery.parseJSON(window.parent.obj);
        function tree(data) {
            for (var i = 0; i < data.length; i++) {
                var data2 = data[i];
                if (data[i].icon == "icon-th") {
                    $("#rootUL").append("<li data-name='" + data[i].code + "'><span><i class='" + data[i].icon + "'></i> " + data[i].name + "</span></li>");
                } else {
                    var children = $("li[data-name='" + data[i].parentCode + "']").children("ul");
                    if (children.length == 0) {
                        $("li[data-name='" + data[i].parentCode + "']").append("<ul></ul>")
                    }
                    $("li[data-name='" + data[i].parentCode + "'] > ul").append(
                        "<li data-name='" + data[i].code + "'>" +
                        "<span>" +
                        "<i class='" + data[i].icon + "'></i> " +
                        data[i].name +
                        "</span>" +
                        "</li>")
                }
                for (var j = 0; j < data[i].child.length; j++) {
                    var child = data[i].child[j];
                    var children = $("li[data-name='" + child.parentCode + "']").children("ul");
                    if (children.length == 0) {
                        $("li[data-name='" + child.parentCode + "']").append("<ul></ul>")
                    }
                    $("li[data-name='" + child.parentCode + "'] > ul").append(
                        "<li data-name='" + child.code + "'>" +
                        "<span>" +
                        "<i class='" + child.icon + "'></i> " +
                        child.name +
                        "</span>" +
                        "</li>")
                    var child2 = data[i].child[j].child;
                    tree(child2)
                }
                tree(data[i]);
            }

        }
        tree(json);
    });
    </script>

    <script type="text/javascript">
        $(function () {
            $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', '关闭');
            $('.tree li.parent_li > span').on('click', function (e) {
                var children = $(this).parent('li.parent_li').find(' > ul > li');
                if (children.is(":visible")) {
                    children.hide('fast');
                    $(this).attr('title', '展开').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
                } else {
                    children.show('fast');
                    $(this).attr('title', '关闭').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
                }
                e.stopPropagation();
            });
        });
    </script>


</head>
<body>

<div class="tree well">

    <ul id="rootUL">

    </ul>
</div>
</body>
</html> --%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>天天小茶馆管理后台</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="css/news.css" media="all" />
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote layui-quote-nm">
  	游戏服务费总计:<span id="fwfzj"></span>
  	<span style="float: right;" id="sjtgt"></span>
</blockquote>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script>
		layui.use(['element', 'layer'], function(){
		  var element = layui.element();
		  var layer = layui.layer;
		  
		  //监听折叠
		  element.on('collapse(test)', function(data){
		    layer.msg('展开状态：'+ data.show);
		  });
		});
		</script>
		<script type="text/javascript">
			var obj;
			 $(function(){
				var json = window.parent.obj.jsonArray;
				 $("#fwfzj").html(window.parent.obj.totalRevenue);
				var pid=window.parent.pid;
				$.ajax({  
			        type: "post",  
			        url: "ProxyServlet",          
			        data: {"op":"showByIdInfo","pid":pid},
			        dataType: "json",
			        async: false,  
		        success: function(e){
			        	obj = e;
			        	if(e.flg==0){
							$("#sjtgt").html("上级推广员:&nbsp;&nbsp;无");
						}else{
							$.get("json/navs.json",function(d){
								/* alert(d[1].children[2].children[0].title) */
								$("#sjtgt").html("<a href='javascript:showProxy("+e.proxy.id+");' style='cursor:pointer;text-decoration:underline;'>上级推广员:&nbsp;&nbsp;"+e.proxy.nickname+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID:"+e.proxy.id+"</a>");
							});
						}
			        } 
			    });
				
				
				for (var i = 0; i < json.length; i++) {
					if(json[i].id==pid){
						$(".childrenBody").append("<div id='collapse"+json[i].id+"' class='layui-collapse' lay-accordion=''></div>");
						$("#collapse"+json[i].id).append("<div id='colla"+json[i].id+"' class='layui-colla-item'></div>");
						$("#colla"+json[i].id).append("<h2 class='layui-colla-title'><a style='cursor:pointer;text-decoration:underline;'>"+json[i].nickname+"</a><span style='float: right;'>推广员ID:【"+json[i].id+"】</span><hr class='layui-colla-hr'/></h2>");
						$("#colla"+json[i].id).append("<div id='content"+json[i].id+"' class='layui-colla-content'></div>");
						$("#content"+json[i].id).append("<div id='accordion"+json[i].id+"' class='layui-collapse' lay-accordion=''></div>");
						$("#accordion"+json[i].id).append("<div id='proxy"+json[i].id+"' class='layui-colla-item'></div>");
						$("#accordion"+json[i].id).append("<div id='users"+json[i].id+"' class='layui-colla-item'></div>");
						$("#proxy"+json[i].id).append("<h2 class='layui-colla-title'>直属推广员<hr class='layui-colla-hr'/></h2>");
						$("#users"+json[i].id).append("<h2 class='layui-colla-title'>直属玩家<hr class='layui-colla-hr'/></h2>");
						if(json[i].users!="" || json[i].users!=null){
							for (var j = 0; j < json[i].users.length; j++) {
								$("#users"+json[i].id).append("<div id='ucontent"+json[i].id+"' class='layui-colla-content'><a href='javascript:showUsers("+json[i].users[j].id+");' style='cursor:pointer;text-decoration:underline;'>"+json[i].users[j].nickname+"</a><span style='float: right;'>玩家ID:【"+json[i].users[j].id+"】</span></div>");
							}
						}
						findChildren(json[i].id,json);
					}
				}
			});
		 function findChildren(FatherID,json){
			 for (var i = 0; i < json.length; i++) {
				 if(FatherID==json[i].pid){
					 if($("#collapse"+json[i].id).length==0){
						 	$("#proxy"+FatherID).append("<div id='pcontent"+json[i].id+"' class='layui-colla-content'></div>");
						 	$("#pcontent"+json[i].id).append("<div id='collapse"+json[i].id+"' class='layui-collapse' lay-accordion=''></div>");
							$("#collapse"+json[i].id).append("<div id='colla"+json[i].id+"' class='layui-colla-item'></div>");
							$("#colla"+json[i].id).append("<h2 class='layui-colla-title'>"+json[i].nickname+"<span style='float: right;'>推广员ID:【"+json[i].id+"】</span><hr class='layui-colla-hr'/></h2>");
							$("#colla"+json[i].id).append("<div id='content"+json[i].id+"' class='layui-colla-content'></div>");
							$("#content"+json[i].id).append("<div id='accordion"+json[i].id+"' class='layui-collapse' lay-accordion=''></div>");
							$("#accordion"+json[i].id).append("<div id='proxy"+json[i].id+"' class='layui-colla-item'></div>");
							$("#accordion"+json[i].id).append("<div id='users"+json[i].id+"' class='layui-colla-item'></div>");
							$("#proxy"+json[i].id).append("<h2 class='layui-colla-title'>直属推广员<hr class='layui-colla-hr'/></h2>");
							$("#users"+json[i].id).append("<h2 class='layui-colla-title'>直属玩家<hr class='layui-colla-hr'/></h2>");
							if(json[i].users!="" && json[i].users!=null){
								for (var j = 0; j < json[i].users.length; j++) {
									$("#users"+json[i].id).append("<div id='ucontent"+json[i].id+"' class='layui-colla-content'><a style='cursor:pointer;text-decoration:underline;'>"+json[i].users[j].nickname+"</a><span style='float: right;'>玩家ID:【"+json[i].users[j].id+"】</span></div>");
								}
							}
							findChildren(json[i].id, json);
					 }
				 }
			 }
		 }
		 
		 function showProxy(pid){
			 $.get("json/navs.json",function(d){
				 indexLayer = layui.layer.open({
						title : "上级推广员信息",
						type : 2,
						fixed: false,
						area: ['900px', '600px'],
						content : d[1].children[2].children[0].href+"&type=1&pid="+pid,
						success : function(layero, index){
							setTimeout(function(){
								layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
									tips: 3
								});
							},500);
						}
					});			
					layui.layer.full(indexLayer);
			  });
		 }
		 function showUsers(uid){
			 $.get("json/navs.json",function(d){
				 indexLayer = layui.layer.open({
						title : "该用户详情",
						type : 2,
						fixed: false,
						area: ['900px', '600px'],
						content : d[1].children[1].children[0].href+"&show=1&uid="+uid,
						success : function(layero, index){
							setTimeout(function(){
								layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
									tips: 3
								});
							},500);
						}
					});			
					layui.layer.full(indexLayer);
			  });
		 }
		</script>
</body>
</html>