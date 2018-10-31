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
			<form id="form1" class="layui-form" method="post" action="TaskServlet?op=taskList&comp=${comp }">
				<input  type="hidden" name="currentPage" class="currentPage" value="1" />
				<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
			</form>
			<div class="layui-inline">
				<a class="layui-btn audit_btn">添加任务</a>
			</div>
		</blockquote>
	</c:if>
	<div class="table-container">
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="10%">
				<col width="20%">
				<col width="40%">
				<col width="10%">
				<c:if test="${compUpdate==1 }">
				<col width="20%">
				</c:if>
		    </colgroup>
		    <thead>
				<tr>
					<th>ID</th>
					<th>任务类型</th>
					<th>任务描述</th>
					<th>任务状态</th>
					<c:if test="${compUpdate==1 }">
					<th>操作</th>
					</c:if>
				</tr>
				<c:if test="${flag==1}">
					<tr>
						<td colspan="5" align="center" style="color: red">无结果！</td>
					</tr>
				</c:if>
				<c:forEach var="pml" items="${pm.list}">
					<tr>
						<td>${pml.id}</td>
						<td>${pml.type==0?'分享任务':pml.type==1?'邀请任务':pml.type==2?'场次任务':pml.type==3?'实名任务':pml.type==4?'每日登陆':''}</td>
						<td>${pml.describe}</td>
						<td><input type="hidden" value="${pml.id }"/><input type="checkbox" ${pml.state==1?'checked':''} name="show" lay-skin="switch" lay-text="开启|关闭" lay-filter="isShow"></td>
						<c:if test="${compUpdate==1}">
							<td>
								<a onclick="updateById(${pml.id});" class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 编辑</a>
							</td>
						</c:if>
					</tr>
				</c:forEach>
		    </thead>
		    <tbody class="news_content"></tbody>
		</table>
	</div>
	</div>
	</div>
	<%@include file="page.jsp"%>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/newsList.js"></script>
	<script type="text/javascript">
	var layer;
	layui.use(['form','layer'],function(){
		var form = layui.form();
			layer = parent.layer;
			
			//修改任务状态
			form.on('switch(isShow)', function(data){
			var status=0;
			if(data.elem.checked){
				status=1;
			}
			var s = $(data.elem);
			var id = s.prev().val().trim();
			var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
				$.post("TaskServlet",{"op":"updateStatus","status":status,"id":id},function(e){
					 setTimeout(function(){
				            layer.close(index);
				            page(cpage);
							layer.msg("任务状态修改成功！");
				     },2000);
				});
			});
	});
	$(document).ready(function(){
		window.parent.layer.close(window.parent.indexload);
	});
	var cpage = '${pm.currentPage}';
	var obj;
	function updateById(id){
		$.ajax({  
	        type: "post",  
	        url: "TaskServlet",          
	        data: {"op":"findById","id":id},  
	        dataType: "json", 
	        async: false,  
        success: function(e){
	        	obj = e;
	        } 
	    });
		$(window).one("resize",function(){
			indexLayer = layui.layer.open({
				title : "修改任务",
				type : 2,
				area: ['900px', '800px'],
				content : "web/update/UpdateTask.jsp",
				success : function(layero, index){
					setTimeout(function(){
						layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					},500);
				}
			});			
			layui.layer.full(indexLayer);
		}).resize();
	}
	
	$(window).one("resize",function(){
		$(".audit_btn").click(function(){
		indexLayer = layui.layer.open({
				title : "添加任务",
				type : 2,
				area: ['900px', '800px'],
				content : "web/update/AddTask.jsp",
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
	}).resize();
	
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