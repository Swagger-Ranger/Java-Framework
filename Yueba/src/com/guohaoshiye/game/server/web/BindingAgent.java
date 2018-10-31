 package com.guohaoshiye.game.server.web;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="bindingAgent", propOrder={"arg0", "arg1", "arg2", "arg3", "arg4"})
 public class BindingAgent
 {
   protected String arg0;
   protected String arg1;
   protected String arg2;
   protected Byte arg3;
   protected int arg4;

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

   public String getArg2()
   {
     return this.arg2;
   }

   public void setArg2(String value)
   {
     this.arg2 = value;
   }

   public Byte getArg3()
   {
     return this.arg3;
   }

   public void setArg3(Byte value)
   {
     this.arg3 = value;
   }




   public int getArg4()
   {
     return this.arg4;
   }




   public void setArg4(int value)
   {
     this.arg4 = value;
   }
 }
