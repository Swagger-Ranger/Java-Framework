<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.guohaoshiye.yueba.util.Util"%>
<%@ page import="com.guohaoshiye.yueba.entity_olddemo.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session!=null || session.getAttribute("mapAdmin")!=null){
	Map<String, Admin> mapAdmin = (Map<String, Admin>) session.getAttribute("mapAdmin");
	String ipClients = Util.getIpAddress(request);
	for (Entry<String, Admin> entry : mapAdmin.entrySet()) {
		if(ipClients.equals(entry.getKey())){
			if(entry.getValue()!=null){
				request.setAttribute("admin",entry.getValue());
			}
		}
	}
}
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>修改密码</title>
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
	<form class="layui-form changePwd">
		<div class="user_left">
			<div class="layui-form-item">
			    <label class="layui-form-label">账号</label>
			    <div class="layui-input-block">
			    	<input type="text" disabled="disabled" value="${admin.adminname }" lay-verify="required" class="layui-input adminname">
			    </div>
			</div>
			<div class="layui-form-item">
		    <label class="layui-form-label">旧密码</label>
		    <div class="layui-input-block">
		    	<input type="password" value="" placeholder="请输入旧密码" lay-verify="required|oldPwd" class="layui-input pwd">
		    </div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">新密码</label>
		    <div class="layui-input-block">
		    	<input type="password" value="" placeholder="请输入新密码" lay-verify="required|newPwd" id="oldPwd" class="layui-input pwd">
		    </div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">确认密码</label>
		    <div class="layui-input-block">
		    	<input type="password" value="" placeholder="请确认密码" lay-verify="required|confirmPwd" class="layui-input newpwd">
		    </div>
		    <input type="hidden" id="pwdpwd" value="${admin.password }"/>
		</div>
		</div>
		<%-- <div class="user_right">
			<input type="file" name="userFace" class="layui-upload-file" lay-title="掐指一算，我要换一个头像了">
			<p>My Avatar</p>
			<img src="${admin.head }" class="layui-circle" id="userFace">
		</div> --%>
		<div class="layui-form-item">
		    <div class="layui-input-block">
		    	<button class="layui-btn" lay-submit="" lay-filter="changePwd">立即修改</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>
	<script type="text/javascript" src="js/userpwd.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
			window.parent.layer.close(window.parent.indexload);
	}); 
	</script>
	
</body>
</html>