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
	<c:if test="${type!=1 }">
		<blockquote class="layui-elem-quote news_search">
			<form id="form1" class="layui-form" method="post" action="ProxyServlet?op=listProxy">
				<input  type="hidden" name="pageSize" class="pageSize" value="${pm.pageSize}" />
				<input type="hidden" name="currentPage" class="currentPage" value="1" />
				<input type="hidden" name="comp" class="comp" value="${comp }" />
				<input style="width: 8%;display:inline;" type="text" id="pid" name="pid" value="${pid }" lay-verify="required" placeholder="根据自己的ID查询" autocomplete="off" class="layui-input">
				<input style="width: 10%;display:inline;" type="text" id="ppid" name="ppid" value="${ppid }" lay-verify="required" placeholder="根据上级的后台ID查询" autocomplete="off" class="layui-input">
				<input style="width: 15%;display:inline;" type="text" id="nickname" name="nickname" value="${nickname }" lay-verify="required" placeholder="根据昵称模糊查询" autocomplete="off" class="layui-input">
				<input style="width: 10%;display:inline;" type="text" id="contactWay" name="contactWay" value="${contactWay }" lay-verify="required" placeholder="根据微信号查询" autocomplete="off" class="layui-input">
				<input style="width: 15%;display:inline;" type="text" id="phone" name="phone" value="${phone }" lay-verify="required" placeholder="根据手机号查询" autocomplete="off" class="layui-input">
				<input style="width: 15%;display:inline;" type="text" id="trueName" name="trueName" value="${trueName }" lay-verify="required" placeholder="根据真实姓名查询" autocomplete="off" class="layui-input">
				<input style="display:inline;" type="submit" value="搜索" class="layui-btn" >
				<div style="width: 30%;display:inline;" class="layui-form-item">
					<div class="layui-input-inline">
						<select name="status">
							<option ${status != '1' and status!= '0' ? 'selected':' '} value="">根据代理状态查询</option>
							<option ${status == '1' ?'selected':' ' } value="1">正常</option>
							<option ${status == '0' ?'selected':' ' } value="0">封禁</option>
						</select>
					</div>
				</div>
			</form>
		</blockquote>
	</c:if>
	<div class="table-container">
		<div class="layui-form news_list">
			<%-- <table class="layui-table">
                <colgroup>
                    <col width="20%">
                    <col width="20%">
                    <col width="20%">
                    <col width="20%">
                    <col width="20%">
                </colgroup>
                <thead>
                    <tr>
                        <th>总服务费合计</th>
                        <th>平台所获得的服务费合计</th>
                        <th>一级代理所获得的服务费合计</th>
                        <th>二级代理所获得的服务费合计</th>
                        <th>三级代理所获得的服务费合计</th>
                        <!-- <th>操作</th> -->
                    </tr>
                </thead>
                <tbody class="news_content">
                    <tr>
                        <td>${sumAllpump }</td>
                        <td>${sumPingtaipump }</td>
                        <td>${sumOneproxypump }</td>
                        <td>${sumTwoproxypump }</td>
                        <td>${sumThreeproxypump }</td>
                    </tr>
                </tbody>
            </table> --%>
			<table class="layui-table">
				<colgroup>
					<col width="5%">
					<col width="5%">
					<col width="11%">
					<col width="5%">
					<col width="11%">
					<col width="11%">
					<col width="5%">
					<col width="12%">
					<col width="10%">
					<col width="10%">
					<c:if test="${proxyOp1==1 }">
						<col width="8%">
					</c:if>
					<c:if test="${proxyOp1==1 or proxyOp2==1 or proxyOp2==1}">
						<col width="7%">
					</c:if>
					<%-- <col width="10%"> --%>
				</colgroup>
				<button onclick="quanxian()" class="layui-btn layui-btn-primary layui-btn-xs">权限设置</button>
				<thead>
				<tr>
					<th>自己的ID</th>
					<th>上级的后台ID</th>
					<th>账号</th>
					<th>电话号码</th>
					<th>微信号</th>
					<th>真实姓名</th>
					<th>自己的游戏ID</th>
					<th>当前推广员平台积分</th>
					<th>总收益(一共收取的服务费)</th>
					<th>已提取积分（总额）</th>
					<c:if test="${proxyOp1==1 }">
						<th>代理后台权限</th>
					</c:if>
					<c:if test="${proxyOp1==1 or proxyOp2==1 or proxyOp2==1}">
						<th>操作</th>
					</c:if>
					<!-- <th>操作</th> -->

				</tr>
				</thead>
				<tbody class="news_content">
				<c:if test="${flag==1}">
					<tr>
						<td colspan="12" align="center" style="color: red">无结果！</td>
					</tr>
				</c:if>
				<c:forEach var="pml" items="${pm.list}">
					<tr>
						<td>${pml.id}</td>
							<%-- <td>${pml.rank==1?'一级代理':'二级代理'}</td> --%>
						<c:if test="${pml.pid == 0}">
							<td>无</td>
						</c:if>
						<c:if test="${pml.pid != 0}">
							<td>${pml.pid}</td>
						</c:if>
						<td>${pml.phone}</td>
						<td>${pml.account}</td>
						<td>${pml.contactWay}</td>
						<td>${pml.trueName}</td>
						<c:if test="${pml.uid == null ||pml.uid ==''}">
							<td>无</td>
						</c:if>
						<c:if test="${pml.uid != null && pml.uid !='' }">
							<td>${pml.uid}</td>
						</c:if>
						<c:forEach items="${map2}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value}</td>
							</c:if>
						</c:forEach>
						<c:forEach items="${map}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value}</td>
							</c:if>
						</c:forEach>
						<c:forEach items="${map3}" var="m" >
							<c:if test="${pml.id==m.key }">
								<td>${m.value}</td>
							</c:if>
						</c:forEach>
						<c:if test="${proxyOp1==1 }">
							<td>
								<c:if test="${pml.kg==0}">
									<a href="javascript:saveKG('${pml.id}','${pml.kg}');" data-name="${pml.id}" data-opt="edit"  class="layui-btn  layui-btn-danger layui-btn-mini">权限已关闭</a>
								</c:if>
								<c:if test="${pml.kg==1}">
									<a href="javascript:saveKG('${pml.id}','${pml.kg}');" data-name="${pml.id}" data-opt="edit"  class="layui-btn layui-btn-mini">权限已开启</a>
								</c:if>
								<c:if test="${pml.right==0 }">
									<a href="javascript:updateRight('${pml.id}','1');" data-name="${pml.id}" data-opt="edit" style="background-color: green;" class="layui-btn layui-btn-danger">查询开</a>
								</c:if>
								<c:if test="${pml.right==1 }">
									<a href="javascript:updateRight('${pml.id}','0');" data-name="${pml.id}" data-opt="edit" style="background-color: red;" class="layui-btn layui-btn-danger">查询关</a>
								</c:if>
							</td>
						</c:if>
						<c:if test="${proxyOp1==1 or proxyOp2==1 or proxyOp2==1}">
							<td>
								<c:if test="${proxyOp1==1 }">
									<c:if test="${pml.isDisable==1 }">
										<a href="javascript:update2('${pml.id}','0');" data-name="${pml.id}" data-opt="edit" class="layui-btn layui-btn-danger layui-btn-mini">禁用登录</a>
									</c:if>
									<c:if test="${pml.isDisable==0 }">
										<a href="javascript:update2('${pml.id}','1');" data-name="${pml.id}" data-opt="edit" class="layui-btn layui-btn-mini">启用登录</a>
									</c:if>

									<c:if test="${pml.status==1 }">
										<a href="javascript:update('${pml.id}','0');" data-name="${pml.id}" data-opt="edit" class="layui-btn layui-btn-danger layui-btn-mini">禁用</a>
									</c:if>
									<c:if test="${pml.status==0 }">
										<a href="javascript:update('${pml.id}','1');" data-name="${pml.id}" data-opt="edit" class="layui-btn layui-btn-mini">启用</a>
									</c:if>
								</c:if>
								<c:if test="${proxyOp2==1 }">
									<c:if test="${type!=1 }">
										<a href="javascript:heProxy('${pml.id}');" data-name="${pml.id}" data-opt="edit" class="layui-btn layui-btn-normal layui-btn-mini">推广信息</a>
									</c:if>
								</c:if>
								<c:if test="${proxyOp3==1 }">
									<c:choose>
										<c:when test="${pml.yiji == 30 && pml.erji == 20 && pml.sanji == 20 }">
											<a href="javascript:choushui('${pml.id}','${pml.yiji }','${pml.erji }','${pml.sanji }');" data-name="${pml.id}" data-opt="edit"  class="layui-btn layui-btn-primaryi layui-btn-mini">奖励比例</a>
										</c:when>
										<c:otherwise>
											<a href="javascript:choushui('${pml.id}','${pml.yiji }','${pml.erji }','${pml.sanji }');" data-name="${pml.id}" data-opt="edit"  class="layui-btn  layui-btn-danger layui-btn-mini">奖励比例</a>
										</c:otherwise>
									</c:choose>
								</c:if>

							</td>
						</c:if>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<c:if test="${type!=1 }">
	<%@include file="page.jsp"%>
</c:if>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>
<!-- <script type="text/javascript" src="js/newsList.js"></script> -->
<script type="text/javascript">
    var currentPage = '${pm.currentPage}';
    var layer,obj,pid;
    layui.use(['form','layer'],function(){
        var form = layui.form();
        layer = layui.layer;
    });


    function choushui(id,yiji,erji,sanji){
        layer.open({
            type: 1,
            title: "奖励比例修改",
            skin: 'layui-layer-rim', //加上边框
            area: ['420px', '340px'], //宽高
            content: "<div id='user' style='margin-top: 10px;' class='layui-form-item'>"+
            "<label class='layui-form-label'>一级奖励</label>"+
            "<div class='layui-input-block'>"+
            "<input id='yiji' onchange='yiji();' value='"+yiji+"' type='number' onkeydown='return false;' step='1' name='number' min='0' max='100' style='width: 70%;' placeholder='一级抽水' autocomplete='off' class='layui-input'>"+
            "</div>"+
            "</div>"+
            "<div id='user' style='margin-top: 10px;' class='layui-form-item'>"+
            "<label class='layui-form-label'>二级奖励</label>"+
            "<div class='layui-input-block'>"+
            "<input id='erji' onchange='erji();' value='"+erji+"' type='number' onkeydown='return false;' step='1' name='number' min='0' max='100' style='width: 70%;' placeholder='一级抽水' autocomplete='off' class='layui-input'>"+
            "</div>"+
            "</div>"+
            "<div id='user' style='margin-top: 10px;' class='layui-form-item'>"+
            "<label class='layui-form-label'>三级奖励</label>"+
            "<div class='layui-input-block'>"+
            "<input id='sanji' onchange='sanji();' value='"+sanji+"' type='number' onkeydown='return false;' step='1' name='number' min='0' max='100' style='width: 70%;' placeholder='一级抽水' autocomplete='off' class='layui-input'>"+
            "</div>"+
            "</div>"+
            "<div id='user' style='margin-top: 10px;' class='layui-form-item'>"+
            "<div class='layui-input-block'>"+
            "<div style='color: red;' class='layui-form-mid layui-word-aux'>提示:总比例100%。(平台占比:<span id='spa'>"+(100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji)))+"</span>)</div>"+
            "</div>"+
            "</div>"+
            "<div id='user' style='margin-top: 10px;' class='layui-form-item'>"+
            "<div class='layui-input-block'>"+
            "<input onclick='save("+id+");' type='button' value='保存' class='layui-btn layui-btn-danger'>"+
            "</div>"+
            "</div>"
        });
    }




    /*  */
    function quanxian(){
        $.post("ProxyServlet",{"op":"selectNum"},function(e){
            if(e=="null"){
                e={"yiji":"0","erji":"0","sanji":"0"};
			}else{
                e = JSON.parse(e);
			}
            layer.open({
                type: 1,
                title: "一条线查询数量设置",
                skin: 'layui-layer-rim', //加上边框
                area: ['420px', '340px'], //宽高
                content: "<div id='user' style='margin-top: 10px;' class='layui-form-item'>"+
                "<label class='layui-form-label'>一级人数</label>"+
                "<div class='layui-input-block'>"+
                "<input id='number1' onchange='' value='" +e.yiji+"' type='number' onkeydown='return false;' step='1' name='number1' min='0' max='100' style='width: 70%;' placeholder='一级代理人数' autocomplete='off' class='layui-input'>"+
                "</div>"+
                "</div>"+
                "<div id='' style='margin-top: 10px;' class='layui-form-item'>"+
                "<label class='layui-form-label'>二级人数</label>"+
                "<div class='layui-input-block'>"+
                "<input id='number2' onchange='' value='" +e.erji+"' type='number' onkeydown='return false;' step='1' name='number2' min='0' max='100' style='width: 70%;' placeholder='二级代理人数' autocomplete='off' class='layui-input'>"+
                "</div>"+
                "</div>"+
                "<div id='user' style='margin-top: 10px;' class='layui-form-item'>"+
                "<label class='layui-form-label'>三级人数</label>"+
                "<div class='layui-input-block'>"+
                "<input id='number3' onchange='' value='" +e.sanji+ "' type='number' onkeydown='return false;' step='1' name='number3' min='0' max='100' style='width: 70%;' placeholder='三级代理人数' autocomplete='off' class='layui-input'>"+
                "</div>"+
                "</div>"+
                "<div id='' style='margin-top: 10px;' class='layui-form-item'>"+
                "<div class='layui-input-block'>"+
                "</div>"+
                "<div id='' style='margin-top: 10px;' class='layui-form-item'>"+
                "<div class='layui-input-block'>"+
                "<input onclick='saveNum()'  type='button' value='保存设置' class='layui-btn layui-btn-danger'>"+
                "</div>"+
                "</div>"
            });
        });
    }
    /*  */
    function saveKG(id,kg){
        var str="";
        if(kg==1){
            str="是否确定关闭该代理的一条线整体查询功能?";
        }else{
            str="是否确定开启该代理的一条线整体查询功能?";
        }
        layer.confirm(str, {
            btn: ['是','否'] //按钮
        }, function(){
            var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
            $.post("ProxyKG",{"id":id,"kg":kg},function(e){
                layer.msg("更改成功", {icon: 1});
                setTimeout("page("+currentPage+")",2000);
            });
        });
    }
    function saveNum(){
        var currentPage = '${pm.currentPage }';
        var number1 = $("#number1").val();
        var number2 = $("#number2").val();
        var number3 = $("#number3").val();
        if(parseInt(number1)==NaN || parseInt(number2)==NaN  || parseInt(number3)==NaN){
            layer.msg("警告:输入框中存在非法数字",{icon: 2});
        }else{
            var index = layer.load(2);
            $.post("ProxyServlet",{"op":"saveNumSession","number1":number1,"number2":number2,"number3":number3},function(e){
                if("ok"==e){
                    layer.msg("保存成功", {icon: 1});
                    setTimeout("page("+currentPage+")",2000);
                }else{
                    layer.msg("保存失败", {icon: 2});
                    layer.close(index);
                }
            });
        }
    }






    function yiji(){
        var yiji = $("#yiji").val();
        var erji = $("#erji").val();
        var sanji = $("#sanji").val();
        if((100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji)))<0){
            $("#yiji").val((100-(parseInt(erji)+parseInt(sanji))));
            $("#erji").val(erji);
            $("#sanji").val(sanji);
            layer.msg("总比例不能超过100%");
        }
        var spa =100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji));
        $("#spa").html(spa);
    }

    function erji(){
        var yiji = $("#yiji").val();
        var erji = $("#erji").val();
        var sanji = $("#sanji").val();
        if((100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji)))<0){
            $("#erji").val((100-(parseInt(yiji)+parseInt(sanji))));
            $("#yiji").val(yiji);
            $("#sanji").val(sanji);
            layer.msg("总比例不能超过100%");
        }
        var spa =100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji));
        $("#spa").html(spa);
    }

    function sanji(){
        var yiji = $("#yiji").val();
        var erji = $("#erji").val();
        var sanji = $("#sanji").val();
        if((100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji)))<0){
            $("#sanji").val((100-(parseInt(erji)+parseInt(yiji))));
            $("#yiji").val(yiji);
            $("#erji").val(erji);
            layer.msg("总比例不能超过100%");
        }
        var spa =100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji));
        $("#spa").html(spa);
    }

    /* $("#yiji").bind("input porpertychange",function(){
        alert("1");
        var yiji = $("#yiji").val();
        var erji = $("#erji").val();
        var sanji = $("#sanji").val();
        if((100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji)))<0){
            layer.msg("总比例不能超过100%");
        }
    }); */
    function save(id){
        var currentPage = '${pm.currentPage }';
        var yiji = $("#yiji").val();
        var erji = $("#erji").val();
        var sanji = $("#sanji").val();
        if((100-(parseInt(yiji)+parseInt(erji)+parseInt(sanji)))<0){
            layer.msg("警告:总比例不能超过100%",{icon: 2});
        }else{
            var index = layer.load(2);
            $.post("ProxyServlet",{"op":"updateChouShui","id":id,"yiji":yiji,"erji":erji,"sanji":sanji},function(e){
                if("ok"==e){
                    layer.msg("修改成功", {icon: 1});
                    setTimeout("page("+currentPage+")",2000);
                }else{
                    layer.msg("修改失败", {icon: 2});
                    layer.close(index);
                }
            });
        }
    }

    //所有玩家
    function heUser(id){
        /* $.ajax({
            type: "post",
            url: "ProxyServlet",
            data: {"op":"findAllUser","pid":id},
            async: false,
        success: function(e){
                obj = e;
            }
        });
            indexLayer = layui.layer.open({
                title : "所有下级玩家",
                type : 2,
                fixed: false,
                area: ['900px', '600px'],
                content : "web/update/allUser.jsp",
                success : function(layero, index){
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500);
                }
            });
            layui.layer.full(indexLayer); */
    }

    //所有代理
    function heProxy(id){
        var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
        pid = id;
        $.ajax({
            type: "post",
            url: "ProxyServlet",
            data: {"op":"findAllAgents","pid":id},
            dataType: "json",
            async: false,
            success: function(e){
                obj = e;
                layer.close(index);
            }
        });
        indexLayer = layui.layer.open({
            title : "推广信息",
            type : 2,
            fixed: false,
            area: ['900px', '600px'],
            content : "web/update/allAgents.jsp",
            success : function(layero, index){
                setTimeout(function(){
                    layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500);
            }
        });
        layui.layer.full(indexLayer);

        /* parent.tab.tabAdd({
            href: "ProxyServlet?op=heListProxy&pid="+id+"&currentPage=1", //地址
            icon: "&#xe63c;",
            title: "所有代理"
        }); */
    }

    function updateRight(id,status){
        var currentPage = $("#currentPage").val();
        var str = "";
        if(status==0){
            str="是否确定关闭该代理的一条线整体查询功能?";
        }else{
            str="是否确定开启该代理的一条线整体查询功能?";
        }
        layer.confirm(str, {
            btn: ['是','否'] //按钮
        }, function(){
            var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
            $.post("ProxyServlet",{"op":"updateRight","id":id,"status":status},function(e){
                layer.msg("更改成功", {icon: 1});
                setTimeout("page("+currentPage+")",2000);
            });
        });
    }


    function update(id,status){
        var currentPage = $("#currentPage").val();
        var str = "";
        if(status==0){
            str="是否确定禁用该代理?<br/><br/><span style='color: #FF3030;'>提示:禁用后该代理将无法登录代理后台,并脱离组织关系。</span>";
        }else{
            str="是否确定启用该代理?";
        }
        layer.confirm(str, {
            btn: ['是','否'] //按钮
        }, function(){
            var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
            $.post("ProxyServlet",{"op":"updateProxy","id":id,"status":status},function(e){
                layer.msg("更改成功", {icon: 1});
                setTimeout("page("+currentPage+")",2000);
            });
        });
    }
    function update2(id,isDisable){
        var currentPage = $("#currentPage").val();
        var str = "";
        if(isDisable==0){
            str="是否确定禁用该代理?<br/><br/><span style='color: #FF3030;'>提示:禁用后该代理将无法登录代理后台。</span>";
        }else{
            str="是否确定启用该代理?";
        }
        layer.confirm(str, {
            btn: ['是','否'] //按钮
        }, function(){
            var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
            $.post("ProxyServlet",{"op":"update2Proxy","id":id,"isDisable":isDisable},function(e){
                layer.msg("更改成功", {icon: 1});
                setTimeout("page("+currentPage+")",2000);
            });
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