package com.guohaoshiye.game.server.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory
{
  private static final QName _AddGoldResponse_QNAME = new QName("http://web.server.game.com/", "addGoldResponse");
  private static final QName _CloseServer_QNAME = new QName("http://web.server.game.com/", "closeServer");
  private static final QName _OpenServer_QNAME = new QName("http://web.server.game.com/", "openServer");
  private static final QName _CloseServerResponse_QNAME = new QName("http://web.server.game.com/", "closeServerResponse");
  private static final QName _UpdateParameterResponse_QNAME = new QName("http://web.server.game.com/", "updateParameterResponse");
  private static final QName _BindingAgent_QNAME = new QName("http://web.server.game.com/", "bindingAgent");
  private static final QName _Message_QNAME = new QName("http://web.server.game.com/", "message");
  private static final QName _OpenServerResponse_QNAME = new QName("http://web.server.game.com/", "openServerResponse");
  private static final QName _Recharge_QNAME = new QName("http://web.server.game.com/", "recharge");
  private static final QName _UpdateParameter_QNAME = new QName("http://web.server.game.com/", "updateParameter");
  private static final QName _CheckUserOnLineResponse_QNAME = new QName("http://web.server.game.com/", "checkUserOnLineResponse");
  private static final QName _CheckUserOnLine_QNAME = new QName("http://web.server.game.com/", "checkUserOnLine");
  private static final QName _MessageResponse_QNAME = new QName("http://web.server.game.com/", "messageResponse");
  private static final QName _UserCountResponse_QNAME = new QName("http://web.server.game.com/", "userCountResponse");
  private static final QName _Give_QNAME = new QName("http://web.server.game.com/", "Give");
  private static final QName _RechargeResponse_QNAME = new QName("http://web.server.game.com/", "rechargeResponse");
  private static final QName _UserCount_QNAME = new QName("http://web.server.game.com/", "userCount");
  private static final QName _GiveResponse_QNAME = new QName("http://web.server.game.com/", "GiveResponse");
  private static final QName _AddGold_QNAME = new QName("http://web.server.game.com/", "addGold");
  private static final QName _BindingAgentResponse_QNAME = new QName("http://web.server.game.com/", "bindingAgentResponse");
  private static final QName _GetServerStatusResponse_QNAME = new QName("http://web.server.game.com/", "getServerStatusResponse");
  private static final QName _GetServerStatus_QNAME = new QName("http://web.server.game.com/", "getServerStatus");
  private static final QName _MailNoticeResponse_QNAME = new QName("http://web.server.game.com/", "mailNoticeResponse");
  private static final QName _MailNotice_QNAME = new QName("http://web.server.game.com/", "mailNotice");
  

  public UpdateParameter createUpdateParameter()
  {
    return new UpdateParameter();
  }
  



  public UserCountResponse createUserCountResponse()
  {
    return new UserCountResponse();
  }
  



  public BindingAgentResponse createBindingAgentResponse()
  {
    return new BindingAgentResponse();
  }
  



  public GiveResponse createGiveResponse()
  {
    return new GiveResponse();
  }
  



  public MailNotice createMailNotice()
  {
    return new MailNotice();
  }
  



  public CheckUserOnLine createCheckUserOnLine()
  {
    return new CheckUserOnLine();
  }
  



  public CheckUserOnLineResponse createCheckUserOnLineResponse()
  {
    return new CheckUserOnLineResponse();
  }
  



  public UserCount createUserCount()
  {
    return new UserCount();
  }
  



  public AddGold createAddGold()
  {
    return new AddGold();
  }
  



  public MailNoticeResponse createMailNoticeResponse()
  {
    return new MailNoticeResponse();
  }
  



  public Give createGive()
  {
    return new Give();
  }
  



  public CloseServerResponse createCloseServerResponse()
  {
    return new CloseServerResponse();
  }
  



  public OpenServerResponse createOpenServerResponse()
  {
    return new OpenServerResponse();
  }
  



  public RechargeResponse createRechargeResponse()
  {
    return new RechargeResponse();
  }
  



  public Message createMessage()
  {
    return new Message();
  }
  



  public OpenServer createOpenServer()
  {
    return new OpenServer();
  }
  



  public Recharge createRecharge()
  {
    return new Recharge();
  }
  



  public AddGoldResponse createAddGoldResponse()
  {
    return new AddGoldResponse();
  }
  



  public CloseServer createCloseServer()
  {
    return new CloseServer();
  }
  



  public GetServerStatus createGetServerStatus()
  {
    return new GetServerStatus();
  }
  



  public MessageResponse createMessageResponse()
  {
    return new MessageResponse();
  }
  



  public UpdateParameterResponse createUpdateParameterResponse()
  {
    return new UpdateParameterResponse();
  }
  



  public GetServerStatusResponse createGetServerStatusResponse()
  {
    return new GetServerStatusResponse();
  }
  



  public BindingAgent createBindingAgent()
  {
    return new BindingAgent();
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="addGoldResponse")
  public JAXBElement<AddGoldResponse> createAddGoldResponse(AddGoldResponse value)
  {
    return new JAXBElement(_AddGoldResponse_QNAME, AddGoldResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="closeServer")
  public JAXBElement<CloseServer> createCloseServer(CloseServer value)
  {
    return new JAXBElement(_CloseServer_QNAME, CloseServer.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="openServer")
  public JAXBElement<OpenServer> createOpenServer(OpenServer value)
  {
    return new JAXBElement(_OpenServer_QNAME, OpenServer.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="closeServerResponse")
  public JAXBElement<CloseServerResponse> createCloseServerResponse(CloseServerResponse value)
  {
    return new JAXBElement(_CloseServerResponse_QNAME, CloseServerResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="updateParameterResponse")
  public JAXBElement<UpdateParameterResponse> createUpdateParameterResponse(UpdateParameterResponse value)
  {
    return new JAXBElement(_UpdateParameterResponse_QNAME, UpdateParameterResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="bindingAgent")
  public JAXBElement<BindingAgent> createBindingAgent(BindingAgent value)
  {
    return new JAXBElement(_BindingAgent_QNAME, BindingAgent.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="message")
  public JAXBElement<Message> createMessage(Message value)
  {
    return new JAXBElement(_Message_QNAME, Message.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="openServerResponse")
  public JAXBElement<OpenServerResponse> createOpenServerResponse(OpenServerResponse value)
  {
    return new JAXBElement(_OpenServerResponse_QNAME, OpenServerResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="recharge")
  public JAXBElement<Recharge> createRecharge(Recharge value)
  {
    return new JAXBElement(_Recharge_QNAME, Recharge.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="updateParameter")
  public JAXBElement<UpdateParameter> createUpdateParameter(UpdateParameter value)
  {
    return new JAXBElement(_UpdateParameter_QNAME, UpdateParameter.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="checkUserOnLineResponse")
  public JAXBElement<CheckUserOnLineResponse> createCheckUserOnLineResponse(CheckUserOnLineResponse value)
  {
    return new JAXBElement(_CheckUserOnLineResponse_QNAME, CheckUserOnLineResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="checkUserOnLine")
  public JAXBElement<CheckUserOnLine> createCheckUserOnLine(CheckUserOnLine value)
  {
    return new JAXBElement(_CheckUserOnLine_QNAME, CheckUserOnLine.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="messageResponse")
  public JAXBElement<MessageResponse> createMessageResponse(MessageResponse value)
  {
    return new JAXBElement(_MessageResponse_QNAME, MessageResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="userCountResponse")
  public JAXBElement<UserCountResponse> createUserCountResponse(UserCountResponse value)
  {
    return new JAXBElement(_UserCountResponse_QNAME, UserCountResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="Give")
  public JAXBElement<Give> createGive(Give value)
  {
    return new JAXBElement(_Give_QNAME, Give.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="rechargeResponse")
  public JAXBElement<RechargeResponse> createRechargeResponse(RechargeResponse value)
  {
    return new JAXBElement(_RechargeResponse_QNAME, RechargeResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="userCount")
  public JAXBElement<UserCount> createUserCount(UserCount value)
  {
    return new JAXBElement(_UserCount_QNAME, UserCount.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="GiveResponse")
  public JAXBElement<GiveResponse> createGiveResponse(GiveResponse value)
  {
    return new JAXBElement(_GiveResponse_QNAME, GiveResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="addGold")
  public JAXBElement<AddGold> createAddGold(AddGold value)
  {
    return new JAXBElement(_AddGold_QNAME, AddGold.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="bindingAgentResponse")
  public JAXBElement<BindingAgentResponse> createBindingAgentResponse(BindingAgentResponse value)
  {
    return new JAXBElement(_BindingAgentResponse_QNAME, BindingAgentResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="getServerStatusResponse")
  public JAXBElement<GetServerStatusResponse> createGetServerStatusResponse(GetServerStatusResponse value)
  {
    return new JAXBElement(_GetServerStatusResponse_QNAME, GetServerStatusResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="getServerStatus")
  public JAXBElement<GetServerStatus> createGetServerStatus(GetServerStatus value)
  {
    return new JAXBElement(_GetServerStatus_QNAME, GetServerStatus.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="mailNoticeResponse")
  public JAXBElement<MailNoticeResponse> createMailNoticeResponse(MailNoticeResponse value)
  {
    return new JAXBElement(_MailNoticeResponse_QNAME, MailNoticeResponse.class, null, value);
  }
  



  @XmlElementDecl(namespace="http://web.server.game.com/", name="mailNotice")
  public JAXBElement<MailNotice> createMailNotice(MailNotice value)
  {
    return new JAXBElement(_MailNotice_QNAME, MailNotice.class, null, value);
  }
}


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\ObjectFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */