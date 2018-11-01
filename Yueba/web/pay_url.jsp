<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.net.MalformedURLException"%>
<%@ page import="java.net.URL"%>
<%@ page import="javax.xml.namespace.QName"%>
<%@ page import="com.guohaoshiye.yueba.util.Util"%>
<%@ page import="com.guohaoshiye.yueba.util.MD5Tool"%>
<%@ page import="com.guohaoshiye.yueba.dao.RechargeDAO"%>
<%@ page import="com.guohaoshiye.yueba.entity.Recharge"%>
<%@ page import="com.guohaoshiye.yueba.dao.ParameterDAO"%>
<%@ page import="com.guohaoshiye.yueba.entity.Parameter"%>
<%@ page import="com.guohaoshiye.game.server.web.*"%>
<%
	System.out.println("已进入支付回调。。");
	System.out.println("参数获取开始。。"+request.getParameter("p1_yingyong"));
	Enumeration en = request.getParameterNames();  
	while(en.hasMoreElements()){  
    String el = en.nextElement().toString();  
    System.out.println("||||"+el+"="+request.getParameter(el));  
} 
	

	String p1_yingyongnum = new String(request.getParameter("p1_yingyongnum"));
	//商户请求交易时候提交的订单号
	String p2_ordernumber = new String(request.getParameter("p2_ordernumber"));
	//实际交易交易金额
	String p3_money = new String(request.getParameter("p3_money"));
	
	String p4_zfstate = new String(request.getParameter("p4_zfstate"));
	
	String p5_orderid = new String(request.getParameter("p5_orderid"));
	String p6_productcode= new String(request.getParameter("p6_productcode").getBytes("ISO-8859-1"),"UTF-8");
	String p7_bank_card_code= new String(request.getParameter("p7_bank_card_code"));
	String p8_charset= new String(request.getParameter("p8_charset"));
	String p9_signtype= new String(request.getParameter("p9_signtype"));
	String p11_pdesc= new String(request.getParameter("p11_pdesc"));
	String p10_sign = new String(request.getParameter("p10_sign"));
	
	//MD5加密数据
	String sign =p1_yingyongnum+"&"+p2_ordernumber+"&"+p3_money+"&"+p4_zfstate+"&"+p5_orderid+"&"+p6_productcode+"&"+p7_bank_card_code+"&"+p8_charset+"&"+p9_signtype+"&"+p11_pdesc+"&040109162509lFJBwoqU";
	
	
	//String strmd5 = "p4_zfstate="+p4_zfstate+"&bargainor_id="+bargainor_id+"&sp_billno="+sp_billno+"&total_fee="+total_fee+"&attach="+attach+"&key=c5dba3f5a342717fffb7b72e614a211c";
	
	
	System.out.println("参数获取完毕。。");
	if("1".equals(p4_zfstate)){
		System.out.println(p10_sign);
		System.out.println(MD5Tool.encoding(sign).toUpperCase());
		System.out.println("交易结果成功。。。");
		if(p10_sign.equals(MD5Tool.encoding(sign).toUpperCase())){
			System.out.println("MD5验证通过。。");
			RechargeDAO dao = new RechargeDAO();
			List<Recharge> recharges = dao.findByHQL("from Recharge where order=?", p2_ordernumber);
			Recharge recharge = new Recharge();
			if(recharges.size()>0){
				System.out.println("正在准备订单修改状态。。");
				 recharge = recharges.get(0);
				 if(recharge.getStatus()==-1){
					 recharge.setStatus(0);
					 dao.update(recharge);
					 ParameterDAO pdao = new ParameterDAO();
					 Parameter p = pdao.findByHQL("from Parameter where name=?", "webService").get(0);
					 System.out.println("订单状态已修改。。");
					 GameWebServerService wb = null;
						try {
							wb = new GameWebServerService(new URL(p.getValue()),
									new QName("http://web.server.game.com/", "GameWebServerService"));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
						String[] split = p3_money.split("\\.");
						wb.getGameWebServerPort().recharge(Integer.parseInt(split[0]), recharge.getUserId(), p2_ordernumber);
						//out.println("ok");
						out.println("success");
				 }else{
					out.println("支付失败,订单重复提交。");
				 }
			}else{
				out.println("支付失败,订单号出现异常。");
			}
		}else{
			out.println("支付失败,MD5数据校验不通过.");
		}
	}else{
		out.println("支付失败,交易失败。");
	}
%>