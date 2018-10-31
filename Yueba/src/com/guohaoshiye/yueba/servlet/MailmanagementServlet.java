package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.MailmanagementDAO;
import com.guohaoshiye.yueba.dao.SystemLogDAO;
import com.guohaoshiye.yueba.entity.Admin;
import com.guohaoshiye.yueba.entity.SystemLog;
import com.guohaoshiye.yueba.entity.Users;
import com.guohaoshiye.yueba.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class MailmanagementServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private MailmanagementDAO dao = new MailmanagementDAO();
  private PrintWriter out = null;
  private SystemLogDAO sdao = new SystemLogDAO();

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
    if ("addMail".equals(op)) {
      addMail(request, response);
    }
  }

  private void addMail(HttpServletRequest request, HttpServletResponse response)
  {
    Timestamp d = new Timestamp(System.currentTimeMillis());
    int type = Integer.parseInt(request.getParameter("type"));
    String describe = request.getParameter("describe");
    SystemLog log = new SystemLog();
    HttpSession session = request.getSession();
    String ipClients = Util.getIpAddress(request);
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        log.setAid(((Admin)entry.getValue()).getId());
      }
    }
    String typeMsg = type == 0 ? "发送邮件-普通玩家(群体)" : "发送邮件-推广员玩家(群体)";
    log.setOperating(typeMsg);
    log.setContent(describe);
    log.setCreateTime(new Timestamp(System.currentTimeMillis()));
    this.sdao.save(log);
    String sql = "";
    if (type == 0) {
      sql = "select u.* from users AS u where id not in(select uid FROM proxy)";
    } else {
      sql = "select u.* from users AS u where id in(select uid FROM proxy)";
    }
    List<Users> list = this.dao.findAllUser(sql);
    this.dao.saveMail(d, list, describe);
    try {
      this.out = response.getWriter();
      this.out.print("ok");
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

