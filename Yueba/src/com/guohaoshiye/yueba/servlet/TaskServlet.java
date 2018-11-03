package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.dao.TaskDAO;
import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.entity_olddemo.AdminopLog;
import com.guohaoshiye.yueba.entity_olddemo.Task;
import com.guohaoshiye.yueba.hibernate.PageModel;
import com.guohaoshiye.yueba.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;






public class TaskServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;
  private TaskDAO dao = new TaskDAO();
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
    if ("taskList".equals(op))
    {
      taskList(request, response);
    } else if ("addTask".equals(op))
    {
      addTask(request, response);
    } else if ("updateStatus".equals(op))
    {
      updateStatus(request, response);
    } else if ("findById".equals(op))
    {
      findByIdTask(request, response);
    } else if ("updateTask".equals(op)) {
      updateTask(request, response);
    }
  }







  private void updateTask(HttpServletRequest request, HttpServletResponse response)
  {
    Integer id = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
    Integer acceptid = Integer.valueOf(Integer.parseInt(request.getParameter("acceptid")));
    Integer completeid = Integer.valueOf(Integer.parseInt(request.getParameter("completeid")));
    Integer type = Integer.valueOf(Integer.parseInt(request.getParameter("type")));
    String describe = request.getParameter("describe");
    String reward = request.getParameter("reward");
    Task t = (Task)this.dao.findById(id);
    t.setAcceptid(acceptid);
    t.setCompleteid(completeid);
    t.setDescribe(describe);
    t.setReward(reward);
    t.setType(type);
    this.dao.update(t);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("对ID[" + id + "]的任务进行了修改");
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






  private void findByIdTask(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    Task task = (Task)this.dao.findById(Integer.valueOf(id));
    JSONArray json1 = JSONArray.fromObject(task);
    try {
      this.out = response.getWriter();
      this.out.print(json1);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void updateStatus(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    Integer status = Integer.valueOf(Integer.parseInt(request.getParameter("status")));
    String[] names = { "state" };
    Object[] values = { status };
    this.dao.partUpdate(id, names, values);


    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("修改了ID[" + id + "]任务的状态");
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


  private void addTask(HttpServletRequest request, HttpServletResponse response)
  {
    Integer acceptid = Integer.valueOf(Integer.parseInt(request.getParameter("acceptid")));
    Integer completeid = Integer.valueOf(Integer.parseInt(request.getParameter("completeid")));
    Integer type = Integer.valueOf(Integer.parseInt(request.getParameter("type")));
    String describe = request.getParameter("describe");
    String reward = request.getParameter("reward");
    Task t = new Task();
    t.setAcceptid(acceptid);
    t.setCompleteid(completeid);
    t.setDescribe(describe);
    t.setReward(reward);
    t.setType(type);
    t.setState(Integer.valueOf(1));
    this.dao.save(t);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("添加了一个新任务");
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






  private void taskList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));

    Integer compAdd = Integer.valueOf(0);
    Integer compUpdate = Integer.valueOf(0);

    String[] splits = comp.split(",");

    compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
    compUpdate = Integer.valueOf(Integer.parseInt(splits[1]));

    PageModel<Task> pm = this.dao.pageList(currentPage, pageSize);


    List<Task> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    try {
      request.setAttribute("pm", pm);
      request.setAttribute("compAdd", compAdd);
      request.setAttribute("compUpdate", compUpdate);
      request.setAttribute("comp", comp);
      request.getRequestDispatcher("web/taskList.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

