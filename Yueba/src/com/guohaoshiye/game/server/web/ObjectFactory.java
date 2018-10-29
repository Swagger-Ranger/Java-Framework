/*     */ package com.game.server.web;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  27 */   private static final QName _AddGoldResponse_QNAME = new QName("http://web.server.game.com/", "addGoldResponse");
/*  28 */   private static final QName _CloseServer_QNAME = new QName("http://web.server.game.com/", "closeServer");
/*  29 */   private static final QName _OpenServer_QNAME = new QName("http://web.server.game.com/", "openServer");
/*  30 */   private static final QName _CloseServerResponse_QNAME = new QName("http://web.server.game.com/", "closeServerResponse");
/*  31 */   private static final QName _UpdateParameterResponse_QNAME = new QName("http://web.server.game.com/", "updateParameterResponse");
/*  32 */   private static final QName _BindingAgent_QNAME = new QName("http://web.server.game.com/", "bindingAgent");
/*  33 */   private static final QName _Message_QNAME = new QName("http://web.server.game.com/", "message");
/*  34 */   private static final QName _OpenServerResponse_QNAME = new QName("http://web.server.game.com/", "openServerResponse");
/*  35 */   private static final QName _Recharge_QNAME = new QName("http://web.server.game.com/", "recharge");
/*  36 */   private static final QName _UpdateParameter_QNAME = new QName("http://web.server.game.com/", "updateParameter");
/*  37 */   private static final QName _CheckUserOnLineResponse_QNAME = new QName("http://web.server.game.com/", "checkUserOnLineResponse");
/*  38 */   private static final QName _CheckUserOnLine_QNAME = new QName("http://web.server.game.com/", "checkUserOnLine");
/*  39 */   private static final QName _MessageResponse_QNAME = new QName("http://web.server.game.com/", "messageResponse");
/*  40 */   private static final QName _UserCountResponse_QNAME = new QName("http://web.server.game.com/", "userCountResponse");
/*  41 */   private static final QName _Give_QNAME = new QName("http://web.server.game.com/", "Give");
/*  42 */   private static final QName _RechargeResponse_QNAME = new QName("http://web.server.game.com/", "rechargeResponse");
/*  43 */   private static final QName _UserCount_QNAME = new QName("http://web.server.game.com/", "userCount");
/*  44 */   private static final QName _GiveResponse_QNAME = new QName("http://web.server.game.com/", "GiveResponse");
/*  45 */   private static final QName _AddGold_QNAME = new QName("http://web.server.game.com/", "addGold");
/*  46 */   private static final QName _BindingAgentResponse_QNAME = new QName("http://web.server.game.com/", "bindingAgentResponse");
/*  47 */   private static final QName _GetServerStatusResponse_QNAME = new QName("http://web.server.game.com/", "getServerStatusResponse");
/*  48 */   private static final QName _GetServerStatus_QNAME = new QName("http://web.server.game.com/", "getServerStatus");
/*  49 */   private static final QName _MailNoticeResponse_QNAME = new QName("http://web.server.game.com/", "mailNoticeResponse");
/*  50 */   private static final QName _MailNotice_QNAME = new QName("http://web.server.game.com/", "mailNotice");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public UpdateParameter createUpdateParameter()
/*     */   {
/*  64 */     return new UpdateParameter();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public UserCountResponse createUserCountResponse()
/*     */   {
/*  72 */     return new UserCountResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BindingAgentResponse createBindingAgentResponse()
/*     */   {
/*  80 */     return new BindingAgentResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GiveResponse createGiveResponse()
/*     */   {
/*  88 */     return new GiveResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MailNotice createMailNotice()
/*     */   {
/*  96 */     return new MailNotice();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CheckUserOnLine createCheckUserOnLine()
/*     */   {
/* 104 */     return new CheckUserOnLine();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CheckUserOnLineResponse createCheckUserOnLineResponse()
/*     */   {
/* 112 */     return new CheckUserOnLineResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public UserCount createUserCount()
/*     */   {
/* 120 */     return new UserCount();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AddGold createAddGold()
/*     */   {
/* 128 */     return new AddGold();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MailNoticeResponse createMailNoticeResponse()
/*     */   {
/* 136 */     return new MailNoticeResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Give createGive()
/*     */   {
/* 144 */     return new Give();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CloseServerResponse createCloseServerResponse()
/*     */   {
/* 152 */     return new CloseServerResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public OpenServerResponse createOpenServerResponse()
/*     */   {
/* 160 */     return new OpenServerResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public RechargeResponse createRechargeResponse()
/*     */   {
/* 168 */     return new RechargeResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Message createMessage()
/*     */   {
/* 176 */     return new Message();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public OpenServer createOpenServer()
/*     */   {
/* 184 */     return new OpenServer();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Recharge createRecharge()
/*     */   {
/* 192 */     return new Recharge();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AddGoldResponse createAddGoldResponse()
/*     */   {
/* 200 */     return new AddGoldResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CloseServer createCloseServer()
/*     */   {
/* 208 */     return new CloseServer();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GetServerStatus createGetServerStatus()
/*     */   {
/* 216 */     return new GetServerStatus();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MessageResponse createMessageResponse()
/*     */   {
/* 224 */     return new MessageResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public UpdateParameterResponse createUpdateParameterResponse()
/*     */   {
/* 232 */     return new UpdateParameterResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GetServerStatusResponse createGetServerStatusResponse()
/*     */   {
/* 240 */     return new GetServerStatusResponse();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BindingAgent createBindingAgent()
/*     */   {
/* 248 */     return new BindingAgent();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="addGoldResponse")
/*     */   public JAXBElement<AddGoldResponse> createAddGoldResponse(AddGoldResponse value)
/*     */   {
/* 257 */     return new JAXBElement(_AddGoldResponse_QNAME, AddGoldResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="closeServer")
/*     */   public JAXBElement<CloseServer> createCloseServer(CloseServer value)
/*     */   {
/* 266 */     return new JAXBElement(_CloseServer_QNAME, CloseServer.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="openServer")
/*     */   public JAXBElement<OpenServer> createOpenServer(OpenServer value)
/*     */   {
/* 275 */     return new JAXBElement(_OpenServer_QNAME, OpenServer.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="closeServerResponse")
/*     */   public JAXBElement<CloseServerResponse> createCloseServerResponse(CloseServerResponse value)
/*     */   {
/* 284 */     return new JAXBElement(_CloseServerResponse_QNAME, CloseServerResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="updateParameterResponse")
/*     */   public JAXBElement<UpdateParameterResponse> createUpdateParameterResponse(UpdateParameterResponse value)
/*     */   {
/* 293 */     return new JAXBElement(_UpdateParameterResponse_QNAME, UpdateParameterResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="bindingAgent")
/*     */   public JAXBElement<BindingAgent> createBindingAgent(BindingAgent value)
/*     */   {
/* 302 */     return new JAXBElement(_BindingAgent_QNAME, BindingAgent.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="message")
/*     */   public JAXBElement<Message> createMessage(Message value)
/*     */   {
/* 311 */     return new JAXBElement(_Message_QNAME, Message.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="openServerResponse")
/*     */   public JAXBElement<OpenServerResponse> createOpenServerResponse(OpenServerResponse value)
/*     */   {
/* 320 */     return new JAXBElement(_OpenServerResponse_QNAME, OpenServerResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="recharge")
/*     */   public JAXBElement<Recharge> createRecharge(Recharge value)
/*     */   {
/* 329 */     return new JAXBElement(_Recharge_QNAME, Recharge.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="updateParameter")
/*     */   public JAXBElement<UpdateParameter> createUpdateParameter(UpdateParameter value)
/*     */   {
/* 338 */     return new JAXBElement(_UpdateParameter_QNAME, UpdateParameter.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="checkUserOnLineResponse")
/*     */   public JAXBElement<CheckUserOnLineResponse> createCheckUserOnLineResponse(CheckUserOnLineResponse value)
/*     */   {
/* 347 */     return new JAXBElement(_CheckUserOnLineResponse_QNAME, CheckUserOnLineResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="checkUserOnLine")
/*     */   public JAXBElement<CheckUserOnLine> createCheckUserOnLine(CheckUserOnLine value)
/*     */   {
/* 356 */     return new JAXBElement(_CheckUserOnLine_QNAME, CheckUserOnLine.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="messageResponse")
/*     */   public JAXBElement<MessageResponse> createMessageResponse(MessageResponse value)
/*     */   {
/* 365 */     return new JAXBElement(_MessageResponse_QNAME, MessageResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="userCountResponse")
/*     */   public JAXBElement<UserCountResponse> createUserCountResponse(UserCountResponse value)
/*     */   {
/* 374 */     return new JAXBElement(_UserCountResponse_QNAME, UserCountResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="Give")
/*     */   public JAXBElement<Give> createGive(Give value)
/*     */   {
/* 383 */     return new JAXBElement(_Give_QNAME, Give.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="rechargeResponse")
/*     */   public JAXBElement<RechargeResponse> createRechargeResponse(RechargeResponse value)
/*     */   {
/* 392 */     return new JAXBElement(_RechargeResponse_QNAME, RechargeResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="userCount")
/*     */   public JAXBElement<UserCount> createUserCount(UserCount value)
/*     */   {
/* 401 */     return new JAXBElement(_UserCount_QNAME, UserCount.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="GiveResponse")
/*     */   public JAXBElement<GiveResponse> createGiveResponse(GiveResponse value)
/*     */   {
/* 410 */     return new JAXBElement(_GiveResponse_QNAME, GiveResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="addGold")
/*     */   public JAXBElement<AddGold> createAddGold(AddGold value)
/*     */   {
/* 419 */     return new JAXBElement(_AddGold_QNAME, AddGold.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="bindingAgentResponse")
/*     */   public JAXBElement<BindingAgentResponse> createBindingAgentResponse(BindingAgentResponse value)
/*     */   {
/* 428 */     return new JAXBElement(_BindingAgentResponse_QNAME, BindingAgentResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="getServerStatusResponse")
/*     */   public JAXBElement<GetServerStatusResponse> createGetServerStatusResponse(GetServerStatusResponse value)
/*     */   {
/* 437 */     return new JAXBElement(_GetServerStatusResponse_QNAME, GetServerStatusResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="getServerStatus")
/*     */   public JAXBElement<GetServerStatus> createGetServerStatus(GetServerStatus value)
/*     */   {
/* 446 */     return new JAXBElement(_GetServerStatus_QNAME, GetServerStatus.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="mailNoticeResponse")
/*     */   public JAXBElement<MailNoticeResponse> createMailNoticeResponse(MailNoticeResponse value)
/*     */   {
/* 455 */     return new JAXBElement(_MailNoticeResponse_QNAME, MailNoticeResponse.class, null, value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @XmlElementDecl(namespace="http://web.server.game.com/", name="mailNotice")
/*     */   public JAXBElement<MailNotice> createMailNotice(MailNotice value)
/*     */   {
/* 464 */     return new JAXBElement(_MailNotice_QNAME, MailNotice.class, null, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\game\server\web\ObjectFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */