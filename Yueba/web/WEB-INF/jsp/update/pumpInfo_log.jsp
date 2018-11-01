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
	<style>
	table
	{
		margin: 0;
		border-collapse: collapse;
	}
	
	td, th
	{
		padding: .5em 1em;
		border: 1px solid #999;
	}
	
	.table-container-outer { position: relative; }
	
	.table-container
	{
		width: 100%;
		overflow-y: auto;
		_overflow: auto;
		margin: 0 0 1em;
	}
	
	.table-container::-webkit-scrollbar
	{
		-webkit-appearance: none;
		width: 14px;
		height: 14px;
	}
	.table-container-fade
	{
		position: absolute;
		right: 0;
		width: 30px;
		height: 100%;
		background-image: -webkit-linear-gradient(0deg, rgba(255,255,255,.5), #fff);
		background-image: -moz-linear-gradient(0deg, rgba(255,255,255,.5), #fff);
		background-image: -ms-linear-gradient(0deg, rgba(255,255,255,.5), #fff);
		background-image: -o-linear-gradient(0deg, rgba(255,255,255,.5), #fff);
		background-image: linear-gradient(0deg, rgba(255,255,255,.5), #fff);
	}
	</style>
</head>
<body class="childrenBody">
		<div class="table-container-outer">
		<div class="table-container">
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="20%">
				<%-- <col width="10%"> --%>
		    </colgroup>
		    <thead>
				<tr>
					<th>玩家ID</th>
					<th>房间号</th>
					<th>房间类型</th>
					<th>游戏类型</th>
					<th>玩家服务费</th>
					<th>平台获得服务费</th>
					<th>一级推广获得服务费</th>
					<th>二级推广获得服务费</th>
					<th>三级推广获得服务费</th>
					<th>创建时间</th>
					<!-- <th>操作</th> -->
				</tr>
			</thead>
			<tbody class="news_content">
				<c:if test="${flag==1}">
					<tr>
						<td colspan="11" align="center" style="color: red">无结果！</td>
					</tr>
				</c:if>
				<c:forEach var="pml" items="${list}">
					<tr>
						<td>${pml.uid}</td>
						<td>${pml.tableid}</td>
						<td>${pml.tabletype==1?'麻将':pml.tabletype==2?'牛牛':pml.tabletype==3?'扯旋':'金花'}</td>
						<td>${pml.gamechang==1?'练习场':pml.gamechang==2?'创建场':'防作弊场'}</td>
						<td>${pml.allpump }</td>
						<td>${pml.pingtaipump }</td>
						<c:if test="${pml.oneproxyid == 0 }">
										<td>无</td>
									</c:if>
									<c:if test="${pml.oneproxyid != 0 }">
										<c:forEach var="p" items="${plist }">
											<c:if test="${p.id==pml.oneproxyid }">
												<td>ID[${pml.oneproxyid }]&nbsp;${p.nickname }(获得:${pml.oneproxypump } 积分)</td>
											</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${pml.twoproxyid == 0 }">
										<td>无</td>
									</c:if>
									<c:if test="${pml.twoproxyid != 0 }">
										<c:forEach var="p" items="${plist }">
											<c:if test="${p.id==pml.twoproxyid }">
												<td>ID[${pml.twoproxyid }]&nbsp;${p.nickname }(获得:${pml.twoproxypump } 积分)</td>
											</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${pml.threeproxyid == 0 }">
										<td>无</td>
									</c:if>
									<c:if test="${pml.threeproxyid != 0 }">
										<c:forEach var="p" items="${plist }">
											<c:if test="${p.id==pml.threeproxyid }">
												<td>ID[${pml.threeproxyid }]&nbsp;${p.nickname }(获得:${pml.threeproxypump } 元宝)</td>
											</c:if>
										</c:forEach>
									</c:if>
						<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.createtime}" /></td>
						<%-- <td>
							<a class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 编辑</a>
							<a href="javascript:recharge('${pml.id}');" data-opt="edit" class="layui-btn layui-btn-mini  layui-btn-normal">充值</a>
							<!-- <a class="layui-btn layui-btn-normal layui-btn-mini news_collect"><i class="layui-icon">&#xe600;</i> 收藏</a> -->
							<!-- <a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="'+data[i].newsId+'"><i class="layui-icon">&#xe640;</i> 删除</a> -->
						</td> --%>
					</tr>
				</c:forEach>
		    
		    </tbody>
		</table>
	</div>
	</div>
	</div>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<!-- <script type="text/javascript" src="js/newsList.js"></script> -->
	<script type="text/javascript">
	var currentPage = '${pm.currentPage}';
	var layer;
	layui.use(['form','layer'],function(){
		var form = layui.form();
			layer = parent.layer;
	});
	
		$(document).ready(function(){
			window.parent.layer.close(window.parent.indexload);
		}); 
	</script>
</body>
</html>