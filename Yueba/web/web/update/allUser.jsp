<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</html>