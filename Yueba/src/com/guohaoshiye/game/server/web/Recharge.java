package com.guohaoshiye.game.server.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="recharge", propOrder={"arg0", "arg1", "arg2"})
public class Recharge
{
  protected Integer arg0;
  protected Integer arg1;
  protected String arg2;

  public Integer getArg0()
  {
    return this.arg0;
  }

  public void setArg0(Integer value)
  {
    this.arg0 = value;
  }

  public Integer getArg1()
  {
    return this.arg1;
  }


  public void setArg1(Integer value)
  {
    this.arg1 = value;
  }



  public String getArg2()
  {
    return this.arg2;
  }


  public void setArg2(String value)
  {
    this.arg2 = value;
  }
}

