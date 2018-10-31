package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.util.VerifyCodeUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthImageServlet
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
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0L);
    response.setContentType("image/jpeg");


    String verifyCode = VerifyCodeUtils.generateVerifyCode(4);

    HttpSession session = request.getSession(true);

    session.removeAttribute("zyzm");
    session.setAttribute("zyzm", verifyCode.toLowerCase());

    int w = 116;int h = 36;
    VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
  }
}

