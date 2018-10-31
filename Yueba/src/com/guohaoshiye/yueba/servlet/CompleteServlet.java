package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.dao.CompleteDAO;
import com.guohaoshiye.yueba.entity.Admin;
import com.guohaoshiye.yueba.entity.AdminopLog;
import com.guohaoshiye.yueba.entity.Complete;
import com.guohaoshiye.yueba.hibernate.PageModel;
import com.guohaoshiye.yueba.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.json.JSONArray;






public class CompleteServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private CompleteDAO dao = new CompleteDAO();
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
    if ("completeList".equals(op))
    {
      completeList(request, response);
    } else if ("addComplete".equals(op))
    {
      addComplete(request, response);
    } else if ("updateComplete".equals(op))
    {
      updateComplete(request, response);
    } else if ("selectAllComp".equals(op))
    {
      selectAllComp(request, response);
    }
  }






  private void selectAllComp(HttpServletRequest request, HttpServletResponse response)
  {
    JSONArray json = new JSONArray();
    List<Complete> list = this.dao.findByHQL("from Complete", null);
    for (Complete comp : list) {
      JSONObject jo = new JSONObject();
      jo.put("id", comp.getId());
      jo.put("text", comp.getDescribe());
      json.put(jo);
    }
    try {
      this.out = response.getWriter();
      this.out.print(json);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }







  private void updateComplete(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    int type = Integer.parseInt(request.getParameter("type"));
    String val = request.getParameter("val");
    Complete comp = (Complete)this.dao.findById(Integer.valueOf(id));
    if (type == 3) {
      comp.setDescribe(val);
    }
    if (type == 1) {
      comp.setCompletecondition(Integer.valueOf(Integer.parseInt(val)));
    }
    if (type == 2) {
      comp.setOtherconditions(val);
    }
    this.dao.update(comp);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("对ID[" + id + "]的任务完成条件进行了修改");
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






  private void addComplete(HttpServletRequest request, HttpServletResponse response)
  {
    Integer completecondition = Integer.valueOf(Integer.parseInt(request.getParameter("completecondition")));
    String otherconditions = request.getParameter("otherconditions");
    String describe = request.getParameter("describe");
    Complete comp = new Complete();
    comp.setCompletecondition(completecondition);
    comp.setOtherconditions(otherconditions);
    comp.setDescribe(describe);
    this.dao.save(comp);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("添加了新的任务完条件");
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






  private void completeList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));

    Integer compAdd = Integer.valueOf(0);
    Integer compUpdate = Integer.valueOf(0);

    String[] splits = comp.split(",");

    compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
    compUpdate = Integer.valueOf(Integer.parseInt(splits[1]));

    PageModel<Complete> pm = this.dao.pageList(currentPage, pageSize);


    List<Complete> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    try {
      request.setAttribute("pm", pm);
      request.setAttribute("compAdd", compAdd);
      request.setAttribute("compUpdate", compUpdate);
      request.setAttribute("comp", comp);
      request.getRequestDispatcher("web/completeList.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

