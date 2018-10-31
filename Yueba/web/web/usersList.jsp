<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.aiwan.util.Util"%>
<%@ page import="com.aiwan.entity.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Map<String, Admin> mapAdmin = (Map<String, Admin>) session.getAttribute("mapAdmin");
String ipClients = Util.getIpAddress(request);
for (Entry<String, Admin> entry : mapAdmin.entrySet()) {
	if(ipClients.equals(entry.getKey())){
		request.setAttribute("admin",entry.getValue());
	}
}
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
	<link rel="stylesheet" href="css/public.css" media="all" />
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
		<c:if test="${show!=1 }">
		<blockquote class="layui-elem-quote news_search">
			<form id="form1" class="layui-form" method="post" action="UsersServlet?op=userslist&comp=${comp }">
				<input  type="hidden" name="currentPage" class="currentPage" value="1" />
				<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
				<input style="width: 10%;display:inline;" type="text" id="uid" name="uid" value="${uid }" placeholder="根据id查询" autocomplete="off" class="layui-input">
					<input style="width: 10%;display:inline;" type="text" id="nickname" name="pid" value="${pid }" placeholder="根据上级ID查询" autocomplete="off" class="layui-input">
					<input style="width: 20%;display:inline;" type="text" id="nickname" name="nickname" value="${nickname }" placeholder="根据昵称模糊查询" autocomplete="off" class="layui-input">
					<input style="width: 20%;display:inline;" type="text" id="nickname" name="realName" value="${realName }" placeholder="根据真实姓名查询" autocomplete="off" class="layui-input">
					<input style="display:inline;" type="submit" value="搜索" class="layui-btn" >
					<div style="width: 25%;display:inline;" class="layui-form-item">
						<div class="layui-input-inline">
							<select name="status">
								<option ${status != '1' and status!= '0' ? 'selected':' '} value="">根据玩家状态查询</option>
								<option ${status == '1' ?'selected':' ' } value="1">正常用户</option>
								<option ${status == '0' ?'selected':' ' } value="0">封禁用户</option>
							</select>
						</div>
					</div>
			</form>
		</blockquote>
		</c:if>
		<div class="table-container">
		<c:if test="${show != 1}">
		<table class="layui-table">
			<colgroup>
				<col width="16.6%">
				<col width="16.6%">
				<col width="16.6%">
				<col width="16.6%">
				<col width="16.6%">
				<col width="16.6%">
				<col width="16.6%">
				<col width="16.6%">
		    </colgroup>
		    <thead>
		    	<tr>
					<th colspan="5">正常玩家所持有(总计)</th>
					<th colspan="3">冻结玩家所持有(总计)</th>
					<!-- <th>操作</th> -->
				</tr>
		    </thead>
		    <thead>
		    	<tr>
					<%--<th>钻石</th>--%>
					<th>赠送</th>
					<th>积分</th>
					<th>仓库</th>
					<th>推广员</th>
					<th>金币</th>
					<th>钻石</th>
					<th>积分</th>
					<th>金币</th>
					<!-- <th>操作</th> -->
				</tr>
		    </thead>
		    <tbody class="news_content">
		    	<tr>
			    	<%--<td>${zuanshit }</td>--%>
					<td>${giveSum}</td>
			    	<td>${trueUserIntegral }</td>
					<td>${warehouseIntegralUserIntegral }</td>
					<td>${trueProxyIntegral }</td>
			    	<td>${jinbit }</td>
			    	<td>${zuanshif }</td>
			    	<td>${falseUserIntegral }</td>
			    	<td>${jinbif }</td>
		    	</tr>
		    </tbody>
		</table>
		</c:if>
	  	<table class="layui-table layui-form">
		    <colgroup>
				<col width="4%">
				<col width="4%">
				<col width="7%">
				<col width="5%">
				<col width="9%">
				<col width="4%">
				<col width="4%">
				<col width="7%">
				<col width="4%">
				<col width="4%">
				<col width="4%">
				<col width="5%">
				<col width="5%">
				<%-- <col width="6%"> --%>
				<col width="12%">
				<col width="12%">
				<col width="8%">
				<col width="6%">
		    </colgroup>
		    <thead>
				<tr>
					<th>ID</th>
					<th>上级ID</th>
					<th>昵称</th>
					<th>真实姓名</th>
					<th>个性签名</th>
					<th>积分仓库</th>
					<th>钻石仓库</th>
					<th>胜利次数</th>
					<th>金币</th>
					<th>钻石</th>
					<th>积分</th>
					<th>在线时长</th>
					<th>登录次数</th>
					<!-- <th>在线状态</th> -->
					<th>账号创建时间</th>
					<th>最后登录时间</th>
					<c:if test="${compUpdate==1 }">
						<th>账号状态</th>
					</c:if>
					<c:if test="${compUpdate==1 or compRecharge==1 }">
					<th>操作</th>
					</c:if>
				</tr>
			</thead>
			<tbody class="news_content">
				<c:if test="${flag==1}">
					<tr>
						<td colspan="16" align="center" style="color: red">无结果！</td>
					</tr>
				</c:if>
				<c:forEach var="pml" items="${pm.list}">
					<tr>
						<td>${pml.id}</td>
						<td>${pml.pid==0?'无':pml.pid==null?'无':pml.pid}</td>
						<td>${pml.nickname}</td>
						<td>${pml.realName}</td>
						<td><div title="${pml.autograph}" id="xtzf" class="test" style="word-break:break-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;max-width: 100px;">${pml.autograph}</div></td>
						<td>${pml.warehouseIntegral}</td>
						<td>${pml.warehouseDiamonds}</td>
						<td>${pml.victorycount}</td>
						<td>${pml.gold}</td>
						<td>${pml.diamonds}</td>
						<td>${pml.integral}</td>
						<c:forEach items="${map}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value}h</td>
							</c:if>
						</c:forEach>
						<c:forEach items="${map2}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value}次</td>
							</c:if>
						</c:forEach>
						<%-- <c:forEach items="${map3}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value==0?'离线':'在线'}</td>
							</c:if>
						</c:forEach> --%>
						<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.createtime}" /></td>
						<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.logintime}" /></td>
						<c:if test="${compUpdate==1}">
						<td><input type="hidden" value="${pml.id }"/><input type="checkbox" ${pml.status==1?'checked':''} name="show" lay-skin="switch" lay-text="正常|封禁" lay-filter="isShow"></td>
						</c:if>
						<c:if test="${compUpdate==1 }">
						<td>
							<%-- <a class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 编辑</a>--%>
							<%--2018-4-25 13:59      zhanglei          把之前注释的充值功能显示出来      begin--%>
							<c:if test="${compRecharge==1}">
								<a href="javascript:recharge('${pml.id}','${pml.gold}','${pml.diamonds}','${pml.integral}');" data-opt="edit" class="layui-btn layui-btn-mini  layui-btn-normal">充值</a>
							</c:if>
							<%--2018-4-25 13:59      zhanglei          把之前注释的充值功能显示出来      end--%>
							<c:if test="${compUpdate==1}">
							<a href="javascript:separate('${pml.id}');" data-name="${pml.id}" data-opt="edit" class="layui-btn layui-btn-danger layui-btn-mini">脱离</a>
							</c:if>
							<!-- <a class="layui-btn layui-btn-normal layui-btn-mini news_collect"><i class="layui-icon">&#xe600;</i> 收藏</a> -->
							<!-- <a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="'+data[i].newsId+'"><i class="layui-icon">&#xe640;</i> 删除</a> -->
						</td>
						</c:if>
					</tr>
				</c:forEach>
		    </tbody>
		</table>
		</div></div>
		<c:if test="${show!=1 }">
	<%@include file="page.jsp"%>
	</c:if>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
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
				$.post("UsersServlet",{"op":"updateStatus","status":status,"id":id},function(e){
					 setTimeout(function(){
				            layer.close(index);
				            page(currentPage);
							layer.msg("账号状态修改成功！");
				     },2000);
				});
			})
	});
	
	function separate(id){
		layer.confirm("是否确定解除该玩家与上级的关系?<br/><br/><span style='color: #FF3030;'>提示:解除之后,该用户将没有直属关系。</span>", {
		    btn: ['是','否'] //按钮
		  }, function(){
			  var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
			  $.post("UsersServlet",{"op":"updateUserSeparate","id":id},function(e){
				  layer.msg("更改成功", {icon: 1});
				  setTimeout("page("+currentPage+")",2000);  
			  });
		 });
	}
	
	
	//充值
	var con;
	function recharge(uid,gold,diamonds,integral){
		var id = '${admin.id}';
		var type = 0;
		con=layer.confirm('请选择充值类型？', {
			  title:'充值',
			  btn: ['积分','钻石','金币'], //按钮
		 	btn3:function(){
				//选择金币
				type = 1;
				rechargeGold(id,uid,type,gold);
			}
			}, function(){
				//选择积分
				type = 3;
				rechargeGold(id,uid,type,integral);
			}, function(){
				//选择钻石
				type = 2;
				rechargeGold(id,uid,type,diamonds);
			});
			
	}
	function rechargeGold(id,uid,type,num){
		layer.close(con);
		layer.prompt({title: '请输入充值金额', formType: 3}, function(money){
			if(money%1==0){
				var count = 100000000-(parseInt(num)+parseInt(money));
				 if(type==1 && count<0){
					layer.msg("充值失败,玩家金币上限为 1 亿.",{icon: 2});
					return ;
				}
				if(type==2 && count<0){
					layer.msg("充值失败,玩家钻石上限为 1 亿.",{icon: 2});
					return ;
				}
				if(type==3 && count<0){
					layer.msg("充值失败,玩家积分上限为 1 亿.",{icon: 2});
					return ;
				} 
				var index = layer.msg('充值中，请稍候',{icon: 16,time:false,shade:0.8});
				$.post("UsersServlet",{"op":"rechargeGold","id":id,"uid":uid,"money":money,"type":type},function(e){
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