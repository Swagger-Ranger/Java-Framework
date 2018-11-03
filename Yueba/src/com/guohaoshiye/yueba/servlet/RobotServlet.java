package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.dao.ParameterDAO;
import com.guohaoshiye.yueba.dao.RobotDAO;
import com.guohaoshiye.yueba.dao.RobotrechargeDAO;
import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.entity_olddemo.AdminopLog;
import com.guohaoshiye.yueba.entity_olddemo.Parameter;
import com.guohaoshiye.yueba.entity_olddemo.Robot;
import com.guohaoshiye.yueba.entity_olddemo.Robotrecharge;
import com.guohaoshiye.yueba.hibernate.PageModel;
import com.guohaoshiye.yueba.util.Util;
import com.guohaoshiye.game.server.web.GameWebServerService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class RobotServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private RobotrechargeDAO rdao = new RobotrechargeDAO();
  private RobotDAO dao = new RobotDAO();
  private ParameterDAO pdao = new ParameterDAO();
  private Parameter parameter = new Parameter();
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
    if ("robotList".equals(op)) {
      robotList(request, response);
    } else if ("imgUpload".equals(op)) {
      imgUpload(request, response);
    } else if ("addRobot".equals(op)) {
      addRobot(request, response);
    } else if ("updateRobot".equals(op)) {
      updateRobot(request, response);
    } else if ("findById".equals(op)) {
      findById(request, response);
    } else if ("updateStatus".equals(op)) {
      updateStatus(request, response);
    } else if ("rechargeGold".equals(op)) {
      rechargeGold(request, response);
    }
  }

  private void rechargeGold(HttpServletRequest request, HttpServletResponse response)
  {
    int aid = Integer.parseInt(request.getParameter("aid"));
    int rid = Integer.parseInt(request.getParameter("rid"));
    int money = Integer.parseInt(request.getParameter("money"));
    Parameter parameter = (Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0);
    GameWebServerService wb = null;
    try {
      wb = new GameWebServerService(new URL(parameter.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    }
    wb.getGameWebServerPort().addGold(Integer.valueOf(money), Integer.valueOf(rid), 3);
    Robotrecharge robotrecharge = new Robotrecharge();
    robotrecharge.setAid(Integer.valueOf(aid));
    robotrecharge.setGold(Integer.valueOf(money));
    robotrecharge.setRid(Integer.valueOf(rid));
    robotrecharge.setTime(new Timestamp(System.currentTimeMillis()));
    this.rdao.save(robotrecharge);
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
    Robot users = (Robot)this.dao.findById(Integer.valueOf(id));
    short status = Short.parseShort(request.getParameter("status"));
    String[] names = { "status" };
    Object[] values = { Short.valueOf(status) };
    this.dao.partUpdate(id, names, values);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("修改了ID为[" + users.getId() + "]的机器人账号状态");
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






  private void findById(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();
    int id = Integer.parseInt(request.getParameter("id"));
    Robot robot = (Robot)this.dao.findById(Integer.valueOf(id));
    this.json = JSONObject.fromObject(robot);
    try {
      this.out = response.getWriter();
      this.out.print(this.json);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void updateRobot(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("robotId"));
    String nickname = request.getParameter("realName");
    String autograph = request.getParameter("myself");
    String head = request.getParameter("userFace");
    Robot robot = (Robot)this.dao.findById(Integer.valueOf(id));
    robot.setNickname(nickname);
    robot.setAutograph(autograph);
    robot.setHead(head);
    this.dao.update(robot);
    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("对ID为[" + robot.getId() + "]机器人进行了修改操作");
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






  private void addRobot(HttpServletRequest request, HttpServletResponse response)
  {
    String account = request.getParameter("account");
    String nickname = request.getParameter("realName");
    String autograph = request.getParameter("myself");
    String head = request.getParameter("userFace");
    Robot robot = new Robot();
    robot.setAccount(account);
    robot.setNickname(nickname);
    robot.setAutograph(autograph);
    robot.setHead(head);
    Timestamp d = new Timestamp(System.currentTimeMillis());
    robot.setCreatetime(d);
    robot.setStatus(Short.valueOf(Short.parseShort("0")));
    robot.setGold(Integer.valueOf(0));
    robot.setIntegral(Integer.valueOf(0));
    this.dao.save(robot);
    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("添加了新的机器人");
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






  private void imgUpload(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();

    DiskFileItemFactory factory = new DiskFileItemFactory();

    ServletFileUpload upload = new ServletFileUpload(factory);


    upload.setHeaderEncoding("UTF-8");
    factory.setSizeThreshold(512000);
    File linshi = new File("C:\\linshi");
    factory.setRepository(linshi);
    upload.setSizeMax(5242880L);
    try
    {
      List<FileItem> items = upload.parseRequest(request);

      for (FileItem item : items)
      {
        if (item.isFormField()) {
          String name = item.getFieldName();
          String str1 = item.getString("utf-8");
        }
        else {
          String fileName = item.getName();
          long sizeInBytes = item.getSize();
          InputStream in = item.getInputStream();
          byte[] buffer = new byte['Ѐ'];
          int len = 0;
          String property = request.getSession().getServletContext().getRealPath("");
          Date date = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
          String imageupdatename = sdf.format(date);
          imageupdatename = imageupdatename + ".png";
          fileName = property + "/imgLoad/robotImg/" + imageupdatename;
          OutputStream out = new FileOutputStream(fileName);
          while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
          }
          out.close();
          in.close();

          this.json.put("str", "imgLoad/robotImg/" + imageupdatename);
        }
      }
    } catch (IOException e) {
      this.json.put("str", "no");
      e.printStackTrace();
    } catch (FileUploadException e) {
      this.json.put("str", "no");
      e.printStackTrace();
    }
    try {
      this.out = response.getWriter();
      this.out.print(this.json);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }







  private void robotList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    Integer compAdd = Integer.valueOf(0);
    Integer compUpdate = Integer.valueOf(0);
    String[] splits = comp.split(",");
    compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
    compUpdate = Integer.valueOf(Integer.parseInt(splits[1]));
    Map<Integer, Long> map2 = new HashMap();
    String[] param = { "uid", "nickname", "status" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<Robot> pm = this.dao.sqlRobot(currentPage, pageSize, param, paramValue);
    List<Robot> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    String ids = "";
    for (Robot robot : list) {
      String string = this.dao.findCount("select IFNULL(SUM(gold),0)from robotrecharge where rid = " + robot.getId());
      long parseLong = Long.parseLong(string);
      long sum = parseLong - robot.getIntegral().longValue();
      map2.put(robot.getId(), Long.valueOf(sum));
      ids = ids + robot.getId() + ",";
    }
    this.parameter = ((Parameter)this.pdao.findByHQL("from Parameter where name='webService'", null).get(0));
    GameWebServerService wb = null;
    try {
      wb = new GameWebServerService(new URL(this.parameter.getValue()), new QName("http://web.server.game.com/", "GameWebServerService"));
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    }
    String line = wb.getGameWebServerPort().checkUserOnLine(ids);
    String[] split = line.split(",");
    Map<Integer, Integer> map = new HashMap();
    String[] arrayOfString1 = split;long sum = arrayOfString1.length; for (int l1 = 0; l1 < sum; l1++) { String string = arrayOfString1[l1];
      String[] split2 = string.split(":");
      map.put(Integer.valueOf(Integer.parseInt(split2[0])), Integer.valueOf(Integer.parseInt(split2[1])));
    }

    request.setAttribute("comp", comp);
    request.setAttribute("map", map);
    request.setAttribute("map2", map2);
    request.setAttribute("compAdd", compAdd);
    request.setAttribute("compUpdate", compUpdate);
    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/robotList.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

