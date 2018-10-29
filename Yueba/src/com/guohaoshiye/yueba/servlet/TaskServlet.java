/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.dao.TaskDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.entity.Task;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import com.aiwan.util.Util;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import net.sf.json.JSONArray;
/*     */ import net.sf.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  34 */   private String flag = "";
/*  35 */   private JSONObject json = null;
/*  36 */   private PrintWriter out = null;
/*  37 */   private TaskDAO dao = new TaskDAO();
/*  38 */   private AdminopLogDAO apdao = new AdminopLogDAO();
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  42 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  47 */     response.setContentType("text/html;charset=utf-8");
/*  48 */     request.setCharacterEncoding("UTF-8");
/*  49 */     response.setCharacterEncoding("UTF-8");
/*  50 */     String op = request.getParameter("op");
/*  51 */     if ("taskList".equals(op))
/*     */     {
/*  53 */       taskList(request, response);
/*  54 */     } else if ("addTask".equals(op))
/*     */     {
/*  56 */       addTask(request, response);
/*  57 */     } else if ("updateStatus".equals(op))
/*     */     {
/*  59 */       updateStatus(request, response);
/*  60 */     } else if ("findById".equals(op))
/*     */     {
/*  62 */       findByIdTask(request, response);
/*  63 */     } else if ("updateTask".equals(op)) {
/*  64 */       updateTask(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateTask(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  76 */     Integer id = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
/*  77 */     Integer acceptid = Integer.valueOf(Integer.parseInt(request.getParameter("acceptid")));
/*  78 */     Integer completeid = Integer.valueOf(Integer.parseInt(request.getParameter("completeid")));
/*  79 */     Integer type = Integer.valueOf(Integer.parseInt(request.getParameter("type")));
/*  80 */     String describe = request.getParameter("describe");
/*  81 */     String reward = request.getParameter("reward");
/*  82 */     Task t = (Task)this.dao.findById(id);
/*  83 */     t.setAcceptid(acceptid);
/*  84 */     t.setCompleteid(completeid);
/*  85 */     t.setDescribe(describe);
/*  86 */     t.setReward(reward);
/*  87 */     t.setType(type);
/*  88 */     this.dao.update(t);
/*     */     
/*  90 */     String ipClients = Util.getIpAddress(request);
/*  91 */     HttpSession session = request.getSession();
/*  92 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/*  93 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/*  94 */       if (ipClients.equals(entry.getKey())) {
/*  95 */         Admin value = (Admin)entry.getValue();
/*  96 */         AdminopLog l = new AdminopLog();
/*  97 */         l.setAid(value.getId());
/*  98 */         l.setDescription("对ID[" + id + "]的任务进行了修改");
/*  99 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 100 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 104 */       this.out = response.getWriter();
/* 105 */       this.out.print("ok");
/* 106 */       this.out.flush();
/* 107 */       this.out.close();
/*     */     } catch (IOException e) {
/* 109 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void findByIdTask(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 120 */     int id = Integer.parseInt(request.getParameter("id"));
/* 121 */     Task task = (Task)this.dao.findById(Integer.valueOf(id));
/* 122 */     JSONArray json1 = JSONArray.fromObject(task);
/*     */     try {
/* 124 */       this.out = response.getWriter();
/* 125 */       this.out.print(json1);
/* 126 */       this.out.flush();
/* 127 */       this.out.close();
/*     */     } catch (IOException e) {
/* 129 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateStatus(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 140 */     int id = Integer.parseInt(request.getParameter("id"));
/* 141 */     Integer status = Integer.valueOf(Integer.parseInt(request.getParameter("status")));
/* 142 */     String[] names = { "state" };
/* 143 */     Object[] values = { status };
/* 144 */     this.dao.partUpdate(id, names, values);
/*     */     
/*     */ 
/* 147 */     String ipClients = Util.getIpAddress(request);
/* 148 */     HttpSession session = request.getSession();
/* 149 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 150 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 151 */       if (ipClients.equals(entry.getKey())) {
/* 152 */         Admin value = (Admin)entry.getValue();
/* 153 */         AdminopLog l = new AdminopLog();
/* 154 */         l.setAid(value.getId());
/* 155 */         l.setDescription("修改了ID[" + id + "]任务的状态");
/* 156 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 157 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 161 */       this.out = response.getWriter();
/* 162 */       this.out.print("ok");
/* 163 */       this.out.flush();
/* 164 */       this.out.close();
/*     */     } catch (IOException e) {
/* 166 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTask(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 173 */     Integer acceptid = Integer.valueOf(Integer.parseInt(request.getParameter("acceptid")));
/* 174 */     Integer completeid = Integer.valueOf(Integer.parseInt(request.getParameter("completeid")));
/* 175 */     Integer type = Integer.valueOf(Integer.parseInt(request.getParameter("type")));
/* 176 */     String describe = request.getParameter("describe");
/* 177 */     String reward = request.getParameter("reward");
/* 178 */     Task t = new Task();
/* 179 */     t.setAcceptid(acceptid);
/* 180 */     t.setCompleteid(completeid);
/* 181 */     t.setDescribe(describe);
/* 182 */     t.setReward(reward);
/* 183 */     t.setType(type);
/* 184 */     t.setState(Integer.valueOf(1));
/* 185 */     this.dao.save(t);
/*     */     
/* 187 */     String ipClients = Util.getIpAddress(request);
/* 188 */     HttpSession session = request.getSession();
/* 189 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 190 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 191 */       if (ipClients.equals(entry.getKey())) {
/* 192 */         Admin value = (Admin)entry.getValue();
/* 193 */         AdminopLog l = new AdminopLog();
/* 194 */         l.setAid(value.getId());
/* 195 */         l.setDescription("添加了一个新任务");
/* 196 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 197 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 201 */       this.out = response.getWriter();
/* 202 */       this.out.print("ok");
/* 203 */       this.out.flush();
/* 204 */       this.out.close();
/*     */     } catch (IOException e) {
/* 206 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void taskList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 217 */     String comp = request.getParameter("comp");
/* 218 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 219 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/*     */     
/* 221 */     Integer compAdd = Integer.valueOf(0);
/* 222 */     Integer compUpdate = Integer.valueOf(0);
/*     */     
/* 224 */     String[] splits = comp.split(",");
/*     */     
/* 226 */     compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
/* 227 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[1]));
/*     */     
/* 229 */     PageModel<Task> pm = this.dao.pageList(currentPage, pageSize);
/*     */     
/*     */ 
/* 232 */     List<Task> list = pm.getList();
/* 233 */     if (list.isEmpty()) {
/* 234 */       this.flag = "1";
/* 235 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     try {
/* 238 */       request.setAttribute("pm", pm);
/* 239 */       request.setAttribute("compAdd", compAdd);
/* 240 */       request.setAttribute("compUpdate", compUpdate);
/* 241 */       request.setAttribute("comp", comp);
/* 242 */       request.getRequestDispatcher("web/taskList.jsp").forward(request, response);
/*     */     } catch (Exception e) {
/* 244 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\TaskServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */