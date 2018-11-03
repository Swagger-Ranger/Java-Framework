package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminRechargeLogDAO;
import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.dao.ParameterDAO;
import com.guohaoshiye.yueba.dao.SystemLogDAO;
import com.guohaoshiye.yueba.dao.UsersDAO;
import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.entity_olddemo.AdminRechargeLog;
import com.guohaoshiye.yueba.entity_olddemo.AdminopLog;
import com.guohaoshiye.yueba.entity_olddemo.Parameter;
import com.guohaoshiye.yueba.entity_olddemo.SystemLog;
import com.guohaoshiye.yueba.entity_olddemo.Users;
import com.guohaoshiye.yueba.hibernate.PageModel;
import com.guohaoshiye.yueba.util.Util;
import com.guohaoshiye.game.server.web.GameWebServerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UsersServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private UsersDAO dao = new UsersDAO();
  private ParameterDAO pdao = new ParameterDAO();
  private AdminRechargeLogDAO arldao = new AdminRechargeLogDAO();
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;
  private SystemLogDAO sdao = new SystemLogDAO();
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
    if ("userslist".equals(op)) {
      userslist(request, response);
    } else if ("updateStatus".equals(op)) {
      updateStatus(request, response);
    } else if ("rechargeGold".equals(op)) {
      rechargeGold(request, response);
    } else if ("newDayUser".equals(op)) {
      newDayUser(request, response);
    } else if ("updateUserSeparate".equals(op)) {
      updateUserSeparate(request, response);
    } else if ("sendPlacard".equals(op)) {
      sendPlacard(request, response);
    }
  }








  private void sendPlacard(HttpServletRequest request, HttpServletResponse response)
  {
    String mag = request.getParameter("msg");
    Parameter p = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
    SystemLog log = new SystemLog();
    HttpSession session = request.getSession();
    String ipClients = Util.getIpAddress(request);
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        log.setAid(((Admin)entry.getValue()).getId());
      }
    }
    log.setOperating("发送及时公告");
    log.setContent(mag);
    log.setCreateTime(new Timestamp(System.currentTimeMillis()));
    this.sdao.save(log);
    GameWebServerService wb = null;
    try {
      URL url = new URL(p.getValue());
      wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));

      wb.getGameWebServerPort().message(mag, 1); return;
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    } finally {
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






  private void updateUserSeparate(HttpServletRequest request, HttpServletResponse response)
  {
    String ipClients = Util.getIpAddress(request);
    int id = Integer.parseInt(request.getParameter("id"));
    Users users = (Users)this.dao.findById(Integer.valueOf(id));
    String[] names = { "pid" };
    Object[] values = { Integer.valueOf(0) };
    this.dao.partUpdate(id, names, values);

    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("对ID为[" + users.getId() + "]的用户进行了脱离操作");
        l.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.apdao.save(l);
      }
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







  private void newDayUser(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();

    Date day = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String date = df.format(day);
    String begin = date + " 0:0:0";
    String end = date + " 23:59:59";


    String newDayProxyCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from proxy where createTime>='" + begin + "'");

    String ProxyCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from proxy");



    String newDayUserCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from users where createtime>='" + begin + "' and createtime<='" + end + "'");

    String UserCount = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from users");

    String integralUser = this.dao.findAllgoldtrue("select IFNULL(count(*),0) from users where integral>0");
    Map<Integer, String> map = this.dao.findGameCount("select playtype,count(*) from game_alllog GROUP BY playtype");
    Map<Integer, String> map2 = this.dao.findGameCount("select playtype,count(*) from (select * from game_alllog where creattime>='" + begin + "' and creattime<='" + end + "') as ss GROUP BY playtype");


    List<SystemLog> loglist = this.sdao.findlist();
    JSONArray jsonloglist = JSONArray.fromObject(loglist);

    Parameter p = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
    GameWebServerService wb = null;
    Integer onlineCount = Integer.valueOf(0);
    boolean status = false;
    try {
      URL url = new URL(p.getValue());
      wb = new GameWebServerService(url, new QName("http://web.server.game.com/", "GameWebServerService"));

      onlineCount = wb.getGameWebServerPort().userCount();
      status = wb.getGameWebServerPort().getServerStatus(); return;
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    } finally {
      this.json.put("status", Boolean.valueOf(status));
      this.json.put("loglist", jsonloglist);
      this.json.put("zong1", map.get(Integer.valueOf(1)));
      this.json.put("zong2", map.get(Integer.valueOf(2)));
      this.json.put("zong3", map.get(Integer.valueOf(3)));
      this.json.put("zong4", map.get(Integer.valueOf(4)));
      this.json.put("jin1", map2.get(Integer.valueOf(1)));
      this.json.put("jin2", map2.get(Integer.valueOf(2)));
      this.json.put("jin3", map2.get(Integer.valueOf(3)));
      this.json.put("jin4", map2.get(Integer.valueOf(4)));

      this.json.put("newDayProxyCount", newDayProxyCount);
      this.json.put("ProxyCount", ProxyCount);

      this.json.put("onlineCount", onlineCount);
      this.json.put("newDayUserCount", newDayUserCount);
      this.json.put("UserCount", UserCount);
      this.json.put("integralUser", integralUser);
      try {
        this.out = response.getWriter();
        this.out.print(this.json);
        this.out.flush();
        this.out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }






  private void rechargeGold(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    Users users = (Users)this.dao.findById(Integer.valueOf(id));
    int uid = Integer.parseInt(request.getParameter("uid"));
    int type = Integer.parseInt(request.getParameter("type"));
    int money = Integer.parseInt(request.getParameter("money"));
    Parameter parameter = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
    GameWebServerService wb = null;
    try {
      wb = new GameWebServerService(new URL(parameter.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    }
    wb.getGameWebServerPort().addGold(Integer.valueOf(money), Integer.valueOf(uid), type);
    AdminRechargeLog arlog = new AdminRechargeLog();
    arlog.setAid(Integer.valueOf(id));
    arlog.setMoney(money + "");
    arlog.setRtype(Integer.valueOf(type));
    arlog.setUid(Integer.valueOf(uid));
    Timestamp d = new Timestamp(System.currentTimeMillis());
    arlog.setCreateTime(d);
    this.arldao.save(arlog);
    try {
      this.out = response.getWriter();
      this.out.print("ok");
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void updateStatus(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    Users users = (Users)this.dao.findById(Integer.valueOf(id));
    short status = Short.parseShort(request.getParameter("status"));
    String[] names = { "status" };
    Object[] values = { Short.valueOf(status) };
    this.dao.partUpdate(id, names, values);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("修改了ID为[" + users.getId() + "]的用户账号状态");
        l.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.apdao.save(l);
      }
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






  private void userslist(HttpServletRequest request, HttpServletResponse response)
  {
    String type = request.getParameter("type");
    String show = request.getParameter("show");

    String comp = request.getParameter("comp");
    Integer compUpdate = Integer.valueOf(0);


    Integer compRecharge = Integer.valueOf(0);


    String[] splits = comp.split(",");
    compUpdate = Integer.valueOf(Integer.parseInt(splits[0]));


    compRecharge = Integer.valueOf(Integer.parseInt(splits[1]));



    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    PageModel<Users> pm = null;
    if ((type != null) && (!"".equals(type))) {
      request.setAttribute("type", type);
      if ("1".equals(type))
      {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(day);
        String begin = date + " 0:0:0";
        String end = date + " 23:59:59";

        pm = this.dao.userList(currentPage, pageSize, " where createtime>='" + begin + "' and createtime<='" + end + "'");
      } else if ("2".equals(type))
      {
        pm = this.dao.userList(currentPage, pageSize, " where integral>0 ");
      }
    } else {
      String[] param = { "uid", "nickname", "status", "pid", "realName" };
      String[] paramValue = new String[param.length];
      for (int i = 0; i < param.length; i++) {
        paramValue[i] = request.getParameter(param[i]);
        request.setAttribute(param[i], paramValue[i]);
      }
      pm = this.dao.sqlUsers(currentPage, pageSize, param, paramValue);
    }

    List<Users> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }


    HashMap<Integer, String> map = new HashMap();

    Users users;

    for (Iterator<Users> i = list.iterator(); i.hasNext();) { users = (Users)i.next();
      String time = this.dao.findByUidTime(users.getId());
      BigDecimal time1 = new BigDecimal(time);
      BigDecimal time2 = new BigDecimal(3600);
      BigDecimal time3 = time1.divide(time2, 2, 4);
      map.put(users.getId(), time3.toString());
    }

    HashMap<Integer, String> map2 = new HashMap();
    for (Users users1 : list) {
      String count = this.dao.findByLoginCount(users1.getId());
      map2.put(users1.getId(), count);
    }

    String trueUserIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(integral),0) from users where status=1");

    String warehouseIntegralUserIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(warehouseIntegral),0) from users where status=1");

    String trueProxyIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(integral),0) from proxy where status=1");

    String falseUserIntegral = this.dao.findAllgoldtrue("select IFNULL(SUM(integral),0) from users where status=0");

    String zuanshit = this.dao.findAllgoldtrue("select IFNULL(SUM(diamonds),0) from users where status=1");

    String zuanshif = this.dao.findAllgoldtrue("select IFNULL(SUM(diamonds),0) from users where status=0");

    String jinbit = this.dao.findAllgoldtrue("select IFNULL(SUM(gold),0) from users where status=1");

    String jinbif = this.dao.findAllgoldtrue("select IFNULL(SUM(gold),0) from users where status=0");























    try
    {
      request.setAttribute("comp", comp);
      request.setAttribute("compUpdate", compUpdate);


      request.setAttribute("compRecharge", compRecharge);


      request.setAttribute("trueUserIntegral", trueUserIntegral);
      request.setAttribute("warehouseIntegralUserIntegral", warehouseIntegralUserIntegral);
      request.setAttribute("trueProxyIntegral", trueProxyIntegral);
      request.setAttribute("falseUserIntegral", falseUserIntegral);
      request.setAttribute("zuanshit", zuanshit);
      request.setAttribute("zuanshif", zuanshif);
      request.setAttribute("jinbit", jinbit);
      request.setAttribute("jinbif", jinbif);
      request.setAttribute("map", map);
      request.setAttribute("map2", map2);

      request.setAttribute("pm", pm);
      request.setAttribute("show", show);
      request.getRequestDispatcher("web/usersList.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\UsersServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */