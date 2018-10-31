package com.guohaoshiye.game.server.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="updateParameter", propOrder={"arg0", "arg1"})
public class UpdateParameter
{
  protected String arg0;
  protected String arg1;

  public String getArg0()
  {
    return this.arg0;
  }


  public void setArg0(String value)
  {
    this.arg0 = value;
  }


  public String getArg1()
  {
    return this.arg1;
  }


  public void setArg1(String value)
  {
    this.arg1 = value;
  }
}

