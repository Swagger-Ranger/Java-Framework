package com.guohaoshiye.game.server.web;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name="GameWebServer", targetNamespace="http://web.server.game.com/")
public abstract interface GameWebServer
{
  @WebMethod
  @RequestWrapper(localName="message", targetNamespace="http://web.server.game.com/", className="com.game.server.web.Message")
  @ResponseWrapper(localName="messageResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.MessageResponse")
  public abstract void message(@WebParam(name="arg0", targetNamespace="") String paramString, @WebParam(name="arg1", targetNamespace="") int paramInt);
  
  @WebMethod(operationName="Give")
  @RequestWrapper(localName="Give", targetNamespace="http://web.server.game.com/", className="com.game.server.web.Give")
  @ResponseWrapper(localName="GiveResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.GiveResponse")
  public abstract void give(@WebParam(name="arg0", targetNamespace="") List<Integer> paramList, @WebParam(name="arg1", targetNamespace="") int paramInt1, @WebParam(name="arg2", targetNamespace="") int paramInt2);
  
  @WebMethod
  @RequestWrapper(localName="updateParameter", targetNamespace="http://web.server.game.com/", className="com.game.server.web.UpdateParameter")
  @ResponseWrapper(localName="updateParameterResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.UpdateParameterResponse")
  public abstract void updateParameter(@WebParam(name="arg0", targetNamespace="") String paramString1, @WebParam(name="arg1", targetNamespace="") String paramString2);
  
  @WebMethod
  @RequestWrapper(localName="recharge", targetNamespace="http://web.server.game.com/", className="com.game.server.web.Recharge")
  @ResponseWrapper(localName="rechargeResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.RechargeResponse")
  public abstract void recharge(@WebParam(name="arg0", targetNamespace="") Integer paramInteger1, @WebParam(name="arg1", targetNamespace="") Integer paramInteger2, @WebParam(name="arg2", targetNamespace="") String paramString);
  
  @WebMethod
  @WebResult(targetNamespace="")
  @RequestWrapper(localName="checkUserOnLine", targetNamespace="http://web.server.game.com/", className="com.game.server.web.CheckUserOnLine")
  @ResponseWrapper(localName="checkUserOnLineResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.CheckUserOnLineResponse")
  public abstract String checkUserOnLine(@WebParam(name="arg0", targetNamespace="") String paramString);
  
  @WebMethod
  @WebResult(targetNamespace="")
  @RequestWrapper(localName="closeRoom", targetNamespace="http://web.server.game.com/", className="com.game.server.web.CloseRoom")
  @ResponseWrapper(localName="closeRoomResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.CloseRoomResponse")
  public abstract boolean closeRoom(@WebParam(name="arg0", targetNamespace="") int paramInt);
  
  @WebMethod
  @WebResult(targetNamespace="")
  @RequestWrapper(localName="userCount", targetNamespace="http://web.server.game.com/", className="com.game.server.web.UserCount")
  @ResponseWrapper(localName="userCountResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.UserCountResponse")
  public abstract Integer userCount();
  
  @WebMethod
  @RequestWrapper(localName="bindingAgent", targetNamespace="http://web.server.game.com/", className="com.game.server.web.BindingAgent")
  @ResponseWrapper(localName="bindingAgentResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.BindingAgentResponse")
  public abstract void bindingAgent(@WebParam(name="arg0", targetNamespace="") String paramString1, @WebParam(name="arg1", targetNamespace="") String paramString2, @WebParam(name="arg2", targetNamespace="") String paramString3, @WebParam(name="arg3", targetNamespace="") Byte paramByte, @WebParam(name="arg4", targetNamespace="") int paramInt);
  
  @WebMethod
  @RequestWrapper(localName="mailNotice", targetNamespace="http://web.server.game.com/", className="com.game.server.web.MailNotice")
  @ResponseWrapper(localName="mailNoticeResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.MailNoticeResponse")
  public abstract void mailNotice(@WebParam(name="arg0", targetNamespace="") int paramInt);
  
  @WebMethod
  @RequestWrapper(localName="addGold", targetNamespace="http://web.server.game.com/", className="com.game.server.web.AddGold")
  @ResponseWrapper(localName="addGoldResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.AddGoldResponse")
  public abstract void addGold(@WebParam(name="arg0", targetNamespace="") Integer paramInteger1, @WebParam(name="arg1", targetNamespace="") Integer paramInteger2, @WebParam(name="arg2", targetNamespace="") int paramInt);
  
  @WebMethod
  @WebResult(targetNamespace="")
  @RequestWrapper(localName="getServerStatus", targetNamespace="http://web.server.game.com/", className="com.game.server.web.GetServerStatus")
  @ResponseWrapper(localName="getServerStatusResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.GetServerStatusResponse")
  public abstract boolean getServerStatus();
  
  @WebMethod
  @WebResult(targetNamespace="")
  @RequestWrapper(localName="openServer", targetNamespace="http://web.server.game.com/", className="com.game.server.web.OpenServer")
  @ResponseWrapper(localName="openServerResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.OpenServerResponse")
  public abstract boolean openServer();
  
  @WebMethod
  @WebResult(targetNamespace="")
  @RequestWrapper(localName="closeServer", targetNamespace="http://web.server.game.com/", className="com.game.server.web.CloseServer")
  @ResponseWrapper(localName="closeServerResponse", targetNamespace="http://web.server.game.com/", className="com.game.server.web.CloseServerResponse")
  public abstract boolean closeServer();
}


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\GameWebServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */