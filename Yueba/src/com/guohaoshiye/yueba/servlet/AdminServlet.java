 package com.guohaoshiye.yueba.servlet;

 import com.guohaoshiye.yueba.dao.AdminDAO;
 import com.guohaoshiye.yueba.dao.AdminRoleDAO;
 import com.guohaoshiye.yueba.entity_olddemo.Admin;
 import com.guohaoshiye.yueba.entity_olddemo.AdminMenu;
 import com.guohaoshiye.yueba.entity_olddemo.AdminRole;
 import com.guohaoshiye.yueba.hibernate.PageModel;
 import com.guohaoshiye.yueba.util.Util;
 import com.alibaba.fastjson.JSONArray;
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
 import java.util.Set;
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


 public class AdminServlet
   extends HttpServlet
 {
   private static final long serialVersionUID = 1L;
   private AdminDAO dao = new AdminDAO();
   private AdminRoleDAO ardao = new AdminRoleDAO();
   private String flag = "";
   private JSONObject json = null;
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
     if ("adminList".equals(op))
     {
       adminList(request, response);
     } else if ("isPwd".equals(op))
     {
       isPwd(request, response);
     } else if ("updatePwd".equals(op)) {
       updatePwd(request, response);
     } else if ("imgUpload".equals(op)) {
       imgUpload(request, response);
     } else if ("updateImg".equals(op)) {
       updateImg(request, response);
     } else if ("addAdmin".equals(op)) {
       addAdmin(request, response);
     } else if ("findByIdAdmin".equals(op)) {
       findByIdAdmin(request, response);
     } else if ("updateAdmin".equals(op)) {
       updateAdmin(request, response);
     } else if ("deleteByIdAdmin".equals(op)) {
       deleteByIdAdmin(request, response);
     }
   }







   private void deleteByIdAdmin(HttpServletRequest request, HttpServletResponse response)
   {
     int id = Integer.parseInt(request.getParameter("aid"));
     Admin admin = (Admin)this.dao.findById(Integer.valueOf(id));
     this.ardao.deleteRole(Integer.valueOf(id));
     this.dao.delete(Integer.valueOf(id));
     try {
       this.out = response.getWriter();
       this.out.print("ok");
       this.out.flush();
       this.out.close();
     } catch (IOException e) {
       e.printStackTrace();
     }
   }







   private void updateAdmin(HttpServletRequest request, HttpServletResponse response)
   {
     int id = Integer.parseInt(request.getParameter("id"));
     String opname = request.getParameter("opname");

     String nodes = request.getParameter("nodes");
     Admin admin = (Admin)this.dao.findById(Integer.valueOf(id));
     admin.setOpname(opname);
     admin.setHead("null");
     this.ardao.deleteRole(admin.getId());
     this.dao.update(admin);
     String[] split = nodes.split("\\@");
     for (String string : split) {
       String[] split2 = string.split("\\[");
       String ss = "0";
       if (split2[1].length() > 1) {
         ss = split2[1].split("\\]")[0];
       }
       AdminRole ar = new AdminRole();
       ar.setAdmin(admin);
       AdminMenu adminMenu = new AdminMenu();
       adminMenu.setId(Integer.valueOf(Integer.parseInt(split2[0])));
       ar.setAdminMenu(adminMenu);
       ar.setOp(ss);
       this.ardao.save(ar);
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






   private void findByIdAdmin(HttpServletRequest request, HttpServletResponse response)
   {
     this.json = new JSONObject();
     int id = Integer.parseInt(request.getParameter("aid"));
     Admin admin = (Admin)this.dao.findById(Integer.valueOf(id));

     this.json.put("adminname", admin.getAdminname());
     this.json.put("head", admin.getHead());
     this.json.put("id", admin.getId());
     this.json.put("opname", admin.getOpname());
     Set<AdminRole> set = admin.getAdminRoles();
     JSONArray jsons = new JSONArray();
     for (AdminRole adminRole : set) {
       JSONObject json2 = new JSONObject();
       json2.put("mid", adminRole.getAdminMenu().getId());
       if (!"0".equals(adminRole.getOp())) {
         if ("1".equals(adminRole.getOp().substring(0, 1))) {
           json2.put("op1", adminRole.getAdminMenu().getId() + "01");
         } else {
           json2.put("op1", "10000");
         }
         if ("1".equals(adminRole.getOp().substring(2, 3))) {
           json2.put("op2", adminRole.getAdminMenu().getId() + "02");
         } else {
           json2.put("op2", "10000");
         }
         if ("1".equals(adminRole.getOp().substring(4, 5))) {
           json2.put("op3", adminRole.getAdminMenu().getId() + "03");
         } else {
           json2.put("op3", "10000");
         }
       }
       jsons.add(json2);
     }
     this.json.put("role", jsons);
     try {
       this.out = response.getWriter();
       this.out.print(this.json);
       this.out.flush();
       this.out.close();
     } catch (IOException e) {
       e.printStackTrace();
     }
   }






   private void addAdmin(HttpServletRequest request, HttpServletResponse response)
   {
     String flg = "1";
     String aname = request.getParameter("aname");
     String pwd = request.getParameter("pwd");
     String opname = request.getParameter("opname");

     String nodes = request.getParameter("nodes");
     List<Admin> list = this.dao.findByHQL("from Admin where adminname=?", new Object[] { aname });
     if (list.size() > 0) {
       flg = "0";
     } else {
       Timestamp d = new Timestamp(System.currentTimeMillis());
       Admin admin = new Admin();
       admin.setAdminname(aname);
       admin.setPassword(Util.Md5(pwd));
       admin.setHead("null");
       admin.setOpname(opname);
       admin.setCreatetime(d);
       this.dao.save(admin);
       List<Admin> admin2 = this.dao.findByHQL("from Admin where adminname=?", new Object[] { aname });

       String[] split = nodes.split("\\@");
       for (String string : split) {
         String[] split2 = string.split("\\[");
         String ss = "0";
         if (split2[1].length() > 1) {
           ss = split2[1].split("\\]")[0];
         }
         AdminRole ar = new AdminRole();
         ar.setAdmin((Admin)admin2.get(0));
         AdminMenu adminMenu = new AdminMenu();
         adminMenu.setId(Integer.valueOf(Integer.parseInt(split2[0])));
         ar.setAdminMenu(adminMenu);
         ar.setOp(ss);
         this.ardao.save(ar);
       }
     }
     try {
       this.out = response.getWriter();
       this.out.print(flg);
       this.out.flush();
       this.out.close();
     } catch (IOException e) {
       e.printStackTrace();
     }
   }







   private void updateImg(HttpServletRequest request, HttpServletResponse response)
   {
     String url = request.getParameter("url");
     HttpSession session = request.getSession();
     Admin attribute = (Admin)session.getAttribute("admin");
     Admin admin = (Admin)this.dao.findById(attribute.getId());
     admin.setHead(url);
     this.dao.update(admin);
     session.setAttribute("admin", admin);
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






   private void updatePwd(HttpServletRequest request, HttpServletResponse response)
   {
     String pwd = request.getParameter("pwd");
     HttpSession session = request.getSession();

     Admin attribute = null;
     String ipClients; if ((session != null) || (session.getAttribute("mapAdmin") != null)) {
       Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
       ipClients = Util.getIpAddress(request);
       for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
         if ((ipClients.equals(entry.getKey())) &&
           (entry.getValue() != null)) {
           attribute = (Admin)entry.getValue();
         }
       }
     }

     Admin admin = (Admin)this.dao.findById(attribute.getId());
     admin.setPassword(Util.Md5(pwd));
     this.dao.update(admin);
     try {
       this.out = response.getWriter();
       this.out.print("ok");
       this.out.flush();
       this.out.close();
     } catch (IOException e) {
       e.printStackTrace();
     }
   }






   private void isPwd(HttpServletRequest request, HttpServletResponse response)
   {
     String str = "";
     String pwd = Util.Md5(request.getParameter("pwd"));
     HttpSession session = request.getSession();
     Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
     String ipClients = Util.getIpAddress(request);
     for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
       if (ipClients.equals(entry.getKey())) {
         if (((Admin)entry.getValue()).getPassword().equals(pwd)) {
           str = "ok";
         } else {
           str = "no";
         }
       }
     }
     try {
       this.out = response.getWriter();
       this.out.print(str);
       this.out.flush();
       this.out.close();
     } catch (IOException e) {
       e.printStackTrace();
     }
   }







   private void adminList(HttpServletRequest request, HttpServletResponse response)
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

     PageModel<Admin> pm = this.dao.pageList(currentPage, pageSize);
     List<Admin> list = pm.getList();
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
       request.getRequestDispatcher("web/adminList.jsp").forward(request, response);
     } catch (Exception e) {
       e.printStackTrace();
     }
   }
 }


/* Location:              C:\Users\liufe\Desktop\yueba_admin\WEB-INF\classes\!\comold\aiwan\servlet\AdminServlet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */