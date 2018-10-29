/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.AcceptDAO;
/*     */ import com.aiwan.entity.Accept;
/*     */ import com.aiwan.hibernate.PageModel;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.List;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.sf.json.JSONObject;
/*     */ import org.json.JSONArray;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AcceptServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  24 */   private AcceptDAO dao = new AcceptDAO();
/*  25 */   private String flag = "";
/*  26 */   private PrintWriter out = null;
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  30 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  35 */     response.setContentType("text/html;charset=utf-8");
/*  36 */     request.setCharacterEncoding("UTF-8");
/*  37 */     response.setCharacterEncoding("UTF-8");
/*  38 */     String op = request.getParameter("op");
/*  39 */     if ("acceptList".equals(op))
/*     */     {
/*  41 */       acceptList(request, response);
/*  42 */     } else if ("selectAllAccept".equals(op))
/*     */     {
/*  44 */       selectAllAccept(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void selectAllAccept(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  55 */     JSONArray json = new JSONArray();
/*  56 */     List<Accept> list = this.dao.findByHQL("from Accept", null);
/*  57 */     for (Accept accept : list) {
/*  58 */       JSONObject jo = new JSONObject();
/*  59 */       jo.put("id", accept.getId());
/*  60 */       jo.put("text", accept.getDescribe());
/*  61 */       json.put(jo);
/*     */     }
/*     */     try {
/*  64 */       this.out = response.getWriter();
/*  65 */       this.out.print(json);
/*  66 */       this.out.flush();
/*  67 */       this.out.close();
/*     */     } catch (IOException e) {
/*  69 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void acceptList(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  81 */     String comp = request.getParameter("comp");
/*  82 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/*  83 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/*     */     
/*  85 */     Integer compAdd = Integer.valueOf(0);
/*  86 */     Integer compDelete = Integer.valueOf(0);
/*  87 */     Integer compUpdate = Integer.valueOf(0);
/*     */     
/*  89 */     String[] splits = comp.split(",");
/*     */     
/*  91 */     compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
/*  92 */     compDelete = Integer.valueOf(Integer.parseInt(splits[1]));
/*  93 */     compUpdate = Integer.valueOf(Integer.parseInt(splits[2]));
/*     */     
/*  95 */     PageModel<Accept> pm = this.dao.pageList(currentPage, pageSize);
/*     */     
/*     */ 
/*  98 */     List<Accept> list = pm.getList();
/*  99 */     if (list.isEmpty()) {
/* 100 */       this.flag = "1";
/* 101 */       request.setAttribute("flag", this.flag);
/*     */     }
/*     */     try {
/* 104 */       request.setAttribute("pm", pm);
/* 105 */       request.setAttribute("compAdd", compAdd);
/* 106 */       request.setAttribute("compDelete", compDelete);
/* 107 */       request.setAttribute("compUpdate", compUpdate);
/* 108 */       request.setAttribute("comp", comp);
/* 109 */       request.getRequestDispatcher("web/acceptList.jsp").forward(request, response);
/*     */     } catch (Exception e) {
/* 111 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\AcceptServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */