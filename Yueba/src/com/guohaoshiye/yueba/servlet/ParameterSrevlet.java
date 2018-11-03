package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.dao.ParameterDAO;
import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.entity_olddemo.AdminopLog;
import com.guohaoshiye.yueba.entity_olddemo.Parameter;
import com.guohaoshiye.yueba.util.Util;
import com.guohaoshiye.game.server.web.GameWebServerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import net.sf.json.JSONObject;

public class ParameterSrevlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private ParameterDAO dao = new ParameterDAO();
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;
  private AdminopLogDAO apdao = new AdminopLogDAO();

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
    if ("parameterList".equals(op)) {
      parameterList(request, response);
    } else if ("updateParameter".equals(op)) {
      updateParameter(request, response);
    } else if ("selectSysPwd".equals(op)) {
      selectSysPwd(request, response);
    } else if ("updateSysPwd".equals(op)) {
      updateSysPwd(request, response);
    } else if ("closeServer".equals(op)) {
      closeServer(request, response);
    }
    else if ("cleanupRoom".equals(op)) {
      cleanupRoom(request, response);
    }
  }








  private void cleanupRoom(HttpServletRequest request, HttpServletResponse response)
  {
    String flg = "";
    int rid = Integer.parseInt(request.getParameter("rid"));
    Parameter p = (Parameter)this.dao.findByHQL("from Parameter where name='webService'", null).get(0);
    GameWebServerService wb = null;
    try {
      URL url = new URL(p.getValue());
      wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));

      boolean b = wb.getGameWebServerPort().closeRoom(rid);
      if (b) {
        flg = "ok";
      } else {
        flg = "on";
      }
    } catch (MalformedURLException e1) {
      flg = "on";
      e1.printStackTrace();
    }
    try {
      this.out = response.getWriter();
      this.out.print(flg);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void closeServer(HttpServletRequest request, HttpServletResponse response)
  {
    Parameter p = (Parameter)this.dao.findByHQL("from Parameter where name='webService'", null).get(0);
    GameWebServerService wb = null;
    try {
      URL url = new URL(p.getValue());
      wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));

      wb.getGameWebServerPort().closeServer();
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    }
  }





  private void updateSysPwd(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    String pwd = request.getParameter("pwd");
    String[] names = { "value" };
    Object[] values = { Util.Md5(pwd) };
    this.dao.partUpdate(id, names, values);
    try {
      this.out = response.getWriter();
      this.out.print("ok");
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }





  private void selectSysPwd(HttpServletRequest request, HttpServletResponse response)
  {
    String msg = "on";
    String pwd = request.getParameter("pwd");
    List<Parameter> list = this.dao.findByHQL("from Parameter where name=? and value=?", new Object[] { "BackstagePwd", Util.Md5(pwd) });
    if (list.size() > 0) {
      msg = "ok";
    }
    try {
      this.out = response.getWriter();
      this.out.print(msg);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void updateParameter(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    Parameter parameter2 = (Parameter)this.dao.findById(Integer.valueOf(id));
    String value = request.getParameter("value");
    String[] names = { "value" };
    Object[] values = { value };
    this.dao.partUpdate(id, names, values);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value2 = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value2.getId());
        l.setDescription("对参数【" + parameter2.getExplain() + "】进行了修改。");
        l.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.apdao.save(l);
      }
    }
    Parameter parameter = (Parameter)this.dao.findById(Integer.valueOf(id));
    if ("rollingbulletin".equals(parameter.getName())) {
      Parameter p = (Parameter)this.dao.findByHQL("from Parameter where name='webService'", null).get(0);
      GameWebServerService wb = null;
      try {
        wb = new GameWebServerService(new URL(p.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
      }
      catch (MalformedURLException e) {
        e.printStackTrace();
      }
      wb.getGameWebServerPort().updateParameter("rollingbulletin", value);
    }
    try {
      this.out = response.getWriter();
      this.out.print("ok");
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }





  private void parameterList(HttpServletRequest request, HttpServletResponse response)
  {
    String url = "";
    String comp = request.getParameter("comp");
    Integer compUpdate = Integer.valueOf(0);

    String[] splits = comp.split(",");
    compUpdate = Integer.valueOf(Integer.parseInt(splits[0]));


    int type = Integer.parseInt(request.getParameter("type"));
    List<Parameter> list = this.dao.findByHQL("from Parameter where type=?", new Object[] { Integer.valueOf(type) });
    if (type == 1) {
      url = "web/parameterList1.jsp";
    }
    if (type == 2) {
      url = "web/parameterList2.jsp";
    }
    if (type == 3) {
      url = "web/parameterList3.jsp";
    }
    if (type == 4) {
      url = "web/parameterList4.jsp";
    }
    if (type == 5) {
      url = "web/parameterList5.jsp";
    }
    if (type == 6) {
      url = "web/parameterList6.jsp";
    }
    try {
      request.setAttribute("list", list);
      request.setAttribute("compUpdate", compUpdate);
      request.getRequestDispatcher(url).forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

