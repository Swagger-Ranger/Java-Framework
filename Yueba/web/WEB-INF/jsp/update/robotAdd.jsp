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
	<title>添加机器人</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/user.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form" method="post" action="www.baidu.com">
		<div class="user_left">
			<div class="layui-form-item">
			    <label class="layui-form-label">机器人账号</label>
			    <div class="layui-input-block">
			    	<input type="text" value="" placeholder="请输入机器人账号" lay-verify="required" class="layui-input account">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">机器人昵称</label>
			    <div class="layui-input-block">
			    	<input type="text" value="" placeholder="请输入机器人昵称" lay-verify="required" class="layui-input realName">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">个性签名</label>
			    <div class="layui-input-block">
			    	<textarea placeholder="请输入内容" name="autograph" class="layui-textarea myself"></textarea>
			    </div>
			</div>
		</div>
		<div class="user_right">
			<input type="file" name="userFace" class="layui-upload-file" lay-title="机器人也该拥有自己的头像 哦!">
			<img src="images/face.jpg" class="layui-circle" id="userFace">
		</div>
		<div class="layui-form-item" style="margin-left: 5%;">
		    <div class="layui-input-block">
		    	<button class="layui-btn" lay-submit="" lay-filter="changeUser">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/address.js"></script>
	<script type="text/javascript" src="js/user.js"></script>
</body>
</html>