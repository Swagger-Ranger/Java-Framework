var $form;
var form;
var $;
var count = 0;
layui.config({
	base : "../../js/"
}).use(['form','layer','upload','laydate'],function(){
	form = layui.form();
	var layer = parent.layer === undefined ? layui.layer : parent.layer;
		$ = layui.jquery;
		$form = $('form');
		laydate = layui.laydate;
		
		form.on("submit(Send)",function(data){
				//发送范围
				var type =  $("#type").val();
				//邮件内容
				var describe =  $("#describe").val();
	    	var index = layer.msg('邮件正在发送中,请稍后',{icon: 16,time:false,shade:0.8});
	        //将填写的用户信息存到session以便下次调取
	        var userInfoHtml = '';
	        userInfoHtml = {
	        	'op' : "addMail",
	            'type' : type,
	            'describe' : describe
	        };
	        $.post("MailmanagementServlet",userInfoHtml,function(e){
	        	setTimeout(function(){
	        		parent.location.reload();
	            	parent.layui.layer.close(parent.indexLayer);
	                layer.msg("邮件已全部发送成功！");
	            },2000);
	        });
	    	return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	    });
});
