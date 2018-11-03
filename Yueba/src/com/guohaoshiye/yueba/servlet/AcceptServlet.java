package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AcceptDAO;
import com.guohaoshiye.yueba.entity_olddemo.Accept;
import com.guohaoshiye.yueba.hibernate.PageModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.json.JSONArray;




public class AcceptServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private AcceptDAO dao = new AcceptDAO();
  private String flag = "";
  private PrintWriter out = null;

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
    if ("acceptList".equals(op))
    {
      acceptList(request, response);
    } else if ("selectAllAccept".equals(op))
    {
      selectAllAccept(request, response);
    }
  }






  private void selectAllAccept(HttpServletRequest request, HttpServletResponse response)
  {
    JSONArray json = new JSONArray();
    List<Accept> list = this.dao.findByHQL("from Accept", null);
    for (Accept accept : list) {
      JSONObject jo = new JSONObject();
      jo.put("id", accept.getId());
      jo.put("text", accept.getDescribe());
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







  private void acceptList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    int currentPage = Integer.parseInt(request.getParameter("currentPage"));
    int pageSize = Integer.parseInt(request.getParameter("pageSize"));

    Integer compAdd = Integer.valueOf(0);
    Integer compDelete = Integer.valueOf(0);
    Integer compUpdate = Integer.valueOf(0);

    String[] splits = comp.split(",");

    compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
    compDelete = Integer.valueOf(Integer.parseInt(splits[1]));
    compUpdate = Integer.valueOf(Integer.parseInt(splits[2]));

    PageModel<Accept> pm = this.dao.pageList(currentPage, pageSize);


    List<Accept> list = pm.getList();
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    try {
      request.setAttribute("pm", pm);
      request.setAttribute("compAdd", compAdd);
      request.setAttribute("compDelete", compDelete);
      request.setAttribute("compUpdate", compUpdate);
      request.setAttribute("comp", comp);
      request.getRequestDispatcher("web/acceptList.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

