package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.dao.HallslidingdrawingDAO;
import com.guohaoshiye.yueba.dao.ParameterDAO;
import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.entity_olddemo.AdminopLog;
import com.guohaoshiye.yueba.entity_olddemo.Hallslidingdrawing;
import com.guohaoshiye.yueba.entity_olddemo.Parameter;
import com.guohaoshiye.yueba.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;






public class HallslidingdrawingServlet
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private String flag = "";
  private JSONObject json = null;
  private PrintWriter out = null;
  private HallslidingdrawingDAO dao = new HallslidingdrawingDAO();
  private ParameterDAO pdao = new ParameterDAO();
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
    if ("hallslidingdrawingList".equals(op)) {
      hallslidingdrawingList(request, response);
    } else if ("addImgUpload".equals(op)) {
      addImgUpload(request, response);
    } else if ("addImg".equals(op)) {
      addImg(request, response);
    } else if ("updateImg".equals(op)) {
      updateImg(request, response);
    } else if ("deleteImg".equals(op)) {
      deleteImg(request, response);
    }
  }






  private void deleteImg(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    this.dao.delete(Integer.valueOf(id));

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("删除了一张公告封面");
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


  private void updateImg(HttpServletRequest request, HttpServletResponse response)
  {
    int id = Integer.parseInt(request.getParameter("id"));
    String url = request.getParameter("url");
    Hallslidingdrawing hallslidingdrawing = (Hallslidingdrawing)this.dao.findById(Integer.valueOf(id));
    hallslidingdrawing.setUrl(url);
    this.dao.update(hallslidingdrawing);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("修改了一张公告封面");
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


  private void addImg(HttpServletRequest request, HttpServletResponse response)
  {
    String url = request.getParameter("url");
    Timestamp d = new Timestamp(System.currentTimeMillis());
    Hallslidingdrawing hallslidingdrawing = new Hallslidingdrawing();
    hallslidingdrawing.setUrl(url);
    hallslidingdrawing.setCreatetime(d);
    hallslidingdrawing.setState(Integer.valueOf(0));
    this.dao.save(hallslidingdrawing);

    String ipClients = Util.getIpAddress(request);
    HttpSession session = request.getSession();
    Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
    for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
      if (ipClients.equals(entry.getKey())) {
        Admin value = (Admin)entry.getValue();
        AdminopLog l = new AdminopLog();
        l.setAid(value.getId());
        l.setDescription("添加了一张公告封面");
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






  private void addImgUpload(HttpServletRequest request, HttpServletResponse response)
  {
    this.json = new JSONObject();
    String property = request.getSession().getServletContext().getRealPath("");
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
    String imageupdatename = sdf.format(date);
    Integer width = Integer.valueOf(Integer.parseInt(request.getParameter("width")));
    Integer height = Integer.valueOf(Integer.parseInt(request.getParameter("height")));

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
        else
        {
          String fileName = item.getName();
          long sizeInBytes = item.getSize();
          InputStream in = item.getInputStream();
//          byte[] buffer = new byte['Ѐ'];
          byte[] buffer = new byte[1024];
          int len;
          fileName = property + "/imgLoad/temp/" + imageupdatename + ".png";
          OutputStream out = new FileOutputStream(fileName);
          while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
          }
          out.close();
          in.close();
          File file = new File(fileName);
          int imgWidth = Util.getImgWidth(file);
          int imgHeight = Util.getImgHeight(file);


          if ((imgWidth == width.intValue()) && (imgHeight == height.intValue())) {
            String fileName2 = property + "/imgLoad/" + imageupdatename + ".png";
            File file2 = new File(fileName2);

            file.deleteOnExit();
            try
            {
              file2.createNewFile();
            } catch (IOException e) {
              e.printStackTrace();
            }
            Util.cutFile(file, file2);
            String contextPath = request.getContextPath();
            Parameter parameter = (Parameter)this.pdao.findByHQL("from Parameter where name = ?", new Object[] { "domainName" }).get(0);
            String urlName = parameter.getValue() + "" + contextPath + "/imgLoad/" + imageupdatename + ".png";
            this.json.put("icon", "1");
            this.json.put("url", urlName);
          } else {
            this.json.put("icon", "0");
          }
//          File file1 = new File(fileName);
//          File file2 = file1.delete();
        }
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    } catch (FileUploadException e) {
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


  private void hallslidingdrawingList(HttpServletRequest request, HttpServletResponse response)
  {
    String comp = request.getParameter("comp");
    Integer compAdd = Integer.valueOf(0);
    Integer compDelete = Integer.valueOf(0);
    Integer compUpdate = Integer.valueOf(0);
    String[] splits = comp.split(",");
    compAdd = Integer.valueOf(Integer.parseInt(splits[0]));
    compDelete = Integer.valueOf(Integer.parseInt(splits[1]));
    compUpdate = Integer.valueOf(Integer.parseInt(splits[2]));
    List<Hallslidingdrawing> list = this.dao.findByHQL("from Hallslidingdrawing", null);
    if (list.isEmpty()) {
      this.flag = "1";
      request.setAttribute("flag", this.flag);
    }
    try {
      request.setAttribute("list", list);
      request.setAttribute("compAdd", compAdd);
      request.setAttribute("compDelete", compDelete);
      request.setAttribute("compUpdate", compUpdate);
      request.setAttribute("comp", comp);
      request.getRequestDispatcher("web/hallslidingdrawingList.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

