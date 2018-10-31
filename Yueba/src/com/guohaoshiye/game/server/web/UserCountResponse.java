package com.guohaoshiye.game.server.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="userCountResponse", propOrder={"_return"})
public class UserCountResponse
{
  @XmlElement(name="return")
  protected Integer _return;

  public Integer getReturn()
  {
    return this._return;
  }


  public void setReturn(Integer value)
  {
    this._return = value;
  }
}

