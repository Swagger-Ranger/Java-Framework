<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>邮件</title>
    <link rel="stylesheet" href="layui/css/layui.css" media="all" />
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-9 animated fadeInRight">
                <div class="mail-box-header">
                    <div class="pull-right tooltip-demo">
                    </div>
                    <h2>
                    邮件
                </h2>
                </div>
                <div class="mail-box">


                   <form class="form-horizontal layui-form" method="get">
                    <div class="mail-body">
                            <!-- <div class="form-group">
                                <label class="col-sm-2 control-label">收件人ID</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="输入收件人的ID" value="">
                                </div>
                            </div> -->
                             <div class="form-group">
                                <label class="col-sm-2 control-label">发送对象</label>
                             <div class="col-sm-10">
						      <select name="city" id="type" lay-verify="required">
						        <option value=""></option>
						        <option value="0">普通玩家</option>
						        <option value="1">推广员玩家</option>
						      </select>
						    </div>
                            </div>
                       
                    </div>
                    <div class="mail-text">
                    	    <div style="width: 100%;margin-left: 0px;min-height: 0px;" class="layui-input-block">
						      <textarea name="desc" id="describe" placeholder="请输入内容" lay-verify="required"  class="layui-textarea"></textarea>
						    </div>
                    </div>
                    <div class="mail-body text-right tooltip-demo">
                        <button class="layui-btn" lay-submit=""  lay-filter="Send">立即发送</button>
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="layui/layui.js"></script>
	<script type="text/javascript" src="js/mail_compose.js"></script>
</body>
	<script type="text/javascript">
	$(document).ready(function(){
		window.parent.layer.close(window.parent.indexload);
	});
	</script>
</html>
    