/*     */ package com.aiwan.servlet;
/*     */ 
/*     */ import com.aiwan.dao.GameAlllogDAO;
/*     */ import com.aiwan.dao.RobotDAO;
/*     */ import com.aiwan.dao.UsersDAO;
/*     */ import com.aiwan.entity.GameAlllog;
/*     */ import com.aiwan.entity.Robot;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameAlllogServlet
/*     */   extends HttpServlet
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  25 */   private GameAlllogDAO dao = new GameAlllogDAO();
/*  26 */   private UsersDAO udao = new UsersDAO();
/*  27 */   private RobotDAO rdao = new RobotDAO();
/*  28 */   private String flag = "";
/*  29 */   private JSONObject json = null;
/*  30 */   private PrintWriter out = null;
/*     */   
/*     */   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
/*     */   {
/*  34 */     doPost(request, response);
/*     */   }
/*     */   
/*     */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/*  40 */     response.setContentType("text/html;charset=utf-8");
/*  41 */     request.setCharacterEncoding("UTF-8");
/*  42 */     response.setCharacterEncoding("UTF-8");
/*  43 */     String op = request.getParameter("op");
/*  44 */     if ("listLog".equals(op)) {
/*  45 */       listLog(request, response);
/*  46 */     } else if ("deleteByData".equals(op)) {
/*  47 */       deleteByData(request, response);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void deleteByData(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  58 */     String str = "";
/*  59 */     Integer icon = null;
/*  60 */     this.json = new JSONObject();
/*  61 */     String begin = request.getParameter("begin");
/*  62 */     String end = request.getParameter("end");
/*  63 */     Integer index = this.dao.deleteLog(begin, end);
/*  64 */     if (index.intValue() == 0) {
/*  65 */       str = "该时间段没有可删除的日志";
/*  66 */       icon = Integer.valueOf(1);
/*     */     } else {
/*  68 */       str = "成功删除【" + index + "】条日志";
/*  69 */       icon = Integer.valueOf(1);
/*     */     }
/*  71 */     this.json.put("str", str);
/*  72 */     this.json.put("icon", icon);
/*     */     try {
/*  74 */       this.out = response.getWriter();
/*  75 */       this.out.print(this.json);
/*  76 */       this.out.flush();
/*  77 */       this.out.close();
/*     */     } catch (IOException e) {
/*  79 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void listLog(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  90 */     String comp = request.getParameter("comp");
/*  91 */     int currentPage = Integer.parseInt(request.getParameter("currentPage"));
/*  92 */     int pageSize = Integer.parseInt(request.getParameter("pageSize"));
/*  93 */     String[] param = { "roomNumber", "playtype", "gamechang", "uid", "begin", "end" };
/*  94 */     String[] paramValue = new String[param.length];
/*  95 */     for (int i = 0; i < param.length; i++) {
/*  96 */       paramValue[i] = request.getParameter(param[i]);
/*  97 */       request.setAttribute(param[i], paramValue[i]);
/*     */     }
/*  99 */     PageModel<GameAlllog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
/* 100 */     List<GameAlllog> list = pm.getList();
/* 101 */     if (list.isEmpty()) {
/* 102 */       this.flag = "1";
/* 103 */       request.setAttribute("flag", this.flag);
/*     */     } else {
/* 105 */       for (GameAlllog gameAlllog : list) {
/* 106 */         gameAlllog.setPlayer(gameAlllog.getPlayer().replace(",", "<hr style='width: 100%' />"));
/* 107 */         gameAlllog.setAlluserid(gameAlllog.getAlluserid().substring(0, gameAlllog.getAlluserid().length() - 1).replace(",", "<hr style='width: 100%' />"));
/*     */       }
/*     */     }
/* 110 */     Object ulist = this.udao.findByHQL("from Users", null);
/* 111 */     List<Robot> robots = this.rdao.findByHQL("from Robot", null);
/* 112 */     request.setAttribute("ulist", ulist);
/* 113 */     request.setAttribute("robots", robots);
/* 114 */     request.setAttribute("comp", comp);
/* 115 */     request.setAttribute("pm", pm);
/*     */     try {
/* 117 */       request.getRequestDispatcher("web/game_all_log.jsp").forward(request, response);
/*     */     }
/*     */     catch (ServletException e) {
/* 120 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 122 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\GameAlllogServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */