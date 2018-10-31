package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.RechargeDAO;
import com.guohaoshiye.yueba.dao.UsersDAO;
import com.guohaoshiye.yueba.entity.Recharge;
import com.guohaoshiye.yueba.entity.Users;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RechargeServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private RechargeDAO dao = new RechargeDAO();
  private UsersDAO udao = new UsersDAO();
  private String flag = "";

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String op = request.getParameter("op");
    if ("rechargeList".equals(op)) {
      rechargeList(request, response);
    }
  }







  private void rechargeList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "status", "userId", "begin", "end", "order", "gold" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<Recharge> pm = this.dao.sqlRechargeLog(currentPage, pageSize, param, paramValue);
    String sum = this.dao.findSqlSum("select cast(IFNULL(SUM(gold),0) as decimal(18,2)) from recharge where status=1");
    List<Recharge> list = pm.getList();
    System.out.println(list.size());
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    List<Users> ulist = this.udao.findByHQL("from Users", null);
    request.setAttribute("ulist", ulist);
    request.setAttribute("comp", comp);
    request.setAttribute("sum", sum);
    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/recharge_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

