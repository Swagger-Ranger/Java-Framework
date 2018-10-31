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
	<title>系统基本参数</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/iconfont.css" media="all" />
	<link rel="stylesheet" href="css/iconfont3.css" media="all" />
	<style type="text/css">
		.layui-table td, .layui-table th{ text-align: center; }
		.layui-table td{ padding:5px; }
		<style>


        .fly-search {
            position: relative;
            margin-left: 10px;
            display: inline-block;
            vertical-align: top;
        }
        .fly-search input {
            padding-right: 30px;
        }
        .layui-input {
            display: block;
            width: 100%;
            padding-left: 10px;
        }
        .layui-input{
            height: 38px;
            line-height: 38px;
            border: 1px solid #e6e6e6;
            background-color: #fff;
            border-radius: 2px;
            box-sizing: border-box!important;---div 设置的宽高将包含 边框及 padding
        }

	</style>
</head>
<body class="childrenBody">
	<form class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="20%">
				<col width="50%">
				<col>
		    </colgroup>
		    <thead>
		    	<tr>
		    		<th>参数说明</th>
		    		<th>参数值</th>
		    		<th>变量名</th>
		    	</tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="pml" items="${list}">
		    		<tr>
						<c:choose>
						   <c:when test="${pml.name eq'BackstagePwd'}"> 
						   		<td>${pml.explain }</td>
								<td style="position:relative;"><i onclick="updateSysPwd('${pml.id}');" class="iconfont icon-jiami" style="position: absolute;right:50%;z-index:5;top: 24%;font-size: 20px;"></i><input type="text" disabled="disabled" class="layui-input cmsName" lay-verify="required" value="密码已被加密" ></td>
								<td>${pml.name }</td>
						   </c:when>
						   <c:otherwise>
							<td>${pml.explain }</td>
							<td style="position:relative;"><i onclick="iconfont('1',this,'${pml.id}');" class="iconfont icon-suodinglocked33" style="position: absolute;right:2%;z-index:5;top: 24%;font-size: 20px;color: #B0B0B0;"></i><input type="text" disabled="disabled" class="layui-input cmsName" lay-verify="required" value="${pml.value }" ></td>
							<td>${pml.name }</td>
						   </c:otherwise>
						</c:choose>
					</tr>
		    	</c:forEach>
		    </tbody>
		</table>
		<!-- <div class="layui-form-item" style="text-align: right;">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="systemParameter">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div> -->
	</form>
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="layui/layui.js"></script>
	<!-- <script type="text/javascript" src="systemParameter.js"></script> -->
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
	
	function updateSysPwd(id){
		var sss = layer.prompt({title: '请输入原二级密码', formType: 1}, function(pass, index){
			$.post("ParameterSrevlet",{"op":"selectSysPwd","pwd":pass,"id":id},function(e){
				layer.close(sss);
				if(e=="ok"){
					var sss2 = layer.prompt({title: '请输入新的二级密码', formType: 1}, function(pass2, index){
						$.post("ParameterSrevlet",{"op":"updateSysPwd","pwd":pass2,"id":id},function(e2){
							layer.close(sss2);
							if("ok"==e2){
								layer.msg("二级密码修改成功。",{icon: 1,time:1500});
							}
						});
					});
				}else{
					layer.msg("原密码输入错误",{icon: 2,time:1500});
				}
				
			});
		});
	}
	
	function iconfont(type,obj,id){
		var compUpdate = '${compUpdate}';
		if(compUpdate==1){
			if(type==1){//开锁操作
				$(obj).prop("class","iconfont icon-jiesuo");
				$(obj).attr("onclick","iconfont('2',this,'"+id+"')");
				$(obj).next().prop("disabled",false);
				
			}else{//关锁操作
				$(obj).prop("class","iconfont icon-suodinglocked33");
				$(obj).attr("onclick","iconfont('1',this,'"+id+"')");
				$(obj).next().prop("disabled",true);
				var value = $(obj).next().val();
				var index = layer.msg('保存中，请稍候',{icon: 16,time:false,shade:0.8});
				$.post("ParameterSrevlet",{"op":"updateParameter","id":id,"value":value},function(e){
				       layer.close(index);
				       layer.msg("保存成功！",{icon: 1,time:1500});
				 });
			}
		}else{
			layer.msg("您没有权限修改内容！",{icon: 4,time:1500});
		}
		
	}
/* 	$(".iconfont").click(function(){
		$(".iconfont").prop("class","iconfont icon-jiesuo");
	});*/	
 </script>
</body>
</html>