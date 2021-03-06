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
	<title>约把麻将管理后台</title>
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
	<c:if test="${compAdd==1 }">
		<blockquote class="layui-elem-quote news_search">
			<form id="form1" class="layui-form" method="post" action="AcceptServlet?op=acceptList&comp=${comp }">
				<input  type="hidden" name="currentPage" class="currentPage" value="1" />
				<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
			</form>
			<div class="layui-inline">
				<a class="layui-btn audit_btn">添加条件</a>
			</div>
			<!-- <div class="layui-inline">
				<a class="layui-btn recommend" style="background-color:#5FB878">推荐文章</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn audit_btn">审核文章</a>
			</div>
			<div class="layui-inline">
				<a class="layui-btn layui-btn-danger batchDel">批量删除</a>
			</div>
			<div class="layui-inline">
				<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div>
			</div> -->
		</blockquote>
	</c:if>
	<div class="table-container">
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="10%">
				<col width="20%">
				<col width="25%">
				<col width="25%">
				<col width="20%">
		    </colgroup>
		    <thead>
				<tr>
					<th>ID</th>
					<th>接受条件</th>
					<th>其他条件</th>
					<th>描述</th>
					<th>操作</th>
				</tr>
				<c:if test="${flag==1}">
					<tr>
						<td colspan="5" align="center" style="color: red">无结果！</td>
					</tr>
				</c:if>
				<c:forEach var="pml" items="${pm.list}">
					<tr>
						<td>${pml.id}</td>
						<td>${pml.acceptcondition}</td>
						<td>${pml.otherconditions}</td>
						<td>${pml.describe}</td>
						<td>
							<a class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 编辑</a>
							<!-- <a class="layui-btn layui-btn-normal layui-btn-mini news_collect"><i class="layui-icon">&#xe600;</i> 收藏</a> -->
							<a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="'+data[i].newsId+'"><i class="layui-icon">&#xe640;</i> 删除</a>
						</td>
					</tr>
				</c:forEach>
		    </thead>
		    <tbody class="news_content"></tbody>
		</table>
	</div></div></div>
	<%@include file="page.jsp"%>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/newsList.js"></script>
	<script type="text/javascript">
	var layer;
	layui.use(['form','layer'],function(){
		var form = layui.form();
			layer = parent.layer;
	});
	$(document).ready(function(){
		window.parent.layer.close(window.parent.indexload);
	});
		//分页
		function page(page){
			if(page>1){
				$(".currentPage").val(page);
			}
			$("#form1").submit();
		}
		//跳转
		$("#tiaozhuan").click(function(){
			var Pages = $("#Pages").val();
			var sumPage = $("#sumPage").val();
			if(!isNaN(Pages)){
				if(parseInt(Pages) <= parseInt(sumPage)){
					page(Pages);
				}else{
				  layer.msg("输入的数字超过总页数", {icon: 2});
				}
			}else{
				 layer.msg("输入不为数字", {icon: 2});
			}
		});
		$("#pageSize").change(function(){
			var pageSize =  $("#pageSize").val();
			$(".pageSize").val(pageSize);
			$("#form1").submit();
		});
	</script>
</body>
</html>