package com.guohaoshiye.game.server.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="openServerResponse", propOrder={"_return"})
public class OpenServerResponse
{
  @XmlElement(name="return")
  protected boolean _return;
  
  public boolean isReturn()
  {
    return this._return;
  }

  public void setReturn(boolean value)
  {
    this._return = value;
  }
}

