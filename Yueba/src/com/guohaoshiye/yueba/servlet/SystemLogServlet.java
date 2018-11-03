package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.SystemLogDAO;
import com.guohaoshiye.yueba.entity_olddemo.SystemLog;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SystemLogServlet
  extends HttpServlet
{
  private String flag = "";
  private SystemLogDAO dao = new SystemLogDAO();
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
    if ("loglist".equals(op)) {
      loglist(request, response);
    }
  }







  private void loglist(HttpServletRequest request, HttpServletResponse response)
  {
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "aid", "begin", "end", "operating" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<SystemLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
    List<SystemLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/sysadmin_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

