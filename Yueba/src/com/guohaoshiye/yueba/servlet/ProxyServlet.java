package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.dao.ParameterDAO;
import com.guohaoshiye.yueba.dao.ProxyDAO;
import com.guohaoshiye.yueba.dao.PumpLogDAO;
import com.guohaoshiye.yueba.dao.TixianLogDAO;
import com.guohaoshiye.yueba.dao.UsersDAO;
import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.entity_olddemo.AdminopLog;
import com.guohaoshiye.yueba.entity_olddemo.Parameter;
import com.guohaoshiye.yueba.entity_olddemo.Proxy;
import com.guohaoshiye.yueba.entity_olddemo.Proxy_num;
import com.guohaoshiye.yueba.entity_olddemo.Users;
import com.guohaoshiye.yueba.hibernate.PageModel;
import com.guohaoshiye.yueba.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;












public class ProxyServlet
  extends HttpServlet
{
  private PumpLogDAO pdao = new PumpLogDAO();
  private ParameterDAO ptdao = new ParameterDAO();
  private UsersDAO udao = new UsersDAO();
  private ProxyDAO dao = new ProxyDAO();
  private TixianLogDAO tdao = new TixianLogDAO();
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;
  private AdminopLogDAO apdao = new AdminopLogDAO();
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
    if ("listProxy".equals(op)) {
      listProxy(request, response);
    } else if ("updateChouShui".equals(op)) {
      updateChouShui(request, response);
    } else if ("findAllAgents".equals(op)) {
      findAllAgents(request, response);
    } else if ("findAllUser".equals(op)) {
      findAllUser(request, response);
    } else if ("updateProxy".equals(op)) {
      updateProxy(request, response);
    } else if ("updateRight".equals(op)) {
      updateRight(request, response);
    } else if ("showByIdInfo".equals(op)) {
      showByIdInfo(request, response);
    } else if ("saveNumSession".equals(op)) {
      saveNumSession(request, response);
    } else if ("selectNum".equals(op)) {
      selectNum(request, response);
    } else if ("update2Proxy".equals(op)) {
      update2Proxy(request, response);
    }
  }

  private void update2Proxy(HttpServletRequest request, HttpServletResponse response) {
    String str = "";
    Integer icon = null;
    this.json = new JSONObject();
    int id = Integer.parseInt(request.getParameter("id"));
    Integer isDisable = Integer.valueOf(Integer.parseInt(request.getParameter("isDisable")));
    Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
    proxy.setIsDisable(isDisable);
    if (isDisable.intValue() == 0) {
      proxy.setPid(Integer.valueOf(0));
      this.dao.upadtePid(id);
      this.udao.updatePid(id);
    }
    this.dao.update(proxy);
    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【账号状态】");
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


  private void selectNum(HttpServletRequest request, HttpServletResponse response)
  {
    Proxy_num proxy_num = this.dao.selectNum();
    JSONObject json = JSONObject.fromObject(proxy_num);
    try {
      this.out = response.getWriter();
      this.out.print(json.toString());
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void saveNumSession(HttpServletRequest request, HttpServletResponse response)
  {
    String str = "error";
    try {
      int pNumber1 = Integer.parseInt(request.getParameter("number1"));
      int pNumber2 = Integer.parseInt(request.getParameter("number2"));
      int pNumber3 = Integer.parseInt(request.getParameter("number3"));
      this.dao.UpdateNum(pNumber1, pNumber2, pNumber3);
      str = "ok";
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      this.out = response.getWriter();
      this.out.print(str);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private void showByIdInfo(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();
    String flg = "0";
    int pid = Integer.parseInt(request.getParameter("pid"));
    Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(pid));
    if (proxy.getPid().intValue() != 0) {
      flg = "1";
      Proxy proxy2 = (Proxy)this.dao.findById(proxy.getPid());
      JSONObject json2 = JSONObject.fromObject(proxy2);
      this.json.put("proxy", json2);
    }
    this.json.put("flg", flg);
    try {
      this.out = response.getWriter();
      this.out.print(this.json);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void updateRight(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();
    int id = Integer.parseInt(request.getParameter("id"));
    Integer status = Integer.valueOf(Integer.parseInt(request.getParameter("status")));
    Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
    proxy.setRight(status);
    this.dao.update(proxy);
    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【代理后台权限】");
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






  private void updateProxy(HttpServletRequest request, HttpServletResponse response)
  {
    String str = "";
    Integer icon = null;
    this.json = new JSONObject();
    int id = Integer.parseInt(request.getParameter("id"));
    Integer status = Integer.valueOf(Integer.parseInt(request.getParameter("status")));
    Proxy proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
    proxy.setStatus(status);
    if (status.intValue() == 0) {
      this.dao.partUpdateProxy(proxy.getPid(), id);
      proxy.setPid(Integer.valueOf(0));
      this.dao.upadtePid(id);
      this.udao.updatePid(id);
    }
    this.dao.update(proxy);
    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【账号状态】");
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






  private void findAllUser(HttpServletRequest request, HttpServletResponse response)
  {
    int pid = Integer.parseInt(request.getParameter("pid"));
    List<Proxy> plist = this.dao.sqlHeProxy(pid);
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    for (Proxy proxy : plist) {
      List<Users> ulist = this.dao.sqlHeUser(proxy.getId());
      sb.append("{");
      sb.append("\"code\":\"" + proxy.getId() + "\",");
      sb.append("\"name\":\"推广员:" + proxy.getNickname() + "&nbsp;&nbsp;ID:" + proxy.getId() + "\",");
      sb.append("\"icon\":\"icon-th\",");
      sb.append("\"child\":[");
      if (!ulist.isEmpty()) {
        for (Users users : ulist) {
          sb.append("{");
          sb.append("\"code\":\"" + users.getId() + "\",");
          sb.append("\"parentCode\":\"" + users.getPid() + "\",");
          sb.append("\"icon\":\"\",");
          sb.append("\"name\":\"会员:" + users.getNickname() + "&nbsp;&nbsp;ID:" + users.getId() + "\",");
          sb.append("\"child\":[]");
          sb.append("},");
        }
        sb = new StringBuffer(sb.substring(0, sb.length() - 1));
      }
      sb.append("]");
      sb.append("},");
    }
    String sb2 = new String(sb);
    sb2 = sb2.substring(0, sb2.length() - 1);
    sb2 = sb2 + "]";
    try {
      this.out = response.getWriter();
      this.out.print(sb2);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void findAllAgents(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();
    int pid = Integer.parseInt(request.getParameter("pid"));
    List<Proxy> plist = this.dao.sqlHeProxy(pid);
    for (Proxy proxy : plist) {
      List<Users> ulist = this.dao.sqlHeUser(proxy.getId());
      proxy.setUsers(ulist);
    }
    JSONArray json2 = JSONArray.fromObject(plist);
    Parameter parameter = (Parameter)this.ptdao.findByHQL("from Parameter where name='pingntaipump'", null).get(0);
    int int1 = Integer.parseInt(parameter.getValue());
    int i = 100 - int1;
    double s = i * 0.01D;
    String totalRevenue = this.pdao.findSqlSum("select cast(IFNULL(SUM(allpump),0)*" + s + " as decimal(18,2)) FROM pump_log where uid in (select id from users where pid in (select id from proxy where FIND_IN_SET(id, getChildLstProxy(" + pid + "))))");
    this.json.put("jsonArray", json2);
    this.json.put("totalRevenue", totalRevenue);
    try {
      this.out = response.getWriter();
      this.out.print(this.json);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }







  private void updateChouShui(HttpServletRequest request, HttpServletResponse response)
  {
    String str = "";
    try {
      int id = Integer.parseInt(request.getParameter("id"));
      int yiji = Integer.parseInt(request.getParameter("yiji"));
      int erji = Integer.parseInt(request.getParameter("erji"));
      int sanji = Integer.parseInt(request.getParameter("sanji"));
//      proxy = (Proxy)this.dao.findById(Integer.valueOf(id));
      Proxy proxy = (Proxy) this.dao.findById(Integer.valueOf(id));//这里我添加了Proxy的变量
      proxy.setYiji(Integer.valueOf(yiji));
      proxy.setErji(Integer.valueOf(erji));
      proxy.setSanji(Integer.valueOf(sanji));
      this.dao.update(proxy);
      str = "ok";
      String ipClients = Util.getIpAddress(request);
      HttpSession session = request.getSession();
      Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
      for (Map.Entry<String, Admin> entry : mapAdmin.entrySet())
        if (ipClients.equals(entry.getKey())) {
          Admin value = (Admin)entry.getValue();
          AdminopLog l = new AdminopLog();
          l.setAid(value.getId());
          l.setDescription("修改了ID为[" + proxy.getId() + "]推广员的【奖励比例】");
          l.setCreateTime(new Timestamp(System.currentTimeMillis()));
          this.apdao.save(l);
        }
    } catch (Exception e) { Proxy proxy;
      String ipClients;
      str = "on";
    }
    try {
      this.out = response.getWriter();
      this.out.print(str);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private void listProxy(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String type = request.getParameter("type");

    Integer proxyOp1 = Integer.valueOf(0);
    Integer proxyOp2 = Integer.valueOf(0);
    Integer proxyOp3 = Integer.valueOf(0);

    String[] splits = comp.split(",");

    proxyOp1 = Integer.valueOf(Integer.parseInt(splits[0]));
    proxyOp2 = Integer.valueOf(Integer.parseInt(splits[1]));
    proxyOp3 = Integer.valueOf(Integer.parseInt(splits[2]));


    String[] param = { "nickname", "status", "pid", "kg", "ppid", "phone", "trueName", "contactWay", "isDisable" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<Proxy> pm = this.dao.sqlProxy(currentPage, pageSize, param, paramValue);
    List<Proxy> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    } else {
      HashMap<Integer, String> map = new HashMap();
      HashMap<Integer, String> map2 = new HashMap();
      HashMap<Integer, String> map3 = new HashMap();
      for (Proxy proxy : list) {
        double f = proxy.getIntegral().doubleValue();
        DecimalFormat df = new DecimalFormat("###############0.##");
        String s = df.format(f);
        BigDecimal sum = new BigDecimal(0);
        String yijisum = this.pdao.showYingli("select cast(IFNULL(SUM(oneproxypump),0) as decimal(18,2)) FROM pump_log where oneproxyid=?", proxy.getId());
        String yerjisum = this.pdao.showYingli("select cast(IFNULL(SUM(twoproxypump),0) as decimal(18,2)) FROM pump_log where twoproxyid=?", proxy.getId());
        String sanjisum = this.pdao.showYingli("select cast(IFNULL(SUM(threeproxypump),0) as decimal(18,2)) FROM pump_log where threeproxyid=?", proxy.getId());
        sum = sum.add(new BigDecimal(yijisum));
        sum = sum.add(new BigDecimal(yerjisum));
        sum = sum.add(new BigDecimal(sanjisum));
        String txsum = this.tdao.showTiXianSum("select IFNULL(SUM(Ingots),0) from tixian_log where `status` =0 and pid =?", proxy.getId());
        map.put(proxy.getId(), sum.toString());
        map2.put(proxy.getId(), s);
        map3.put(proxy.getId(), txsum);
      }
      request.setAttribute("map", map);
      request.setAttribute("map2", map2);
      request.setAttribute("map3", map3);
    }
    request.setAttribute("pm", pm);
    request.setAttribute("proxyOp1", proxyOp1);
    request.setAttribute("proxyOp2", proxyOp2);
    request.setAttribute("proxyOp3", proxyOp3);
    request.setAttribute("comp", comp);
    request.setAttribute("type", type);
    try {
      request.getRequestDispatcher("web/prxoyList.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\ProxyServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */