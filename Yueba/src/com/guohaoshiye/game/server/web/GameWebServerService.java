package com.guohaoshiye.game.server.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

















@WebServiceClient(name="GameWebServerService", targetNamespace="http://web.server.game.com/", wsdlLocation="http://192.168.1.154:7005/ws?wsdl")
public class GameWebServerService
  extends Service
{
  private static final URL GAMEWEBSERVERSERVICE_WSDL_LOCATION;
  private static final Logger logger = Logger.getLogger(GameWebServerService.class.getName());

  static {
    URL url = null;

    try
    {
      URL baseUrl = GameWebServerService.class.getResource(".");
      url = new URL(baseUrl, "http://192.168.1.154:7005/ws?wsdl");
    } catch (MalformedURLException e) {
      logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.1.154:7005/ws?wsdl', retrying as a local file");
      logger.warning(e.getMessage());
    }
    GAMEWEBSERVERSERVICE_WSDL_LOCATION = url;
  }

  public GameWebServerService(URL wsdlLocation, QName serviceName) {
    super(wsdlLocation, serviceName);
  }

  public GameWebServerService() {
    super(GAMEWEBSERVERSERVICE_WSDL_LOCATION, new QName("http://web.server.game.com/", "GameWebServerService"));
  }





  @WebEndpoint(name="GameWebServerPort")
  public GameWebServer getGameWebServerPort()
  {
    return (GameWebServer)super.getPort(new QName("http://web.server.game.com/", "GameWebServerPort"), GameWebServer.class);
  }
}

