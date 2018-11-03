package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminDAO;
import com.guohaoshiye.yueba.dao.MailmanagementDAO;
import com.guohaoshiye.yueba.dao.ParameterDAO;
import com.guohaoshiye.yueba.dao.ProxyDAO;
import com.guohaoshiye.yueba.dao.ProxytoexamineLogDAO;
import com.guohaoshiye.yueba.dao.UsersDAO;
import com.guohaoshiye.yueba.entity_olddemo.ProxytoexamineLog;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;



public class ProxytoexamineLogServlet
  extends HttpServlet
{
  private ProxytoexamineLogDAO dao = new ProxytoexamineLogDAO();
  private ProxyDAO pdao = new ProxyDAO();
  private UsersDAO udao = new UsersDAO();
  private AdminDAO adao = new AdminDAO();
  private ParameterDAO padao = new ParameterDAO();
  private MailmanagementDAO mdao = new MailmanagementDAO();
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String op = request.getParameter("op");


    if ("listProxytoexamineLog".equals(op)) {
      listProxytoexamineLog(request, response);
    }
  }






  private void listProxytoexamineLog(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    Integer proxyOp1 = Integer.valueOf(0);
    String[] splits = comp.split(",");
    proxyOp1 = Integer.valueOf(Integer.parseInt(splits[0]));

    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "uid", "pid", "phone", "begin", "end", "weixinhao" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<ProxytoexamineLog> pm = this.dao.sqlLoglist(currentPage, pageSize, param, paramValue);
    List<ProxytoexamineLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    request.setAttribute("comp", comp);
    request.setAttribute("proxyOp1", proxyOp1);
    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/proxyshenqing_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

