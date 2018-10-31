package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.GameAlllogDAO;
import com.guohaoshiye.yueba.dao.RobotDAO;
import com.guohaoshiye.yueba.dao.UsersDAO;
import com.guohaoshiye.yueba.entity.GameAlllog;
import com.guohaoshiye.yueba.entity.Robot;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;



public class GameAlllogServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private GameAlllogDAO dao = new GameAlllogDAO();
  private UsersDAO udao = new UsersDAO();
  private RobotDAO rdao = new RobotDAO();
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    String op = request.getParameter("op");
    if ("listLog".equals(op)) {
      listLog(request, response);
    } else if ("deleteByData".equals(op)) {
      deleteByData(request, response);
    }
  }






  private void deleteByData(HttpServletRequest request, HttpServletResponse response)
  {
    String str = "";
    Integer icon = null;
    this.json = new JSONObject();
    String begin = request.getParameter("begin");
    String end = request.getParameter("end");
    Integer index = this.dao.deleteLog(begin, end);
    if (index.intValue() == 0) {
      str = "该时间段没有可删除的日志";
      icon = Integer.valueOf(1);
    } else {
      str = "成功删除【" + index + "】条日志";
      icon = Integer.valueOf(1);
    }
    this.json.put("str", str);
    this.json.put("icon", icon);
    try {
      this.out = response.getWriter();
      this.out.print(this.json);
      this.out.flush();
      this.out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }






  private void listLog(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
    String[] param = { "roomNumber", "playtype", "gamechang", "uid", "begin", "end" };
    String[] paramValue = new String[param.length];
    for (int i = 0; i < param.length; i++) {
      paramValue[i] = request.getParameter(param[i]);
      request.setAttribute(param[i], paramValue[i]);
    }
    PageModel<GameAlllog> pm = this.dao.sqlLog(currentPage, pageSize, param, paramValue);
    List<GameAlllog> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    } else {
      for (GameAlllog gameAlllog : list) {
        gameAlllog.setPlayer(gameAlllog.getPlayer().replace(",", "<hr style='width: 100%' />"));
        gameAlllog.setAlluserid(gameAlllog.getAlluserid().substring(0, gameAlllog.getAlluserid().length() - 1).replace(",", "<hr style='width: 100%' />"));
      }
    }
    Object ulist = this.udao.findByHQL("from Users", null);
    List<Robot> robots = this.rdao.findByHQL("from Robot", null);
    request.setAttribute("ulist", ulist);
    request.setAttribute("robots", robots);
    request.setAttribute("comp", comp);
    request.setAttribute("pm", pm);
    try {
      request.getRequestDispatcher("web/game_all_log.jsp").forward(request, response);
    }
    catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

