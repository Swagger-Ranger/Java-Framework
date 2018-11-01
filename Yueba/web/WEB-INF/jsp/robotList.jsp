<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.guohaoshiye.yueba.util.Util"%>
<%@ page import="com.guohaoshiye.yueba.entity.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

if(session!=null && session.getAttribute("mapAdmin")!=null){
	Map<String, Admin> mapAdmin = (Map<String, Admin>) session.getAttribute("mapAdmin");
	String ipClients = Util.getIpAddress(request);
	for (Entry<String, Admin> entry : mapAdmin.entrySet()) {
		if(ipClients.equals(entry.getKey())){
			if(entry.getValue()!=null){
				request.setAttribute("aid",entry.getValue().getId());
			}
		}
	}
}else{
	response.sendRedirect(request.getContextPath()+"/login.jsp");
}
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
			<form id="form1" class="layui-form" method="post" action="RobotServlet?op=robotList&comp=${comp }">
				<input  type="hidden" name="currentPage" class="currentPage" value="1" />
				<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
				<input style="width: 20%;display:inline;" type="text" id="uid" name="uid" value="${uid }" lay-verify="required" placeholder="根据id查询" autocomplete="off" class="layui-input">
				<input style="width: 20%;display:inline;" type="text" id="nickname" name="nickname" value="${nickname }" lay-verify="required" placeholder="根据昵称模糊查询" autocomplete="off" class="layui-input">
				<input style="display:inline;" type="submit" value="搜索" class="layui-btn" >
				<c:if test="${compAdd==1 }">
				<input style="display:inline;float: right;" id=add type="button" value="添加机器人" class="layui-btn layui-btn-normal newsAdd_btn" >
				</c:if>
					<div style="width: 30%;display:inline;" class="layui-form-item">
						<div class="layui-input-inline">
							<select name="status">
								<option ${status != '1' and status!= '0' ? 'selected':' '} value="">根据机器人状态查询</option>
								<option ${status == '1' ?'selected':' ' } value="1">正常</option>
								<option ${status == '0' ?'selected':' ' } value="0">禁用</option>
							</select>
						</div>
					</div>
			</form>
		</blockquote>
		<div class="table-container">
	<div class="layui-form news_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="8%">
				<col width="8%">
				<col width="8%">
				<col width="20%">
				<col width="8%">
				<col width="8%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<c:if test="${compUpdate==1 }">
				<col width="10%">
				</c:if>
		    </colgroup>
		    <thead>
				<tr>
					<th>ID</th>
					<th>账号</th>
					<th>昵称</th>
					<th>个人签名</th>
					<th>在线状态</th>
					<th>剩余积分</th>
					<th>总输赢</th>
					<th>账号状态</th>
					<th>创建时间</th>
					<c:if test="${compUpdate==1 }">
					<th>操作</th>
					</c:if>
				</tr>
				<c:if test="${flag==1}">
					<tr>
						<td colspan="7" align="center" style="color: red">无结果！</td>
					</tr>
				</c:if>
				<c:forEach var="pml" items="${pm.list}">
					<tr>
						<td>ID[${pml.id}]</td>
						<td style="word-wrap:break-word;word-break:break-all;">${pml.account}</td>
						<td>${pml.nickname}</td>
						<td>${pml.autograph}</td>
						<c:forEach items="${map}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value==0?'<font style="color: #EE2C2C;">离线</font>':'<font style="color: #B3EE3A;">在线</font>'}</td>
							</c:if>
						</c:forEach>
						<%-- <c:forEach items="${map3}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value==0?'离线':'在线'}</td>
							</c:if>
						</c:forEach> --%>
						<td>${pml.integral}</td>
						<c:forEach items="${map2}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value}</td>
							</c:if>
						</c:forEach>
						<td><input type="hidden" value="${pml.id }"/><input type="checkbox" ${pml.status==1?'checked':''} name="show" lay-skin="switch" lay-text="正常|封禁" lay-filter="isShow"></td>
						<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.createtime}" /></td>
						<c:if test="${compUpdate==1 }">
						<td>
							<a onclick="robotEdit('${pml.id}');" class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 编辑</a>
							<a href="javascript:recharge('${pml.id}');" data-opt="edit" class="layui-btn layui-btn-mini  layui-btn-normal">充值</a>
							<%-- <a href="javascript:recharge('${pml.id}');" data-opt="edit" class="layui-btn layui-btn-mini  layui-btn-normal">充值</a> --%>
							<!-- <a class="layui-btn layui-btn-normal layui-btn-mini news_collect"><i class="layui-icon">&#xe600;</i> 收藏</a> -->
							<!-- <a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="'+data[i].newsId+'"><i class="layui-icon">&#xe640;</i> 删除</a> -->
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
	<script type="text/javascript" src="js/user.js"></script>
	<!-- <script type="text/javascript" src="js/newsList.js"></script> -->
	<script type="text/javascript">
	var currentPage = '${pm.currentPage}';
	var layer;
	layui.use(['form','layer'],function(){
		var form = layui.form();
			layer = parent.layer;
			//修改账号状态
			form.on('switch(isShow)', function(data){
			var status=0;
			if(data.elem.checked){
				status=1;
			}
			var s = $(data.elem);
			var id = s.prev().val().trim();
			var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
				$.post("RobotServlet",{"op":"updateStatus","status":status,"id":id},function(e){
					 setTimeout(function(){
				            layer.close(index);
				            page(currentPage);
							layer.msg("账号状态修改成功！");
				     },2000);
				});
			})
	});
	
	function recharge(rid){
		var aid = '${aid}';
		var sss = layer.prompt({title: '请输入充值金额', formType: 3}, function(money){
			if(money%1==0 && money>0){
				var index = layer.msg('充值中，请稍候',{icon: 16,time:false,shade:0.8});
				$.post("RobotServlet",{"op":"rechargeGold","rid":rid,"aid":aid,"money":money},function(e){
					layer.close(sss);
					 setTimeout(function(){
				            layer.close(index);
				            page(currentPage);
							layer.msg("充值成功！",{icon: 1});
				     },2000);
				 });
			}else{
				layer.msg("请输入正确的数值.", {icon: 2});
			}
		});
	}
	
	
	//添加
	var indexLayer,indexLayer2,obj;
	$(window).one("resize",function(){
		$(".newsAdd_btn").click(function(){
		indexLayer = layui.layer.open({
				title : "添加机器人",
				type : 2,
				area: ['900px', '800px'],
				content : "web/update/robotAdd.jsp",
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
	function robotEdit(id){
		$.ajax({  
	        type: "post",  
	        url: "RobotServlet",          
	        data: {"op":"findById","id":id},  
	        dataType: "json", 
	        async: false,  
        	success: function(e){
	        	obj = e;
	        } 
	    });
		indexLayer2 = layui.layer.open({
			title : "编辑机器人",
			type : 2,
			area: ['900px', '800px'],
			content : "web/update/robotEdit.jsp",
			success : function(layero, index){
				setTimeout(function(){
					layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				},500);
			}
		});			
		layui.layer.full(indexLayer2);
	}
	
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
	</script>
</body>
</html>