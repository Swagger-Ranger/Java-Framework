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
		<blockquote class="layui-elem-quote news_search">
			<form id="form1" class="layui-form" method="post" action="ProxytoexamineLogServlet?op=listProxytoexamineLog">
					<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
					<input type="hidden" name="currentPage" class="currentPage" value="1" />
					<input type="hidden" name="comp" class="comp" value="${comp }" />
					<input style="width: 10%;display:inline;"  type="text" id="uid" name="uid" value="${uid }" lay-verify="required" placeholder="根据玩家ID查询" autocomplete="off" class="layui-input">
					<input style="width: 10%;display:inline;"  type="text" id="pid" name="pid" value="${pid }" lay-verify="required" placeholder="根据上级ID查询" autocomplete="off" class="layui-input">
					<input style="width: 15%;display:inline;"  type="text" id="phone" name="phone" value="${phone }" lay-verify="required" placeholder="根据手机号查询" autocomplete="off" class="layui-input">
					<input style="width: 15%;display:inline;"  type="text" id="weixinhao" name="weixinhao" value="${weixinhao }" lay-verify="required" placeholder="根据微信号查询" autocomplete="off" class="layui-input">
					<input style="width: 15%;display:inline;"  type="text" id="begin" name="begin" value="${begin }" lay-verify="required" placeholder="通过时间查询(开始时间)" autocomplete="off" class="layui-input">
					<input style="width: 15%;display:inline;"  type="text" id="end" name="end" value="${end }" lay-verify="required" placeholder="通过时间查询(结束时间)" autocomplete="off" class="layui-input">
					<input style="display:inline;" type="submit" value="搜索" class="layui-btn" >
					<input style="display:inline; " id="reset" type="button" value="重置" class="layui-btn layui-btn-normal" >
					<%-- <div style="width: 20%;display:inline;" class="layui-form-item">
						<div class="layui-input-inline">
							<select name="state">
								<option ${state != '1' and state!= '2' ? 'selected':' '} value="">根据审核状态查询</option>
								<option ${state == '1' ?'selected':' ' } value="1">通过</option>
								<option ${state == '2' ?'selected':' ' } value="2">驳回</option>
							</select>
						</div>
					</div> --%>
			</form>
		</blockquote>
		<div class="table-container">
	<div class="layui-form news_list">
	  	<table class="layui-table admin-table">
						 <colgroup>
							<col width="10%">
							<col width="10%">
							<col width="15%">
							<col width="15%">
							<col width="10%">
							<col width="10%">
							<col width="10%">
							<col width="20%">
							<%-- <col width="10%"> --%>
					    </colgroup>
						<thead>
							<tr>
								<th>用户ID</th>
								<th>上级ID</th>
								<th>账号</th>
								<th>手机号</th>
								<th>微信号</th>
								<th>当前钻石</th>
								<th>当前积分</th>
								<th>申请时间</th>
							</tr>
						</thead>
						<tbody id="content">
							<c:if test="${flag==1}">
									<tr>
										<td colspan="11" align="center" style="color: red">无结果！</td>
									</tr>
							</c:if>
							<c:forEach var="pml" items="${pm.list}" varStatus="status">
								<tr>
									<td>${pml.uid }</td>
									<td>${pml.pid }</td>
									<td>${pml.phone }</td>
									<td>${pml.phone }</td>
									<td>${pml.weixinhao }</td>
									<td>${pml.currentDiamonds }</td>
									<td>${pml.currentIntegral }</td>
									<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.creatrtime}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	</div>
	</div>
	</div>
	<%@include file="page.jsp"%>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<!-- <script type="text/javascript" src="js/newsList.js"></script> -->
	<script type="text/javascript">
	var currentPage = '${pm.currentPage}';
	var layer;
	layui.use(['form','layer','laydate'],function(){
		var form = layui.form();
			layer = parent.layer;
			laydate = layui.laydate;
			var start = {
				    max: laydate.now()
				    ,istoday: false
				    ,choose: function(datas){
				    }
				  };
				  
				 /*  var end = {
				    min: laydate.now()
				    ,max: '2099-06-16 23:59:59'
				    ,istoday: false
				    ,choose: function(datas){
				      start.max = datas; //结束日选好后，重置开始日的最大日期
				    }
				  }; */
				  var end = {
						  	max: laydate.now()
						    ,istoday: false
						    ,choose: function(datas){
						    }
						  };
				  document.getElementById('begin').onclick = function(){
				    start.elem = this;
				    laydate(start);
				  }
				  document.getElementById('end').onclick = function(){
				    end.elem = this
				    laydate(end);
				  }
	});
	
	
	
		//分页
		function page(page){
			if(page>1){
				$(".currentPage").val(page);
			}
			window.parent.indexload = layer.load(2);
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
			window.parent.indexload = layer.load(2);
			$("#form1").submit();
		});
		$(document).ready(function(){
			window.parent.layer.close(window.parent.indexload);
		}); 
		$("#reset").click(function(){
			var comp = '${comp }';
			var pageSize = '${pm.pageSize }';
			window.location.href="ProxytoexamineLogServlet?op=listProxytoexamineLog&currentPage=1&pageSize="+pageSize+"&comp="+comp;
		});
	</script>
</body>
</html>