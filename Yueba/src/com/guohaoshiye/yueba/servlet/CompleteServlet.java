/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AdminopLogDAO;
/*     */ import com.aiwan.dao.CompleteDAO;
/*     */ import com.aiwan.entity.Admin;
/*     */ import com.aiwan.entity.AdminopLog;
/*     */ import com.aiwan.entity.Complete;
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
/*     */ import net.sf.json.JSONObject;
/*     */ import org.json.JSONArray;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompleteServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  34 */   private CompleteDAO dao = new CompleteDAO();
/*  35 */   private String flag = "";
/*  36 */   private JSONObject json = null;
/*  37 */   private PrintWriter out = null;
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
/*  51 */     if ("completeList".equals(op))
/*     */     {
/*  53 */       completeList(request, response);
/*  54 */     } else if ("addComplete".equals(op))
/*     */     {
/*  56 */       addComplete(request, response);
/*  57 */     } else if ("updateComplete".equals(op))
/*     */     {
/*  59 */       updateComplete(request, response);
/*  60 */     } else if ("selectAllComp".equals(op))
/*     */     {
/*  62 */       selectAllComp(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void selectAllComp(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  73 */     JSONArray json = new JSONArray();
/*  74 */     List<Complete> list = this.dao.findByHQL("from Complete", null);
/*  75 */     for (Complete comp : list) {
/*  76 */       JSONObject jo = new JSONObject();
/*  77 */       jo.put("id", comp.getId());
/*  78 */       jo.put("text", comp.getDescribe());
/*  79 */       json.put(jo);
/*     */     }
/*     */     try {
/*  82 */       this.out = response.getWriter();
/*  83 */       this.out.print(json);
/*  84 */       this.out.flush();
/*  85 */       this.out.close();
/*     */     } catch (IOException e) {
/*  87 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void updateComplete(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  99 */     int id = Integer.parseInt(request.getParameter("id"));
/* 100 */     int type = Integer.parseInt(request.getParameter("type"));
/* 101 */     String val = request.getParameter("val");
/* 102 */     Complete comp = (Complete)this.dao.findById(Integer.valueOf(id));
/* 103 */     if (type == 3) {
/* 104 */       comp.setDescribe(val);
/*     */     }
/* 106 */     if (type == 1) {
/* 107 */       comp.setCompletecondition(Integer.valueOf(Integer.parseInt(val)));
/*     */     }
/* 109 */     if (type == 2) {
/* 110 */       comp.setOtherconditions(val);
/*     */     }
/* 112 */     this.dao.update(comp);
/*     */     
/* 114 */     String ipClients = Util.getIpAddress(request);
/* 115 */     HttpSession session = request.getSession();
/* 116 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 117 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 118 */       if (ipClients.equals(entry.getKey())) {
/* 119 */         Admin value = (Admin)entry.getValue();
/* 120 */         AdminopLog l = new AdminopLog();
/* 121 */         l.setAid(value.getId());
/* 122 */         l.setDescription("对ID[" + id + "]的任务完成条件进行了修改");
/* 123 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 124 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 128 */       this.out = response.getWriter();
/* 129 */       this.out.print("ok");
/* 130 */       this.out.flush();
/* 131 */       this.out.close();
/*     */     } catch (IOException e) {
/* 133 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addComplete(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 144 */     Integer completecondition = Integer.valueOf(Integer.parseInt(request.getParameter("completecondition")));
/* 145 */     String otherconditions = request.getParameter("otherconditions");
/* 146 */     String describe = request.getParameter("describe");
/* 147 */     Complete comp = new Complete();
/* 148 */     comp.setCompletecondition(completecondition);
/* 149 */     comp.setOtherconditions(otherconditions);
/* 150 */     comp.setDescribe(describe);
/* 151 */     this.dao.save(comp);
/*     */     
/* 153 */     String ipClients = Util.getIpAddress(request);
/* 154 */     HttpSession session = request.getSession();
/* 155 */     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
/* 156 */     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
/* 157 */       if (ipClients.equals(entry.getKey())) {
/* 158 */         Admin value = (Admin)entry.getValue();
/* 159 */         AdminopLog l = new AdminopLog();
/* 160 */         l.setAid(value.getId());
/* 161 */         l.setDescription("添加了新的任务完条件");
/* 162 */         l.setCreateTime(new Timestamp(System.currentTimeMillis()));
/* 163 */         this.apdao.save(l);
/*     */       }
/*     */     }
/*     */     try {
/* 167 */       this.out = response.getWriter();
/* 168 */       this.out.print("ok");
/* 169 */       this.out.flush();
/* 170 */       this.out.close();
/*     */     } catch (IOException e) {
/* 172 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void completeList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 183 */     String comp = request.getParameter("comp");
/* 184 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/* 185 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/*     */     
/* 187 */     Integer compAdd = Integer.valueOf(0);
/* 188 */     Integer compUpdate = Integer.valueOf(0);
/*     */     
/* 190 */     String[] splits = comp.split(",");
/*     */     
/* 192 */     compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
/* 193 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[1]));
/*     */     
/* 195 */     PageModel<Complete> pm = this.dao.pageList(currentPage, pageSize);
/*     */     
/*     */ 
/* 198 */     List<Complete> list = pm.getList();
/* 199 */     if (list.isEmpty()) {
/* 200 */       this.flag = "1";
/* 201 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     try {
/* 204 */       request.setAttribute("pm", pm);
/* 205 */       request.setAttribute("compAdd", compAdd);
/* 206 */       request.setAttribute("compUpdate", compUpdate);
/* 207 */       request.setAttribute("comp", comp);
/* 208 */       request.getRequestDispatcher("web/completeList.jsp").forward(request, response);
/*     */     } catch (Exception e) {
/* 210 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\CompleteServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */