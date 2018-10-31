<i><%@page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%> <%@page
		import="java.util.*"%> <%@page
		import="java.util.Map"%> <%@page
		import="java.net.MalformedURLException"%> <%@page
		import="java.net.URL"%> <%@page
		import="javax.xml.namespace.QName"%> <%@page
		import="com.aiwan.util.Util"%> <%@page
		import="com.aiwan.util.MD5Tool"%> <%@page
		import="com.aiwan.dao.RechargeDAO"%> <%@page
		import="com.aiwan.entity.Recharge"%> <%@page
		import="com.aiwan.dao.ParameterDAO"%> <%@page
		import="com.aiwan.entity.Parameter"%> <%@page
		import="com.game.server.web.*"%> <%
 	System.out.println("已进入支付回调。。");

 	Enumeration en = request.getParameterNames();
 	while (en.hasMoreElements()) {
 		String el = en.nextElement().toString();
 		System.out
 				.println("||||" + el + "=" + request.getParameter(el));
 	}

 	String state = new String(request.getParameter("state")); //1:充值成功 2:充值失败
 	String customerid = new String(request.getParameter("customerid")); //商户注册的时候，网关自动分配的商户ID
 	String sd51no = new String(request.getParameter("sd51no")); //该订单在网关系统的订单号
 	String sdcustomno = new String(request.getParameter("sdcustomno")); //该订单在商户系统的流水号
 	String ordermoney = new String(request.getParameter("ordermoney")); //商户订单实际金额单位：（元）
 	String cardno = new String(request.getParameter("cardno")); //支付类型:32(微信扫码),41(微信WAP,微信公众号),42(支付宝),44(支付宝WAP),36

 	String mark = new String(request.getParameter("mark")); //订单提交时的mark值
 	String sign = new String(request.getParameter("sign")); //一次签名字符串
 	String resign = new String(request.getParameter("resign")); //二次签名字符串
 	String des = new String(request.getParameter("des")); //描述订单支付成功或失败的系统备注
 	String key = "C295DBAD8E8DCFE43607B06DF0AC3F32"; // key可从商务人员处获取
 	//String key = "42C8938E4CF5777700700E642DC2A8CD";
 	String sign2 = "customerid=" + customerid + "&sd51no=" + sd51no
 			+ "&sdcustomno=" + sdcustomno + "&mark=" + mark + "&key="
 			+ key;
 	String resign2 = "sign=" + Util.Md5(sign2).toUpperCase() + "&customerid=" + customerid
 			+ "&ordermoney=" + ordermoney + "&sd51no=" + sd51no
 			+ "&state=" + state + "&key=" + key;
 	System.out.println("参数获取完毕。。");
 	if ("1".equals(state)) {
 		System.out.println("一次签名字符串"+sign);
 		System.out.println("一次签名字符串"+Util.Md5(sign2).toUpperCase());
 		System.out.println("er次签名字符串"+resign);
 		System.out.println("er次签名字符串"+Util.Md5(resign2).toUpperCase());
 		System.out.println("交易结果成功。。。");
 		if (sign.equals(Util.Md5(sign2).toUpperCase())&&resign.equals(Util.Md5(resign2).toUpperCase())) {
 			System.out.println("MD5验证通过。。");
 			RechargeDAO dao = new RechargeDAO();
 			List<Recharge> recharges = dao.findByHQL(
 					"from Recharge where order=?", sdcustomno);
 			Recharge recharge = new Recharge();
 			if (recharges.size() > 0) {
 				System.out.println("正在准备订单修改状态。。");
 				recharge = recharges.get(0);
 				if (recharge.getStatus() == -1) {
 					recharge.setStatus(0);
 					dao.update(recharge);
 					ParameterDAO pdao = new ParameterDAO();
 					Parameter p = pdao
 							.findByHQL("from Parameter where name=?",
 									"webService").get(0);
 					System.out.println("订单状态已修改。。");
 					GameWebServerService wb = null;
 					try {
 						wb = new GameWebServerService(new URL(
 								p.getValue()), new QName(
 								"http://web.server.game.com/",
 								"GameWebServerService"));
 					} catch (MalformedURLException e) {
 						e.printStackTrace();
 					}
 					String[] split = ordermoney.split("\\.");
 					wb.getGameWebServerPort().recharge(
 							Integer.parseInt(split[0]),
 							recharge.getUserId(), sdcustomno);
 							out.println("<result>1</result>");
 				//	out.println("ok");
 				//	out.println("success");
 				} else {
 					out.println("支付失败,订单重复提交。");
 				}
 			} else {
 				out.println("支付失败,订单号出现异常。");
 			}
 		} else {
 			out.println("支付失败,MD5数据校验不通过.");
 		}
 	} else {
 		out.println("支付失败,交易失败。");
 	}
 %>