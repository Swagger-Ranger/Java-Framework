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
		
		form.on("submit(addTask)",function(data){
			if(count==0){
				layer.msg("奖励最少选择一项",{icon: 2});
				return false; 
			}else{
				var gold =  $(".gold").val();
				var diamonds =  $(".diamonds").val();
				var horn =  $(".horn").val();
				var egg =  $(".egg").val();
				var hammer =  $(".hammer").val();
				var integral =  $(".integral").val();
				var sportcar =  $(".sportcar").val();
				var flower =  $(".flower").val();
				/*fixbug       2018-4-26      begin           zhanglei*/
				var laobanka =  $(".laobanka").val();
				//任务奖励
				var rewdrd = '{"gold":'+gold+',"diamonds":'+diamonds+',"horn":'+horn+',"egg":'+egg+',"hammer":'+hammer+',"integral":'+integral+',"sportcar":'+sportcar+',"flower":'+flower+',"laobanka":'+laobanka+'}';
				/*fixbug       2018-4-26      end           zhanglei*/
				//任务接受条件
				var accept =  $("#accept").val();
				//任务完成条件
				var comp =  $("#comp").val();
				//任务类型
				var type =  $("#type").val();
				//任务描述
				var describe =  $("#describe").val();
				
			}
	    	var index = layer.msg('提交中，请稍候',{icon: 16,time:false,shade:0.8});
	        //将填写的用户信息存到session以便下次调取
	        var userInfoHtml = '';
	        userInfoHtml = {
	        	'op' : "addTask",
	            'acceptid' : accept,
	            'completeid' : comp,
	            'reward' : rewdrd,
	            'type' : type,
	            'describe' : describe
	        };
	        $.post("TaskServlet",userInfoHtml,function(e){
	        	setTimeout(function(){
	        		parent.location.reload();
	            	parent.layui.layer.close(parent.indexLayer);
	                layer.msg("提交成功！");
	            },2000);
	        });
			count=0;
	    	return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	    });
		//添加验证规则
    form.verify({
    	cbx : function(value, item){
        	if(value!=0){
        		count++;
        	}
        }
    
    });
		
		
		form.on('checkbox(reward)', function(data){
			  var el = data.elem;
			  var content = $(el).attr("title");
			  var split = content.split("(");
			  content = split[0];
			  if(data.elem.checked){
				layer.prompt({title: '输入奖励数量',btn: ['完成','取消'], formType: 3,btn2: function(index){
					 $(el).prop("checked",false);
					 form.render('checkbox','reward');
			    }}, function(text, index){
					 if((/^(\+|-)?\d+$/.test(text))&&text>-1){  
						 	$(el).val(text);
						 	content= content+"("+text+")";
							$(el).attr("title",content);
							layer.close(index);
							form.render('checkbox','reward');
					    }else{  
					    	layer.msg("请输入正确的值");
					        return false;  
					    }  
					 	
				  });
			  }else{
				  $(el).val(0);
				  content= content+"(0)";
				  $(el).attr("title",content);
				  form.render('checkbox','reward');
			  }
			  /*console.log(data.elem); //得到radio原始DOM对象
			  console.log(data.value); //被点击的radio的value值
*/		});  
		
		
		
		$.post("CompleteServlet",{"op":"selectAllComp"},function(e){
			var h= "<option value=''></option>";
			for (var i = 0; i < e.length; i++) {
				h+="<option value='"+e[i].id+"'>"+e[i].text+"</option>";
			}
			$("#comp").html(h);
			form.render('select');
		},"json");
		
		
		$.post("AcceptServlet",{"op":"selectAllAccept"},function(e){
			var h= "<option value=''></option>";
			for (var i = 0; i < e.length; i++) {
				h+="<option value='"+e[i].id+"'>"+e[i].text+"</option>";
			}
			$("#accept").html(h);
			form.render('select');
		},"json");
});
