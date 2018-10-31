<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.aiwan.util.Util"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String ipClients = Util.getIpAddress(request);
request.setAttribute("ipClients", ipClients);
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>约把麻将管理后台</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" type="text/css" href="css/iconfont.css">
	<link rel="stylesheet" type="text/css" href="css/iconfont1.css">
	<link rel="stylesheet" type="text/css" href="css/iconfont2.css">
	<link rel="stylesheet" href="css/main.css" media="all" />
</head>
<body class="childrenBody">
	<div class="panel_box row">
		<div class="panel col">
			<a href="javascript:;">
				<div class="panel_icon">
					<i class="iconfont icon-zaixianyonhu" data-icon="icon-text"></i>
				</div>
				<div class="panel_word newMessage">
					<span id="zxrs"></span>
					<cite>在线人数</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" id="xzwjuser">
				<div class="panel_icon" style="background-color:#FF5722;">
					<i class="iconfont icon-dongtaifensishu" data-icon="icon-dongtaifensishu"></i>
				</div>
				<div class="panel_word userAll">
					<span id="xzwj"></span>
					<cite>新增玩家</cite>
				</div>
			</a>
		</div>
		<%--2018-4-6 18:14开始 by lujun--%>
		<div class="panel col">
			<a href="javascript:;" id="xztgyproxy">
				<div class="panel_icon" style="background-color:#FF5722;">
					<i class="iconfont icon-dongtaifensishu" data-icon="icon-dongtaifensishu"></i>
				</div>
				<div class="panel_word userAll">
					<span id="xztgy"></span>
					<cite>今日新增推广员</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" id="tgyzrsproxy">
				<div class="panel_icon" style="background-color:#009688;">
					<i class="layui-icon" data-icon="&#xe613;">&#xe613;</i>
				</div>
				<div class="panel_word userAll">
					<span id="tgyzrs"></span>
					<cite>推广员总数</cite>
				</div>
			</a>
		</div>
		<%--2018-4-6 18:14结束 by lujun--%>
		<div class="panel col">
			<a href="javascript:;" id="yhzsuser">
				<div class="panel_icon" style="background-color:#009688;">
					<i class="layui-icon" data-icon="&#xe613;">&#xe613;</i>
				</div>
				<div class="panel_word userAll">
					<span id="yhzs"></span>
					<cite>用户总数</cite>
				</div>
			</a>
		</div>
		<div class="panel col">
			<a href="javascript:;" id="jfwjuser">
				<div class="panel_icon" style="background-color:#5FB878;">
					<i class="iconfont icon-yonghufenxisvg" data-icon="icon-text"></i>
				</div>
				<div class="panel_word imgAll">
					<span id="jfwj"></span>
					<cite>积分玩家</cite>
				</div>
			</a>
		</div>
		<c:forEach  items="${mapAdmin}" var="admin">
			<c:if test="${admin.key==ipClients}">
				<c:if test="${admin.value.adminHomeOp2==1 }">
					<div class="panel col max_panel">
						<a href="javascript:;" data-url="web/mail_compose.jsp">
							<cite style="display: none;">发送邮件</cite>
							<div class="panel_icon" style="background-color:#2F4056;">
								<i class="iconfont icon-fasongyoujian" data-icon="icon-text"></i>
							</div>
							<div class="panel_word allNews">
								<br />
								<em>发送邮件</em>
							</div>
						</a>
					</div>
				</c:if>
			</c:if>
		</c:forEach>
		<div class="panel col">
			<a href="javascript:sendPlacard();">
				<div class="panel_icon" style="background-color:#F7B824;">
					<i class="iconfont icon-labagonggaoxiaoxi" data-icon="icon-text"></i>
				</div>
				<div class="panel_word waitNews">
					<br />
					<cite>发送及时公告</cite>
				</div>
			</a>
		</div>
	</div>
	<c:forEach  items="${mapAdmin}" var="admin">
			<c:if test="${admin.key==ipClients}">
				<c:if test="${admin.value.adminHomeOp1==1 }">
					<blockquote class="layui-elem-quote explain" style="padding: 0px;">
							<form class="layui-form">
							<div class="layui-form-item">
							    <label class="layui-form-label">服务器状态</label>
							    <div class="layui-input-block">
							      <input type="checkbox" checked="checked" name="zzz" id="status" lay-filter="test2" lay-skin="switch" lay-text="开启|关闭">
							      	<!--fix      2018-4-20      begin-->
								      <a href="javascript:cleanup();" style="float: right;" class="layui-btn layui-btn-radius layui-btn-primary">清理房间</a>
								 <!--fix      2018-4-20      end-->
							    </div>
							  </div>
							</form>
					</blockquote>
				</c:if>
			</c:if>
	</c:forEach>
	<div class="row">
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">总游戏场次</blockquote>
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<td>麻将</td>
						<td class="version1"></td>
					</tr>
					<tr>
						<td>牛牛</td>
						<td class="author1"></td>
					</tr>
					<tr>
						<td>扯旋</td>
						<td class="homePage1"></td>
					</tr>
					<tr>
						<td>金花</td>
						<td class="server1"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="sysNotice col">
			<blockquote class="layui-elem-quote title">今日游戏场次</blockquote>
			<table class="layui-table">
				<colgroup>
					<col width="150">
					<col>
				</colgroup>
				<tbody>
					<tr>
						<td>麻将</td>
						<td class="version2"></td>
					</tr>
					<tr>
						<td>牛牛</td>
						<td class="author2"></td>
					</tr>
					<tr>
						<td>扯旋</td>
						<td class="homePage2"></td>
					</tr>
					<tr>
						<td>金花</td>
						<td class="server2"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="width: 100%; margin-top: 10px;" class="sysNotice col">
			<blockquote class="layui-elem-quote title">发送(公告/邮件)记录<a href="javascript:log();" style="float: right; color: #009688; cursor:pointer;">更多>></a></blockquote>
			<table class="layui-table">
				<colgroup>
					<col width="20%">
					<col width="20%">
					<col width="40%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th>管理员ID</th>
						<th>发送类型</th>
						<th>发送内容</th>
						<th>发送时间</th>
					</tr>
				</thead>
				<tbody id="tabHtml">
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript">
		var layer;
		layui.use(['form','layer'],function(){
			var form = layui.form();
				layer = layui.layer;
		});
		<!--fix      2018-4-20      begin-->
		function cleanup(){
			layer.prompt({title: '请输入需要清理的房间号', formType: 3}, function(text, index){
				var re = /^[0-9]*[1-9][0-9]*$/;
				if(re.test(text)){
					 $.post("ParameterSrevlet",{"op":"cleanupRoom","rid":text},function(e){
						 if(e=="ok"){
							 layer.msg('房间清理成功',{icon: 1});
							 layer.close(index);
						 }else{
							 layer.msg('未找到该房间',{icon: 2});
							 layer.close(index);
						 }
							 
					  });
				}else{
					layer.msg('请输入正确的房间号',{icon: 2});
				}
				 /*  if(text.length>5){
					  layer.confirm('是否确定发送？', {
						  btn: ['是','否'] //按钮
						}, function(){
						  layer.close(index);
						  var index2 = layer.load(1);
						  $.post("UsersServlet",{"op":"sendPlacard","msg":text},function(){
							  layer.msg('公告发送成功',{icon: 1});
							  layer.close(index2);
						  });
						}, function(){
						});
				  }else{
					  layer.msg('公告最少为5位字符',{icon: 2});
				  } */
			  });
		}
		<!--fix      2018-4-20      begin-->
		function log(){
			indexLayer = layui.layer.open({
				title : "发送(公告/邮件)记录",
				type : 2,
				fixed: false,
				area: ['900px', '600px'],
				content : "SystemLogServlet?op=loglist&pageSize=10&currentPage=1",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500);
				}
			});			
			layui.layer.full(indexLayer); 
		}
		
		
		function sendPlacard(){
			/* console.log("1"); */
		  layer.prompt({title: '请输入发送内容', formType: 2}, function(text, index){
			  if(text.length>5){
				  layer.confirm('是否确定发送？', {
					  btn: ['是','否'] //按钮
					}, function(){
					  layer.close(index);
					  var index2 = layer.load(1);
					  $.post("UsersServlet",{"op":"sendPlacard","msg":text},function(){
						  layer.msg('公告发送成功',{icon: 1});
						  layer.close(index2);
					  });
					}, function(){
					});
			  }else{
				  layer.msg('公告最少为5位字符',{icon: 2});
			  }
		  });
		}
		$(document).ready(function(){
			window.parent.layer.close(window.parent.indexload);
		});
	</script>
</body>
</html>