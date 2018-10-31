layui.config({
	base : "../../js/"
}).use(['upload'],function(){
	 layui.upload({
	    	url : "RobotServlet?op=imgUpload",
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
})