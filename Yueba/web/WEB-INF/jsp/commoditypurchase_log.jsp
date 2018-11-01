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
			<form id="form1" class="layui-form" method="post" action="CommoditypurchaseLogServlet?op=commoditypurchaseLog">
					<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
					<input type="hidden" name="currentPage" class="currentPage" value="1" />
					<input type="hidden" name="comp" class="comp" value="${comp }" />
					<input style="width: 10%;display:inline;" type="text" id="PurchaseUserid" name="PurchaseUserid" value="${PurchaseUserid }" lay-verify="required" placeholder="玩家ID查询" autocomplete="off" class="layui-input">
					<%-- <input style="width: 15%;display:inline;" type="text" id="CommodityName" name="CommodityName" value="${CommodityName }" lay-verify="required" placeholder="根据商品名称查询" autocomplete="off" class="layui-input"> --%>
					<input style="width: 15%;display:inline;"  type="text" id="begin" name="begin" value="${begin }" lay-verify="required" placeholder="通过时间查询(开始时间)" autocomplete="off" class="layui-input">
					<input style="width: 15%;display:inline;"  type="text" id="end" name="end" value="${end }" lay-verify="required" placeholder="通过时间查询(结束时间)" autocomplete="off" class="layui-input">
					<input style="display:inline;" type="submit" value="搜索" class="layui-btn" >
					<input style="display:inline; " id="reset" type="button" value="重置" class="layui-btn layui-btn-normal" >
					<div style="width: 20%;display:inline;" class="layui-form-item">
						<div class="layui-input-inline">
							<select name="CommodityName">
								<option ${CommodityName != 'flower' and CommodityName!= 'sportcar' and CommodityName!= 'egg' and CommodityName!= 'hammer' and CommodityName!= 'horn' ? 'CommodityName':' '} value="">选择商品查询</option>
								<option ${CommodityName == 'flower' ?'selected':' ' } value="flower">鲜花</option>
								<option ${CommodityName == 'sportcar' ?'selected':' ' } value="sportcar">跑车</option>
								<option ${CommodityName == 'egg' ?'selected':' ' } value="egg">鸡蛋</option>
								<option ${CommodityName == 'hammer' ?'selected':' ' } value="hammer">锤子</option>
								<option ${CommodityName == 'horn' ?'selected':' ' } value="horn">喇叭</option>
							</select>
						</div>
					</div>	
					<%-- <c:if test="${comp==1 }">
						<input style="display:inline;" id="batchDelete" type="button" value="批量删除" class="layui-btn layui-btn layui-btn-danger" >
					</c:if> --%>
					<%-- <div style="width: 30%;display:inline;" class="layui-form-item">
						<div class="layui-input-inline">
							<select name="playtype">
								<option ${playtype != '1' and playtype!= '2' and playtype!= '3' and playtype!= '4' ? 'selected':' '} value="">根据房间类型查询</option>
								<option ${playtype == '1' ?'selected':' ' } value="1">麻将</option>
								<option ${playtype == '2' ?'selected':' ' } value="2">牛牛</option>
								<option ${playtype == '3' ?'selected':' ' } value="3">扯旋</option>
								<option ${playtype == '4' ?'selected':' ' } value="4">金花</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="gamechang">
								<option ${gamechang != '1' and gamechang!= '2' and gamechang!= '3' ? 'selected':' '} value="">根据游戏类型查询</option>
								<option ${gamechang == '1' ?'selected':' ' } value="1">练习场</option>
								<option ${gamechang == '2' ?'selected':' ' } value="2">好友场</option>
								<option ${gamechang == '3' ?'selected':' ' } value="3">匹配场</option>
							</select>
						</div>
					</div>	 --%>
			</form>
		</blockquote>
		<div class="table-container">
	<div class="layui-form news_list">
		<table class="layui-table">
			<colgroup>
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
		    </colgroup>
		    <thead>
		    	<tr>
					<th colspan="5">商品售出总额:${sum }</th>
					<!-- <th>操作</th> -->
				</tr>
		    </thead>
		    <thead>
		    	<tr>
					<th>鲜花售出总数量</th>
					<th>跑车售出总数量</th>
					<th>鸡蛋售出总数量</th>
					<th>锤子售出总数量</th>
					<th>喇叭售出总数量</th>
					<!-- <th>操作</th> -->
				</tr>
		    </thead>
		    <tbody class="news_content">
		    	<tr>
			    	<td>${xhsum }</td>
			    	<td>${pcsum }</td>
			    	<td>${jdsum }</td>
			    	<td>${czsum }</td>
			    	<td>${lbsum }</td>
		    	</tr>
		    </tbody>
		</table>
	  	<table class="layui-table">
		    <colgroup>
				<col width="10%">
				<col width="20%">
				<col width="10%">
				<col width="15%">
				<col width="15%">
				<col width="30%">
				<%-- <col width="10%"> --%>
		    </colgroup>
		    <thead>
				<tr>
					<th>ID</th>
					<th>用户ID</th>
					<th>商品名称</th>
					<th>商品个数</th>
					<th>商品总价</th>
					<th>购买时间</th>
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
									<td>${pml.id }</td>
									<td>${pml.purchaseUserid }</td>
									<td>${pml.commodityName eq 'flower' ?'鲜花':pml.commodityName eq 'sportcar' ?'跑车':pml.commodityName eq 'egg' ?'鸡蛋':pml.commodityName eq 'hammer' ?'锤子':'喇叭' }</td>
									<td>${pml.commodityNumber }</td>
									<td>${pml.commodityTotalPrice }</td>
									<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.createTime }" /></td>
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
			window.location.href="CommoditypurchaseLogServlet?op=commoditypurchaseLog&currentPage=1&pageSize=10&comp="+comp;
		});
	</script>
</body>
</html>