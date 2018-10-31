var form,layer;
layui.config({
	base : "js/"
}).use(['form','layer'],function(){
		form = layui.form(),
		layer = layui.layer
	//登录按钮事件
	form.on("submit(login)",function(data){
		$("#from").submit();
		return false;
	});
	//页面加载执行
	/*$(function(){
		if(prompt==""){
			layer.msg("验证码错误", {icon: 2});
		}
	});*/
	
	//点击切换验证码
});
$("#yzm").click(function(){
	$("#yzm").attr('src', 'AuthImageServlet?' + Math.random());
});
function loadPrompt(prompt){
	if(prompt!=""){
		layer.msg(prompt, {icon: 2});
	}
}
