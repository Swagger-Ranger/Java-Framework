package com.guohaoshiye.yueba.servlet;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RechargeFaSongServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String op = request.getParameter("op");
    if ("rechargefasong".equals(op)) {
      rechargefasong(request, response);
    }
  }

  private void rechargefasong(HttpServletRequest request, HttpServletResponse response)
  {
    System.out.println("支付来了~~~~~~~~~~~~~~~~~~");


    request.setAttribute("flag", request.getParameter("p8_sign"));
    request.setAttribute("p14_customname", request.getParameter("p14_customname"));
    request.setAttribute("p16_customip", request.getParameter("p16_customip"));
    request.setAttribute("p25_treminal", request.getParameter("p25_treminal"));
    request.setAttribute("url", "http://order.z.jtpay.com/jh-web-order/order.receiveOrder");
    try {
      request.getRequestDispatcher("right/rechargefasong.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}

