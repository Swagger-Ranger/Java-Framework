<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href="<%=basePath%>">
	<TITLE> ZTREE DEMO - checkbox</TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/demo.css" type="text/css">
	<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/ztree/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/ztree/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="js/ztree/jquery.ztree.excheck.js"></script>
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="css/user.css" media="all" />
	<!--
	<script type="text/javascript" src="../../../js/jquery.ztree.exedit.js"></script>
	-->
	<SCRIPT type="text/javascript">
	var zNodes;
		$(function(){
			 zNodes =[
						{ id:1, pId:0, name:"后台首页", open:false},
				{ id:101, pId:1, name:"开关服务器"},
				{ id:102, pId:1, name:"发送邮件"},
			{ id:2, pId:0, name:"用户管理", open:false},
				{ id:5, pId:2, name:"用户"},
					{ id:501, pId:5, name:"修改用户"},
                 /*增加对管理员的充值功能权限管控                2018-4-26               begin    zhanglei*/
                    { id:502, pId:5, name:"充值"},
                 /*增加对管理员的充值功能权限管控                2018-4-26               end    zhanglei*/
				{ id:8, pId:2, name:"推广员"},
					{ id:801, pId:8, name:"禁用/开权限"},
					{ id:802, pId:8, name:"查看推广信息"},
					{ id:803, pId:8, name:"修改奖励比例"},
				/* { id:3, pId:2, name:"管理员"},
					{ id:301, pId:3, name:"添加管理员"},
					{ id:302, pId:3, name:"删除管理员"},
					{ id:303, pId:3, name:"编辑管理员"}, */
			/* { id:4, pId:2, name:"游戏用户信息"}, */
				
			/* { id:7, pId:2, name:"推广员信息"}, */
					
			/* { id:9, pId:7, name:"提现审核"}, */
				/* { id:901, pId:9, name:"审核权限"}, */
			{ id:12, pId:0, name:"游戏管理"},
			/* { id:13, pId:12, name:"游戏信息"}, */
			{ id:17, pId:12, name:"机器人"},
				{ id:1701, pId:17, name:"添加机器人"},
				{ id:1702, pId:17, name:"编辑机器人"},
			{ id:18, pId:12, name:"封面公告"},
				{ id:1801, pId:18, name:"添加封面"},
				{ id:1802, pId:18, name:"删除封面"},
				{ id:1803, pId:18, name:"修改封面"},
			{ id:19, pId:12, name:"任务管理"},
				{ id:20, pId:19, name:"任务列表"},
					{ id:2001, pId:20, name:"添加任务"},
					{ id:2002, pId:20, name:"编辑任务"},
				{ id:22, pId:19, name:"任务完成条件"},
					{ id:2201, pId:22, name:"添加完成条件"},
					{ id:2202, pId:22, name:"编辑完成条件"},
			{ id:23, pId:12, name:"参数设置"},
				{ id:24, pId:23, name:"游戏参数设置"},
					{ id:2401, pId:24, name:"修改参数"},
				{ id:25, pId:23, name:"推广员参数设置"},
					{ id:2501, pId:25, name:"修改参数"},
				{ id:26, pId:23, name:"麻将参数设置"},
					{ id:2601, pId:26, name:"修改参数"},
				{ id:27, pId:23, name:"牛牛参数设置"},
					{ id:2701, pId:27, name:"修改参数"},
				{ id:28, pId:23, name:"焖鸡参数设置"},
					{ id:2801, pId:28, name:"修改参数"},
				{ id:29, pId:23, name:"扯旋参数设置"},
					{ id:2901, pId:29, name:"修改参数"},
				{ id:13, pId:0, name:"数据总汇", open:false},
					{ id:6, pId:13, name:"充值记录"},
					{ id:14, pId:13, name:"对战信息"},
					{ id:15, pId:13, name:"服务费信息"},
					{ id:30, pId:13, name:"商品购买记录"},
					{ id:9, pId:13, name:"申请奖励记录"},
					{ id:10, pId:13, name:"推广员充值记录"},
                 <%-- 开启后台充值信息功能        2018-4-25  14:07     zhanglei    begin--%>
					{ id:16, pId:13, name:"后台充值信息"}
                 <%-- 开启后台充值信息功能        2018-4-25  14:07     zhanglei    end--%>
				];
			var json = window.parent.obj;
			var json2 = json.role;
			$("#aname").val(json.adminname);
			$("#opname").val(json.opname);
			$("#userFace").attr("src",json.head);
			for (var i = 0; i < json2.length; i++) {
				for (var j = 0; j < zNodes.length; j++) {
					if(json2[i].mid==zNodes[j].id){
						zNodes[j].checked=true;
					}
					if(json2[i].op1==zNodes[j].id){
						zNodes[j].checked=true;
					}
					if(json2[i].op2==zNodes[j].id){
						zNodes[j].checked=true;
					}
					if(json2[i].op3==zNodes[j].id){
						zNodes[j].checked=true;
					}
					
				}
			}
			
		});
	
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		
		var code;
		
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			type =  { "Y" : "ps", "N" : "s" };
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
			$("#py").bind("change", setCheck);
			$("#sy").bind("change", setCheck);
			$("#pn").bind("change", setCheck);
			$("#sn").bind("change", setCheck);
		});
		
		 /* function sasad(){  
	            var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),  
	            nodes=treeObj.getCheckedNodes(true) ,  
	            v="";  
	            for(var i=0;i<nodes.length;i++){  
	            v+=nodes[i].name + ",";  
	            // alert(nodes[i].name); 获取选中节点的值  
	        	 }
	            alert(nodes.length);
		 }   */
	</SCRIPT>
</HEAD>

<BODY>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>添加管理员</legend>
	</fieldset>
	<form class="layui-form" action="">
	<div class="user_left">
		<div class="layui-form-item">
		    <label class="layui-form-label">管理员账号</label>
		    <div class="layui-input-block">
		      <input name="name" id="aname" disabled="disabled" lay-verify="required|name" autocomplete="off" placeholder="请输入管理员账号" class="layui-input" type="text">
		    </div>
		  </div>
		  <!-- <div class="layui-form-item">
		    <label class="layui-form-label">管理员密码</label>
		    <div class="layui-input-block"> 
		      <input name="pwd" id="pwd" lay-verify="required|pwd" autocomplete="off" placeholder="请输入管理员密码" class="layui-input" type="password">
		    </div>
		  </div> -->
		  <!-- <div class="layui-form-item">
		    <label class="layui-form-label">管理权限名</label>
		    <div class="layui-input-block">
		      <input name="opname" id="opname" lay-verify="required|opname" autocomplete="off" placeholder="请输入管理权限名" class="layui-input" type="text">
		    </div>
		  </div> -->
		  <div class="layui-form-item">
		    <label class="layui-form-label">选择权限</label>
		    <div class="layui-input-block">
		      <ul id="treeDemo" class="ztree"></ul>
		    </div>
		  </div>
		 </div>
		  <!-- <div class="user_right">
			<input type="file" name="userFace" class="layui-upload-file" lay-title="上传头像">
					<br/>
					<br/>
				<img src="images/face.jpg" class="layui-circle" id="userFace">
			</div> -->
		  <div class="layui-form-item" style="margin-left: 5%;">
		    <div class="layui-input-block">
		    	<button class="layui-btn" lay-submit="" lay-filter="addTask">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
</BODY>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
var layer,form;
layui.use(['form','layer','upload'],function(){
	var form = layui.form();
		layer = layui.layer;
		
		layui.upload({
	    	url : "AdminServlet?op=imgUpload",
	    	success: function(res){
	    		if(res.str!="no"){
	    			userFace.src = res.str;
	    			//window.sessionStorage.setItem('userFace',res.data[num].src)
	    		}
	    		/*var num = parseInt(4*Math.random());  //生成0-4的随机数
	    		alert(num)
	    		//随机显示一个头像信息
		    	
		    	;*/
		 	}
		 });
		form.on("submit(addTask)",function(data){
			 var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),  
		     nodes=treeObj.getCheckedNodes(true);
				if(nodes.length==0){
					layer.alert('尚未选择权限', {
						  icon: 2
						});
					return ;
				}
				var aname =  $("#aname").val();
				var opname =  $("#opname").val();
				/* var userFace =  $("#userFace")[0].src; */
				var str = "";
				for (var i = 0; i < nodes.length; i++) {
					if(nodes[i].id<100){
						str+=nodes[i].id+"[";
						var op = "";
						var code1="0",code2="0",code3="0";
						for (var j = 0; j < nodes.length; j++) {
							if(nodes[i].id==nodes[j].pId && nodes[j].id>100){
								var code = nodes[j].id+"";
								code=code.substr(code.length-1,1);
								if(code==1){
									code1="1";
								}else
								if(code==2){
									code2="1";
								}else
								if(code==3){
									code3="1";
								}
								op=code1+","+code2+","+code3;
							}
						}
						str+=op;
						str+="]@";
					}
				}
				str  = str.substring(0,str.length-1);
				var userInfoHtml = '';
			        userInfoHtml = {
			        	'op' : "updateAdmin",
			            'id' : window.parent.obj.id,
			            'opname' : opname,
			            /* 'userFace' : userFace, */
			            'nodes' : str
			        };
			         var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
			        $.post("AdminServlet",userInfoHtml,function(e){
			        	if(e=="ok"){
			        		layer.msg("修改成功！");
			        		setTimeout(function(){
				        		parent.location.reload();
				            	parent.layui.layer.close(parent.indexLayer);
				            },2000);
			        	}else{
			        		layer.msg("添加失败,账号已存在。");
			        	}
			        	
			        }); 
			return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		});
		
		form.verify({
			 name: function(value){  
		          if(value.length < 5){  
		            return '管理员账号不得少于5个字符';  
		          }  
		     },
		     pwd: function(value){  
		          if(value.length < 6){  
		            return '管理员密码不得少于6位数';  
		          }  
		     },
		     opname: function(value){  
		          if(value.length < 3){  
		            return '管理员权限名不得少于5个字符';  
		          }  
		     }
	    });
});
</script>
</HTML>