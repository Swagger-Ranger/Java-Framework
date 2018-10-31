layui.config({
	base : "js/"
}).use(['form','element','layer','jquery'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		element = layui.element(),
		$ = layui.jquery;

	$(".panel a").on("click",function(){
		window.parent.addTab($(this));
	});
	
	form.on('switch(test2)', function(data){
		if(data.elem.checked){
			layer.msg("服务器只能手动关闭,不能开启。", {icon: 2});
			$("#status").prop("checked",false);
			form.render('checkbox', 'test2');
		}else{
			var sss = layer.prompt({title: '请输入二级密码', formType: 1,btn2: function(){
				$("#status").prop("checked",true);
				form.render('checkbox', 'test2');
			  },cancel: function(){
					$("#status").prop("checked",true);
					form.render('checkbox', 'test2');
				  }}, function(pass, index){
				$.post("ParameterSrevlet",{"op":"selectSysPwd","pwd":pass},function(e){
					layer.close(sss);
					if(e=="ok"){
						$.post("ParameterSrevlet",{"op":"closeServer"},function(e){
							layer.msg("服务器关闭成功",{icon: 1,time:1500});
							$("#status").prop("checked",false);
							form.render('checkbox', 'test2');
						});
					}else{
						layer.msg("二级密码输入错误",{icon: 2,time:1500});
						$("#status").prop("checked",true);
						form.render('checkbox', 'test2');
					}
				});
			});
		}
	});         
	
/*	$.get("json/navs.json",function(e){
		for (var i = 0; i < e.length; i++) {
			if(e[i].title=="用户"){
				$("#xzwjuser").attr("data-url",e[i].href+"&type=1");
				$("#yhzsuser").attr("data-url",e[i].href);
				$("#jfwjuser").attr("data-url",e[i].href+"&type=2");
			}
		}
		
	});*/

	$.post("UsersServlet",{"op":"newDayUser"},function(e){
		if(e.status==true){
			$("#status").prop("checked",true);
			form.render('checkbox', 'test2');
		}else{
			$("#status").prop("checked",false);
			form.render('checkbox', 'test2');
		}
		//2018-4-16 18:14
        $("#xztgy").html(e.newDayProxyCount);
        $("#tgyzrs").html(e.ProxyCount);
        //2018-4-16 18:14
		$("#xzwj").html(e.newDayUserCount);
		$("#yhzs").html(e.UserCount);
		$("#zxrs").html(e.onlineCount);
		$("#jfwj").html(e.integralUser);
		$(".version1").html(e.zong1+"&nbsp;&nbsp;场");
		$(".author1").html(e.zong2+"&nbsp;&nbsp;场");
		$(".homePage1").html(e.zong3+"&nbsp;&nbsp;场");
		$(".server1").html(e.zong4+"&nbsp;&nbsp;场");
		$(".version2").html(e.jin1+"&nbsp;&nbsp;场");
		$(".author2").html(e.jin2+"&nbsp;&nbsp;场");
		$(".homePage2").html(e.jin3+"&nbsp;&nbsp;场");
		$(".server2").html(e.jin4+"&nbsp;&nbsp;场");
		var tabHtml = "";
		for (var i = 0; i < e.loglist.length; i++) {
			tabHtml+="<tr>";
			tabHtml+="<td>"+e.loglist[i].aid+"</td>";
			tabHtml+="<td>"+e.loglist[i].operating+"</td>";
			tabHtml+="<td>"+e.loglist[i].content+"</td>";
			tabHtml+="<td>"+getLocalTime(e.loglist[i].createTime.time)+"</td>";
			tabHtml+="</tr>";
		}
		$("#tabHtml").html(tabHtml);
	},"json");
	
	function getLocalTime(sss) {
		var time = new Date(sss);
		var y = time.getFullYear();//年
		var m = time.getMonth() + 1;//月
		var d = time.getDate();//日
		var h = time.getHours();//时
		var mm = time.getMinutes();//分
		var s = time.getSeconds();//秒
		return y+"-"+m+"-"+d+" "+h+":"+mm+":"+s;
		
	} 
});


