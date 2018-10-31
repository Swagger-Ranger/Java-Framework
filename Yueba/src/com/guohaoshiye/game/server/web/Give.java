package com.guohaoshiye.game.server.web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;





@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Give", propOrder={"arg0", "arg1", "arg2"})
public class Give
{
  @XmlElement(nillable=true)
  protected List<Integer> arg0;
  protected int arg1;
  protected int arg2;

  public List<Integer> getArg0()
  {
    if (this.arg0 == null) {
      this.arg0 = new ArrayList();
    }
    return this.arg0;
  }




  public int getArg1()
  {
    return this.arg1;
  }




  public void setArg1(int value)
  {
    this.arg1 = value;
  }




  public int getArg2()
  {
    return this.arg2;
  }




  public void setArg2(int value)
  {
    this.arg2 = value;
  }
}

