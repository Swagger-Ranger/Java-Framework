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
			<form id="form1" class="layui-form" method="post" action="RechargeServlet?op=rechargeList">
					<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
					<input type="hidden" name="currentPage" class="currentPage" value="1" />
					<input type="hidden" name="comp" class="comp" value="${comp }" />
					<input style="width: 10%;display:inline;"  type="text" id="userId" name="userId" value="${userId }" lay-verify="required" placeholder="根据ID查询" autocomplete="off" class="layui-input">
					<input style="width: 14%;display:inline;"  type="text" id="order" name="order" value="${order }" lay-verify="required" placeholder="根据订单号查询" autocomplete="off" class="layui-input">
					<input style="width: 13%;display:inline;"  type="text" id="gold" name="gold" value="${gold }" lay-verify="required" placeholder="根据充值数量查询" autocomplete="off" class="layui-input">
					<input style="width: 14%;display:inline;"  type="text" id="begin" name="begin" value="${begin }" lay-verify="required" placeholder="通过时间查询(开始时间)" autocomplete="off" class="layui-input">
					<input style="width: 14%;display:inline;"  type="text" id="end" name="end" value="${end }" lay-verify="required" placeholder="通过时间查询(结束时间)" autocomplete="off" class="layui-input">
					<input style="display:inline;" type="submit" value="搜索" class="layui-btn" >
					<input style="display:inline; " id="reset" type="button" value="重置" class="layui-btn layui-btn-normal" >
					<div style="width: 15%;display:inline;" class="layui-form-item">
						<div class="layui-input-inline">
							<select name="status">
								<option ${status != '0' and status!= '1' ? 'selected':' '} value="">根据充值状态查询</option>
								<option ${status == '0' ?'selected':' ' } value="0">未处理</option>
								<option ${status == '1' ?'selected':' ' } value="1">充值成功</option>
							</select>
						</div>
					</div>
			</form>
		</blockquote>
		<div class="table-container">
	<div class="layui-form news_list">
		<table class="layui-table">
		    <thead>
		    	<tr>
					<th>已成功充值总额</th>
					<!-- <th>操作</th> -->
				</tr>
		    </thead>
		    <tbody class="news_content">
		    	<tr>
			    	<td>${sum }</td>
		    	</tr>
		    </tbody>
		</table>
	  	<table class="layui-table">
		    <colgroup>
				<col width="10%">
				<col width="15%">
				<col width="25%">
				<col width="15%">
				<col width="15%">
				<col width="20%">
				<%-- <col width="10%"> --%>
		    </colgroup>
		    <thead>
				<tr>
					<th>用户ID</th>
					<th>用户名</th>
					<th>订单号</th>
					<th>充值数量</th>
					<th>充值状态</th>
					<th>充值时间</th>
				</tr>
			</thead>
			<tbody class="news_content">
				<c:if test="${flag==1}">
					<tr>
						<td colspan="11" align="center" style="color: red">无结果！</td>
					</tr>
				</c:if>
				<c:forEach var="pml" items="${pm.list}" varStatus="status">
								<tr>
									<td>${pml.userId }</td>
									<c:forEach var="u" items="${ulist }">
										<c:if test="${u.id==pml.userId }">
											<td>${u.nickname }</td>
										</c:if>
									</c:forEach>
									<td>${pml.order }</td> 
									<%-- <td>${pml.money }</td>--%>
									<td>${pml.gold }</td>
									<td>${pml.status==0?'未处理':pml.status==1?'充值成功':'' }</td>
									<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.createtime}" /></td>
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
			window.location.href="RechargeServlet?op=rechargeList&currentPage=1&pageSize=10&comp="+comp;
		});
	</script>
</body>
</html>