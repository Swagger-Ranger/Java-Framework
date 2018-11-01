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
			<form id="form1" class="layui-form" method="post" action="GameAlllogServlet?op=listLog">
					<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
					<input type="hidden" name="currentPage" class="currentPage" value="1" />
					<input type="hidden" name="comp" class="comp" value="${comp }" />
					<input style="width: 10%;display:inline;" type="text" id="roomNumber" name="roomNumber" value="${roomNumber }" lay-verify="required" placeholder="根据房间号查询" autocomplete="off" class="layui-input">
					<input style="width: 10%;display:inline;" type="text" id="uid" name="uid" value="${uid }" lay-verify="required" placeholder="根据玩家ID查询" autocomplete="off" class="layui-input">
					<input style="width: 14%;display:inline;"  type="text" id="begin" name="begin" value="${begin }" lay-verify="required" placeholder="通过时间查询(开始时间)" autocomplete="off" class="layui-input">
					<input style="width: 14%;display:inline;"  type="text" id="end" name="end" value="${end }" lay-verify="required" placeholder="通过时间查询(结束时间)" autocomplete="off" class="layui-input">
					<input style="display:inline;" type="submit" value="搜索" class="layui-btn" >
					<input style="display:inline; " id="reset" type="button" value="重置" class="layui-btn layui-btn-normal" >
					<%-- <c:if test="${comp==1 }">
						<input style="display:inline;" id="batchDelete" type="button" value="批量删除" class="layui-btn layui-btn layui-btn-danger" >
					</c:if> --%>
					<div style="width: 30%;display:inline;" class="layui-form-item">
						<div class="layui-input-inline">
							<select name="playtype">
								<option ${playtype != '1' and playtype!= '2' and playtype!= '3' and playtype!= '4' and playtype!= '5' ? 'selected':' '} value="">根据房间类型查询</option>
								<option ${playtype == '1' ?'selected':' ' } value="1">麻将</option>
								<option ${playtype == '2' ?'selected':' ' } value="2">牛牛</option>
								<option ${playtype == '3' ?'selected':' ' } value="3">扯旋</option>
								<option ${playtype == '4' ?'selected':' ' } value="4">金花</option>
								<option ${playtype == '5' ?'selected':' ' } value="5">五子棋</option>
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
				<col width="8%">
				<col width="10%">
				<col width="8%">
				<col width="27%">
				<col width="18%">
				<col width="5%">
				<%-- <col width="10%"> --%>
		    </colgroup>
		    <thead>
				<tr>
					<th>序号</th>
					<th>房间号</th>
					<%--2018-4-12     18:45  开始--%>
					<th>庄</th>
					<%--2018-4-12     18:45  结束--%>
					<th>游戏类型</th>
					<th>房间类型</th>
					<th>玩家ID</th>
					<th>输赢详情</th>
					<th>创建时间</th>
					<th>操作</th>
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
					<td>${pml.roomNumber }</td>
						<%--2018-4-12     18:45  开始--%>
						<c:if test="${pml.bankerid==0 }">
							<td>无庄</td>
						</c:if>
						<c:if test="${pml.bankerid<=10000 && pml.bankerid!=0}">
							<c:forEach var="u" items="${robots}" varStatus="status">
							<c:if test="${u.id==pml.bankerid }">
								<td>ID[${u.id }]&nbsp;${u.nickname }</td>
							</c:if>
							</c:forEach>
						</c:if>
					<c:if test="${pml.bankerid>10000 }">
						<c:forEach var="u" items="${ulist}" varStatus="status">
						<c:if test="${u.id==pml.bankerid}">
							<td>ID[${u.id }]&nbsp;${u.nickname }</td>
						</c:if>
						</c:forEach>
					</c:if>
					<%--2018-4-12     18:45  结束--%>
						<td>${pml.playtype==1?'麻将':pml.playtype==2?'牛牛':pml.playtype==3?'扯旋':pml.playtype==4?'金花':'五子棋'}</td>
						<td>${pml.gamechang==1?'练习场':pml.gamechang==2?'好友场':'匹配场'}</td>
						<td>${pml.alluserid}</td>
						<td>${pml.player}</td>
						<td><fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.creattime}" /></td>

						<td>
							<c:if test="${pml.gamechang ==1 || pml.playtype==5 }">
							<a href="javascript:;" data-opt="edit" class="layui-btn layui-btn-mini  layui-btn-normal layui-btn-disabled">服务费详情</a>
							</c:if>
							<c:if test="${pml.gamechang !=1 && pml.playtype!=5 }">
							<a href="javascript:showServicefee('${pml.roomNumber }','${pml.haomiao }');" data-opt="edit" class="layui-btn layui-btn-mini  layui-btn-normal ${pml.gamechang ==1 ?'layui-btn-disabled':'' }">服务费详情</a>
							</c:if>
						</td>
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

function showServicefee(roomNumber,haomiao){
indexLayer = layui.layer.open({
title : "当局服务费明细",
type : 2,
fixed: false,
area: ['900px', '600px'],
content : "PumpLogServlet?op=showServicefee&roomNumber="+roomNumber+"&haomiao="+haomiao,
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
window.location.href="GameAlllogServlet?op=listLog&currentPage=1&pageSize=10&comp="+comp;
});
</script>
</body>
</html>