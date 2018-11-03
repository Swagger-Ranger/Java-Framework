package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.ProxyDAO;
import com.guohaoshiye.yueba.dao.PumpLogDAO;
import com.guohaoshiye.yueba.dao.UsersDAO;
import com.guohaoshiye.yueba.entity_olddemo.Proxy;
import com.guohaoshiye.yueba.entity_olddemo.PumpLog;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

public class PumpLogServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private PumpLogDAO dao = new PumpLogDAO();
  private UsersDAO udao = new UsersDAO();
  private ProxyDAO pdao = new ProxyDAO();
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
    if ("pumpLogList".equals(op))
    {
      pumpLogList(request, response);
    } else if ("showServicefee".equals(op)) {
      showServicefee(request, response);
    } else if ("pumpLogList2".equals(op)) {
      pumpLogList2(request, response);
    }
  }






  private void pumpLogList2(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "uid", "tableid", "tabletype", "gamechang" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }


    PageModel<PumpLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
    List<PumpLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }

    String sumAllpump = this.dao.findSqlSum("select cast(IFNULL(SUM(allpump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
    String sumPingtaipump = this.dao.findSqlSum("select cast(IFNULL(SUM(pingtaipump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
    String sumOneproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(oneproxypump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
    String sumTwoproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(twoproxypump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");
    String sumThreeproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(threeproxypump),0) as decimal(18,2)) from pump_log where tabletype=10 or tabletype=11");


    List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);

    request.setAttribute("plist", plist);
    request.setAttribute("comp", comp);

    request.setAttribute("sumAllpump", sumAllpump);
    request.setAttribute("sumPingtaipump", sumPingtaipump);
    request.setAttribute("sumOneproxypump", sumOneproxypump);
    request.setAttribute("sumTwoproxypump", sumTwoproxypump);
    request.setAttribute("sumThreeproxypump", sumThreeproxypump);

    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/pump_log2.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }







  private void showServicefee(HttpServletRequest request, HttpServletResponse response)
  {
    int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
    String haomiao = request.getParameter("haomiao");
    List<PumpLog> list = this.dao.findByHQL("from PumpLog where tableid=? and haomiao=?", new Object[] { Integer.valueOf(roomNumber), haomiao });
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);
    request.setAttribute("plist", plist);
    request.setAttribute("list", list);
    try {
      request.getRequestDispatcher("web/update/pumpInfo_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void pumpLogList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));

    String[] param = { "uid", "tableid", "tabletype", "gamechang" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }

    PageModel<PumpLog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
    List<PumpLog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }

    String sumAllpump = this.dao.findSqlSum("select cast(IFNULL(SUM(allpump),0) as decimal(18,2)) from pump_log where tabletype!=10");
    String sumPingtaipump = this.dao.findSqlSum("select cast(IFNULL(SUM(pingtaipump),0) as decimal(18,2)) from pump_log where tabletype!=10");
    String sumOneproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(oneproxypump),0) as decimal(18,2)) from pump_log where tabletype!=10");
    String sumTwoproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(twoproxypump),0) as decimal(18,2)) from pump_log where tabletype!=10");
    String sumThreeproxypump = this.dao.findSqlSum("select cast(IFNULL(SUM(threeproxypump),0) as decimal(18,2)) from pump_log where tabletype!=10");


    List<Proxy> plist = this.pdao.findByHQL("from Proxy", null);

    request.setAttribute("plist", plist);
    request.setAttribute("comp", comp);

    request.setAttribute("sumAllpump", sumAllpump);
    request.setAttribute("sumPingtaipump", sumPingtaipump);
    request.setAttribute("sumOneproxypump", sumOneproxypump);
    request.setAttribute("sumTwoproxypump", sumTwoproxypump);
    request.setAttribute("sumThreeproxypump", sumThreeproxypump);

    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/pump_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

