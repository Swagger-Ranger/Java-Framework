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
	<title>广告封面</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/images.css" media="all" />
</head>
<body class="childrenBody">
	<form class="layui-form">
		<c:if test="${compAdd==1 }">
		<blockquote class="layui-elem-quote news_search">
			<!-- <div class="layui-inline">
				<input type="checkbox" name="selectAll" id="selectAll" lay-filter="selectAll" lay-skin="primary" title="全选">
			</div> -->
			<div id="test1" class="layui-inline">
				<a class="layui-btn layui-btn-normal newsAdd_btn">添加新封面</a>
			</div>
			<div class="layui-inline">
				<div class="layui-form-mid layui-word-aux">图片大小统一为300像素*339像素</div>
			</div>
		</blockquote>
		</c:if>
		<ul id="Images">
		<c:forEach var="pml" items="${list}">
			<li>
			<img src="${pml.url }">
			<div class="operate">
				<c:if test="${compUpdate==1 }">
				<i style="float: left;" class="layui-icon img_del updete">&#xe642;<input type="hidden" value="${pml.id }"/></i>
				</c:if>
				<div class="check">
				<%-- <input type="checkbox" name="belle" lay-filter="choose" lay-skin="primary" title="<fmt:formatDate pattern="yy年MM月dd日 hh时:mm分" value="${pml.createtime }" />"> --%>
				</div>
				<c:if test="${compDelete==1 }">
				<i onclick="deleteImg(${pml.id });" class="layui-icon img_del">&#xe640;</i>
				</c:if>
			</div>
			</li>
		</c:forEach>
		</ul>
	</form>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.all.js"></script>
	<!-- <script type="text/javascript" src="js/images.js"></script> -->
</body>
<script type="text/javascript">
	var comp = '${comp }';
	var layer,indexLayer,hid;
	layui.use(['layer','upload'],function(){
			layer = parent.layer,
			upload = layui.upload;
			upload.render({
			    elem: '#test1' //绑定元素
			    ,url: "HallslidingdrawingServlet?op=addImgUpload&width=300&height=339" //上传接口
			    ,before:function(obj){
			    	indexLayer = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
				}
				,done: function(e){
					if(e.icon=="0"){
						layer.msg("上传失败。图片大小必须为300*339",{icon: 2});
					}else{
						 $.post("HallslidingdrawingServlet",{"op":"addImg","url":e.url},function(e){
							if(e=="ok"){
								layer.msg("添加成功。", {icon: 1});
								window.setTimeout("window.location.href='HallslidingdrawingServlet?op=hallslidingdrawingList&comp="+comp+"'",2000);
							}
							layer.close(indexLayer);
						});
					}
			      //上传完毕回调
			    }
			    ,error: function(){
			      //请求异常回调
			    }
		});
			
			//修改
			upload.render({
			    elem: '.updete' //绑定元素
			    ,url: "HallslidingdrawingServlet?op=addImgUpload&width=300&height=339" //上传接口
			    ,before:function(obj){
			    	var item = this.item;
			    	hid = $(item).children("input").val();
			    	indexLayer = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
				}
				,done: function(e){
					if(e.icon=="0"){
						layer.msg("上传失败。图片大小必须为300*339",{icon: 2});
					}else{
						 $.post("HallslidingdrawingServlet",{"op":"updateImg","url":e.url,"id":hid},function(e){
							if(e=="ok"){
								layer.msg("修改成功。", {icon: 1});
								window.setTimeout("window.location.href='HallslidingdrawingServlet?op=hallslidingdrawingList&comp="+comp+"'",2000);
							}
							layer.close(indexLayer);
						});
					}
			      //上传完毕回调
			    }
			    ,error: function(){
			      //请求异常回调
			    }
		});
	});
	
	function deleteImg(id){
		layer.confirm("是否确定删除该封面?", {
		    btn: ['是','否'] //按钮
		  }, function(){
			  $.post("HallslidingdrawingServlet",{"op":"deleteImg","id":id},function(e){
					if(e=="ok"){
						layer.msg("删除成功。", {icon: 1});
						window.setTimeout("window.location.href='HallslidingdrawingServlet?op=hallslidingdrawingList&comp="+comp+"'",2000);
					}else{
						layer.msg("删除失败。", {icon: 2});
					}
				});
		});
	}
	
	$(document).ready(function(){
		window.parent.layer.close(window.parent.indexload);
		$(".layui-upload-file").css("display","none");
	}); 
	</script>
</html>