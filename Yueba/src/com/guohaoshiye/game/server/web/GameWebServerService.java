/*    */ package com.game.server.web;
/*    */ 
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebServiceClient(name="GameWebServerService", targetNamespace="http://web.server.game.com/", wsdlLocation="http://192.168.1.154:7005/ws?wsdl")
/*    */ public class GameWebServerService
/*    */   extends Service
/*    */ {
/*    */   private static final URL GAMEWEBSERVERSERVICE_WSDL_LOCATION;
/* 32 */   private static final Logger logger = Logger.getLogger(GameWebServerService.class.getName());
/*    */   
/*    */   static {
/* 35 */     URL url = null;
/*    */     
/*    */     try
/*    */     {
/* 39 */       URL baseUrl = GameWebServerService.class.getResource(".");
/* 40 */       url = new URL(baseUrl, "http://192.168.1.154:7005/ws?wsdl");
/*    */     } catch (MalformedURLException e) {
/* 42 */       logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.1.154:7005/ws?wsdl', retrying as a local file");
/* 43 */       logger.warning(e.getMessage());
/*    */     }
/* 45 */     GAMEWEBSERVERSERVICE_WSDL_LOCATION = url;
/*    */   }
/*    */   
/*    */   public GameWebServerService(URL wsdlLocation, QName serviceName) {
/* 49 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */   
/*    */   public GameWebServerService() {
/* 53 */     super(GAMEWEBSERVERSERVICE_WSDL_LOCATION, new QName("http://web.server.game.com/", "GameWebServerService"));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @WebEndpoint(name="GameWebServerPort")
/*    */   public GameWebServer getGameWebServerPort()
/*    */   {
/* 63 */     return (GameWebServer)super.getPort(new QName("http://web.server.game.com/", "GameWebServerPort"), GameWebServer.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\GameWebServerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */