package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminDAO;
import com.guohaoshiye.yueba.dao.AdminRechargeLogDAO;
import com.guohaoshiye.yueba.dao.UsersDAO;
import com.guohaoshiye.yueba.entity.Admin;
import com.guohaoshiye.yueba.entity.AdminRechargeLog;
import com.guohaoshiye.yueba.entity.Users;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

public class AdminRechargeLogServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private AdminRechargeLogDAO dao = new AdminRechargeLogDAO();
  private UsersDAO udao = new UsersDAO();
  private AdminDAO adao = new AdminDAO();
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String op = request.getParameter("op");
    if ("adminRechargeLogList".equals(op)) {
      adminRechargeLogList(request, response);
    }
  }







  private void adminRechargeLogList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "uid", "aid", "rtype", "money", "begin", "end" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<AdminRechargeLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
    String jbsum = this.dao.findSqlSum("select cast(IFNULL(SUM(money),0) as decimal(18,2)) from admin_recharge_log where rtype=1");
    String zssum = this.dao.findSqlSum("select cast(IFNULL(SUM(money),0) as decimal(18,2)) from admin_recharge_log where rtype=2");
    String jfsum = this.dao.findSqlSum("select cast(IFNULL(SUM(money),0) as decimal(18,2)) from admin_recharge_log where rtype=3");
    List<AdminRechargeLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    List<Users> ulist = this.udao.findByHQL("from Users", null);
    List<Admin> alist = this.adao.findByHQL("from Admin", null);
    request.setAttribute("comp", comp);
    request.setAttribute("ulist", ulist);
    request.setAttribute("alist", alist);
    request.setAttribute("jbsum", jbsum);
    request.setAttribute("zssum", zssum);
    request.setAttribute("jfsum", jfsum);
    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/admin_recharge_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

