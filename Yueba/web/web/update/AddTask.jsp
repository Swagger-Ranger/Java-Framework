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
	<title>添加任务</title>
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
			    <label class="layui-form-label">接受条件</label>
			    <div class="layui-input-block">
			      <select name="city" id="accept" lay-verify="required">
			        <option value=""></option>
			      </select>
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">完成条件</label>
			    <div class="layui-input-block">
			      <select name="city" id="comp" lay-verify="required">
			        <option value=""></option>
			      </select>
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">任务类型</label>
			    <div class="layui-input-block">
			      <select name="city" id="type" lay-verify="required">
			        <option value=""></option>
			        <option value="0">分享任务</option>
			        <option value="1">邀请任务</option>
			        <option value="2">场次任务</option>
			        <option value="3">实名任务</option>
			        <option value="4">每日登陆</option>
			      </select>
			    </div>
			  </div>
			  <div class="layui-form-item">
			    <label class="layui-form-label">奖励</label>
			    <div class="layui-input-block">
			      <input type="checkbox" class="gold" name="gold" value="0" title="金币(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary">
				  <input type="checkbox" class="diamonds" name="diamonds" value="0" title="钻石(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary"> 
				  <input type="checkbox" class="horn" name="horn" value="0" title="喇叭(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary"> 
				  <input type="checkbox" class="egg" name="egg" value="0" title="鸡蛋(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary"> 
				  <input type="checkbox" class="hammer" name="hammer" value="0" title="锤(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary"> 
				  <input type="checkbox" class="integral" name="integral" value="0" title="积分(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary"> 
				  <input type="checkbox" class="sportcar" name="sportcar" value="0" title="跑车(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary"> 
				  <input type="checkbox" class="flower" name="flower" value="0" title="鲜花(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary"> 
			      <input type="checkbox" class="laobanka" name="laobanka" value="0" title="老板卡(0)" lay-filter="reward" lay-verify="required|cbx" lay-skin="primary">
			    </div>
			  </div>
			  <div class="layui-form-item">
			  	<div class="layui-form-item layui-form-text">
				    <label class="layui-form-label">任务描述</label>
				    <div class="layui-input-block">
				      <textarea name="desc" id="describe" placeholder="请输入内容" lay-verify="required" class="layui-textarea"></textarea>
				    </div>
				  </div>
			  </div>
		</div>
		
		<div class="layui-form-item" style="margin-left: 5%;">
		    <div class="layui-input-block">
		    	<button class="layui-btn" lay-submit="" lay-filter="addTask">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/addTask.js"></script>
</body>
</html>