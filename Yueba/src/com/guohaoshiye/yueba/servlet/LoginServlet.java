package com.guohaoshiye.yueba.servlet;

import com.guohaoshiye.yueba.dao.AdminDAO;
import com.guohaoshiye.yueba.dao.AdminMenuDAO;
import com.guohaoshiye.yueba.dao.AdminRoleDAO;
import com.guohaoshiye.yueba.dao.AdminopLogDAO;
import com.guohaoshiye.yueba.entity_olddemo.Admin;
import com.guohaoshiye.yueba.entity_olddemo.AdminMenu;
import com.guohaoshiye.yueba.entity_olddemo.AdminRole;
import com.guohaoshiye.yueba.entity_olddemo.AdminopLog;
import com.guohaoshiye.yueba.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@Controller
//@RequestMapping("login")
public class LoginServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private AdminDAO dao = new AdminDAO();
  private AdminMenuDAO amdao = new AdminMenuDAO();
  private AdminRoleDAO ardao = new AdminRoleDAO();
  private AdminopLogDAO apdao = new AdminopLogDAO();

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    String type = request.getParameter("type");
    HttpSession session = request.getSession();
    if (type == null)
    {
      session.invalidate();

      request.getRequestDispatcher("login.jsp").forward(request, response);
      return;
    }

    if ("loginOut".equals(type)) {
      Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
      String ipClients = Util.getIpAddress(request);
      for (Map.Entry<String, Admin> entry : mapAdmin.entrySet()) {
        if (ipClients.equals(entry.getKey())) {
          entry.setValue(null);
        }
      }
      session.setAttribute("mapAdmin", mapAdmin);
      response.sendRedirect("login.jsp");
      return;
    }
    String yzm = request.getParameter("code");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String zyzm = (String)session.getAttribute("zyzm");
    if ((zyzm != null) && (!zyzm.equalsIgnoreCase(yzm))) {
      request.setAttribute("prompt", "验证码错误");
      try {
        request.getRequestDispatcher("login.jsp").forward(request, response);
      }
      catch (ServletException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      String hql = "from Admin where adminname=? and password=?";
      if ((username == null) || (password == null)) {
        response.sendRedirect("login.jsp");
        return;
      }
      List<Admin> findByHQL = this.dao.findByHQL(hql, new Object[] { username, Util.Md5(password) });
      if (findByHQL.size() > 0) {
        Admin admin = findByHQL.get(0);

        Set<AdminRole> adminRoles = admin.getAdminRoles();
        adminRoles = Util.sortByValue(adminRoles);
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        for (AdminRole adminRole : adminRoles)
          if (adminRole.getAdminMenu().getRank().intValue() == 0) {
            sb.append("{");
            sb.append("'title':'" + adminRole.getAdminMenu().getTitle() + "',");
            sb.append("'icon':'" + adminRole.getAdminMenu().getIcon() + "',");
            sb.append("'href':'" + adminRole.getAdminMenu().getUrl() + "&comp=" + adminRole.getOp() + "',");
            sb.append("'spread':" + adminRole.getAdminMenu().getSpread() + ",");
            List<AdminMenu> adminMenulist = this.amdao.findByHQL("from AdminMenu where rank=?", new Object[] { adminRole.getAdminMenu().getId() });
            if (adminMenulist.size() > 0) {
              sb.append("'children':[");
            }

            AdminRole adminRole2;
            for (Iterator localIterator3 = adminRoles.iterator(); localIterator3.hasNext();) {
              adminRole2 = (AdminRole)localIterator3.next();
              if (adminRole2.getAdminMenu().getRank() == adminRole.getAdminMenu().getId()) {
                sb.append("{");
                sb.append("'title':'" + adminRole2.getAdminMenu().getTitle() + "',");
                sb.append("'icon':'" + adminRole2.getAdminMenu().getIcon() + "',");
                sb.append("'href':'" + adminRole2.getAdminMenu().getUrl() + "&comp=" + adminRole2.getOp() + "',");
                sb.append("'spread':" + adminRole2.getAdminMenu().getSpread() + ",");
                List<AdminMenu> adminMenulist2 = this.amdao.findByHQL("from AdminMenu where rank=?", new Object[] { adminRole2.getAdminMenu().getId() });
                if (adminMenulist2.size() > 0) {
                  sb.append("'children':[");
                }

                for (AdminRole adminRole3 : adminRoles) {
                  if (adminRole3.getAdminMenu().getRank() == adminRole2.getAdminMenu().getId()) {
                    sb.append("{");
                    sb.append("'title':'" + adminRole3.getAdminMenu().getTitle() + "',");
                    sb.append("'icon':'" + adminRole3.getAdminMenu().getIcon() + "',");
                    sb.append("'href':'" + adminRole3.getAdminMenu().getUrl() + "&comp=" + adminRole3.getOp() + "',");
                    sb.append("'spread':" + adminRole3.getAdminMenu().getSpread());
                    sb.append("},");
                  }
                }
                sb = new StringBuffer(sb.substring(0, sb.length() - 1));
                if (adminMenulist2.size() > 0) {
                  sb.append("]");
                }
                sb.append("},");
              }
            }
            sb = new StringBuffer(sb.substring(0, sb.length() - 1));
            if (adminMenulist.size() > 0) {
              sb.append("]");
            }
            sb.append("},");
          }
//        AdminRole adminRole2;
        sb = new StringBuffer(sb.substring(0, sb.length() - 1));
        sb.append("]");
        String s2 = new String(sb);
        s2 = s2.replace('\'', '"');
        String property = request.getSession().getServletContext().getRealPath("");
        property = property + "/json/navs.json";
        boolean b = Util.writeFile(property, s2);
        Set<AdminRole> set = admin.getAdminRoles();
        for (AdminRole adminRole : set) {
          if (adminRole.getAdminMenu().getId().intValue() == 1) {
//            op = adminRole.getOp();
            String op = adminRole.getOp();
            String[] split = (op).split(",");
            admin.setAdminHomeOp1(Integer.valueOf(Integer.parseInt(split[0])));
            admin.setAdminHomeOp2(Integer.valueOf(Integer.parseInt(split[1])));
          }
        }
        Object op;
        String ipClients = Util.getIpAddress(request);
        if ((session != null) && (session.getAttribute("mapAdmin") != null)) {
          Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
          for (op = mapAdmin.entrySet().iterator(); ((Iterator)op).hasNext();) { Map.Entry<String, Admin> entry = (Map.Entry)((Iterator)op).next();
            if (ipClients.equals(entry.getKey())) {
              entry.setValue(admin);
            }
          }
          session.setAttribute("mapAdmin", mapAdmin);
        } else {
          Map<String, Admin> mapAdmin = new HashMap();
          mapAdmin.put(ipClients, admin);
          session.setAttribute("mapAdmin", mapAdmin);
        }
        if (b) {
          Map<String, Admin> mapAdmin = (Map)session.getAttribute("mapAdmin");
          for (op = mapAdmin.entrySet().iterator(); ((Iterator)op).hasNext();) { Map.Entry<String, Admin> entry = (Map.Entry)((Iterator)op).next();
            if (ipClients.equals(entry.getKey())) {
              Admin value = (Admin)entry.getValue();
              AdminopLog l = new AdminopLog();
              l.setAid(value.getId());
              l.setDescription("登录后台管理系统.");
              l.setCreateTime(new Timestamp(System.currentTimeMillis()));
              this.apdao.save(l);
            }
          }
          try {
            request.getRequestDispatcher("web/index-proto.jsp").forward(request, response);
          }
          catch (ServletException e) {
            e.printStackTrace();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      } else {
        request.setAttribute("prompt", "用户名或密码错误");
        try {
          request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        catch (ServletException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

