package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminDAO;
import com.guohaoshiye.yueba.dao.ProxyDAO;
import com.guohaoshiye.yueba.dao.TixianLogDAO;
import com.guohaoshiye.yueba.entity_olddemo.Proxy;
import com.guohaoshiye.yueba.entity_olddemo.TixianLog;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;







public class TixianLogServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private TixianLogDAO dao = new TixianLogDAO();
  private ProxyDAO pdao = new ProxyDAO();
  private AdminDAO adao = new AdminDAO();
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String op = request.getParameter("op");
    if ("tiXianAuditList".equals(op)) {
      tiXianAuditList(request, response);
    } else if ("adminAuditTiXian".equals(op)) {
      adminAuditTiXian(request, response);
    } else if ("tiXianLogList".equals(op)) {
      tiXianLogList(request, response);
    }
  }







  private void tiXianLogList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "pid", "aid", "status", "begin", "end" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<TixianLog> pm = this.dao.sqlLoglist(currentPage, pageSize, param, paramValue);
    List<TixianLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    String sum1 = this.dao.findSqlSum("select cast(IFNULL(SUM(cash),0) as decimal(18,2)) from tixian_log");
    String sum2 = this.dao.findSqlSum("select cast(IFNULL(SUM(tax),0) as decimal(18,2)) from tixian_log");




    request.setAttribute("comp", comp);
    request.setAttribute("pm", pm);
    request.setAttribute("sum1", sum1);
    request.setAttribute("sum2", sum2);
    try {
      request.getRequestDispatcher("web/proxytixian_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void adminAuditTiXian(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();
    int id = Integer.parseInt(request.getParameter("id"));
    int tid = Integer.parseInt(request.getParameter("tid"));
    int type = Integer.parseInt(request.getParameter("type"));
    TixianLog log = (TixianLog)this.dao.findById(Integer.valueOf(tid));
    log.setAuditPeople(Integer.valueOf(id));
    if (type == 1) {
      log.setStatus(Integer.valueOf(0));
    } else if (type == 2) {
      String text = request.getParameter("text");
      log.setStatus(Integer.valueOf(1));
      log.setDenyReason(text);
    }
    Timestamp d = new Timestamp(System.currentTimeMillis());
    log.setAuditTime(d);
    this.dao.update(log);
    if (type == 2) {
      String ingots = log.getIngots();
      Proxy proxy = (Proxy)this.pdao.findById(log.getPid());
      Double gold = proxy.getIntegral();
      BigDecimal b1 = new BigDecimal(gold.doubleValue());
      BigDecimal b2 = new BigDecimal(ingots);
      BigDecimal b3 = b1.add(b2);
      proxy.setIntegral(Double.valueOf(b3.doubleValue()));
      this.pdao.update(proxy);
    }
    this.json.put("str", "ok");
    try {
      this.out = response.getWriter();
      this.out.print(this.json);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void tiXianAuditList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    Integer proxyOp1 = Integer.valueOf(0);

    String[] splits = comp.split(",");

    proxyOp1 = Integer.valueOf(Integer.parseInt(splits[0]));
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "pid", "begin", "end", "content", "txhz" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<TixianLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
    List<TixianLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);
    request.setAttribute("plist", plist);
    request.setAttribute("comp", comp);
    request.setAttribute("proxyOp1", proxyOp1);
    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/proxytixian_check.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

