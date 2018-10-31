<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String p3_money = request.getParameter("p1_yingyongnum");
System.out.println(p3_money);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>send</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->

  </head>
  
  <body onload="ddddd()">
   <form id="formid" method="post" enctype="application/json" action='<%=request.getParameter("url")%>'>
   <input type="hidden" name="p1_yingyongnum" id="p1_yingyongnum" value='<%=request.getParameter("p1_yingyongnum")%>'>
    <input type="hidden" name="p2_ordernumber" id="p2_ordernumber" value='<%=request.getParameter("p2_ordernumber")%>'>
   <input type="hidden" name="p3_money" id="p3_money" value='<%=request.getParameter("p3_money")%>'> 
   <input type="hidden" name="p6_ordertime" id="p6_ordertime" value='<%=request.getParameter("p6_ordertime")%>'>
  <input type="hidden" name="p7_productcode" id="p7_productcode" value='<%=request.getParameter("p7_productcode")%>'> 
<input type="hidden" name="p8_sign" id="p8_sign" value='<%=request.getParameter("p8_sign")%>'>
<input type="hidden" name="p9_signtype" id="p9_signtype" value="1">
<input type="hidden" name="p14_customname" id="p14_customname" value='<%=request.getParameter("p14_customname")%>'>
<input type="hidden" name="p16_customip" id="p16_customip" value='<%=request.getParameter("p16_customip")%>'>

<input type="hidden" name="paytype" id="paytype" value="zz">

</form>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
window.onload=function()
{
	$("#formid").submit();
}
</script>
  </body>
</html>
</i>