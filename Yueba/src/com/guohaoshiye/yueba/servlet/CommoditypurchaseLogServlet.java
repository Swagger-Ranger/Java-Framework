package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.CommoditypurchaseLogDAO;
import com.guohaoshiye.yueba.entity.CommoditypurchaseLog;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class CommoditypurchaseLogServlet
  extends HttpServlet
{
  private CommoditypurchaseLogDAO dao = new CommoditypurchaseLogDAO();
  private String flag = "";
  private static final long serialVersionUID = 1L;

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
    if ("commoditypurchaseLog".equals(op)) {
      commoditypurchaseLog(request, response);
    }
  }







  private void commoditypurchaseLog(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "CommodityName", "PurchaseUserid", "begin", "end" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<CommoditypurchaseLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);


    String sum = this.dao.findSqlSum("select IFNULL(SUM(commodityTotalPrice),0) from commoditypurchase_log");

    String xhsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='flower'");

    String pcsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='sportcar'");

    String jdsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='egg'");

    String czsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='hammer'");

    String lbsum = this.dao.findSqlSum("select IFNULL(SUM(commodityNumber),0) from commoditypurchase_log where commodityName='horn'");
    List<CommoditypurchaseLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    request.setAttribute("comp", comp);
    request.setAttribute("pm", pm);

    request.setAttribute("sum", sum);
    request.setAttribute("xhsum", xhsum);
    request.setAttribute("pcsum", pcsum);
    request.setAttribute("jdsum", jdsum);
    request.setAttribute("czsum", czsum);
    request.setAttribute("lbsum", lbsum);
    try {
      request.getRequestDispatcher("web/commoditypurchase_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

